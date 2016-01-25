/* Legendairy - does the heavy lifting of legends
 * 
 * Notes:
 * Version 2! mainly testing area!!
 * 
 *
 */


//java 7 api 
import java.io.*;
import java.util.*;


public class Legendairy2 {

	public Event e;
	public GChar c1;
	public GChar enemy;

	private Scanner in;


	//constructor - runs game
	public Legendairy2() {

		ArrayList<GChar> party = new ArrayList<GChar>();
		in = new Scanner(System.in);
		boolean hasSeed = false;
		long ws = (new Random()).nextLong(); //world seed
		
		/* Called by Creator.initCreator();
		Item.consEquipList();
		Skill.consAllSkills();
		Monster.initMonsters();
		*/
		Creator.initCreator();
		
		System.out.println("Now creating your world!\nPlease enter a world generator seed (long number, will default to 1234 in any other case):");
		do {
			try 
			{
				if( in.hasNextLong() ) {
					ws = in.nextLong();
					hasSeed = true;
					break;
				}
				ws = 1234;
				break;
			} catch(Exception e) {}

		} while( !hasSeed );
		
		try 
		{
			party = newGame();
			playWorld(party);			
		} catch(Exception e) {System.out.println("Your party has died. Game Over.");}
		
		System.out.print("Good Game.\n");
		
		
	}

	public ArrayList<GChar> newGame() {
	
		//-----------------INTRO/TUTORIAL
		ArrayList<GChar> party = new ArrayList<GChar>();
		c1 = Creator.characterCreation();
		party.add(c1);
		System.out.println(c1.name + " has joined the party!\n\n");
	
		System.out.println("You open your crusty eyelids as if you have woken from a long sleep. You find yourself in a dark, gloomy room.");
		e = new NoEvent(party);
		party = e.beginEvent();
		System.out.println("You wander out of the room and find yourself in a long hallway. You can only see so far down the hallway before an obscuring darkness clouds it.");
		System.out.println("You hear shuffling noises. What do you do?\nRun\nHide\n");
		while(true)
		{
			String input = in.nextLine();
			if (input.toLowerCase().equals("run"))
			{
				System.out.println("The noises chase after you. Suddenly, you are caught, as the shuffling noises change into heavy footsteps, which in turn manifest themselves as insidious creatures in your vision. \nYou are attacked.");
				break;
			}
			else if (input.toLowerCase().equals("hide"))
			{
				System.out.println("The shuffling noises grow louder and louder, and then grow softer. Then you hear a lighter shuffling approach you again as you hide behind a door. That shuffling quicky becomes the footsteps of a single entity. \nThe door creaks open as you and a horrible creature look into each other's eyes.\nThe creature lets out a hideous scream and its comerades rush to its aid.\nYou are attacked.");
				break;
			}
			else
			{
				System.out.println("Input a valid response.");
			}
		}

		e = new CombatEvent(party, true);
		party = e.beginEvent();
	
		//String delay = in.nextLine(); //////////////////
		System.out.print("\033[H\033[2J");
			System.out.flush();     
		System.out.println("You are heavily damaged. You lay on the floor as yet another entitiy hobbles toward you. There is nothing you can do.");
		System.out.println("'Hello there...' it says. Take this, and come with me.");
		c1.getInventory().giveItem(new EffectItem("Lesser Healing Potion"));
		System.out.println("'Go on, drink it. You'll have to wait for its effects to kick in. We can stay here for now.");
		c1.HP = (int)(c1.HP/2) + 1;
		int hptemp = c1.HP;
		while (c1.HP == hptemp)
		{
		System.out.println("Access your items to use the potion. Then, wait for the potion to do its work");
		e = new NoEvent(party);
		party = e.beginEvent();
		}
		System.out.println("You feel much better.");
		System.out.println("'Now come with me,' he says...\n Now who is he?\n");
		System.out.println("Press any key to enter character Creation.");
		String delay = in.nextLine();
		GChar c2 = Creator.characterCreation();
		party.add(c2);
		System.out.println(c2.name + " has joined the party!");
		e = new CombatEvent(party);
		party = e.beginEvent();
		//----------------------------END TUTORIAL
	    
		return( party );
	
	}

	public void playWorld(ArrayList<GChar> p) {

		World w = new World(p);
	
		System.out.print("World created\nx:" + w.player_x_cor + ", y:" + w.player_y_cor + "\n\n");
		
		for(int turn=0; turn<10; turn++) {
			System.err.println("turn: " + turn);
			if( (w.getArea()).noMoreEvents() ) {  //player cleared area...
				
				w.getArea().restore(p);
				
				System.out.println("You have cleared the area!\nWhere would you like to go?\n");
				System.out.print("North\nSouth\nEast\nWest\nStay here\n\n:");
				
				if( in.hasNextLine() ) {  //prompt for direction to travel
					switch( in.nextLine() ) {
						case "North":
							w.player_y_cor--;
							if( w.player_y_cor<0 ) {
								w.player_y_cor = w.world_size-1;
							}
							break;
						case "South":
							w.player_y_cor++;
							w.player_y_cor %= w.world_size;
							break;
						case "East":
							w.player_x_cor++;
							w.player_x_cor %= w.world_size;
							break;
						case "West":
							w.player_x_cor--;
							if( w.player_x_cor<0 ) {
								w.player_x_cor = w.world_size-1;
							}
							break;
						case "Stay here":
							break;
						default:
							System.out.println("This isnt your GPS! Please enter a proper direction.\n");
							break;
					} //close switch-case
				} //close if input
				
			} //close if player cleared area
			
			else {
				System.err.print("Calling area event\n");
				p = w.getArea().callEvent(p);
				System.err.print("event calling complete\n");
			}
			
		} //close loop
	
		System.out.println("Done\n");
	
	
	}
	
	public static void main (String[] args){

	    Legendairy2 game = new Legendairy2();

	} //close main


}//close class



