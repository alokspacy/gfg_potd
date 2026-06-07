// Finding Profession

class Solution {
    public String profession(int level, int pos) {
        // Count number of set bits in (pos-1)
        int flips = Integer.bitCount(pos - 1);
        
        // If flips is even → Engineer, else Doctor
        return (flips % 2 == 0) ? "Engineer" : "Doctor";
    }
}
