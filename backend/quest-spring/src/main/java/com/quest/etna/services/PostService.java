package com.quest.etna.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.etna.model.Category;
import com.quest.etna.model.Post;
import com.quest.etna.repositories.CategoryRepository;
import com.quest.etna.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	PostRepository postRepository;
	
	public void setPostCategories(List<Post> posts) {
		if(posts != null && !posts.isEmpty())
		for(Post post : posts) {
			//Category category = categoryRepository.findById(post.get))
		}
	}

}
