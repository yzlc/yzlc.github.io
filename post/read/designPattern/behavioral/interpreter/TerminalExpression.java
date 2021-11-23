package interpreter;

public class TerminalExpression extends AbstractExpression {
    @Override
    void interpret(Context context) {
        System.out.println("终端解释器");
    }
}
