/* abstract Mage class - contains and defines specific Mage methods
 * 
 * Notes:
 *	
 *
 */

package gamechars;
 
import java.io.*;
import java.util.*;

public abstract class Mage extends Character{

	public Mage() {
		//super(); ?
		skillList.add("ArcaniteForce");
	}

	public abstract int useSkill(String skill);
	
    public int classAtk1(Character enemy){
        
		//String atkName = new String("ArcaniteForce");
		
		//Stolen from Warrior=========================
		this.crit = false; //Crit activation is set to false
        int damage = this.str + 10 - enemy.def; //Work in progress. This is the damage that your character will do
        
        if ( (Math.random() *100) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.str + 10 ) - (enemy.def /1.03) ) ;//This will be the new damage your character does
        }
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return(damage); //Returns the damage dealt to enemy
    
	}

	public abstract int elemAtk1();
	
	public abstract int elemAtk2();
	
}

