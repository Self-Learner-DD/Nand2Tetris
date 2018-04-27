import edu.princeton.cs.algs4.Out;
import java.util.Map;
import java.util.HashMap;

public class Assembler {
    public static int NOT_VALID_COMMAND = -1;
    public static int A_COMMAND = 0;
    public static int C_COMMAND = 1;
    public static int L_COMMAND = 2;A
    private static  Map<String, Integer> map =  new HashMap<String, Integer>();
    static {
        map.put("SP", 0);
        map.put("LCL", 1);
        map.put("ARG", 2);
        map.put("THIS", 3);
        map.put("THAT", 4);
        map.put("SCREEN", 16384);
        map.put("KBD", 24576);
        map.put("R0", 0);
        map.put("R1", 1);
        map.put("R2", 2);
        map.put("R3", 3);
        map.put("R4", 4);
        map.put("R5", 5);
        map.put("R6", 6);
        map.put("R7", 7);
        map.put("R8", 8);
        map.put("R9", 9);
        map.put("R10", 10);
        map.put("R11", 11);
        map.put("R12", 12);
        map.put("R13", 13);
        map.put("R14", 14);
        map.put("R15", 15);
    }
        
    public static void firstPass(String filename) {
        Parser parser = new Parser(filename);
        
        int instruction_address = 0;
        Out out = new Out(filename.replace(".asm", "_clean.asm"));
        while (parser.hasMoreCommands()) {       
            parser.advance();
            int commandType = parser.commandType();
            if (commandType != NOT_VALID_COMMAND) {
                out.println(parser.command());
                if (commandType == L_COMMAND) {
                    map.put(parser.symbol(), instruction_address);
                }
                else {
                    instruction_address++;
                }
            }
        }
    }
    
    public static void secondPass(String filename) {
        Parser parser = new Parser(filename.replace(".asm", "_clean.asm"));
        Out out = new Out(filename.replace(".asm", ".hack"));
        int variable_address = 1024;
        while (parser.hasMoreCommands()) { 
            parser.advance();
            int commandType = parser.commandType();
            if (commandType == A_COMMAND) {
                String symbol = parser.symbol();
                int ins;
                if (symbol.matches("[0-9]+")) { ins = Integer.valueOf(symbol);}
                else 
                {
                    if (!map.containsKey(symbol)) map.put(symbol, variable_address++);
                    ins = map.get(symbol); 
                }
                String instruction  = Integer.toBinaryString(ins);
                while (instruction.length() < 16) {
                    instruction = "0" + instruction;
                }
                out.println(instruction);
            }
            else if (commandType == C_COMMAND) {
                Code code = new Code();
                out.println("111" + code.comp(parser.comp()) + code.dest(parser.dest()) + code.jump(parser.jump()));
            }
        }
        out.close();
    }     

    public static void main(String[] args) {
        String fileName = args[0];
        firstPass(fileName);
        secondPass(fileName);  
    }
}
