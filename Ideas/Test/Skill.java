import java.util.*;

public abstract class Skill
{
    protected int mpCost;
    public static HashMap<String,Skill> allSkills = new HashMap<String,Skill>();
    
    public static void consAllSkills()
    {
        allSkills.put("Basic Attack", new basicAttack());
        allSkills.put("Strong Swing", new strongSwing());
        allSkills.put("Proud Swivel", new proudSwivel());
        allSkills.put("Heat Wave", new heatWave());
    }
    
    public static HashMap<String,Skill> getAllSkills()
    {
        return allSkills;
    }
    
    public abstract void use(GChar user, GChar c);
    public int getMpCost() {return mpCost;}
}


class basicAttack extends Skill
{
    public basicAttack()
    {
        mpCost = 0;
    }
    
    public void use(GChar user, GChar c)
    {
        user.MP -= mpCost;
        if (((Math.random() * 100)) <= user.luck)
        {
            c.takeDamage(user.str - c.def / 2 );
            System.out.println ("It's a critical hit! REKT");
        }
        else
        {
            c.takeDamage(user.str-c.def);
        }
        
    }
}


//current Warrior class skills
class strongSwing extends Skill
{
    public strongSwing()
    {
        mpCost = 10;
    }
    
    public void use (GChar user, GChar c)
    {
        user.MP -= mpCost;
     if (((Math.random() * 100)) <= user.luck)
        {
            c.takeDamage (user.str - c.def / 2 );
            System.out.println ("It's a critical hit! REKT");
        }
    else
        {
            c.takeDamage (user.str + 10 - c.def);
        }
    }
}


class proudSwivel extends Skill
{
    public proudSwivel()
    {
        mpCost = 5;
    }
    
    public void use (GChar user, GChar c)
    {
        user.MP -= mpCost;
        if (((Math.random() * 100)) <= user.luck)
        {
            c.takeDamage (user.str - c.def / 2 );
            System.out.println ("It's a critical hit! REKT");
        }
        else
        {
            c.takeDamage (user.str + user.magic - c.def);
        }
    }
}




//element Fire skills
class heatWave extends Skill
{
    public heatWave()
    {
        mpCost = 10;
    }
    
    public void use (GChar user, GChar c)
    {
        user.MP -= mpCost;
        if (c.element.equals ("Wood") )
        {
           c.takeDamage (user.magic*2 - c.res); 
           System.out.println ("It's super effective!");
        }
        
        else if (c.element.equals ("Aqua") )
        {
           c.takeDamage (user.magic*2 - c.res); 
           System.out.println ("It's not very effective...");
        }
        
        else
        {
            c.takeDamage (user.magic - c.res);
        }
    }
}

