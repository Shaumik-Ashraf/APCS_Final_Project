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
        super(player);
        element = "Aqua";
        
        bestStat ("Resistance");
        worstStat ("Luck");
		
		SkillSet.add("hailStorm");
		SkillSet.add("drizzle");
		SkillSet.add("aquaveil");
		
    }
	
	/* Now in Skill
    public void hailStorm (gChar enemy){
        
        SO.println (name + " began the Hail Storm!");
        int hits = 3;
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
        int hits = (int)(Math.random() *4);
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
        SO.println ("The ring of water increased " + name +"'s defenses!");
        def += 4;
       
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
	
	*/
	
}  //close class

