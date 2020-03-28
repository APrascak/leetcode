// Minimum Index Sum of Two Lists
// 28 March 2020

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap <String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i <list1.length; i++) {
            map.put(list1[i],(i+1) * -1);
        }
        for (int i = 0; i <list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int indexSum = ((map.get(list2[i])+1) * -1) + i;
                map.put(list2[i], indexSum);
            }
        }
        int least = list1.length + list2.length;
        int count = 0;
        for (String key : map.keySet()) {
            if (map.get(key) > -1) {
                if (map.get(key) == least) {
                    count++;
                }
                if (map.get(key) < least) {
                    System.out.println(key + " " + map.get(key));
                    least = map.get(key);
                    count = 1;
                }
            }
        }
        String[] solution = new String[count];
        int i = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == least) {
                solution[i] = key;
                i++;
            }
        }
        return solution;
    }
}