class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        int sum = 0;
        vector<int> remain1, remain2;

        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) remain1.push_back(num);
            else if (num % 3 == 2) remain2.push_back(num);
        }

        if (sum % 3 == 0) return sum;

        sort(begin(remain1), end(remain1));
        sort(begin(remain2), end(remain2));

        int rem = sum % 3;
        int removeVal = INT_MAX;

        // Case when sum % 3 == 1
        if (rem == 1) {
            if (remain1.size() >= 1) 
                removeVal = min(removeVal, remain1[0]);
            if (remain2.size() >= 2) 
                removeVal = min(removeVal, remain2[0] + remain2[1]);
        }

        // Case when sum % 3 == 2
        else {  
            if (remain2.size() >= 1) 
                removeVal = min(removeVal, remain2[0]);
            if (remain1.size() >= 2) 
                removeVal = min(removeVal, remain1[0] + remain1[1]);
        }

        return (removeVal == INT_MAX) ? 0 : sum - removeVal;
    }
};
