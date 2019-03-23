package com.mymessenger.repos;

import com.mymessenger.domain.Mtest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Mtest, Long> {

    List<Mtest> findByTag(String tag);

}
