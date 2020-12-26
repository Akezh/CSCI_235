package evaluator;

public class AddOperation extends BinaryOperation {
    public AddOperation(IntExpression lhs, IntExpression rhs) {
        super(lhs, rhs);
    }

    protected int doOperation(int lhsval, int rhsval) {
        return lhsval + rhsval;
    }

    protected String toStringOperator() {
        return "+";
    }
}
