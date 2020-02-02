package com.mymessenger.controller;

import com.mymessenger.domain.Role;
import com.mymessenger.domain.User;
import com.mymessenger.repos.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    private static final Logger log = Logger.getLogger(RegistrationController.class);

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String,Object> model){
        log.info("Registration user");
        User userfromDB =userRepo.findByUsername(user.getUsername());
        if (userfromDB!=null){
            model.put("message","User exist!");   //если пользователь уже есть в бд то сообщение(опр в registration.mustache)
            return "registration"; }
        //изменить
        if(user.getUsername().isEmpty()||user.getName().isEmpty()||user.getPassword().isEmpty()){
            model.put("message","Empty fields");
            return "registration";}
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        log.debug("User: "+user.getUId()+" is registered");
        return "redirect:/login";

    }
}
