package leetcode.medium.permutations;

import java.util.*;

/**
 * Problem from leetcode
 *
 * @author Pavel Kazarin
 * @see <a href="https://leetcode.com/problems/permutations/description/">Permutations</a>
 */
class Permutations {

    /**
     * This method calculates all possible permutations
     *
     * @param nums Array of ints
     * @return List of list of possible permutations
     */
    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>());
//        backtrackSet(nums,result,new ArrayList<>(), new HashSet<>());
        return result;
    }

    /**
     * Recursive method that calculates all permutations
     *
     * @param nums         Array of ints
     * @param permutations List of list of possible permutations
     * @param tempList     Current list we work with
     */
    private static void backtrack(int[] nums, List<List<Integer>> permutations, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            permutations.add(new ArrayList<>(tempList));
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) continue;
                tempList.add(num);
                backtrack(nums, permutations, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * Recursive method that calculate all permutations using Set.
     * @param nums Array of ints
     * @param permutations List of list of possible permutations
     * @param tempList current list we work with
     * @param tempSet current set we work with
     */
    private static void backtrackSet(int[] nums, List<List<Integer>> permutations, List<Integer> tempList, Set<Integer> tempSet){
        if(tempList.size()==nums.length){
            permutations.add(new ArrayList<>(tempList));
        }else{
            for(int num : nums){
                if(tempSet.contains(num)) continue;
                tempList.add(num);
                tempSet.add(num);
                backtrackSet(nums,permutations,tempList, tempSet);
                tempSet.remove(num);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
