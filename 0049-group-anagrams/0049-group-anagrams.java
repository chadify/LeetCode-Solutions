class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            StringBuilder count = new StringBuilder();
            count.append("0".repeat(26)); 
            for (char c: s.toCharArray()) {
                int index = (int)c - (int)'a';
                int value = count.charAt(index) - '0';
                value++;
                count.setCharAt(index, (char)('0' + value));
            }
            if (map.containsKey(count.toString())) {
                map.get(count.toString()).add(s);
            } 
            else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                map.put(count.toString(), newList);
            }
        }
        return new ArrayList<>(map.values());
    }
}