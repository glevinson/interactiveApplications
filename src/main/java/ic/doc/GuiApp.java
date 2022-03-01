package ic.doc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuiApp {

    Model calc = new Model();

    String[] operators = {"+", "-", "*", "/"};

    private void display() {
        JFrame frame = new JFrame("RPN App");
        frame.setSize(600,400);

        JPanel panel = new JPanel();
        JTextField textField = new JTextField(10);
        panel.add(textField);

        for (int i = 0; i < 10; i++){
            JButton number = new JButton(String.valueOf(i));
            int finalI = i;
            number.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    textField.setText(String.valueOf(finalI));
                    calc.addNumberToStack(finalI);
                }
            });

            panel.add(number);
        }

        for(int i = 0; i < operators.length; i++){
            JButton operator = new JButton(operators[i]);
            int finalI = i;
            operator.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if(calc.numberList.size() >= 2){
                        int result = calc.findResult(operators[finalI]);
                        textField.setText(String.valueOf(result));
                        calc.addNumberToStack(result);
                    }
                }
            });
            panel.add(operator);
        }

        frame.getContentPane().add(panel);
        frame.setVisible(true);

    }

    public static void main(String[] args){
        new GuiApp().display();
    }
}
