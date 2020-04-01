// Basic Calculator II
// 1 April 2020

class Solution {
    public int calculate(String s) {
        Set<Character> operators = new HashSet<Character>();
        List<String> operations  = new ArrayList<String>();
        int n = s.length();
        
        operators.add('*');
        operators.add('/');
        operators.add('+');
        operators.add('-');
        
        s = s.replaceAll("\\s+", ""); //  Remove whitespace
        n = s.length();
        
        int i = 0;
        while (i < n) {
            Character letter = s.charAt(i);
            if (operators.contains(letter)) {
                String temp = Character.toString(letter);
                operations.add(temp);
                i++;
            } else {
                String temp = "";
                if (i==n) break;
                while (!operators.contains(s.charAt(i))) {
                    temp += Character.toString(s.charAt(i));
                    i++;
                    if (i==n) break;
                }
                operations.add(temp);
            }
        }
        
        i = 0;
        int value = 0;
        while (i < operations.size()) {
            if (operations.get(i).equals("*")) {
                operations.set(i, Integer.toString(Integer.parseInt(operations.get(i-1)) * Integer.parseInt(operations.get(i+1))) );
                operations.remove(i+1);
                operations.remove(i-1);
            } else if (operations.get(i).equals("/")) {
                operations.set(i, Integer.toString(Integer.parseInt(operations.get(i-1)) / Integer.parseInt(operations.get(i+1))) );
                operations.remove(i+1);
                operations.remove(i-1);
            } else {
                i++;
            }
        }
        
        i = 0;
        while (i < operations.size()) {
            if (operations.get(i).equals("+")) {
                operations.set(i, Integer.toString(Integer.parseInt(operations.get(i-1)) + Integer.parseInt(operations.get(i+1))) );
                operations.remove(i+1);
                operations.remove(i-1);
            } else if (operations.get(i).equals("-")) {
                operations.set(i, Integer.toString(Integer.parseInt(operations.get(i-1)) - Integer.parseInt(operations.get(i+1))) );
                operations.remove(i+1);
                operations.remove(i-1);
            } else {
                i++;
            }
        }

        return Integer.parseInt(operations.get(0));
    }
}