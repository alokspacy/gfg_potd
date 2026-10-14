// Roll Characters of String

class Solution {

    public String findRollOut(String s, int[] roll) {

        int n = s.length();

        int[] count = new int[n];

 

        // Count how many times each position is affected

        for (int r : roll) {

            count[r - 1]++;

        }

 

        // Calculate suffix sums

        for (int i = n - 2; i >= 0; i--) {

            count[i] += count[i + 1];

        }

 

        StringBuilder result = new StringBuilder();

 

        for (int i = 0; i < n; i++) {

            int shift = count[i] % 26;

            char ch = (char) ('a' + (s.charAt(i) - 'a' + shift) % 26);

            result.append(ch);

        }

 

        

    }

}
