package com.rafael.graphql.exception;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.execution.ExecutionPath;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GraphQLExceptionHandler implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        return list.stream().map(this::getNested).collect(Collectors.toList());
    }

    private GraphQLError getNested(GraphQLError error) {
        if (error instanceof ExceptionWhileDataFetching) {
            return new SanitizedError(ExecutionPath.fromList(error.getPath()), ((ExceptionWhileDataFetching) error).getException(), null);
        }
        return error;
    }
}