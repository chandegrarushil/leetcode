class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int length=0;

        //right to left
        for(int i=s.length()-1;i>=0;i--){

            //space na mle to aagad vadho
            if(s.charAt(i)!=' ') length++;
            else break;
        }
        return length;
    }
}