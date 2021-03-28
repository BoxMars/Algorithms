package dev.boxz;

public class MaximumSubarray {

    /**
     * @see <a href="https://leetcode-cn.com/problems/maximum-subarray/">MaximumSubarray</a>
     * @param nums an array
     * @return
     */
    public static int SolutionOne(int[] nums){
        int len=nums.length;
        int[][] dp=new int[len][len];

        for (int l=0;l<len;l++){
            for (int i=0;i+l<len;i++){
                if (l==0){
                    dp[i][i+l]=nums[i];
                }
                else {
                    dp[i][i+l]=dp[i][i+l-1]+nums[i+l];
                }
            }
        }
        int max=nums[0];
        for (int i=0;i<len;i++){
            for (int j=i;j<len;j++){
                max=Math.max (max,dp[i][j]);
            }
        }
        return max;
    }

    public static int SolutionTwo(int[] nums){
        int len=nums.length;

        int[] dp=new int[len];
        int tempMax=0;
        int max=nums[0];
        for (int x:nums){
            tempMax=Math.max (x,tempMax+x);
            max=Math.max(tempMax,max);
        }
        return max;
    }
}
