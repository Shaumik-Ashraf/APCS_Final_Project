//abstract area class for JASC

/* Usage:
I intend the following code to be in the main function:

ArrayList<Area> map = new ArrayList<Area>(10);

for(int i=0; i<map.size(); i++) {
	if( Math.random()*100 < 67 ) {  
		map[i] = new Field(i);  //constructor will create field named field-i
	}
	else {
		map[i] = new Town(i);  //likewise, town-i
	}
}

for(int i=0; i<map.size(); i++) {
	map[i].event(Character player);
}

*/

package gamearea;

import gamechars.*;


public abstract class Area {

	/*==================================================================
	  Attributes
	==================================================================*/
	protected String name;
	protected byte areatype;
	protected final byte AT_UNKNOWN = 0;
	protected final byte AT_TOWN = 1;
	protected final byte AT_FIELD = 2;
	
	
	/*==================================================================
	  constructors
	==================================================================*/
	public Area() {
		name = "<area_name>";
	}

	public Area(String name_arg) {
		name = name_arg;
		areatype = AT_UNKOWN;
	}
	
	/*==================================================================
	  accessors && mutators
	==================================================================*/
	public String getName() {
		return(name);
	}

	public String setName(String newName) {
		String temp = name;
		name = newName;
		return(temp);
	}
	
	/*==================================================================
	  abstract methods
	==================================================================*/
	public abstract void event(gChar gch);

	public abstract void description();
	
	/*==================================================================
	  static methods
	==================================================================*/
    
	//does battle between player and enemy
	//assumes player is user and enemy is AI
	//requires gChar methods: useAttack, useRandomAttack, doBattleTurn
	//optionally add: doAITurn, for more advanced AIs
	//does not incorporate exp or leveling as of now
	public static void battle(gChar player, gChar enemy) {

		Scanner sc = new Scanner(System.in);
		String input;

		SO.P("Enemy " + enemy + " encountered!\n");
		
		do {

			//invoke faster one's turn
			if( player.isFasterThan(enemy) ) {
				player.doBattleTurn();
			}
			else {
				//have enemy do stuff; can make better AIs later
				SO.P("It is the enemy's turn");
				enemy.useRandomAttack(player);
			}
			
			//invoke slower one's turn
			if( player.isFasterThan(enemy) ) {
				//have enemy do stuff; can make better AIs later
				SO.P("It is the enemy's turn");
				enemy.useRandomAttack(player);
			}
			else {
				player.doBattleTurn();
			}

			//check if anyone is dead
			if( !enemy.isAlive() && !player.isAlive() ) {
				SO.P("Draw...\n");
				break;
			}
			if( !enemy.isAlive() ) {
				SO.P("Enemy is dead\n");
				break;
			}
			if( !player.isAlive() ) {
				SO.P("You are dead\n");
				break;
			}
			
			SO.P("End of turn\n");
			
		} while(1);
	
	} //close battle method
    
	/*
	//Coming Soon!
	public static void battle(gChar player, gChar[] enemys) {}
	*/
	
}
