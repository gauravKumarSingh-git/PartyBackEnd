package com.party.dto;

import java.util.*;
public class ContactDTO {

    private String name;
	private String description;

    public ContactDTO() {}
	public ContactDTO( String name , String description) {
		super();
		this.name = name;
		this.description = description;     
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
		this.name = name;   
	}   
    public String getdescription() {
        return description;
    }
    public void setdescription(String description) {
		this.description = description;
    }
    @Override
	public int hashCode() {
		return Objects.hash( description, name);
	}
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactDTO other = (ContactDTO) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name);
    }
	@Override
	public String toString() {
        return  "Contact [name=" + name + ", description=" + description + "]";
	}
}
