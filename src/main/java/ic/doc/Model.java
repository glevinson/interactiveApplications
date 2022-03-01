package ic.doc;

import java.util.Objects;
import java.util.Stack;

public class Model {
        Stack<Integer> numberList = new Stack<Integer>();
        View view;
        public void addNumberToStack(int i){
            numberList.push(i);
            view.change(i);
        }
        public void findResult(String a){
            int num1 = numberList.pop();
            int num2 = numberList.pop();

            switch (a){
                case "+" -> addNumberToStack(num1+num2);
                case "-" -> addNumberToStack(num2 -num1);
                case "*" -> addNumberToStack(num2 * num1);
                case "/" -> addNumberToStack(num2 / num1);
                }
            }



    public void setView(View view) {
            this.view = view;
    }
}
