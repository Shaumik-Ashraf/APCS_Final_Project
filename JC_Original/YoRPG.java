/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Warrior, Mage, Priest, Rogue, Archer, Monster
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Warrior and a Monster will be instantiated
    private Character pat;   //Is it man or woman?
    private Monster smaug; //Friendly generic monster name, eh?

    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;
    
    private int vocation = 0;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG() {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

    /*=============================================
      void newGame() -- facilitates info gathering to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
      =============================================*/
    public void newGame() {

	String s;
	String name = "";
	s = "Welcome to Ye Olde RPG!\n";

	s += "\nChoose your difficulty: \n";
	s += "\t1: Standard\n";
	s += "\t2: Proud\n";
	s += "\t3: Critical\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }
	
		
	s = "Picture in your head your own appearance.\n";
	s += "\t1: A galliant warrior\n";
	s += "\t2: A wise wizard\n";
	s += "\t3: A nimble rogue\n";
	s += "\t4: A keen archer\n";
	s += "\t5: A benevolent priest\n";
	s += "Selection: ";
	System.out.print( s );
	
	try {
	    vocation = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }


	//instantiate the player's character
	if (vocation == 1 ){
		 pat = new Warrior( name );}
	if (vocation == 2 ){
		 pat = new Wizard( name );}
	if (vocation == 3 ){
		  pat = new Rogue( name );}
	if (vocation == 4 ){
		  pat = new Archer( name );}
	if (vocation == 5 ){
		  pat = new Priest( name );}
	
		
	System.out.println (pat.details + "\n");
		 

	s = "What do you wish to be called? (State your name): ";
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }
	
	s = "\n"+name+", "+"I wish you good luck on your journey.";
	System.out.println (s);


    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Character pat has been initialized
      post: Returns true if player wins (monster dies).
            Returns false if monster wins (player dies).
      =============================================*/
    public boolean playTurn() {

	int i = 1;
	int d1, d2;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "There doesn't seem to anything here. You decided to move on." );

	else {
	    System.out.println( "A monster approaches! Activating combat mode!" );
	    

	    smaug = new Monster();

	    while( smaug.isAlive() && pat.isAlive() ) {

		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		try {
		    System.out.println( "What will you do?" );
		    System.out.println( "\t1: Attack\n\t2: Special\n\t3: Heal" );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }
		
		if (vocation == 1){
		    ((Warrior)pat).normalize();}
		if (vocation == 2){
		    ((Wizard)pat).normalize();}
		if (vocation == 3){
		    ((Rogue)pat).normalize();}
		if (vocation == 4){
		    ((Archer)pat).normalize();}
		if (vocation == 5){
		    ((Priest)pat).normalize();}

		if ( i == 2 ){
			if (vocation == 1){
		    ((Warrior)pat).specialize();}
		    if (vocation == 2){
		    ((Wizard)pat).specialize();}
		     if (vocation == 3){
		    ((Rogue)pat).specialize();}
		    if (vocation == 4){
		    ((Archer)pat).specialize();}
		    if (vocation == 5){
		    ((Priest)pat).specialize();}}
		    
		if ( i == 3 ){
			if (vocation == 1){
		    ((Warrior)pat).recover();}
		    if (vocation == 2){
		    ((Wizard)pat).recover();}
		     if (vocation == 3){
		    ((Rogue)pat).recover();}
		    if (vocation == 4){
		    ((Archer)pat).recover();}
		    if (vocation == 5){
		    ((Priest)pat).recover();}}
		    
		    
	
		    

		d1 = pat.attack( smaug );
		d2 = smaug.attack( pat );
		
		
		
		if (d1 <= 0){
			d1 = 0;
		}
		
		if (d1 > 9999){
			d1 = 9999;
		}
		
		if (d2 <= 0){
			d2 = 0;
		}
		
		if (!(pat.healing)){
		System.out.println( "You" + " dealt " + d1 +
				    " points of damage.");
		if (pat.crit){
			System.out.println("It's a critical hit!");
		}}
				    

		System.out.println( "The enemy hit back for " + d2 +
				    " points of damage.");
		
		if (smaug.crit){
			System.out.println("It's a critical hit!");
		}
				    
	
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You cut ye olde monster down, but " +
				    "with its dying breath ye olde monster. " +
				    "laid a fatal blow upon thy skull." );
		return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
		System.out.println( "Conglaturations! You gained an insignificant amount of experience points.\n");
		if (Math.random() >= .5){
			System.out.println( "The monster left a cookie! Restored health!" );
			pat.HP = pat.hpInitial;

		}
		return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
		System.out.println( "GG. Welcome to die." );
		return false;
	    }
	}//end else

	return true;
    }//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static void main( String[] args ) {

	//As usual, move the begin-comment bar down as you progressively 
	//test each new bit of functionality...

	//loading...
	YoRPG game = new YoRPG();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
		break;
	    encounters++;
	    System.out.println();
	}

	System.out.println( "Game over." );
	/*=============================================

	  =============================================*/

    }//end main

}//end class YoRPG




/*=============================================
  =============================================*/
