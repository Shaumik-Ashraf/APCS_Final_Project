import java.io.*;
import java.util.*;

public class WarriorF extends Character implements Fire{
    
    public WarriorF (ArrayList<String> player){
        name = player.get(0);
        
        //literally the stats for My Unit in Fire Emblem. ;)
        HP = 19;
        str = 6;
        magic = 5;
        def = 6;
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
        
        
        
}
