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
            knn object = new knn();
            object.knn(Double.valueOf(JOptionPane.showInputDialog("Insert value for Height: ")), Double.valueOf(JOptionPane.showInputDialog("Insert value for Age: ")), Integer.valueOf(JOptionPane.showInputDialog("Insert value for K: ")));
            System.out.println("Weight = " + object.getWeight());
        }

        @Override
        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    }
}