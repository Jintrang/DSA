package week9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class phoneBook {
    public static void main(String []argh)
    {
        Map st = new HashMap();
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            in.nextLine();
            st.put(name, phone);
        }
        while(in.hasNext())
        {
            String s=in.nextLine();
            if(st.containsKey(s)) {
                System.out.println(s + "=" + st.get(s));
            } else System.out.println("Not found");
        }
    }
}
