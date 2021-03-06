package com.javarush.test.level08.lesson11.home02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

public class Solution
{
    public static class Cat
    {
    }

    public static class Dog
    {

    }

    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        Set<Cat> cats = new HashSet<>();
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());

        return cats;
    }

    public static Set<Dog> createDogs()
    {
        HashSet<Dog> dogs = new HashSet<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        dogs.add(new Dog());

        return dogs;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        HashSet<Object> set = new HashSet<>();
        Iterator<Cat> catsIter = cats.iterator();
        Iterator<Dog> dogsIter = dogs.iterator();

        while(catsIter.hasNext())
        {
            set.add(catsIter.next());
        }

        while(dogsIter.hasNext())
        {
            set.add(dogsIter.next());
        }

        return set;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        Iterator<Object> it = pets.iterator();

        while (it.hasNext())
        {
            if(it.next() instanceof Cat)
            {
                it.remove();
            }
        }
    }

    public static void printPets(Set<Object> pets)
    {
        Iterator<Object> it = pets.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }

    //напишите тут ваш код
}
