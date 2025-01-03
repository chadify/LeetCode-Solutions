class Solution {
    static HashMap<Integer, String> map = new HashMap<>();
    public char findKthBit(int n, int k) {
        // find the nth string
        // find the kth bit in nth string
        // hashmap from index to string

        String res = nthString(n);
        return res.charAt(k-1);
    }

    private static String nthString(int n) {
        if (n == 1)
            return "0";
        if (map.containsKey(n))
            return map.get(n);
        StringBuilder stringPrev = new StringBuilder(nthString(n-1));
        StringBuilder stringInvert = new StringBuilder();
        // Iterate through each character and invert it
        for (int i = 0; i < stringPrev.length(); i++) {
            char c = stringPrev.charAt(i);
            stringInvert.append(c == '0' ? '1' : '0'); // Invert 0 to 1, 1 to 0
        }
        map.put(n, stringPrev + "1" + stringInvert.reverse().toString());
        return map.get(n);
    }
}