class Solution {
    public void setZeroes(int[][] matrix) {

        int[][] res = new int[matrix.length][matrix[0].length];

        //copy matrix to another matrix res
        for (int i = 0; i < res.length; i++)
            for (int j = 0; j < res[0].length; j++)
                res[i][j] = matrix[i][j];


        for (int row = 0; row < res.length; row++) {
            for (int col = 0; col < res[0].length; col++) {
                if (res[row][col] == 0) {
                    for (int i = 0; i < matrix[0].length; i++)
                        matrix[row][i] = 0;

                    for (int i = 0; i < matrix.length; i++)
                        matrix[i][col] = 0;
                }
            }
        }
    }
}