import javax.swing.*;
import java.util.LinkedList;

public class Prefix_to_Postfix {

     public static boolean operand(String s){

         if(s.charAt(0) == '*' || s.charAt(0) == '/' || s.charAt(0) == '^' || s.charAt(0) == '+' || s.charAt(0) == '-')
         {

             return false;

         }

         return true;

    }

    public static String Prefix_Converse_Postfix( String Prefix, JTextArea StackPrint,JTextArea OutputPrint){

        OutputPrint.append("Prefix : " +Prefix+'\n');

        ArrayStack stack = new ArrayStack(Prefix.length());

        String a,b,Test = null;

        for (int i = 0;i<Prefix.length();i++){

            Test="" + Prefix.charAt(i);

            if (!operand(Test)) {

                stack.push(Test);

                StackPrint.append("Stack : " +Test +'\n');

            }

            else {

                if (operand(stack.Top())){

                    a = stack.pop();

                    b = stack.pop();

                    Test =  a + Test +b;

                    OutputPrint.append("Output : " + Test +'\n');

                }

                stack.push(Test);

                StackPrint.append("Stack : " + Test +'\n');

            }

        }

        return stack.pop();

    }

}
