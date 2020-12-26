package evaluator;

public class TernaryOperation implements IntExpression {
    private IntExpression exp1;
    private IntExpression exp2;
    private IntExpression exp3;

    public TernaryOperation(IntExpression exp1, IntExpression exp2, IntExpression exp3) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.exp3 = exp3;
    }

    public int getValue() {
        if (exp1.getValue() == 0) {
            return exp3.getValue();
        }

        return exp2.getValue();
    }

    public String toString() {
        return "(" + exp1.toString() + " ? " +  exp2.toString() + " : " + exp3.toString() + ") ";
    }
}
