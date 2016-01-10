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


public abstract class Area {

	//attributes
	private String name;   //should we use private atttributes as proper, or just make everything public?
	                       //my IDE can generate accessors/mutators...
	
	//constructors
	public Area(String name_arg) {
		name = name_arg;
	}
	
	//accessors
	public String getName(void) {
		return(name);
	}
	
	//mutators
	public String setName(String newName) {
		String temp = name;
		name = newName;
		return(temp);
	}
	
	//abstract methods
	public abstract void event(Character ch);

	public abstract void description();
	
}
