// Substrings with more 1's than 0's

class Solution {
public:
    int countSubstring(string& s) {
        int n = s.length();
        vector<int> bit(2 * n + 2, 0);
        
        auto update = [&](int idx, int val) {
            for (; idx <= 2 * n + 1; idx += idx & -idx)
                bit[idx] += val;
        };
        
        auto query = [&](int idx) {
            int sum = 0;
            for (; idx > 0; idx -= idx & -idx)
                sum += bit[idx];
            return sum;
        };
        
        long long ans = 0;
        int curr_sum = 0;
        
        update(0 + n + 1, 1);
        
        for (int i = 0; i < n; i++) {
            curr_sum += (s[i] == '1') ? 1 : -1;
            ans += query(curr_sum + n);
            update(curr_sum + n + 1, 1);
        }
        
        return ans;
    }
};
