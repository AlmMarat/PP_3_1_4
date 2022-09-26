package com.example.spring_3_1_3_bootstrap;

import com.example.spring_3_1_3_bootstrap.entities.Role;
import com.example.spring_3_1_3_bootstrap.entities.User;
import com.example.spring_3_1_3_bootstrap.services.RoleService;
import com.example.spring_3_1_3_bootstrap.services.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UsersInit {

    private final UserService userService;
    private final RoleService roleService;

    public UsersInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void createUsers() {
        Role user = new Role("ROLE_USER");
        Role admin = new Role("ROLE_ADMIN");

        roleService.save(user);
        roleService.save(admin);

        User user1 = new User("oleg", "111");//$2a$12$54rDWKSismZ9uGff8bWwvetMn/YqhjzHl0P3D7JxY8GSyXeI2zM9e
        User user2 = new User("inna", "111");//111//$2a$12$54rDWKSismZ9uGff8bWwvetMn/YqhjzHl0P3D7JxY8GSyXeI2zM9e
        User user3 = new User("irina", "111");//$2a$12$54rDWKSismZ9uGff8bWwvetMn/YqhjzHl0P3D7JxY8GSyXeI2zM9e

        user1.addRole(roleService.findByName("ROLE_ADMIN"));
        user1.addRole(roleService.findByName("ROLE_USER"));
        user2.addRole(roleService.findByName("ROLE_ADMIN"));
        user3.addRole(roleService.findByName("ROLE_USER"));

        user3.setEmail("irina@mail.ru");

        user1.setEmail("oleg@mail.ru");

        user2.setEmail("inna@mail.ru");

        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
    }
}
