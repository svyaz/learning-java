package com.github.svyaz.javalearning.matrix;

import com.github.svyaz.javalearning.vector.Vector;

public class Matrix {
    private static final String EXCEPTION_CONSTRUCTOR_MESSAGE = "Matrix rows and columns sizes must be greater than 0.";
    //private static final String EXCEPTION_INDEX_OUT_OF_BOUNDS_MESSAGE = "Index out of bounds of rows number.";
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

    /*public Vector getRow(int index) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException(EXCEPTION_INDEX_OUT_OF_BOUNDS_MESSAGE);
        }
        return rows[index];
    }*/

    public int[] getSizes() {
        return new int[]{rows.length, rows[0].getSize()};
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
  Получение и задание вектора-строки по индексу
  Получение вектора-столбца по индексу
  Транспонирование матрицы
  Умножение на скаляр
  Вычисление определителя матрицы
  + toString определить так, чтобы результат получался в таком виде: { { 1, 2 }, { 2, 3 } }
  умножение матрицы на вектор
  Сложение матриц
  Вычитание матриц

Статические методы:
  Сложение матриц
  Вычитание матриц
  Умножение матриц
*/