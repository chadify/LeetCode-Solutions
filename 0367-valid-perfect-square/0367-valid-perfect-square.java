class Solution {
    public boolean isPerfectSquare(int num) {


       int start = 0;
       int end = num;

        
        while (start <= end) {
            int mid = (start + end)/2;

            if ((long)mid*mid < num)
                start = mid + 1;
            else if ((long)mid*mid == num)
                return true;
            else
                end = mid - 1;
            
        }

        return false;

    }
}