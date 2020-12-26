package evaluator;

public class MultiplyOperation extends BinaryOperation {
    public MultiplyOperation(IntExpression lhs, IntExpression rhs) {
        super(lhs, rhs);
    }

    protected int doOperation(int lhsval, int rhsval) {
        return lhsval * rhsval;
    }

    protected String toStringOperator() {
        return "*";
    }
}
