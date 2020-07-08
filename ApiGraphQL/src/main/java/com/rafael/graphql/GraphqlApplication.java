package com.rafael.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.rafael.graphql.entity"})
public class GraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlApplication.class, args);
    }

}
