package markov;

import java.util.Arrays;

public class MarkovDecisionProcess {

    public static void main(String[] args) {

        State[] states = new State[]{
                new State("financially stable and good health", 0),
                new State("financially unstable and good health", 1),
                new State("financially stable and poor health", 2),
                new State("financially unstable and poor health", 3)
        };

        Action[] actions = new Action[] {
                new Action("reduce expenses", 0),
                new Action("find additional income", 1),
                new Action("do nothing", 2)
        };

        Double[][][] transitionProbabilities = new Double[][][]{
                {
                        {0.5, 0.2, 0.2, 0.1},
                        {0.4, 0.3, 0.2, 0.1},
                        {0.1, 0.1, 0.6, 0.2},
                        {0.1, 0.1, 0.3, 0.5}
                },
                {
                        {0.4, 0.3, 0.2, 0.1},
                        {0.2, 0.5, 0.2, 0.1},
                        {0.1, 0.1, 0.6, 0.2},
                        {0.1, 0.1, 0.3, 0.5}
                },
                {
                        {0.5, 0.2, 0.2, 0.1},
                        {0.4, 0.3, 0.2, 0.1},
                        {0.1, 0.1, 0.6, 0.2},
                        {0.1, 0.1, 0.3, 0.5}
                }
        };

        Double[][][] rewards = new Double[][][]{
                {
                        {-10.0, -50.0, -10.0, -50.0},
                        {-10.0, -50.0, -10.0, -50.0},
                        {-10.0, -50.0, -20.0, -50.0},
                        {-10.0, -50.0, -20.0, -50.0}
                },
                {
                        {-10.0, 10.0, -10.0, 10.0},
                        {-10.0, 10.0, -10.0, 10.0},
                        {-10.0, 10.0, -20.0, 10.0},
                        {-10.0, 10.0, -20.0, 10.0}
                },
                {
                        {10.0, -50.0, 10.0, -50.0},
                        {10.0, -50.0, 10.0, -50.0},
                        {10.0, -50.0, -20.0, -50.0},
                        {10.0, -50.0, -20.0, -50.0}
                }
        };

        MDP mdp = new MDP(states, actions, transitionProbabilities, rewards, 0.9);
        mdp.valueIteration(0.001);

    }
}

