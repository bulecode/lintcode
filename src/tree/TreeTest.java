package tree;

/**
 * Author: buleCode
 * Date: 2018/3/7
 */
public class TreeTest {

    public static void main(String[] args) {
        NormalNode<Character> root = new NormalNode<>('A');
        NormalNode<Character> b = new NormalNode<>('B');
        NormalNode<Character> c = new NormalNode<>('C');
        NormalNode<Character> d = new NormalNode<>('D');
        NormalNode<Character> e = new NormalNode<>('E');
        NormalNode<Character> f = new NormalNode<>('F');
        NormalNode<Character> g = new NormalNode<>('G');
        NormalNode<Character> h = new NormalNode<>('H');
        NormalNode<Character> k = new NormalNode<>('K');

        root.left = b;
        root.right = e;
        b.right = c;
        c.left = d;
        e.right = f;
        f.left = g;
        g.left = h;
        g.right = k;

        TreeAlgorithm.prevOrder(root);
        System.out.println("");
        TreeAlgorithm.preOrder1(root);
        System.out.println("\n---------------------");
        TreeAlgorithm.inOrder(root);
        System.out.println("");
        TreeAlgorithm.inOrder1(root);
    }




}
