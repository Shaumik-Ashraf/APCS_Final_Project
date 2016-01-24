/* World class
	will just be a matrix of areas and have main gameplay

	Note: java.util contains Random, a class for seeding and generating random numbers
	
*/

import java.util.*;

public class World {

	public int world_size;
	public Area[][] world;
	public int player_x_cor;
	public int player_y_cor;
	public long world_seed;
	public Random rand;
	
    public World(ArrayList<GChar> party) {
		world_size = 3;
		world = new Area[world_size][world_size];
		
		world_seed = (long)(Math.random()*Math.random()*Math.random()*Math.random()*1000);
		rand = new Random(world_seed);
		
		player_x_cor = Math.abs(rand.nextInt()) % world_size;
		player_y_cor = Math.abs(rand.nextInt()) % world_size;
		
		for(int i=0; i<world_size; i++) {
			for(int j=0; j<world_size; j++) {
				switch( rand.nextInt()%3 ) {
					case 0:
						world[i][j] = new AreaTown(party);
						break;
					case 1:
						world[i][j] = new AreaField(party);
						break;
					case 2:
						world[i][j] = new AreaDungeon(party);
						break;
					default:
						break;
				}  //close switch
			} //close for-loop j
		} //close for-loop i
	} //close constructor
	
	public World(ArrayList<GChar> party, int worldsize, long worldseed) {
		world_size = worldsize;
		world = new Area[world_size][world_size];
		
		world_seed = worldseed;
		rand = new Random(world_seed);
		
		player_x_cor = rand.nextInt();//(rand.nextInt()*rand.nextInt()) % world_size;
		player_y_cor = rand.nextInt();//(rand.nextInt()*rand.nextInt()) % world_size;
		
		for(int i=0; i<world_size; i++) {
			for(int j=0; j<world_size; j++) {
				switch( rand.nextInt()%3 ) {
					case 0:
						world[i][j] = new AreaTown(party);
						break;
					case 1:
						world[i][j] = new AreaField(party);
						break;
					case 2:
						world[i][j] = new AreaDungeon(party);
						break;
					default:
						break;
				}  //close switch
			} //close for-loop j
		} //close for-loop i
	} //close constructor
	
	public Area getArea() {
		return( world[player_x_cor][player_y_cor] );
	}
	
	public static void main(String[] args) {
	
		ArrayList<GChar> p = new ArrayList<GChar>();
		Scanner in = new Scanner(System.in);
		World w;
		
		Creator.initCreator();
	
		p.add( Creator.characterCreation() );
		p.add( Creator.characterCreation() );
		
		w = new World(p);
	
		System.out.print("World created\nx: " + w.player_x_cor + ", y:" + w.player_y_cor + "\n\n");
		
		for(int turn=0; turn<10; turn++) {
			System.out.println("turn: " + turn );
			if( (w.getArea()).noMoreEvents() ) {  //player cleared area...
				
				w.getArea().restore(p);
				
				System.out.println("You have cleared the area!\nWhere would you like to go?\n");
				System.out.print("North\nSouth\nEast\nWest\nStay here\n\n:");
				
				if( in.hasNextLine() ) {  //prompt for direction to travel
					switch( in.nextLine() ) {
						case "North":
							w.player_y_cor--;
							if( w.player_y_cor<0 ) {
								w.player_y_cor = w.world_size-1;
							}
							break;
						case "South":
							w.player_y_cor++;
							w.player_y_cor %= w.world_size;
							break;
						case "East":
							w.player_x_cor++;
							w.player_x_cor %= w.world_size;
							break;
						case "West":
							w.player_x_cor--;
							if( w.player_x_cor<0 ) {
								w.player_x_cor = w.world_size-1;
							}
							break;
						case "Stay here":
							break;
						default:
							System.out.println("This isnt your GPS! Please enter a proper direction.\n");
							break;
					} //close switch-case
				} //close if input
				
			} //close if player cleared area
			else {
				p = w.getArea().callEvent(p);
			}
			
		} //close loop
	
	} //close main
	
}

