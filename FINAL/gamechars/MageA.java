/* MageA class - extend mage and implement aqua
 * 
 * Notes:
 *	packaging everything
 *
 */

package gamechars;
 
import java.io.*;
import java.util.*;

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
    public int hailStorm (){
        
        System.out.println (name + " began the Hail Storm!");
        int hits = 2;
        return hits;
        
        }
        
        
    //does damage on res based on str stat    
    public int drizzle(){
        System.out.println (name + " cast Drizzle!");
        int hits = (int)(Math.random() *5);
        return hits;
        }
    
    
        
    public void aquaVeil(){
        System.out.println (name + " cast Aqua Veil!");
        if (hpInitial > HP){
        HP += 10;
             if (HP > hpInitial){
                HP = hpInitial;
                System.out.println (name + " has full HP now.");
            }
        }
        else {
            System.out.println ("It had no effect!");}
        //healing = true;
        str = 0;
        magic = 0;
    }
}