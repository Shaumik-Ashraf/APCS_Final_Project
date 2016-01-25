
import java.io.*;
import java.util.*;

public class Luna extends GChar{
    
    public Luna()
    {
        level = 100;
        name = "Lightning God Dragon";
        element = "Light";
        hpInitial = HP = 8000;
        mpInitial = MP = 999999;
        strInitial = str = 150;
        magicInitial = magic = 150;
        defInitial = def = 75;
        resInitial = res = 75;
        luckInitial = luck = 40;
        speedInitial = speed = 100;
        EXP = 1000;
        gold = 9999;
        i= new Inventory ("Emerald Redwood Staff");
        
        //40% to use basic attack
        known.add ("Basic Attack");
        known.add ("Basic Attack");
        known.add ("Basic Attack");
        known.add ("Basic Attack");
        
        //60% to use skills
        known.add ("Pepper Song");
        known.add ("Heat Wave");
        known.add ("Tidal Wave");
        known.add ("Heavenly Light");
        known.add ("Luster Wave");
        known.add ("Feather Duster");
    }
}