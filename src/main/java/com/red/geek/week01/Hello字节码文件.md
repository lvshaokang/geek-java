- 源文件
```java
public class Hello {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = a + b;
        int d = c - 1;
        int e = d * 2;
        int f = e / 3;
        for (int i =  0; i < c; i ++) {
            if (i < f) {
                System.out.println(b);
            }
        }
    }
}
```  
- 字节码文件
```
Classfile /D:/lamp/ruozedata/workspace/project/geek-university/geek-java/target/classes/com/red/geek/week01/Hello.class
  Last modified 2021-3-20; size 756 bytes
  MD5 checksum e78d7f3199884214fd3981f0a60a92de
  Compiled from "Hello.java"
public class com.red.geek.week01.Hello
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #5.#29         // java/lang/Object."<init>":()V
   #2 = Fieldref           #30.#31        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = Methodref          #32.#33        // java/io/PrintStream.println:(I)V
   #4 = Class              #34            // com/red/geek/week01/Hello
   #5 = Class              #35            // java/lang/Object
   #6 = Utf8               <init>
   #7 = Utf8               ()V
   #8 = Utf8               Code
   #9 = Utf8               LineNumberTable
  #10 = Utf8               LocalVariableTable
  #11 = Utf8               this
  #12 = Utf8               Lcom/red/geek/week01/Hello;
  #13 = Utf8               main
  #14 = Utf8               ([Ljava/lang/String;)V
  #15 = Utf8               i
  #16 = Utf8               I
  #17 = Utf8               args
  #18 = Utf8               [Ljava/lang/String;
  #19 = Utf8               a
  #20 = Utf8               b
  #21 = Utf8               c
  #22 = Utf8               d
  #23 = Utf8               e
  #24 = Utf8               f
  #25 = Utf8               StackMapTable
  #26 = Class              #18            // "[Ljava/lang/String;"
  #27 = Utf8               SourceFile
  #28 = Utf8               Hello.java
  #29 = NameAndType        #6:#7          // "<init>":()V
  #30 = Class              #36            // java/lang/System
  #31 = NameAndType        #37:#38        // out:Ljava/io/PrintStream;
  #32 = Class              #39            // java/io/PrintStream
  #33 = NameAndType        #40:#41        // println:(I)V
  #34 = Utf8               com/red/geek/week01/Hello
  #35 = Utf8               java/lang/Object
  #36 = Utf8               java/lang/System
  #37 = Utf8               out
  #38 = Utf8               Ljava/io/PrintStream;
  #39 = Utf8               java/io/PrintStream
  #40 = Utf8               println
  #41 = Utf8               (I)V
{
  public com.red.geek.week01.Hello();
    descriptor: ()V 构造方法
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 10: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcom/red/geek/week01/Hello;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=8, args_size=1 操作数栈最大深度2，局部变量最大槽数8，字节码长度55
         0: iconst_1 常量1压入操作数栈 1
         1: istore_1 弹出操作数栈栈顶元素，存到本地变量表的第1个slot a=1
         2: iconst_2 常量2压入操作数栈 2
         3: istore_2 弹出操作数栈栈顶元素，存到本地变量表的第2个slot b=2
         4: iload_1 从本地变量表中加载第1个slot，压入操作数栈 1
         5: iload_2 从本地变量表中加载第2个slot，压入操作数栈 2
         6: iadd 栈顶两个元素出栈，相加，结果再入栈 3
         7: istore_3 弹出操作数栈栈顶元素，存到本地变量表的第3个slot c=3
         8: iload_3 从本地变量表中加载第3个slot，压入操作数栈 3
         9: iconst_1 常量1压入操作数栈 1
        10: isub 栈顶两个元素出栈，相加，结果再入栈 2
        11: istore        4 弹出操作数栈栈顶元素，存到本地变量表的第4个slot d=2
        13: iload         4 从本地变量表中加载第4个slot，压入操作数栈 2
        15: iconst_2 常量2压入操作数栈 2 
        16: imul 相乘 栈顶两个元素出栈，相乘，结果再入栈 4
        17: istore        5 弹出操作数栈栈顶元素，存到本地变量表的第5个slot e=4
        19: iload         5 从本地变量表中加载第5个slot，压入操作数栈 4
        21: iconst_3 常量3压入操作数栈 3 
        22: idiv 相除 栈顶两个元素出栈，相除，结果再入栈 4/3= int 1
        23: istore        6 弹出操作数栈栈顶元素，存到本地变量表的第6个slot f=1
        25: iconst_0 常量0压入操作数栈 0
        26: istore        7 弹出操作数栈栈顶元素，存到本地变量表的第7个slot i=0
        28: iload         7 从本地变量表中加载第7个slot，压入操作数栈 0
        30: iload_3 从本地变量表中加载第3个slot，压入操作数栈 3
        31: if_icmpge     54 如果大于，跳到54偏移量
        34: iload         7 从本地变量表中加载第7个slot，i，压入操作数栈 0
        36: iload         6 从本地变量表中加载第6个slot，f，压入操作数栈 1
        38: if_icmpge     48 如果大于，跳到48偏移量
        41: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        44: iload_2
        45: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
        48: iinc          7, 1 // 以常数1，递增本地变量表中的第7个slot的变量 i
        51: goto          28 以新的变量值，到28偏移量，
        54: return
      LineNumberTable:
        line 12: 0
        line 13: 2
        line 14: 4
        line 15: 8
        line 16: 13
        line 17: 19
        line 18: 25
        line 19: 34
        line 20: 41
        line 18: 48
        line 23: 54
      LocalVariableTable: 本地变量表
        Start  Length  Slot  Name   Signature
           28      26     7     i   I
            0      55     0  args   [Ljava/lang/String;
            2      53     1     a   I
            4      51     2     b   I
            8      47     3     c   I
           13      42     4     d   I
           19      36     5     e   I
           25      30     6     f   I
      StackMapTable: number_of_entries = 3
        frame_type = 255 /* full_frame */
          offset_delta = 28
          locals = [ class "[Ljava/lang/String;", int, int, int, int, int, int, int ]
          stack = []
        frame_type = 19 /* same */
        frame_type = 250 /* chop */
          offset_delta = 5
}
SourceFile: "Hello.java"

Process finished with exit code 0```