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
 
//java 7 api 
import java.io.*;
import java.util.*;


    public class Legendairy{
            
        
        private static final ArrayList<String> stats = new ArrayList();
        private static final ArrayList<String> traits = new ArrayList();
        private static final ArrayList<String> jobs = new ArrayList();
        private static final ArrayList<String> commands = new ArrayList();
        private static final ArrayList<String> skills = new ArrayList();
        
        private static ArrayList<String> player = new ArrayList();

        private gChar cloud;
        private gChar enemy;
        
        private boolean response;
        private String message;
        private String skillList;
        private String choice;
        
        //private InputStreamReader isr;
        //private BufferedReader in;
        
        private Scanner in;
        
        public Legendairy() {
          //  isr = new InputStreamReader( System.in );
	      //  in = new BufferedReader( isr );
	        in = new Scanner(System.in);
	        response = false;
	        stats.add ("Health");
	        stats.add ("HP");
	        stats.add ("Strength");
	        stats.add ("Magic");
	        stats.add ("Defense");
	        stats.add ("Resistance");
	        stats.add ("Luck");
	        stats.add ("Agility");
	        
	        traits.add ("Outgoing");
	        traits.add ("Optimistic");
	        traits.add ("Calm");
	        
	        jobs.add ("Warrior");
	        jobs.add ("Mage");
	        jobs.add ("Archer");
	        
	        commands.add ("Attack");
	        commands.add("Skills");
	        
	        
	        //A bit silly, but if the user happens to type it into lower case, the program will accept the input and uppercase it later on.

	        newGame();
        }
        
        public void newGame(){
        	
            //character selections
            characterCreation();
            
            //for now, do battle
            battleSim();
        
        	
        	
        }
        
        public void characterCreation(){
        	System.out.print("\033[H\033[2J");
			System.out.flush();
            message = "";
            message = "Welcome to Project Legendairy. \nWe appreciate you volunteering to help out. \nWould you mind telling me your name?";
            SO.println (message);
            
            //try {
	            player.add (in.nextLine());
	        //}
	        //catch ( IOException e ) {}
	        System.out.print("\033[H\033[2J");
			System.out.flush();
	        
	        message = "Choose your vocation.\n";
	        message += "Warrior\n";
	        message += "Mage\n";
        	message += "Archer\n";
        	
        	
        	while (!response){
                
                //try {
                	SO.println (message);
                    SO.println("Please enter an appropriate response.\n");
	                choice =in.nextLine();
	               	System.out.print("\033[H\033[2J");
					System.out.flush();
	                if ( jobs.contains (choice) ) {
	                    player.add (choice);
	                    response = true;
	                }
	            //}
	            //catch ( IOException e ) { }
            }
            
            response = false;
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
       
            
            
            while (!response){
                
                //try {
                	SO.println (message);
                    SO.println("Please enter an appropriate response.\n");
	                choice =in.nextLine();
	                System.out.print("\033[H\033[2J");
					System.out.flush();
	                if ( stats.contains (choice) ) {
	                    player.add (choice);
	                    response = true;
	                }
	            //}
	            //catch ( IOException e ) { }
            }
            
            response = false;
            
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
       
            
            
            while (!response){
                
                //try {
                	SO.println (message);
                    SO.println("Please enter an appropriate response.\n");
	                choice =in.nextLine();
	                System.out.print("\033[H\033[2J");
					System.out.flush();
	                if ( stats.contains (choice) ) {
	                    player.add(choice);
	                    response = true;
	                }
	            //}
	            //catch ( IOException e ) { }
            }
            
        
        
         response = false;
            System.out.print("\033[H\033[2J");
			System.out.flush();
            message = "Which of the following best describes your character?\n";
        	message += "\nOutgoing\n";
	        message += "Optimistic\n";
	        message += "Calm\n";
        

            
            while (!response){
                
               // try {
               		SO.println (message);
                    SO.println("Please enter an appropriate response.\n");
	                choice =in.nextLine();
	                System.out.print("\033[H\033[2J");
					System.out.flush();
	                if ( traits.contains (choice) ) {
	                    player.add(choice);
	                    response = true;
	                }
	            //}
	            //catch ( IOException e ) { }
            }
            
            response = false;
            
            //Description will be customized to fit what the player inputed previously
            System.out.print("\033[H\033[2J");
			System.out.flush();
            message = "Hm, so you're " ;
            message += player.get(0);
            message += "?\n";
            SO.println (message);
            
            
            if (player.get(4).equals ("Outgoing") ){
            	if (player.get(1).equals ("Warrior")){
            		cloud = new WarriorF(player);
            		skills.add ("Strong Swing");
            		skills.add ("Heat Wave");
            		skills.add ("Flame Crash");
            		skills.add ("Rekindle");
            		skillList = "Strong Swing\nHeat Wave\nFlame Crash\nRekindle\n";
            	}
            	
            	if (player.get(1).equals ("Mage")){
            		cloud = new MageF(player);
            		skills.add ("Arcanite Force");
            		skills.add ("Heat Wave");
            		skills.add ("Flame Crash");
            		skills.add ("Rekindle");
            		skillList = "Arcanite Force\nHeat Wave\nFlame Crash\nRekindle\n";
            	}
            }
            
            if (player.get(4).equals ("Optimistic") ){
            	if (player.get(1).equals ("Warrior")){
            		cloud = new WarriorW(player);
            		skills.add ("Strong Swing");
            		skills.add ("Flower Dance");
            		skills.add ("Wood Spike");
            		skills.add ("Pepper Song");
            		skillList = "Strong Swing\nFlower Dance\nWood Spike\nPepper Song\n";
            	}
            	
            	if (player.get(1).equals ("Mage")){
            		cloud = new MageW(player);
            		skills.add ("Arcanite Force");
            		skills.add ("Flower Dance");
            		skills.add ("Wood Spike");
            		skills.add ("Pepper Song");
            		skillList = "Arcanite Force\nFlower Dance\nWood Spike\nPepper Song\n";
            	}
            }
            
            if (player.get(4).equals ("Calm") ){
            	if (player.get(1).equals ("Warrior")){
            		cloud = new WarriorA(player);
            		skills.add ("Strong Swing");
            		skills.add ("Hail Storm");
            		skills.add ("Drizzle");
            		skills.add ("Aqua Veil");
            		skillList = "Strong Swing\nHail Storm\nDrizzle\nAqua Veil\n";
            	}
            	if (player.get(1).equals("Mage")){
            		cloud = new MageA(player);
            		skills.add ("Arcanite Force");
            		skills.add ("Hail Storm");
            		skills.add ("Drizzle");
            		skills.add ("Aqua Veil");
            		skillList = "Arcanite Force\nHail Storm\nDrizzle\nAqua Veil\n";
            	}
            	
            }
            
        }
        
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
        	}
        }
        
        public void skillPoints (gChar cloud){
        	String message = "";
        	SO.println ("You gained some skill points!\n");
        	choice =in.nextLine();
        	//try{
       			//Thread.sleep(1500);
       		//	}catch (Exception e){}
       		System.out.print("\033[H\033[2J");
			System.out.flush();
        	for (int i = 3; i >0; i--){
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
            			System.out.print("\033[H\033[2J");
						System.out.flush();
            			
            			}
            		}
            	
        	}
        	response = false;
        }
    
       		
       		
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
       		
       		enemy = new Monster();
			SO.println ("An enemy draws near! \n\n");
			choice =in.nextLine();
       		while( cloud.isAlive() && enemy.isAlive() ) {
       				response = false;
       				
       				
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
		    		cloud.normalize();
		    		enemy.normalize();
		    		
		    		if (choice.equals ("Attack")){
		    			int damage = cloud.regAtk(enemy);
		    			SO.println ("\n"+ player.get(0) + " smacks the enemy!" +"\nThe enemy took " + damage + "!\n\n");
		    		}
		    		
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
		    			
		    			}
		    			
		    			if (cloud instanceof MageA){
		    				
		    			
		    				if (choice.equals ("Arcanite Force")){
		    					int d1 = ( (MageA)cloud ).arcaniteForce (enemy);
		    					if (d1 <= 0){
								d1 = 0;
								}
								SO.println ("The enemy took " + d1 + "!\n\n");
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
		    			
		    			}
		    			

						if (cloud.typeAdv){
		    				SO.println("It's super effective!\n\n");
						}
						
						if (cloud.typeDis){
		    				SO.println("It's not very effective!\n\n");
						}
						
		    			if (cloud.crit){
							SO.println("It's a critical hit!\n\n");
						}
						
						choice =in.nextLine();
		    		//	try{
       				//		Thread.sleep(200);
       				//	}catch (Exception e){}
        				
        				//System.out.print("\033[H\033[2J");
						//System.out.flush();
		    		
		    		
		    		if (enemy.isAlive()) {
		    			int damage = enemy.regAtk(cloud);
		    			SO.println ("\nThe "+ enemy.name + " slaps " + player.get(0) +"!" +"\n" + player.get(0)+ " took " + damage + "!\n\n");
		    			
					if (enemy.crit){
							SO.println("It's a critical hit!\n\n");
						}
						
						choice =in.nextLine();
					//	try{
       				///		Thread.sleep(1500);
       					//}catch (Exception e){}
        				System.out.print("\033[H\033[2J");
						System.out.flush();
		    		}
		    		
		    		else{
		    			expGain (enemy);
		    			SO.println ("You win!");
		    			break;
		    		}
				
			
			
			if (!cloud.isAlive()){
				SO.println ("You lose.");
			}
			
            
            
        
        }
      	}
        
          
        
        public static void main (String[] args){
            Legendairy game = new Legendairy();
        }
    }
