package leetcode.easy.longest_common_prefix;


/**
 * This problem is solved and was approved by leetcode
 *
 * @author Pavel Kazarin
 * @see <a href="https://leetcode.com/problems/longest-common-prefix/description/">Longest Common Prefix</a>
 */
class LongestCommonPrefix {

    /**
     * This method finds common prefixes in String array
     *
     * @param strs String array to check
     * @return Longest common prefix
     */
    static String longestCommonPrefix(String[] strs) {

        // Result to return in future
        StringBuilder result = new StringBuilder();

        // Returning "" when array is empty
        if (strs.length == 0) {
            return result.toString();
        }
        if (strs.length == 1) {
            return strs[0];
        }
        // If we need to compare smth, we need at least 2 words
        // So we are getting first word to compare it with others in future
        String firstWord = strs[0];

        // There is no need to compare anything if first word is empty
        if (firstWord.equals("")) {
            return result.toString();
        }

        int firstWrodLength = firstWord.length();

        // This loop will go through first word chars
        for (int currentCharNumber = 0; currentCharNumber < firstWrodLength; currentCharNumber++) {

            // Getting first word's char
            char charToCheck = firstWord.charAt(currentCharNumber);

            // This loop goes through other words, starting from strs[1] word
            for (int currentWordIndex = 1; currentWordIndex < strs.length; currentWordIndex++) {
                // Getting char from current word
                String currentWord = strs[currentWordIndex];

                // If current word is empty, return ""
                if (currentWord.equals("")) {
                    return "";
                }

                if (currentCharNumber == currentWord.length()) {
                    return result.toString();
                }

                // Getting current char in current word
                char currentChar = currentWord.charAt(currentCharNumber);

                // If words have common char continue loop
                // Return result the loop otherwise
                if (currentChar != charToCheck) {
                    return result.toString();
                }
            }
            // Adding new char to result String
            result.append(charToCheck);
        }
        return result.toString();
    }
}
