#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<set>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

/*
 *  Leetcode 475
 */
class Solution {
public:

    int get_first_greater(const std::vector<int>& v, int x)
    {
        int first = 0, last = int(v.size()) - 1;
        while (first <= last)
        {
            int mid = (first + last) / 2;
            if (v[mid] > x)
                last = mid - 1;
            else
                first = mid + 1;
        }
        return last + 1 == v.size() ? -1 : last + 1;
    }

    int get_last_smaller(const std::vector<int>& v, int x)
    {
        int first = 0, last = int(v.size()) - 1;
        while (first <= last)
        {
            int mid = (first + last) / 2;
            if (v[mid] >= x)
                last = mid - 1;
            else
                first = mid + 1;
        }
        return first - 1 < 0 ? -1 : first - 1;
    }

    int findRadius(vector<int>& houses, vector<int>& heaters) {
        std::sort(heaters.begin(), heaters.end());
        int ans = 0;
        for (int i = 0; i < houses.size(); i++) {
            //std::cou
            int left = get_last_smaller(heaters, houses[i]);
            int right = get_first_greater(heaters, houses[i]);
            for (int j = 0; j < heaters.size(); j++) {
                if (heaters[j] >= houses[i]) {
                    right = min(right, j);
                }
                if (heaters[j] <= houses[i]) {
                    left = max(left, j);
                }
            }
//            std::cout << houses[i] << " " << left << " " << right << std::endl;
            int radius = 2147483647;
            if (left != -1) {
                radius = min(radius, houses[i] - heaters[left]);
            }
            if (right != -1) {
                radius = min(radius, heaters[right] - houses[i]);
            }
//            std::cout << radius << std::endl << std::endl;
            ans = max(ans, radius);
        }
        return ans;
    }
};

int main() {
    Solution s;
    vector<int> houses;
    houses.push_back(1);
    houses.push_back(2);
    houses.push_back(3);
    houses.push_back(4);
    vector<int> heaters;
    heaters.push_back(1);
    heaters.push_back(4);
//    heaters.push_back(8);
    std::cout << s.findRadius(houses, heaters) << std::endl;
}