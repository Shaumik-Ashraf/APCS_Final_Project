/* MageW class - extend mage and implement wood
 * 
 * Notes:
 *	packaging everything
 *
 */

package gamechars;
 
import java.io.*;
import java.util.*;

public class MageW extends Mage implements Wood {
    
    public MageW (ArrayList<String> player){
        name = player.get(0);
        element = "Wood";
        
        //literally the stats for sMy Unit in Fire Emblem. ;)
        HP = 19;
        str = 2;
        magic = 14;
        def = 3;
        res = 5;
        luck = 3;
        speed = 5;
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
        System.out.println (name + " cast Wood Spike!");
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
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return damage; //Returns the damage dealt to enemy
    
        }
        
        
    //does multiple regular attacks   
    public int flowerDance(){
        System.out.println (name + " began the Flower Dance!");
        
        int hits = (int)(Math.random() *4);
        return hits;
    
        }
    
    
        
    public void pepperSong(){
        System.out.println (name + " cast Pepper Song!");
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