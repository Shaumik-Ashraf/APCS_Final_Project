/* Legendairy - does the heavy lifting of legends
 * 
 * Notes:
 * This should still work
 * 
 *
 */

//custom api
import gamechars.*;
 
//java 7 api 
import java.io.*;
import java.util.*;


    public class Legendairy{
            
        
        private static final ArrayList<String> stats = new ArrayList();
        private static final ArrayList<String> traits = new ArrayList();
        private static final ArrayList<String> jobs = new ArrayList();
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
	        
	        //A bit silly, but if the user happens to type it into lower case, the program will accept the input and uppercase it later on.

	        newGame();
        }
        
        public void characterCreation(){
        	System.out.print("\033[H\033[2J");
			System.out.flush();
            message = "";
            message = "Welcome to Project Legendairy. \nWe appreciate you volunteering to help out. \nWould you mind telling me your name?";
            System.out.println (message);
            
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
                	System.out.println (message);
                    System.out.println("Please enter an appropriate response.\n");
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
                	System.out.println (message);
                    System.out.println("Please enter an appropriate response.\n");
	                String choice =in.nextLine();;
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
                	System.out.println (message);
                    System.out.println("Please enter an appropriate response.\n");
	                String choice =in.nextLine();
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
               		System.out.println (message);
                    System.out.println("Please enter an appropriate response.\n");
	                String choice =in.nextLine();
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
            System.out.println (message);
            
            
            if (player.get(4).equals ("Outgoing") ){
            	cloud = new WarriorF(player);
            	skills.add ("Strong Swing");
            	skills.add ("Heat Wave");
            	skills.add ("Flame Crash");
            	skills.add ("Rekindle");
            	skillList = "Strong Swing\nHeat Wave\nFlame Crash\nRekindle\n";
            }
            
            if (player.get(4).equals ("Optimistic") ){
            	cloud = new WarriorW(player);
            	skills.add ("Strong Swing");
            	skills.add ("Flower Dance");
            	skills.add ("Wood Spike");
            	skills.add ("Pepper Song");
            	skillList = "Strong Swing\nFlower Dance\nWood Spike\nPepper Song\n";
            }
            
            if (player.get(4).equals ("Calm") ){
            	cloud = new WarriorA(player);
            	skills.add ("Strong Swing");
            	skills.add ("Hail Storm");
            	skills.add ("Drizzle");
            	skills.add ("Aqua Veil");
            	skillList = "Strong Swing\nHail Storm\nDrizzle\nAqua Veil\n";
            }
            
        }
    
       		
       		
      	public void battleSim(){
       		message = "So... why don't we start the battle simulator?\n";
       		message += "1. Sure!\n";
       		message += "2. No way!\n";
       		
       		while (!response){
       			System.out.println (message);
            	String choice =in.nextLine();
	            System.out.print("\033[H\033[2J");
				System.out.flush();
				if ( choice.equals ("1" )) {
	                    response = true;
	                }
       		}
       		
       		enemy = new Monster();
			System.out.println ("An enemy draws near! \n\n");
       		while( cloud.isAlive() && enemy.isAlive() ) {
       				response = false;
       				
       				try{
       					Thread.sleep(1000);
       				}catch (Exception e){}
       				System.out.print("\033[H\033[2J");
					System.out.flush();
       			
		    		System.out.println( "What will you do?" );
		    		System.out.println( "Attack\nSkills\nNothing\n" );
		    		String choice =in.nextLine();
		    		
		    		cloud.normalize();
		    		enemy.normalize();
		    		
		    		if (choice.equals ("Attack")){
		    			int d1 = cloud.regAtk( enemy );
		    			if (d1 <= 0){
							d1 = 0;
						}
						System.out.println ("\n"+ player.get(0) + " smacks the enemy with a regular attack!" +"\nThe enemy took " + d1 + "!\n\n");
		    		}
		    		
		    		if (choice.equals ("Skills") ){
		    			if (cloud instanceof WarriorF){
		    				while (!response){
		    				
		    				System.out.print("\033[H\033[2J");
							System.out.flush();
		    				System.out.println( "What will you do?" );
		    				System.out.println( skillList );
		    				choice =in.nextLine();
		    				if ( skills.contains (choice) ) {
	                    		response = true;
		    					}
		    				}
		    			
		    				if (choice.equals ("Strong Swing")){
		    					int d1 = ( (WarriorF)cloud ).strongSwing (enemy);
		    					if (d1 <= 0){
								d1 = 0;
								}
								System.out.println ("The enemy took " + d1 + "!\n\n");
		    				}
		    			
		    				if (choice.equals ("Heat Wave")){
		    					int d1 = ( (WarriorF)cloud ).heatWave (enemy);
		    					if (d1 <= 0){
								d1 = 0;
								}
								System.out.println ("The enemy took " + d1 + "!\n\n");
		    				}
		    			
		    				if (choice.equals ("Flame Crash")){
		    					int d1 = ( (WarriorF)cloud).flameCrash (enemy);
		    					if (d1 <= 0){
								d1 = 0;
								}
								System.out.println ("The enemy took " + d1 + "!\n\n");
		    				}
		
		    			
		    				if (choice.equals ("Rekindle")){
		    					 ( (WarriorF)cloud ).reKindle();
		    				
		    				}
		    			
		    			}
		    			
		    			
		    			
		    			
		    				if (cloud instanceof WarriorW){
		    				while (!response){
		    				
		    				System.out.print("\033[H\033[2J");
							System.out.flush();
		    				System.out.println( "What will you do?" );
		    				System.out.println( skillList );
		    				choice =in.nextLine();
		    				if ( skills.contains (choice) ) {
	                    		response = true;
		    					}
		    				}
		    			
		    				if (choice.equals ("Strong Swing")){
		    					int d1 = ( (WarriorW)cloud ).strongSwing (enemy);
		    					if (d1 <= 0){
								d1 = 0;
								}
								System.out.println ("The enemy took " + d1 + "!\n\n");
		    				}
		    			
		    				if (choice.equals ("Flower Dance")){
		    					int hits = ( (WarriorW)cloud ).flowerDance();
		    					while (hits != 0){
		    						int d1 = cloud.regAtk( enemy );
		    						if (d1 <= 0){
										d1 = 0;
		    						}
								System.out.println ("The enemy took " + d1 + "!\n\n");
								hits --;
								cloud.str++;
		    					}
		    				}
		    			
		    				if (choice.equals ("Wood Spike")){
		    					int d1 = ( (WarriorW)cloud).woodSpike (enemy);
		    					if (d1 <= 0){
								d1 = 0;
								}
								System.out.println ("The enemy took " + d1 + "!\n\n");
		    				}
		
		    			
		    				if (choice.equals ("Pepper Song")){
		    					 ( (WarriorW)cloud ).pepperSong();
		    				
		    				}
		    			
		    			}
		    			
		    			if (cloud instanceof WarriorA){
		    				while (!response){
		    				
		    				System.out.print("\033[H\033[2J");
							System.out.flush();
		    				System.out.println( "What will you do?" );
		    				System.out.println( skillList );
		    				choice =in.nextLine();
		    				if ( skills.contains (choice) ) {
	                    		response = true;
		    					}
		    				}
		    			
		    				if (choice.equals ("Strong Swing")){
		    					int d1 = ( (WarriorA)cloud ).strongSwing (enemy);
		    					if (d1 <= 0){
								d1 = 0;
								}
								System.out.println ("The enemy took " + d1 + "!\n\n");
		    				}
		    			
		    				if (choice.equals ("Hail Storm")){
		    					int hits = ( (WarriorA)cloud ).hailStorm();
		    					while (hits != 0){
		    						int d1 = cloud.regAtk( enemy );
		    						if ( enemy.element.equals ("Wood") ){
            							cloud.typeAdv = true;
            							d1 += cloud.regAtk( enemy );
        							}
        
        							if ( enemy.element.equals ("Fire") ){
            							cloud.typeDis = true;
            							d1 = cloud.bestow (enemy, d1);
    								 }
		    						if (d1 <= 0){
										d1 = 0;
		    						}
								System.out.println ("The enemy took " + d1 + "!\n\n");
								hits --;
							
		    					}
		    				}
		    			
		    				if (choice.equals ("Drizzle")){
		    					int hits = ( (WarriorA)cloud ).drizzle();
		    					while (hits != 0){
		    						int d1 = cloud.regAtk( enemy );
		    						if ( enemy.element.equals ("Fire") ){
            							cloud.typeAdv = true;
            							d1 += cloud.regAtk( enemy );
        							}
        
        							if ( enemy.element.equals ("Wood") ){
            							cloud.typeDis = true;
            							d1 = cloud.bestow (enemy, d1);
    								 }
    								 
    								 
		    						if (d1 <= 0){
										d1 = 0;
		    						}
								System.out.println ("The enemy took " + d1 + "!\n\n");
								hits --;
								cloud.str--;
		    					}
		    				}
		    			
		    				if (choice.equals ("Aqua Veil")){
		    					 ( (WarriorA)cloud ).aquaVeil();
		    				
		    				}
		    			
		    			}
		    		}
		    		
		    		
		    		
		    		
		
						if (cloud.typeAdv){
		    				System.out.println("It's super effective!\n\n");
						}
						
						if (cloud.typeDis){
		    				System.out.println("It's not very effective!\n\n");
						}
						
		    			if (cloud.crit){
							System.out.println("It's a critical hit!\n\n");
						}
						
		    			try{
       						Thread.sleep(200);
       					}catch (Exception e){}
        				
        				//System.out.print("\033[H\033[2J");
						//System.out.flush();
		    		
		    		
		    		if (enemy.isAlive()) {
						int d2 = enemy.regAtk( cloud );
							if (d2 <= 0){
								d2 = 0;
						}
						System.out.println ("The enemy slaps " + player.get(0) +"!" +"\n" + player.get(0)+ " took " + d2 + "!\n\n");
						if (enemy.crit){
							System.out.println("It's a critical hit!\n\n");
						}
						
						try{
       						Thread.sleep(1500);
       					}catch (Exception e){}
        				System.out.print("\033[H\033[2J");
						System.out.flush();
		    		}
		    		
		    		else{
		    			System.out.println ("You win!");
		    			break;
		    		}
				
			}
			
			if (!cloud.isAlive()){
				System.out.println ("You lose.");
			}
			
            
            
        
        }
        
           public void newGame(){
        	
            characterCreation();
            battleSim();
        }
        
        public static void main (String[] args){
            Legendairy game = new Legendairy();
        }
    }
