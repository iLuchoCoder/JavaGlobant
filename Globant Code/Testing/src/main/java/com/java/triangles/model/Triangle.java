package com.java.triangles.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Triangle {

    private Integer a;
    private Integer b;
    private Integer c;

}
