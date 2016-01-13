import java.util.*;
public class Inventory
{
    private ArrayList<Item> inv = new ArrayList<Item>();
    private HashMap<String, Item> equipped = new HashMap<String, Item>();
    //HashMap has "Wep", "Head","Body","Legs","Feet","Accessory" Slots.
    
    //Creates inventory for new character with basic equips. Beginner's weapon determined by character class
    public Inventory (String baseWep)       
    {
        equipped.put("Wep", new Weapon(baseWep));
        equipped.put("Head", new Armor("Wooden Helmet"));
        equipped.put("Body", new Armor("Copper Chestplate"));
        equipped.put("Legs", new Armor("Leather Pants"));
        equipped.put("Feet", new Armor("Leather Boots"));
        equipped.put("Accessory", new Armor("Broken Glasses"));
    }
    
    public String toString()
    {
        String s = "";
        s += "Inventory:\n";
        for (int i = 0; i < inv.size(); i++)
        {
            s += inv.get(i).toString();
            s += ", ";
        }
        s = s.substring(0, s.length()-2) + "\n\nEquipment:\n";
        for(Map.Entry<String, Item> entry : equipped.entrySet()) 
        {
            String key = entry.getKey();
            s = s + key + ": ";
            s += entry.getValue().toString();
            s += " | ";
        }
        return s.substring(0, s.length()-1);
    }
    
    public static void main(String[] args)
    {
        Item.consEquipList();
        Inventory i = new Inventory("Wooden Pole");
        System.out.println(i);
    }
    
}