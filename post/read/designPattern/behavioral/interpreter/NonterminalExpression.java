package interpreter;

public class NonterminalExpression extends AbstractExpression {
    @Override
    void interpret(Context context) {
        System.out.println("非终端解释器");
    }
}
