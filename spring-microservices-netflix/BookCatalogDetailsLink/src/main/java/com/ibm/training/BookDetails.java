package com.ibm.training;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookDetails {

	
	String name;
	
		String description;
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		
		Integer id;

		public BookDetails()
		{
			
		}
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public BookDetails(String name, String description, Integer id) {
			this.name = name;
			this.description = description;
			this.id = id;
		}

		


	}

