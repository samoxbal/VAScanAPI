package ru.vascan.api.dao;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "experiments")
@Data
@Accessors(chain = true)
public class Experiment {

    @Id
    private String id;

    @NotBlank
    private String user;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String startDate;

    @NotBlank
    private String endDate;
}
