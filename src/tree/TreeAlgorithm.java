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
     *
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
            current = stack.pop();
            current = current.right;
        }
    }

    /**
     * 二叉树的前序遍历 非递归
     *
     * @param node
     */
    public static void preOrder2(NormalNode node) {
        if (node == null) {
            return;
        }
        Stack<NormalNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            NormalNode normalNode = stack.pop();
            System.out.print(normalNode.value);
            if (normalNode.right != null) {
                stack.push(normalNode.right);
            }
            if (normalNode.left != null) {
                stack.push(normalNode.left);
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
            current = stack.pop();
            System.out.print(current.value);
            current = current.right;
        }
    }

    /**
     * 二叉树的后序遍历 递归方式 左 右 中
     *
     * @param node
     */
    public static void posOrder(NormalNode node) {
        if (node == null) {
            return;
        }
        posOrder(node.left);
        posOrder(node.right);
        System.out.print(node.value);
    }

    /**
     * 二叉树的后续遍历 非递归 双栈
     *
     * @param node
     */
    public static void posOrder1(NormalNode node) {
        if (node == null) {
            return;
        }
        Stack<NormalNode> s1 = new Stack<>();
        Stack<NormalNode> s2 = new Stack<>();
        NormalNode current = node;
        s1.push(current);
        while (!s1.isEmpty()) {
            current = s1.pop();
            s2.push(current);
            if (current.left != null) {
                s1.push(current.left);
            }
            if (current.right != null) {
                s1.push(current.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().value);
        }
    }

    /**
     * 二叉树的遍历 非递归 单栈
     *
     * @param node
     */
    public static void posOrder2(NormalNode node) {
        Stack<NormalNode> stack = new Stack<>();
        NormalNode current = node;
        NormalNode prev = node;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            NormalNode temp = stack.peek().right;
            if (temp == null || temp == prev) {
                current = stack.pop();
                System.out.print(current.value);
                prev = current;
                current = null;
            } else {
                current = temp;
            }
        }
    }
}
