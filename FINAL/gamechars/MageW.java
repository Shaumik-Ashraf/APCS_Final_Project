/* MageW class - extend mage and implement wood
 * 
 * Notes:
 *	packaging everything
 *
 */

package gamechars;
 
import java.io.*;
import java.util.*;
import gameutils.*;
 

public class MageW extends Mage implements Wood {
    
    public MageW (ArrayList<String> player){
        name = player.get(0);
        element = "Wood";
        
        //literally the stats for sMy Unit in Fire Emblem. ;)
        HP = 16;
        str = 1;
        magic = 10;
        def = 3;
        res = 4;
        luck = 6;
        speed = 7;
        EXP = 0;
        level = 1;
        
        hpInitial = HP;
        strInitial = str;
        magicInitial = magic;
        defInitial = def;
        resInitial = res;
        luckInitial = luck;
        speedInitial = speed;
        
       
        bestStat (player.get(2));
        worstStat (player.get(3));
        

    }
    
     public int woodSpike(gChar enemy){
        SO.println (name + " cast Wood Spike!");
        this.crit = false; //Crit activation is set to false
        int damage = this.magic - enemy.def; //Work in progress. This is the damage that your character will do
        
        
        if ( (Math.random() *100) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.magic )- (enemy.def /1.03) ) ;//This will be the new damage your character does
        }
        
        if ( enemy.element.equals ("Aqua") ){
            this.typeAdv = true;
            damage *= 2;
        }
        
        if ( enemy.element.equals ("Fire") ){
            this.typeDis = true;
            damage /= 2;
        }
        
        if (damage <= 0){
            damage = 0;
        }
        SO.println ("The enemy took " + damage + "!\n\n");
        
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return damage; //Returns the damage dealt to enemy
    
        }
        
        
    //does multiple regular attacks   
    public void flowerDance(gChar enemy){
        SO.println (name + " began the Flower Dance!");
        
        int hits = (int)(Math.random() *7);
        if (hits == 0 ){
            SO.println (name + "trips!");
        }
            while (hits != 0){
		        int damage = regAtk( enemy );
		    	if ( enemy.element.equals ("Aqua") ){
            		this.typeAdv = true;
            		damage += regAtk( enemy );
        			}
        
        		if ( enemy.element.equals ("Fire") ){
            	    this.typeDis = true;
            		damage = bestow (enemy, damage);
    				}
		    	if (damage <= 0){
					damage = 0;
		    		}
				SO.println ("The enemy took " + damage + "!\n\n");
				hits --;
				this.str++;
            }
        this.str = this.strInitial;
        }
    
    
        
    public void pepperSong(){
        SO.println (name + " cast Pepper Song!");
        SO.println ("The soothing song refreshes " + name + ". Recovered 10 HP!");
        if (hpInitial > HP){
        HP += 10;
             if (HP > hpInitial){
                HP = hpInitial;
                SO.println (name + " has full HP now.");
            }
        }
        else {
            SO.println ("It had no effect!");}
        //healing = true;
      
    }
    
   
    
        
        
        
}