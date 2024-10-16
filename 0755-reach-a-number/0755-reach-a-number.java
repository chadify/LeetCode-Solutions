class Solution {
    public int reachNumber(int target) {

        if (target < 0)
            target = -target;

        int pos = 0;
        int i = 1;

        while(true) {
            pos += i++;

            if (pos == target)
                return i-1;
            else if (pos > target && (pos - target)%2 == 0)
                return i-1;
        }
    }
}