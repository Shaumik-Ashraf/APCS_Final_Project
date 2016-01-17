import java.util.*;

public abstract class Skill
{
    protected int mpCost;
    public static HashMap<String,Skill> allSkills = new HashMap<String,Skill>();
    
    public static void consAllSkills()
    {
        allSkills.put("Basic Attack", new basicAttack());
        allSkills.put("Basic AttackM", new basicAttackM());
        
        //Warrior Skills
        allSkills.put("Strong Swing", new strongSwing());
        allSkills.put("Proud Swivel", new proudSwivel());
        allSkills.put("Finishing Touch", new finishingTouch());
        
        //Archer Skills
        allSkills.put("Bow Throw", new bowThrow());
        allSkills.put("Arrow Storm", new arrowStrom());
        allSkills.put("Focus", new focus());
        
        //Mage Skills
        allSkills.put("Arcanite Force", new arcaniteForce());
        allSkills.put("Arcane Bullets", new arcaneBullets());
        allSkills.put("Concentrate", new concentrate());
        
        //Rogue Skills
        allSkills.put ("Back Stab", new backStab());
        allSkills.put ("Assassinate", new assassinate());
        allSkills.put ("Gamble", new gamble());
        
        //Fire skills
        allSkills.put("Heat Wave", new heatWave());
        allSkills.put("Rekindle", new reKindle());
        allSkills.put ("Flame Crash", new flameCrash());
        
        //Aqua Skills
        allSkills.put("Hail Storm", new hailStorm());
        allSkills.put ("Tidal Wave", new tidalWave());
        allSkills.put ("Aqua Veil", new aquaVeil());
        
        //Wood Skills
        allSkills.put("Flower Dance", new flowerDance());
        allSkills.put ("Wood Spike", new woodSpike());
        allSkills.put ("Pepper Song", new pepperSong());
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
        System.out.println (user.name + " bashes " + c.name);
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

class basicAttackM extends Skill
{
    public basicAttackM()
    {
        mpCost = 0;
    }
    
    public void use(GChar user, GChar c)
    {
        System.out.println (user.name + " bashes " + c.name);
        user.MP -= mpCost;
        c.takeDamage(user.magic-c.res);
        System.out.println (user.name + " deals " + (user.magic-c.res ) );

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
        System.out.println (user.name + " used Strong Swing!");
        user.MP -= mpCost;
     if (((Math.random() * 100)) <= user.luck)
        {
            c.takeDamage (user.str + 10 - c.def / 2 );
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
        mpCost = 25;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " used Proud Swivel!");
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


class finishingTouch extends Skill
{
    public finishingTouch()
    {
        mpCost = 25;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " used Finishing Touch!"); 
        user.MP -= mpCost;
        if (((Math.random() * 100)) <= user.luck)
        {
            c.takeDamage (user.str + user.HP - c.def / 2 );
            System.out.println ("It's a critical hit! REKT");
        }
        else
        {
            c.takeDamage (user.str + user.HP - c.def);
        }
    }
}

//class Archer skills
class bowThrow extends Skill
{
    public bowThrow()
    {
        mpCost = 10;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " threw a bow!?!");
        user.MP -= mpCost;
     if (((Math.random() * 100)) <= user.luck)
        {
            c.takeDamage (user.str - c.def / 4 );
            System.out.println ("It's a critical hit! REKT");
        }
    else
        {
            c.takeDamage (user.str - c.def/2);
        }
    }
}

class arrowStrom extends Skill
{
    public arrowStrom()
    {
        mpCost = 20;
    }
    
    public void use (GChar user, GChar c){
        System.out.println (user.name + " fired some arrows into the sky!");
        int hits = (int)(Math.random() *5);
        if (hits == 0 )
        {
            System.out.println ("The arrows miss " + c.name +"!");
        }
        while (hits != 0)
        {
            user.useSkill ("BasicAttack", c);
            hits --;
        }
        
    }
}

class focus extends Skill
{
    public focus()
    {
        mpCost = 15;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " began to concentrate!");
        System.out.println (user.name + " Offensive capabiltiies have increased at the cost of defenses!");
        user.str *= 1.5;
        user.luck *= 1.5;
        user.def /= 2;
        user.res /=2;
    }
}


//class Mage skills

class arcaniteForce extends Skill
{
    public arcaniteForce()
    {
        mpCost = 15;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " cast Arcanite Force!");
        user.MP -= mpCost;
        c.takeDamage (user.magic + 15 - c.res);
        
    }
}

class arcaneBullets extends Skill
{
    public arcaneBullets()
    {
        mpCost = 25;
    }
    
    public void use (GChar user, GChar c){
        System.out.println (user.name + " launches a series of magical orbs!");
        int hits = 3;

        while (hits != 0)
        {
            user.useSkill ("BasicAttackM", c);
            hits --;
        }
        
    }
}

class concentrate extends Skill
{
    public concentrate()
    {
        mpCost = 35;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " began to chant magical incantations");
        System.out.println (user.name + " Magical damage increases drastically at the cost of half of " + user.name + "'s health!");
        user.magic *= 2.5;
        user.HP /= 2;
        
    }
}


//class Thief skils
class backStab extends Skill
{
    public backStab()
    {
        mpCost = 15;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " dashes behind the " + c.name + " and deals a fatal stab!");
        user.MP -= mpCost;
         if (((Math.random() * 50)) <= user.luck)
        {
            c.takeDamage (user.str * 2 - c.def / 2 );
            System.out.println ("It's a critical hit! REKT");
        }
        else
        {
            c.takeDamage (user.str * 2 - c.def);
        }
        
    }
}

class assassinate extends Skill
{
    public assassinate()
    {
        mpCost = 30;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " attempts to assassinate the " + c.name + "!");
        user.MP -= mpCost;
        if (((Math.random() * 110)) <= user.luck)
        {
            c.takeDamage (c.HP);
            System.out.println ("It's a one hit ko!");
        }
        else
        {
            c.takeDamage ((int)(c.HP * .2));
        }
        
    }
}

class gamble extends Skill
{
    public gamble()
    {
        mpCost = 30;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " flips a coin!");
        if (((Math.random() * 200)) <= user.luck)
        {
            user.luck *= 2;
            user.speed *= 2;
            System.out.println ("Lucky!" +user.name + " obtains unimaginable power!");
        }
        else
        {
            user.luck /= 2;
            user.speed /= 2;
            System.out.println ("Unlucky!" +user.name + " obtains unimaginable weaknesses!");
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
        System.out.println (user.name + " cast Heat Wave"); 
        user.MP -= mpCost;
        if (c.element.equals ("Wood") )
        {
           c.takeDamage (user.magic*2 - c.res); 
           System.out.println ("It's super effective!");
        }
        
        else if (c.element.equals ("Aqua") )
        {
           c.takeDamage (user.magic/2 - c.res); 
           System.out.println ("It's not very effective...");
        }
        
        else
        {
            c.takeDamage (user.magic - c.res);
        }
    }
}



class reKindle extends Skill
{
    public reKindle()
    {
        mpCost = 10;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " cast Rekindle!");
        System.out.println (user.name + " is enveloped by a firey aura! Resistance to magic has increased!");
        user.res += 4;
    }
}

class flameCrash extends Skill
{
    public flameCrash()
    {
        mpCost = 15;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " used Flame Crash!"); 
        user.MP -= mpCost;
        if (c.element.equals ("Wood") )
        {
           c.takeDamage (user.str*2 - c.res); 
           System.out.println ("It's super effective!");
        }
        
        else if (c.element.equals ("Aqua") )
        {
           c.takeDamage (user.str/2 - c.res); 
           System.out.println ("It's not very effective...");
        }
        
        else
        {
            c.takeDamage (user.magic - c.res);
        }
    }
}

//element aqua skills
class hailStorm extends Skill
{
    public hailStorm()
    {
        mpCost = 20;
    }
    
    public void use (GChar user, GChar c){
        System.out.println (user.name + " fires chunks of ice!");
        int hits = 3;
        while (hits != 0)
        {
            if (c.element.equals ("Wood") )
            {
                 c.takeDamage (user.str*2 - c.def); 
                System.out.println ("It's super effective!");
            }
        
            else if (c.element.equals ("Fire") )
            {
                c.takeDamage (user.str/2 - c.def); 
                System.out.println ("It's not very effective...");
            }
        
            else
            {
             c.takeDamage (user.str - c.def);
            }
            
            hits --;
        }
        
    }
}

class tidalWave extends Skill
{
    public tidalWave()
    {
        mpCost = 25;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " launched a giant wave at " + c.name + "!"); 
        user.MP -= mpCost;
        if (c.element.equals ("Fire") )
        {
           c.takeDamage (user.magic*3 - c.res); 
           System.out.println ("It's super effective!");
        }
        
        else if (c.element.equals ("Wood") )
        {
           c.takeDamage (user.magic/2 - c.res); 
           System.out.println ("It's not very effective...");
        }
        
        else
        {
            c.takeDamage (user.magic - c.res);
        }
    }
}

class aquaVeil extends Skill
{
    public aquaVeil()
    {
        mpCost = 10;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " cast Aqua Veil!");
        System.out.println (user.name + " is enveloped by a ring of water. Resistance to physical attacks increased!");
        user.def += 4;
    }
}

//element Wood Skills
class flowerDance extends Skill
{
    public flowerDance()
    {
        mpCost = 30;
    }
    
    public void use (GChar user, GChar c){
        System.out.println (user.name + " begins a gallant dnace");
        int hits = (int)(Math.random() *7);
        if (hits == 0 )
        {
            System.out.println (user.name + " trips!");
            user.takeDamage (10);
        }
        while (hits != 0)
        {
            user.useSkill ("BasicAttack", c);
            hits --;
        }
        
    }
}

class woodSpike extends Skill
{
    public woodSpike()
    {
        mpCost = 25;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " impales " + c.name + " with a spike of wood!"); 
        user.MP -= mpCost;
        if (c.element.equals ("Aqua") )
        {
           c.takeDamage (user.magic*2 - c.def); 
           System.out.println ("It's super effective!");
        }
        
        else if (c.element.equals ("Fire") )
        {
           c.takeDamage (user.magic/2 - c.def); 
           System.out.println ("It's not very effective...");
        }
        
        else
        {
            c.takeDamage (user.magic - c.def);
        }
    }
}

class pepperSong extends Skill
{
    public pepperSong()
    {
        mpCost = 10;
    }
    
    public void use (GChar user, GChar c)
    {
        System.out.println (user.name + " sings the Pepper Song");
        System.out.println ("The lyrics are so awesome that " + user.name + "regains health!");
        user.HP += 10;
    }
}
