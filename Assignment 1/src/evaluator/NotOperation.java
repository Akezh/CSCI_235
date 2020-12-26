package evaluator;

public class NotOperation extends UnaryOperation {
    public NotOperation(IntExpression chs) {
        super(chs);
    }

    protected int doOperation(int chsval) {
        if (chsval == 0)
            return 1;

        return 0;
    }

    protected String toStringOperator() {
        return "!";
    }
}
