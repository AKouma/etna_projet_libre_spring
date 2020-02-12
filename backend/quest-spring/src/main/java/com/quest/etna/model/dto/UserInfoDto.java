package com.quest.etna.model.dto;
import java.util.List;

import com.quest.etna.model.Comment;
import com.quest.etna.model.Post;
import com.quest.etna.model.User;

public class UserInfoDto {
	
	private User user;
    private List<Comment> comments;
    private List<Post> posts;
      
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
      
      

}
