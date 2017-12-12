# programming-fundamentals
Personal Work on Java 
## What is Farash? 

Farash is a Nepalese take on Poker. Instead of a hand with 5 hands in classical poker, there are only hands of three in farash.
After the hands has been distributed, there is a process of evaluation and the player with best hands wins the game. There is also
a version with betting after each round called chali Farash. 

## How are hands evaluated? 

Evaluation of hands is done on the basis of following fundamentals. 

### Trials 

Trials occur when all three cards in the hands are of same rank. Trials lie in the topmost of evaluation hiararchy. In case only one of
the player has got a trial, s/he wins the game automatically. In case two or more players have got the trial, the highest ranks is used 
to select the winner ( 2 being the lowest and Ace being the highest). 

### Runs 

If nobody has got a trial, runs are used to identify the winner. Runs means the ranks of three cards in a hand are consecutive. If no player
has a trial, the player with run wins the hands. In case of two players getting a run, the rank of highest card is used to select winner. 

### Pairs 

In case no player is able to get runs or trials, pairs are used to select a winner. Pairs is a condition when two of the three cards in the 
hand are of same rank. In case of two or more players have a pair, the pair with highest rank breaks the tie. 

### Highest Card 

In case no player is able to find any of the aforementioned condition, the highest card in the hands of three decides the tie. In case 
two players have the same card as highest, the priority is given to the second highest card and so on. 

## Extra Features 

You can bet on each round. 


