public class BitManipulation {
    public static void main(String[] args) {
        //Get Bit
        //Get the bit at 3rd position
        int a = 5; //0101
        a = 8;
        int position = 3;
        int bitMask = 1<<position;

        if((a & bitMask) == 0){
            System.out.println("It's Zero");
        }
        else {
            System.out.println("It's NOT Zero");
        }


        //Set bit
        //set 2nd bit  (position 1 from right - 01'0'1) of a Binary number N.
        int b = 5; //0101
        int pos2 = 1;
        int bitMask1 = 1<< pos2;

        System.out.println(b | bitMask1);


        //Clear bit
        //Clear 3rd bit (position 2 from right 0'1'01) of a Binary Number
        System.out.println("Clearing Bit");

        int c = 5; //0101
        int pos3 = 2;
        int bitMask2 = 1<< pos3;
        //System.out.println(bitMask2);

        System.out.println(b & ~bitMask2);

        //Update Bit with 1
        System.out.println("Update bit with 1");

        int d = 5; //0101
        int pos4 = 1;
        int bitMask4 = 1<< pos4;
        System.out.println(d & ~bitMask4);

        //Update Bit with 0
        System.out.println("Update bit with 1");

        int e = 5; //0101
        int pos5 = 1;
        int bitMask5 = 1<< pos4;
        System.out.println(e | bitMask5);
    }



}
