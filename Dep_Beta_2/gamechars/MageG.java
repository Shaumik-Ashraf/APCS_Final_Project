/* MageG class - extend Mage and implement Gale
 * 
 * Notes:
 *	packaging everything
 *
 */

package gamechars;
 
import java.io.*;
import java.util.*;
import gameutils.*;
 

public class MageG extends Mage implements Gale {
    
    public MageG (ArrayList<String> player){
        name = player.get(0);
        element = "Gale";
        
        //literally the stats for My Unit in Fire Emblem. ;)
        HP = 16;
        str = 3;
        magic = 9;
        def = 3;
        res = 3;
        luck = 3;
        speed = 10;
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
    
    public int windStrike(gChar enemy){
        SO.println (name + " cast Wind Strike!");
        this.crit = false; //Crit activation is set to false
        int damage = this.magic - enemy.def; //Work in progress. This is the damage that your character will do
        
        
        if ( (Math.random() *100) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.magic )- (enemy.def /1.03) ) ;//This will be the new damage your character does
        }
        /*
        if ( enemy.element.equals ("Fire") ){
            this.typeAdv = true;
            damage *= 2;
        }
        
        if ( enemy.element.equals ("Aqua") ){
            this.typeDis = true;
            damage /= 2;
        }*/
        
        if (damage <= 0){
            damage = 0;
        }
        SO.println ("The enemy took " + damage + "!\n\n");
        
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return damage; //Returns the damage dealt to enemy
    
        }
        
        
    //does multiple regular attacks   
    public int galeForce(gChar enemy){
       SO.println (name + " cast Wind Strike!");
        this.crit = false; //Crit activation is set to false
        int damage = this.magic - enemy.res; //Work in progress. This is the damage that your character will do
        
        
        if ( (Math.random() *60) <= luck){
            this.crit = true; //Crit activation is set to true
            damage = (int)( (this.magic )- (enemy.res /1.03) ) ;//This will be the new damage your character does
        }
        
      /*  if ( enemy.element.equals ("Fire") ){
            this.typeAdv = true;
            damage *= 2;
        }
        
        if ( enemy.element.equals ("Aqua") ){
            this.typeDis = true;
            damage /= 2;
        }*/
        
        if (damage <= 0){
            damage = 0;
        }
        SO.println ("The enemy took " + damage + "!\n\n");
        
        
        enemy.HP -= damage; //Final damage that your enemy will take
        return damage; //Returns the damage dealt to enemy
    
        }
    
    
        
    public void tailWind(){
        SO.println (name + " started a Tail Wind!");
        SO.println ("The gust of wind made " + name + " faster!");
        speed += 4;
    }

    public String skillListChange( String skillList){
        if (this.level == 2){
            skillList += "Arcane Bullets\n";
            System.out.println (this.name + " learned Arcane Bullets!");
        }
        
        if (this.level == 3){
            skillList += "Concentrate\n";
            System.out.println (this.name + " learned Concentrate!");
        }
        
        return skillList;
    }
    
    public ArrayList<String> skillChange( ArrayList<String> skills){
         if (this.level == 2){
             skills.add ("Arcane Bullets");
         }
         if (this.level == 3){
             skills.add ("Concentrate");
         }
         return skills;
    }
   
    
        
        
        
}