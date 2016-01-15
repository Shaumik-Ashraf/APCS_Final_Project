/* ArcherA class - extend archer and implement Aqua
 * 
 * Notes:
 *	packaging everything
 *
 */

package gamechars;
 
import java.io.*;
import java.util.*;
import gameutils.*;
 

public class ArcherA extends Archer implements Aqua {
    
    public ArcherA (ArrayList<String> player){
        name = player.get(0);
        element = "Aqua";
        
        //literally the stats for My Unit in Fire Emblem. ;)
        HP = 21;
        str = 9;
        magic = 3;
        def = 3;
        res = 4;
        luck = 7;
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
        
        //SO.println( "Previous stats\n");
        //statSheet();
       // SO.println ("\n");
        bestStat (player.get(2));
        worstStat (player.get(3));
        
       // SO.println( "New stats\n");
       // statSheet();
       // SO.println ("\n");
    
    }
    
    public void hailStorm (gChar enemy){
        
        SO.println (name + " began the Hail Storm!");
        int hits = 3;
            while (hits != 0){
		        int damage = regAtkM( enemy );
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
        int hits = (int)(Math.random() *4);
        if (hits == 0 ){
            SO.println ("But it failed!");
        }
            while (hits != 0){
		        int damage = regAtk( enemy );
		    	if ( enemy.element.equals ("Fire") ){
            		this.typeAdv = true;
            		damage += regAtk( enemy );
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
        SO.println ("The ring of water increased " + name +"'s defenses!");
        def += 4;
       
    }
    
        
        
        
}