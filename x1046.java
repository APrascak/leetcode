// Last Stone Weight
// 12 April 2020

class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pQueue.add(stones[i]);
        }
        while (pQueue.size() > 1) {
            int la = pQueue.poll();
            int sm = pQueue.poll();
            int diff = la - sm;
            if (diff == 0) {
                continue;
            } else {
                pQueue.offer(diff);
            }
        }
        if (pQueue.isEmpty()) return 0;
        return pQueue.poll();
    }
}