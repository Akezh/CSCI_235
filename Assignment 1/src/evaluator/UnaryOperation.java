package evaluator;

public abstract class UnaryOperation implements IntExpression {
    private IntExpression chs;

    public UnaryOperation(IntExpression chs) {
        this.chs = chs;
    }

    abstract protected int doOperation(int chsval);

    public int getValue() {
        return doOperation(chs.getValue());
    }

    abstract protected String toStringOperator();

    public String toString() {
        return "(" + toStringOperator() + chs.toString() + ")";
    }
}
