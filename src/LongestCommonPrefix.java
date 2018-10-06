import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[][] asd = new String[][] {

                new String[]{"abab","aba",""},

                new String[]{"aa", "a"},
                new String[]{"we", "wendor", "well"},

                new String[]{"flower","flow","flight"},

                new String[]{"a", "a", "abcd", "a"},

                new String[0],

                new String[]{"",""},

                new String[]{ "", "","","","s","s"},

                new String[]{"abcd","","",""},

                new String[]{"dog","racecar","car"},
        };

        for (int i = 0; i < asd.length; i++) {
            String[] anAsd = asd[i];
            System.out.print(i);
            System.out.print(" ");
            Arrays.stream(anAsd).forEach(System.out::print);
            System.out.print(" ");
            String x = longestCommonPrefix(anAsd);
            System.out.println(x);
        }

    }

    public static String longestCommonPrefix(String[] strs) {

        //Result to return in future
        String result = "";

        //returning "" when array is empty
        if( strs.length == 0){
            return result;
        }
        //If we need to compare smth, we need at least 2 words
        //So we are getting first word to compare it with others in future
        String firstWord = strs[0];

        //There is nothing to compare when there are no at least 2 elements
        // or first word is already empty
        if( strs.length < 2 || firstWord == "" ){
            return result;
        }


        int firstWrodLength = firstWord.length();

        //this loop will go through first word chars
        A:for (int currentCharNumber = 0; currentCharNumber < firstWrodLength; currentCharNumber++) {

            //error was here
            //trying to get index 1 at second word
            //getting first word's char
            char charToCheck = firstWord.charAt(currentCharNumber);

            //this loop goes through other words, starting from strs[1] word
            for (int currentWordIndex = 1; currentWordIndex < strs.length; currentWordIndex++) {
                //getting char from current word
                String currentWord = strs[currentWordIndex];

                //if current word is empty, return ""
                if (currentWord == "" ) {
                    return "";
                }

                if (currentWord.length() < firstWrodLength){
//                    return "";
                }

                //check it check it
                if(currentCharNumber==currentWord.length()-1){
                    break A;
                }

                //getting current char in current word
                char currentChar = currentWord.charAt(currentCharNumber);

                    //if words have common char continue loop
                    //break the loop otherwise
                    if(currentChar == charToCheck ){
//                    result += charToCheck;
                        continue;
                    }
                    else {
                        break A;
                    }

//                checkChar = strs[currentWordIndex].charAt(currentCharNumber);
//                // why 2
//                if (strs.length<2 || strs[currentWordIndex] == ""||strs[currentWordIndex].charAt(currentCharNumber) != checkChar) {
//                    checker = false;
//                    break A;
//                }

            }
            //adding new char to result String
            result += charToCheck;

        }

        return result;
    }

}
