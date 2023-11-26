package com.ecomerce.angular.jwt.service;

import com.ecomerce.angular.jwt.dao.RoleDao;
import com.ecomerce.angular.jwt.dao.UserDao;
import com.ecomerce.angular.jwt.entity.Role;
import com.ecomerce.angular.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;
    public User registerNewUser(User user){
        return userDao.save(user);
    }

    /*1. When we restart or re-run application,
        it will deleted all the table in the  database(since we have used 'create' as ddl-auto command)
    2. then this method will be run, here logic of roles and users will be writen
    */

    public void initRolesAndUser(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("user");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword("admin@pass");

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);

        userDao.save(adminUser);

        User user = new User();
        user.setUserFirstName("Kiran");
        user.setUserLastName("Suryawanshi");
        user.setUserName("kiran123");
        user.setUserPassword("kiran@pass");

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);

        userDao.save(user);



    }


}
