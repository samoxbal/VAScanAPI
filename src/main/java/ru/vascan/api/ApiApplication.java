package ru.vascan.api;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.coxautodev.graphql.tools.SchemaParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import graphql.execution.ExecutionStrategy;
import graphql.execution.SimpleExecutionStrategy;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;
import ru.vascan.api.entities.Experiment;

import java.util.List;

@SpringBootApplication
public class ApiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApiApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

    @Autowired
    private List<GraphQLResolver<?>> resolvers;

	@Bean
    public GraphQLSchema graphQLSchema() {
	    return SchemaParser
                .newParser()
                .file("Schema.graphqls")
                .resolvers(resolvers)
                .dictionary(Experiment.class)
                .build()
                .makeExecutableSchema();
    }

    @Bean
    ExecutionStrategy executionStrategy() {
        return new SimpleExecutionStrategy();
    }

    @Bean
    ServletRegistrationBean graphQLServletRegistrationBean(GraphQLSchema schema, ExecutionStrategy executionStrategy) {
        return new ServletRegistrationBean(new SimpleGraphQLServlet(schema, executionStrategy), "/graphql");
    }
}
