package HomeWork07_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Translator {
    /**
     * Задание 2
     * Создать программу по работе со словарем. Например,
     * англо-испанский или французско-немецкий, или любое
     * другое направление.
     * Программа должна:
     * ■■Обеспечивать начальный ввод данных для словаря.
     * ■■ Позволять отобразить слово и его переводы.
     * ■■ Позволять добавить, заменить, удалить переводы слова.
     * ■■ Позволять добавить, заменить, удалить слово.
     * ■■Отображать топ-10 самых популярных слов (определя-
     * ем популярность на основании счетчика обращений).
     * ■■Отображать топ-10 самых непопулярных слов (опре-
     * деляем непопулярность на основании счетчика об-
     * ращений).
     */
    public static HashMap<String, ArrayList<String>> translator = new HashMap();
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static List<String> list = new ArrayList<>();//создаем временную коллекцию
    public static HashMap<String, Integer> countWords = new HashMap<>();

    public static void main(String[] args) throws IOException {
        showMenu(); //отображаем меню
        init(); // заполняем наш MAP
        int choise = choise(); //вводим строку и парсим в число(выбираем действие)
        String userWord;
        while (choise != 0) {
            switch (choise) {

                case 1:
                    System.out.println("Вы выбрали 1\n" +
                            "Отобразить слово и его переводы.");
                    System.out.println("Введите английское слово");
                    userWord = inputWord();//вводим слово и печатаем перевод
                    translationOutput(userWord);//ператаем перевод
                    countWords.put(userWord, countWords.get(userWord) + 1);//увеличиваем количество обращений
                    choise = choise();//вводим строку и парсим в число(выбираем действие)
                    break;
                case 2:
                    System.out.println("Вы выбрали 2\n" +
                            "Добавить, заменить, удалить переводы слова");
                    System.out.println("Введите английское слово");
                    userWord = inputWord();//вводим слово
                    translationOutput(userWord);//печатаем перевод
                    System.out.println("Выберете действие :\n" +
                            "1.Добавить слово перевода\n" +
                            "2.Заменить слово перевода\n" +
                            "3.Удалить слово перевода");

                    list.addAll(translator.get(userWord));//и заполняем
                    int num2 = choise();//выбираем действие
                    int index;
                    switch (num2) {
                        case 1:
                            System.out.println("Вы выбрали \n" +
                                    "1.Добавить слово перевода");
                            list.add(inputWord());//добавляем слово
                            break;
                        case 2:
                            System.out.println("Вы выбрали \n" +
                                    "2.Заменить слово перевода");

                            System.out.println("Введите порядковый номер слова которое хотите заменить :");
                            index = indexNumber(); //вводим число (без проверок на строки и дробные числа)
                            System.out.println("ВВедите новое слово");
                            list.set((index - 1), inputWord());
                            break;
                        case 3:
                            System.out.println("Вы выбрали \n" +
                                    "3.Удалить слово перевода");
                            System.out.println("Введите порядковый номер слова которое хотите удалить :");
                            index = indexNumber(); //вводим число (без проверок на строки и дробные числа)
                            list.remove(index - 1);
                            break;
                    }
                    translator.replace(userWord, (ArrayList<String>) list);// меняем значение в MAP
                    System.out.println(translator.get(userWord));
                    choise = choise();//вводим строку и парсим в число(выбираем действие)
                    break;
                case 3:
                    System.out.println("Вы выбрали 3\n" +
                            "Добавить, заменить, удалить слово.");

                    System.out.println("Выберете действие :\n" +
                            "1.Добавить слово\n" +
                            "2.Заменить слово\n" +
                            "3.Удалить слово");
//                list.addAll(translator.get(inputWord()));
                    int num3 = choise();//выбираем действие
                    switch (num3) {
                        case 1:
                            System.out.println("Вы выбрали 1\n" +
                                    "Добавить слово");
                            System.out.println("Введите новое слово");
                            String newKey = inputWord();
                            System.out.println("Введите перевод слова");
                            String newWord = inputWord();
                            ArrayList<String> newArr = new ArrayList<>();
                            newArr.addAll(Arrays.asList(newWord));
                            translator.put(newKey, newArr);
                            break;
                        case 2:
                            System.out.println("Вы выбрали 2\n" +
                                    "Заменить слово");
                            System.out.println("Введите английское слово");
                            userWord = inputWord();
                            if (translator.containsKey(userWord)) {
                                newArr = translator.get(userWord);//временно записываем значение в новый лист
                                translator.remove(userWord); //удаляем слово и перевод
                                System.out.println("Введите новое слово(key)");
                                newKey = inputWord();
                                translator.put(newKey, newArr);
                            } else {
                                System.out.println("Такого слова нет в списке!!!");
                            }
                            break;
                        case 3:
                            System.out.println("Вы выбрали 3\n" +
                                    "Удалить слово");
                            System.out.println("Введите английское слово которое хотите удалить");
                            userWord = inputWord();
                            if (translator.containsKey(userWord)) {
                                translator.remove(userWord); //удаляем слово и перевод
                            } else {
                                System.out.println("Такого слова нет в списке!!!");
                            }
                            break;
                    }
                    System.out.println(translator);
                    choise = choise();//вводим строку и парсим в число(выбираем действие)
                    break;

                case 4:
                    System.out.println("Вы выбрали 4\n" +
                            "Отобразить топ-10 самых популярных слов.");
                    HashMap<String, Integer> count = new HashMap<>();

                    choise = choise();//вводим строку и парсим в число(выбираем действие)
                    break;
                case 5:
                    System.out.println("Вы выбрали 5\n" +
                            "Отобразить топ-10 самых непопулярных слов. ");
                    choise = choise();//вводим строку и парсим в число(выбираем действие)
                    break;
                case 0:
                    System.out.println("THE END!!!");

            }
        }


    }

    //вводим число (без проверок на строки и дробные числа)
    private static int indexNumber() throws IOException {
        int num = Integer.parseInt(reader.readLine());
        return num;
    }


    private static Collection<String> returnTranslate(String inputWord) {
        return translator.get(inputWord);
    }

    private static void setTranslateWord(String inputWord) {

    }

    //Вводим слово
    private static String inputWord() throws IOException {
        String word = reader.readLine();
        return word;
    }

    //вводим строку и парсим в число
    private static int choise() throws IOException {
        System.out.println("Введите действие которое хотите выбрать");
        String strNumber = reader.readLine();
        int number = 0;
        if (strNumber == null || strNumber == "") {
            System.out.println("Вы ввели пустую строку");
        }
        try {
            number = Integer.parseInt(strNumber);
        } catch (NumberFormatException ex) {
            try {
                double d = Double.parseDouble(strNumber);
                System.out.println("Вы ввели дробное число!!!");
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели строку");
            }
        }
        if (number >= 0 && number <= 5) {
            return number;
        } else {
            System.out.println("Вы ввели число вне диапазона!!!");
        }
        return number;
    }

    //печатаем перевод слова
    private static void translationOutput(String word) {
        System.out.println(translator.get(word));
    }

    //отображаем меню
    private static void showMenu() {
        System.out.println("1. Отобразить слово и его переводы.\n" +
                "2. Добавить, заменить, удалить переводы слова\n" +
                "3. Добавить, заменить, удалить слово.\n" +
                "4. Отобразить топ-10 самых популярных слов.\n" +
                "5. Отобразить топ-10 самых непопулярных слов.\n " +
                "0. Закончить.");
    }

    // заполняем наш MAP
    private static void init() {
        ArrayList<String> hello = new ArrayList<>();
        hello.addAll(Arrays.asList("Привет", "Добрый день", "Здравствуйте"));
        translator.put("hello", hello);
        countWords.put("hello", 0);
        ArrayList<String> buy = new ArrayList<>();
        buy.addAll(Arrays.asList("Досвидание", "Пока", "до встречи"));
        translator.put("buy", buy);
        countWords.put("buy", 0);
    }
}
