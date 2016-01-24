//Superclass for Items - potions, equips, etc.
import java.util.*;
public abstract class Item
{
    protected boolean consumable;
    protected boolean collectable;
    protected boolean equip;
    protected boolean important;
    public String name;
    
    public static HashMap<String, int[]> weapons = new HashMap<String, int[]>(); //Creates dictionary of items, uses name to label lists of weapon stats. Weapon data accessed by name. Array contains data in order of definitions in equipable
    public static HashMap<String, int[]> armor = new HashMap<String, int[]>(); //Creates dictionary of items, uses name to label lists of armor stats. Armor data accessed by name. Array contains data in order of definitions in equipable    
    public static HashMap<String, int[]> effectItems = new HashMap<String, int[]>(); //Creates dictionary of useable items that affect stats
    public static HashMap<String, int[]> miscItems = new HashMap<String, int[]>(); //Creates dictionary of miscellaneous items
    public static void consEquipList()
    {
        /* ------WEAPON DATABASE------ */
        
        /* --DAGGERS-- */
        weapons.put("Bronze Dagger",        new int[] {0,10,0,0,35,0,0,15,1});
        weapons.put("Iron Dagger",          new int[] {0,13,0,0,40,0,0,20,1});
        weapons.put("Steel Dagger",         new int[] {0,16,0,0,43,0,0,30,1});
        weapons.put("Darksteel Dagger",     new int[] {0,22,0,0,50,0,0,35,1});
        weapons.put("Mithril Dagger",       new int[] {0,25,0,0,58,0,0,40,1});
        weapons.put("Obsidian Dagger",      new int[] {0,28,0,0,67,0,0,50,1});
        weapons.put("MA's Eviscerator",     new int[] {0,37,0,0,90,0,0,60,1});
        /* ----------- */
        
        /* --Longswords-- */
        weapons.put("Bronze Longsword",     new int[] {0,15,0,5,25,0,0,10,1});
        weapons.put("Iron Longsword",       new int[] {0,18,0,10,25,0,0,15,1});
        weapons.put("Steel Longsword",      new int[] {0,21,0,15,35,0,0,20,1});
        weapons.put("Darksteel Longsword",  new int[] {0,28,0,20,38,0,0,25,1});
        weapons.put("Mithril Longsword",    new int[] {0,33,0,25,40,0,0,28,1});
        weapons.put("Obsidian Longsword",   new int[] {0,38,0,30,45,0,0,31,1});
        /* -------------- */
        
        /* --Greatswords-- */
        weapons.put("Bronze Greatsword",    new int[] {0,20,0,0,10,0,0,5,1});
        weapons.put("Iron Greatsword",      new int[] {0,25,0,0,15,0,0,10,1});
        weapons.put("Steel Greatsword",     new int[] {0,35,0,0,15,0,0,15,1});
        weapons.put("Darksteel Greatsword", new int[] {0,38,0,0,23,0,0,18,1});
        weapons.put("Mithril Greatsword",   new int[] {0,43,0,0,15,0,0,23,1});
        weapons.put("Obsidian Greatsword",  new int[] {0,48,0,0,15,0,0,28,1});
        weapons.put("Zweihander",           new int[] {0,75,0,0,10,0,0,33,1});
        /* --------------- */   
        
        /* --STAFFS-- */
        weapons.put("Wooden Pole",              new int[] {0,0,16,0,25,0,0,0,1});
        weapons.put("Oak Staff",                new int[] {0,0,21,0,22,0,0,0,1});
        weapons.put("Ruby Oak Staff",           new int[] {0,0,28,0,20,0,0,0,1});
        weapons.put("Redwood Staff",            new int[] {0,0,31,0,17,0,0,0,1});
        weapons.put("Ruby Redwood Staff",       new int[] {0,0,35,0,15,0,0,0,1});
        weapons.put("Emerald Redwood Staff",    new int[] {0,0,42,0,12,0,0,0,1});
        /* ---------- */
    
        /* --WANDS-- */
        weapons.put("Wooden Stick",         new int[] {0,0,14,0,25,0,0,0,1});
        weapons.put("Oak Wand",             new int[] {0,0,18,0,30,0,0,0,1});
        weapons.put("Ruby Oak Wand",        new int[] {0,0,23,0,36,0,0,0,1});
        weapons.put("Redwood Wand",         new int[] {0,0,27,0,39,0,0,0,1});
        weapons.put("Ruby Redwood Wand",    new int[] {0,0,30,0,43,0,0,0,1});
        weapons.put("Emerald Redwood Wand", new int[] {0,0,35,0,49,0,0,0,1});
        weapons.put("Moocao's Little Rod",  new int[] {0,0,50,0,75,0,0,0,1});
        /* --------- */   
        
        /* --BOWS--- */
        weapons.put("Wooden Bow",           new int[] {0,12,0,0,20,0,0,20,1});
        weapons.put("Oak Bow",              new int[] {0,15,0,0,23,0,0,23,1});
        weapons.put("Light Steel Bow",     new int[] {0,18,0,0,26,0,0,26,1});
        weapons.put("Darksteel Bow",       new int[] {0,23,0,0,29,0,0,30,1});
        weapons.put("Willow Longbow",      new int[] {0,27,0,0,32,0,0,33,1});
        weapons.put("Redwood Longbow",     new int[] {0,31,0,0,35,0,0,38,1});
        
                            /*
                        1: defMod;
                        2: strMod;
                        3: magicMod;
                        4: resMod;
                        5: speedMod;
                        6: hpMod;
                        7: mpMod;
                        8: luckMod;
                        9: slot;
                            */        
        
        /* ------ARMOR DATABASE------ */
        
        /* --HEAD-- */
        armor.put("Wooden Helmet",          new int[]  {2,0,0,0,0,0,0,0,2});
        armor.put("Bronze Helmet",          new int[]  {3,0,0,1,-1,0,0,0,2});
        armor.put("Iron Helmet",            new int[]  {6,0,0,3,-2,0,0,0,2});
        armor.put("Steel Helmet",           new int[]  {9,0,0,5,-3,0,0,0,2});
        armor.put("Darksteel Helmet",       new int[] {11,0,0,7,-4,0,0,0,2});
        armor.put("Mithril Helmet",         new int[] {13,0,0,9,-5,0,0,0,2});
        armor.put("Obsidian Helmet",        new int[] {15,0,0,11,-6,0,0,2});
        
        armor.put("Leather Headgear",           new int[]  {2,0,0,2,5,0,0,5,2});
        armor.put("Hard Leather Headgear",      new int[]  {4,0,0,4,6,0,0,6,2});
        armor.put("Snakeskin Headgear",         new int[]  {6,0,0,6,7,0,0,7,2});
        armor.put("Dragonhide Headgear",        new int[]  {9,0,0,8,8,0,0,8,2});
        armor.put("Phoenix Feather Headgear",   new int[] {11,0,0,10,9,0,0,9,2});
        armor.put("Hydra Headgear",             new int[] {13,0,0,12,10,0,0,10,2});
        
        armor.put("Brown Wizard Hat",       new int[] {1,0,2,1,0,0,2,0,2}); //magic armor heals mp every turn and adds magic damage
        armor.put("Blue Wizard Hat",        new int[] {3,0,4,4,0,0,3,0,2});
        armor.put("Black Wizard Hat",       new int[] {5,0,6,7,0,0,4,0,2});
        armor.put("Garnished Wizard Hat",   new int[] {7,0,8,10,0,0,6,0,2});
        armor.put("Grand Sage Hat",         new int[]{9,0,10,13,0,0,8,0,2});
        armor.put("Grandmaster Hat",        new int[]{11,0,12,16,0,0,10,0,2});
        /* -------- */
        
        /* --BODY-- */
        armor.put("Copper Chestplate",          new int[]  {5,0,0,2,0,0,0,0,3}); 
        armor.put("Iron ChestPlate",            new int[]  {9,0,0,4,0,0,0,0,3});
        armor.put("Steel Chestplate",           new int[] {13,0,0,6,0,0,0,0,3});
        armor.put("Darksteel Chestplate",      new int[] {15,0,0,8,0,0,0,0,3});
        armor.put ("Mithril Chestplate",        new int[]{17,0,0,10,0,0,0,0,3});
        armor.put ("Obsidian Chestplate",       new int[]{19,0,0,12,0,0,0,0,3});
        
        armor.put("Leather Body",                new int[]  {3,0,0,3,3,0,0,3,3});
        armor.put("Hard Leather Body",           new int[]  {6,0,0,5,5,0,0,5,3});
        armor.put("Snakeskin Body",              new int[]  {9,0,0,7,7,0,0,7,3});
        armor.put("Dragonhide Body",              new int[] {11,0,0,9,9,0,0,9,3});
        armor.put("Phoenix Feather Body",        new int[] {13,0,0,11,11,0,0,11,3});
        armor.put("Hydra Body",                  new int[] {15,0,0,13,13,0,0,13,3});
        
        armor.put("Jagged Wizard Robe",     new int[]  {2,0,2,5,0,0,1,0,3});
        armor.put("Brown Wizard Robe",      new int[]  {4,0,4,8,0,0,3,0,3});
        armor.put("Black Wizard Robe",      new int[]  {6,0,6,11,0,0,5,0,3});
        armor.put("Garnished Wizard Robe",  new int[]  {8,0,8,14,0,0,7,0,3});
        armor.put("Grand Sage Robe",        new int[] {10,0,10,17,0,0,9,0,3});
        armor.put ("Grandmaster Robe",      new int[] {13,0,12,20,0,0,11,0,3});
        
        
        /* -------- */
        
        /* --LEGS-- */
        armor.put("Bronze Leggings",    new int[]  {3,0,0,1,0,0,0,0,4});
        armor.put("Iron Leggings",      new int[]  {6,0,0,3,0,0,0,0,4});
        armor.put("Steel Leggings",     new int[]  {9,0,0,5,0,0,0,0,4});
        armor.put("Darksteel Leggings", new int[] {11,0,0,7,0,0,0,0,4});
        armor.put("Mithril Leggings",   new int[] {13,0,0,9,0,0,0,0,4});
        armor.put("Obsidian Leggings",  new int[] {15,0,0,11,0,0,0,0,4});
        
        armor.put("Leather Pants",          new int[]  {2,0,0,3,2,0,0,5,4});
        armor.put("Hard Leather Pants",     new int[]  {4,0,0,5,4,0,0,7,4});
        armor.put("Snakeskin Pants",        new int[]  {6,0,0,7,6,0,0,9,4});
        armor.put("Dragonhide Pants",       new int[]  {8,0,0,9,8,0,0,11,4});
        armor.put("Phoenix Feather Pants",  new int[] {10,0,0,11,10,0,0,13,4});
        armor.put("Hydra Pants",            new int[] {12,0,0,13,12,0,0,15,4});
        /* -------- */
        
        /* --FEET-- */
        armor.put("Bronze Boots",   new int[]  {3,0,0,1,0,0,0,0,5});
        armor.put("Iron Boots",     new int[]  {6,0,0,2,0,0,0,0,5});
        armor.put("Steel Boots",    new int[]  {9,0,0,3,0,0,0,0,5});
        armor.put("Darksteel Boots",new int[]  {11,0,0,4,0,0,0,0,5});  
        armor.put("Mithril Boots",  new int[]  {13,0,0,5,0,0,0,0,5});  
        armor.put("Obsidian Boots", new int[]  {15,0,0,6,0,0,0,0,5});
        
        armor.put("Leather Boots",          new int[]  {2,0,0,2,5,0,0,5,5});
        armor.put("Hard Leather Boots",     new int[]  {4,0,0,4,7,0,0,6,5});
        armor.put("Snakeskin Boots" ,       new int[]  {6,0,0,6,9,0,0,7,5});
        armor.put("Dragonhide Boots",       new int[]  {8,0,0,8,11,0,0,8,5});
        armor.put("Phoenix Feather Boots",  new int[]  {10,0,0,10,13,0,0,9,5});
        armor.put("Hydra Boots",            new int[]  {12,0,0,12,15,0,0,10,5});
        
        armor.put("Wizard's Shoes",     new int[]  {1,0,1,3,0,0,2,0,5});
        armor.put("Spellcaster Boots",  new int[]  {2,0,2,6,0,0,3,0,5});
        armor.put("Sorcerer Boots",     new int[]  {3,0,3,9,0,0,4,0,5});
        armor.put("Warlock Boots",      new int[]  {4,0,4,11,0,0,5,0,5});
        armor.put("Sage Boots",         new int[]  {5,0,5,13,0,0,6,0,5});
        armor.put("Grandmaster Boots",  new int[]  {6,0,6,15,0,0,7,0,5});
        /* -------- */
        
        /* --ACCESSORY-- */
        armor.put("Broken Glasses", new int[] {0,0,0,0,0,0,5,5,6});
        armor.put("Weak Adventurer's Trinket", new int[] {1,1,1,1,1,1,1,1,6});
        armor.put("Pocket Watch", new int[] {0,0,0,0,5,0,0,0,6});
        armor.put("Medal", new int[] {0,6,6,0,0,0,0,0,6});
        
        /* ------------- */
        
        /* -------------------------- */
        
                            /*
                        1: defMod;
                        2: strMod;
                        3: magicMod;
                        4: resMod;
                        5: speedMod;
                        6: hpMod;
                        7: mpMod;
                        8: luckMod;
                        9: slot;
                            */   
        
        /* -------EFFECT USEABLE DATABASE---------- */
        
        effectItems.put("Lesser Healing Potion", new int[] {0,0,0,0,0,15,0,0,1});
        effectItems.put("Weak Healing Potion", new int[] {0,0,0,0,0,20,0,0,1});
        effectItems.put("Healing Potion", new int[] {0,0,0,0,0,35,0,0,1});
        effectItems.put("Effective Healing Potion", new int[] {0,0,0,0,0,50,0,0,1});
        effectItems.put("Strong Healing Potion", new int[] {0,0,0,0,0,65,0,0,1});
        effectItems.put("Powerful Healing Potion", new int[] {0,0,0,0,0,85,0,0,1});
        effectItems.put("Super Healing Potion", new int[] {0,0,0,0,0,55,0,0,2});            //Super, Ultra, and Ultimate potions of all types heal for multiple turns
        effectItems.put("Ultra Healing Potion", new int[] {0,0,0,0,0,70,0,0,2});
        effectItems.put("Ultimate Healing Potion", new int[] {0,0,0,0,0,60,0,0,3});
        effectItems.put("Lesser Revitalizer", new int[] {0,-10,-10,0,-10,50,0,0,1});        //Revitalizers for emergencies or healing out of combat - have drawback effects
        effectItems.put("Revitalizer", new int[] {0,-18,-18,0,-20,100,0,0,1});
        effectItems.put("Strong Revitalizer", new int[] {0,-26,-26,0,-30,175,0,0,1});
        effectItems.put("Super Revitalizer", new int[] {0,-40,-40,0,-35,300,0,0,1});
        
        effectItems.put("Lesser Mana Potion", new int[] {0,0,0,0,0,0,15,0,1});
        effectItems.put("Weak Mana Potion", new int[] {0,0,0,0,0,0,25,0,1});
        effectItems.put("Mana Potion", new int[] {0,0,0,0,0,0,35,0,1});
        effectItems.put("Effective Mana Potion", new int[] {0,0,0,0,0,0,50,0,1});
        effectItems.put("Strong Mana Potion", new int[] {0,0,0,0,0,0,65,0,1});
        effectItems.put("Powerful Mana Potion", new int[] {0,0,0,0,0,0,85,0,1});
        effectItems.put("Super Mana Potion", new int[] {0,0,0,0,0,0,55,0,2});            //Super, Ultra, and Ultimate potions of all types heal for multiple turns
        effectItems.put("Ultra Mana Potion", new int[] {0,0,0,0,0,0,70,0,2});
        effectItems.put("Ultimate Mana Potion", new int[] {0,0,0,0,0,0,60,0,3});
        
        effectItems.put("Minor Strength Potion", new int[] {0,5,0,0,0,0,0,0,3});
        effectItems.put("Improved Minor Strength Potion", new int[] {0,5,0,0,0,0,0,0,5});
        effectItems.put("Strength Potion", new int[] {0,10,0,0,0,0,0,0,4});
        effectItems.put("Improved Strength Potion", new int[] {0,10,0,0,0,0,0,0,6});
        effectItems.put("Powerful Strength Potion", new int[] {0,15,0,0,0,0,0,0,5});
        effectItems.put("Improved Powerful Strength Potion", new int[] {0,15,0,0,0,0,0,0,7});
        effectItems.put("Super Strength Potion", new int[] {0,22,0,0,0,0,0,0,5});
        effectItems.put("Improved Super Strength Potion", new int[] {0,22,0,0,0,0,0,0,7});
        
        effectItems.put("Minor Defense Potion", new int[] {5,0,0,0,0,0,0,0,3});
        effectItems.put("Improved Minor Defense Potion", new int[] {5,0,0,0,0,0,0,0,5});
        effectItems.put("Defense Potion", new int[] {10,0,0,0,0,0,0,0,4});
        effectItems.put("Improved Defense Potion", new int[] {10,0,0,0,0,0,0,0,6});
        effectItems.put("Powerful Defense Potion", new int[] {15,0,0,0,0,0,0,0,5});
        effectItems.put("Improved Powerful Defense Potion", new int[] {15,0,0,0,0,0,0,0,7});
        effectItems.put("Super Defense Potion", new int[] {22,0,0,0,0,0,0,0,5});
        effectItems.put("Improved Super Defense Potion", new int[] {22,0,0,0,0,0,0,0,7});   
        
        effectItems.put("Minor Magic Potion", new int[] {0,0,5,0,0,0,0,0,3});
        effectItems.put("Improved Minor Magic Potion", new int[] {0,0,5,0,0,0,0,0,5});
        effectItems.put("Magic Potion", new int[] {0,0,10,0,0,0,0,0,4});
        effectItems.put("Improved Magic Potion", new int[] {0,0,10,0,0,0,0,0,6});
        effectItems.put("Powerful Magic Potion", new int[] {0,0,15,0,0,0,0,0,5});
        effectItems.put("Improved Powerful Magic Potion", new int[] {0,0,15,0,0,0,0,0,7});
        effectItems.put("Super Magic Potion", new int[] {0,0,22,0,0,0,0,0,5});
        effectItems.put("Improved Super Magic Potion", new int[] {0,0,22,0,0,0,0,0,7});
        
        effectItems.put("Minor Resolution Potion", new int[] {0,0,0,5,0,0,0,0,3});
        effectItems.put("Improved Minor Resolution Potion", new int[] {0,0,0,5,0,0,0,0,5});
        effectItems.put("Resolution Potion", new int[] {0,0,0,10,0,0,0,0,4});
        effectItems.put("Improved Resolution Potion", new int[] {0,0,0,10,0,0,0,0,6});
        effectItems.put("Powerful Resolution Potion", new int[] {0,0,0,15,0,0,0,0,5});
        effectItems.put("Improved Powerful Resolution Potion", new int[] {0,0,0,15,0,0,0,0,7});
        effectItems.put("Super Resolution Potion", new int[] {0,0,0,22,0,0,0,0,5});
        effectItems.put("Improved Super Resolution Potion", new int[] {0,0,0,22,0,0,0,0,7});
        
        effectItems.put("Minor Speed Potion", new int[] {0,0,0,0,5,0,0,0,3});
        effectItems.put("Improved Minor Speed Potion", new int[] {0,0,0,0,5,0,0,0,5});
        effectItems.put("Speed Potion", new int[] {0,0,0,0,10,0,0,0,4});
        effectItems.put("Improved Speed Potion", new int[] {0,0,0,0,10,0,0,0,6});
        effectItems.put("Powerful Speed Potion", new int[] {0,0,0,0,15,0,0,0,5});
        effectItems.put("Improved Powerful Speed Potion", new int[] {0,0,0,0,15,0,0,0,7});
        effectItems.put("Super Speed Potion", new int[] {0,0,0,0,22,0,0,0,5});
        effectItems.put("Improved Super Speed Potion", new int[] {0,0,0,0,22,0,0,0,7});
        
        effectItems.put("Minor Luck Potion", new int[] {0,0,0,0,0,0,0,5,3});
        effectItems.put("Improved Minor Luck Potion", new int[] {0,0,0,0,0,0,0,5,5});
        effectItems.put("Luck Potion", new int[] {0,0,0,0,0,0,0,10,4});
        effectItems.put("Improved Luck Potion", new int[] {0,0,0,0,0,0,0,10,6});
        effectItems.put("Powerful Luck Potion", new int[] {0,0,0,0,0,0,0,15,5});
        effectItems.put("Improved Powerful Luck Potion", new int[] {0,0,0,0,0,0,0,15,7});
        effectItems.put("Super Luck Potion", new int[] {0,0,0,0,0,0,0,22,5});
        effectItems.put("Improved Super Luck Potion", new int[] {0,0,0,0,0,0,0,22,7});
        
        
        
        
        /* -------MISC ITEM DATABASE---------- */
        miscItems.put("Lock Picking Kit", new int[]{25});
        miscItems.put("Advanced Lock Picking Kit", new int[]{75});
        miscItems.put("Rope", new int[]{25});
        
        miscItems.put("Power Stone", new int[] {10});
        miscItems.put("Arcane Pebble", new int[] {10});
        miscItems.put("Health Stone", new int[] {4});
        miscItems.put("Mana Essence", new int[] {4});
        miscItems.put("Resiliance Essence", new int[] {6});
        miscItems.put("Toughness Inscription", new int[] {6});
        miscItems.put("Speed Charm", new int[] {4});
        miscItems.put("Luck Charm", new int[] {4});
        
        
        
    }
    
    public String toString() {return name;}

}
    

//---------------------------------------EQUIPABLE CLASSES-----------------------------------
abstract class Equipable extends Item
{
    protected int defMod;
    protected int strMod;
    protected int magicMod;
    protected int resMod;
    protected int speedMod;
    protected int hpMod;
    protected int mpMod;
    protected int luckMod;
    protected int slot;
    
    
    public int getDefMod() {return defMod;}
    public int getStrMod() {return strMod;}
    public int getMagicMod() {return magicMod;}
    public int getResMod() {return resMod;}
    public int getSpeedMod() {return speedMod;}
    public int getHpMod() {return hpMod;}
    public int getMpMod() {return mpMod;}
    public int getLuckMod() {return luckMod;}
    
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
            return new int[] {0,0,0,0,0,0,0,0,0,0,0};
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
        luckMod = stats[7];
        slot = stats[8];
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
        luckMod = stats[7];
        slot = stats[8];
    }
    public String getSlot()
    {
        String[] slots = {"","","Head","Body","Legs","Feet","Accessory"};
        return slots[slot];
    }
}
//-------------------------------------------------------------------------------------------

//---------------------------------------USEABLE CLASSES-------------------------------------
abstract class Useable extends Item
{
    protected int duration;
    public abstract HashMap<String, Integer> use();
    
    public int getDuration()
    {
        return duration;
    }
    
}

class EffectItem extends Useable
{
    protected int[] data;
    public EffectItem (String itemName)
    {
        name = itemName;
        data = effectItems.get(itemName);
        duration = data[8];
    }
    
    public HashMap<String, Integer> use()
    {
        HashMap<String, Integer> effects = new HashMap<String, Integer>();
        effects.put("defMod",data[0]);
        effects.put("strMod",data[1]);  
        effects.put("magicMod",data[2]);
        effects.put("resMod",data[3]);
        effects.put("speedMod",data[4]);
        effects.put("hpMod",data[5]);
        effects.put("mpMod",data[6]);
        effects.put("luckMod",data[7]);
        return effects;
    }
}

//-------------------------------------------------------------------------------------------

//---------------------------------------MISC CLASSES-------------------------------------

class MiscItem extends Item
{
    public MiscItem (String n)
    {
        name = n;
    }
}