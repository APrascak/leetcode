// Check If a Word Occurs As a Prefix of Any Word in a Sentence
// 24 May 2020

// O(n) time and space
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.indexOf(searchWord) == 0)
                return i+1;
        }
        return -1;
    }
}