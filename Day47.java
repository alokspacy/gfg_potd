// Largest number in one swap

class Solution {
    public String largestSwap(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int[] lastPos = new int[10];
        for (int i = 0; i < n; i++) {
            lastPos[arr[i] - '0'] = i;
        }

        for (int i = 0; i < n; i++) {
            int current = arr[i] - '0';
            // Check digits larger than current
            for (int d = 9; d > current; d--) {
                if (lastPos[d] > i) {
                    char temp = arr[i];
                    arr[i] = arr[lastPos[d]];
                    arr[lastPos[d]] = temp;
                    return new String(arr);
                }
            }
        }
        return s;
    }
}
