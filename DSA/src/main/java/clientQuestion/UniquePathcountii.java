package clientQuestion;

public class UniquePathcountii {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        // if first and last has obstacle that mean 0 path
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1)
            return 0;
        int[][] path = new int[row][col];

        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                path[0][i] = 1;
            }
        }
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                path[i][0] = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    path[i][j] = 0;
                } else {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                }
            }
        }
        return path[row - 1][col - 1];

    }

    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }
}
