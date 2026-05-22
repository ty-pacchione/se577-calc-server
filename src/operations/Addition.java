package operations;

public class Addition extends BinaryOperator {
    public Addition(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }
}