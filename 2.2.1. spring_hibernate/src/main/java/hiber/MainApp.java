package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      /*userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));*/
      User user1 = new User("Igor", "Abramov", "igor@gmail.com");
      User user2 = new User("Vlad", "Pescov", "pescov@gmail.com");
      User user3 = new User("Ignat", "Abrosimov", "ignat@gmail.com");
      User user4 = new User("Kristina", "Koroleva", "Kristina@gmail.com");
      User user5 = new User("Olya", "Fedosina", "olya@gmail.com");
      Car car1 = new Car("Lada",3310);
      Car car2 = new Car("Mazda",3);
      Car car3 = new Car("Mersedes",111);
      Car car4 = new Car("Ford",2701);
      Car car5 = new Car("Merkurii",55);
      user1.setUserCar(car1);
      user2.setUserCar(car2);
      user3.setUserCar(car3);
      user4.setUserCar(car4);
      user5.setUserCar(car5);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
      userService.add(user5);





      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
         /*System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());*/
         //System.out.println();
      }
      User userget = userService.usercar("Ford", 2701);
      System.out.println("машина асера " + userget);

      context.close();
   }
}
