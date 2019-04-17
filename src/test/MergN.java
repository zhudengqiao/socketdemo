package test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergN {
    private class Node{
        private int val;
        private int index;
        private Node(int val, int index){
            this.val = val;
            this.index = index;
        }
        private int getVal(){
            return this.val;
        }

        private void setVal(int val) {
            this.val = val;
        }
    }
    private int[] MergeArray(int[][] arrays){
        int num = arrays.length;
        int L = arrays[0].length;
        int[] result = new int[num * L];
        int[] in = new int[num];
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(Node::getVal));
        for (int i = 0; i < num; i++) {
            Node n = new Node(arrays[i][in[i]++], i);
            q.offer(n);
        }
        int id = 0;
        while (id < num*L){
            Node min = q.poll();
            result[id++] = min.getVal();
            if(in[min.index]<L){
                min.setVal(arrays[min.index][in[min.index]++]);
                q.offer(min);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = (3+i)*(j+2);
            }
        }
        MergN m = new MergN();
        int[]result = m.MergeArray(a);
        for (int i = 0; i < 9; i++) {
            System.out.println(result[i]);
        }
    }
}
