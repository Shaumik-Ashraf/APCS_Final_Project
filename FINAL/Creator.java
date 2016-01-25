/* Creator class, creates user GChar


*/
import java.io.*;
import java.util.*;

public final class Creator {

	public static final ArrayList<String> stats = new ArrayList<String>();
	public static final ArrayList<String> traits = new ArrayList<String>();
	public static final ArrayList<String> jobs = new ArrayList<String>();

	private static String message;
	private static String choice;

	private static Scanner in;

	public static String name;
	public static String element;
	public static String best;
	public static String worst;
	public static String job;


	public static void initCreator() {

		in = new Scanner(System.in);
		
		stats.add ("health");
		stats.add ("strength");
		stats.add ("magic");
		stats.add ("defense");
		stats.add ("resistance");
		stats.add ("luck");
		stats.add ("agility");
		
		traits.add ("outgoing");
		traits.add ("optimistic");
		traits.add ("calm");
		traits.add ("carefree");
		traits.add ("malevolent");
		traits.add ("benevolent");
		traits.add ("empty");
		
		jobs.add ("warrior");
		jobs.add ("mage");
		jobs.add ("archer");
		jobs.add ("rogue");
		
		Item.consEquipList();
		Skill.consAllSkills();
		Monster.initMonsters();


	}

	public static GChar characterCreation(){
		
		System.out.print("\033[H\033[2J");
			System.out.flush();

		message = "";
	    	message = "Creating new Character...\nWould you tell me your name?";
	    	System.out.println (message);
	    
		if( in.hasNextLine() ) {
			name = in.nextLine();
		}
	      
		System.out.print("\033[H\033[2J");
		System.out.flush();
		
		message = "Choose your vocation.\n";
		message += "Warrior\n";
		message += "Mage\n";
		message += "Archer\n";
		message += "Rogue\n";
	
	
		do
		{
		
			System.out.println (message);
			System.out.println("Please enter an appropriate response.\n");
		        choice =in.nextLine();
		        choice = choice.toLowerCase(Locale.ENGLISH);
		       	System.out.print("\033[H\033[2J");
					System.out.flush();
		        if ( jobs.contains (choice) ) {
		            job = choice;
		            break;
		        }
		} while (true);
	    

		System.out.print("\033[H\033[2J");
			System.out.flush();
		message = "What do you think is your strongest asset?\n";
		message += "\nHealth\n";
		message += "Strength\n";
		message += "Magic\n";
		message += "Defense\n";
		message += "Resistance\n";
		message += "Luck\n";
		message += "Agility\n";

	    
		do
		{
	      
		System.out.println (message);
		System.out.println("Please enter an appropriate response.\n");
		    choice =in.nextLine();
		    choice = choice.toLowerCase(Locale.ENGLISH);
		    System.out.print("\033[H\033[2J");
				System.out.flush();
		    if ( stats.contains (choice) ) {
		       	best = choice;
		        break;
		        }

	    }while (true);
	    

	    
	    System.out.print("\033[H\033[2J");
			System.out.flush();
	    message = "What do you think is your weakest asset?\n";
		message += "\nHealth\n";
		message += "Strength\n";
		message += "Magic\n";
		message += "Defense\n";
		message += "Resistance\n";
		message += "Luck\n";
		message += "Agility\n";

	    
			do
		{
	      
		System.out.println (message);
		System.out.println("Please enter an appropriate response.\n");
		    choice =in.nextLine();
		    choice = choice.toLowerCase(Locale.ENGLISH);
		    System.out.print("\033[H\033[2J");
				System.out.flush();
		    if ( stats.contains (choice) ) {
		       	worst = choice;
		        break;
		        }

	    }while (true);
	    



	    System.out.print("\033[H\033[2J");
			System.out.flush();
	    message = "Which of the following best describes your character?\n";
		message += "\nOutgoing\n";
		message += "Optimistic\n";
		message += "Calm\n";
		message += "Carefree\n";
		message += "Malevolent\n";
		message += "Benevolent\n";
	       // message += "Empty\n"; // Blank is a secret class.

			do
		{
	      
		System.out.println (message);
		System.out.println("Please enter an appropriate response.\n");
		    choice =in.nextLine();
		    choice = choice.toLowerCase(Locale.ENGLISH);
		    System.out.print("\033[H\033[2J");
				System.out.flush();
		    if ( traits.contains (choice) ) {
		            element = choice;
		            if (element.equals ("outgoing") ){
		            	element = "Fire";
		            }
		            if (element.equals ("optimistic") ){
		            	element = "Wood";
		            }
		            if (element.equals ("calm") ){
		            	element = "Aqua";
		            }
		            if (element.equals ("carefree") ){
		            	element = "Gale";
		            }
		            if (element.equals ("malevolent") ){
		            	element = "Dark";
		            }
		            if (element.equals ("benevolent") ){
		            	element = "Light";
		            }
		            if (element.equals ("empty") ){
		            	element = "Void";
		            }
		       break;
		    }

	    }while (true);
	    

	    System.out.print("\033[H\033[2J");
			System.out.flush();
		
			System.out.println (name);
			System.out.println (element);
			System.out.println (best);
			System.out.println (worst);
			System.out.println (job);
		
		
			GChar cloud = new GChar (name, element, best, worst, job);
	    message = "Hm, so you're " ;
	    message += name;
	    message += "?\n";
	    System.out.println (message);
	    return cloud;
	  
	}  //close characterCreation

	//for testing
	public static void main(String[] args) {

		GChar ch; 


		System.out.println("Start Creator.main()\n");
		
		Creator.initCreator();
		ch = Creator.characterCreation();


		System.out.println("Creator.main() done.\n");

				
	}

}
