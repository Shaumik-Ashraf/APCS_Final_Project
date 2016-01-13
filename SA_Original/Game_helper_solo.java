/**
 * Game_helper_solo
 * Helper class for Game (solo mode)
 * Will contain bulk of code for actual game play
 * 
 */
package main;

/**
 * @author Shaumik Ashraf
 *
 */
public class Game_helper_solo {

	public static void play() {
		;
		/* IMPLEMENT CODE HERE
		 * 
		 * PLAN:
		 * 	Character goes thru a series of areas
		 *  Each area is either a field or a town
		 *  fields offer (randomly) battling monsters, additionally finding items, harvesting materials, etc.
		 *  towns offer (by choice) healing, merchants, additionally saving, specializing 
		 * 
		 * ALGORITHM
		 * 	abstract class AbstAreaPatch will feature an area, will have subclasses field and town
		 * 		AbstAreaPatch UML
		 * 			String name
		 * 			public AbstAreaPatch(String nam) - constructor
		 * 			public String toString() - overload/overwrite
		 * 			public abstract void event(AbstGameChar gch) - either randomizes an event or lets player choose event  
		 * 		Field extends AbstAreaPatch UML
		 * 			float chanceMonsterEncounter
		 * 			float chanceOtherStuff...
		 * 			public Field(String nam) - constructor
		 * 			public Field(int n) - constructor, generates name: field - n
		 * 			public void event(AbstGameChar gch) - if encounter monster then gch.battle(monster)
		 * 		Town extends AbstAreaPatch UML
		 * 			String[] Options
		 * 			public Town(String nam) - constructor
		 * 			public Town(int n) - constructor, generates name: town - n
		 * 			protected void printOptions() - print options for user
		 * 			protected int getOption() - get users choice of option, returns corresponding index for Options
		 * 			public void event(AbstGameChar gch) - printOptions; getOption; switch(i) {...}
		 *		
		 *  abstract class AbstGameChar implements Battlable will be a playable character
		 * 		AbstGameChar UML
		 * 			protected String name
		 * 			public AbstGameChar() - constructor
		 * 			public AbstGameChar(String nam) - constructor			
		 * 			public String getName() - accessor
		 * 			public void setName(String newName) - mutator 
		 * 			public abstract description() - describe character class
		 * 			
		 * 
		 * 		Warrior extends AbstGameChar
		 * 			 
		 * 			public abstract description() - describe character class
		 * 			
		 * 			
		 * 		Mage extends AbstGameChar
		 * 			 
		 * 			public abstract description() - describe character class
		 * 			
		 * 			
		 * 		Archer extends AbstGameChar
		 * 			 
		 * 			public abstract description() - describe character class
		 * 			
		 * 			
		 * 		
		 * 	interface Battlable will hold stats and battle methods
		 * 		Battlable UML
		 * 			private Float[] Stats or Rational[] Stats
		 * 			
		 * 			public specialize() - alter stats (maybe call awakening?)
		 * 			public normalize() - undo specialize
		 * 			public attack(Battlable opp) - inflicts damage on opp
		 * 			public battle(Battlable opp) - starts battle with opp, asks user for move and preforms it
		 * 
		 * 
		 * */
	}
	
}
