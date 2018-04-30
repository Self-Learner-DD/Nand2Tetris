How to compile the code

1.Go to folder Assembler java/

2.Open terminal in current path

3.Run command “javac Code.java” “javac Parser.java” “javac Assembler.java” (java is required to be installed) (all file input and output are handled with standard library of algorithm4, need to install the package from https://algs4.cs.princeton.edu/home/)

4.After compiling, there will be a “Code.class”, a “Parser.class” and a “Assember.class” file in current path

How to run the code

1.Command format is “java Assembler filepath”.

Example: java Assembler "/Users/User1/Desktop/nand2tetris/projects/06/add/Add.asm"

The .asm file does not need to be in the same folder of the program files. if it is in the same folder, can just use file name instead of path name. After finishing translation, there will be a _clean.asm file (asm file with no comments and spaces and blank lines) and .hack file with same name in the same path of the .asm file.
