package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(1, 1);
        A a1 = (A) a.clone();
        System.out.println(a1);
        C c = new C(3, 4, "Dima");
        C c1 = (C) c.clone();
        System.out.println(c1);
        B b = new B(1, 2, "Vasya");
        B b1 = (B) b.clone();
        System.out.println(b1);
    }

    public static class A implements Cloneable  {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        protected  Object clone() throws CloneNotSupportedException {
            return new A(getI(), getJ());
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        protected  Object clone() throws CloneNotSupportedException  {
            throw  new CloneNotSupportedException();
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        protected  Object clone() throws CloneNotSupportedException {
            return new C(super.getI(), super.getJ(), super.getName());
        }
    }
}
