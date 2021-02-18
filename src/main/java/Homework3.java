

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Homework3 {

    //1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать
    // это число. При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное,
    // или меньше. После победы или проигрыша выводится
    // запрос – «Повторить игру еще раз? 1 да / 0 – нет»(1 – повторить, 0 – нет)./


    public static void guessingNumberGame() throws IOException {
        System.out.println("Требуется угадать число от 0 до 9, у вас 3 попытки. Введите пожалуйста число:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random rand = new Random();
        int guessedNumber = rand.nextInt(10);
        for (int i = 3; i > 0; i--) {
            byte answerOfPerson = Byte.parseByte(reader.readLine());
            if (answerOfPerson > guessedNumber) System.out.println(" Введёное число больше загаданного, осталось " + ( i - 1) + " попробуйте ввести другое число");
            else if (answerOfPerson < guessedNumber) System.out.println(" Введёное число меньше загаданного, осталось " + ( i - 1) + " попыток, попробуйте ввести другое число");
            else if (answerOfPerson == guessedNumber) {
                System.out.println("Поздравляю, Вы угадали!");
                break;
            }
            if (i == 1 && answerOfPerson != guessedNumber) System.out.println("ой, а ввести уже ничего не получится, ваши попытки исчерпаны \n к сожалению, вы не угадали...");
        }
            System.out.println("Повторить игру еще раз? Введите 1 если хотите и 0 если нет");
            byte answerOfPersonOfEndingOrContinuing = Byte.parseByte(reader.readLine());
            if (answerOfPersonOfEndingOrContinuing == 1) guessingNumberGame();
            else if (answerOfPersonOfEndingOrContinuing == 0) System.out.println("Игра окончена!");
        reader.close();
        }

        /*2  Создать массив из слов
    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
            При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
    apple – загаданное
    apricot - ответ игрока
    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    Для сравнения двух слов посимвольно можно пользоваться:
    String str = "apple";
    char a = str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
    Играем до тех пор, пока игрок не отгадает слово.
    Используем только маленькие буквы.
*/
        public static void guessingWordGame() throws IOException {
            Random rand = new Random();
            int plate = rand.nextInt(25);
            String[] words = new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
                    System.out.println("Компьютер загадал слово,попытайтесь отгадать, играем до тех пор, пока игрок не отгадает слово:");
            String guessedWord = words[plate];
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String answerOfPerson = reader.readLine().toLowerCase();
            int maxLength = answerOfPerson.length() < guessedWord.length() ? answerOfPerson.length() : guessedWord.length();
            if(answerOfPerson.equals(guessedWord)){
                System.out.println("Поздравляю, Вы угадали!");
                break;
            }
            else if (!answerOfPerson.equals(guessedWord)){
                System.out.println("Попробуйте ещё раз, вы не угадали, сейчас будет выведена подсказка, какие буквы вами угаданы, # не означает что буква обязательно есть, она может как быть:");
                String[] promptArray = new String[15];
                for (int i = 0; i < 15; i++)promptArray[i] = "#";
                for (int i = 0; i < maxLength;i++){
                  if (answerOfPerson.charAt(i) == guessedWord.charAt(i)){
                      promptArray[i] = Character.toString(guessedWord.charAt(i));
                  }
                  else if(answerOfPerson.charAt(i) != guessedWord.charAt(i)){
                      promptArray[i] ="#";
                  }

                }
                ArrayList<String> list = new ArrayList<String>(Arrays.asList(promptArray));
                for (String partOfList: list)
                      {
                          System.out.print(partOfList);
                }
                System.out.println();
            }
        }
        }
//
            public static void main(String[] args) throws IOException{
            guessingWordGame();



    }
        }
