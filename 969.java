// Pancake Sorting
// 22 April 2020

class Solution {
    public List<Integer> pancakeSort(int[] A) {
        int n = A.length;
        List<Integer> solution = new ArrayList<>();
        
        if (n == 1 || n == 0) return solution;
        
        int k = 0;
        while (A[k] < A[k+1]) {
            k++;
            if (k == n-1) return solution;
        }
        
        int curr = 1;
        // printArray(A);
        while (curr < n) {
            for (int i = 0; i < n; i++) {
                if (A[i] == curr) {
                    if (i == 0) {
                        curr++;
                        break;
                    }
                    A = flip(A, i);
                    // printArray(A);
                    A = flip(A, i+1);
                    // printArray(A);
                    solution.add(i);
                    solution.add(i+1);
                    curr++;
                    break;
                }
            }
        }
        flip(A, n-1);
        solution.add(n-1);
        // printArray(A);
        return solution;
    }
    
    public int[] flip(int[] arr, int k) {
        int a = 0;
        int b = k-1;
        while (a < b) {
            int ref = arr[a];
            arr[a] = arr[b];
            arr[b] = ref;
            a++;
            b--;
        }
        return arr;
    }
    
    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}