How to compile the code

1.Go to folder VM translator java/ 

2.Open terminal in current path

3.Run command “javac CodeWriter.java”
	      “javac Parser.java”
	      “javac VMtranslator.java”
	      (java is required to be installed)
        (all file input and output are handled with standard library of algorith4, need to install the package at https://algs4.cs.princeton.edu/home/)

4.After compiling, there will be a “CodeWriter.class”, a “Parser.class” and a “VMtranslator.class” file in current path

How to run the code

1.Command format is “java VMtranslator pathOrfileName”.

    (1) If the argument is a directory, after translation finishing, there will be a .asm file which is named by the folder name and this file will be in this directory.

    (2) If the argument is a file, after translation finishing, there will be a StaticTest.asm file which is named by the file name and this file will be in the same directory as the vm file.
