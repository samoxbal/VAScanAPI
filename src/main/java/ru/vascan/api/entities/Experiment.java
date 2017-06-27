package ru.vascan.api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;

@Document(collection = "experiments")
@GraphQLName("experiment")
public class Experiment {

    @Id
    public String id;

    private String user;
    private String name;
    private String description;
    private String startDate;
    private String endDate;

    @GraphQLField
    public String getUser() {
        return this.user;
    }

    @GraphQLField
    public String getName() {
        return this.name;
    }

    @GraphQLField
    public String getDescription() {
        return this.startDate;
    }

    @GraphQLField
    public String getStartDate() {
        return this.startDate;
    }

    @GraphQLField
    public String getEndDate() {
        return this.endDate;
    }
}
