package LeetCodeProblems;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] array = new int[]{10, 15, 20};
        int[] array1 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] array3 = new int[]{0,0,0,0};
        int[] array4 = new int[]{0,1,2,2};


//        System.out.println(minCostClimbingStairs(array));
//        System.out.println(minCostClimbingStairs(array1));
//        System.out.println(minCostClimbingStairs(array3));
        System.out.println(minCostClimbingStairs(array4));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int stairs = 0;


        for(int i =0; i<cost.length-1; i++){
            if(i == cost.length-2){
                if(cost[i]>cost[i+1]){
                    stairs = stairs+ cost[i+1];
                }else {
                    stairs = stairs+ cost[i];
                }
                break;
            }

            if(cost[i]>cost[i+1] || cost[i]+cost[i+2]>cost[i+1]){
                i =i +1;
            }
//            cost[i]+cost[i+2]>cost[i+1]
//            if(i<=cost.length-3){
//                if(cost[i]+cost[i+2]>cost[i+1]){
//                    i=i+1;
//                }
//            }
            stairs = stairs+cost[i];
        }


        return stairs;
    }
}
