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
    =========================ATTRIBUTES==============================================================================
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
    
	//items!
	Inventory inv; 
	
	//Arrays/Lists that hold vital information for functionality
	public ArrayList<String> Builder;
	/* Builder is the ArrayList<String> used to initially create gChar
	Builder formatted as follows:
		{<class>, <strongest_stat>, <weakest_stat>, <personality>, ...}
	*/
	public ArrayList<String> Rebuilder;
	/* Rebuilder is used to store all info necessary to reinstantiate a formerly existing gChar
	Will eventually be needed for saving
	Rebuilder format TBD
	*/
	public LinkedList<String> Skills_LinkedList;
	/* Skill_LinkedList is a collection of attacks useable by player
	A LinkedList, for current intents and purposes, is same as an ArrayList
	Technical difference (crudely explained): Linked Lists are faster at changing size, but slower as they get larger
	SKILLS GAINED IN SUBCLASSES OR LEVEL UPS MUST BE ADDED TO THIS LIST
    */
	public String[] StatTypes = new String[] {"Health", "Strength", "Magic", "Defense", "Resistance", "Luck", "Agility"}; 
	
	/*
    =================================================================================================================
    ===========ATTACK SKILL METHODS==================================================================================
    =================================================================================================================
    */
    
    //Basic attack that every character can perform
    public int regAtk(gChar enemy){
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
    
    public int regAtkM(gChar enemy){
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
    
    public abstract String skillListChange(String skillList);
    
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
    
	public boolean isFasterThan(gChar enemy) {
		return( this.agility >= enemy.agility );
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
		
			if( input.hasNextLine() ) {
				input = sc.nextLine();
			}
			
			input.toLowerCase(Locale.ENGLISH);
			
			//check for proper input, if proper break loop and continue on, otherwise continue loop
			if( "attack".equals(input) || "use item".equals(input) || "nothing".equals(input) ) {
				break;
			}
			else {
				SO.P("That pokemon game's words echoed in your mind... There is a time and place for everything.\n");
			}
			
		} while (1);
	
		//have user's gChar perform response
		if( "attack".equals(input) ) {
			player.useAttack(enemy);
		}
		else if( "use item".equals(input) ) {
			player.useItem();
		}
		else if( "nothing".equals(input) ) {
			SO.P("You did nothing...\n");
		}
		else ;
	} 
	
	//prompt user to select an attack
	//player then performs attack
	//all usable attacks must be added to SkillList
	public abstract void useAttack(gChar enemy);
	/* Begin with following: {
		Scanner sc = new Scanner(System.in);
		String input_buffer = new String();
		
		SO.P("Which attack will you use?\n");
		
		for( String s : Skills_LinkedList ) {
			SO.P(s + "\n");
		}
		
		if( sc.hasNextLine() ) {
			input_buffer = sc.nextLine();
		}
		
		//if-else ladder for attacks
		
	}*/
	
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
	
	//uses a random attack from Skills_LinkedList
	//can implement better AI here later - may require making abstract
	//for now, I will just use regAtk
	public void useRandomAttck(gChar enemy) {
		this.regAtk(enemy);
	}
	
}  //close class

