/* abstract Warrior class - contains and defines specific warrior methods
 * 
 * Notes:
 *	
 *
 */

package gamechars;
 
import java.io.*;
import java.util.*;

public abstract class Warrior extends gChar{

    public int strongSwing(gChar enemy){
        this.crit = false; //Crit activation is set to false
        int damage = this.str + 10 - enemy.def; //Work in progress. This is the damage that your character will do
        
        if ( (Math.random() *100) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.str + 10 )- (enemy.def /1.03) ) ;//This will be the new damage your character does
        }
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return damage; //Returns the damage dealt to enemy
    }

}