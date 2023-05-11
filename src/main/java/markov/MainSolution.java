package markov;

class MainSolution {

        public static void main(String[] args) {

            State[] states = new State[] {
                    new State("financially stable and good health", 0),
                    new State("financially unstable and good health", 1),
                    new State("financially stable and poor health", 2),
                    new State("financially unstable and poor health", 3)
            };

            Action[] actions = new Action[]{
                    new Action("Cut expenses", 1),
                    new Action("Seek additional income", 1)
            };

            Double[][][] transitionProbabilities = new Double[][][] {
                    {
                            {0.7, 0.3, 0.0, 0.0},
                            {0.7, 0.3, 0.0, 0.0},
                            {0.7, 0.0, 0.3, 0.0},
                            {0.7, 0.0, 0.3, 0.0}
                    },
                    {
                            {0.3, 0.7, 0.0, 0.0},
                            {0.3, 0.7, 0.0, 0.0},
                            {0.0, 0.3, 0.7, 0.0},
                            {0.0, 0.3, 0.7, 0.0}
                    }
            };

            Double[][][] rewards = new Double[][][] {
                    { {-2.0, -2.0, -1.0, -1.0} },
                    { {-3.0, -3.0, -2.0, -2.0} },
                    { {-3.0, -3.0,-2.0, -2.0} }
            };


            MDP mdp = new MDP(states, actions, transitionProbabilities, rewards, 0.9);
            mdp.valueIteration(0.0001);
            mdp.printOptimalPolicy();
        }
}
