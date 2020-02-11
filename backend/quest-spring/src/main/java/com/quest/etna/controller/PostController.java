package com.quest.etna.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quest.etna.customexception.AuthenticateException;
import com.quest.etna.customexception.ParametersNotFound;
import com.quest.etna.model.Post;
import com.quest.etna.model.dto.PostDto;
import com.quest.etna.repositories.PostRepository;
import com.quest.etna.utils.Userutils;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostRepository postRepository;
	
	 @PostMapping("/create_post")
	 @ResponseStatus(HttpStatus.CREATED)
	 public Post createPost(@RequestBody PostDto postDto) {
		 Post post  = null;
		 if(!Userutils.isConnected() || postDto == null || postDto.getTitle() == null || postDto.getContent() == null
		/* || postDto.getCategory() == null */)
			   throw new ParametersNotFound();
		 else {
			 post = new Post();
			 post.setTitle(postDto.getTitle());
			 post.setContent(postDto.getContent());
			 post = postRepository.save(post);
		 }
		 return post;
	 }
	 
	 @GetMapping("/all_posts")
	 @ResponseStatus(HttpStatus.OK)
	 public List<Post> getPosts() {
		 List<Post> posts  = new ArrayList<Post>();
		 if(!Userutils.isConnected())
			   throw new AuthenticateException();
		 else {
			 postRepository.findAll().forEach(posts::add);;
		 }
		 return posts;
	 }

}
