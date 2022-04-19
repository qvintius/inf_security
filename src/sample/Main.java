package sample;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ключ: ");
        String key = scanner.nextLine().toLowerCase(Locale.ROOT);//ключ
        System.out.println("Введите сообщение: ");
        String inputString = scanner.nextLine().toLowerCase(Locale.ROOT);//введенная строка текста
        System.out.println("\nЗашифрованное сообщение: ");
        String outputString = cesar(inputString);
        outputString = vijener(outputString, key);
        System.out.println(outputString);
    }

    public static String vijener(String m, String k){
        char[] message = m.toCharArray();//открытое сообщение (массив символов строки)
        String alf = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] alfavit = alf.toCharArray();
        char[] key = k.toCharArray();//массив символов строки ключа
        int d;  //смещение
        int j = 0, f = 0;//переменные для циклов
        int t=0;//переменная нумерации символов ключа

        //преобразование каждого символа сообщения
        for (int i = 0; i < message.length; i++) {
            //поиск индекса буквы
            for (j = 0; j < alfavit.length; j++) {
                if (message[i] == alfavit[j]) {
                    break;
                }
            }

            //если j = 33, весь цикл пройден и символа не найдено
            if (j != 33) {
                if (t > key.length - 1) {
                    t = 0;
                }//когда заканчивается ключ, он начинается заново
                //индекс буквы ключа в алфавите
                for (f = 0; f < alfavit.length; f++) {
                    if (key[t] == alfavit[f]) {
                        break;
                    }
                }
                t++;
                if (f != 33) {
                    d = j + f;//сдвиг буквы на f
                } else {
                    d = j;
                }
                //проверка чтобы при окончании алфавита он начинался сначала
                if (d > 32) {
                    d = d - 33;
                }
                message[i] = alfavit[d];//изменение буквы
            }
        }
        return new String(message);
    }

    public static String cesar(String m){
        char[] message = m.toCharArray();//открытое сообщение (массив символов строки)
        String alf = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] alfavit = alf.toCharArray();
        int d;//смещение
        int j = 0;//переменная для запоминания индекса в цикле - номер в алфавите
        //соответствие буквы из сообщения букве из алфавита
        for (int i = 0; i < message.length; i++) {
            for (j = 0; j < alfavit.length; j++) {
                if (message[i] == alfavit[j]) {
                    break;
                }
            }
            //j=33 - символ не из алфавита не будет преобразован, переход к следующей итерации
            if (j != 33) {
                d = j + 3;//сдвиг
                //проверка чтобы не выйти из алфавита(когда заканчивается алфавит, он начинается сначала)
                if (d > 32) {
                    d = d - 33;
                }
                message[i] = alfavit[d];//изменение буквы
            }
        }
        return new String(message);//возвращение массива сиволов, собранного в строку
    }
}
