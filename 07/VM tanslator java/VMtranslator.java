import java.io.File;

public class VMtranslator {
    private CodeWriter cw;
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
    
    public VMtranslator(String name) {
        cw = new CodeWriter(name);
    }
    
    public void singleFile(String fileName) {
        cw.setFileName(fileName);
        Parser parser = new Parser(fileName);
        while(parser.hasMoreCommand()) {
            parser.advance();
            
            String command = null; String arg1 = null; int arg2 = -1;
            
            int commandType = parser.commandType();
            if (commandType == C_ARITHMETIC) {
                command = parser.arg1();
                cw.writeArithmetic(command);
            }
            else if (commandType == C_PUSH || commandType == C_POP) {
                
                if (commandType == C_PUSH) command = "push";
                else command = "pop";
                arg1 = parser.arg1();
                arg2 = parser.arg2();
                cw.writePushPop(command, arg1, arg2);
            }
        }
    }
                       
    public static void main(String[] args) {
        String name = args[0];
        VMtranslator vm = new VMtranslator(name);
        if (name.endsWith(".vm")) vm.singleFile(name);
        else {
            File files = new File(name);
            for (File file : files.listFiles()) {
                String filename = file.getName();
                if (filename.endsWith(".vm")) {
                    vm.singleFile(filename);
                }
            }
        }
    }
}
        
        