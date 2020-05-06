// Invalid Transactions
// 6 May 2020

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> solution = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String st : transactions) {
            String[] values = st.split(",");
            String name = values[0];
            Integer time = Integer.parseInt(values[1]);
            Integer amount = Integer.parseInt(values[2]);
            String location = values[3];
            if (amount > 1000)
                solution.add(st);
            fraud(solution, map, name, amount, time, location);
            addToMap(map, name, amount, time, location);
        }
        return solution;
    }
    
    private void addToMap(Map<String, List<String>> map, String name,int amount, int time, String location) {
        if (map.containsKey(name)) {
            map.get(name).add(time + "," + amount + "," + location);
        } else {
            List<String> temp = new ArrayList<>();
            temp.add(time + "," + amount + "," + location);
            map.put(name, temp);
        }
    }
    
    private boolean fraud(List<String> solution, Map<String, List<String>> map, String name, int amount, int time, String location) {
        if (!map.containsKey(name)) {
            return false;
        } else {
            List<String> data = map.get(name);
            boolean FLAGGED = false;
            for (String transData : data) {
                String[] x = transData.split(",");
                Integer transTime = Integer.parseInt(x[0]);
                Integer transAmount = Integer.parseInt(x[1]);
                String transLocation = x[2];
                if (Math.abs(time - transTime) <= 60 && !location.equals(transLocation)) {
                    FLAGGED = true;
                    if (!solution.contains(name+","+transTime+","+transAmount+","+transLocation))
                        solution.add(name+","+transTime+","+transAmount+","+transLocation);
                }
            }
            if (FLAGGED && !solution.contains(name+","+time+","+amount+","+location))
                solution.add(name+","+time+","+amount+","+location);
        }
        return true;
    }
}