import java.io.*;
import java.util.*;

public class Brown extends GChar{
    
    public Brown()
    {
        level = 100;
        name = "Mr.Brown";
        element = Blank;
        hpInitial = HP = 25000;
        mpInitial = MP = 0;
        strInitial = str = 250;
        magicInitial = magic = 250;
        defInitial = def = 150;
        resInitial = res = 150;
        luckInitial = luck = 50;
        speedInitial = speed = 200;
        EXP = 1000;
        gold = 9999;
        i= new Inventory ("Zweihänder")
        
        known.add ("Keys to Success");
        known.add ("Wadatah");
        known.add ("Day of Relaxation");
        known.add ("Beard of Justice");
        known.add ("Bun of Fate");

    }
    