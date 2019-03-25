package com.github.svyaz.javalearning.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class Matrix implements Serializable {
    private static final String EXC_MSG_ILLEGAL_DATA = "Matrix must be symmetric (NxN).";
    public static final long serialVersionUID = 1L;

    // для стандартной сериализации (без transient)
    //private int[][] data;
    private transient int[][] data;

    public Matrix(int[][] data) {
        if (data.length == 0 || data.length != data[0].length) {
            throw new IllegalArgumentException(EXC_MSG_ILLEGAL_DATA);
        }
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(" [").append(System.lineSeparator());
        for (int[] array : data) {
            sb.append("  ").append(Arrays.toString(array)).append(',').append(System.lineSeparator());
        }
        sb.append(']');
        return sb.toString();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        // сначала записываем размерность матрицы
        int dim = data.length;
        out.writeInt(dim);
        // по строкам
        for (int i = 0; i < dim; i++) {
            // по столбцам (начиная с элемента в диалогали)
            for (int j = i; j < dim; j++) {
                out.writeInt(data[i][j]);
            }
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // читаем размерность матрицы
        int dim = in.readInt();
        data = new int[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (j >= i) {
                    data[i][j] = in.readInt();
                } else {
                    data[i][j] = data[j][i];
                }
            }
        }
    }
}
