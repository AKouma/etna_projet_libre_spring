package com.quest.etna.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quest.etna.model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

}
