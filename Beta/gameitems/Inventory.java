
package gameitems;

import java.util.*;

public class Inventory
{
    private int effectDuration = 0;
    private ArrayList<Item> inv = new ArrayList<Item>();
    private HashMap<String, Equipable> equipped = new HashMap<String, Equipable>();
    private HashMap<String, Integer> effect = new HashMap<String, Integer>();
    //HashMap has "Wep", "Head","Body","Legs","Feet","Accessory" Slots.
    
    //Creates inventory for new character with basic equips. Beginner's weapon determined by character class. Char has no effects when first created
    public Inventory (String baseWep)       
    {
        equipped.put("Wep", new Weapon(baseWep));
        equipped.put("Head", new Armor("Wooden Helmet"));
        equipped.put("Body", new Armor("Copper Chestplate"));
        equipped.put("Legs", new Armor("Leather Pants"));
        equipped.put("Feet", new Armor("Leather Boots"));
        equipped.put("Accessory", new Armor("Broken Glasses"));
        resetEffects();
    }
    
    public void resetEffects()
    {
        effect.put("defMod",0);
        effect.put("magicMod",0);
        effect.put("resMod",0);
        effect.put("speedMod",0);
        effect.put("hpMod",0);
        effect.put("mpMod",0);
        effect.put("luckMod",0);
        effect.put("strMod",0);        
    }
    
    //Allows user to cancel all effects, with flavor text.
    public void killEffects()
    {
        System.out.println("Through sheer willpower you supress all chemical effects on you.");
        resetEffects();
        effectDuration = 0;
    }
    
    public String toString()
    {
        String s = "------------------------------------------------- YOUR STUFF -------------------------------------------------\n";
        s += "Inventory:\n";
        for (int i = 0; i < inv.size(); i++)
        {
            s += inv.get(i).toString();
            s += ", ";
        }
        s = s.substring(0, s.length()-2) + "\n\nEquipment:\n";
        for(Map.Entry<String, Equipable> entry : equipped.entrySet()) 
        {
            String key = entry.getKey();
            s = s + key + ": ";
            s += entry.getValue().toString();
            s += " | ";
        }
        return s.substring(0, s.length()-1)+"\n--------------------------------------------------------------------------------------------------------------\n";
    }
    
    public void giveItem(Item i)
    {
        inv.add(i);
        System.out.println("You gain: " + i.toString() + ".");
    }
    
    public void removeItem(String itemName)
    {
        try 
        {
            int index = -1;
            for (int k = 0; k < inv.size(); k++)
            {
                if (inv.get(k).toString().equals(itemName))
                {
                    index = k;
                }
            }
            inv.remove(index);
        } catch(Exception e) {return;}
    }
    
    public boolean removeItemB(String itemName)
    {
        try 
        {
            int index = -1;
            for (int k = 0; k < inv.size(); k++)
            {
                if (inv.get(k).toString().equals(itemName))
                {
                    index = k;
                }
            }
            inv.remove(index);
            return true;
        } catch(Exception e) {return false;}        
    }
    
    public void equipItem(String itemName)
    {
        try
        {
            for (Item i : inv)
            {
                if ((i.toString().equals(itemName)) && i instanceof Equipable)
                {
                    inv.add(equipped.get(((Equipable)i).getSlot()));
                    equipped.remove(((Equipable)i).getSlot());
                    equipped.put(((Equipable)i).getSlot(), (Equipable)i);
                    this.removeItem(itemName);
                    System.out.println("You Equip " + itemName + ".");
                }
            }
        } catch (Exception e) {System.out.println("You don't own this item, or it cannot be equipped");}
    }
    
    //adds all item and effect bonuses, and exports data as hashmap for easy use
    public HashMap<String, Integer> scrapeStats()
    {
        HashMap<String, Integer> data = new HashMap<String, Integer>();
        int strMod = effect.get("strMod") + equipped.get("Wep").getStrMod() + equipped.get("Head").getStrMod() + equipped.get("Body").getStrMod() + equipped.get("Legs").getStrMod() + equipped.get("Feet").getStrMod() + equipped.get("Accessory").getStrMod();
        int defMod = effect.get("defMod") + equipped.get("Wep").getDefMod() + equipped.get("Head").getDefMod() + equipped.get("Body").getDefMod() + equipped.get("Legs").getDefMod() + equipped.get("Feet").getDefMod() + equipped.get("Accessory").getDefMod();
        int magicMod = effect.get("magicMod") + equipped.get("Wep").getMagicMod() + equipped.get("Head").getMagicMod() + equipped.get("Body").getMagicMod() + equipped.get("Legs").getMagicMod() + equipped.get("Feet").getMagicMod() + equipped.get("Accessory").getMagicMod();
        int resMod = effect.get("resMod") + equipped.get("Wep").getResMod() + equipped.get("Head").getResMod() + equipped.get("Body").getResMod() + equipped.get("Legs").getResMod() + equipped.get("Feet").getResMod() + equipped.get("Accessory").getResMod();
        int speedMod = effect.get("speedMod") + equipped.get("Wep").getSpeedMod() + equipped.get("Head").getSpeedMod() + equipped.get("Body").getSpeedMod() + equipped.get("Legs").getSpeedMod() + equipped.get("Feet").getSpeedMod() + equipped.get("Accessory").getSpeedMod();
        int hpMod = effect.get("hpMod") + equipped.get("Wep").getHpMod() + equipped.get("Head").getHpMod() + equipped.get("Body").getHpMod() + equipped.get("Legs").getHpMod() + equipped.get("Feet").getHpMod() + equipped.get("Accessory").getHpMod();
        int mpMod = effect.get("mpMod") + equipped.get("Wep").getMpMod() + equipped.get("Head").getMpMod() + equipped.get("Body").getMpMod() + equipped.get("Legs").getMpMod() + equipped.get("Feet").getMpMod() + equipped.get("Accessory").getMpMod();
        int luckMod = effect.get("luckMod") + equipped.get("Wep").getLuckMod() + equipped.get("Head").getLuckMod() + equipped.get("Body").getLuckMod() + equipped.get("Legs").getLuckMod() + equipped.get("Feet").getLuckMod() + equipped.get("Accessory").getLuckMod();
        data.put("strMod", strMod);
        data.put("defMod", defMod);
        data.put("magicMod", magicMod);
        data.put("resMod", resMod);
        data.put("speedMod", speedMod);
        data.put("hpMod", hpMod);
        data.put("mpMod", mpMod);
        data.put("luckMod", luckMod);
        effectDuration -= 1;
        if (effectDuration == 0)
        {
            resetEffects();            
        }
        return data;
    }
    
    public void useItem(String itemName)
    {
        //try 
       // {
            //spawn new item because it's easier to get its effects than search for the same item in the inventory, since removeItemB has removed it if it exists already
            EffectItem u = new EffectItem(itemName);
            if (effectDuration > 0)
            {
                System.out.println("Being under the effects of multiple strong chemicals could make you fatally ill. Try again later.");
                return;
            }
            if(removeItemB(itemName))
            {
                effectDuration = u.getDuration();
                HashMap<String, Integer> effectTemp = u.use();
                effect.put("defMod",effectTemp.get("defMod"));
                effect.put("magicMod",effectTemp.get("magicMod"));
                effect.put("resMod",effectTemp.get("resMod"));
                effect.put("speedMod",effectTemp.get("speedMod"));
                effect.put("hpMod",effectTemp.get("hpMod"));
                effect.put("mpMod",effectTemp.get("mpMod"));
                effect.put("luckMod",effectTemp.get("luckMod"));
                effect.put("strMod",effectTemp.get("strMod"));
                //print flavor text based on buffs/debuffs
                System.out.println("You consume a(n) " + itemName + ".");
                if (effectTemp.get("strMod") > 0) {System.out.println("You feel empowered.");} else if (effectTemp.get("strMod") < 0) {System.out.println("You feel enfeebled.");}
                if (effectTemp.get("defMod") > 0) {System.out.println("You feel fortified.");} else if (effectTemp.get("defMod") < 0) {System.out.println("You feel vulnerable.");}
                if (effectTemp.get("magicMod") > 0) {System.out.println("You feel a rush of arcane energy.");} else if (effectTemp.get("magicMod") < 0) {System.out.println("You feel drained.");}
                if (effectTemp.get("resMod") > 0) {System.out.println("You feel resolute.");} else if (effectTemp.get("resMod") < 0) {System.out.println("You feel nervous and uneasy.");}
                if (effectTemp.get("speedMod") > 0) {System.out.println("Your sense of awareness is heightened.");} else if (effectTemp.get("speedMod") < 0) {System.out.println("You feel lethargic.");}
                if (effectTemp.get("hpMod") > 0) {System.out.println("You feel revitalized.");} else if (effectTemp.get("hpMod") < 0) {System.out.println("You feel ill.");}
                if (effectTemp.get("mpMod") > 0) {System.out.println("You feel rejuvinated.");} else if (effectTemp.get("mpMod") < 0) {System.out.println("You are drained of arcane willpower.");}
                if (effectTemp.get("luckMod") > 0) {System.out.println("Your sense of perception is heightened.");} else if (effectTemp.get("luckMod") < 0) {System.out.println("Your perception is dulled.");}
            }
       // } catch (Exception e){}
    }


/*    
    public static void main(String[] args)
    {
        Item.consEquipList();
        Inventory i = new Inventory("Wooden Pole");
        i.giveItem(new Weapon("Moocao's Little Rod"));
        i.giveItem(new Armor("Leather Boots"));
//        System.out.println("Create inventory and equips");
//        System.out.println(i);
//        System.out.println(i.scrapeStats());
        i.removeItem("Leather Boots");
//        System.out.println("Removing leather boots");
//        System.out.println(i);
        i.equipItem("Moocao's Little Rod");
//        System.out.println("Adding and equipping Little Rod");
//        System.out.println(i);
        i.giveItem(new Armor("Bronze Helmet"));
//        System.out.println("giving bronze helmet");
//        System.out.println(i);
        i.equipItem("Bronze Helmet");
//        System.out.println("Equipping the helmet");
//        System.out.println(i);
        i.equipItem("Iron Longsword");
//        System.out.println("Attempting to equip unowned item");
//        System.out.println(i);
        i.equipItem("bgiesibgbobgio");
//        System.out.println("Attempting to equip nonexistant item");
//        System.out.println(i);
//        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(i);
        System.out.println(i.scrapeStats());
        boolean k = i.removeItemB("Bronze Helmet");
        System.out.println(k);
        k = i.removeItemB("Wooden Helmet");
        i.equipItem("Wooden Pole");
        System.out.println(i);
        System.out.println(i.scrapeStats());
        System.out.println(k);
        i.effect.put("hpMod", 10000);
        i.effectDuration = 5;
        System.out.println(i.scrapeStats());
        System.out.println(i.scrapeStats());
        System.out.println(i.scrapeStats());
        System.out.println(i.scrapeStats());
        System.out.println(i.scrapeStats());  
        System.out.println(i.scrapeStats());

        i.giveItem(new EffectItem("Lesser Healing Potion"));
        System.out.println(i);
        System.out.println(i.scrapeStats());
        i.useItem("Lesser Healing Potion");
        System.out.println(i);
        System.out.println(i.scrapeStats());
        System.out.println(i.scrapeStats());
        i.giveItem(new EffectItem("Weak Healing Potion"));
        System.out.println(i);
        System.out.println(i.scrapeStats());
        i.useItem("Weak Healing Potion");
        System.out.println(i);
        System.out.println(i.scrapeStats());
        System.out.println(i.scrapeStats());
        i.useItem("Weak Healing Potion");  
        System.out.println(i.scrapeStats());


        System.out.println(i.scrapeStats());
        i.giveItem(new EffectItem("Ultimate Healing Potion"));
        i.giveItem(new EffectItem("Ultimate Mana Potion"));
        i.useItem("Ultimate Healing Potion");
        System.out.println(i.scrapeStats());
        i.killEffects();
        i.useItem("Ultimate Mana Potion");
        System.out.println(i.scrapeStats());
        System.out.println(i);

    }
    */
    
}