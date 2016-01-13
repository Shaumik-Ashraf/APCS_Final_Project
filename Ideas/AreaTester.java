/*
Test Area, Field, and Town class


*/


public final class AreaTester {   //final modifier means class cant be extended; no subclasses


	public static void main(String[] args) {
		
		ArrayList<Area> map = new ArrayList<Area>(10);

		ArrayList<String> sora_builder = new ArrayList<String>();
		sora_builder.add("Sora");
		sora_builder.add("Warrior");
		sora_builder.add("Health");
		sora_builder.add("Health");
		sora_builder.add("Calm");
		Character sora = new WarriorW( sora_builder ); 


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
		
		
		
		
	}
	
	
	
	

}
