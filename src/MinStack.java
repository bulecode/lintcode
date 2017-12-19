import java.util.Objects;
import java.util.Stack;

/**
 * 实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
 你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。
 */
public class MinStack {

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> temp = new Stack<>();

    public MinStack() {
        // do intialization if necessary
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        stack.push(number);
        if (temp.empty() || temp.peek() >= number) {
            temp.push(number);
        }

        // write your code here
    }

    /*
     * @return: An integer
     */
    public int pop() {
        Integer pop = stack.pop();
        if (!temp.empty() && Objects.equals(pop, temp.peek())) {
            temp.pop();
        }
        return pop;
        // write your code here
    }

    /*
     * @return: An integer
     */
    public int min() {
        if (stack.empty()) {
            throw new RuntimeException("stack is empty");
        }
        return temp.peek();
    }
}