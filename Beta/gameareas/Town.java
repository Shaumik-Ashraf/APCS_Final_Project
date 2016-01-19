/*
 class Town - subclass of area that allows player to rest or continue; later add shopping and saving
 This version is for Ideas
 
*/

package gameareas;


import java.util.*;

import gameutils.*;
import gamechars.*;
import gameskills.*;
import gameitems.*;
//import gameareas.*;

public class Town extends Area {

	//attributes
	//a list of possible Town names; Disclaimer: Town names from SAO, RS, Kid Icarus Uprising, and Super Smash Brothers, respectively
	private final String[] TownNames = new String[] {"Town of Beginnings", "Lumbridge", "That Burning Town", "Final Destination"};
	private boolean response = false;
	
	//constructor
	public Town(String name_arg) {
		super(name_arg);
	}
	
	public Town(int n) {   //creates numbered towns named Town-n; ie Town-1, Town-2...
		super("Town-" + n);
	}

	public Town() {  //create a town with a random name from TownNames
		String newName = TownNames[ (int)(Math.random()*TownNames.length) ];
		name = newName;
	}
	
	//overload toString
	public String toString() {
		return( name );
	}
	
	//define event and description methods
	public void event(gChar gch) {
		
		Scanner event_sc = new Scanner(System.in);
		String buffer = new String();
		
		description();
		
		SO.P("What would you like to do?\n");
		SO.P("Rest\n");
		SO.P("Continue\n\n");
		//ADD MORE OPTIONS FOR TOWN HERE! GAMELIST THIS!
		SO.P(":");
		
		while(!response) {  //loop until proper response recieved
		
			try {
				if( event_sc.hasNextLine() ) {
					buffer = event_sc.nextLine();
				}
			} catch( Exception e) {
				//not sure how to handle...
				System.err.println("Error! " + e);
			}
			
			//case sensitivity?
			
			if( buffer.equals("Rest") ) {
				SO.P("resting...\n");
				gch.normalize(); //restore HP
				//do anything else?
				
				try {  //pause code for 1 sec
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					//Thread.thisThread.interrupt();
					//not sure how to handle
				}
				
				SO.P("Rested!\n");
				response = true;
			}
			else if( buffer.equals("continue") ) {
				SO.P("continuing to next area.\n");
				response = true;
			}
			//ADD MORE OPTIONS HERE!
			else {
				SO.P("Incorrect Input.\n");
			}
			
		}
		
	}
	
	public void description() {
		SO.P(name + ": A safe, bustling, adventurer-hub town.\n"); //to be improved
	}
	
}


