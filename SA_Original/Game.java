/**
 * Game
 * main code of game
 */
package main;

/**
 * @author Shaumik Ashraf
 * should learn the author annotations...
 */

//import other packages HERE

public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if( args.length < 1 ) {
			System.err.println("Error, incorrect options. Enter \"Game --help\" for help.");
		}
		else if( "--help".equals(args[0]) ) {
			System.out.println("Game - An MMORPG\n");
			
			System.out.println("Options:");
			System.out.println("\t--help - output help for Game");
			System.out.println("\t--solo - play Game solo");
			System.out.println("\t--multi - play Game on Server, DO NOT use this option as user, rather run init...\n");
		
			System.out.println("Credits:");
			System.out.println("\tAuthors:");
			System.out.println("\t\tShaumik Ashraf\n");
			
			System.out.println("END");
		}
		else if( "--solo".equals(args[0]) ) {
			Game_helper_solo.play();
		}
		else if( "--multi".equals(args[0])) {
			;
			/* IMPLEMENT CODE HERE
			 * will prbly make Game_helper_multi class call Game_helper_multi.play()
			 * remember to have ipc with client/communicator.c via file IO on fifo
			 * */
		}
		else {
			System.err.println("Error, incorrect options. Enter \"Game --help\" for help.");
		}

	}

}
