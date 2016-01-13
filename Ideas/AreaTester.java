/*
Test Area, Field, and Town class


*/


public final class AreaTester {   //final modifier means class cant be extended; no subclasses


	public static void main(String[] args) {
		
		ArrayList<Area> map = new ArrayList<Area>(10);
		//Fix: Character sora = new Warrior();

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
