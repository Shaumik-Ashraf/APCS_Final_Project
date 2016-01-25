import java.io.*;
import java.util.*;

public class Reaper extends GChar{
    
    public Reaper()
    {
        level = 100;
        name = "Fatal Scythe";
        element = "Dark";
        hpInitial = HP = 15000;
        mpInitial = MP = 999999;
        strInitial = str = 225;
        magicInitial = magic = 100;
        defInitial = def = 100;
        resInitial = res = 50;
        luckInitial = luck = 40;
        speedInitial = speed = 150;
        EXP = 1000;
        gold = 9999;
        i= new Inventory ("MA's Eviscerator");
        
        //20% to use basic attack
        known.add ("Basic Attack");
        known.add ("Basic Attack");
        
        //30% to use drain skills
        known.add ("Brain Shock");
        known.add ("Brain Shock");
        known.add ("Vampire");
        known.add ("Vampire");
        
        //40% to use skills
        known.add ("Strong Swing");
        known.add ("Assassinate");
        known.add ("Blood Rain");
        known.add ("Darkness");


    }
}