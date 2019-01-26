package com.github.svyaz.javalearning.matrix;

import com.github.svyaz.javalearning.vector.Vector;

public class Matrix {
    private static final String EXCEPTION_CONSTRUCTOR_MESSAGE = "Matrix rows and columns must be greater than 0.";
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
  Matrix(Matrix) – конструктор копирования
  Matrix(double[][]) – из двумерного массива (в C# double[,])
  Matrix(Vector[]) – из массива векторов-строк

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