package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }

        public A() {
            this.name = "";
        }

    }

    public class B extends A implements Serializable {

        public B(String name) {
            super(name);
            this.name += name;
        }

//        public void writeObject(ObjectOutput out) throws IOException {
//            out.writeObject(name);
//        }
//
//        public  void readObject(ObjectInput in) throws IOException, ClassNotFoundException {
//            name = (String) in.readObject();
//        }


    }
}
