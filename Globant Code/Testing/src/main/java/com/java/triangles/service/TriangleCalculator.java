package com.java.triangles.service;

import com.java.triangles.exception.InvalidTriangleException;
import com.java.triangles.generator.TriangleGenerator;
import com.java.triangles.model.Result;
import com.java.triangles.model.Triangle;
import org.springframework.beans.factory.annotation.Autowired;

public class TriangleCalculator {

    public static String INVALID_TRIANGLE_BY_SIDE_MESSAGE = "One side is less or equals than 0";
    public static String INVALID_TRIANGLE_BY_THEOREM_MESSAGE = "Inequality Theorem failure";

    @Autowired
    private TriangleGenerator generator;

    public Result calculate() {
        Triangle triangle = generator.generateTriangle();

        if(!this.isTriangleValidSides(triangle)){
            throw new InvalidTriangleException(INVALID_TRIANGLE_BY_SIDE_MESSAGE);
        }

        if (!this.isTriangleValidInequalityTheorem(triangle)) {
            throw new InvalidTriangleException(INVALID_TRIANGLE_BY_THEOREM_MESSAGE);
        }

        return Result.builder().perimeter(this.calculatePerimeter(triangle))
                .area(this.caculateArea(triangle)).build();
    }

    private boolean isTriangleValidSides(Triangle triangle) {
        return triangle.getA() > 0 && triangle.getB() > 0 && triangle.getC() > 0;
    }

    private boolean isTriangleValidInequalityTheorem(Triangle triangle) {
        return ((triangle.getA() + triangle.getB() > triangle.getC())
                && (triangle.getB() + triangle.getC() > triangle.getA())
                && (triangle.getC() + triangle.getA() > triangle.getB()));
    }

    private Integer calculatePerimeter(Triangle triangle) {
        return triangle.getA() + triangle.getB() + triangle.getC();
    }

    private Double caculateArea(Triangle triangle) {
        Double sp = Double.valueOf(calculatePerimeter(triangle) / 2);
        return Math.sqrt(sp*(sp-triangle.getA())*(sp-triangle.getB())* (sp-triangle.getC()));
    }

}
