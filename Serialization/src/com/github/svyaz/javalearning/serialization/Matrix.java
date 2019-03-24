package com.github.svyaz.javalearning.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class Matrix implements Serializable {
    private static final String EXC_MSG_ILLEGAL_DATA = "Matrix must be symmetric (NxN).";
    public static final long serialVersionUID = 1L;

    private int[][] data;

    public Matrix(int[][] data) {
        if (data.length == 0 || data.length != data[0].length) {
            throw new IllegalArgumentException(EXC_MSG_ILLEGAL_DATA);
        }
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matrix [").append(System.lineSeparator());
        for (int[] array : data) {
            sb.append(Arrays.toString(array)).append(',').append(System.lineSeparator());
        }
        sb.append(']');
        return sb.toString();
    }

    /*private void writeObject(ObjectOutputStream out) throws IOException {

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

    }*/
}
