package com.stiggley.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "STIGGLEY_USER")
@SequenceGenerator(name = "stiggley_user_seq_name", sequenceName = "stiggley_user_seq", initialValue = 5, allocationSize = 1)
public class StiggleyUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stiggley_user_seq_name")
	private Integer id;

	@Email
	@NotNull
	@Column(name = "email", unique = true)
	private String email;

	@NotNull
	@Column(name = "username")
	private String username;

	@NotNull
	@Column(name = "password")
	private String password;

	public StiggleyUser() {

	}

	public StiggleyUser(String email, String username, String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public StiggleyUser(Integer id, String email, String username, String password) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StiggleyUser other = (StiggleyUser) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StiggleyUser [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ "]";
	}

}
