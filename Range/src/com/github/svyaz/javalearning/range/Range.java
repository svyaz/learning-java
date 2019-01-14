package com.github.svyaz.javalearning.range;

public class Range {
    private static final String EXCEPTION_MESSAGE = "'from' cannot be greater than 'to'.";
    private double from;
    private double to;

    public Range(double from, double to) throws IllegalArgumentException {
        if (from > to) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) throws IllegalArgumentException {
        if (from > to) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) throws IllegalArgumentException {
        if (from > to) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public String toString() {
        return "[" + from + ", " + to + "]";
    }

    public boolean isInside(double number) {
        return from <= number && number <= to;
    }

    public Range getCrossing(Range range) {
        if (this.to <= range.from || range.to <= this.from) {
            // they not crossing
            return null;
        }
        // they crossing
        double newFrom = Math.max(this.from, range.from);
        double newTo = Math.min(this.to, range.to);
        return new Range(newFrom, newTo);
    }

    public Range[] getUnion(Range range) {
        if (this.to < range.from || range.to < this.from) {
            // they not crossing
            Range newRange1 = new Range(this.from, this.to);
            Range newRange2 = new Range(range.from, range.to);
            return new Range[]{newRange1, newRange2};
        }
        // they crossing
        double newFrom = Math.min(this.from, range.from);
        double newTo = Math.max(this.to, range.to);
        return new Range[]{new Range(newFrom, newTo)};
    }

    public Range[] getSubtraction(Range range) {
        if (this.to <= range.from || range.to <= this.from) {
            // they not crossing
            return new Range[]{new Range(this.from, this.to)};
        }
        // they crossing
        if (this.from != range.from) {
            // left borders not equal
            double newFrom = Math.min(this.from, range.from);
            double newTo = Math.max(this.from, range.from);
            return new Range[]{new Range(newFrom, newTo)};
        }
        if (this.from == range.from && this.to == range.to) {
            // ranges completely equal
            return new Range[]{};
        }
        // left borders equal, right borders not equal
        double newFrom = Math.min(this.to, range.to);
        double newTo = Math.max(this.to, range.to);
        return new Range[]{new Range(newFrom, newTo)};
    }
}
