package com.party.entity;

import java.util.*;

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
    @Override
	public int hashCode() {
		return Objects.hash(description, name);
	}
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(description, other.description)
				&& Objects.equals(name, other.name);
    }
    	@Override
	public String toString() {
		return  "name=" + name + ", description=" + description + ",  "]";
	}

}
