package com.game.rummyGame.play;

import java.util.LinkedList;

public class Cards 
{
	//There are four suits in a Deck of cards
			//and that's a fixed number so making it's value as final and static.
		private static final String RANK[] = {"Spades", "Diamonds", "Hearts", "Clubs"};
			
			//Ranks of each card in a deck is also fixed
			//So making this also final and static
		private static final String SUIT[] = {"ACE", "2", "3", "4", "5", "6", "7",
	            "8", "9", "10", "JACK", "QUEEN", "KING"};
			
		

		//deck is a list which contains total number of cards
		private static LinkedList<String> deck = new LinkedList<>();


		public static void setDeck()
		{
			deck.clear();
			
			for (int  i= 0; i < SUIT.length; i++)
			{
				for (int j = 0; j < RANK.length ; j++)
				{
					deck.add(SUIT[i] + " of " + RANK[j]);
				}
			}
		}
		
		public static LinkedList<String> getDeck() 
		{
			return deck;
		}
}


