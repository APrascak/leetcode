// Restore IP Addresses
// 13 May 2020

class Solution {
    List<String> solution;
    public List<String> restoreIpAddresses(String s) {
        solution = new ArrayList<>();
        helper("",s, 0);
        return solution;
    }
    
    private void helper(String curr, String remaining, int count) {
        if (count > 4) {
            return;
        }
        if (count == 4) {
            if (remaining.equals("")) {
                solution.add(curr.substring(1));
            }
            return;
        }
        int i = 1, value = 0;
        while (i <= remaining.length()) {
            if(remaining.substring(0,i).equals("0")) {
                helper(curr+"."+remaining.substring(0,i), remaining.substring(i), count+1);
                break;
            }
            value = Integer.parseInt(remaining.substring(0,i));
            if (value > 255)
                break;
            helper(curr+"."+remaining.substring(0,i), remaining.substring(i), count+1);
            i++;
        }
    }
}