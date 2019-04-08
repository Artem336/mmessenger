package com.mymessenger.controller;


import com.mymessenger.domain.Message;
import com.mymessenger.domain.User;
import com.mymessenger.repos.MessageRepo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MessageController{
    private static final Logger log = Logger.getLogger(Message.class);


    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/dialog")
    public String getMessages(@RequestParam(name = "chatId",required=false) Long chIdM,
                              @AuthenticationPrincipal User user, Map<String, Object> model) {
        log.debug("Enter chat: "+chIdM);

        if (chIdM.toString().equals(null)){
            return "redirect:/chatsm";
        }else {

        model.put("chIdM",chIdM);
        Iterable<Message> getMessages = messageRepo.findByChatId(chIdM);
        model.put("messages", getMessages);

        return "dialog";
    }}

    @PostMapping("/dialog")
    public String create(@RequestParam( name = "chatId",required=false) Long chIdM,
                         @RequestParam(required = false) String content,
                         @AuthenticationPrincipal User user, Map<String, Object> model) {
            log.debug("Create message, user: "+user.getUId()+"  chat: "+chIdM);
            model.put("chIdM", chIdM);
            Message message = new Message(content, user, chIdM);
            messageRepo.save(message);
            Iterable<Message> getMessages = messageRepo.findByChatId(chIdM);

            model.put("messages", getMessages);

        return "dialog";

    }
}
