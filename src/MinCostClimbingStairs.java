import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MinCostClimbingStairs {

    public static void main(String[] args) {


        ArrayList<TestInput<Integer, Integer>> inputs = new ArrayList<>();

        inputs.add(new TestInput<>(new Integer[]{1, 2, 2, 0}, 2));

        inputs.add(new TestInput<>(new Integer[]{0}, 0));
        inputs.add(new TestInput<>(new Integer[0], 0));
        inputs.add(new TestInput<>(new Integer[]{0,1,2,2}, 2));
        inputs.add(new TestInput<>(new Integer[]{0,0,0,0}, 0));
        inputs.add(new TestInput<>(new Integer[]{10, 15, 20}, 15));
        inputs.add(new TestInput<>(new Integer[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, 6));



        for (int i = 0; i < inputs.size(); i++) {
            Integer[] input = inputs.get(i).Input;

            System.out.printf("%s: [", i);
            Arrays.stream(input).map(s -> s + " ").forEach(System.out::print);
            System.out.printf("]%n");

            // Integer x = minCostClimbingStairs(input);
            Integer x = minCostClimbingStairs2(input);
            System.out.printf("[%s]%n", x);
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!Objects.equals(x, inputs.get(i).Expected)){
                String error = String.format("Wrong Answer! Got: %s Expected: %s", x, inputs.get(i).Expected.toString());
                throw new ArithmeticException(error);
            }
        }
        System.out.println();
    }

    public static Integer minCostClimbingStairs(Integer[] cost) {
        int stairs = 0;


        for(int i = 0; i < cost.length - 1; i++){
            if(i == cost.length - 2){
                if(cost[i] > cost[i+1]){
                    stairs = stairs + cost[i+1];
                } else {
                    stairs = stairs + cost[i];
                }
                break;
            }

            if(cost[i] > cost[i+1] || cost[i] + cost[i+2]>cost[i+1]){
                i = i + 1;
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

    public static Integer minCostClimbingStairs2(Integer[] cost) {
            int currentSum = 0;
            int currentIndex = -1;

            while(true){

                int next = currentIndex + 1;
                int afterNext = currentIndex + 2;

                if(cost.length <= afterNext){
                    break;
                }

                int nCost = cost[next];
                int anCost = cost[afterNext];

                if (nCost < anCost){

                    // Only three elements left
                    if (cost.length == afterNext + 2){
                        int tCost = cost[afterNext + 1];

                        // If first + third > second
                        if (nCost + tCost > anCost){

                            // Add cost of second and return from function
                            return currentSum + anCost;
                        }
                    }

                    // Only four elements left
                    if (cost.length == afterNext + 3){
                        int tCost = cost[afterNext + 1];
                        int fCost = cost[afterNext + 2];

                        // If first + third > second
                        if (nCost + tCost > anCost + fCost){

                            // Add cost of second and return from function
                            return currentSum + anCost + fCost;
                        }
                    }

                    currentIndex = next;
                } else {
                    currentIndex = afterNext;
                }
                System.out.println(currentIndex);
                currentSum += cost[currentIndex];
            }

            return currentSum;
    }
}
