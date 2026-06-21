// Choose and Swap

import java.util.TreeSet;

class Solution {
    public String chooseSwap(String s) {
        // Step 1: Store all unique characters in a sorted set (TreeSet maintains alphabetical order)
        TreeSet<Character> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        char charToReplace = ' ';
        char smallestAvailable = ' ';
        boolean found = false;

        // Step 2: Traverse the string to find the first character that can be minimized
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            // Remove the current character from the set so we don't compare it with itself
            set.remove(currentChar);

            // If the set is not empty, the first element is the smallest available remaining character
            if (!set.isEmpty()) {
                char smallestRemaining = set.first();

                // If the smallest remaining character is smaller than the current character,
                // we found our swap pair!
                if (smallestRemaining < currentChar) {
                    charToReplace = currentChar;
                    smallestAvailable = smallestRemaining;
                    found = true;
                    break;
                }
            }
        }

        // Step 3: If a valid swap is found, modify the string
        if (found) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == charToReplace) {
                    sb.append(smallestAvailable);
                } else if (ch == smallestAvailable) {
                    sb.append(charToReplace);
                } else {
                    sb.append(ch);
                }
            }
            return sb.toString();
        }

        // If no swap can make it smaller, return the original string
        return s;
    }
}
