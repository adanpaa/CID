package examples.behaviours;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import java.util.*;
import java.lang.Math;


public class OneShotAgent extends Agent {

    protected void setup() {
        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new MyOneShotBehaviour());
    }

    private class MyOneShotBehaviour extends OneShotBehaviour {

        public void action() {
            ArrayList<Double> bounds = new ArrayList<>();
            ArrayList<Double> best_score = new ArrayList<>();
            bounds.add(-1.0);
            bounds.add(1.0);
            int n_iter = 30;
            double step_size = 1.0;

            best_score = gradient_descent(bounds, n_iter, step_size);
            System.out.println("Done!");
            System.out.println("f("+ best_score.get(0) +") = " + best_score.get(1));
        }

        public double objective(double x){
            return x*x;
        }

        public double derivative(double x){
            return x * 2.0;
        }

        public ArrayList<Double> gradient_descent(ArrayList<Double> bounds, int n_iter, double step_size) {
           double solution = bounds.get(0) + Math.random() * bounds.get(1) - bounds.get(0);
           double gradient = 0.0;
           double solution_eval = 0.0;
           for(int i = 0; i < n_iter; i++){
               gradient = derivative(solution);
               solution = solution - step_size * gradient;
               solution_eval = objective(solution);
           }
           ArrayList<Double> result = new ArrayList<>();
           result.add(solution);
           result.add(solution_eval);
           return result;
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    }
}

