package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
/*    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null) {
            throw new TooShortStringException();
        }
        String[] res = string.trim().split(" ");
        if(res.length<5) {
            throw new TooShortStringException();
        }
        String ret = "";
        for (int i = 1; i < 5; i++) {
            ret+= res[i] + " ";
        }
        return ret.trim();
    }

    public static class TooShortStringException extends Exception {

    }

    public static void main(String[] args) throws Exception {
        System.out.println(getPartOfString(null));
    }*/
}
