package evaluator;

public class SubtractOperation extends BinaryOperation {
    public SubtractOperation(IntExpression lhs, IntExpression rhs) {
        super(lhs, rhs);
    }

    protected int doOperation(int lhsval, int rhsval) {
        return lhsval - rhsval;
    }

    protected String toStringOperator() {
        return "-";
    }
}
