class Solution {
    public String reverseWords(String s) {
        if(s==null) return "";

        //string ne characheter array ma convert 
        char[] a= s.toCharArray();
        int n=a.length;

        //extra sapcger mate 
        int length=cleanSpaces(a,n);

        //reverse array 
        reverse(a,0,length-1);

        //word reverse
        reverseEachWord(a,length);

        return new String(a,0,length);
    }

    private int cleanSpaces(char[] a, int n){
        int i=0,j=0;

        while(j<n){
            //bhadhi space delete
            while(j<n && a[j]==' ') j++;

            //word copy karo 
            while(j<n && a[j]!=' ') a[i++]=a[j++];

            //banne vache khali ek space
            while(j<n && a[j]==' ') j++;

            //jo word hoy to space apo
            if(j<n) a[i++]=' ';
        }
        return i;
    }

    private void reverse(char[] a, int left, int right){
        while(left<right){
            char tmp=a[left];
            a[left++]=a[right];
            a[right--]=tmp;
        }
    }

    private void reverseEachWord(char[] a, int n){
        int i=0,j=0;
        while(i<n){

            while(i<j || i<n && a[i]==' ') i++;
            while(j<i || j<n && a[j]!=' ') j++;
            reverse(a,i,j-1);

        }
    }
}