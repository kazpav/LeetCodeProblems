

//this one works correctly, was approved by leetcode
public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[] case1 = new String[]{"aa", "a"};

//        String[] case2 = new String[]{"abab", "aba", ""};
//
//        String[] case3 = new String[]{"we", "wendor", "well"};
//
//        String[] case4 = new String[]{"flower", "flow", "flight"};
//
//        String[] case5 = new String[]{"a", "a", "abcd", "a"};
//
//        String[] case6 = new String[0];
//
//        String[] case7 = new String[]{"", ""};
//
//        String[] case8 = new String[]{"", "", "", "", "s", "s"};
//
//        String[] case9 = new String[]{"abcd", "", "", ""};
//
//        String[] case10 = new String[]{"dog", "racecar", "car"};

        System.out.println(longestCommonPrefix(case1));

    }

    public static String longestCommonPrefix(String[] strs) {

        //Result to return in future
        String result = "";

        //returning "" when array is empty
        if (strs.length == 0) {
            return result;
        }
        if (strs.length == 1) {
            return strs[0];
        }
        //If we need to compare smth, we need at least 2 words
        //So we are getting first word to compare it with others in future
        String firstWord = strs[0];

        //There is nothing to compare when there are no at least 2 elements
        // or first word is already empty
        if (strs.length < 2 || firstWord == "") {
            return result;
        }

        int firstWrodLength = firstWord.length();

        //this loop will go through first word chars
        A:
        for (int currentCharNumber = 0; currentCharNumber < firstWrodLength; currentCharNumber++) {

            //error was here
            //trying to get index 1 at second word
            //getting first word's char
            char charToCheck = firstWord.charAt(currentCharNumber);

            //this loop goes through other words, starting from strs[1] word
            for (int currentWordIndex = 1; currentWordIndex < strs.length; currentWordIndex++) {
                //getting char from current word
                String currentWord = strs[currentWordIndex];

                //if current word is empty, return ""
                if (currentWord == "") {
                    return "";
                }

                if (currentCharNumber == currentWord.length()) {

                    break A;
                }

                //getting current char in current word
                char currentChar = currentWord.charAt(currentCharNumber);

                //if words have common char continue loop
                //break the loop otherwise
                if (currentChar == charToCheck) {
                    continue;
                } else {
                    break A;
                }
            }
            //adding new char to result String
            result += charToCheck;
        }
        return result;
    }

}
