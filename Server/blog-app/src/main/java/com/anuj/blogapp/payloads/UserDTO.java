package com.anuj.blogapp.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

//DTO-> Data Transfer Object 
//it will use to send user object
//it advantage we not send full object we can send necessary details
public class UserDTO {
	
		private int user_id;
		@NotEmpty
		@Size(min=4, message = "name must be greater than 4")
		private String name;
		@Email(message = "Email is not valid")
		private String email;
		@NotEmpty
		@Size(min=8, message = "Minimum 8 character")
//		@Pattern(regexp = )
		private String password;
		@NotEmpty
		private String about;
				
		
		public UserDTO() {
			super();
		}
		public UserDTO(int user_id, String name, String email, String password, String about) {
			super();
			this.user_id = user_id;
			this.name = name;
			this.email = email;
			this.password = password;
			this.about = about;
		}
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getAbout() {
			return about;
		}
		public void setAbout(String about) {
			this.about = about;
		}
		
	}
