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
    
    public int hailStorm (gChar enemy){
        
        System.out.println (name + " began the Hail Storm!");
        int hits = 3;
        return hits;
    
        
       /* this.crit = false; //Crit activation is set to false
        int damage = this.str*1.5 - enemy.res; //Work in progress. This is the damage that your character will do
        
        
        if ( (Math.random() *100) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.str*1.5)- (enemy.res /1.03) ) ;//This will be the new damage your character does
        }
        
        if ( enemy.element.equals ("Fire") ){
            this.typeAdv = true;
            damage *= 2;
        }
        
        if ( enemy.element.equals ("Wood") ){
            this.typeDis = true;
            damage /= 2;
        }
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return damage; //Returns the damage dealt to enemy*/
    
        }
        
        
    //does damage on res based on str stat    
    public int drizzle(gChar enemy){
        System.out.println (name + " cast Drizzle!");
        int hits = (int)(Math.random() *8);
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