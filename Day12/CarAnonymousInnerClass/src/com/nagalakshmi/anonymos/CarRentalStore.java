package com.nagalakshmi.anonymos;

public class CarRentalStore {

	public static void main(String[] args) {
		Audi audi=new Audi("A8", "Red");
		BMW bmw=new BMW("Q5","Blue");
		Toyota toyota=new Toyota("Altis", "Golden");
		
		Driver sonu=new Driver("Sonu");
		Driver ramesh=new Driver("Ramesh");
		Driver maruti=new Driver("Maruti");

		sonu.setCar(audi);
		sonu.drive();
		
		ramesh.setCar(toyota);
		ramesh.drive();
		
		maruti.setCar(bmw);
		maruti.drive();
		
		System.out.println("-----------");
		Car c=new Audi("A9", "Black") {
			@Override
			public void engine() {
				System.out.println("\n Audi model : "+getModel()+" Color: "+getColor());
				System.out.println(" Audi engine goes aooooom!!");
			}
		};
		
		sonu.setCar(c);
		sonu.drive();
		
		System.out.println("-----------");
		Car c1=new Toyota("T20", "Silver") {
			@Override
			public void engine() {
				System.out.println("\nToyota model : "+getModel()+" Color: "+getColor());
				System.out.println("Toyota engine goes Tooooom!!");
			}
		};
		
		ramesh.setCar(c1);
		ramesh.drive();
		
		System.out.println("-----------");
		Car c2=new Audi("BMW15", "White") {
			@Override
			public void engine() {
				System.out.println("\nBMW model : "+getModel()+" Color: "+getColor());
				System.out.println("BMW engine goes booooom!!");
			}
		};
		
		ramesh.setCar(c2);
		ramesh.drive();
		
	}

}
