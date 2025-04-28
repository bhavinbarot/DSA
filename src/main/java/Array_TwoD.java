import java.util.Scanner;

public class Array_TwoD {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Rows");
        int rows = sc.nextInt();
        System.out.println("Enter Number of Columns");
        int columns = sc.nextInt();

        int[][] numbers = new int[rows][columns];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.printf("Enter element at Row %d and Column %d :", i,j);
                numbers[i][j] = sc.nextInt();
            }
        }
        System.out.println("Here is your matrix");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.printf("%d - ", numbers[i][j]);
            }
            System.out.println("->");
        }

        //Find out an indice where number 3 is present
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if(numbers[i][j] == 3)
                {
                    System.out.printf("3 Found at row %d column %d", i,j);
                }
            }

        }

    }
}
