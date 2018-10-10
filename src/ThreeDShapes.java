public class ThreeDShapes {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2},
                {3, 4}
        };
        int[][] array1 = new int[][]{
                {1, 4},
                {1, 1}
        };
        System.out.println(projectionArea(array1));
    }

    public static int projectionArea(int[][] grid) {
        int bottomCounter = 0;
        int sideCounter = 0;
        int backCounter = 0;

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > sideCounter) {
//                    if (i != j) { doesn't help


                        sideCounter = grid[i][j];
//                    }
                }
                if (grid[j][i] > backCounter) {
                    backCounter = grid[j][i];
                }
                if (grid[i][j] != 0) {
                    bottomCounter++;
                }
            }
            sum = sum + sideCounter + backCounter;

        }
        return sum + bottomCounter;
    }
}
