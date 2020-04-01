// Count and Say
// 1 April 2020

class Solution {
    public String countAndSay(int n) {
        String first = "1";
        return findSolution(first,1,n);
    }
    public String findSolution(String str, int level, int max) {
        if (level == max) {
            return str;
        }
        int i = 0;
        int n = str.length();
        List<String> values = new ArrayList<String>();
        Character ch;
        while (i < n) {
            ch = str.charAt(i);
            int count = 1;
            i++;
            if (i==n) {
                values.add("1");
                values.add(Character.toString(ch));
                break;
            }
            while (str.charAt(i)==ch) {
                count++;
                i++;
                if (i==n) break;
            }
            values.add(Integer.toString(count));
            values.add(Character.toString(ch));
        }
        String thisLevel = "";
        for (String term : values) {
            thisLevel += term;
        }
        return findSolution(thisLevel, level+1, max);
    }
}