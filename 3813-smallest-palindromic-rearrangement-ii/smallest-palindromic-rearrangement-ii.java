class Solution{
    private static final long MAX_LIMIT=1_000_000_000L;

    public String smallestPalindrome(String s,int k){
        int[] charCount=new int[26];
        for(char ch:s.toCharArray()) charCount[ch-'a']++;
        char middleChar=0;
        int halfLength=0;
        for(int i=0;i<26;i++){
            if(charCount[i]%2==1) middleChar=(char)(i+'a');
            charCount[i]/=2;
            halfLength+=charCount[i];
        }
        if(countWays(charCount,halfLength)<k) return "";
        StringBuilder leftHalf=new StringBuilder();
        for(int pos=0;pos<halfLength;pos++){
            for(int ch=0;ch<26;ch++){
                if(charCount[ch]==0) continue;
                charCount[ch]--;
                long possible=countWays(charCount,halfLength-pos-1);
                if(possible<k){
                    k-=possible;
                    charCount[ch]++;
                }else{
                    leftHalf.append((char)(ch+'a'));
                    break;
                }
            }
        }
        String rightHalf=new StringBuilder(leftHalf).reverse().toString();
        return middleChar==0
                ? leftHalf.toString()+rightHalf
                : leftHalf.toString()+middleChar+rightHalf;
    }

    private long countWays(int[] charCount,int totalChars){
        long result=1;
        int used=0;
        for(int count:charCount){
            for(int i=1;i<=count;i++){
                result=result*(used+i)/i;
                if(result>MAX_LIMIT) return MAX_LIMIT;
            }
            used+=count;
        }
        return result;
    }
}
