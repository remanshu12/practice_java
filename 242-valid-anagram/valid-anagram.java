class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arr1=new char[s.length()];
        char[] arr2=new char[t.length()];
        arr1=s.toCharArray();
        arr2=t.toCharArray();
       Arrays.sort(arr1);
       Arrays.sort(arr2);
       System.out.println(Arrays.toString(arr1));
       System.out.println(Arrays.toString(arr2));
        return Arrays.equals(arr1,arr2);
    }
}