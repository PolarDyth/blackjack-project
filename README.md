# Text based Blackjack

This is a text based program based on the card game Blackjack

## How to play

The aim of the game is to beat the dealer in getting the highest hand without exceeding 21.
Each card has a value an ace is either 1 or 11. By default the ace is 11 but if you go over 21 with an ace in your hand then it will go down to 1. Cards 2 throuh 10 are worth their respective number and the Jack, Queen, King are all worth 10.

Running the program will show you the initial card you drew, what you have in your hand and the current sum of cards in your hand. The program then asks you if you would like to hit (draw another card) or stand (don't draw another card) you need to respond in the console with either "hit" or "stand".
If you hit then you draw a card and that card is added to your hand. If you go over 21 then you go bust and lose, if you are under 21 you have the option to hit or stand again. 
If you stand then the dealer draws cards until they reach a value of 17 or higher. If the dealer goes bust and you haven't, you win. If the dealer has a higher value of cards than you and neither of you are bust, the dealer wins. If you have a higher value then you win.
