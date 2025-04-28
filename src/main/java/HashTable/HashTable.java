package HashTable;

import java.util.*;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        dataMap = new Node[size];
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("   {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    public int hash(String key){
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for(int i =0; i< keyChars.length ; i++){
            int asciiValue = keyChars[i];
            //If you Multiply it by prime number, The number you get is more random.
            //% dataMap.length will give remainder
            //This will give the index
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        System.out.println("Hash Index for the key - '" + key + "' is : " + hash);
        return hash;
    }

    public void set(String key, int value){
        int index = hash(key);
        Node newNode = new Node(key, value);

        //If the linked list at the index is empty
        if(dataMap[index] == null){
            dataMap[index] = newNode;
        }else{
            //If the linked list at the index is NOT empty
            Node temp = dataMap[index];
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key){
        int index = hash(key);
        Node temp = dataMap[index];
        while(temp !=null){
            if(temp.key == key){
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList keys(){
        ArrayList<String> allKeys = new ArrayList<>();
        for(int i=0;i<dataMap.length;i++){
            Node temp = dataMap[i];
            while(temp != null){
                allKeys.add(temp.key);
                temp = temp.next;

            }
        }
        return allKeys;
    }

    public static boolean itemsInCommon(int[] array1, int[] array2){
        HashMap<Integer, Boolean> myhashMap = new HashMap<>();

        for(int i : array1){
            myhashMap.put(i, true);
        }

        for(int j : array2){
            if(myhashMap.get(j)!=null){
                return true;
            }
        }
        /*
        for(int i=0; i<array1.length;i++){
            myhashMap.put(array1[i], true);
        }

        for(int j=0; j<array2.length;j++){
            if(myhashMap.get(array2[j]) != null)
                return true;
        }

         */
        return false;
    }

    public List<Integer> findDuplicates(int[] nums){
        HashMap<Integer, Integer> numbers = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        for(int i : nums){
            if(numbers.get(i)==null){
                System.out.println("numbers.getOrDefault - " + numbers.getOrDefault(i,0));
                numbers.put(i, numbers.getOrDefault(i,0)+1);
            }else{
                if(numbers.getOrDefault(i,0) == 1){
                    duplicates.add(i);
                }
                numbers.put(i, numbers.getOrDefault(i,0)+1);
            }
        }
        return duplicates;
    }


    public Character firstNonRepeatingChar(String str){
        Character firstNonRepeating = null;
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(Character ch : str.toCharArray()){
            charMap.put(ch, charMap.getOrDefault(ch,0)+1);
        }
        for(Character ch1 : str.toCharArray()){
            if(charMap.get(ch1) == 1){
                firstNonRepeating = ch1;
                return firstNonRepeating;
            }
        }
        return firstNonRepeating;
    }

    public List<List<String>> groupAnagrams(String[] strings){
        List<List<String>> anagrams = new ArrayList<>();
        HashMap<String, Integer> stringMap = new HashMap<>();

        for(int i=0;i<strings.length;i++){
            //Create a variable to hold the string as list
            List<String> group = new ArrayList<>();
            //Add it to global String Map for the first time.
            if(stringMap.get(strings[i]) == null){
                stringMap.put(strings[i], stringMap.getOrDefault(strings[i],0)+1);
                group.add(strings[i]);
            }else{
                continue;
            }

            //Create map for the string characters
            HashMap<Character, Integer> charMap = new HashMap<>();
            for(Character ch : strings[i].toCharArray()){
                charMap.put(ch, charMap.getOrDefault(ch,0)+1);
            }

            for(int j=i+1;j<strings.length;j++){
                //Create another char map to Compare it with other strings
                HashMap<Character, Integer> charMap1 = new HashMap<>();
                boolean areCharCountNotMatching = false;
                for(Character ch1 : strings[j].toCharArray()){
                    charMap1.put(ch1, charMap1.getOrDefault(ch1,0)+1);
                    if(charMap.get(ch1) != charMap1.get(ch1)){
                        areCharCountNotMatching = true;
                    }
                }

                if(!areCharCountNotMatching){
                    group.add(strings[j]);
                    stringMap.put(strings[j], stringMap.getOrDefault(strings[j],0)+1);
                }
            }

            //Add a group to Anagrams
            anagrams.add(group);
        }

        return anagrams;
    }


    public int[] twoSum(int[] numbers, int target){
        HashMap<Integer, Integer> myHash = new HashMap<>();
        for(int i=0; i< numbers.length ; i++){
            int complement = target-numbers[i];

            // Check if the complement is already in the map
            if (myHash.containsKey(complement)) {
                // If found, return the current index and the index of the complement
                return new int[]{myHash.get(complement), i};
            }
            // Otherwise, store the current number with its index
            myHash.put(numbers[i], i);

        }
        return new int[]{};
    }

    //Pending
    public int[] subarraySum(int[] numbers, int target) {
        HashMap<Integer, Integer> sumIndex = new HashMap<>();
        return new int[]{};
    }

    public List<Integer> removeDuplicates(List<Integer> myList){

        //Set<Integer> uniqueSet = new HashSet<>();

        //for(int i=0;i<myList.size();i++){
        //    uniqueSet.add(myList.get(i));
        //}
        //More Efficient
        Set<Integer> uniqueSet = new HashSet<>(myList);
        return new ArrayList<>(uniqueSet);

    }

    public boolean hasUniqueChars(String str){
        /*
        HashMap<Character, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);  // Get the character at index i

            //If hash map does not contain the character
            if(!hashMap.containsKey(ch)){
                hashMap.put(ch, true);
            }else{
                return false;
            }
        }
        */

        HashSet<Character> hashSet = new HashSet<>();
        for(char ch : str.toCharArray()){

        }
        return true;
    }



}