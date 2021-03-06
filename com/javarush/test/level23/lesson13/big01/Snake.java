package com.javarush.test.level23.lesson13.big01;

import java.util.ArrayList;

/**
 * Класс змея
 */
public class Snake
{
    //Направление движения змеи
    private SnakeDirection direction;
    //Состояние - жива змея или нет.
    private boolean isAlive;
    //Список кусочков змеи.
    private ArrayList<SnakeSection> sections = new ArrayList<SnakeSection>();

    public Snake(int x, int y)
    {
        sections = new ArrayList<SnakeSection>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }

    public boolean isAlive()
    {
        return isAlive;
    }

    public int getX()
    {
        return sections.get(0).getX();
    }

    public int getY()
    {
        return sections.get(0).getY();
    }

    public SnakeDirection getDirection()
    {
        return direction;
    }

    public void setDirection(SnakeDirection direction)
    {
        this.direction = direction;
    }

    public ArrayList<SnakeSection> getSections()
    {
        return sections;
    }

    /**
     * Метод перемещает змею на один ход.
     * Направление перемещения задано переменной direction.
     */
    public void move()
    {
        SnakeSection head = new SnakeSection(sections.get(0).getX(), sections.get(0).getY());

        checkBody(head);
        checkBorders(head);

        if (!isAlive) return;

        if (direction == SnakeDirection.UP)
            move(0, -1);
        else if (direction == SnakeDirection.RIGHT)
            move(1, 0);
        else if (direction == SnakeDirection.DOWN)
            move(0, 1);
        else if (direction == SnakeDirection.LEFT)
            move(-1, 0);
    }

    /**
     * Метод перемещает змею в соседнюю клетку.
     * Кординаты клетки заданы относительно текущей головы с помощью переменных (dx, dy).
     */
    private void move(int dx, int dy)
    {
        //Создаем новую голову - новый "кусочек змеи".
        //Проверяем - не вылезла ли голова за границу комнаты
        //Проверяем - не пересекает ли змея  саму себя
        //Проверяем - не съела ли змея мышь.
        //Двигаем змею.

        SnakeSection head = new SnakeSection(dx, dy);
        checkBorders(head);
        checkBody(head);

        if(head.getX() == Room.game.getMouse().getX() && head.getY() == Room.game.getMouse().getY()) {
            Room.game.eatMouse();
        }

        if(isAlive) {
            getSections().add(0, head);
            getSections().remove(getSections().size()-1);
        }



    }

    /**
     *  Метод проверяет - находится ли новая голова в пределах комнаты
     */
    private void checkBorders(SnakeSection head)
    {
        /*
        if(head.getX() < 0 || head.getX() > Room.game.getWidth()) {
            isAlive = false;
        }
        if(head.getY() < 0 || head.getY() > Room.game.getHeight()) {
            isAlive = false;
        }
        */
    }

    /**
     *  Метод проверяет - не совпадает ли голова с каким-нибудь участком тела змеи.
     */
    private void checkBody(SnakeSection head)
    {
       if (sections.contains(head)) {
            isAlive = false;
        }
    }
}
