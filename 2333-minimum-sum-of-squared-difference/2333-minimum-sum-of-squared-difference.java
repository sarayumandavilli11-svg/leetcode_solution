import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long operations = (long) k1 + k2;
        long[] diff = new long[nums1.length];

        long total = 0;
        long max = 0;

        for (int i = 0; i < nums1.length; i++) {
            diff[i] = Math.abs((long) nums1[i] - nums2[i]);
            total += diff[i];
            max = Math.max(max, diff[i]);
        }

        if (operations >= total) {
            return 0;
        }

        long left = 0, right = max;

        while (left < right) {
            long mid = left + (right - left) / 2;
            long needed = 0;

            for (long d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= operations) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        long remaining = operations;

        for (int i = 0; i < diff.length; i++) {
            if (diff[i] > left) {
                remaining -= diff[i] - left;
                diff[i] = left;
            }
        }

        long answer = 0;

        for (long d : diff) {
            answer += d * d;
        }

        for (int i = 0; i < diff.length && remaining > 0; i++) {
            if (diff[i] == left && left > 0) {
                answer -= 2 * left - 1;
                remaining--;
            }
        }

        return answer;
    }
}