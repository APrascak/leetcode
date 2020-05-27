// Employee Importance
// 27 May 2020

// O(n) time, O(n) space
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Queue<Employee> queue = new LinkedList();
        Map<Integer, Employee> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (Employee worker : employees) {
            map.put(worker.id, worker);
            if (worker.id == id)
                queue.offer(worker);
        }
        int importance = 0;
        while (!queue.isEmpty()) {
            Employee current = queue.poll();
            importance += current.importance;
            set.add(current.id);
            for (Integer x: current.subordinates) {
                if (!set.contains(x))
                    queue.offer(map.get(x));
            }
        }
        return importance;
    }
}

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/