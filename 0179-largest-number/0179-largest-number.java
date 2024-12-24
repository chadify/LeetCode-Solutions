class Solution {
    public String largestNumber(int[] nums) {
        mergeSortInPlace(nums, 0, nums.length);
        
        // Check if all numbers are 0
        boolean allZero = true;
        for (int num : nums) {
            if (num != 0) {
                allZero = false;
                break;
            }
        }
        if (allZero) {
            return "0";
        }
        
        // Build the result string
        StringBuilder result = new StringBuilder();
        for (int num : nums) {
            result.append(num);
        }
        return result.toString();
    }
    
    static void mergeSortInPlace(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }
        
        int mid = (s + e) / 2;
        
        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);
        
        mergeInPlace(arr, s, mid, e);
    }
    
    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];
        
        int i = s;
        int j = m;
        int k = 0;
        
        while (i < m && j < e) {
            String num1 = String.valueOf(arr[i]);
            String num2 = String.valueOf(arr[j]);
            // Modified comparison: if compare returns true, num2 should come first
            if (!compare(num1, num2)) {  // Changed condition
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        
        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        
        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }
        
        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }
    }
    
    private static boolean compare(String str1, String str2) {
        String order1 = str1 + str2;
        String order2 = str2 + str1;
        return order1.compareTo(order2) < 0;  // Changed to < for descending order
    }
}