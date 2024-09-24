package SquareIntoSquaresProtectTrees;

public class Decompose {
    private class Node {
        long value, div;
        Node left, right;

        public Node(long value, long div) {
            this.value = value;
            this.div = div;
        }
    }

    public String decompose (long n){
        Node root = this.buildTree(n*n,n);
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        Node current = root;
        while (current.value > 0){
            if (current.left != null && current.right != null) current = (current.left.div > current.right.div) ? current.left : current.right;
            else if (current.left != null) current = current.left;
            else if (current.right != null) current = current.right;
            sb.insert(0, current.div + " ");
        }
        return sb.toString().trim();
    }

    public Node buildTree(long rest, long parentDiv){
        Node root = new Node(rest, parentDiv);
        long div = (long) Math.sqrt(rest);
        if (div == parentDiv) div--;
        if (root.div > div && div > 0) root.left = buildTree(rest - div*div, div);
        if (root.left != null && root.left.left == null && root.left.right == null && root.left.value > 0) root.left = null;
        if (root.div > div -1 && div - 1 > 0) root.right = buildTree(rest - (div-1)*(div-1), (div-1));
        if (root.right != null && root.right.left == null && root.right.right == null && root.right.value > 0) root.right = null;
        return root;
    }

    public static void main(String[] args) {
        Decompose d = new Decompose();
        System.out.println(new Decompose().decompose(12675));
        System.out.println(new Decompose().decompose(8857));
        System.out.println(new Decompose().decompose(18641));
        System.out.println(new Decompose().decompose(9420));

    }
}
