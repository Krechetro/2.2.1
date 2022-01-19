package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {

   public static void main (String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User u1 = new User("KKKK", "KKKKK", "KKKK@gmail.com");
      Car car1 = new Car("ford", 3);
      u1.setCar(car1);
      userService.addUserWithCar(u1, car1);
      User u2 = new User("AAAA", "AAAA", "AAAA@gmail.com");
      Car car2 = new Car("ford", 4);
      u2.setCar(car2);
      userService.addUserWithCar(u2, car2);
      User u3 = new User("BBBB", "BBBB", "BBBB@gmail.com");
      Car car3 = new Car("vaz", 5);
      u3.setCar(car3);
      userService.addUserWithCar(u3, car3);
      User u4 = new User("CCCC", "CCCC", "CCCC@gmail.com");
      Car car4 = new Car("ford", 6);
      u4.setCar(car4);
      userService.addUserWithCar(u4, car4);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println(user.getCar()==null?"Пешеход":user.getCar());
         System.out.println("==========================================================");
      }

      System.out.println("\nИщем User по модели и серии авто.\n"
              + userService.findUserByModelAndSeries("ford", 7));

      context.close();
   }
}