// Subdomain Visit Count
// 27 May 2020

// O(n) time, O(n) space
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] str = domain.split("\\W+");
            int count = Integer.parseInt(str[0]);
            String curr = str[str.length-1];
            map.put(curr, map.getOrDefault(curr,0) + count);
            for (int i = str.length-2; i > 0; i--) {
                curr = str[i]+"."+curr;
                map.put(curr, map.getOrDefault(curr,0) + count);
            }
        }
        List<String> solution = new ArrayList<>();
        for (String domain : map.keySet()) {
            solution.add(map.get(domain) + " " + domain);
        }
        return solution;
    }
}