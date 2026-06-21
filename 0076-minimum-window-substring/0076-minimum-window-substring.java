class Solution {
    public String minWindow(String s, String t) {
        int have = 0;
        Map<Character, Integer> mapRequired = new HashMap<>();
        Map<Character, Integer> mapHaves = new HashMap<>();

        // store t's chars into hashmap
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            mapRequired.put(c, mapRequired.getOrDefault(c, 0) + 1);
        }

        int required = mapRequired.size();

        int l = 0;
        int r = 0;
        int res = Integer.MAX_VALUE;
        String resString = "";

        while (r < s.length()) {
            char rc = s.charAt(r);

            mapHaves.put(rc, mapHaves.getOrDefault(rc, 0) + 1);

            // Requirement for this character just got satisfied
            if (mapRequired.containsKey(rc) &&
                mapHaves.get(rc).intValue() == mapRequired.get(rc).intValue()) {
                have++;
            }

            // shrink window
            while (have == required) {
                if ((r - l + 1) < res) {
                    res = r - l + 1;
                    resString = s.substring(l, r + 1);
                }

                char lc = s.charAt(l);

                mapHaves.put(lc, mapHaves.get(lc) - 1);

                if (mapRequired.containsKey(lc) &&
                    mapHaves.get(lc) < mapRequired.get(lc)) {
                    have--;
                }

                l++;
            }

            r++;
        }

        return resString;
    }
}