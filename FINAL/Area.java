/* Area class
 *
 * Note: Queue is actually an interface; so I'm changing Queue to linkedlist, which holds the same LIFO properties
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
    //public Queue<String> qs;
	public LinkedList<Event> qe;
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
		qe = new LinkedList<Event>();
		areatype = "Empty";
	}
	
	public String getName() {  //not necessary since name is public but...
		return( name );
	}
	
    public Event seeEvent() {
		return( qe.peek() );
    }

	public abstract ArrayList<GChar> callEvent(ArrayList<GChar> party);
	
	public abstract void update(ArrayList<GChar> party);

    public boolean noMoreEvents() {
		//System.err.print("peek:" + qe.peek());
		return( qe.peek()==null );
    }

    public abstract void restore(ArrayList<GChar> party);
	
	public abstract void arriveAt();
	
}

/*==================AreaTown Class====================================================================*/
class AreaTown extends Area {

	public static final String[] TOWNNAMESLIST = new String[] 
				{"Town of Beginnings", "Lumbridge", "That Burning Town", "Final Destination"};
	public static ArrayList<String> townnameslist = new ArrayList<String>( Arrays.asList(TOWNNAMESLIST) );
	/*Disclaimer: Townnames from: 
				{SAO, RuneScape, Kid Icurus Uprising, and Super Smash Bros.},
				respectively
	*/
	
	public AreaTown(ArrayList<GChar> party) {
		super();
		if( townnameslist.size()==0 ) {
			name = "That Generic Town";
		} 
		else {
			name = townnameslist.remove( (int)(Math.random()*townnameslist.size()) );
		}
		areatype = "Town";
		qe.add( new TownEvent(party, name) );
	}

    public AreaTown(ArrayList<GChar> party, String name_arg) {
		super();
		name = name_arg;
		areatype = "Town";
		qe.add( new TownEvent(party, name) );
    }
	
	public ArrayList<GChar> callEvent(ArrayList<GChar> party) {
		update(party);
		//System.err.print("event update complete...\n");
		return( qe.poll().beginEvent() );
	}
	
	public void update(ArrayList<GChar> party) {
	    //String temp_nam = qe.poll().townname;
	    qe.poll();
		qe.add( new TownEvent(party, name) );
	}

	public void restore(ArrayList<GChar> party) {
		qe.add( new TownEvent(party, name) );
	}
	
	public void arriveAt() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.println("You've arrived at a Town.\n");
	}
	
}

/*===================AreaField Class====================================================================*/
class AreaField extends Area {

    public static int fieldctr = 0;

    //the following vars are currently incompatible with CombatEvent and spawnMonsters
    //could create another CombatEvent constructor: public CombatEvent(ArrayList<GChar> party, ArrayList<GChar> monsters) {...} 
    //public String[] monsterlist;  //array of names of possible monsters to encounter
    //public double[] chancespawn;  //chance that monster of corresponding index spawns

    public AreaField(ArrayList<GChar> party) {
	super();
	name = "Field-" + fieldctr; //OR could do "Route-" + fieldctr
	fieldctr++;
	areatype = "Field";
	qe.add( new NoEvent(party) );
	for(int i=0; i<3; i++) {   //add 3 random events, with 60% CombatEvent, 20% NoEvent, 20% CavernEvent 
	    double r = Math.random();
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

	public void restore(ArrayList<GChar> party) {
		qe.add( new NoEvent(party) );
		for(int i=0; i<3; i++) {   //add 3 random events, with 60% CombatEvent, 20% NoEvent, 20% CavernEvent 
			double r = Math.random();
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
	}
	
} //close AreaField class

/*===============AreaDungeon========================================================*/


class AreaDungeon extends Area {

    //currently incompatible, read Field
    //public String[] monsterlist;
    //public double[] spawnchance; 
    public static int d_num=0;  //dungeon number
    
    public AreaDungeon(ArrayList<GChar> party) {
	super();
	name = "Dungeon";  //IMPROVE
	d_num++;
	areatype = "Dungeon";
	qe.add( new NoEvent(party) );
	if( d_num > 3 && d_num%2==1 ) {  //spawn boss on every odd dungeon after the 3rd
		qe.add( new CombatEvent(party, (int)((d_num-1)/2)) );
	}
	for(int i=0; i<3; i++) {   //add 5 random events: 20% TrapEvent, 20% CryptEvent, 20% ChestEvent, 30% CombatEvent, 10% NoEvent
	    double r = Math.random();
	    if( r < 0.2 ) {
		qe.add( new TrapEvent(party) );
	    }
	    else if( r < 0.4 ) {
		qe.add( new CryptEvent(party) );
	    }
	    else if( r < 0.6 ) {
		qe.add( new ChestEvent(party) );
	    }
	    else if( r < 0.9 ) {
		qe.add( new CombatEvent(party) );
	    }
	    //add other Events here
	    else {
		qe.add( new NoEvent(party) );
	    }
	} //close for-loop
    }

    public ArrayList<GChar> callEvent(ArrayList<GChar> party) {
		update(party);
		return( qe.poll().beginEvent() );
    }

    public void update(ArrayList<GChar> party) {
		Event e = qe.poll();
		if( e instanceof ChestEvent ) {
			qe.add( new ChestEvent(party) );
		}
		else if( e instanceof TrapEvent ) {
			qe.add( new TrapEvent(party) );
		}
		else if( e instanceof CryptEvent ) {
			qe.add( new CryptEvent(party) );
		}
		else if( e instanceof CombatEvent ) {
			qe.add( new CombatEvent(party) );
		}
		//If other Events added to Field, add here
		else {
			qe.add( new NoEvent(party) );
		}
    }

	public void restore(ArrayList<GChar> party) {
		qe.add( new NoEvent(party) );
		for(int i=0; i<3; i++) {   //add 5 random events: 20% TrapEvent, 20% CryptEvent, 20% ChestEvent, 30% CombatEvent, 10% NoEvent
			double r = Math.random();
			if( r < 0.1 ) {
			qe.add( new TrapEvent(party) );
			}
			else if( r < 0.2 ) {
			qe.add( new CryptEvent(party) );
			}
			else if( r < 0.3 ) {
			qe.add( new ChestEvent(party) );
			}
			else if( r < 0.9 ) {
			qe.add( new CombatEvent(party) );
			}
			//add other Events here
			else {
			qe.add( new NoEvent(party) );
			}
		} //close for-loop
	} //close method restore
	
}

