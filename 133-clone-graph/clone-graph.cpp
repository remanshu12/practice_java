/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    unordered_map<Node*,Node*> map;
    void dfs(Node* node,Node* clone_node){
        for(Node* n:node->neighbors){
            if(map.find(n)==map.end()){
                Node* clone=new Node(n->val);
                map[n]=clone;
                clone_node->neighbors.push_back(clone);
                dfs(n,clone);
            }else{
                 clone_node->neighbors.push_back(map[n]);
            }
        }
    }
    Node* cloneGraph(Node* node) {

         if(node==NULL){
            return NULL;
         }
         map.clear();
         Node* clone_node=new Node(node->val);
        map[node]=clone_node;
        dfs(node,clone_node);
        return clone_node;
    }
};