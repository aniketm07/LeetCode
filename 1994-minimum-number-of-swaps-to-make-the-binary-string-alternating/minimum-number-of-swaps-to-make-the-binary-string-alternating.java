class Solution {
    public int minSwaps(String s) {
        if (s == null || s.isEmpty()) {
            return -1; // Invalid input
        }

        int n = s.length();
        int count0 = 0; // Count of '0's
        int count1 = 0; // Count of '1's

        // Count the number of '0's and '1's
        for (char c : s.toCharArray()) {
            if (c == '0') {
                count0++;
            } else if (c == '1') {
                count1++;
            }
        }

        // Check if it's possible to form an alternating string
        if (Math.abs(count0 - count1) > 1) {
            return -1; // Impossible to make the string alternating
        }

        // Check swaps for both patterns
        int swaps1 = 0; // Starting with '1' (pattern: 1010...)
        int swaps0 = 0; // Starting with '0' (pattern: 0101...)

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) { // Even index
                if (s.charAt(i) != '1') {
                    swaps1++; // Needs to be '1'
                }
                if (s.charAt(i) != '0') {
                    swaps0++; // Needs to be '0'
                }
            } else { // Odd index
                if (s.charAt(i) != '0') {
                    swaps1++; // Needs to be '0'
                }
                if (s.charAt(i) != '1') {
                    swaps0++; // Needs to be '1'
                }
            }
        }

        // Calculate the minimum swaps for the valid pattern
        if (count0 > count1) {
            return swaps0 / 2; // Only pattern "0101..." is possible
        } else if (count1 > count0) {
            return swaps1 / 2; // Only pattern "1010..." is possible
        } else {
            return Math.min(swaps0, swaps1) / 2; // Both patterns are possible
        }
    }
}