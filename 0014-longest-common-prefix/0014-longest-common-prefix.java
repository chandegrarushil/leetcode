class Solution {

    public String twoPre(String s1, String s2){
        StringBuilder ans=new StringBuilder();
        int n1=s1.length();
        int n2=s2.length();

        for(int i=0;i<Math.min(n1,n2);i++){
            if(s1.charAt(i)==s2.charAt(i)){
                ans.append(s1.charAt(i));
            }else break;
        }
        return ans.toString();
    }

    public String longestCommonPrefix(String[] arr) {
        if(arr==null || arr.length==0) return "";

        String ans=arr[0];
        for(int i=1;i<arr.length;i++){
            ans=twoPre(ans,arr[i]);
            if(ans.isEmpty()) break;
        }
        return ans;
    }
}