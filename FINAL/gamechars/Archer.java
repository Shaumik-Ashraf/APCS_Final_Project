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
	
	
	




}

