package com.mingyisoft.javademo.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * List<User>变List<Integer>
 * @author alexyang
 *
 */
public class StreamDemo2 {
	public static void main(String[] args) {
		List<TempUser> userList = new ArrayList<>(); 
		
		userList.add(new TempUser(1,"a"));
		userList.add(new TempUser(2,"b"));
		userList.add(new TempUser(3,"c"));
		
		List<Integer> reutrnIntegerList = userList.stream().map(TempUser::getId)
			    .collect(Collectors.toList());
		
		for(Integer t : reutrnIntegerList) {
			System.out.println(t);
		}
	}
}

class TempUser{
	public TempUser() {
		
	}
	
	public TempUser(Integer id,String name) {
		this.id = id;
		this.name = name;
	}
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
