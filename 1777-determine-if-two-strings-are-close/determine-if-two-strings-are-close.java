class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()){
            return false;
        }
        System.out.println("hello");

        int arr1[]=new int[27];
        int arr2[]=new int[27];
        Set<Character> set1=new HashSet<>();
        Set<Character> set2=new HashSet<>();
        for(int i=0;i<word1.length();i++){
            arr1[word1.charAt(i)-'a']++;
            set1.add(word1.charAt(i));
            set2.add(word2.charAt(i));
             arr2[word2.charAt(i)-'a']++;
        }
        if(set1.size()!=set2.size()){
            return false;
        }
         System.out.println("hello");
        for(char c:set1){
            if(!set2.contains(c)){
                return false;
            }
        }
         System.out.println("hello");
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]>0){
                list1.add(arr1[i]);
            }
            if(arr2[i]>0){
                list2.add(arr2[i]);
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
         
        for(int i =0;i<list1.size();i++){
            if(!list1.get(i).equals(list2.get(i))){
                // System.out.println(list1.get(0)+" "+list1.get(0)+" "+list1.size());
                return false;
            }
        }
        
        return true;

    }
}