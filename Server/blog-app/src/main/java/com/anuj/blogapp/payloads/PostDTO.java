package com.anuj.blogapp.payloads;

import java.util.Date;

import com.anuj.blogapp.entity.Category;
import com.anuj.blogapp.entity.User;


public class PostDTO {
	
	private Integer postId;
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	private Category category;
	private User user;
	
	
	public PostDTO() {
		super();
	}


	public PostDTO(String title, String content, String imageName, Date addedDate, Category category, User user, Integer postId) {
		super();
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.category = category;
		this.user = user;
		this.postId = postId;
	}


	public Integer getPostId() {
		return postId;
	}
	

	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	
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


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public Date getAddedDate() {
		return addedDate;
	}


	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	

}
