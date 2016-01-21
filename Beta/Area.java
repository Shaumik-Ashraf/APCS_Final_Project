/* Area class
 *
 * Needs Testing!!
 *
 * Usage (so far):
 *	Area a = new TownArea(party)
 *  party = a.callEvent(party); 
 *
 */

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
	
	public abstract ArrayList<GChar> callEvent(ArrayList<GChar> Party);
	
	public abstract void update(ArrayList<GChar> Party);
	
}

/*==================AreaTown Class====================================================================*/
public class TownArea extends Area {

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
		update();
		return( qe.poll().beginEvent() );
	}
	
	public void update(ArrayList<GChar> Party) {
		String temp_nam = qe.poll().getName()
		qe.add( new TownEvent(party), temp_nam );
	}

}

/*=====*/
