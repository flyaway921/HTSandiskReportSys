package com.sandisk.rpsys.entity;

import java.util.ArrayList;

import org.junit.Test;

public class GroupTest {
	
	@Test
	public void TestGroupEquals(){
		ArrayList<User> members = new ArrayList<User>();
		members.add(new User(1, "adsb", "bbv", "badf"));
		members.add(new User(2, "asdfdsb", "bsdfbv", "bsadfadf"));
		
		Group g1 = new Group("a",1,members);
		Group g2 = new Group("a",1,members);
		System.out.println(g1.hashCode());
		System.out.println(g2.hashCode());
		if(g1.equals(g2))
			System.out.println("equals");
//		System.out.println(GroupTest.class.getClassLoader().getResource(""));
	}
}
