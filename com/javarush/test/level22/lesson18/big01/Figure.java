package com.javarush.test.level22.lesson18.big01;


public class Figure {
    private int x;
    private int y;

    private int[][] matrix;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public Figure(int x, int y, int[][] matrix) {
        this.matrix = new int[y][x];
    }

    public void left() {
        x--;

        if(!isCurrentPositionAvailable()) {
            x++;
        }
    }
    public void right() {
        x++;
        if(!isCurrentPositionAvailable()) {
            x--;
        }
    }
    public void down() {
        y++;
    }
    public void up() {

        y--;
    }
    public void downMaximum() {
        while (isCurrentPositionAvailable()) {
            down();
        }
        up();
    }
    public void rotate() {
        int[][] matrix2 = new int[3][3];

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                matrix2[i][j] = matrix[j][i];
            }
        }

        matrix = matrix2;

    }
    public boolean isCurrentPositionAvailable() {
        Field field = Tetris.game.getField();

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (matrix[i][j] == 1)
                {
                    if (y + i >= field.getHeight())
                        return false;

                    Integer value = field.getValue(x + j, y + i);
                    if (value == null || value == 1)
                        return false;
                }
            }
        }

        return true;
    }
    public void landed() {
        Field field = Tetris.game.getField();

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (matrix[i][j] == 1)
                    field.setValue(x + j, y + i, 1);
            }
        }

    }

}

/*
Добавь в класс Figure методы:
left() - для движения фигурки влево.
right() - для движения фигурки вправо.
down() - для движения фигурки вниз.
up() - для движения фигурки вверх.
downMaximum() - падение фигурки в низ до дна.
rotate() - для поворота фигурки вокруг главной диагонали.
boolean isCurrentPositionAvailable() - проверка - может ли фигурка быть помещена в текущую позицию. Для теста захардкодь результат в true.
landed() - вызывается, когда фигурка достигла дна или уперлась в другую фигурку
Все ее занятые клетки теперь должны добавиться в Field.
 */
