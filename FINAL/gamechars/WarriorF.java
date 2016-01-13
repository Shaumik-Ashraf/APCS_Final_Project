/* WarriorF class - extend warrior and implement Fire
 * 
 * Notes:
 *	packaging everything
 *
 */

package gamechars;
 
import java.io.*;
import java.util.*;

public class WarriorF extends Warrior implements Fire {
    
    public WarriorF (ArrayList<String> player){
        name = player.get(0);
        element = "Fire";
        
        //literally the stats for My Unit in Fire Emblem. ;)
        HP = 19;
        str = 8;
        magic = 6;
        def = 6;
        res = 1;
        luck = 4;
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
        
        //System.out.println( "Previous stats\n");
        //statSheet();
       // System.out.println ("\n");
        bestStat (player.get(2));
        worstStat (player.get(3));
        
       // System.out.println( "New stats\n");
       // statSheet();
       // System.out.println ("\n");
    }
    
    public int heatWave(gChar enemy){
        System.out.println (name + " cast Heat Wave!");
        this.crit = false; //Crit activation is set to false
        int damage = this.magic - enemy.res; //Work in progress. This is the damage that your character will do
        
        
        if ( (Math.random() *100) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.magic )- (enemy.res /1.03) ) ;//This will be the new damage your character does
        }
        
        if ( enemy.element.equals ("Wood") ){
            this.typeAdv = true;
            damage *= 2;
        }
        
        if ( enemy.element.equals ("Aqua") ){
            this.typeDis = true;
            damage /= 2;
        }
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return damage; //Returns the damage dealt to enemy
    
        }
        
        
    //does damage on res based on str stat    
    public int flameCrash(gChar enemy){
        System.out.println (name + " used Flame Crash!");
        this.crit = false; //Crit activation is set to false
        int damage = this.str - enemy.res; //Work in progress. This is the damage that your character will do
        
        
        if ( (Math.random() *100) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.str )- (enemy.res /1.03) ) ;//This will be the new damage your character does
        }
        
        if ( enemy.element.equals ("Wood") ){
            this.typeAdv = true;
            damage *= 2;
        }
        
        if ( enemy.element.equals ("Aqua") ){
            this.typeDis = true;
            damage /= 2;
        }
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return damage; //Returns the damage dealt to enemy
    
        }
    
    
        
    public void reKindle(){
        System.out.println (name + " cast Rekindle!");
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