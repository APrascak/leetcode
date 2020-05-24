// Maximum Number of Vowels in a Substring of Given Length
// 24 May 2020

// O(n) time and O(1) space
class Solution {
    Set<Character> vowels;
    public int maxVowels(String s, int k) {
        vowels = initializeVowels();
        int count = 0, max = 0;
        for (int i = 0; i < k; i++) {
            count += vowel(s.charAt(i));
        }
        max = Math.max(count, count);
        for (int i = k; i < s.length(); i++) {
            count += vowel(s.charAt(i));
            count -= vowel(s.charAt(i-k));
            max = Math.max(max, count);
        }
        return max;
    }
    
    private int vowel(Character ch) {
        if (vowels.contains(ch))
            return 1;
        return 0;
    }
    
    private Set<Character> initializeVowels() {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        return set;       
    }
}