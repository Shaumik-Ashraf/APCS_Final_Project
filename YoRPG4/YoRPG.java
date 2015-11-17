//Gats and Hats
//APCS1 pd9
//HW31 -- Ye Olde Role Playing Game, Unchained
//2015-11-17


//class YoRPG -- Driver file for Ye Olde Role Playing Game.
import java.io.*;
import java.util.*;

public class YoRPG {

    
    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Warrior and a Monster will be instantiated
    private Characters pat;

    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG() {
	    moveCount = 0;
	    gameOver = false;
	    isr = new InputStreamReader( System.in );
	    in = new BufferedReader( isr );
	    newGame();
    }

    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~
	//void newGame() -- facilitates info gathering to begin a new game
    public void newGame() {

	    String s;
	    String name = "";
	    int classID;
    	s = "Welcome to Ye Olde RPG!\n";
    
    	s += "\nChoose your difficulty: \n";
    	s += "\t1: Easy\n";
    	s += "\t2: Not so easy\n";
    	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
    	s += "Selection: ";
    	System.out.print( s );

    	try {
    	    difficulty = Integer.parseInt( in.readLine() );
    	}
    	catch ( IOException e ) { }
    
    	s = "Intrepid hero, what doth thy call thyself? (State your name): ";
    	System.out.print( s );
    
    	try {
    	    name = in.readLine();
    	}
    	catch ( IOException e ) { }
    	
    	s = "Choose Thy Occupation:\n 1: Warrior\n 2: Mage\n 3: Rogue\n 4: Priest\n 5: Ranger";
    	System.out.println(s);
    	try{
    		classID = Integer.parseInt(in.readLine());
    	}
    	catch (IOException e) {
    		classID = 1;
    	}
    	if (classID == 1) {
    		pat = new Warrior(name);
    		System.out.println(pat.about());
    	}
    	else if (classID == 2) {
    		pat = new Mage(name);
    		System.out.println(pat.about());
    	}
    	else if (classID == 3) {
    		pat = new Rogue(name);
    		System.out.println(pat.about());
    	}
    	else if (classID == 4) {
    		pat = new Priest(name);
    		System.out.println(pat.about());
    	}
    	else if (classID == 5) {
    		pat = new Ranger(name);
    		System.out.println(pat.about());
    	}
    	//System.out.println("ID:" + pat.getJobID());
    
    	//instantiate the player's character
    	//pat = new Warrior( name );
    
    
    }//end newGame()
    

    //boolean playTurn -- simulates a round of combat
    public boolean playTurn() {

	int i=1;
	int d1, d2;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "Nothing to see here. Move along!" );

	else {
	    System.out.println( "Lo, yonder monster approacheth!" );

	    Monster smaug = new Monster();

	    while(smaug.isAlive() && pat.isAlive()) {

		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
	do {		
		try {
		    System.out.println( "Your move, " + pat.getName() + "!" );
		    System.out.println( "\t1: Basic Attack\n\t2: Special Attack\n\t3: Info\n\t4: Status" );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }

		if ( i == 2 )
			{
		    pat.specialize();
			}
		else if (i == 1)
			{
		    pat.normalize();
			}
		else if (i == 3)
			{
			System.out.println(smaug.about()); 
			}
		else if (i == 4)
			{
			System.out.println(pat)	;
			}
		} while ((i == 3) || (i == 4));

	//	d1 = pat.attack( smaug );
	//	d2 = smaug.attack( pat );
if (pat.getJobID() == 3)
{
		System.out.println( pat.getName() + " dealt " + pat.attack(smaug) +
				    " points of damage.");

	if (!smaug.isAlive())
	{

			System.out.println(pat.getName() + " executed Ye Old Monster with such speed and precision that it could not strike back!");
	}
	else
	{
			System.out.println( "Ye Olde Monster hit back for " + smaug.attack(pat) +
					    " points of damage.");
	}
	
}
else
{
		System.out.println( pat.getName() + " dealt " + pat.attack(smaug) +
				    " points of damage.");

		System.out.println( "Ye Olde Monster hit back for " + smaug.attack(pat) +
				    " points of damage.");
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
		System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
		return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
		System.out.println( "Ye olde self hath expired. You got dead." );
		return false;
	    }
	}//end else

	return true;
    }//end playTurn()

    public static void main( String[] args ) {

	//loading...
	YoRPG game = new YoRPG();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
		    {break;}
	        encounters++;
	        System.out.println();
	}

	System.out.println( "Thy game doth be over." );

    }//end main

}//end class YoRPG
