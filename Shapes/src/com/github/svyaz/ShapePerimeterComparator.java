package com.github.svyaz;

import com.github.svyaz.javalearning.shapes.Shape;
import java.util.Comparator;

public class ShapePerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape object1, Shape object2) {
        return Double.compare(object1.getPerimeter(),object2.getPerimeter());
    }
}
