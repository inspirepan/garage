package playground;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author panjx
 */

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        try{
            set.add(null);
            System.out.println("ok");
        }catch (NullPointerException e){
            System.out.println("fail");
        }
    }


}


