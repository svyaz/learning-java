package com.github.svyaz.javalearning.shapes;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {
    private static final double EPSILON = 1e-10;
    private ShapeCompareType compareType;

    public ShapeComparator(ShapeCompareType compareType) {
        this.compareType = compareType;
    }

    @Override
    public int compare(Shape object1, Shape object2) {
        double compareParameter1 = 0.0;
        double compareParameter2 = 0.0;

        switch (compareType) {
            case AREA:
                compareParameter1 = object1.getArea();
                compareParameter2 = object2.getArea();
                break;
            case PERIMETER:
                compareParameter1 = object1.getPerimeter();
                compareParameter2 = object2.getPerimeter();
                break;
        }

        if (compareParameter1 - compareParameter2 > EPSILON) {
            return 1;
        }
        if (compareParameter2 - compareParameter1 > EPSILON) {
            return -1;
        }
        return 0;
    }
}
