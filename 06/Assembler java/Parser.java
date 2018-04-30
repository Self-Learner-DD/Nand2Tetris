import edu.princeton.cs.algs4.In;
import java.util.Map;
import java.util.HashMap;

public class Parser {
    private In in;
    private String command;
    public int NOT_VALID_COMMAND = -1;
    public int A_COMMAND = 0;
    public int C_COMMAND = 1;
    public int L_COMMAND = 2;
    private Map<String, String> destMap;
    public Parser(String filename) {
        in = new In(filename);
    }
    
    public boolean hasMoreCommands() {
        return in.hasNextLine();
    }
    
    public void advance() {
        command = in.readLine().replaceAll("\\s", "").replaceAll("//.*", "");
    }
    
    public int commandType() {
        if (command.length() == 0 || command.equals("\n")) return NOT_VALID_COMMAND;
        if (command.indexOf("@") == 0) return A_COMMAND;
        else if (command.indexOf("(") == 0) return L_COMMAND;
        else return C_COMMAND;
    }
    
    public String symbol() {
        if (commandType() == A_COMMAND) return command.substring(1);
        else return command.substring(1, command.length() - 1);
    }
    
    public String dest() {
        int index = command.indexOf("=");
        if (index == -1) return "";
        return command.substring(0, index);
    }
    
    public String comp() {
        int index1 = command.indexOf("=");
        int index2 = command.indexOf(";");
        if (index1 == -1 && index2 == -1) return command;
        else if (index2 == -1) return command.substring(index1 + 1);
        else return command.substring(index1 + 1, index2);
    }
    
    public String jump() {
        int index = command.indexOf(";");
        if (index == -1) return "";
        return command.substring(index + 1);
    }
    
    public String command() {
        return command;
    }
}
