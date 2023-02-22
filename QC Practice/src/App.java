import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class App {

    public static int getLongestSubstringLength(String someString)
    {
        int currentLongest = 0;
        int idx = 0;

        for (int i=1; i<someString.length(); i++){
            String subString = someString.substring(idx, i);  //substring up to current char
            int strLen = subString.length();
            int idxOf = subString.indexOf(someString.charAt(i));  //check if current char is in the substring

            if (idxOf != -1){  //if contains duplicate
                if (strLen > currentLongest){
                    currentLongest = strLen;  //replace if it is the longest substring seen
                }
                idx += idxOf+1; //move front pointer after idxOf.
            }

            if (i == someString.length() -1){  // if last iteration, do final check inclusive of last char
                strLen = someString.substring(idx, i+1).length();
                if (strLen > currentLongest){
                    currentLongest = strLen;
                }
            }

        }
        return currentLongest;
    }
    public static void main(String[] args) throws Exception {
        Map<String, Integer> testcases = new HashMap<>();

        testcases.put("abcdddef", 4);
        testcases.put("aaaaa", 1);
        testcases.put("pwwkew", 3);
        testcases.put("",0);
        testcases.put("uthyysleelsinkkweoroikkkpoqweriueeeerrttyy",9);
        testcases.put("dvdf", 3);
        testcases.put("aab", 2);

        for (Entry<String,Integer> elemeEntry : testcases.entrySet()) {
            int actual = getLongestSubstringLength(elemeEntry.getKey());

            System.out.println("Testcase: " + elemeEntry.getKey());

            if (actual == elemeEntry.getValue()) {
                System.out.println("\u001B[32m"+"Correct"+"\u001B[0m");
                System.out.println("longest substring is " + elemeEntry.getValue());
            }else {
                System.out.println("\u001B[31m"+"Failed"+"\u001B[0m");
                System.out.println("Your method gave: " + actual);
            }
            
            System.out.println("===============================");
        }

        
    }
}