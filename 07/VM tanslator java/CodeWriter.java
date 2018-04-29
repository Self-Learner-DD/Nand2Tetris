import edu.princeton.cs.algs4.Out;

public class CodeWriter {
    private String filename;
    private Out out;
    private int count;

    public CodeWriter(String pathOrfilename) {
        if (pathOrfilename.endsWith(".vm")) out = new Out(pathOrfilename.replace(".vm", ".asm"));
        else {
            String file = pathOrfilename.substring(pathOrfilename.lastIndexOf("/") + 1);
            out = new Out(pathOrfilename + "/" + file + ".asm"); 
        }
        count = 0;
    }
    
    public void setFileName(String filename) {
        this.filename = filename;
    }
    
    public void writeArithmetic(String command) {
        out.println("//" + command);
        if (command.equals("neg")) {
            out.println("@SP");
            out.println("A=M-1");
            out.println("M=-M");
        }
        else if (command.equals("not")) {
            out.println("@SP");
            out.println("A=M-1");
            out.println("M=!M");
        }
        else if (command.equals("add")) {
            out.println("@SP");
            out.println("AM=M-1");
            out.println("D=M");
            out.println("@SP");
            out.println("A=M-1");
            out.println("M=M+D");
        }
        else if (command.equals("sub")) {
            out.println("@SP");
            out.println("AM=M-1");
            out.println("D=M");
            out.println("@SP");
            out.println("A=M-1");
            out.println("M=M-D");
        }
        else if (command.equals("and")) {
            out.println("@SP");
            out.println("AM=M-1");
            out.println("D=M");
            out.println("@SP");
            out.println("A=M-1");
            out.println("M=M&D");
        }
        else if (command.equals("or")) {
            out.println("@SP");
            out.println("AM=M-1");
            out.println("D=M");
            out.println("@SP");
            out.println("A=M-1");
            out.println("M=M|D");
        }
        else if (command.equals("eq")) {
            out.println("@SP");
            out.println("AM=M-1");
            out.println("D=M");
            out.println("@SP");
            out.println("A=M-1");
            out.println("D=M-D");
            out.println("@FALSEeq" + count);
            out.println("D;JNE");
            out.println("@SP");
            out.println("A=M-1");
            out.println("M=-1");
            out.println("@CONTINUEeq" + count);
            out.println("0;JMP");
            out.println("(FALSEeq" + count + ")");
            out.println("@SP");
            out.println("A=M-1");
            out.println("M=0");
            out.println("(CONTINUEeq" + count + ")");
        }
        else if (command.equals("lt")) {
            out.println("@SP");
            out.println("AM=M-1");
            out.println("D=M");
            out.println("@SP");
            out.println("A=M-1");
            out.println("D=M-D");
            out.println("@FALSElt" + count);
            out.println("D;JGE");
            out.println("@SP");
            out.println("A=M-1");
            out.println("M=-1");
            out.println("@CONTINUElt" + count);
            out.println("0;JMP");
            out.println("(FALSElt" + count + ")");
            out.println("@SP");
            out.println("A=M-1");
            out.println("M=0");
            out.println("(CONTINUElt" + count + ")");
        }
        else if (command.equals("gt")) {
            out.println("@SP");
            out.println("AM=M-1");
            out.println("D=M");
            out.println("@SP");
            out.println("A=M-1");
            out.println("D=M-D");
            out.println("@FALSEgt" + count);
            out.println("D;JLE");
            out.println("@SP");
            out.println("A=M-1");
            out.println("M=-1");
            out.println("@CONTINUEgt" + count);
            out.println("0;JMP");
            out.println("(FALSEgt" + count + ")");
            out.println("@SP");
            out.println("A=M-1");
            out.println("M=0");
            out.println("(CONTINUEgt" + count + ")");
        } 
        count++;
    }
    
    public void writePushPop(String command, String segment, int index) {
        out.println("//" + command + " " + segment + " " + index);
        if (command.equals("push")) {
            if (segment.equals("argument")) {
                out.println("@" + index);
                out.println("D=A");
                out.println("@ARG");
                out.println("A=M+D");
                out.println("D=M");
                out.println("@SP");
                out.println("A=M");
                out.println("M=D");
                out.println("@SP");
                out.println("M=M+1");
            }
            else if (segment.equals("local")) {
                out.println("@" + index);
                out.println("D=A");
                out.println("@LCL");
                out.println("A=M+D");
                out.println("D=M");
                out.println("@SP");
                out.println("A=M");
                out.println("M=D");
                out.println("@SP");
                out.println("M=M+1");
            }
            else if (segment.equals("this")) {
                out.println("@" + index);
                out.println("D=A");
                out.println("@THIS");
                out.println("A=M+D");
                out.println("D=M");
                out.println("@SP");
                out.println("A=M");
                out.println("M=D");
                out.println("@SP");
                out.println("M=M+1");
            }
            else if (segment.equals("that")) {
                out.println("@" + index);
                out.println("D=A");
                out.println("@THAT");
                out.println("A=M+D");
                out.println("D=M");
                out.println("@SP");
                out.println("A=M");
                out.println("M=D");
                out.println("@SP");
                out.println("M=M+1");
            }
            else if (segment.equals("pointer")) {
                out.println("@" + index);
                out.println("D=A");
                out.println("@3");
                out.println("A=A+D");
                out.println("D=M");
                out.println("@SP");
                out.println("A=M");
                out.println("M=D");
                out.println("@SP");
                out.println("M=M+1");
            }
            else if (segment.equals("temp")) {
                out.println("@" + index);
                out.println("D=A");
                out.println("@5");
                out.println("A=A+D");
                out.println("D=M");
                out.println("@SP");
                out.println("A=M");
                out.println("M=D");
                out.println("@SP");
                out.println("M=M+1");
            }
            else if (segment.equals("constant")) {
                out.println("@" + index);
                out.println("D=A");
                out.println("@SP");
                out.println("A=M");
                out.println("M=D");
                out.println("@SP");
                out.println("M=M+1");
            }
            else if (segment.equals("static")) {
                out.println("@" + filename + "." + index);
                out.println("D=M");
                out.println("@SP");
                out.println("A=M");
                out.println("M=D");
                out.println("@SP");
                out.println("M=M+1");
            }
        }
        else {
            if (segment.equals("argument")) {
                out.println("@" + index);
                out.println("D=A");
                out.println("@ARG");
                out.println("D=M+D");
                out.println("@R13");
                out.println("M=D");
                out.println("@SP");
                out.println("AM=M-1");
                out.println("D=M");
                out.println("@R13");
                out.println("A=M");
                out.println("M=D");
            }
            else if (segment.equals("local")) {
                out.println("@" + index);
                out.println("D=A");
                out.println("@LCL");
                out.println("D=M+D");
                out.println("@R13");
                out.println("M=D");
                out.println("@SP");
                out.println("AM=M-1");
                out.println("D=M");
                out.println("@R13");
                out.println("A=M");
                out.println("M=D");
            }
            else if (segment.equals("this")) {
                out.println("@" + index);
                out.println("D=A");
                out.println("@THIS");
                out.println("D=M+D");
                out.println("@R13");
                out.println("M=D");
                out.println("@SP");
                out.println("AM=M-1");
                out.println("D=M");
                out.println("@R13");
                out.println("A=M");
                out.println("M=D");
            }
            else if (segment.equals("that")) {
                out.println("@" + index);
                out.println("D=A");
                out.println("@THAT");
                out.println("D=M+D");
                out.println("@R13");
                out.println("M=D");
                out.println("@SP");
                out.println("AM=M-1");
                out.println("D=M");
                out.println("@R13");
                out.println("A=M");
                out.println("M=D");
            }
            else if (segment.equals("pointer")) {
                out.println("@" + index);
                out.println("D=A");
                out.println("@3");
                out.println("D=A+D");
                out.println("@R13");
                out.println("M=D");
                out.println("@SP");
                out.println("AM=M-1");
                out.println("D=M");
                out.println("@R13");
                out.println("A=M");
                out.println("M=D");
            }
            else if (segment.equals("temp")) {
                out.println("@" + index);
                out.println("D=A");
                out.println("@5");
                out.println("D=A+D");
                out.println("@R13");
                out.println("M=D");
                out.println("@SP");
                out.println("AM=M-1");
                out.println("D=M");
                out.println("@R13");
                out.println("A=M");
                out.println("M=D");
            }
            else if (segment.equals("static")) {
                out.println("@SP");
                out.println("AM=M-1");
                out.println("D=M");
                out.println("@" + filename + "." + index);
                out.println("M=D");
            }
        } 
    }
    
    public void Close(){
        out.close();
    }
}
    