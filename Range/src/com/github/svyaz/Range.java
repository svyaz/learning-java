package com.github.svyaz;

public class Range {
    private static final double EPSILON = 1e-10;
    private static final String EXCEPTION_MESSAGE = "'from' cannot be greater than 'to'.";
    private double from;
    private double to;
    private double length;

    public Range(double from, double to) throws IllegalArgumentException {
        if (from > to) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.from = from;
        this.to = to;
        setLength();
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) throws IllegalArgumentException {
        if (from > to) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.from = from;
        setLength();
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) throws IllegalArgumentException {
        if (from > to) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.to = to;
        setLength();
    }

    public double getLength() {
        return length;
    }

    private void setLength() {
        length = to - from;
    }

    public String toString() {
        return "[" + from + ", " + to + "]";
    }

    public boolean isInside(double number) {
        return number - from > Range.EPSILON && to - number > Range.EPSILON;
    }
}
