package CommandPtn.command;

import java.util.Stack;

public class MacroCommand implements Command {
    // 복수의 command를 모아놓은 클래스. 'macro'는 보통 프로그래밍에서 '복수의 명령을 모은것'을 의미함
    private Stack<Command> commands = new Stack<>();

    @Override
    public void execute() {
        for (Command comm : commands) {//for-each is the same with iterator
            comm.execute();
        }
    }

    public void append(Command command) {
        if (!this.equals(command)) { //자기 자신을 add하지 않도록 하기위함 (이렇게 하지않으면 무한 루프를 돌기때문)
            commands.push(command);
        }
    }

    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop();
        }
    }

    public void clear() {
        commands.clear();
    }
}
