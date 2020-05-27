// Reverse Only Letters
// 27 May 2020

// O(n) time, O(1) space
class Solution {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int l = 0, r = chars.length-1;
        while (l < r) {
            while (l < r && !Character.isAlphabetic(chars[l]))
                l++;
            while (r > l && !Character.isAlphabetic(chars[r]))
                r--;
            if (l >= r)
                break;
            char ref = chars[l];
            chars[l] = chars[r];
            chars[r] = ref;
            l++;
            r--;
        }
        return String.valueOf(chars);
    }
}