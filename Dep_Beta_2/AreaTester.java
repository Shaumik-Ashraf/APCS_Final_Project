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
		
		int areamap_len = 10;
		ArrayList<Area> areamap = new ArrayList<Area>(areamap_len);

		ArrayList<String> sora_builder = new ArrayList<String>();
		sora_builder.add("Sora");
		sora_builder.add("Warrior");
		sora_builder.add("Health");
		sora_builder.add("Health");
		sora_builder.add("Calm");
		gChar sora = new WarriorW( sora_builder ); 


		areamap.add(0, new Town());
		for(int i=1; i<areamap_len; i++) {
			if( Math.random()*100 < 67 ) {
				areamap.add( i, new Field(i) );  //constructor will create field named field-i
			}
			else {
				areamap.add( i, new Town(i) ); //likewise, town-i
			}
		}

		System.err.println("DEBUGGING: " + areamap);

		for(int i=0; i<areamap_len; i++) {
			System.err.print("DEBUGGING: looping area event: " + i + "\n");
			areamap.get(i).event(sora);
		}
		
		
		
		
	}
	
	
	
	

}
