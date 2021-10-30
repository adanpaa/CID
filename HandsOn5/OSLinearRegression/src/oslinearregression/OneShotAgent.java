package oslinearregression;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import javax.swing.JOptionPane;

public class OneShotAgent extends Agent {

    @Override
    protected void setup() {
        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new MyOneShotBehaviour());
    }

    private class MyOneShotBehaviour extends OneShotBehaviour {

        @Override
        public void action() {
            LinearRegression object = new LinearRegression();
            object.setAdvertising(Integer.valueOf(JOptionPane.showInputDialog("Insert value for X: ")));
            object.gradientDescent();
            object.LinearRegression();
            System.out.println("y = B0 + B1X1");
            System.out.println("y = " + String.valueOf(object.getB0()) + 
                " + (" + String.valueOf(object.getB1()) +
                ")("+String.valueOf(object.getAdvertising()) + ")");
            System.out.println("y = " + String.valueOf(object.getSales()));
        }

        @Override
        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    }
}