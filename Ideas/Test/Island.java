import java.io.*;
import java.util.*;

public class Island extends GChar{
    
    public Island()
    {
        level = 100;
        name = "Island Eater";
        element = "Aqua";
        hpInitial = HP = 3500;
        mpInitial = MP = 999999;
        strInitial = str = 80;
        magicInitial = magic = 80;
        defInitial = def = 40;
        resInitial = res = 30;
        luckInitial = luck = 30;
        speedInitial = speed = 10;
        EXP = 1000;
        gold = 9999;
        i= new Inventory ("Steel Longsword");
        
        //40% chance to use basic attack
        known.add ("Basic Attack");
        known.add ("Basic Attack");
        known.add ("Basic Attack");
        known.add ("Basic Attack");
        
        //60% chance to use skills
        known.add ("Hail Storm");
        known.add ("Tidal Wave");
        known.add ("Icicle Charge");
        known.add ("Seed Burst");
        known.add ("Feather Duster");
        known.add ("Hurricane Force");
    }
}