package com.javarush.test.level21.lesson16.big01;



public class Horse {
    public String name;
    public double speed;
    public double distance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move(){
        distance += speed * Math.random();
    }

    public void print(){
        String dista = "";
        for (int i=0; i<(int) distance; i++){
            dista +=".";
        }
        System.out.println(dista + name);
    }

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.distance = distance;
        this.speed = speed;
    }
}

