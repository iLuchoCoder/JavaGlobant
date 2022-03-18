package com.java.triangles.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result {

    private Integer perimeter;
    private Double area;
}
