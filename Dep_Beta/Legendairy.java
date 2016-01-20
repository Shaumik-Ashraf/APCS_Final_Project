/* Legendairy - does the heavy lifting of legends
* 
* Notes:
* This should still work
* 
*
*/

//custom api
import gamechars.*;
import gameutils.*;
import gameitems.*;
import gameareas.*;

//java 7 api 
import java.io.*;
import java.util.*;


public class Legendairy {
		
	private Scanner in = new Scanner(System.in);
	private String input_buffer = new String();
	private boolean exitedGame = false;
	
	//run the game upon calling constructor
	public Legendairy() {
	
		gamelists.init();
		gChar player = new Monster();  //this is to avoid the "player may not be initialized error" which is impossible do to system below
	
		SO.P("JASC game start!\n\n");
		
		do {  //ask to start new game or load game, loop until player selects new game
			SO.P("What would you like to do?\n");
			SO.P("New game\n");
			SO.P("Load game\n");
			SO.P("Exit game\n\n:");
			
			if( in.hasNextLine() ) {
				input_buffer = in.nextLine();
			}
			//input_buffer = input_buffer.toLowerCase(Locale.ENGLISH);
			
			if( "New game".equals(input_buffer) ) {
				try {
					SO.P("Creating character...\n\n");
					player = Creator.characterCreation();
					SO.P("DEBUG:: Character created!!!\n");
					//player.statSheet();
					break;
				}
				catch(Exception e) {  //cud handle this better...
					System.err.println("Caught an error!!!\n Press C-c!\n");
					System.err.println(e);	
				}
			}
			else if( "Load game".equals(input_buffer) ) {
				SO.P("load option to be implemented!!!\n");
				//player = loadCharacter();
				exitedGame = true; //for now
				break;
			}
			else if( "Exit game".equals(input_buffer) ) {
				exitedGame = true;
				break;
				//End it Properly!!!
			}
			else {
				SO.P("Error, invalid input...\n");
				continue;
			}
		} while(1==1);
			
		if( !exitedGame /*&& player!=null*/ ) {
			//!!!!!IMPLEMENT GAMEPLAY HERE!!!!!!!!!!!!!!!!!!!!
			
			ArrayList<Area> map = new ArrayList<Area>(10);

			//generate area map
			map.add(new Town());
			for(int i=1; i<10; i++) {
				if( Math.random()*100 < 67 ) {  
					map.add(i, new Field(i));  //constructor will create field named field-i
				}
				else {
					map.add(i, new Town(i));  //likewise, town-i
				}
			}

			for(int i=0; i<map.size(); i++) {
				(map.get(i)).event(player);
			}
			
			SO.P("Game done! :)\n\n");
		}
		else ;
	
		
	} //close constructor
	
	/*For now...
	public void expGain(gChar enemy){
		System.out.print("\033[H\033[2J");
		System.out.flush();
		cloud.EXP += enemy.EXP;
		SO.println (cloud.name + " gained " + enemy.EXP + " exp!");
		if (cloud.EXP >= 100){
			int lvls = cloud.EXP / 100;
			cloud.level += lvls;
			SO.println (cloud.name + " leveled up to level " + cloud.level);
			cloud.EXP = cloud.EXP % 100;
			SO.println ("\n");
			skillPoints(cloud);
			skillList = cloud.skillListChange(skillList);
			skills = cloud.skillChange(skills);
		}
	}
	
	public void skillPoints (gChar cloud){
		String message = "";
		SO.println ("You gained some skill points!\n");
		choice =in.nextLine();
		//try{
			//Thread.sleep(1500);
		//	}catch (Exception e){}
		
		for (int i = 3; i >0; i--){
			System.out.print("\033[H\033[2J");
			System.out.flush();
			cloud.statSheet();
			message = "\nPlease allocate these points to the following stats.\nYou have " + i + " point(s).\n";
			message += "HP\n";
			message += "Strength\n";
			message += "Magic\n";
			message += "Defense\n";
			message += "Resistance\n";
			message += "Luck\n";
			message += "Agility\n";
			response = false;
			while (!response){
				SO.println (message);
				choice =in.nextLine();
				if (stats.contains (choice)) {
					if (choice.equals ("HP")){
						cloud.HP ++;
						cloud.hpInitial = cloud.HP;
					}
					if (choice.equals ("Strength")){
						cloud.str ++;
						cloud.strInitial = cloud.str;
					}
					if (choice.equals ("Magic")){
						cloud.magic ++;
						cloud.magicInitial = cloud.magic;
					}
					if (choice.equals ("Defense")){
						cloud.def ++;
						cloud.defInitial = cloud.def;
					}
					if (choice.equals ("Resistance")){
						cloud.res ++;
						cloud.resInitial = cloud.res;
					}
					if (choice.equals ("Luck")){
						cloud.luck ++;
						cloud.luckInitial = cloud.luck;
					}
					if (choice.equals ("Agility")){
						cloud.speed ++;
						cloud.speedInitial = cloud.speed;
					}
					
					response = true;
				
					}
					
					System.out.print("\033[H\033[2J");
					System.out.flush();
					cloud.statSheet();
				
				}
			
		}
		response = false;
	}
	*/
		
	/*	battleSim method...
	public void battleSim(){
	
		message = "So... why don't we start the battle simulator?\n";
		message += "1. Sure!\n";
		message += "2. No way!\n";
		
		while (!response){
			SO.println (message);
			choice =in.nextLine();
			System.out.print("\033[H\033[2J");
			System.out.flush();
			if ( choice.equals ("1" )) {
					response = true;
				}
		}
		
		while (true){
		enemy = new Monster();
		SO.println ("An enemy draws near! \n");
		pause =in.nextLine();
		while( cloud.isAlive() && enemy.isAlive() ) {
				response = false;
				enemyFirst = false;
				cloud.typeAdv = false;
				cloud.typeDis = false;
				
				//try{
				//	Thread.sleep(1000);
			//	}catch (Exception e){}
				
				while (!response){
					System.out.print("\033[H\033[2J");
					System.out.flush();
			
					SO.println( "What will you do?" );
					SO.println( "Attack\nSkills\nNothing\n" );
					choice =in.nextLine();
					if ( commands.contains (choice) ) {
							response = true;
							}
				}
				
				
				
				response = false;
			
				
			
				
				if (choice.equals ("Skills") ){
				
						while (!response){
						
						System.out.print("\033[H\033[2J");
						System.out.flush();
						SO.println( "What will you do?" );
						SO.println( skillList );
						choice =in.nextLine();
						if ( skills.contains (choice) ) {
							response = true;
							}
						}
				}
				
				if (cloud.speed < enemy.speed){
					enemyFirst = true;
					int damage = enemy.regAtk(cloud);
					SO.println ("\nThe "+ enemy.name + " slaps " + player.get(0) +"!" +"\n" + player.get(0)+ " took " + damage + "!\n");
					
					if (enemy.crit){
						SO.println("It's a critical hit!\n");
					}
					
					pause =in.nextLine();
					
				}
				
				if (choice.equals ("Attack")){
					int damage = cloud.regAtk(enemy);
					SO.println ("\n"+ player.get(0) + " smacks the enemy!" +"\nThe enemy took " + damage + "!\n");
				}
				
						
					if (cloud instanceof WarriorF){
					
						if (choice.equals ("Strong Swing")){
							 ( (WarriorF)cloud ).strongSwing (enemy);
						}
					
						if (choice.equals ("Heat Wave")){
							( (WarriorF)cloud ).heatWave (enemy);
						}
					
						if (choice.equals ("Flame Crash")){
							 ((WarriorF)cloud).flameCrash (enemy);
						}
	
						if (choice.equals ("Rekindle")){
							 ( (WarriorF)cloud ).reKindle();
						
						}
						
						if (choice.equals ("Proud Swivel")){
							 ( (WarriorF)cloud ).proudSwivel(enemy);
						
						}
						
						if (choice.equals ("Finishing Touch")){
							 ( (WarriorF)cloud ).finishingTouch(enemy);
						
						}
					
					}
					
					
					
					
					if (cloud instanceof WarriorW){
						
					
						if (choice.equals ("Strong Swing")){
							( (WarriorW)cloud ).strongSwing (enemy);
						}
					
						if (choice.equals ("Flower Dance")){
							( (WarriorW)cloud ).flowerDance(enemy);
						
						}
					
						if (choice.equals ("Wood Spike")){
							( (WarriorW)cloud).woodSpike (enemy);
						}
	
					
						if (choice.equals ("Pepper Song")){
							 ( (WarriorW)cloud ).pepperSong();
						
						}
						
							if (choice.equals ("Proud Swivel")){
							 ( (WarriorW)cloud ).proudSwivel(enemy);
						
						}
						
						if (choice.equals ("Finishing Touch")){
							 ( (WarriorW)cloud ).finishingTouch(enemy);
						
						}
					
					}
					
					if (cloud instanceof WarriorA){
						
					
						if (choice.equals ("Strong Swing")){
							 ( (WarriorA)cloud ).strongSwing (enemy);
						}
					
						if (choice.equals ("Hail Storm")){
							( (WarriorA)cloud ).hailStorm(enemy);
						}
					
						if (choice.equals ("Drizzle")){
							( (WarriorA)cloud ).drizzle(enemy);
						}
					
						if (choice.equals ("Aqua Veil")){
							 ( (WarriorA)cloud ).aquaVeil();
						
						}
						
						if (choice.equals ("Proud Swivel")){
							 ( (WarriorA)cloud ).proudSwivel(enemy);
						
						}
						
						if (choice.equals ("Finishing Touch")){
							 ( (WarriorA)cloud ).finishingTouch(enemy);
						
						}
					
					}
					
					if (cloud instanceof WarriorG){
						
					
						if (choice.equals ("Strong Swing")){
							 ( (WarriorG)cloud ).strongSwing (enemy);
						}
					
						if (choice.equals ("Wind Strike")){
							( (WarriorG)cloud ).windStrike(enemy);
						}
					
						if (choice.equals ("Gale Force")){
							( (WarriorG)cloud ).galeForce(enemy);
						}
					
						if (choice.equals ("Tail Wind")){
							 ( (WarriorG)cloud ).tailWind();
						
						}
						
						if (choice.equals ("Proud Swivel")){
							 ( (WarriorG)cloud ).proudSwivel(enemy);
						
						}
						
						if (choice.equals ("Finishing Touch")){
							 ( (WarriorG)cloud ).finishingTouch(enemy);
						
						}
					
					}
					
					if (cloud instanceof WarriorB){
						
					
						if (choice.equals ("Strong Swing")){
							 ( (WarriorB)cloud ).strongSwing (enemy);
						}
					
						if (choice.equals ("Noise Pulse")){
							( (WarriorB)cloud ).noisePulse(enemy);
						}
					
						if (choice.equals ("Gravity")){
							( (WarriorB)cloud ).gravity(enemy);
						}
					
						if (choice.equals ("Abnormalize")){
							 ( (WarriorB)cloud ).abnormalize();
						
						}
						
						if (choice.equals ("Proud Swivel")){
							 ( (WarriorB)cloud ).proudSwivel(enemy);
						
						}
						
						if (choice.equals ("Finishing Touch")){
							 ( (WarriorB)cloud ).finishingTouch(enemy);
						
						}
					
					}
					
					
					if (cloud instanceof MageF){
						
					
						if (choice.equals ("Arcanite Force")){
							( (MageF)cloud ).arcaniteForce (enemy);
						}
					
						if (choice.equals ("Heat Wave")){
							 ( (MageF)cloud ).heatWave (enemy);
						}
					
						if (choice.equals ("Flame Crash")){
							( (MageF)cloud).flameCrash (enemy);
						}
	
					
						if (choice.equals ("Rekindle")){
							 ( (MageF)cloud ).reKindle();
						
						}
						
						if (choice.equals ("Arcane Bullets")){
							 ( (MageF)cloud ).arcaneBullets(enemy);
						
						}
						
						if (choice.equals ("Concentrate")){
							 ( (MageF)cloud ).concentrate();
						
						}
					
					}
					
					if (cloud instanceof MageW){
						
					
						if (choice.equals ("Arcanite Force")){
							( (MageW)cloud ).arcaniteForce (enemy);
						}
					
						if (choice.equals ("Flower Dance")){
							( (MageW)cloud ).flowerDance(enemy);
							
						}
					
						if (choice.equals ("Wood Spike")){
							( (MageW)cloud).woodSpike (enemy);
						}
	
					
						if (choice.equals ("Pepper Song")){
							 ( (MageW)cloud ).pepperSong();
						
						}
						
						if (choice.equals ("Arcane Bullets")){
							 ( (MageW)cloud ).arcaneBullets(enemy);
						
						}
						
						if (choice.equals ("Concentrate")){
							 ( (MageW)cloud ).concentrate();
						
						}
					
					}
					
					if (cloud instanceof MageA){
						
					
						if (choice.equals ("Arcanite Force")){
							( (MageA)cloud ).arcaniteForce (enemy);
							
						}
					
						if (choice.equals ("Hail Storm")){
							( (MageA)cloud ).hailStorm(enemy);
						}
					
						if (choice.equals ("Drizzle")){
							( (MageA)cloud ).drizzle(enemy);
						}
					
						if (choice.equals ("Aqua Veil")){
							 ( (MageA)cloud ).aquaVeil();
						
						}
						
						if (choice.equals ("Arcane Bullets")){
							 ( (MageA)cloud ).arcaneBullets(enemy);
						
						}
						
						if (choice.equals ("Concentrate")){
							 ( (MageA)cloud ).concentrate();
						
						}
					
					}
					
					if (cloud instanceof MageG){
						
					
						if (choice.equals ("Arcanite Force")){
							 ( (MageG)cloud ).arcaniteForce (enemy);
						}
					
						if (choice.equals ("Wind Strike")){
							( (MageG)cloud ).windStrike(enemy);
						}
					
						if (choice.equals ("Gale Force")){
							( (MageG)cloud ).galeForce(enemy);
						}
					
						if (choice.equals ("Tail Wind")){
							 ( (MageG)cloud ).tailWind();
						
						}
						if (choice.equals ("Arcane Bullets")){
							 ( (MageG)cloud ).arcaneBullets(enemy);
						
						}
						
						if (choice.equals ("Concentrate")){
							 ( (MageG)cloud ).concentrate();
						
						}
					}
					
					if (cloud instanceof MageB){
						
			
						if (choice.equals ("Arcanite Force")){
							 ( (MageB)cloud ).arcaniteForce (enemy);
						}
					
						if (choice.equals ("Noise Pulse")){
							( (MageB)cloud ).noisePulse(enemy);
						}
					
						if (choice.equals ("Gravity")){
							( (MageB)cloud ).gravity(enemy);
						}
					
						if (choice.equals ("Abnormalize")){
							 ( (MageB)cloud ).abnormalize();
						
						}
						
						if (choice.equals ("Arcane Bullets")){
							 ( (MageB)cloud ).arcaneBullets(enemy);
						
						}
						
						if (choice.equals ("Concentrate")){
							 ( (MageB)cloud ).concentrate();
						
						}
					
					}
					
					
					
					if (cloud instanceof ArcherF){
						
					
						if (choice.equals ("Bow Throw")){
							( (ArcherF)cloud ).bowThrow (enemy);
						}
					
						if (choice.equals ("Heat Wave")){
							 ( (ArcherF)cloud ).heatWave (enemy);
						}
					
						if (choice.equals ("Flame Crash")){
							( (ArcherF)cloud).flameCrash (enemy);
						}
	
					
						if (choice.equals ("Rekindle")){
							 ( (ArcherF)cloud ).reKindle();
						
						}
						
						
						if (choice.equals ("Arrow Storm")){
							 ( (ArcherF)cloud ).arrowStorm(enemy);
						
						}
						
						if (choice.equals ("Focus")){
							 ( (ArcherF)cloud ).focus();
						
						}
					
					}
					
					if (cloud instanceof ArcherW){
						
					
						if (choice.equals ("Bow Throw")){
							( (ArcherW)cloud ).bowThrow (enemy);
						}
					
						if (choice.equals ("Flower Dance")){
							( (ArcherW)cloud ).flowerDance(enemy);
							
						}
					
						if (choice.equals ("Wood Spike")){
							( (ArcherW)cloud).woodSpike (enemy);
						}
	
					
						if (choice.equals ("Pepper Song")){
							 ( (ArcherW)cloud ).pepperSong();
						
						}
						
						if (choice.equals ("Arrow Storm")){
							 ( (ArcherW)cloud ).arrowStorm(enemy);
						
						}
						
						if (choice.equals ("Focus")){
							 ( (ArcherW)cloud ).focus();
						
						}
					
					}
					
					if (cloud instanceof ArcherA){
						
					
						if (choice.equals ("Bow Throw")){
							( (ArcherA)cloud ).bowThrow(enemy);
							
						}
					
						if (choice.equals ("Hail Storm")){
							( (ArcherA)cloud ).hailStorm(enemy);
						}
					
						if (choice.equals ("Drizzle")){
							( (ArcherA)cloud ).drizzle(enemy);
						}
					
						if (choice.equals ("Aqua Veil")){
							 ( (ArcherA)cloud ).aquaVeil();
						
						}
						
						if (choice.equals ("Arrow Storm")){
							 ( (ArcherA)cloud ).arrowStorm(enemy);
						
						}
						
						if (choice.equals ("Focus")){
							 ( (ArcherA)cloud ).focus();
						
						}
					
					}
					
					if (cloud instanceof ArcherG){
						
					
						if (choice.equals ("Bow Throw")){
							 ( (ArcherG)cloud ).bowThrow (enemy);
						}
					
						if (choice.equals ("Wind Strike")){
							( (ArcherG)cloud ).windStrike(enemy);
						}
					
						if (choice.equals ("Gale Force")){
							( (ArcherG)cloud ).galeForce(enemy);
						}
					
						if (choice.equals ("Tail Wind")){
							 ( (ArcherG)cloud ).tailWind();
						
						}
						
						if (choice.equals ("Arrow Storm")){
							 ( (ArcherG)cloud ).arrowStorm(enemy);
						
						}
						
						if (choice.equals ("Focus")){
							 ( (ArcherG)cloud ).focus();
						
						}
					
					}
					
					if (cloud instanceof ArcherB){
						
			
						if (choice.equals ("Bow Throw")){
							 ( (ArcherB)cloud ).bowThrow (enemy);
						}
					
						if (choice.equals ("Noise Pulse")){
							( (ArcherB)cloud ).noisePulse(enemy);
						}
					
						if (choice.equals ("Gravity")){
							( (ArcherB)cloud ).gravity(enemy);
						}
					
						if (choice.equals ("Abnormalize")){
							 ( (ArcherB)cloud ).abnormalize();
						
						}
						
						if (choice.equals ("Arrow Storm")){
							 ( (ArcherB)cloud ).arrowStorm(enemy);
						
						}
						
						if (choice.equals ("Focus")){
							 ( (ArcherB)cloud ).focus();
						
						}
					
					}
					
					
					
					

					if (cloud.typeAdv){
						SO.println("It's super effective!\n");
					}
					
					if (cloud.typeDis){
						SO.println("It's not very effective!\n");
					}
					
					if (cloud.crit){
						SO.println("It's a critical hit!\n");
					}
					
					pause =in.nextLine();
				//	try{
				//		Thread.sleep(200);
				//	}catch (Exception e){}
					
					//System.out.print("\033[H\033[2J");
					//System.out.flush();
				
				
				if ((enemy.isAlive()) && !enemyFirst) {
					int damage = enemy.regAtk(cloud);
					SO.println ("\nThe "+ enemy.name + " slaps " + player.get(0) +"!" +"\n" + player.get(0)+ " took " + damage + "!\n");
					
				if (enemy.crit){
						SO.println("It's a critical hit!\n");
					}
					
					pause =in.nextLine();
				//	try{
				///		Thread.sleep(1500);
					//}catch (Exception e){}
					System.out.print("\033[H\033[2J");
					System.out.flush();
				}
				
				if (!( enemy.isAlive() ) ){
					cloud.normalize();
					enemy.normalize();
					expGain (enemy);
					SO.println ("You win!");
				
					
				}
			
		
		
		if (!cloud.isAlive()){
			SO.println ("You lose.");
			break;
		}
		
		
		
	
	}
	}
	}
	
	  
	/*
	public static void main (String[] args){
		Legendairy game = new Legendairy();
	}
	*/
	
}//close class





