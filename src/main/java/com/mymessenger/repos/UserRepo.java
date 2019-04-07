package com.mymessenger.repos;

import com.mymessenger.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
    User findByUId(Long uId);

}
