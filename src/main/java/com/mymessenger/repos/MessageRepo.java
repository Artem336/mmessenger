package com.mymessenger.repos;
import com.mymessenger.domain.User;

import com.mymessenger.domain.Message;
import org.springframework.data.repository.CrudRepository;




public interface MessageRepo extends CrudRepository<Message, Long> {

    Iterable<Message> findAll();

    Iterable<Message> findByAuthor(User user);
    Iterable<Message> findByChatId(Long chatId);
    //Iterable<Message> findByChIdM(Long chIdM);


}
