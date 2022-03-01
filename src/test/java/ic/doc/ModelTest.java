package ic.doc;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class ModelTest {

    public JUnitRuleMockery context = new JUnitRuleMockery();
    Model model = new Model();
    View viewMock = context.mock(View.class);

    @Test
    public void doesNotCalculateIfStackIsSmallerThanTwo() {

        context.checking(new Expectations() {{
            never(viewMock);
        }});

        model.findResult("+");

    }

    @Test
    public void canSetView() {
        GuiApp app = new GuiApp();
        model.setView(app);
    }

    @Test
    public void canAddTwoNumbers() {
        GuiApp app = new GuiApp();
        model.setView(app);
        model.addNumberToStack(4);
        model.addNumberToStack(3);
        model.findResult("+");

        assertThat(String.valueOf(model.numberList.peek()), is("7"));

    }

    @Test
    public void canMultiplyTwoNumbers() {
        GuiApp app = new GuiApp();
        model.setView(app);
        model.addNumberToStack(4);
        model.addNumberToStack(3);
        model.findResult("*");

        assertThat(String.valueOf(model.numberList.peek()), is("12"));

    }

    @Test
    public void canSubtractTwoNumbers() {
        GuiApp app = new GuiApp();
        model.setView(app);
        model.addNumberToStack(4);
        model.addNumberToStack(3);
        model.findResult("-");

        assertThat(String.valueOf(model.numberList.peek()), is("1"));

    }


    @Test
    public void canDivideTwoNumbers() {
        GuiApp app = new GuiApp();
        model.setView(app);
        model.addNumberToStack(4);
        model.addNumberToStack(2);
        model.findResult("/");

        assertThat(String.valueOf(model.numberList.peek()), is("2"));

    }

    @Test
    public void canDoOperationsOnStack() {
        GuiApp app = new GuiApp();
        model.setView(app);
        model.addNumberToStack(4);
        model.addNumberToStack(2);
        model.addNumberToStack(1);
        model.addNumberToStack(4);
        model.addNumberToStack(2);
        model.findResult("+");
        assertThat(String.valueOf(model.numberList.peek()), is("6"));
        model.findResult("+");
        assertThat(String.valueOf(model.numberList.peek()), is("7"));
        model.findResult("*");
        assertThat(String.valueOf(model.numberList.peek()), is("14"));

    }


}
