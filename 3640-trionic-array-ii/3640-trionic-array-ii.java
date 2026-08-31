class Solution {
    public long maxSumTrionic(int[] nums) {

        int n = nums.length;

        long inc1 = Long.MIN_VALUE;
        long dec = Long.MIN_VALUE;
        long inc2 = Long.MIN_VALUE;

        long ans = Long.MIN_VALUE;

        for (int i = 1; i < n; i++) {

            long newInc1 = Long.MIN_VALUE;
            long newDec = Long.MIN_VALUE;
            long newInc2 = Long.MIN_VALUE;

            if (nums[i] > nums[i - 1]) {

                // Continue first increasing phase
                if (inc1 != Long.MIN_VALUE) {
                    newInc1 = Math.max(
                        newInc1,
                        inc1 + nums[i]
                    );
                }

                // Start first increasing phase
                newInc1 = Math.max(
                    newInc1,
                    (long) nums[i - 1] + nums[i]
                );

                // Continue third increasing phase
                if (inc2 != Long.MIN_VALUE) {
                    newInc2 = Math.max(
                        newInc2,
                        inc2 + nums[i]
                    );
                }

                // Start third increasing phase
                if (dec != Long.MIN_VALUE) {
                    newInc2 = Math.max(
                        newInc2,
                        dec + nums[i]
                    );
                }

            } else if (nums[i] < nums[i - 1]) {

                // Continue decreasing phase
                if (dec != Long.MIN_VALUE) {
                    newDec = Math.max(
                        newDec,
                        dec + nums[i]
                    );
                }

                // Start decreasing phase from first increasing phase
                if (inc1 != Long.MIN_VALUE) {
                    newDec = Math.max(
                        newDec,
                        inc1 + nums[i]
                    );
                }
            }

            inc1 = newInc1;
            dec = newDec;
            inc2 = newInc2;

            ans = Math.max(ans, inc2);
        }

        return ans;
    }
}