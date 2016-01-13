/* WarriorA class - extend warrior and implement Aqua
 * 
 * Notes:
 *	packaging everything
 *
 */

package gamechars;
 
import java.io.*;
import java.util.*;

public class WarriorA extends Warrior implements Aqua {
    
    public WarriorA (ArrayList<String> player){
        name = player.get(0);
        element = "Aqua";
        
        //literally the stats for My Unit in Fire Emblem. ;)
        HP = 19;
        str = 9;
        magic = 5;
        def = 4;
        res = 4;
        luck = 4;
        speed = 6;
        EXP = 0;
        
        hpInitial = HP;
        strInitial = str;
        magicInitial = magic;
        defInitial = def;
        resInitial = res;
        luckInitial = luck;
        speedInitial = speed;
        
        //System.out.println( "Previous stats\n");
        //statSheet();
       // System.out.println ("\n");
        bestStat (player.get(2));
        worstStat (player.get(3));
        
       // System.out.println( "New stats\n");
       // statSheet();
       // System.out.println ("\n");
    
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
        HP += 8;
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