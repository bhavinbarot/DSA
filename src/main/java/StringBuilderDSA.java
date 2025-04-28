public class StringBuilderDSA {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Tony");
        System.out.println(sb);

        //char at index 0
        System.out.println(sb.charAt(1));

        //set chart at 2
        sb.setCharAt(0,'P');
        System.out.println(sb);

        //Insert 'S' at 0 position
        sb.insert(2, "m");
        System.out.println(sb);

        //Delete Character
        sb.delete(2,4);
        System.out.println(sb);

        sb.append("e");
        sb.append("l");
        System.out.println(sb);

        StringBuilder sb1 = new StringBuilder("Hello");
        for (int i = 0; i < sb1.length()/2; i++) {
            int frontIndex = i;
            int backIndex = sb.length()-1-i;
            char temp = sb1.charAt(frontIndex);
            sb1.setCharAt(frontIndex, sb1.charAt(backIndex));
            sb1.setCharAt(backIndex, temp);
        }

        System.out.println(sb1);

    }
}
