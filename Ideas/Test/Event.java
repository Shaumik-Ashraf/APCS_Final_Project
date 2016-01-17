import java.util.*;
import java.io.*;

public abstract class Event 
{
    protected boolean isComplete;
    
    public boolean eventComplete()
    {
        return isComplete;
    }
    
    public abstract ArrayList<GChar> beginEvent();
}

class CombatEvent extends Event
{
    public ArrayList<GChar> enemies = new ArrayList<GChar>();
    public ArrayList<GChar> party = new ArrayList<GChar>();
    public ArrayList<GChar> engagement = new ArrayList<GChar>();
    public ArrayList<GChar> aliveParty = new ArrayList<GChar>();
    public ArrayList<GChar> aliveEnemies = new ArrayList<GChar>();    
    private Scanner in = new Scanner(System.in);
   
    public CombatEvent (ArrayList<GChar> p)
    {

        isComplete = false;
        for (GChar c: p)
        {
            party.add(c);
            engagement.add(c);
            aliveParty.add(c);
        }
        spawnEnemies();
        
        for (int k = 0; k < engagement.size(); k++)
        {
            for (int i = 1; i < engagement.size()-1; i++)
            {
                if (engagement.get(i).speed < engagement.get(i+1).speed)
                {
                    GChar lower = engagement.get(i);
                    GChar higher = engagement.get(i+1);
                    engagement.set(i, higher);
                    engagement.set(i+1, lower);
                }
            }            
        }

    }
    
    public void spawnEnemies()
    {
        enemies.add(new GChar("Goblin Spellcaster", "Fire", "Magic", "Agility", "Mage"));
        enemies.add(new GChar("Goblin Recruit", "Wood", "Agility", "Magic", "Rogue"));
        for (GChar c : enemies)
        {
            engagement.add(c);
            aliveEnemies.add(c);
        }
    }
    
    public ArrayList<GChar> beginEvent()
    {
        while (!(eventComplete()))
        {
            if ((aliveEnemies.size() == 0) || (aliveParty.size() == 0))
            {
                isComplete = true;
            }
            for (GChar c : engagement)
            {
                if ((aliveEnemies.size() == 0) || (aliveParty.size() == 0))
                {
                    break;
                }
                if (aliveParty.contains(c))
                {
                    //System.out.print("\033[H\033[2J");
        			//System.out.flush(); 
                    System.out.println("\nEnemies: " + aliveEnemies);
                    System.out.println("Party: " + aliveParty);
                    System.out.println("Who will " + c.name + " engage?\n");
                    String input = in.nextLine();
                    for (GChar e : aliveEnemies)
                    {
                        if (e.toString().equals(input))
                        {
                            c.battleBeat(e);
                            break;
                        }
                    }
                }
                if (aliveEnemies.contains(c))
                {
                    c.useSkill("Basic Attack", aliveParty.get((int)(party.size()*Math.random())));
                }
                for (GChar ap : party)
                {
                    if (!(ap.isAlive()))
                    {
                        try 
                        {
                            aliveEnemies.remove(ap);                        
                        } catch(Exception e) {}
                    }                    
                }
                for (GChar ae : enemies)
                {
                    if (!(ae.isAlive()))
                    {
                        try 
                        {
                            aliveEnemies.remove(ae);                            
                        } catch(Exception e) {}
                    }
                }
                if ((aliveEnemies.size() == 0) || (aliveParty.size() == 0))
                {
                    break;
                }
                
            }
        }
        System.out.println("Your Party is Victorious");
        System.out.println("Your Remaining Party: " + aliveParty);
        return aliveParty;
    }
}