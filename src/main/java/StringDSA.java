import java.util.Scanner;

public class StringDSA {
    public static void main(String[] args) {
        /*
        Scanner sc = new Scanner(System.in);
        String myName = sc.next();
        System.out.println(myName);
        */

        String lastname = "Barot";
        for(int i=0 ; i<lastname.length();i++)
        {
            System.out.println(lastname.charAt(i));
        }

        String name1 = "Tonx";
        String name2 = "Tony";

        System.out.println(name1.compareTo(name2));

        String sentence = "I am Bhavin - testing substring";
        for (int i = 0; i < sentence.length(); i++) {
            System.out.println(sentence.substring(i));
        }
        //Strings are Immutable

    }
}
