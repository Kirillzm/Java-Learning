package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter  implements PersonScanner {
        private Scanner scanner;
        PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

       public Person read() throws IOException {
           String str = scanner.nextLine();
           String[] split = str.split(" ");
           GregorianCalendar calendar = new GregorianCalendar();
           calendar.set(Integer.parseInt(split[5]), Integer.parseInt(split[4])-1, Integer.parseInt(split[3]));
           return new Person(split[1], split[2], split[0], calendar.getTime());

        }

        public void close() throws IOException {
            scanner.close();

        }

    }
}
