/* WarriorB class - extend warrior and implement Blank
 * 
 * Notes:
 *	packaging everything
 *
 */

package gamechars;
 
import java.io.*;
import java.util.*;
import gameutils.*;
 

public class WarriorB extends Warrior implements Blank {
    
    public WarriorB (ArrayList<String> player){
        name = player.get(0);
        element = "Blank";
        
        //literally the stats for My Unit in Fire Emblem. ;)
        HP = 10;
        str = 15;
        magic = 15;
        def = 5;
        res = 5;
        luck = 0;
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
    
   public int noisePulse(gChar enemy){
        SO.println ("Drown in noise...");
        this.crit = false; //Crit activation is set to false
        int damage = ((this.magic+this.str)/2) - enemy.res; //Work in progress. This is the damage that your character will do
        
        
        if ( (Math.random() *100) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (((this.magic+this.str)/2) )- (enemy.res /1.03) ) ;//This will be the new damage your character does
        }
        
        if ( ( enemy.element.equals ("Dark") ) ||( enemy.element.equals ("Light") ) ){
            this.typeAdv = true;
            damage *= 2;
        }
        
        
        if (damage <= 0){
            damage = 0;
        }
        
        SO.println ("The enemy took " + damage + "!\n\n");
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return damage; //Returns the damage dealt to enemy
    
        }
        
        
    //does damage on res based on str stat    
    public int gravity (gChar enemy){
        SO.println ("Down.");
       
        int damage = enemy.HP /4; //Work in progress. This is the damage that your character will do

        
        if ( ( enemy.element.equals ("Wood") ) ||  ( enemy.element.equals ("Fire") ) ||  ( enemy.element.equals ("Aqua") ) ||  ( enemy.element.equals ("Gale") ) ){
            this.typeAdv = true;
            damage *= 2;
        }
        
        if (damage <= 0){
            damage = 0;
        }
        SO.println ("The enemy took " + damage + "!\n\n");
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return damage; //Returns the damage dealt to enemy
    
        }
    
    
        
    public void abnormalize(){
        SO.println ("This is the end...");
        SO.println (name + " becomes one with the void. Offensive stats have drastically increased!");
        str *= 2;
        magic *= 2;
        speed *= 2;
    }
    
    public String skillListChange( String skillList){
        if (this.level == 2){
            skillList += "Proud Swivel\n";
            System.out.println (this.name + " learned Proud Swivel!");
        }
        
        if (this.level == 3){
            skillList += "Finishing Touch\n";
            System.out.println (this.name + " learned Finishing Touch!");
        }
        
        return skillList;
    }
    
    public ArrayList<String> skillChange( ArrayList<String> skills){
         if (this.level == 2){
             skills.add ("Proud Swivel");
         }
         if (this.level == 3){
             skills.add ("Finishing Touch");
         }
         return skills;
    }
    
        
        
        
}