package com.nagalakshmi.setdemo;

import java.util.Set;
import java.util.TreeSet;

import java.util.Iterator;

public class CDTreeSet {

	public static void main(String[] args) {
		Set<CD> cdData=new TreeSet<CD>();
		
		cdData.add(new CD(1001,"CD1","Author A",2.5));
		cdData.add(new CD(1002,"CD2","Author B",2.45));
		cdData.add(new CD(1003,"CD3","Author C",3.10));
		cdData.add(new CD(1004,"CD4","Author D",4.9));
		cdData.add(new CD(1005,"CD5","Author A",2.45));
		cdData.add(new CD(1001,"CD1","Author A",2.5));
		cdData.add(new CD(1006,"CD6","Author A",5.0));
		
		System.out.println("Total number of CDS: "+cdData.size());
		
		System.out.println(cdData);
		
		System.out.println("Iteration Using For Each");
		for(CD element:cdData) {
			System.out.println(element);
		}
		
		System.out.println("Iteration Using Iterator");
		//iterator() : factory method : Factory Design Pattern
		Iterator<CD> iterator=cdData.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}
