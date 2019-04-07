package com.mymessenger.controller;

import com.mymessenger.domain.ChatM;
import com.mymessenger.domain.User;
import com.mymessenger.repos.ChatMRepo;
import com.mymessenger.repos.UserRepo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class ChatMController {
    private static final Logger log = Logger.getLogger(ChatMController.class);

    @Autowired
    private ChatMRepo chatMRepo;

    @Autowired
    private UserRepo userRepo;

    static Set<User> users = new HashSet<User>();



    @GetMapping(path = "/chatsm")
    public String allChats(@AuthenticationPrincipal User user, Map<String,Object> model) {
        log.debug("List chatsM from: "+user.getUId());
        model.put("uName",user.getUsername());
        model.put("uId",user.getUId());
//        Iterable<ChatM> chats=chatMRepo.findByAuthorMOrderByChIdM(user);
        Iterable<ChatM> chats=chatMRepo.findByUsers(user);

        model.put("chatss",chats);
        return "chatsm";
    }

    @PostMapping(path = "/chatsm", params = "add")
    public String addUserInChat(@AuthenticationPrincipal User user, Long user_id){
        users.add(user);
       // while (true){
            users.add(userRepo.findByUId(user_id));
            log.debug("user"+user_id+"добавлен в чат");
            return "redirect:/chatsm";
        //}
    }

    @PostMapping(path = "/chatsm", params = "create")
    public String createCh(@AuthenticationPrincipal User user,
                           @RequestParam String chName, Map<String, Object> model) {

        model.put("uName",user.getUsername());
        model.put("uId",user.getUId());
        ChatM chatM=new ChatM(chName,user,users);
        if(chatM.getChName().isEmpty()){return "redirect:/chatsm";}


        if(chatMRepo.existsByChNameAndAuthorM(chatM.getChName(),chatM.getAuthorM())){
            model.put("window","Chat exist");
            return "chatsm";
        }

        chatMRepo.save(chatM);
        users.clear();

        log.debug("created chat with name "+chatM.getChName());

//        Iterable<ChatM> chats=chatMRepo.findByAuthorMOrderByChIdM(user);
        Iterable<ChatM> chats=chatMRepo.findByUsers(user);
        model.put("chatss",chats);
        log.info("create chatm");
        return "chatsm";


    }




}
