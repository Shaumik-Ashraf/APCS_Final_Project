/* Creator - static class that creates a character...
*
*
*/

package gameutils;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

import gamechars.*;
//import gameutils.*;
import gameareas.*;
import gameitems.*;
import gameskills.*;

public final class Creator {  //fyi: final class means class cannot be extended

	private static Scanner in = new Scanner(System.in);
	private static String input_buffer = new String();
	private static ArrayList<String> player_builder = new ArrayList<String>();
	//^^ string array formatted: name, class, strongstat, weakstat, trait, 
	
	//create a character by prompting user for preferences and then returning the created character
	public static gChar characterCreation() throws Exception {
	
		//=============================================================================
		//vars
		//=============================================================================
		String message;
		gChar cloud;  //creater character to be returned; also guy from final fantasy
	
	
		//=============================================================================
		//prompts
		//=============================================================================
		//prompt for name
		SO.clearScreen();
		SO.P("What is your name?\n:");
		try {
			player_builder.add(in.nextLine());
		}
		catch( Exception e) {
			System.err.println("IO Error: " + e);
		}
		SO.clearScreen();
		
		//prompt for class
		message = "\nChoose your vocation.\n";
		SO.P(message);
		gamelists.printClasses();
		SO.P("\n:");
		do { //loop for proper input
			SO.println(message);
			if( in.hasNextLine() ) {
				input_buffer = in.nextLine();
			}
			
			if ( gamelists.hasClass(input_buffer) ) {
				player_builder.add(input_buffer);
				break;
			}
			SO.println("Please enter an appropriate response.\n");
			
		} while(1==1);
		SO.clearScreen();

		//prompt for strongest stat
		message = "What do you think is your strongest asset?\n";
		SO.P(message);
		gamelists.printStats();
		SO.P("\n:");
		do {
		
			if( in.hasNextLine() ) {
				input_buffer = in.nextLine();
			}
			
			if ( gamelists.hasStat(input_buffer) ) {
				player_builder.add(input_buffer);
				break;
			}
			SO.println("Please enter an appropriate response.\n");
			
		} while(1==1);
		SO.clearScreen();
		
		//prompt for weakest stat
		message = "What do you think is your weakest asset?\n";
		SO.P(message);
		gamelists.printStats();
		SO.P("\n:");
		do {
			if( in.hasNextLine() ) {
				input_buffer = in.nextLine();
			}
			
			if ( gamelists.hasStat(input_buffer) ) {
				player_builder.add(input_buffer);
				break;
			}
			SO.println("Please enter an appropriate response.\n");
			
		} while(1==1);
		SO.clearScreen();
		
		//prompt for personality - which determines element
		SO.clearScreen();
		message = "Which of the following best describes your character?\n";
		SO.P(message);
		gamelists.printTraits();
		SO.P("\n:");
		do {
		
			if( in.hasNextLine() ) {
				input_buffer = in.nextLine();
			}
			
			if ( gamelists.hasTrait(input_buffer) ) {
				player_builder.add(input_buffer);
				break;
			}
			SO.println("Please enter an appropriate response.\n");
			
		} while(1==1);
		SO.clearScreen();
		
		//Description will be customized to fit what the player inputed previously
		SO.clearScreen();
		message = "Hm, so you're " ;
		message += player_builder.get(0);
		message += "?\n";
		SO.println(message);
		
		//System.err.println("DEBUG: " + builder);
		
		//=============================================================================
		//call appropriate constructor
		//=============================================================================
		//create character with player_builder string array; can make this into seperate function
		try {
			if (player_builder.get(4).equals("Outgoing") ){  //if fire element
				if (player_builder.get(1).equals("Warrior")){
					cloud = new WarriorF(player_builder);
				}			
				else if (player_builder.get(1).equals ("Mage")){
					cloud = new MageF(player_builder);
				}
				
				else if (player_builder.get(1).equals ("Archer")){
					cloud = new ArcherF(player_builder);

				}
				
				else throw new Exception("Exception: Failed to create character;\n");
			}  //close if fire
			
			else if (player_builder.get(4).equals ("Optimistic") ){  //if wood element
				if (player_builder.get(1).equals ("Warrior")){
					cloud = new WarriorW(player_builder);
				}
				
				else if (player_builder.get(1).equals ("Mage")){
					cloud = new MageW(player_builder);
				}
				
				else if (player_builder.get(1).equals ("Archer")){
					cloud = new ArcherW(player_builder);
				}
				else throw new Exception("Exception: Failed to create character;\n");
			}  //close if wood
			
			else if (player_builder.get(4).equals ("Calm") ){   //if aqua element
				if (player_builder.get(1).equals ("Warrior")){
					cloud = new WarriorA(player_builder);
				}
				else if (player_builder.get(1).equals("Mage")){
					cloud = new MageA(player_builder);
					
				}
				
				else if (player_builder.get(1).equals("Archer")){
					cloud = new ArcherA(player_builder);
				}
				else throw new Exception("Exception: Failed to create character;\n");
			}  //close if aqua
			
			else if (player_builder.get(4).equals ("Carefree") ) {  //if gale type
				if (player_builder.get(1).equals ("Warrior")){
					cloud = new WarriorG(player_builder);
				}
				else if (player_builder.get(1).equals("Mage")){
					cloud = new MageG(player_builder);
				}
				else if (player_builder.get(1).equals("Archer")){
					cloud = new ArcherG(player_builder);
				}
				else throw new Exception("Exception: Failed to create character;\n");
			} //close if gale
			
			//INSERT OTHER ELEMENTS AND CLASSES HERE!
				
			else throw new Exception("Exception: Failed to create character;\n");
		} catch( NullPointerException e ) {
			System.err.print("Caught an error!!\n");
			System.err.println(e);
			System.err.println("---------------------\n");
			e.printStackTrace();
			throw e;
		} catch( Exception e ) {
			System.err.print("Caught an error!!\n");
			System.err.println(e);
			throw e;
		}
		
		return(cloud);
		
	}  //close characterCreation method
	


}  //close class

