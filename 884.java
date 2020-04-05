// Uncommon Words from Two Sentences
// 5 April 2020

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        
        String[] a = A.split(" ");
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        
        String[] b = B.split(" ");
        for (int j = 0; j < b.length; j++) {
            map.put(b[j], map.getOrDefault(b[j], 0) + 1);
        }
        
        List<String> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                ans.add(key);
            }
        }

        return ans.toArray(new String[ans.size()]);
    }
}