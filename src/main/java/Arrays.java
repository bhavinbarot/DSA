import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        //int[] arrayName = new int[5];
        System.out.println("Sample 1 : Array of 10 integers");
        int arrayName[] = new int[10]; //You can keep bracket anywhere
        arrayName[0] = 11;
        arrayName[1] = 12;
        arrayName[2] = 13;
        System.out.println(arrayName[0]);

        System.out.println("Sample 2 : Pre defined Array Values");
        int preDefinedArrayValues[] = {11,12,13,14};
        for(int i=0;i<preDefinedArrayValues.length;i++)
        {
            System.out.println(preDefinedArrayValues[i]);
        }

        System.out.println("Sample 3 : Take input from User");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int userArray[] = new int[size];

        for(int i=0;i<userArray.length;i++)
        {
            userArray[i] = sc.nextInt();
        }
        for(int i=0;i<userArray.length;i++)
        {
            System.out.println(userArray[i]);
        }



    }
}
