import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {



        List<Users> lstUser = new ArrayList<>();
        lstUser.add(new Users("Pavel","Koval", "м", 42));
        lstUser.add(new Users("Anna", "Ivanova", "ж", 28));
        lstUser.add(new Users("Sergey", "Petrov", "м", 35));
        lstUser.add(new Users("Maria", "Sidorova", "ж", 68));
        lstUser.add(new Users("Ivan", "Kozlov", "м", 25));
        lstUser.add(new Users("Olga", "Smirnova", "ж", 30));
        lstUser.add(new Users("Dmitry", "Mikhailov", "м", 50));
        lstUser.add(new Users("Elena", "Popova", "ж", 33));
        lstUser.add(new Users("Maxim", "Kuznetsov", "м", 38));
        lstUser.add(new Users("Natalia", "Orlova", "ж", 22));
        lstUser.add(new Users("Andrey", "Sokolov", "м", 45));
        lstUser.add(new Users("Tatiana", "Novikova", "ж", 29));
        lstUser.add(new Users("Vladimir", "Fedorov", "м", 55));
        lstUser.add(new Users("Yulia", "Zaitseva", "ж", 67));
        lstUser.add(new Users("Petr", "Prokhorov", "м", 70));
        lstUser.add(new Users("Irina", "Volkova", "ж", 27));
        lstUser.add(new Users("Alexey", "Bogdanov", "м", 36));
        lstUser.add(new Users("Ekaterina", "Golubeva", "ж", 39));
        lstUser.add(new Users("Nikita", "Ilyin", "м", 32));
        lstUser.add(new Users("Svetlana", "Lobanova", "ж", 44));

        System.out.println(lstUser.get(5));


        System.out.println(lstUser.stream().allMatch(u->u.getAge()>18 && u.getSex().equals("м") ));

        //пропускаем первые 5 элементов и выводим первый
        System.out.println(lstUser.stream().skip(5).findFirst().orElse(null));

        //фильтр, вводит количество женщин за 40
        System.out.println("количество женщин за 40: "+lstUser.stream().filter(u ->u.getAge()>40&&u.getSex().equals("ж")).count());

        List<Users> lstUsers2 = lstUser.stream()
                .filter(u -> u.getAge()<30)
                .sorted()//вызывает метод compareTo в классе Users
                .collect(Collectors.toList());

        lstUsers2.stream().forEach(System.out::println);

        System.out.println("количество работоспособных мужчин "+lstUser.stream().filter(u -> u.getSex().equals("м")&&u.getAge()<65).count());

        List<Users> lstUsers3 = lstUser.stream()
                .filter(u -> u.getSex().equals("ж"))
                .map(u-> new Users(u.getName(),"asd",u.getSex(),u.getAge()))
                .collect(Collectors.toList());
        lstUsers3.stream().forEach(users -> System.out.println(users));


    }
}