# CalmTheFDown - LEARNING Markov algorithm

## Table of contents
* [Technologies](#technologies)
* [General info](#general-info)
* [Markov algorithm](#markov-algorithm)

## Technologies
Project is created with:
* Java version: 17
* Apache Maven 3.8.6

## General info
Markov algorithm is not the best approach for life events solutions, but still attention worthy.

So pproach is to use decision-making algorithms, such as Markov decision processes, to model some random couple's decision-making process and suggest actions to improve their well-being.

The State space represents the different states the system can be in. In the case of the couple's problem, the State space could include different combinations of the couple's financial and health status, such as "financially stable and good health," "financially unstable and good health," "financially stable and poor health," and "financially unstable and poor health."

The Action space represents the different actions the couple can take to improve their well-being, such as reducing expenses, seeking better medical care, or seeking social support.

The transition probabilities represent the probability of moving from one state to another when an action is taken. For example, if the couple seeks better medical care, the probability of moving from the "poor health" state to the "good health" state could be modeled as a transition probability.

The reward function represents the value or utility the couple receives for being in a particular state or taking a particular action. For example, the reward for being in the "financially stable and good health" state could be higher than the reward for being in the "financially unstable and poor health" state.

Once we have defined the state space, action space, transition probabilities, and reward function, we can use a Markov decision process algorithm to determine the optimal actions the couple should take to maximize their well-being.

## Markov algorithm
Markov chain is a systematic method for generating a sequence of random variables where the current value is probabilistically dependent on the value of the prior variable. Specifically, selecting the next variable is only dependent upon the last variable in the chain.
