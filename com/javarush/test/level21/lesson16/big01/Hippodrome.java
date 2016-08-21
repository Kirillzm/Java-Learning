package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome {
    static ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;
    public ArrayList<Horse> getHorses()
    {
        return horses;
    }
    public void run() throws InterruptedException
    {
        for (int a = 0; a < 100; a++){
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (Horse horse : horses){
            horse.move();
        }
    }
    public void print(){
        for (int a = 0; a < horses.size(); a++){
            horses.get(a).print();
        }
        System.out.println();
        System.out.println();
    }
    public Horse getWinner(){
        double dis=0;
        Horse winner=null;
        for (Horse horse : horses){
            if (horse.getDistance()>dis) {
                dis=horse.getDistance();
                winner=horse;
            }
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        horses.add(new Horse("Burya", 3, 0));
        horses.add(new Horse("Ksysha", 3, 0));
        horses.add(new Horse("Plotva", 3, 0));
        game.run();
        game.printWinner();
    }
}