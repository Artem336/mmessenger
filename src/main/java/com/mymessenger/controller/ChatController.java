//package com.mymessenger.controller;
//
//import com.mymessenger.domain.Chat;
//import com.mymessenger.domain.User;
//import com.mymessenger.repos.ChatRepo;
//import com.mymessenger.repos.UserRepo;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import java.util.Iterator;
//import java.util.Map;
//
//
//
//@Controller
//public class ChatController {
//    private static final Logger log = Logger.getLogger(ChatController.class);
//
//
//    @Autowired
//    private ChatRepo chatRepo;
//
//    @Autowired
//    private UserRepo userRepo;
//
//
//    @GetMapping("/")
//    public String greeting(@AuthenticationPrincipal User user,Map<String, Object> model) {
//        return "greeting"; }
//
////addlinks=ready
//    @GetMapping("/chats")
//    public String allChats(@AuthenticationPrincipal User user, Map<String,Object> model) {
//        log.debug("List chats from: "+user.getUId());
//        model.put("uName",user.getUsername());
//        model.put("uId",user.getUId());
//        Iterable<Chat> chatsOfAuthorAndOfAddresseeIdOderById=chatRepo.findByAuthorOrAddresseeIdOrderByChId(user,user.getUId());
//        model.put("chatss",chatsOfAuthorAndOfAddresseeIdOderById);
//        return "chats";
//    }
//
//    @PostMapping("/chats")
//    public String createCh(@RequestParam (required = false) Long addresseeId,
//                           @AuthenticationPrincipal User user,
//                           Map<String, Object> model) {
//        log.info("create chat");
//        model.put("uName",user.getUsername());
//        model.put("uId",user.getUId());
//        Chat chat = new Chat(user,addresseeId);
//        if(userRepo.findByUId(addresseeId)==null){
//            model.put("window","User not found!");
//            return "chats";
//        }
////addunique=ready
//        if (chatRepo.existsByAddresseeIdAndAuthor(addresseeId,user)||chatRepo.existsByAddresseeIdAndAuthor(user.getUId(),userRepo.findByUId(addresseeId))){
//            model.put("window","Chat exist!");
//            return "chats";}
//
//        chat.setCh_name(chat.getAuthorn()+"("+chat.getAuthor().getUId()+")"+" - "
//                + userRepo.findByUId(addresseeId).getUsername()+"("+addresseeId+")");
//        chatRepo.save(chat);
//
//        Iterable<Chat> chatsOfAuthorAndOfAddresseeIdOderById=chatRepo.findByAuthorOrAddresseeIdOrderByChId(user,user.getUId());
//        model.put("chatss",chatsOfAuthorAndOfAddresseeIdOderById);
//
//        return "chats";
//
//
//}}
