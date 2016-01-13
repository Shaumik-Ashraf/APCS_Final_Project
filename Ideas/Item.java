//Superclass for Items - potions, equips, etc.
import java.util.*;
public abstract class Item
{
    protected boolean consumable;
    protected boolean collectable;
    protected boolean equip;
    protected boolean important;
    public String name;
    
    public abstract void use();
    public abstract int[] getStats(String itemName, String type);
    
    public static HashMap<String, int[]> weapons = new HashMap<String, int[]>(); //Creates dictionary of items, uses name to label lists of weapon stats. Weapon data accessed by name. Array contains data in order of definitions in equipable
    public static HashMap<String, int[]> armor = new HashMap<String, int[]>(); //Creates dictionary of items, uses name to label lists of armor stats. Armor data accessed by name. Array contains data in order of definitions in equipable    
    public static void consEquipList()
    {
        /* ------WEAPON DATABASE------ */
        
        /* --DAGGERS-- */
        weapons.put("Bronze Dagger", new int[] {0,10,0,0,35,0,0,1});
        weapons.put("Iron Dagger", new int[] {0,13,0,0,40,0,0,1});
        weapons.put("Steel Dagger", new int[] {0,16,0,0,43,0,0,1});
        weapons.put("Darksteel Dagger", new int[] {0,22,0,0,50,0,0,1});
        weapons.put("Mithril Dagger", new int[] {0,25,0,0,58,0,0,1});
        weapons.put("Obsidian Dagger", new int[] {0,28,0,0,67,0,0,1});
        weapons.put("MA's Eviscerator", new int[] {0,37,0,0,90,0,0,1});
        /* ----------- */
        
        /* --Longswords-- */
        weapons.put("Bronze Longsword", new int[] {0,15,0,5,25,0,0,1});
        weapons.put("Iron Longsword", new int[] {0,18,0,10,25,0,0,1});
        weapons.put("Steel Longsword", new int[] {0,21,0,15,35,0,0,1});
        weapons.put("Darksteel Longsword", new int[] {0,28,0,20,38,0,0,1});
        weapons.put("Mithril Longsword", new int[] {0,33,0,25,40,0,0,1});
        weapons.put("Obsidian Longsword", new int[] {0,38,0,30,45,0,0,1});
        /* -------------- */
        
        /* --Greatswords-- */
        weapons.put("Bronze Greatsword", new int[] {0,20,0,0,10,0,0,1});
        weapons.put("Iron Greatsword", new int[] {0,25,0,0,15,0,0,1});
        weapons.put("Steel Greatsword", new int[] {0,35,0,0,15,0,0,1});
        weapons.put("Darksteel Greatsword", new int[] {0,38,0,0,23,0,0,1});
        weapons.put("Mithril Greatsword", new int[] {0,43,0,0,15,0,0,1});
        weapons.put("Obsidian Greatsword", new int[] {0,48,0,0,15,0,0,1});
        weapons.put("Zweihänder", new int[] {0,75,0,0,10,0,0,1});
        /* --------------- */   
        
        /* --STAFFS-- */
        weapons.put("Wooden Pole", new int[] {0,0,16,0,25,0,0,1});
        weapons.put("Oak Staff", new int[] {0,0,21,0,22,0,0,1});
        weapons.put("Ruby Oak Staff", new int[] {0,0,28,0,20,0,0,1});
        weapons.put("Redwood Staff", new int[] {0,0,31,0,17,0,0,1});
        weapons.put("Ruby Redwood Staff", new int[] {0,0,35,0,15,0,0,1});
        weapons.put("Emerald Redwood Staff", new int[] {0,0,42,0,12,0,0,1});
            /* ---------- */
    
        /* --WANDS-- */
        weapons.put("Wooden Stick", new int[] {0,0,14,0,25,0,0,1});
        weapons.put("Oak Wand", new int[] {0,0,18,0,30,0,0,1});
        weapons.put("Ruby Oak Wand", new int[] {0,0,23,0,36,0,0,1});
        weapons.put("Redwood Wand", new int[] {0,0,27,0,39,0,0,1});
        weapons.put("Ruby Redwood Wand", new int[] {0,0,30,0,43,0,0,1});
        weapons.put("Emerald Redwood Wand", new int[] {0,0,35,0,49,0,0,1});
        weapons.put("Moocao's Little Rod", new int[] {0,0,50,0,75,0,0,1});
        /* --------- */    
        
        /* ------ARMOR DATABASE------ */
        
        /* --HEAD-- */
        armor.put("Wooden Helmet", new int[] {10,0,0,5,0,5,0,2});
        /* -------- */
        
        /* --BODY-- */
        armor.put("Copper Chestplate", new int[] {15,0,0,10,0,10,0,3});
        /* -------- */
        
        /* --LEGS-- */
        armor.put("Leather Pants", new int[] {5,0,0,5,0,5,0,4});        
        /* -------- */
        
        /* --FEET-- */
        armor.put("Leather Boots", new int[] {5,0,0,5,5,5,0,5});    
        /* -------- */
        
        /* --ACCESSORY-- */
        armor.put("Broken Glasses", new int[] {0,0,0,0,0,0,5,6});    
        /* ------------- */
        
        /* -------------------------- */
        System.out.println("List Constructed");
    }
    
    public String toString() {return name;}

}
    
    
abstract class Equipable extends Item
{
    protected int defMod;
    protected int strMod;
    protected int magicMod;
    protected int resMod;
    protected int speedMod;
    protected int hpMod;
    protected int mpMod;
    protected int slot;
    
    public void use()
    {
        System.out.println("Nothing Happens");
    }
    
    public int getDefMod() {return defMod;}
    public int getStrMod() {return strMod;}
    public int getMagicMod() {return magicMod;}
    public int getResMod() {return resMod;}
    public int getSpeedMod() {return speedMod;}
    public int getHpMod() {return hpMod;}
    public int getMpMod() {return mpMod;}
    
    public int[] getStats(String itemName, String type)
    {
        if (type.equals("W"))
        {
            return weapons.get(itemName);
        }
        else if (type.equals("A"))
        {
            return armor.get(itemName);
        }
        else
        {
            return new int[] {0,0,0,0,0,0,0,0,0,0};
        }
    }
    
    public abstract String getSlot();
}


class Weapon extends Equipable
{   
    private int[] stats;
    public Weapon(String n)
    {
        stats = getStats(n, "W");
        defMod = stats[0];
        strMod = stats[1];
        magicMod = stats[2];
        resMod = stats[3];
        speedMod = stats[4];
        hpMod = stats[5];
        mpMod = stats[6];
        name = n;
        consumable = false;
        collectable = false;
        equip = true;
        important = false;
        slot = stats[7];
    }
    public String getSlot()
    {
        return "Wep";
    }
}

class Armor extends Equipable
{   
    private int[] stats;
    public Armor(String n)
    {
        stats = getStats(n, "A");
        defMod = stats[0];
        strMod = stats[1];
        magicMod = stats[2];
        resMod = stats[3];
        speedMod = stats[4];
        hpMod = stats[5];
        mpMod = stats[6];
        name = n;
        consumable = false;
        collectable = false;
        equip = true;
        important = false;
        slot = stats[7];
    }
    public String getSlot()
    {
        String[] slots = {"","","Head","Body","Legs","Feet","Accessory"};
        return slots[slot];
    }
}