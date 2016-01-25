import java.io.*;
import java.util.*;

public class King extends GChar{
    
    public King()
    {
        level = 100;
        name = "King of the Jungle";
        element = "Wood";
        hpInitial = HP = 5000;
        mpInitial = MP = 999999;
        strInitial = str = 80;
        magicInitial = magic = 80;
        defInitial = def = 35;
        resInitial = res = 35;
        luckInitial = luck = 30;
        speedInitial = speed = 80;
        EXP = 1000;
        gold = 9999;
        i= new Inventory ("Darksteel Bow");
        
        //40% to use basic attack
        known.add ("Basic Attack");
        known.add ("Basic Attack");
        known.add ("Basic Attack");
        known.add ("Basic Attack");
        
        //60% to use skills
        known.add ("Quick Draw");
        known.add ("Flower Dance");
        known.add ("Wood Spike");
        known.add ("Seed Burst");
        known.add ("Pepper Song");
        known.add ("Spiral Assault");
    }
}