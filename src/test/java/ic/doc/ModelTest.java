package ic.doc;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Test;

public class ModelTest {

    public JUnitRuleMockery context = new JUnitRuleMockery();
    Model model = new Model();

    View viewMock = context.mock(View.class);


    @Test
    public void doesNotCalculateIfStackIsSmallerThanTwo(){

        context.checking(new Expectations(){{
            never(viewMock);
        }});

        model.findResult("+");

    }

}
