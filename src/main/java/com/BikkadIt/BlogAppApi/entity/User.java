package com.BikkadIt.BlogAppApi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
      //@entity (name="new entity name")by default entity name is user
      //@table(name="users")to give the different name of table by default table name user
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	     //id will be auto incremented bythe@generatevalue annotation
	private int id;
	
	//if we want to chang the name of column 
	@Column(name="user_name",nullable = false, length = 100)
	private String name;
	
	private String email;
	
	private String password;
	
	private String about;
	
	

}
