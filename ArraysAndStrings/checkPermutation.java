package ArraysAndStrings;


import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;


public class checkPermutation {
    public static void main(String[] args) {
        System.out.println("JUnit Testing is written");
    }

    public static boolean checkPermutationBySorting(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        char[] arrStr1 = str1.toCharArray();
        char[] arrStr2 = str2.toCharArray();

        Arrays.sort(arrStr1);
        Arrays.sort(arrStr2);
        
        return new String(arrStr1).equals(new String (arrStr2));

        // Time Complexity : O(nlogn)
        //Space Complexity : O(n)
    }

    public static boolean checkPermutationByCount(String str1, String str2){
        int checker1=0;
        int checker2=0;

        if (str1.length() != str2.length()) return false;


        for (int i =0; i< str1.length(); i++){
            int c1 = str1.charAt(i)-'a';
            int c2 = str2.charAt(i)-'a';

            checker1 ^= 1<<c1;
            checker2 ^= 1<<c2;
        }
        return checker1==checker2;

        //Time Complexity : O(n)
        //Space Complexity : O(1)
    }
    
    @Test
    public void testCheckPermutation() throws Exception{
        assertEquals(true, checkPermutationBySorting("dog", "god"));
        assertEquals(true, checkPermutationBySorting("",""));
        assertEquals(false,checkPermutationBySorting("pastry","trypes"));

        assertEquals(true, checkPermutationByCount("dog", "god"));
        assertEquals(true, checkPermutationByCount("",""));
        assertEquals(false,checkPermutationByCount("pastry","trypes"));

    }
}


