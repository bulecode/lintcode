package tree;

/**
 * Author: buleCode
 * Date: 2018/3/7
 */
public class NormalNode<T> {

    T value;
    NormalNode<T> left;
    NormalNode<T> right;

    public NormalNode(T value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "NormalNode{" +
                "value=" + value +
                '}';
    }
}
