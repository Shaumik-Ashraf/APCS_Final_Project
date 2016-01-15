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
    
    public abstract String skillListChange( String skillList);
    public abstract ArrayList<String> skillChange( ArrayList<String> skills);
    
    
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
    //may cause conflicts when using equips
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
     =========================================================================================================================================================
     ===Battle Methods========================================================================================================================================
     =========================================================================================================================================================
     */
    
    public void battle(gChar enemy) {

	SO.P("Enemy " + enemy + " encountered!\n");
	
	//boolean whilebattle = true;
	
	do {  //

	} while(1);


while( cloud.isAlive() && enemy.isAlive() ) {

response = false;
enemyFirst = false;
cloud.typeAdv = false;
cloud.typeDis = false;


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
    
}  //close class

