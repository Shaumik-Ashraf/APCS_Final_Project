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
import gameitems.*;
import gameskills.*;
//import gameareas.*;
 

public abstract class gChar{

    /*
    =================================================================================================================
    =========================ATTRIBUTES==============================================================================
    =================================================================================================================
    */
	//these should all be protected, but w/e
	
    public String name;
    public String element;
    
    public int HP; //Player's health
	public int MP;
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
	public int mpInitial;
    public int strInitial;
    public int magicInitial;
    public int defInitial;
    public int resInitial;
    public int luckInitial;
    public int speedInitial;
    
	//items!
	protected Inventory inv; 
	
	//Arrays/Lists that hold vital information for functionality
	public ArrayList<String> Builder;
	/* Builder is the ArrayList<String> used to initially create gChar
	Builder formatted as follows:
		{<name>, <class>, <strongest_stat>, <weakest_stat>, <personality>}
	*/
	public ArrayList<String> Rebuilder = new ArrayList<String>();
	/* Rebuilder is used to store all info necessary to reinstantiate a formerly existing gChar
	Will eventually be needed for saving
	Rebuilder format TBD
	*/
	public LinkedList<String> SkillSet;
	/* SkillSet is a collection of attacks useable by player
	A LinkedList, for current intents and purposes, is same as an ArrayList
	Technical difference (crudely explained): Linked Lists are faster at changing size, but slower as they get larger
	SKILLS GAINED IN SUBCLASSES OR LEVEL UPS MUST BE ADDED TO THIS LIST
    */
	//public String[] StatTypes = new String[] {"Health", "Strength", "Magic", "Defense", "Resistance", "Luck", "Agility"}; 
	
	/*
    =================================================================================================================
    ===========Constructors==========================================================================================
    =================================================================================================================
    */
    
    public gChar() {
		//This should nvr be called...
		SkillSet = new LinkedList<String>();
		SkillSet.add("Basic Attack");
		SkillSet.add("Basic AttackM");
	}
	
	public gChar(ArrayList<String> builder) {
		Builder = builder;
		
        HP = 21;
		MP = 25;
        str = 7;
        magic = 7;
        def = 5;
        res = 5;
        luck = 4;
        speed = 6;
        EXP = 0;
        level = 1;
        
        hpInitial = HP;
		mpInitial = MP;
        strInitial = str;
        magicInitial = magic;
        defInitial = def;
        resInitial = res;
        luckInitial = luck;
        speedInitial = speed;
		
		//System.err.println("Debug: " + builder + "----");
		name = builder.get(0);
		bestStat(builder.get(2));
		worstStat(builder.get(3));
		
		SkillSet = new LinkedList<String>();
		SkillSet.add("Basic Attack");
		SkillSet.add("Basic AttackM");
		
	}
	
    /*
    =================================================================================================================
    ==========STAT METHODS===========================================================================================
    =================================================================================================================
    */
    /* comment out for now...
    public abstract String skillListChange(String skillList);
    
	public abstract ArrayList<String> skillChange( ArrayList<String> skills);
    */
	
    public void bestStat(String stat){
        if (stat.equals ("Health")){
            HP *= 1.5;
            hpInitial = HP;
        }
		else if (stat.equals("Mana")) {
			MP *= 1.5;
			mpInitial = MP;
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
		else if (stat.equals("Mana")) {
			MP *= .5;
			mpInitial = MP;
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
    
	public boolean isFasterThan(gChar enemy) {
		return( this.speed >= enemy.speed );
	}
	
	public int takeDamage(int dmg) {
		this.HP -= dmg;
		return(dmg);
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
    
    public void normalize(){  //restore stats
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

	/* Depreciated
	//take user input on what to do and perform indicated action
	//current possible actions: Attack, Use Item, Nothing
	public void doBattleTurn() {
		
		Scanner sc = new Scanner(System.in);
		String input;  //input buffer
		
		//print user options and get response:
		do {
			SO.P("It is your turn. What would you like to do?\n");
			SO.P("Attack\n");
			SO.P("Use Item\n");
			SO.P("Nothing\n");
		
			if( sc.hasNextLine() ) {
				input = sc.nextLine();
			}
			
			//input.toLowerCase(Locale.ENGLISH);
			
			//check for proper input, if proper break loop and continue on, otherwise continue loop
			if( "Attack".equals(input) || "Use item".equals(input) || "Nothing".equals(input) ) {
				break;
			}
			else {
				SO.P("That pokemon game's words echoed in your mind... There is a time and place for everything.\n");
			}
			
		} while (1==1);
	
		//have user's gChar perform response
		if( "Attack".equals(input) ) {
			SO.P("Select a skill to use:\n");
			for(String s : SkillSet) {
				SO.println(s);
			}
			if(sc.hasNextLine()) {
				input = sc.nextLine();
			}
			//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
		else if( "Use item".equals(input) ) {
			this.useItem();
		}
		else if( "Nothing".equals(input) ) {
			SO.P("You did nothing...\n");
		}
		else ;
	} 
	*/
	
	//prints inv, prompts user for what Item to use, and uses said item
	public void useItem() {
	
		Scanner sc = new Scanner(System.in);
		String input_buffer = new String();
		
		SO.P(this.inv);
		
		SO.P("What item would you like to use?\n");
		if( sc.hasNextLine() ) {
			input_buffer = sc.nextLine();
		}
		
		inv.useItem(input_buffer);
		
	}
	/* Depreciated

	//uses a random attack from Skills_LinkedList
	//can implement better AI here later - may require making abstract
	//for now, I will just use regAtk
	public void useRandomAttck(gChar enemy) {
		
	}
	*/

}  //close class

