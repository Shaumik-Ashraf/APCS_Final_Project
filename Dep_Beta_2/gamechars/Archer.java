/* abstract Archer class - contains and defines specific Archer methods
 * 
 * Notes:
 *	
 *
 */

package gamechars;
import gameutils.*;
 
import java.io.*;
import java.util.*;

public abstract class Archer extends gChar{

	public int bowThrow(gChar enemy) {
		SO.println (name + " threw a bow.");
		this.crit = false;
		int damage = this.str - enemy.def/2;

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
        
    public void arrowStorm(gChar enemy){
    	 SO.println (name + " fired some arrows into the sky.");
        
        int hits = (int)(Math.random() *5);
        if (hits == 0 ){
            SO.println (" The arrows miss " + enemy.name +"!");
        }
            while (hits != 0){
		        int damage = regAtk( enemy );
		    	if (damage <= 0){
					damage = 0;
		    		}
				SO.println ("The enemy took " + damage + "!\n\n");
				hits --;
            }
        
    }
    
    public void focus (){
    	SO.println (name + " begins to concentrate! Offensive stats have increase!");
    	SO.println (name + " is more vulnerable to enemy attacks!");
    	str *= 1.5;
    	luck *= 1.5;
    	def /= 2;
    	res /= 2;
    }
	
	
	




}

