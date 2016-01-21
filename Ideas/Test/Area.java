/* Area class
 *
 * Needs Testing!!
 *
 * Usage (so far):
 *	Area a = new TownArea(party)
 *  party = a.callEvent(party); 
 *
 */

import java.util.*;

/*==================Abstract Area Class====================================================================*/
public abstract class Area {

	public String name;
	public Queue<String> qs;
	public Queue<Event> qe;
	public String areatype;
	/* Possible areatypes as of now:
		Empty - default areatype, not to be instantiated
		Town - features TownEvent (To Be Made)
		Field - features NoEvent, CombatEvent, and CavernEvent
		Dungeon - features NoEvent, CombatEvent, ChestEvent, TrapEvent, and CryptEvent
	*/

	public Area() {
		name = "Area";
		//qs = new Queue<String>();
		qe = new Queue<Event>();
		areatype = "Empty";
	}
	
	public String getName() {  //not necessary since name is public but...
		return( name );
	}
	
    public Event seeEvent() {
	return( qe.seek() );
    }

	public abstract ArrayList<GChar> callEvent(ArrayList<GChar> Party);
	
	public abstract void update(ArrayList<GChar> Party);

    //public abstract void restore(); //readd popped Events
	
}

/*==================AreaTown Class====================================================================*/
class TownArea extends Area {

	public static final String[] TOWNNAMESLIST = new String[] 
				{"Town of Beginnings", "Lumbridge", "That Burning Town", "Final Destination"};
	public static String[] townnameslist = TOWNNAMESLIST;
	/*Disclaimer: Townnames from: 
				{SAO, RuneScape, Kid Icurus Uprising, and Super Smash Bros.},
																			respectively
	*/
	
	public TownArea(ArrayList<GChar> party) {
		super();
		name = townnameslist.remove( (int)(Math.random()*townnameslist.length) );
		areatype = "Town";
		qe.add( new TownEvent(party), name );
		qe.add( new TownEvent(party), name );
	}
	
	public ArrayList<GChar> callEvent(ArrayList<GChar> Party) {
		update(Party);
		return( qe.poll().beginEvent() );
	}
	
	public void update(ArrayList<GChar> Party) {
	    String temp_nam = qe.poll().getName();
		qe.add( new TownEvent(party), temp_nam );
	}

}

/*===================AreaField Class====================================================================*/
class AreaField extends Area {

    public static int fieldctr = 0;

    //the following vars are currently incompatible with CombatEvent and spawnMonsters
    //could create another CombatEvent constructor: public CombatEvent(ArrayList<GChar> party, ArrayList<GChar> monsters) {...} 
    public String[] monsterlist;  //array of names of possible monsters to encounter
    public double[] chancespawn;  //chance that monster of corresponding index spawns

    public AreaField(ArrayList<GChar> party) {
	super();
	name = "Field-" + fieldctr; //OR could do "Route-" + fieldctr
	fieldctr++;
	areatype = "field";
	qe.add( new NoEvent(party) );
	qe.add( new NoEvent(party) );
	for(int i=0; i<3; i++) {   //add 3 random events, with 60% CombatEvent, 20% NoEvent, 20% CavernEvent 
	    int r = Math.random();
	    if( r < 0.6 ) {
		qe.add( new CombatEvent(party) );
	    }
	    else if( r < 0.8 ) {
		qe.add( new NoEvent(party) );
	    }
	    else {
		qe.add( new CavernEvent(party) );
	    }
	} //close for-loop
    } //close constructor

    public ArrayList<GChar> callEvent(ArrayList<GChar> party) {
	update(party);
	return( qe.poll().beginEvent() );
    }

    public void update(ArrayList<GChar> party) {
	Event e = qe.poll();
	if( e instanceof CombatEvent ) {
	    qe.add( new CombatEvent(party) );
	}
	else if( e instanceof NoEvent ) {
	    qe.add( new NoEvent(party) );
	}
	//If other Events added to Field, add here
	else {
	    qe.add( new CavernEvent(party) );
	}
    }//close update method

} //close AreaField class

/*===============AreaDungeon========================================================*/

/*
class AreaDungeon extends Area {

    public AreaDungeon(ArrayList<GChar> party) {
	;
    }

    public ArrayList<GChar> callEvent(ArrayList<GChar> party) {
	;
    }

    public void update() {
	;
    }

}
*/
