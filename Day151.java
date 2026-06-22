// Maximum Area Between Bars

class Solution {
    public int maxArea(List<Integer> height) {
        int left = 0;
        int right = height.size() - 1;
        int maxArea = 0;
        
        while (left < right) {
            // Calculate the number of bars between left and right
            int width = right - left - 1;
            
            // Calculate the current area
            int currentArea = Math.min(height.get(left), height.get(right)) * width;
            
            // Update the maximum area found so far
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer pointing to the smaller height
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}
