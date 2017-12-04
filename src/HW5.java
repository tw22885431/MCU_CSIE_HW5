import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.atomic.AtomicReference;

public class HW5 {
    public JPanel panel1;
    public JTabbedPane Tabble;
    public JTextField Prefix1;
    public JButton InfixPrefixButton;
    public JTextField Infix1;
    public JTextField Infix2;
    public JTextField Postfix1;
    public JTextField Prefix2;
    public JTextField Postfix2;
    public JTextArea Tracing;
    public JTextArea Stack;
    public JButton InfixPostfixButton;
    public JButton PrefixPostfixButton;

    public String Input;

    public HW5(){

        Infix_to_Postfix_or_Prefix Infix_Converse = new Infix_to_Postfix_or_Prefix();

        Prefix_to_Postfix Prefix_Converse = new Prefix_to_Postfix();

        InfixPrefixButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent actionEvent) {

                Stack.setText("");

                Tracing.setText("");

                Input = Infix1.getText();

                if (Input.charAt(0) != '*' || Input.charAt(0) != '/' || Input.charAt(0) != '|' || Input.charAt(0) != '+' || Input.charAt(0) != '-')

                    Prefix1.setText(Infix_Converse.toPrefix(Input, Stack, Tracing));

                 else

                    JOptionPane.showMessageDialog(null,"輸入錯誤");

            }

        });

        InfixPostfixButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent actionEvent) {

                Tracing.setText("");

                Stack.setText("");

                Input = Infix2.getText();

                if (Input.charAt(0) != '*' || Input.charAt(0) != '/' || Input.charAt(0) != '|'||Input.charAt(0) != '+' || Input.charAt(0) != '-')

                    Postfix1.setText(Infix_Converse.toPostfix(Input,Stack,Tracing));

                else

                    JOptionPane.showMessageDialog(null,"輸入錯誤");

            }

        });


        PrefixPostfixButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent actionEvent) {

                Input = Prefix2.getText();

                Stack.setText("");

                Tracing.setText("");

                Postfix2.setText(Prefix_Converse.Prefix_Converse_Postfix(Input,Stack,Tracing));

            }

        });

    }

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null,"作者 : 吳浩綸 \n時間 : 2017/11/29 \n版本 : 1.0\n學號 : 05361122");

        JFrame frame = new JFrame("HW5 by 吳浩綸");

        frame.setContentPane(new HW5().panel1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();

        frame.setVisible(true);

    }



}
