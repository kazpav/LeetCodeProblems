package LeetCodeProblems;

import java.util.HashMap;

//this one works correctly and was approved by leetcode
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("ab", "aa"));

    }


    public static boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            //checking if such key is already stored in hashmap
            if (hashMap.containsKey(s.charAt(i))) {
                //if key and value doesn't map - return false
                if (!hashMap.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
                //if there are no such key, but we already have such value - they don't map, return false
            } else if (hashMap.containsValue(t.charAt(i))) {
                return false;
            } else {
                //if there are no coincidences, put new element
                hashMap.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }
}
