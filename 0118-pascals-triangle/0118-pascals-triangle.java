class Solution {
static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<>();
    res.add(List.of(1)); // First row

    for (int i = 1; i < numRows; i++) {
        List<Integer> tmp = new ArrayList<>(); // Create a new list for each row
        tmp.add(1); // First element of the row is always 1

        for (int j = 1; j < i; j++) {
            int sum = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
            tmp.add(sum);
        }

        tmp.add(1); // Last element of the row is always 1
        res.add(tmp); // Add the new row to res
    }

    return res;
}
}