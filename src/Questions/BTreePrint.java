package Questions;

import java.util.*;

class Node<T extends Comparable<?>> {
    Node<T> left, right;
    T data;

    public Node(T data) {
        this.data = data;
    }
}

public class BTreePrint {

    public static <T extends Comparable<?>> void printNode(Node<T> root) {
        int maxLevel = BTreePrint.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    public static Node InsertIntoTree(ArrayList<Integer> list){
        Node root = null,current = null;
        if ( list.size() == 0 ) return root;
        if ( list.size() ==1  && list.get(0) == -1) return null;
        int startChildren=0;
        Queue<Node> parents = new LinkedList<Node>();
        while (startChildren < list.size()){
            if ( root== null){
                root = InsertNodes(list.get(startChildren));
                parents.add(root);
                startChildren = 2*startChildren +1;
            } else {
                while (!parents.isEmpty()){
                    current = parents.remove();
                    current.left = InsertNodes(list.get(startChildren++));
                    if ( current.left != null) parents.add(current.left);
                    current.right = InsertNodes(list.get(startChildren++));
                    if ( current.right!=null) parents.add(current.right);
                }
            }
        }
        return root ;
    }

    public static Node InsertNodes(int x){
        if ( x == -1) return null;
        else return new Node(x);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrint.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrint.printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<Node<T>>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrint.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrint.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrint.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrint.printWhitespaces(1);

                BTreePrint.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrint.printWhitespaces(1);

                BTreePrint.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrint.maxLevel(node.left), BTreePrint.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}