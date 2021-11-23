package oslinearregression;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class OneShotAgent extends Agent {

    @Override
    protected void setup() {
        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new MyOneShotBehaviour());
    }

    private class MyOneShotBehaviour extends OneShotBehaviour {

        @Override
        public void action() {
            LogisticRegression object = new LogisticRegression();
            object.LogisticRegression();
            System.out.println("w = (" + object.getw0() + ", " + object.getw1() + ", " +  object.getw2() + ")");
        }

        @Override
        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    }
}