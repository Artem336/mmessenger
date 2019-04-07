package com.mymessenger.repos;

import com.mymessenger.domain.ChatM;
import com.mymessenger.domain.User;
import org.springframework.data.repository.CrudRepository;



public interface ChatMRepo extends CrudRepository<ChatM, Long> {
    Iterable<ChatM> findByAuthorMOrderByChIdM(User user);
    Iterable<ChatM> findByUsers(User user);

    boolean existsByChNameAndAuthorM(String chName,User user);


}
