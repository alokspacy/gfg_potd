// Maximum Subset XOR

class Solution {
    public int maxSubsetXOR(int[] arr) {
        int[] basis = new int[32];

        // Build the linear basis
        for (int num : arr) {
            for (int i = 31; i >= 0; i--) {
                if ((num & (1 << i)) == 0) continue;

                if (basis[i] == 0) {
                    basis[i] = num;
                    break;
                }
                num ^= basis[i];
            }
        }

        // Greedily maximize XOR value from highest to lowest bit
        int max_xor = 0;
        for (int i = 31; i >= 0; i--) {
            if ((max_xor ^ basis[i]) > max_xor) {
                max_xor ^= basis[i];
            }
        }

        return max_xor;
    }
}
