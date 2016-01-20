/* gamelists class
contains LinkedLists/Arraylists of useful things: ie possible actions or moves...

*/

package gameutils;

import java.util.LinkedList;
import java.util.ArrayList;

public class gamelists {

	protected static LinkedList<String> stats = new LinkedList<String>();
	protected static LinkedList<String> traits = new LinkedList<String>();
	protected static LinkedList<String> classes = new LinkedList<String>();
	protected static LinkedList<String> commands = new LinkedList<String>();

	public static void init() {
		stats.add ("Health");
		stats.add("Mana");
		stats.add ("Strength");
		stats.add ("Magic");
		stats.add ("Defense");
		stats.add ("Resistance");
		stats.add ("Luck");
		stats.add ("Agility");
		
		traits.add ("Outgoing");
		traits.add ("Optimistic");
		traits.add ("Calm");
		traits.add ("Carefree");
		//traits.add ("Empty");
		
		classes.add ("Warrior");
		classes.add ("Mage");
		classes.add ("Archer");
		
		commands.add ("Fight");
		commands.add("Pkmn");
		commands.add("Bag");
		commands.add("Run");
	}
	
	public static LinkedList<String> getStatsList() {return(stats);}
	public static LinkedList<String> getTraitsList() {return(traits);}
	public static LinkedList<String> getClassesList() {return(classes);}
	public static LinkedList<String> getCommandsList() {return(commands);}
	
	public static void printStats() {
		for(String s : stats) {
			SO.println(s);
		}
	}
	
	public static void printTraits() {
		for(String s : traits) {
			SO.println(s);
		}
	}
	
	public static void printClasses() {
		for(String s : classes) {
			SO.println(s);
		}
	}
	
	public static void printCommands() {
		for(String s : commands) {
			SO.println(s);
		}
	}
	
	public static boolean hasStats(String s) {
		return( stats.indexOf(s) != -1);
	}
	
	public static boolean hasStat(String s) {
		return( stats.indexOf(s) != -1);
	}
	
	public static boolean hasTraits(String s) {
		return( traits.indexOf(s) != -1);
	}
	
	public static boolean hasTrait(String s) {
		return( traits.indexOf(s) != -1);
	}
	
	public static boolean hasClasses(String s) {
		return( classes.indexOf(s) != -1);
	}
	
	public static boolean hasClass(String s) {
		return( classes.indexOf(s) != -1);
	}
	
	public static boolean hasCommands(String s) {
		return( commands.indexOf(s) != -1);
	}
	
	public static boolean hasCommand(String s) {
		return( commands.indexOf(s) != -1);
	}
	
}
