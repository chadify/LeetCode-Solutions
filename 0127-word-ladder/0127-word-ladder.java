import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList); // Use Set for fast lookup

        if (!wordSet.contains(endWord)) return 0; // If endWord is not in wordList, no path

        q.offer(new Pair<>(beginWord, 1));
        wordSet.remove(beginWord);

        while (!q.isEmpty()) {
            Pair<String, Integer> current = q.poll();
            String word = current.getKey();      // getKey() from Pair
            int length = current.getValue();     // getValue() from Pair

            if (word.equals(endWord)) {
                return length;
            }

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String replacedWord = new String(wordArray);

                    if (wordSet.contains(replacedWord)) {
                        wordSet.remove(replacedWord);
                        q.offer(new Pair<>(replacedWord, length + 1));
                    }
                }
            }
        }

        return 0; // If no transformation is found
    }

    // Simple Pair class if not using javafx or javafx.util.Pair
    class Pair<K, V> {
        private K key;
        private V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() { return key; }
        public V getValue() { return value; }
    }
}