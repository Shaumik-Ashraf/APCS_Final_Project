import java.io.*;
import java.util.*;

public class Fire extends Character{
    
    public Fire (ArrayList<String> player){
        name = player.get(0);
        element = player.get(4);
        
        HP = 100;
        str = 10;
        magic =10;
        def = 10;
        res = 10;
        luck = 10;
        speed = 10;
   
    }
        
        
}