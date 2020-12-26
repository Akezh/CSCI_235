package evaluator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Binary Operations");
        IntExpression expr = new OrOperation(
                new IntConstant(1),
                new AndOperation(
                        new IntConstant(0),
                        new OrOperation(
                                new IntConstant(-12),
                                new IntConstant(1)
                        )
                )
        );
        System.out.println(expr);
        System.out.println("result of upper equation: " + expr.getValue());
        System.out.println("sould be: 1");

        IntExpression expr5 = new AndOperation(
                new IntConstant(12),
                new IntConstant(0)
        );
        System.out.println(expr5);
        System.out.println("result of upper equation: " + expr5.getValue());
        System.out.println("sould be: 0");

        IntExpression expr2 = new NotOperation(
                new MultiplyOperation(
                        new IntConstant(0),
                        new MultiplyOperation(
                                new IntConstant(20),
                                new SubtractOperation(
                                    new IntConstant(10),
                                        new IntConstant(5)
                                )
                        )
                )
        );
        System.out.println(expr2);
        System.out.println("result of upper equation: " + expr2.getValue());
        System.out.println("sould be: 1");
        System.out.println();


        System.out.println("Unary Operations");
        IntExpression expr3 = new NotOperation(
                new IntConstant(1)
        );
        IntExpression expr4 = new NotOperation(
            new NotOperation(
                    new IntConstant(-12)
            )
        );
        System.out.println(expr3);
        System.out.println("result of upper equation: " + expr3.getValue());
        System.out.println("sould be: 0");

        System.out.println(expr4);
        System.out.println("result of upper equation: " + expr4.getValue());
        System.out.println("sould be: 1");

        IntExpression expr6 = new MinusOperation(
                new IntConstant(-2)
        );
        System.out.println(expr6);
        System.out.println("result of upper equation: " + expr6.getValue());
        System.out.println("sould be: 2");
        System.out.println();


        System.out.println("Ternary Operation");
        TernaryOperation tr = new TernaryOperation(
                new IntConstant(1),
                new IntConstant(38),
                new IntConstant(2)
        );
        System.out.println(tr);
        System.out.println("result of upper equation: " + tr.getValue());
        System.out.println("sould be: 38");

        IntExpression e = new DivideOperation(
                new IntConstant(56),
                new AddOperation(
                        new IntConstant(13),
                        new SubtractOperation(
                                new IntConstant(16),
                                new NotOperation(
                                        new IntConstant(0)
                                )
                        )
                )
        );
        System.out.println(e);
        System.out.println("result of upper equation: " + e.getValue());
        System.out.println("sould be: 2");

        IntExpression e2 = new MinusOperation(
                new MinusOperation(
                    new MinusOperation (
                        new IntConstant(55)
                    )
                )
        );
        System.out.println(e2);
        System.out.println("result of upper equation: " + e2.getValue());
        System.out.println("sould be: -55");
    }
}
