package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man1 = new Man("name1", 23, "qwe");
        Man man2 = new Man("name2", 22, "qwe2");

        Woman woman1 = new Woman("name1", 23, "qwe");
        Woman woman2 = new Woman("name2", 22, "qwe2");

        man1.print();
        man2.print();

        woman1.print();
        woman2.print();


    }

    public static class Man
    {
        String name;
        int age;
        String address;

        Man (String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        void print()
        {
            System.out.println(name + " " + age + " " + address);
        }
    }

    public static class Woman
    {
        String name;
        int age;
        String address;

        Woman (String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        void print()
        {
            System.out.println(name + " " + age + " " + address);
        }
    }
}
