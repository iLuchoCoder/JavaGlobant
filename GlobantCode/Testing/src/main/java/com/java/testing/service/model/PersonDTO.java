package com.java.testing.service.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonDTO {

    private Integer id;
    private String firstName;
    private String lastName;
}
