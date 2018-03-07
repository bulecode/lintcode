package tree;

import java.util.Stack;

/**
 * Author: buleCode
 * Date: 2018/3/7
 */
public class TreeAlgorithm {


    /**
     * 二叉树的前序遍历 根 - 左 -右
     * 递归方式
     * @param node
     */
    public static void prevOrder(NormalNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        prevOrder(node.left);
        prevOrder(node.right);
    }

    /**
     * 二叉树的前序遍历 非递归
     *
     * @param node
     */
    public static void preOrder1(NormalNode node) {
        Stack<NormalNode> stack = new Stack<>();
        NormalNode current = node;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                System.out.print(current.value);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.right;
            }
        }
    }

    /**
     * 二叉树的中序遍历 左 - 中 - 右
     *
     * @param node
     */
    public static void inOrder(NormalNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    /**
     * 二叉树的中序遍历 非递归
     *
     * @param node
     */
    public static void inOrder1(NormalNode node) {
        Stack<NormalNode> stack = new Stack<>();
        NormalNode current = node;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                System.out.print(current.value);
                current = current.right;
            }
        }

    }

}
