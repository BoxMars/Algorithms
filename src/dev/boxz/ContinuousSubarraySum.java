/**
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 */

package dev.boxz;

public class ContinuousSubarraySum {
    public static boolean Solution(int[] nums, int k){
        int[] sum = new int[nums.length+1];
        sum[0]=0;
        for (int i=0;i<nums.length;i++){
            sum[i+1]=sum[i]+ nums[i];
        }

            for (int i=0;i<sum.length-2;i++){
                for (int j=i+1; j<sum.length-1;j++){
                    int temp=sum[j+1]-sum[i];
                    if ((k==0&&temp==0)||(k!=0&&temp%k==0)){
                        return true;
                    }
                }
            }
            return false;
    }
}
