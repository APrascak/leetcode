// Group Shifted Strings
// 29 March 2020

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        int n = strings.length;
        
        for (int i = 0; i < n; i++) {
            String word = strings[i];
            String newWord = "";
            if (word.charAt(0) != 'a') {
                int offset = word.charAt(0);
                for (char x : word.toCharArray()) {
                    int temp = x + 'a' - offset;
                    if (x-offset < 0) {
                        temp+=26;
                    }
                    newWord += (char) temp;
                }
            } else {
                newWord = word;
            }
            if (!(map.containsKey(newWord))) {
                map.put(newWord, new ArrayList());
            }
            map.get(newWord).add(word);
            newWord = "";
        }
        return new ArrayList(map.values());
    }
}