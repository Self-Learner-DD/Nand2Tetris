All file reading and writing are done using In and Out class from edu.princeton.cs.algs4

Parser: process each line of the file; get rid of comments, space, and blank lines; return the type of the command; if the command is C_COMMAND
        return the computation, destination, and jump component.
        
Code: return the binary representation of the computation, destination, and jump component if the instruction is C_COMMAND;

Assembler: Build a symbol table to store all default symbol, label symbol, and variable symbol and there corresponding address;
           first pass record the label symbol and their address; and output an .asm files with out comments, space, and blank lines
           2nd pass, add variable symbol and their address into the symbol table; and translate the assembly language into machine language.
           
