class Solution {
    public boolean isTrionic(int[] nums) {
        int diff[]=new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++){
            diff[i]=nums[i+1]-nums[i];
            if(diff[i]==0){
                return false;
            }
        }
       // System.out.println(Arrays.toString(diff));
        if(diff[0]<0) return false;
            if(diff[diff.length-1]<0) return false;
            int neg=0;
            int pos=0;
            boolean flag=false;
        for(int i=0;i<diff.length;i++){
               if(diff[i]>0 && flag==false){
                pos++;
                flag=true;
               }else if(diff[i]<0 && flag==true){
                neg++;
                flag=false;
               }

        }
        // System.out.println(neg+" " + pos);
        return neg==1 && pos==2;
    }
}