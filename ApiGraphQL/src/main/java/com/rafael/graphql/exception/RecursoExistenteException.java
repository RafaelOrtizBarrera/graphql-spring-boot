package com.rafael.graphql.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class RecursoExistenteException extends Exception implements GraphQLError {

    public RecursoExistenteException(String message) {
        super(message);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }
}
