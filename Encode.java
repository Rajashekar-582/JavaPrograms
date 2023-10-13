package corejava;

import java.util.Scanner;

public class Encode {
	void m1(String s)
	{
		int U = 2;
        int l = 3;
        int a = 26;
        
        StringBuilder b = new StringBuilder();

        for (char c : s.toCharArray())
        {
            if (Character.isUpperCase(c)) 
            {
                char p = (char) (((c - 'A' - U + a) % a) + 'A');
                b.append(p);
            } 
            else if (Character.isLowerCase(c))
            {
                char p = (char) (((c - 'a' - l + a) % a) + 'a');
                b.append(p);
            } 
            else 
            {
                b.append(c);
            }
        }
			
        System.out.println(b.toString());
				
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		
		Encode e=new Encode();
		e.m1(s);
		
	}

}
/*
output:
Hello
Fbiil
==========================
Zebra
Xbyox
*/