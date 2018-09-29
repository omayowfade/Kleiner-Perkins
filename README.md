# Kleiner-Perkins
Deviation- The Game of Champions 

Instructions for running the code:
  1)	Enter the KPCG file directory
  2)	Enter the following command: cd src/com/company && javac Main.java && cd ../.. && java com.company.Main
  3)	At the end of the game, you will be asked whether you want to continue playing. If you wish to continue playing, press Y. Otherwise, you can quit by pressing N or pressing CTRL-C at any point in the game.

Rules:
(THIS GAME IS SINGLE_PLAYER)
The goal of Deviation is to successfully predict different attributes about the next drawn card from a deck through three consecutive steps (input is case insensitive).

Procedure:
1)	Guess the color of next drawn card (RED or BLACK)
2)	Guess whether the suite of the next drawn card is higher or lower than the previously drawn card (H or L)
3)	Guess the suit of the card (SPADES, HEARTS, DIAMONDS, or CLUBS)

Notes: 
  If you guess incorrectly at any point throughout steps 1, 2, and 3, you will be returned to step 1 and receive a scoring penalty. The LOWER you score, the better you are at Deviation. The scoring rubric is listed below.

Scoring Rubric:
  Guess incorrectly on:
  Step 1: score increased by 3
  Step 2: score increase by 2
  Step 3: score increase by 1


Design choices:
  Within the parameters of the project, making a random card into its own class called “RandomCard” made sense. Doing so abstracted some of the functionality of the random cards and provided more organization in the project. 

  I also decided to split the program into three major portions representing the steps of the Deviation game. This provided clear flow to the project.

Choice of tooling:
  •	Java - Internal Libraries: ‘package com.company’, ‘java.util’
    o	Easy object-oriented structure very useful in building card functionality
    o	All-inclusive tools for catching user input and output, respectively.
  •	Terminal Shell
	
Data Structures & Algorithms used:
  •	Lists – store static data for card attributes
  •	Class Structure – “RandomCard”, Step program structure

External Libraries:
  •	(None)
Tests:
  •	(None)

