// Most Common Word
// 26 May 2020

// O(m+n) time, O(m+n) space
// m = len of paragraph
// n = # of banned words
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        for (String word : banned)
            bannedWords.add(word);
        String[] words = paragraph.split("\\W+");
        int max = 0;
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            String word = str.toLowerCase();
            if (!bannedWords.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
                max = Math.max(max, map.get(word));
                if (max == map.get(word))
                    answer = word;
            }
        }
        return answer;
    }
}