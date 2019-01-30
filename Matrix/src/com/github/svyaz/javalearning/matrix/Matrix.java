package com.github.svyaz.javalearning.matrix;

import com.github.svyaz.javalearning.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private static final String EXCEPTION_CONSTRUCTOR_MESSAGE = "Matrix rows and columns sizes must be greater than 0.";
    private static final String EXCEPTION_ROW_INDEX_OUT_OF_BOUNDS_MESSAGE = "Index out of bounds of rows number.";
    private static final String EXCEPTION_COLUMN_INDEX_OUT_OF_BOUNDS_MESSAGE = "Index out of bounds of columns number.";
    private static final String EXCEPTION_WRONG_ROW_SIZE_MESSAGE = "Size of new row not equal to matrix row size.";
    private static final String EXCEPTION_WRONG_COLUMN_SIZE_MESSAGE = "Size of new column not equal to matrix column size.";
    private static final String EXCEPTION_MATRIX_NOT_SQUARE_MESSAGE = "Matrix not square.";
    private static final String EXCEPTION_COLUMN_SIZE_NOT_MATCH_MESSAGE = "Column-vector size not match matrix row size.";
    private static final String EXCEPTION_ROW_OR_MATRIX_SIZE_NOT_MATCH_MESSAGE = "Row-vector or matrix size not match row-multiplication conditions.";
    private static final String EXCEPTION_MATRICES_SIZES_NOT_EQUAL_MESSAGE = "Matrices sizes not equal.";
    private static final String EXCEPTION_MATRICES_NOT_CONSISTENT_MESSAGE = "Matrices not consistent.";
    private Vector[] rows;

    public Matrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException(EXCEPTION_CONSTRUCTOR_MESSAGE);
        }
        this.rows = new Vector[rows];
        for (int i = 0; i < rows; i++) {
            this.rows[i] = new Vector(columns);
        }
    }

    public Matrix(Vector[] rows) {
        if (rows.length == 0) {
            throw new IllegalArgumentException(EXCEPTION_CONSTRUCTOR_MESSAGE);
        }
        int maxColumns = rows[0].getSize();
        for (int i = 1; i < rows.length; i++) {
            if (rows[i].getSize() > maxColumns) {
                maxColumns = rows[i].getSize();
            }
        }
        this.rows = new Vector[rows.length];
        for (int i = 0; i < rows.length; i++) {
            this.rows[i] = new Vector(maxColumns);
            this.rows[i].add(rows[i]);
        }
    }

    public Matrix(double[][] elements) {
        if (elements.length == 0) {
            throw new IllegalArgumentException(EXCEPTION_CONSTRUCTOR_MESSAGE);
        }
        int maxColumns = elements[0].length;
        for (int i = 1; i < elements.length; i++) {
            if (elements[i].length > maxColumns) {
                maxColumns = elements[i].length;
            }
        }
        if (maxColumns == 0) {
            throw new IllegalArgumentException(EXCEPTION_CONSTRUCTOR_MESSAGE);
        }
        this.rows = new Vector[elements.length];
        for (int i = 0; i < elements.length; i++) {
            this.rows[i] = new Vector(maxColumns, elements[i]);
        }
    }

    public Matrix(Matrix matrix) {
        this.rows = new Vector[matrix.rows.length];
        for (int i = 0; i < matrix.rows.length; i++) {
            this.rows[i] = new Vector(matrix.rows[i]);
        }
    }

    public static Matrix add(Matrix matrix1, Matrix matrix2) {
        if (matrix1.rows.length != matrix2.rows.length || matrix1.getColumnsCount() != matrix2.getColumnsCount()) {
            throw new ArithmeticException(EXCEPTION_MATRICES_SIZES_NOT_EQUAL_MESSAGE);
        }
        Matrix result = new Matrix(matrix1);
        result.add(matrix2);
        return result;
    }

    public static Matrix subtract(Matrix matrix1, Matrix matrix2) {
        if (matrix1.rows.length != matrix2.rows.length || matrix1.getColumnsCount() != matrix2.getColumnsCount()) {
            throw new ArithmeticException(EXCEPTION_MATRICES_SIZES_NOT_EQUAL_MESSAGE);
        }
        Matrix result = new Matrix(matrix1);
        result.subtract(matrix2);
        return result;
    }

    public static Matrix multiply(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.rows.length) {
            throw new ArithmeticException(EXCEPTION_MATRICES_NOT_CONSISTENT_MESSAGE);
        }

        int rowsNumber = matrix1.rows.length;
        int columnsNumber = matrix2.getColumnsCount();
        Matrix result = new Matrix(rowsNumber, columnsNumber);
        for (int i = 0; i < rowsNumber; i++) {
            Vector tmpVector = new Vector(columnsNumber);
            for (int j = 0; j < columnsNumber; j++) {
                double element = Vector.scalarMultiplication(matrix1.getRow(i), matrix2.getColumn(j));
                tmpVector.setComponent(j, element);
            }
            result.setRow(i, tmpVector);
        }
        return result;
    }

    /**
     * Код из дополнительного задания про определитель в курсе "Основы программирования".
     */
    private static double calcDeterminant(double[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        }

        double d = 0;
        for (int i = 0; i < n; i++) {
            double[][] minor = new double[n - 1][n - 1];
            for (int j = 0; j < n - 1; j++) {
                for (int k = 0; k < n - 1; k++) {
                    minor[j][k] = matrix[j + 1][k >= i ? k + 1 : k];
                }
            }
            d += matrix[0][i] * Math.pow(-1, i) * calcDeterminant(minor);
        }
        return d;
    }

    public Vector getRow(int index) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException(EXCEPTION_ROW_INDEX_OUT_OF_BOUNDS_MESSAGE);
        }
        return new Vector(rows[index]);
    }

    public void setRow(int index, Vector row) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException(EXCEPTION_ROW_INDEX_OUT_OF_BOUNDS_MESSAGE);
        }
        if (getColumnsCount() != row.getSize()) {
            throw new IllegalArgumentException(EXCEPTION_WRONG_ROW_SIZE_MESSAGE);
        }
        rows[index] = new Vector(row);
    }

    public Vector getColumn(int index) {
        if (index < 0 || index >= getColumnsCount()) {
            throw new IndexOutOfBoundsException(EXCEPTION_COLUMN_INDEX_OUT_OF_BOUNDS_MESSAGE);
        }
        double[] column = new double[rows.length];
        for (int i = 0; i < rows.length; i++) {
            column[i] = rows[i].getComponent(index);
        }
        return new Vector(column);
    }

    public void setColumn(int index, Vector column) {
        if (index < 0 || index >= getColumnsCount()) {
            throw new IndexOutOfBoundsException(EXCEPTION_COLUMN_INDEX_OUT_OF_BOUNDS_MESSAGE);
        }
        if (column.getSize() != rows.length) {
            throw new IllegalArgumentException(EXCEPTION_WRONG_COLUMN_SIZE_MESSAGE);
        }
        for (int i = 0; i < rows.length; i++) {
            rows[i].setComponent(index, column.getComponent(i));
        }
    }

    public int getRowsCount() {
        return rows.length;
    }

    public int getColumnsCount() {
        return rows[0].getSize();
    }

    public void transpose() {
        Vector[] newRows = new Vector[getColumnsCount()];
        for (int i = 0; i < getColumnsCount(); i++) {
            newRows[i] = getColumn(i);
        }
        rows = newRows;
    }

    public void multiply(double number) {
        for (Vector row : rows) {
            row.multiplication(number);
        }
    }

    /**
     * Multiplication by vector-column
     */
    public Vector multiplyByColumn(Vector column) {
        if (getColumnsCount() != column.getSize()) {
            throw new ArithmeticException(EXCEPTION_COLUMN_SIZE_NOT_MATCH_MESSAGE);
        }

        Vector result = new Vector(rows.length);
        for (int i = 0; i < rows.length; i++) {
            double tmp = 0.0;
            for (int j = 0; j < column.getSize(); j++) {
                tmp += rows[i].getComponent(j) * column.getComponent(j);
            }
            result.setComponent(i, tmp);
        }
        return result;
    }

    /**
     * Multiplication by vector-row
     */
    public void multiplyByRow(Vector row) {
        if (rows.length != row.getSize() || getColumnsCount() > 1) {
            throw new ArithmeticException(EXCEPTION_ROW_OR_MATRIX_SIZE_NOT_MATCH_MESSAGE);
        }

        for (int i = 0; i < rows.length; i++) {
            Vector tmpVector = new Vector(rows.length);
            for (int j = 0; j < rows.length; j++) {
                tmpVector.setComponent(j, rows[i].getComponent(0) * row.getComponent(j));
            }
            rows[i] = tmpVector;
        }
    }

    public void add(Matrix matrix) {
        if (rows.length != matrix.rows.length || getColumnsCount() != matrix.getColumnsCount()) {
            throw new ArithmeticException(EXCEPTION_MATRICES_SIZES_NOT_EQUAL_MESSAGE);
        }

        for (int i = 0; i < rows.length; i++) {
            rows[i].add(matrix.rows[i]);
        }
    }

    public void subtract(Matrix matrix) {
        if (rows.length != matrix.rows.length || getColumnsCount() != matrix.getColumnsCount()) {
            throw new ArithmeticException(EXCEPTION_MATRICES_SIZES_NOT_EQUAL_MESSAGE);
        }

        for (int i = 0; i < rows.length; i++) {
            rows[i].subtract(matrix.rows[i]);
        }
    }

    public double getDeterminant() {
        if (rows.length != getColumnsCount()) {
            throw new ArithmeticException(EXCEPTION_MATRIX_NOT_SQUARE_MESSAGE);
        }

        int dimension = rows.length;
        double[][] tmpMatrix = new double[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            double[] tmpRow = new double[dimension];
            for (int j = 0; j < dimension; j++) {
                tmpRow[j] = rows[i].getComponent(j);
            }
            tmpMatrix[i] = tmpRow;
        }
        return calcDeterminant(tmpMatrix);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Matrix { ");
        for (int i = 0; i < rows.length; i++) {
            str.append("{ ");
            for (int j = 0; j < rows[i].getSize(); j++) {
                str.append(rows[i].getComponent(j));
                str.append(j == rows[i].getSize() - 1 ? " }" : ", ");
            }
            str.append(i == rows.length - 1 ? " }" : ", ");
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Matrix matrix = (Matrix) object;
        return Arrays.equals(rows, matrix.rows);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rows);
    }
}
