/* Battler.java
Class for battling

*/

package gameutils;

import java.util.*;

import gamechars.*;
//import gameutils.*;
import gameskills.*;
import gameitems.*;
import gameareas.*;

public final class Battler {

	//Field=============================================================
	private static Scanner sc = new Scanner(System.in);
	private static String input;

	/*==================================================================
	  static methods
	==================================================================*/
    
	//prompts player for what to do in battle and does it
	public static void doBattleTurn(gChar player, gChar enemy) {
		
		SO.P("What would you like to do?\n\n");
		/*Options are: Fight, Pkmn, Bag, Run; from gamelists.commands*/
		gamelists.printCommands();
		
		do {
			if( sc.hasNextLine() ) {
				input = sc.nextLine();
			}
		
			//check for proper input, if proper break loop and continue on, otherwise continue loop
			if( gamelists.hasCommand(input) ) {
				break;
			}
			else {
				SO.P("That pokemon game's words echoed in your mind... There is a time and place for everything.\n");
			}
			
		} while (1==1);
	
		//have user's gChar perform response
		if( "Fight".equals(input) ) {
			SO.P("Select a skill to use:\n");
			for(String s : player.SkillSet) {
				SO.println(s);
			}
			if(sc.hasNextLine()) {
				input = sc.nextLine();
			}
			do {  //prompt for skill to use
				if( player.SkillSet.indexOf(input)!=-1 ) {//if in SkillSet
					break;
				}
				else {
					SO.P("Your pokemon doesn't know that move...\n");
					continue;
				}
			} while( 1==1 );
			Skill.activateSkill(player, enemy, input);
		}  //close if Fight
		else if( "Bag".equals(input) ) {
			player.useItem();
		}
		else if( "Pkmn".equals(input) ) {
			SO.P("Thats the wrong game!\nYou ended up doing nothing due to this shocking realization...\n");
		}
		else if( "Run".equals(input) ) {
			SO.P("No... there is no running from a trainer battle.\n");
		}
		else ;
		
		
	} //close doBattleTurn method
	
	//does battle between player and enemy
	//assumes player is user and enemy is AI
	//does not incorporate exp, type ads/disads, or leveling as of now
	public static void battle(gChar player, gChar enemy) {
	
		SO.P("Enemy " + enemy + " encountered!\n");
		
		do {

			//invoke faster one's turn
			if( player.isFasterThan(enemy) ) {
				Battler.doBattleTurn(player, enemy);
			}
			else {
				//have enemy do stuff; can make better AIs later
				SO.P("It is the enemy's turn");
				Skill.activateSkill(player, enemy, "Basic Attack");
			}
			
			//invoke slower one's turn
			if( player.isFasterThan(enemy) ) {
				//have enemy do stuff; can make better AIs later
				SO.P("It is the enemy's turn");
				Skill.activateSkill(player, enemy, "Basic Attack");
			}
			else {
				Battler.doBattleTurn(player, enemy);
			}

			//check if anyone is dead
			if( !enemy.isAlive() && !player.isAlive() ) {
				SO.P("Draw...\n");
				break;
			}
			if( !enemy.isAlive() ) {
				SO.P("Enemy is dead\n");
				break;
			}
			if( !player.isAlive() ) {
				SO.P("You are dead\n");
				break;
			}
			
			SO.P("End of turn\n");
			
		} while(1==1);
	
		//ADD POST BATTLE STUFF HERE!!!
	
	} //close battle method
    
	/*
	//Coming Soon!
	public static void battle(gChar player, gChar[] enemys) {}
	*/
	

}

