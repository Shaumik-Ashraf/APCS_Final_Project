/* 
 * My commenting formats so inconsistent...
 *
 * class Field - subclass of area where players encounter monsters and battle
 * 
 *
 * ASSUMES BATTLE METHOD
 *
 *
 */

package gamearea;
 
import java.util.ArrayList;

import gamechars.*;
import gameutils.*;
 
public class Field extends Area {

    //RECREATE with HashTable

	//attributes
    Hashtable<Monster, Double> Encounters;  //possible encounters
	
	//constructors
	public Field() {
		super("Field");
		areatype = AT_FIELD;
	}
	
	public Field(String name_arg) {
		super(name_arg);
		areatype = AT_FIELD;
		
	}
	
	//creates numbered fields named Field-n; ie Field-1, Field-2...
	public Field(int n) { 
		super("Field-" + n);
		areatype = AT_FIELD;
	}
	
	//creates a field that features only mon with a chance chance of encounter
	public Field(String name_arg, Monster mon, Double chance) {  
		name = name_arg;
		areatype = AT_FIELD;
		Encounters.put(mon, chance);
	}
	
	//creates field with chances and monsters determined by args
	//assumes mons and chances are of same length
	public Field(String name_arg, Monster[] mons, Double[] chances) {
		name = name_arg;
		areatype = AT_FIELD;
		for(int i=0; i<mons.length; i++) {
			Encounters.put(mons[i], chances[i]);
		}
	}
	
	//protected void recalibrateChances() {}
	/* Suppose there was a .1 chance encountering monster A and .1 chance encountering monster B,
		My code first checks if random()<.1; if true then battle monster A
		
		if the first is false and I use if-else ladder, then if I check for random()<.1 to encounter B
			B's actual chance of occurance is 0.9(A false) * 0.1(B true)
	
		if the first is true and I use consecutive if statements, then if random()<.1 for B, I can encounter
			both A and B in only one possible encounter (which is not intended)
			
		The method should compensate for this
	*/
	
	
	//event and description methods
	public void event(gChar gch) {
		
		double r;
		int i, j;
		
		for(i=0; i<3; i++) { //3 possibilities for encounters
			
		    r = (double)Math.random();
			
		    /**
			CONTINUE HERE
			*/
			
		}
		
	}
	
	public void description() {
		SO.P(name + ": Think RuneScape wilderness.\n");  //good enuf
	}
	
}
