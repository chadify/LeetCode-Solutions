class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = mergeSort(heights, 0, heights.length - 1);

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i])
                res++;
        }

        return res;
    }

    private int[] mergeSort(int[] array, int s, int e) {
        if (s == e) { // Base case: single element
            return new int[]{array[s]};
        }
        int m = s + (e - s) / 2;
        int[] left = mergeSort(array, s, m);
        int[] right = mergeSort(array, m + 1, e);

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j])
                res[k++] = left[i++];
            else
                res[k++] = right[j++];
        }

        while (i < left.length) res[k++] = left[i++];
        while (j < right.length) res[k++] = right[j++];
        return res;
    }
}