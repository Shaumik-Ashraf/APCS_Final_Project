//abstract area class for JASC

/* Usage:
I intend the following code to be in the main function:

ArrayList<Area> map = new ArrayList<Area>(10);

map.add(new Town());
for(int i=1; i<10; i++) {
	if( Math.random()*100 < 67 ) {  
		map.add(i, new Field(i));  //constructor will create field named field-i
	}
	else {
		map.add(i, new Town(i));  //likewise, town-i
	}
}

for(int i=0; i<map.size(); i++) {
	(map.get(i)).event(player);
}

*/

package gameareas;

import java.util.*;

import gamechars.*;
import gameutils.*;
import gameskills.*;
import gameitems.*;

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
		areatype = AT_UNKNOWN;
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
	
	
}
