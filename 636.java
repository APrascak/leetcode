// Exclusive Time of Functions
// 12 May 2020

// O(n) time and space where n = # of logs
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] exclusiveTime = new int[n];
        Stack<Integer> processIDs = new Stack<>();
        List<int[]> currentProcess = new ArrayList<>();
        int sum = 0;
        
        for (String str : logs) {
            String[] log = str.split(":");
            int id = Integer.parseInt(log[0]);
            String action = log[1];
            int timestamp = Integer.parseInt(log[2]);
            if (action.equals("start")) {
                if (!processIDs.isEmpty())
                    currentProcess.add(new int[]{processIDs.peek(), timestamp-sum});
                sum = timestamp;
                processIDs.push(id);
            } else {
                int size = currentProcess.size();
                currentProcess.add(new int[]{processIDs.peek(), timestamp-sum+1});
                sum = timestamp+1;
                processIDs.pop();
            }
        }
        
        for (int[] log : currentProcess) {
            exclusiveTime[log[0]] += log[1];
        }
        
        return exclusiveTime;
    }
}
