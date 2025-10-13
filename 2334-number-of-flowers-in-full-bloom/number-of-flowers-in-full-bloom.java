class Solution {
    static int Upperbound(int arr[],int target){
        if(target<arr[0]){
            return 0;
        }
        if(target>=arr[arr.length-1]){
            return arr.length;
        }
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    static int Lowerbound(int arr[],int target){
        if(target<arr[0]){
            return 0;
        }
        if(target>arr[arr.length-1]){
            return arr.length;
        }
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    
    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int[] result = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            int time = people[i];

            // count how many flowers have started blooming ≤ time
            int started = Upperbound(start, time);
            // count how many flowers have already ended < time
            int ended = Lowerbound(end, time);

            result[i] = started - ended;
        }

        return result;
    }


   
}

// blooming at time p=  flowers_started_on_or_before_p − flowers_ended_before_p
// = count(start ≤ p) − count(end < p)