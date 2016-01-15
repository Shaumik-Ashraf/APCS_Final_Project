
package gamechars;

import java.io.*;
import java.util.*;

public class Monster extends gChar{
        public Monster(){
            name = "Jellyfish";
            element = "Aqua";
            HP = 20;
            str = 7;
            magic = 0;
            def = 3;
            res = 3;
            luck = 1;
            speed = 11;
            EXP = 100;
            
            hpInitial = HP;
            strInitial = str;
            magicInitial = magic;
            defInitial = def;
            resInitial = res;
            luckInitial = luck;
            speedInitial = speed;
        }
        
        public String skillListChange( String skillList){
            return "No.";
        }
        
        public ArrayList<String> skillChange(ArrayList<String> skills){
            ArrayList<String> No = new ArrayList<String>();
            return No;
        }
        
}