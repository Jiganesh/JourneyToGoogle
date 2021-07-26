package ArraysAndStrings;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class URLify {
    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith    ", 13));
    }

    public static String replaceSpaces(String str, int trueLength) {
        // If true length is not given we count the number of spaces and add them to lenght.
        char [] chars = str.toCharArray();
        int endPointer = chars.length-1;
        int stringPointer = trueLength-1;

        while(stringPointer !=0){
            if (chars[stringPointer] != ' '){
                chars[endPointer] = chars[stringPointer];
                endPointer--;
                stringPointer--;
            }
            else{
                chars[endPointer] = '0';
                chars[endPointer-1] = '2';
                chars[endPointer-2] = '%';
                endPointer -= 3;
                stringPointer--;
            }
        }
        return new String(chars);
        // Time Complexity: O(n)
        // Space Complexity: O(n)
    }

    @Test
    public void testReplaceSpaces() throws Exception{
        assertEquals("Mr%20John%20Smith", replaceSpaces("Mr John Smith    ", 13));
    }

}
