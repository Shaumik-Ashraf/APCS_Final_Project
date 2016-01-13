/*
Test Area, Field, and Town class


*/


import java.util.*;
import gamechars.*;
import gamearea.*;
import gameutils.*;
//import gameitems.*;

public final class AreaTester {   //final modifier means class cant be extended; no subclasses


	public static void main(String[] args) {
		
		ArrayList<Area> map = new ArrayList<Area>(10);

		ArrayList<String> sora_builder = new ArrayList<String>();
		sora_builder.add("Sora");
		sora_builder.add("Warrior");
		sora_builder.add("Health");
		sora_builder.add("Health");
		sora_builder.add("Calm");
		gChar sora = new WarriorW( sora_builder ); 


		map.add(0, new Town());
		for(int i=1; i<map.size(); i++) {
			if( Math.random()*100 < 67 ) {
				map.add( i, new Field(i) );  //constructor will create field named field-i
			}
			else {
				map.add( i, new Town(i) ); //likewise, town-i
			}
		}

		for(int i=0; i<map.size(); i++) {
			map.get(i).event(sora);
		}
		
		
		
		
	}
	
	
	
	

}
