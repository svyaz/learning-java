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

    public Vector getRow(int index) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException(EXCEPTION_ROW_INDEX_OUT_OF_BOUNDS_MESSAGE);
        }
        return rows[index];
    }

    public void setRow(int index, Vector row) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException(EXCEPTION_ROW_INDEX_OUT_OF_BOUNDS_MESSAGE);
        }
        if (rows[0].getSize() != row.getSize()) {
            throw new IllegalArgumentException(EXCEPTION_WRONG_ROW_SIZE_MESSAGE);
        }
        rows[index] = new Vector(row);
    }

    public Vector getColumn(int index) {
        if (index < 0 || index >= rows[0].getSize()) {
            throw new IndexOutOfBoundsException(EXCEPTION_COLUMN_INDEX_OUT_OF_BOUNDS_MESSAGE);
        }
        double[] column = new double[rows.length];
        for (int i = 0; i < rows.length; i++) {
            column[i] = rows[i].getComponent(index);
        }
        return new Vector(column);
    }

    public void setColumn(int index, Vector column) {
        if (index < 0 || index >= rows[0].getSize()) {
            throw new IndexOutOfBoundsException(EXCEPTION_COLUMN_INDEX_OUT_OF_BOUNDS_MESSAGE);
        }
        if (column.getSize() != rows.length) {
            throw new IllegalArgumentException(EXCEPTION_WRONG_COLUMN_SIZE_MESSAGE);
        }
        for (int i = 0; i < rows.length; i++) {
            rows[i].setComponent(index, column.getComponent(i));
        }
    }

    public int[] getSizes() {
        return new int[]{rows.length, rows[0].getSize()};
    }

    public void transpose() {
        Vector[] newRows = new Vector[rows[0].getSize()];
        for (int i = 0; i < rows[0].getSize(); i++) {
            newRows[i] = getColumn(i);
        }
        rows = newRows;
    }

    public void multiplication(double number) {
        for (Vector row : rows) {
            row.multiplication(number);
        }
    }

    public double getDeterminant() {
        if (rows.length != rows[0].getSize()) {
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
        return countDeterminant(tmpMatrix);
    }

    /**
     * Код из дополнительного задания про определитель в курсе "Основы программирования".
     */
    private static double countDeterminant(double[][] matrix) {
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
            d += matrix[0][i] * Math.pow(-1, i) * countDeterminant(minor);
        }
        return d;
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

/*
TODO:
Задача 3. Матрица

Реализовать класс матрицы Matrix с использованием класса Vector – хранить строки как массив векторов

Реализовать:

Конструкторы:
  + Matrix(n, m) – матрица нулей размера nxm
  + Matrix(Matrix) – конструктор копирования
  + Matrix(double[][]) – из двумерного массива (в C# double[,])
  + Matrix(Vector[]) – из массива векторов-строк

Методы:
  + Получение размеров матрицы
  + Получение и задание вектора-строки по индексу
  + Получение вектора-столбца по индексу
  + Транспонирование матрицы
  + Умножение на скаляр
  + Вычисление определителя матрицы
  + toString определить так, чтобы результат получался в таком виде: { { 1, 2 }, { 2, 3 } }
  умножение матрицы на вектор
  Сложение матриц
  Вычитание матриц

  + hashCode()
  + equals()

Статические методы:
  Сложение матриц
  Вычитание матриц
  Умножение матриц
*/