/* abstract Mage class - contains and defines specific Mage methods
 * 
 * Notes:
 *	
 *
 */

package gamechars;

import gameutils.*;
import gameitems.*;
 
import java.io.*;
import java.util.*;

public abstract class Mage extends gChar{

	//Constructors
	public Mage() {
		super();
	}
	
	public Mage(ArrayList<String> builder) {
		super(builder);
		inv = new Inventory("Wooden Pole");  // Error??? "Wooden Pole"
		
		bestStat("Magic");
        worstStat("Strength");
        
		SkillSet.add("Arcanite Force");
		SkillSet.add("Arcane Bullets");
		SkillSet.add("Concentrate");
		
	}
	
	/* Skills now defined in Skill.class !!!
	public int arcaniteForce(gChar enemy) {
		SO.println (name + "cast Arcanite Force!");
		this.crit = false;
		int damage = this.magic - enemy.res + 10;

		if ( (Math.random() *100) <=luck){
		    this.crit = true;
		    damage = (int)(damage*1.03);
		}
		
		if (damage <= 0){
            damage = 0;
        }
        SO.println ("The enemy took " + damage + "!\n\n");
		enemy.HP -= damage;
		return(damage);

        }
        
    public void arcaneBullets (gChar enemy){
    	SO.println (name + " surrounds the enemy with magical orbs.");
        
        int hits = 3;
       
            while (hits != 0){
		        int damage = regAtkM( enemy );
		    	if (damage <= 0){
					damage = 0;
		    		}
				SO.println ("The enemy took " + damage + "!\n\n");
				hits --;
            }
       
    }
    
    public void concentrate(){
    	SO.println (name + " begins to chant magical incantations.");
    	SO.println ("Magic damage have increased dramatically! Speed and luck have decresed.");
    	magic *= 2;
    	speed /= 2;
    	luck /= 2;
    }
	
	*/
	

}

