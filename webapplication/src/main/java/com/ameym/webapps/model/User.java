package com.ameym.webapps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "appuser")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	@SequenceGenerator(name="user_sequence", sequenceName = "usersequence", allocationSize=10)
	@Column(name = "userid", updatable = false, nullable = false)
	private int userId;
	
	private String userName;
	
	@Column(name = "userpassword", length = 20)
	private String password;
	
	@Column(name = "FirstName", length = 20)
	private String firstName;
	
	@Column(name = "lastName", length = 20)
	private String lastName;
	
	@Column(name = "emailid", length = 40)
	private String emailId;
	
	@Column(name = "mobnumber", length = 10)
	private String mobNumber;
	
	public User() {
		
	}
	
	@JsonCreator
	public User(@JsonProperty("userName") String userName, @JsonProperty("password") String password, @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("emailId") String emailId, @JsonProperty("mobNnumber") String mobNnumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobNumber = mobNnumber;
	}


	public int getUserId() {
		return userId;
	}
	/*public void setUserId(int userId) {
		this.userId = userId;
	}*/
	
	@Column(name = "username", length = 20)
	public String getUserName() {
		return userName;
	}
	public void setUserId(String userName) {
		this.userName = userName;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	public String getMobNnumber() {
		return mobNumber;
	}
	public void setMobNnumber(String mobNnumber) {
		this.mobNumber = mobNnumber;
	}
	
	
	 @Override
	 public String toString() {
	  StringBuilder str = new StringBuilder();
	  str.append("userName: " + getUserName());
	  str.append("UserPassword: " + getPassword());
	  str.append("firstName: " + getFirstName());
	  str.append("lastName:- " + getLastName());
	  str.append("Email: " + getEmailId());
	  str.append("mobNumber: " + getMobNnumber());
	  return str.toString();
	 }

}
