package ArraysAndStrings;
import java.util.Arrays;

public class IsUnique {
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isUnique1(str));
        System.out.println(isUnique2(str));
        System.out.println(isUnique3(str));

    }

    public static boolean isUnique1(String str) {
        
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) return false;
            }
        }
        return true;

        //Time Complexity : O(n^2)
        //Space Complexity : O(1)
    }

    public static boolean isUnique2(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) return false;
        }
        return true;

        //Time Complexity : O(nlogn)
        //Space Complexity : O(n)
    }

    public static boolean isUnique3(String str) {

        //An Integer to store presence and absence of 26 characters using its 32 bits
        // checker is the variable to store the bits if  its true or false

        int checker =0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i)-'a';
            
            // If bit corresponding to current character is already set then that character is present
            // 1<<0 means 1 , 1<<2 means 100, 1<<4 means 10000, 1<<6 means 1000000
            // left shift operator <<
            if ((checker & (1<<val))>0) {   
                return false;
            }

            // Set the bit corresponding to current character
            checker |= (1<<val);
        }
        return true;

        //Time Complexity : O(n)
        //Space Complexity : O(1)
    }
}