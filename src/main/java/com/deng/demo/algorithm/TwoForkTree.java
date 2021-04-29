package com.deng.demo.algorithm;

public class TwoForkTree {
    static int k = 0;
     public TwoForkNode getTwoNode(){
         TwoForkNode rootNode = new TwoForkNode(3);
         TwoForkNode node1 = new TwoForkNode(2);
         TwoForkNode node2 = new TwoForkNode(4);
         TwoForkNode node3 = new TwoForkNode(5);
         rootNode.setLeft(node1);
         rootNode.setRight(node2);
         node1.setRight(node3);
         return rootNode;
     }

     public void findNode(TwoForkNode node,int n){
         if (node == null){
               return;
         }
         findNode(node.getRight(),n);
         k++;
         if ( k==n){
             System.out.println(node.getData());
         }
         findNode(node.getLeft(),n);
     }
}
