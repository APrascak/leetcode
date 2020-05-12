// Text Justification
// 12 May 2020

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> solution = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (int i = words.length-1; i >= 0; i--) {
            stack.push(words[i]);
        }
        while (!stack.isEmpty()) {
            int len = 0;
            Queue<String> queue = new LinkedList();
            while (!stack.isEmpty() && len + stack.peek().length() <= maxWidth) {
                len += stack.peek().length();
                queue.offer(stack.pop());
                len++;
            }
            if (stack.isEmpty()) {
                String line = "";
                while (!queue.isEmpty()) {
                    line += queue.poll();
                    if (line.length() < maxWidth)
                        line += " ";
                }
                while (line.length() < maxWidth)
                    line += " ";
                solution.add(line);
                return solution;
            }
            if (queue.size() == 1) {
                String line = queue.poll();
                while (line.length() < maxWidth) {
                    line+=" ";
                }
                solution.add(line);
                continue;
            }
            int spaces = maxWidth - (len-queue.size());
            int spacesPerWord = spaces / (queue.size()-1);
            int extraSpaces = spaces % (queue.size()-1);
            String line = "";
            while (!queue.isEmpty()) {
                String word = queue.poll();
                line += word;
                if (queue.isEmpty()) continue;
                for (int i = 0; i < spacesPerWord; i++)
                    line += " ";
                if (extraSpaces > 0) {
                    line += " ";
                    extraSpaces--;
                }
            }
            solution.add(line);
        }
        return solution;
    }
}