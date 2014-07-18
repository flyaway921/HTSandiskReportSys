package com.sandisk.rpsys.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable{
	
	private String name;
	private Integer id;
	//save java object to table grop members field
	private ArrayList<User> members;
	
	
	public Group(){}
	
	public Group(String name, Integer id, ArrayList<User> members) {
		super();
		this.name = name;
		this.id = id;
		this.members = members;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((members == null) ? 0 : members.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Group other = (Group) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (members == null) {
			if (other.members != null)
				return false;
		} else if (!members.equals(other.members))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Group [name=" + name + ", id=" + id + ", members=" + members
				+ "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ArrayList<User> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<User> members) {
		this.members = members;
	}
	
	public void addMember(User user){
		this.members.add(user);
	}
	
	public void removeMember(User user){
		this.members.remove(user);
	}
	

	
}
