//this one works correctly and was approved by leetcode
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] array = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(array));
    }

    public static int maxArea(int[] height) {

        //field to store biggest calculated number
        int biggestArea = 0;

        //we will compare and store min number from two points at the array, to get right water level
        int minLevel;
        for (int i = 0; i<height.length; i++){
            for (int j = 0; j<height.length; j++){
                if(j == i){
                    continue;
                }
                minLevel = Math.min(height[i], height[j]);
                int currentArea = minLevel * (j-i);

                if(currentArea>biggestArea){
                    biggestArea = currentArea;
                }
            }
        }


        return biggestArea;
    }
}
