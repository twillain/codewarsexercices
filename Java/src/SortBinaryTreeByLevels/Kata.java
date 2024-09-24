package SortBinaryTreeByLevels;

import java.util.ArrayList;
import java.util.List;

public class Kata {

    private static class Node{
        public Node left;
        public Node right;
        public int value;

        public  Node(Node l, Node r, int v){
            left = l;
            right = r;
            value = v;
        }

        public static List<Integer> treeByLevels(Node node){
            if (node == null) return null;

            ArrayList<Integer> sorted = new ArrayList<Integer>();
            ArrayList<Node> list = new ArrayList<Node>();

            sorted.add(node.value);
            while (true){
                list.add(node.left);
                list.add(node.right);
                for (Node n : list){

                }
                return sorted;
            }


            //return sorted;
        }

        public static void main(String... args){
            List<Integer> test1 = treeByLevels(new Node(new Node(null, new Node(null, null, 4), 2), new Node(new Node(null, null, 5), new Node(null, null, 6), 3), 1));
            System.out.println(test1);
        }


    }
}
