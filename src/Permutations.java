package LeetCodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] arrays = new int[]{1,2,3};
        int[] arrays1 = new int[]{0,1};

//        permute(arrays);

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list = permute(arrays1);

        for(int i = 0; i<list.size(); i++){
            for(int j = 0; j<list.get(i).size(); j++){
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        //unstate situations
        //optimize this code
        if(nums.length == 1 ){
            ArrayList<Integer> tempArrayL = new ArrayList<Integer>();
            tempArrayL.add(nums[0]);
            list.add(tempArrayL);
            return list;
        }




        for (int i = 0; i<nums.length; i++){
            int[] numsCopy = nums.clone();



            ArrayList<Integer> tempArray = new ArrayList<Integer>();
            for(int x : nums){
                tempArray.add(x);
            }
            list.add(tempArray);


            for(int j = numsCopy.length-1; j> numsCopy.length-2; j--){

                if(nums.length == 2){
                    break;
                }


                int temp = numsCopy[j];
                numsCopy[j] = numsCopy[j-1];
                numsCopy[j-1] = temp;

                tempArray = new ArrayList<Integer>();
                for(int x : numsCopy){
                    tempArray.add(x);
                }
                list.add(tempArray);

            }
            if(i!=nums.length-1){
                int temp = nums[0];
                nums[0]=nums[i+1];
                nums[i+1] = temp;
            }

            System.out.println();
        }
        return list;
    }

// NEW NEW 
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> permutations, List<Integer> tempList){
        if(tempList.size() == nums.length)
            permutations.add(new ArrayList<>(tempList));

        else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue;       // Element exists (distinct), skip this
                tempList.add(nums[i]);
                backtrack(nums, permutations, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }

    }
}
