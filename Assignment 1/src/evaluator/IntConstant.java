package evaluator;

public class IntConstant implements IntExpression {
    private int value;

    public IntConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return Integer.toString(value);
    }
}
