/* abstract Warrior class - contains and defines specific warrior methods
 * 
 * Notes:
 *	
 *
 */

package gamechars;

import gameutils.*;
import java.io.*;
import java.util.*;

public abstract class Warrior extends gChar{

    public int strongSwing(gChar enemy){
        SO.println(name + " used Strong Swing!");
        this.crit = false; //Crit activation is set to false
        int damage = this.str + 10 - enemy.def; //Work in progress. This is the damage that your character will do
        
        if ( (Math.random() *100) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.str + 10 )- (enemy.def /1.03) ) ;//This will be the new damage your character does
        }
        
        if (damage <= 0){
            damage = 0;
        }
        SO.println ("The enemy took " + damage + "!\n\n");
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return damage; //Returns the damage dealt to enemy
    }
    
    public int proudSwivel(gChar enemy){
    	SO.println (name + " throws the enemy!");
        this.crit = false; //Crit activation is set to false
        int damage = this.str + this.magic + 5 - enemy.def/2; //Work in progress. This is the damage that your character will do
        
        if ( (Math.random() *100) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.str + this.magic + 5 )- (enemy.def /1.03) ) ;//This will be the new damage your character does
        }
        
        if (damage <= 0){
            damage = 0;
        }
        SO.println ("The enemy took " + damage + "!\n\n");
        
        enemy.HP -= damage; //Final damage that your enemy will take
        SO.println (name + "'s attack decreases due to fatigue!")
        this.str *= .75;
        return damage; //Returns the damage dealt to enemy
        
       
    }
    
    public int finishingTouch (gChar enemy){
        SO.println (name + " enters a dangerous stance and lunges at the enemy!");
        this.crit = false; //Crit activation is set to false
        int damage = this.str + this.HP + this.def - enemy.def/4; //Work in progress. This is the damage that your character will do
        
        if ( (Math.random() *100) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.str + this.HP + this.def  )- (enemy.def /1.03) ) ;//This will be the new damage your character does
        }
        
        if (damage <= 0){
            damage = 0;
        }
        SO.println ("The enemy took " + damage + "!\n\n");
        SO.println (name + " loses a large amount of HP as recoil!");
        this.HP /= 3;
        
        enemy.HP -= damage; //Final damage that your enemy will take
    
        return damage; //Returns the damage dealt to enemy
    }

}