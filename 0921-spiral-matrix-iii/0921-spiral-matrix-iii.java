class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int[][] res = new int[rows * cols][2];
        int i, col_pos, row_pos, count;
        i = 1;
        row_pos = rStart;
        col_pos = cStart;
        count = 0;

        while (count < rows * cols) {                    //right
            for (; col_pos <= cStart + i && count < rows * cols; col_pos++) {
                if (col_pos < cols && col_pos >= 0 && row_pos < rows && row_pos >= 0) {
                    res[count][0] = row_pos;
                    res[count][1] = col_pos;
                    count++;
                }
            }

            row_pos++;
            col_pos--;

            for (; row_pos <= rStart + i && count < rows * cols; row_pos++) {      //down
                if (col_pos < cols && col_pos >= 0 && row_pos < rows && row_pos >= 0) {
                    res[count][0] = row_pos;
                    res[count][1] = col_pos;
                    count++;
                }
            }

            row_pos--;
            col_pos--;

            for (; col_pos >= cStart - i && count < rows * cols; col_pos--) {      //left
                if (col_pos < cols && col_pos >= 0 && row_pos < rows && row_pos >= 0) {
                    res[count][0] = row_pos;
                    res[count][1] = col_pos;
                    count++;
                }
            }

            row_pos--;
            col_pos++;

            for (; row_pos >= rStart - i && count < rows * cols; row_pos--) {      //up
                if (col_pos < cols && col_pos >= 0 && row_pos < rows && row_pos >= 0) {
                    res[count][0] = row_pos;
                    res[count][1] = col_pos;
                    count++;
                }
            }

            row_pos++;
            col_pos++;

            i++;
        }

    return res;
        
    }
}