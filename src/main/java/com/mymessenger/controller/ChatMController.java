package com.mymessenger.controller;

import com.mymessenger.domain.ChatM;
import com.mymessenger.domain.User;
import com.mymessenger.repos.ChatMRepo;
import com.mymessenger.repos.UserRepo;
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


    @GetMapping("/")
    public String greeting(@AuthenticationPrincipal User user,Map<String, Object> model) {
        return "greeting"; }


    @GetMapping(path = "/chatsm")
    public String allChats(@AuthenticationPrincipal User user, Map<String,Object> model) {
     model.put("uName",user.getUsername());
        model.put("uId",user.getUId());
        Iterable<ChatM> chats=chatMRepo.findByUsers(user);

        model.put("chatss",chats);
        return "chatsm";
    }

    @PostMapping(path = "/chatsm", params = "add")
    public String addUserInChat(@AuthenticationPrincipal User user, Long user_id,Map<String, Object> model){
        users.add(user);
        if(!userRepo.existsById(user_id)){
            model.put("e","User not found!");
            return "chatsm";
        }
            return "redirect:/chatsm";

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


        Iterable<ChatM> chats=chatMRepo.findByUsers(user);
        model.put("chatss",chats);
        return "chatsm";


    }




}
