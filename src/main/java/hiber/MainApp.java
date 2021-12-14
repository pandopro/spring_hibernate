package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException, IOException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("S", "Black")));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("X", "Ultra White")));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("A", "Green")));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Z", "Fire Red")));
        userService.add(new User("User5", "Lastname5", "user5@mail.ru", new Car("Z", "Fire Red")));
        List<User> users = userService.listUsers();
        System.out.println("Зарегистрированые пользователи:");
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }
        System.out.println("===");

        String model = "Z";
        String series = "Fire Red";
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Введите модель авто которую нужно найти: ");
//        model = br.readLine();
//        System.out.println("Введите серию авто: ");
//        series = br.readLine();
//        br.close();
        System.out.println("Найденые варианты:");
        users = userService.findUser(model, series);
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }
        context.close();
    }
}
