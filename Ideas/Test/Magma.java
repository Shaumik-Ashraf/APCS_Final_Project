import java.io.*;
import java.util.*;

public class Magma extends GChar{
    
    public Magma()
    {
        level = 100;
        name = "Magma Glider";
        element = "Fire";
        hpInitial = HP = 2000;
        mpInitial = MP = 999999;
        strInitial = str = 40;
        magicInitial = magic = 50;
        defInitial = def = 20;
        resInitial = res = 20;
        luckInitial = luck = 10;
        speedInitial = speed = 50;
        EXP = 1000;
        gold = 9999;
        i= new Inventory ("Oak Wand");
        
        //50% to use basic attack
        known.add ("Basic Attack");
        known.add ("Basic Attack");
        known.add ("Basic Attack");
        known.add ("Basic Attack");
        known.add ("Basic Attack");
        
        //50% to use skills
        known.add ("Arcanite Force");
        known.add ("Heat Wave");
        known.add ("Rekindle");
        known.add ("Flame Crash");
        known.add ("Strong Swing");
        
    }
}