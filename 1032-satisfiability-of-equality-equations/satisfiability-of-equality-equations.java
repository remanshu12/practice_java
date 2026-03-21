class Solution {
    class DSU{
        int parent[],rank[];
        DSU(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        int find(int x){
            if(parent[x]!=x){
                return parent[x]=find(parent[x]);
            }
            return x;
        }
        boolean union(int u,int v){
            int ra=find(u);
            int rb=find(v);
            if(ra==rb) return false;
            if(rank[ra]<rank[rb]){
                parent[ra]=rb;
            }else if(rank[ra]>rank[rb]){
                parent[rb]=ra;
            }else{
                parent[rb]=ra;
                rank[ra]++;
            }
            return true;
        }

    }
    public boolean equationsPossible(String[] arr) {
        DSU dsu=new DSU(26);
        for(int i=0;i<arr.length;i++){
            String s=arr[i];
            int u=s.charAt(0)-'a';
            int v=s.charAt(3)-'a';
            if(s.charAt(1)=='='){
                dsu.union(u,v);
            }
        }
        for(int i=0;i<arr.length;i++){
            String s=arr[i];
            int u=s.charAt(0)-'a';
            int v=s.charAt(3)-'a';
            if(s.charAt(1)=='!'){
               if(dsu.find(u)==dsu.find(v)){
                return false;
               }
            }
        }
        return true;

    }
}