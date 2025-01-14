class Solution {
    private StringBuilder sb = new StringBuilder();
    private List<Integer> numbers = new ArrayList<>();
    public String getPermutation(int n, int k) {
        for(int i=1; i<=n; i++){
            numbers.add(i);
        }
        return helper(n, k-1);
    }

    private String helper(int n, int k) {
        if (n == 0)
            return sb.toString();

        int factorial = getFactorial(n-1);

        int index = k/factorial;

        //append corresponding numb from index to string
        sb.append(String.valueOf(numbers.get(index)));
        numbers.remove(index);

        return helper(n - 1, k - (index * factorial));
    }

    private int getFactorial(int n) {
        if (n == 0 || n == 1)
            return 1;

        int factorial = 1;
        for(int i=1; i<=n; i++){
            factorial *= i;
        }

        return factorial;
    }
}