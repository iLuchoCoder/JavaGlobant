package com.java.testing.triangles.service;

import com.java.triangles.exception.InvalidTriangleException;
import com.java.triangles.generator.TriangleGenerator;
import com.java.triangles.model.Result;
import com.java.triangles.model.Triangle;
import com.java.triangles.service.TriangleCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class TriangleCalculatorTest {

    @Mock
    private TriangleGenerator generator;

    @InjectMocks
    private TriangleCalculator calculator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInvalidTriangleBySideLessThanZero() {
        Triangle triangle = Triangle.builder().a(-1).b(1).c(3).build();
        Mockito.when(generator.generateTriangle()).thenReturn(triangle);

        InvalidTriangleException ex =
                Assertions.assertThrows(InvalidTriangleException.class,
                        () -> calculator.calculate());

        Assertions.assertEquals(TriangleCalculator.INVALID_TRIANGLE_BY_SIDE_MESSAGE,
                ex.getMessage());
    }

    @Test
    public void testInvalidTriangleByTheorem() {
        Triangle triangle = Triangle.builder().a(1).b(1).c(50).build();
        Mockito.when(generator.generateTriangle()).thenReturn(triangle);

        InvalidTriangleException ex =
                Assertions.assertThrows(InvalidTriangleException.class,
                        () -> calculator.calculate());

        Assertions.assertEquals(TriangleCalculator.INVALID_TRIANGLE_BY_THEOREM_MESSAGE,
                ex.getMessage());
    }

    @Test
    public void testValidTriangle() {
        Triangle validTriangle = Triangle.builder().a(6).b(4).c(9).build();
        Mockito.when(generator.generateTriangle()).thenReturn(validTriangle);

        Integer perimeter = this.calculatePerimeter(validTriangle);
        Double area = this.calculateArea(validTriangle);

        Result result = calculator.calculate();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(perimeter, result.getPerimeter());
        Assertions.assertEquals(area, result.getArea());

        Mockito.verify(generator, Mockito.times(1)).generateTriangle();

    }

    private Integer calculatePerimeter(Triangle triangle) {
        return triangle.getA() + triangle.getB() + triangle.getC();
    }

    private Double calculateArea(Triangle triangle) {
        Double sp = Double.valueOf(calculatePerimeter(triangle) / 2);
        return Math.sqrt(sp*(sp-triangle.getA())*(sp-triangle.getB())* (sp-triangle.getC()));
    }
}
