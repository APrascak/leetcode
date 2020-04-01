// Walls and Gates
// 31 March 2020

class Solution {
    public void wallsAndGates(int[][] rooms) {
        List<Integer[]> gates = new ArrayList<>();
        
        // Find gates
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    gates.add(new Integer[]{i, j});
                }
            }
        }

        
        // Print gates
        // for (int i = 0; i < gates.size(); i++) {
        //     System.out.println(gates.get(i)[0] + " : " + gates.get(i)[1]);
        // }
        
        Queue<Integer[]> queue;
        Set<String> seen = new HashSet<String>();
        int dist = 0;
        for (int i = 0; i < gates.size(); i++) {
            seen = new HashSet<String>();
            queue = new LinkedList();
            int x = gates.get(i)[0];
            int y = gates.get(i)[1];
            dist = 1;
            if (x-1 >= 0) {
                if (rooms[x-1][y] != -1 && rooms[x-1][y] != 0) {
                    queue.offer(new Integer[]{x-1, y});
                    rooms[x-1][y] = Math.min(rooms[x-1][y], dist);
                    seen.add(Integer.toString(x-1) + "," + Integer.toString(y));
                }
            }
            if (x+1 < rooms.length) {
                if (rooms[x+1][y] != -1 && rooms[x+1][y] != 0) {
                    queue.offer(new Integer[]{x+1, y});
                    rooms[x+1][y] = Math.min(rooms[x+1][y], dist);
                    seen.add(Integer.toString(x+1) + "," + Integer.toString(y));
                }
            }
            if (y-1 >= 0) {
                if (rooms[x][y-1] != -1 && rooms[x][y-1] != 0) {
                    queue.offer(new Integer[]{x, y-1});
                    rooms[x][y-1] = Math.min(rooms[x][y-1], dist);
                    seen.add(Integer.toString(x) + "," + Integer.toString(y-1));
                }
            }
            if (y+1 < rooms[x].length) {
                if (rooms[x][y+1] != -1 && rooms[x][y+1] != 0) {
                    queue.offer(new Integer[]{x, y+1});
                    rooms[x][y+1] = Math.min(rooms[x][y+1], dist);
                    seen.add(Integer.toString(x) + "," + Integer.toString(y+1));
                }
            }
            
            while (!queue.isEmpty()) {
                int size = queue.size();
                dist++;
                // System.out.println("DIST: " + dist);
                for (int j =0; j < size; j++) {
                    Integer[] coords = queue.poll();
                    // System.out.println(coords[0] + " : " + coords[1]);
                    x = coords[0];
                    y = coords[1];
                    if (x-1 >= 0) {
                        if (rooms[x-1][y] != -1 && rooms[x-1][y] != 0) {
                            if (!seen.contains(Integer.toString(x-1) + "," + Integer.toString(y))) {
                                queue.offer(new Integer[]{x-1, y});
                                seen.add(Integer.toString(x-1) + "," + Integer.toString(y));
                            }
                            rooms[x-1][y] = Math.min(rooms[x-1][y], dist);
                        }
                    }
                    if (x+1 < rooms.length) {
                        if (rooms[x+1][y] != -1 && rooms[x+1][y] != 0) {
                            if (!seen.contains(Integer.toString(x+1) + "," + Integer.toString(y))) {
                                queue.offer(new Integer[]{x+1, y});
                                seen.add(Integer.toString(x+1) + "," + Integer.toString(y));
                            }
                            rooms[x+1][y] = Math.min(rooms[x+1][y], dist);
                        }
                    }
                    if (y-1 >= 0) {
                        if (rooms[x][y-1] != -1 && rooms[x][y-1] != 0) {
                            if (!seen.contains(Integer.toString(x) + "," + Integer.toString(y-1))) {
                                queue.offer(new Integer[]{x, y-1});
                                seen.add(Integer.toString(x) + "," + Integer.toString(y-1));
                            }
                            rooms[x][y-1] = Math.min(rooms[x][y-1], dist);
                        }
                    }
                    if (y+1 < rooms[x].length) {
                        if (rooms[x][y+1] != -1 && rooms[x][y+1] != 0) {
                            if (!seen.contains(Integer.toString(x) + "," + Integer.toString(y+1))) {
                                queue.offer(new Integer[]{x, y+1});
                                seen.add(Integer.toString(x) + "," + Integer.toString(y+1));
                            }
                            rooms[x][y+1] = Math.min(rooms[x][y+1], dist);
                        }
                    }
                }    
                // for (String key : seen) {
                    // System.out.println(key);
                // }
                // for (int j = 0; j < rooms.length; j++) {
                //     for (int k = 0; k < rooms[j].length; k++) {
                //         System.out.print(rooms[j][k] + " ");
                //     }
                //     System.out.println();
                // }
            }
            
            
            // System.out.println("Queue for gate: " + i);
            // for (int j = 0; j < rooms.length; j++) {
            //     for (int k = 0; k < rooms[j].length; k++) {
            //         System.out.print(rooms[j][k] + " ");
            //     }
            //     System.out.println();
            // }
            // while (queue.isEmpty() == false) {
            //     Integer[] coords = queue.poll();
            //     System.out.println(coords[0] + " : " + coords[1]);
            // }
        }
        // System.out.println(Arrays.deepToString(rooms).replace("], ", "]\n"));
    }
}