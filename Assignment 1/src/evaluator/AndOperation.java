package evaluator;

public class AndOperation extends BinaryOperation {
    public AndOperation(IntExpression lhs, IntExpression rhs) {
        super(lhs, rhs);
    }

    protected int doOperation(int lhsval, int rhsval) {
        if (lhsval == 0 || rhsval == 0)
            return 0;

        return 1;
    }

    protected String toStringOperator() {
        return "&";
    }
}
