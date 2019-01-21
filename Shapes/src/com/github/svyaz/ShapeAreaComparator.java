package com.github.svyaz;

import com.github.svyaz.javalearning.shapes.Shape;
import java.util.Comparator;

public class ShapeAreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape object1, Shape object2) {
        return Double.compare(object1.getArea(),object2.getArea());
    }
}
