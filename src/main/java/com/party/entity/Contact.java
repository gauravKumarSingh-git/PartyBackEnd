package com.party.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Contact {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private String description;

    public Contact(String name , String description) {
        this.name = name;
        this.description = description;
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

}
