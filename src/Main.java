import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //Объявляем переменные при известных первых двух:
        int num0 = 0;
        int num1 = 1;
        int num2;

        //Первые две переменные выводим вне цикла:
        System.out.print(num0 + " " + num1 + " ");
        for (int i = 3; i <= 10; i++) {
            num2 = num0 + num1;

            //Каждый следующий элемент выводим в цикле:
            System.out.print(num2 + " ");

            //Предыдущим двум переменным присваиваем новые значения:
            num0 = num1;
            num1 = num2;
        }
        System.out.println();

        User[] arr = new User[3]; // создаем массив
        // создание объектов для заполнения массива
        User vania = new User("Иван", 34, "89517238347");
        User vasia = new User("Вася", 56, "89117237341");
        User kolya = new User("Иван", 34, "89497238346");
        // заполнение массива объектами
        arr[0] = vania;
        arr[1] = vasia;
        arr[2] = kolya;
        // создание карты и заполнения ее 
        Map<String, String> users = new HashMap<>();
        // с помощью обычного цикла for
        for (int i = 0; i < arr.length; i++) {
            users.put(arr[i].getPhone(), arr[i].getName());
        }
        // с помощью цикла forich
        for (User user : arr) {
            users.put(user.getPhone(), user.getName());
        }
        // с помощью стримов
        Map<String, String> users1;
        users1 = Stream.of(arr).collect(Collectors.toMap(e -> e.getPhone(), e -> e.getName()));
        System.out.println(users);
        System.out.println(users1);

    }
}