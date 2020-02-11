package com.quest.etna.model.dto;

import java.util.Set;

import com.quest.etna.model.Category;
import com.quest.etna.model.Comment;
import com.quest.etna.model.User;

public class PostDto {
	
	 private String title;

	 private String content;
	 
	 private User user;
		  
	 private Category category;
     
	 private Set<Comment> comments;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}
