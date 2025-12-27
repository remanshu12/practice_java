class Solution {
    public int countBeautifulPairs(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(gcd(nums[i],nums[j])==1){
                    count++;
                }
            }


      }
      return count;
    }
    static int gcd(int a,int b){
        String s1=String.valueOf(a);
        String s2=String.valueOf(b);
        a=(s1.charAt(0)-'0');
        b=(s2.charAt(s2.length()-1)-'0');
        while(b!=0){
           
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}