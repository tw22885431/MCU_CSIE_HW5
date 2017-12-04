import javax.swing.*;
import java.util.LinkedList;

public class Infix_to_Postfix_or_Prefix {

    private static int priority( char c){

        return c == '+'|| c == '-' ? 1 : c == '*' || c == '/' ? 2 : c == '^' ? 3 : 0;

    }

    private static String toConverse( String infix , boolean isConverse,JTextArea StackPrint,JTextArea OutputPrint ){

        String Temp = isConverse ? infix : new StringBuffer(infix).reverse().toString();

        OutputPrint.append(isConverse ? Temp : infix +'\n' + "Reverse : " + Temp + '\n');

        LinkedList<Character> Stack = new LinkedList <>();

        StringBuilder Output = new StringBuilder();

        char toStack = isConverse ? '(' : ')';

        StackPrint.append("Stack : " + toStack+'\n');

        char toOutput = isConverse ? ')' : '(';

        for (char c : Temp.toCharArray()) {

            if (c == toStack) {

                Stack.add(c);

                StackPrint.append("Stack : " + Stack.toString()+'\n');

            }

            else if ("+-*/^".indexOf(c) != -1) {

                while (!Stack.isEmpty() && priority(Stack.getLast()) >= priority(c)) {

                    Output.append(Stack.removeLast());

                    OutputPrint.append("Output : " +Output.toString()+'\n');

                }

                Stack.add(c);

                StackPrint.append("Stack : " + Stack.toString()+'\n');

            } else if (c == toOutput) {

                while (Stack.getLast() != toStack) {

                    Output.append(Stack.removeLast());

                    OutputPrint.append("Output : " + Output.toString()+'\n');

                }

                Stack.removeLast();

                StackPrint.append("Stack : "+ Stack.toString()+'\n');

            } else {

                Output.append(c);

                OutputPrint.append("Output : " + Output.toString() +'\n');

            }

        }

        while(!Stack.isEmpty()) {

            Output.append(Stack.removeLast());

            OutputPrint.append("Output : "+ Output.toString()+'\n');

            StackPrint.append("Stack : " + Stack.toString());

        }

        OutputPrint.append("Output : " + ( isConverse ? Output.toString() : " Reverse : "+Output.reverse().toString())+'\n');

        return Output.toString();

    }

    public static String toPostfix( String infix ,JTextArea stack, JTextArea Output ){

        return toConverse(infix,true,stack,Output);

    }

    public static String toPrefix( String infix,JTextArea stack,JTextArea output){

        return toConverse(infix,false,stack,output);

    }

}