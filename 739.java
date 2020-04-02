// Daily Temperatures
// 1 April 2020

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<int[]> s = new Stack<>(); // stored as: [temp, index]
        int n = T.length;
        int index;
        
        for (int i = 0; i<n;i++) {
            if (s.isEmpty()) {
                s.push(new int[]{T[i], i});
                continue;
            }
            while (T[i] > s.peek()[0]) {
                index = s.pop()[1];
                T[index] = i-index;
                if (s.isEmpty()) break;
            }
            s.add(new int[]{T[i], i});
        }
        while (!s.isEmpty()) {
            index = s.pop()[1];
            T[index] = 0;
        }
        return T;
    }
}