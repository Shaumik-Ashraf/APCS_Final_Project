/* abstract Character class - contains everything required for battling, and all methods for any character
 * 
 * Notes:
 *	maybe add a public void battle(Character x) method? remove some of the "weight" from Legendairy
 *	packaging everything
 *
 */

package gamechars;
 
import java.io.*;
import java.util.*;
import gameutils.*;
 

public abstract class gChar{

    /*
    =================================================================================================================
    =========================FIELD===================================================================================
    =================================================================================================================
    */
    public String name;
    public String element;
    
    public int HP; //Player's health
    public int str; //Determines damage of physical attacks
    public int magic; //Determines damage of spells
    public int def; //Reduces the damage taken by physical attacks
    public int res; //Reduces the damage taken by magic attacks
    public int luck; //Affects critical hit ratio and total damage taken (min/max damage)
    public int speed; //Determines turn order and battle and affects evasion rate
    public boolean crit; //if true, the attack will be a critical hit and do more damage
    //public boolean healing; // if true, the player skips a turn to heal.
    public boolean typeAdv; // if the player does a move that has a type advantage, deal double damage.
    public boolean typeDis; // if the player does a move that has a type disadvantage, deal half damage.
    public int EXP;
    public int level;
   
    
    //used for normalize
    public int hpInitial;
    public int strInitial;
    public int magicInitial;
    public int defInitial;
    public int resInitial;
    public int luckInitial;
    public int speedInitial;
    
    /*
    =================================================================================================================
    ===========ATTACK SKILL METHODS==================================================================================
    =================================================================================================================
    */
    
    //Basic attack that every character can perform
    public int regAtk( gChar enemy){
        this.crit = false; //Crit activation is set to false
        int damage = this.str - enemy.def; //Work in progress. This is the damage that your character will do
        
        if ( (Math.random() *100) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.str )- (enemy.def /1.03) ) ;//This will be the new damage your character does
        }
        
        if (damage <= 0){
            damage = 0;
        }
        
        enemy.HP -= damage; //Final damage that your enemy will take
        //SO.println ("\n"+ name + " smacks the enemy with a regular attack!" +"\nThe enemy took " + damage + "!\n\n");
        return damage; //Returns the damage dealt to enemy
    }
    
    public int regAtkM( gChar enemy){
        this.crit = false; //Crit activation is set to false
        int damage = this.magic - enemy.res; //Work in progress. This is the damage that your character will do
        
        if ( (Math.random() *100) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.magic )- (enemy.res /1.03) ) ;//This will be the new damage your character does
        }
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return damage; //Returns the damage dealt to enemy
    }
    
    public int bestow (gChar enemy, int damage){
        enemy.HP += damage/2;
        return damage/2;
    }
    
    /*
    =================================================================================================================
    ==========STAT METHODS===========================================================================================
    =================================================================================================================
    */
    public void bestStat(String stat){
        if (stat.equals ("Health")){
            HP *= 1.5;
            hpInitial = HP;
        }
        else if (stat.equals ("Strength")){
            str *= 1.5;
            strInitial = str;
        }
        
        else if (stat.equals ("Magic")){
            magic *= 1.5;
            magicInitial = magic;
        }
        
        else if (stat.equals ("Defense")){
            def *= 1.5;
            defInitial = def;
        }
        
        else if (stat.equals ("Resistance")){
            res *= 1.5;
            resInitial = res;
        }
        
        else if (stat.equals ("Luck")){
            luck *= 1.5;
            luckInitial = luck;
        }
        
        else if (stat.equals ("Agility")){
            speed *= 1.5;
            speedInitial = speed;
        }
        else{
            SO.println ("Something went wrong...");
        }
    }
    
    public void worstStat(String stat){
         if (stat.equals ("Health")){
            HP *= .5;
            hpInitial = HP;
        }
        else if (stat.equals ("Strength")){
            str *= .5;
            strInitial = str;
        }
        
        else if (stat.equals ("Magic")){
            magic *= .5;
            magicInitial = magic;
        }
        
        else if (stat.equals ("Defense")){
            def *= .5;
            defInitial = def;
        }
        
        else if (stat.equals ("Resistance")){
            res *= .5;
            resInitial = res;
        }
        
        else if (stat.equals ("Luck")){
            luck *= .5;
            luckInitial = luck;
        }
        
        else if (stat.equals ("Agility")){
            speed *= .5;
            speedInitial = speed;
        }
        else{
            SO.println ("Something went wrong...");
        }
        
    }
    
     public boolean isAlive(){
        return (HP > 0);
    }
    
    public void statSheet(){
        ArrayList<String> stats = new ArrayList();
        stats.add("HP: " + HP);
        stats.add("Str: " + str);
        stats.add("Magic: " +magic);
        stats.add("Def: " + def);
        stats.add("Res: " + res);
        stats.add("Luck: " + luck);
        stats.add("Agility: " + speed);
        
        SO.println (name);
        SO.println ("Level: " + level);
        SO.println ("Element :"+ element);
        SO.println ("EXP: " + EXP);
        SO.println (stats);
    }
    
    //reset stats
    //also use as heal (boolean healing not required; usage: class Town -> rest case)
    public void normalize(){
       // healing = false;
        str = strInitial;
        magic = magicInitial;
        def = defInitial;
        res = resInitial;
        luck = luckInitial;
        speed = speedInitial;
        crit = false;
        typeAdv = false;
        typeDis = false;
    }
    
    
    /*
    =================================================================================================================
    ==========BATTLE METHODS===========================================================================================
    =================================================================================================================
    */
   
   /*
   // only commented and modified part of it, look down for where I left off
   // i'm confused in some parts too
   public void battle(gChar enemy) {
       
       Scanner in = new Scanner(System.in);
       		
			    SO.println("An enemy draws near! \n");
			    pause = in.nextLine();
       
       //start attack exchange loop
       while( this.isAlive() && enemy.isAlive() ) {
       		 
       				response = false;
       				enemyFirst = false;
       	
       	   //get user action choice			
       				while(!response) {
       					   
       			     SO.clearScreen();
      		    			SO.println( "What will you do?" );
      		    			SO.println( "Attack\nSkills\nNothing\n" );
      		    			choice = in.nextLine();
      		    			if ( commands.contains(choice) ) {
      	                    		response = true;
      		    				}
      		    				
       				}
       	
		       		response = false;
		    
		    		   if(choice.equals ("Skills") ) {
		    		
     		    				while (!response) {
        		    				SO.clearScreen();
        		    				SO.println( "What will you do?" );
        		    				SO.println( skillList );
        		    				choice =in.nextLine();
        		    				if ( skills.contains (choice) ) {
        	                    		response = true;
        		    				}
     		    				}
     		    }
		    		
		    		   if (this.speed < enemy.speed){
      		    			enemyFirst = true;
      		    			int damage = enemy.regAtk(cloud);
      		    			SO.println ("\nThe "+ enemy.name + " slaps " + player.get(0) +"!" +"\n" + player.get(0)+ " took " + damage + "!\n");
      		    			
      						   if (enemy.crit){
      							     SO.println("It's a critical hit!\n");
      						   }
      						
      						   pause = in.nextLine();
      		    			
		    		   }
		    		
   		    		else if (choice.equals ("Attack")){
   		    			  int damage = cloud.regAtk(enemy);
   		    			  SO.println("\n"+ player.get(0) + " smacks the enemy!" +"\nThe enemy took " + damage + "!\n");
   		    		}
		    		
		    				 //Nothing case????
		    				 
		    			  else if (cloud instanceof WarriorF){
		    			
     		    				if (choice.equals ("Strong Swing")){
     		    					 ( (WarriorF)this ).strongSwing (enemy);  //does this typecast work??? I put it in to switch cloud to this
     		    				}
     		    			
     		    				if (choice.equals ("Heat Wave")){
     		    					( (WarriorF)this ).heatWave (enemy);
     		    				}
     		    			
     		    				if (choice.equals ("Flame Crash")){
     		    					 ((WarriorF)this ).flameCrash (enemy);
     		    				}
     		
     		    				if (choice.equals ("Rekindle")){
     		    					 ( (WarriorF)this ).reKindle();
     		    				
     		    				}
		    			
		    			}
		    			
		    			/*
		    			 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		    			 Unedited beyond this point
		    			 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		    			 *
		    			 /*
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
		    			
		    			}
		    *

						if (this.typeAdv){
		    				SO.println("It's super effective!\n");
						}
						
						if (this.typeDis){
		    				SO.println("It's not very effective!\n");
						}
						
		    if (this.crit){
							   SO.println("It's a critical hit!\n");
						}
						
						pause =in.nextLine();
		    		
		   if ((enemy.isAlive()) && !enemyFirst) {
		    			int damage = enemy.regAtk(cloud);
		    			SO.println ("\nThe "+ enemy.name + " slaps " + player.get(0) +"!" +"\n" + player.get(0)+ " took " + damage + "!\n");
		    			
					if (enemy.crit){
							SO.println("It's a critical hit!\n");
						}
						
						pause =in.nextLine();
					 System.out.print("\033[H\033[2J");
						System.out.flush();
						
		}  //end while loop (?)
		    		
		    		if (!( enemy.isAlive() ) ){
		    			cloud.normalize();
		    			enemy.normalize();
		    			expGain (enemy);
		    			SO.println ("You win!");
		    		
		    			break;
		    		}

     			if (!cloud.isAlive()){
     				SO.println ("You lose.");
     			}
        
        } //what does this cloes?
      	}  //what does this close?
   }  //what does this close
   
   
}
*/
