package visit;

import java.util.ArrayList;
import java.util.List;

public class Repeat {

    private void checkEven(int n){
        if(n%2==0)
            System.out.println("Even");
        else
            System.out.println("Odd");


    }

    private static void test(){
        String[] field = {"b", "a", "y", "l", "o", "r"};

        String s = "";

        for (int i = 0; i < field.length; ++i) {
            s = s + field[i];
        }
        List<String> names = new ArrayList<String>();
        System.out.println(s);


		/*
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < field.length; ++i) {
			sb.append(field[i]);
		}
		s = sb.toString();
		*/
        System.out.println(s);

    }
}
