# Travelling Salesman Problem
Travelling salesman problem – Given a list of cities and the distances between each pair of cities, what is the shortest possible route that visits each city and returns to the origin city.
Created a loss function a fitness function in this case, which would take a tour of n cities (basically a list of cities to visit), the distance between each cities and would give the length of all the cities, I then had to minimise this function. 

RMHC – Random Mutation Hill Climbing 
standard hill climbing approach where optima (solution) are found by exploring a solution space, chooses an initial solution at random and then does a small change, in this case swapping two cities and then based on the result moves in the direction of increased fitness on each iteration

RRHC – Random Restart Hill Climbing 
It iteratively does hill-climbing, each time with a random initial condition, The best solution is kept: if a new run of hill climbing produces a better solution than the stored state, it replaces the stored state.

SHC – Stochastic Hill Climbing 
It selects a neighbour at random and decides (based on the amount of improvement in that neighbour) whether to move to that neighbour or to examine another.

SA – Simulated Annealing
The algorithm is basically hill-climbing except instead of picking the best move, it picks a random move.  If the selected move improves the solution, then it is always accepted.  Otherwise, the algorithm makes the move anyway with some probability less than 1.The probability decreases exponentially with the “badness” of the move, which is the amount deltaE by which the solution is worsened (i.e., energy is increased.) 

