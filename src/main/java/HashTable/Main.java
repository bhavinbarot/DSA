package HashTable;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        HashTable myHashTable = new HashTable();
        myHashTable.printTable();
        myHashTable.hash("baba");

        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);
        myHashTable.set("bolts", 200);
        myHashTable.set("screws", 140);

        myHashTable.printTable();

        System.out.println("Testing Get");
        System.out.println(myHashTable.get("Something"));
        System.out.println(myHashTable.get("tile"));
        System.out.println(myHashTable.get("screws"));

        //Get all Keys
        myHashTable = null;
        myHashTable =  new HashTable();
        myHashTable.set("paint", 20);
        myHashTable.set("bolts", 40);
        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);
        myHashTable.printTable();
        System.out.println("All Keys");
        System.out.println(myHashTable.keys());


        int[] array1 = {1,3,5};
        int[] array2 = {2,4,6};
        System.out.println("array1 - " + Arrays.toString(array1));
        System.out.println("array2 - " + Arrays.toString(array2));
        System.out.println("itemsInCommon : "+ myHashTable.itemsInCommon(array1, array2));

        //Find Duplicates
        int[] nums = {1,2,3,2,1,4,5,4};
        //int[] nums = {1,1,1,1};
        List<Integer> duplicates = myHashTable.findDuplicates(nums);

        System.out.println("duplicates : " + duplicates);

        System.out.println("\n\nFirst Non Repeating Characters");
        System.out.println("For Hello -> " + myHashTable.firstNonRepeatingChar("Hello"));


        System.out.println("\n\nGroup Anagrams");
        System.out.println("1st set:");
        System.out.println(myHashTable.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(myHashTable.groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(myHashTable.groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));


        System.out.println("\n\nTwo Sum:");
        System.out.println(Arrays.toString(myHashTable.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(myHashTable.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(myHashTable.twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(myHashTable.twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(myHashTable.twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(myHashTable.twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(myHashTable.twoSum(new int[]{}, 0)));

        System.out.println("\n\nRemove Duplicates:");
        List<Integer> myList = List.of(1,2,2,3,3,4,4,4);
        List<Integer> newList = myHashTable.removeDuplicates(myList);
        System.out.println(newList);

        System.out.println("\n\nhasUniqueChars:");
        System.out.println(myHashTable.hasUniqueChars("ABC"));
        System.out.println(myHashTable.hasUniqueChars("ABCC"));

    }
}
