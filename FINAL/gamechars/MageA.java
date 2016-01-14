/* MageA class - extend mage and implement aqua
 * 
 * Notes:
 *	packaging everything
 *
 */

package gamechars;
 
import java.io.*;
import java.util.*;
import gameutils.*;
 

public class MageA extends Mage implements Aqua {
    
    public MageA (ArrayList<String> player){
        name = player.get(0);
        element = "Aqua";
        
        //literally the stats for sMy Unit in Fire Emblem. ;)
        HP = 19;
        str = 5;
        magic = 11;
        def = 4;
        res = 4;
        luck = 5;
        speed = 6;
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
    public void hailStorm (gChar enemy){
        
        SO.println (name + " began the Hail Storm!");
        int hits = 2;
            while (hits != 0){
		        int damage = regAtk( enemy );
		    	if ( enemy.element.equals ("Wood") ){
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
            }

        }
        
        
    //does damage on res based on str stat    
    public void drizzle(gChar enemy){
        SO.println (name + " cast Drizzle!");
        int hits = (int)(Math.random() *6);
        if (hits == 0 ){
            SO.println ("But it failed!");
        }
            while (hits != 0){
		        int damage = regAtkM( enemy );
		    	if ( enemy.element.equals ("Fire") ){
            		this.typeAdv = true;
            		damage += regAtkM( enemy );
        			}
        
        		if ( enemy.element.equals ("Aqua") ){
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
    
    
        
    public void aquaVeil(){
        SO.println (name + " cast Aqua Veil!");
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
        str = 0;
        magic = 0;
    }
}