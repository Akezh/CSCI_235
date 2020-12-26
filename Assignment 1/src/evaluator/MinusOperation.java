package evaluator;

public class MinusOperation extends UnaryOperation {
    public MinusOperation(IntExpression chs) {
        super(chs);
    }

    protected int doOperation(int chsval) {
        return chsval * (-1);
    }

    protected String toStringOperator() {
        return "";
    }
}
