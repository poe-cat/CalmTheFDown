package markov;

import java.util.*;

public class MDP {

        private final State[] states;
        private final Action[] actions;
        private final Double[][][] transitionProbabilities;
        private final Double[][][] rewards;
        private final double discountFactor;
        private final double[] values;
        private final double epsilon = 0.0001;
        private final int numStates;
        private final int numActions;

        public MDP(State[] states, Action[] actions, Double[][][] transitionProbabilities, Double[][][] rewards,
                   double discountFactor) {

            this.states = states;
            this.actions = actions;
            this.transitionProbabilities = transitionProbabilities;
            this.rewards = rewards;
            this.discountFactor = discountFactor;
            this.numStates = states.length;
            this.numActions = actions.length;
            this.values = new double[numStates];
            Arrays.fill(values, 0.0);
        }


    public void valueIteration(double epsilon) {

            double delta = Double.MAX_VALUE;

            while (delta > epsilon) {
                delta = 0.0;
                for (int s = 0; s < numStates; s++) {
                    double v = values[s];
                    double maxV = Double.NEGATIVE_INFINITY;
                    for (int a = 0; a < numActions; a++) {
                        double q = 0.0;
                        for (int sPrime = 0; sPrime < numStates; sPrime++) {

                            // wrong!!
                            q += transitionProbabilities[a][s][sPrime] * (rewards[s][a][sPrime] +
                                    discountFactor * values[sPrime]);
                        }
                        maxV = Math.max(maxV, q);
                    }
                    values[s] = maxV;
                    delta = Math.max(delta, Math.abs(v - values[s]));
                }
            }
        }

        public void printOptimalPolicy() {

            System.out.println("Optimal policy:");

            for (int s = 0; s < numStates; s++) {
                int bestAction = 0;
                double bestValue = Double.NEGATIVE_INFINITY;
                for (int a = 0; a < numActions; a++) {
                    double value = 0.0;
                    for (int sPrime = 0; sPrime < numStates; sPrime++) {
                        value += transitionProbabilities[a][s][sPrime] * (rewards[s][a][sPrime]
                                + discountFactor * values[sPrime]);
                    }
                    if (value > bestValue) {
                        bestValue = value;
                        bestAction = a;
                    }
                }
                System.out.println("State " + s + ": Action " + bestAction);
            }
        }
    }