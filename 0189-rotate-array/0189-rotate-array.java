class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;

        if(n<=1 || k%n==0) return;

        k=k%n;

        //full array reverse
        reverse(nums,0,n-1);

        //k elements reverse
        reverse(nums,0,k-1);

        //baki element 
        reverse(nums,k,n-1);
    }

        //fumction
        private void reverse(int[] nums,int start,int end){
            while(start<=end){
                int tmp=nums[start];
                nums[start]=nums[end];
                nums[end]=tmp;

                start++;
                end--;
            }
        }
}