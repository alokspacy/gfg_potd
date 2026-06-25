// N-Digit Numbers with Increasing Digits

import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Impossible to have strictly increasing sequence longer than 10
        if (n > 10) return result;
        
        // Edge case for n = 1
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                result.add(i);
            }
            return result;
        }
        
        // Start recursion: 
        // n: length remaining, 
        // 1: starting digit (cannot be 0 for n > 1),
        // 0: current number being built
        backtrack(n, 1, 0, result);
        return result;
    }
    
    private static void backtrack(int n, int startDigit, int currentNum, ArrayList<Integer> result) {
        if (n == 0) {
            result.add(currentNum);
            return;
        }
        
        for (int i = startDigit; i <= 9; i++) {
            backtrack(n - 1, i + 1, currentNum * 10 + i, result);
        }
    }
}
