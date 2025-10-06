package com.jpquizbot.service;

import com.jpquizbot.model.Question;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class QuestionBank {
    private final Map<String, List<Question>> banks = new HashMap<>();

    @PostConstruct
    public void init() {
        // --- JAVA BANK ---
        List<Question> java = new ArrayList<>();
        java.add(new Question("j1","Which of these is NOT a primitive type in Java?",
                Arrays.asList("int","boolean","String","double"),2,
                "String is a reference type (class), not a primitive."));
        java.add(new Question("j2","Which keyword is used for inheritance?",
                Arrays.asList("implements","extends","inherits","uses"),1,
                "'extends' is used to inherit classes; 'implements' is for interfaces."));
        java.add(new Question("j3","What is the entry point method signature?",
                Arrays.asList("public static void main(String[] args)","public void main()","static public main()","main(String[])"),0,
                "The JVM looks for 'public static void main(String[] args)' as entry point."));
        java.add(new Question("j4","Which collection preserves insertion order and allows duplicates?",
                Arrays.asList("HashSet","ArrayList","TreeSet","PriorityQueue"),1,
                "ArrayList preserves insertion order and allows duplicates."));
        java.add(new Question("j5","Which exception is checked (compile-time)?",
                Arrays.asList("NullPointerException","IOException","ArithmeticException","RuntimeException"),1,
                "IOException is a checked exception and must be handled or declared."));
        java.add(new Question("j6","What does 'final' on a method mean?",
                Arrays.asList("Can be overridden","Cannot be overridden","Private method","Static method"),1,
                "final prevents a method from being overridden in subclasses."));
        java.add(new Question("j7","Which JVM memory area stores class definitions?",
                Arrays.asList("Stack","Heap","Method Area / PermGen / Metaspace","Native"),2,
                "The Method Area (Metaspace in modern JVMs) stores class metadata."));
        java.add(new Question("j8","What is autoboxing?",
                Arrays.asList("Converting object to primitive","Converting primitive to wrapper automatically","Casting numbers","Manual boxing"),1,
                "Autoboxing converts primitives to their wrapper types automatically."));
        java.add(new Question("j9","Which keyword makes a member belong to class (not instance)?",
                Arrays.asList("this","static","final","volatile"),1,
                "static members belong to the class itself."));
        java.add(new Question("j10","What does 'synchronized' ensure?",
                Arrays.asList("Faster execution","Memory allocation","Mutual exclusion for threads","Type safety"),2,
                "synchronized serializes access to a block or method across threads."));
        java.add(new Question("j11","Which method is used to compare String contents?",
                Arrays.asList("==","equals()","compare()","same()"),1,
                "Use equals() to compare String content; '==' compares references."));
        banks.put("java", java);

        // --- C BANK ---
        List<Question> c = new ArrayList<>();
        c.add(new Question("c1","Who developed the C language?",
                Arrays.asList("Bjarne Stroustrup","Dennis Ritchie","James Gosling","Ken Thompson"),1,
                "Dennis Ritchie at Bell Labs created C."));
        c.add(new Question("c2","What does 'sizeof(char)' return in C (on most systems)?",
                Arrays.asList("1","2","4","Depends"),0,
                "By definition sizeof(char) == 1 (byte)."));
        c.add(new Question("c3","Which header defines printf?",
                Arrays.asList("<io.h>","<stdio.h>","<iostream>","<print.h>"),1,
                "printf is declared in stdio.h."));
        c.add(new Question("c4","Which operator yields address of variable?",
                Arrays.asList("*","&","%","$"),1,
                "& gives the address of a variable (pointer)."));
        c.add(new Question("c5","Which memory is typically used for local variables?",
                Arrays.asList("Heap","Stack","BSS","Data segment"),1,
                "Local (automatic) variables are stored on the stack."));
        c.add(new Question("c6","What does 'malloc' return on failure?",
                Arrays.asList("NULL","0","-1","Error code"),0,
                "malloc returns NULL when it fails to allocate memory."));
        c.add(new Question("c7","Which function frees allocated memory?",
                Arrays.asList("free()","delete()","dispose()","release()"),0,
                "free() releases memory allocated by malloc/calloc/realloc."));
        c.add(new Question("c8","What is undefined behavior?",
                Arrays.asList("Guaranteed error","Compiler-specific behavior that is unpredictable","Portable code","Standard behavior"),1,
                "Undefined behavior is unpredictable and can vary by compiler/platform."));
        c.add(new Question("c9","Which loop runs at least once?",
                Arrays.asList("for","while","do-while","none"),2,
                "do-while executes the body before checking condition."));
        c.add(new Question("c10","Which is correct array declaration?",
                Arrays.asList("int a = new int[5];","int a[5];","int[] a = 5;","array<int> a;"),1,
                "C arrays declared as int a[5];"));
        banks.put("c", c);

        // --- PYTHON BANK ---
        List<Question> python = new ArrayList<>();
        python.add(new Question("p1","Which keyword defines a function in Python?",
                Arrays.asList("def","function","fun","fn"),0,
                "Use def to define functions."));
        python.add(new Question("p2","What is the type of [] in Python?",
                Arrays.asList("list","tuple","dict","set"),0,
                "[] creates a list."));
        python.add(new Question("p3","Which symbol starts a comment?",
                Arrays.asList("//","#","/*","--"),1,
                "# starts a single-line comment in Python."));
        python.add(new Question("p4","Which method adds an item to end of list?",
                Arrays.asList("add()","append()","push()","insert()"),1,
                "list.append(x) appends x at the end."));
        python.add(new Question("p5","Which keyword creates an anonymous function?",
                Arrays.asList("lambda","anon","func","def"),0,
                "lambda creates small anonymous functions."));
        python.add(new Question("p6","What does 'len' return for a string?",
                Arrays.asList("characters count","bytes used","memory size","hash"),0,
                "len(s) returns number of characters."));
        python.add(new Question("p7","How do you handle exceptions?",
                Arrays.asList("try/except","catch/throw","trap/rescue","except only"),0,
                "Use try/except blocks in Python."));
        python.add(new Question("p8","What is a Python dictionary?",
                Arrays.asList("ordered sequence","hash map of key->value","list of lists","file"),1,
                "A dict maps keys to values (hash map)."));
        python.add(new Question("p9","Which statement imports a module?",
                Arrays.asList("require math","import math","include math","using math"),1,
                "import math loads the math module."));
        python.add(new Question("p10","Which is true about Python variables?",
                Arrays.asList("Static typed","Dynamically typed","Not typed","Compile-time typed"),1,
                "Python is dynamically typed; types are checked at runtime."));
        banks.put("python", python);

        // --- WEBDEV BANK ---
        List<Question> webdev = new ArrayList<>();
        webdev.add(new Question("w1","HTML stands for?",
                Arrays.asList("HyperText Markup Language","Home Tool Markup","Hyperlinks Text Markup","HighText Markup"),0,
                "HTML = HyperText Markup Language."));
        webdev.add(new Question("w2","Which tag for a paragraph?",
                Arrays.asList("<p>","<para>","<text>","<pgraph>"),0,
                "<p> defines a paragraph."));
        webdev.add(new Question("w3","CSS property to change text color?",
                Arrays.asList("color","text-color","font-color","fg"),0,
                "Use 'color' to change font color in CSS."));
        webdev.add(new Question("w4","Which is JS strict equality operator?",
                Arrays.asList("==","=","===","!=="),2,
                "=== compares value and type."));
        webdev.add(new Question("w5","DOM stands for?",
                Arrays.asList("Document Object Model","Digital Object Map","Data Object Model","Document Order Model"),0,
                "The DOM is the Document Object Model."));
        webdev.add(new Question("w6","Which tag for external JS file?",
                Arrays.asList("<script src='...'>","<js src='...'>","<include src='...'>","<link src='...'>"),0,
                "Use <script src='file.js'></script> to include JS."));
        webdev.add(new Question("w7","Which HTTP status means OK?",
                Arrays.asList("200","404","500","301"),0,
                "200 is OK; 404 is Not Found, 500 server error."));
        webdev.add(new Question("w8","Which attribute sets image source?",
                Arrays.asList("href","src","link","path"),1,
                "Use src='...' for images."));
        webdev.add(new Question("w9","Which CSS displays items in a flex row?",
                Arrays.asList("display:block","display:flex","display:grid","display:inline"),1,
                "display:flex enables flex layout."));
        webdev.add(new Question("w10","Which method adds a child node in JS DOM?",
                Arrays.asList("appendChild","addChild","pushChild","attachChild"),0,
                "appendChild attaches a child node to an element."));
        banks.put("webdev", webdev);

        // --- GK BANK ---
        List<Question> gk = new ArrayList<>();
        gk.add(new Question("g1","Who proposed theory of relativity?",
                Arrays.asList("Newton","Einstein","Galileo","Maxwell"),1,
                "Albert Einstein proposed the theory of relativity."));
        gk.add(new Question("g2","What is the capital of Japan?",
                Arrays.asList("Seoul","Tokyo","Kyoto","Osaka"),1,
                "Tokyo is Japan's capital."));
        gk.add(new Question("g3","Which planet is known as Red Planet?",
                Arrays.asList("Venus","Mars","Jupiter","Saturn"),1,
                "Mars is the Red Planet."));
        gk.add(new Question("g4","Who wrote 'Hamlet'?",
                Arrays.asList("Shakespeare","Dickens","Austen","Tolstoy"),0,
                "William Shakespeare wrote Hamlet."));
        gk.add(new Question("g5","Which gas is most abundant in Earth's atmosphere?",
                Arrays.asList("Oxygen","Nitrogen","Carbon dioxide","Helium"),1,
                "Nitrogen makes up ~78% of atmosphere."));
        gk.add(new Question("g6","Which ocean is largest?",
                Arrays.asList("Atlantic","Pacific","Indian","Arctic"),1,
                "Pacific Ocean is the largest."));
        gk.add(new Question("g7","Which country gifted Statue of Liberty?",
                Arrays.asList("France","England","Spain","Germany"),0,
                "France gifted it to the USA."));
        gk.add(new Question("g8","Which metal has highest conductivity?",
                Arrays.asList("Copper","Silver","Gold","Aluminium"),1,
                "Silver has the highest electrical conductivity."));
        gk.add(new Question("g9","What year did WW2 end?",
                Arrays.asList("1945","1939","1918","1950"),0,
                "World War II ended in 1945."));
        gk.add(new Question("g10","What is H2O?",
                Arrays.asList("Hydrogen peroxide","Water","Salt","Oxygen"),1,
                "H2O is the chemical formula for water."));
        banks.put("gk", gk);

        // combine all into "misc" for surprise/mixed
        List<Question> combined = new ArrayList<>();
        for (List<Question> list : banks.values()) combined.addAll(list);
        banks.put("misc", combined);
    }

    public List<Question> getQuestions(String cat, int num) {
        String key = (cat == null) ? "java" : cat.toLowerCase();
        List<Question> src = banks.getOrDefault(key, banks.get("java"));
        // copy and shuffle
        List<Question> copy = new ArrayList<>(src);
        Collections.shuffle(copy);
        if (num >= copy.size()) return new ArrayList<>(copy);
        return new ArrayList<>(copy.subList(0, num));
    }
}
