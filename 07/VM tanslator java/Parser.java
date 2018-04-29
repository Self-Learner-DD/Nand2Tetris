import edu.princeton.cs.algs4.In;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Parser {
    private String command;
    private String[] commands;
    private In in;
    private static final int NOT_VALID_COMMAND = 0;
    private static final int C_ARITHMETIC = 1;
    private static final int C_PUSH = 2;
    private static final int C_POP = 3;
    private static final int C_LABEL = 4;
    private static final int C_GOTO = 5;
    private static final int C_IF = 6;
    private static final int C_FUNCTION = 7;
    private static final int C_RETURN = 8;
    private static final int C_CALL = 9;
    
    private static Set<String> operator = new HashSet<String>(Arrays.asList("add", "sub", "neg", "eq", "gt", "lt", "and", "or", "not"));
    
    public Parser(String filename) {
        in = new In(filename);
    }
    
    public boolean hasMoreCommand() {
        return in.hasNextLine();
    }
    
    public void advance() {
        command = in.readLine().replace("\\s+", " ").replace("//.*", "");
        commands = command.split(" ");
    }
    
    public int commandType() {
        if (command.length() == 0 || command == " " || command == "\n") return NOT_VALID_COMMAND;
        if (commands[0].equals("push")) return C_PUSH;
        if (commands[0].equals("pop")) return C_POP;
        if (operator.contains(command)) return C_ARITHMETIC; 
        else return 0;
    }
    
    public String arg1() {
        if (commands.length == 1) return commands[0];
        else return commands[1]; 
    }
    
    public int arg2() {
        return Integer.valueOf(commands[2]);
    }
}