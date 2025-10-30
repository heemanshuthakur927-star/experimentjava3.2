package com.example.pblj;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.pblj.config.AppConfig;
import com.example.pblj.entity.User;
import com.example.pblj.service.UserService;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        // Create
        userService.save(new User("Alice", "alice@gmail.com"));
        userService.save(new User("Bob", "bob@gmail.com"));

        // Read
        System.out.println("All Users:");
        userService.list().forEach(System.out::println);

        // Update
        User u = userService.get(1);
        u.setEmail("alice_updated@gmail.com");
        userService.update(u);

        // Delete
        userService.delete(2);

        System.out.println("\nAfter Update/Delete:");
        userService.list().forEach(System.out::println);

        context.close();
    }
}
