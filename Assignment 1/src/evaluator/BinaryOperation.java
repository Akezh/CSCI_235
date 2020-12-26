package evaluator;

public abstract class BinaryOperation implements IntExpression {

    private IntExpression lhs;
    private IntExpression rhs;

    public BinaryOperation(IntExpression lhs, IntExpression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    abstract protected int doOperation(int lhsval, int rhsval);

    public int getValue() {
        return doOperation(lhs.getValue(), rhs.getValue());
    }

    abstract protected String toStringOperator();

    public String toString() {
        return "(" + lhs.toString() + " " + toStringOperator() + " " + rhs.toString() + ")";
    }
}
