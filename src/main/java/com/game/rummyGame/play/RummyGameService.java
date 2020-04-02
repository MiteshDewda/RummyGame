package com.game.rummyGame.play;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RummyGameService 
{	
	public static List<String> playerOne = new ArrayList<>();
	public static List<String> playerTwo = new ArrayList<>(); 
	
	//There are four suits in a Deck of cards
		//and that's a fixed number so making it's value as final and static.
	public static final String RANK[] = {"Spades", "Diamonds", "Hearts", "Clubs"};
		
		//Ranks of each card in a deck is also fixed
		//So making this also final and static
	public static final String SUIT[] = {"ACE", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "JACK", "QUEEN", "KING"};

	public static List<List<String>> sequenceOfCards = new ArrayList<>();
	
		
	//deck is a list which contains total number of cards
	public static LinkedList<String> deck;

	public static int chance = 0;
	public static int k;
	public static int count = 1;
	public static boolean playerOneCardRemoved = false;
	public static boolean playerTwoCardRemoved = false;
	
	//preparing the deck
	public static void makeDeck()
	{
		Cards.setDeck();
	}
	
	//returning the prepared deck
	//Initially when the program executes, this method will return 52 cards
	//but once shuffleAnddeal gets called, this method will return cards left
	//in the deck after subtracting playerOne and playerTwo cards.
	public static LinkedList<String> getDeck()
	{
		deck = Cards.getDeck();
		if(!playerOne.isEmpty())
			deck.removeAll(playerOne);
		if(!playerTwo.isEmpty())
			deck.removeAll(playerTwo);
		return deck;
	}

	//shuffling the deck and distributing cards to players
	public static String shuffleAnddeal(LinkedList<String> cardsDeck)
	{
		if(chance > 0)
		{
			Collections.shuffle(cardsDeck);
			deck = cardsDeck;
			return "Cards shuffled in the remaining deck but not distributed to players";
		}
		else
		{
			Random random1 = new Random();
			
			chance++;
			
			while(cardsDeck.size() != 0)
			{
				k = random1.nextInt(cardsDeck.size());
				
				String l = cardsDeck.get(k);
				if ((count-1) % 4 == 0) 
				{
					playerOne.add(l);
				}
				if ((count-2) % 4 == 0) 
				{
					playerTwo.add(l);
				}
				
				++count;
				cardsDeck.remove(k);
			}
			
			return "Cards has been shuffled and distributed to players.<br>"
					+ "You may check each player cards using <b>/cards/playerOneCards</b> and <b>/cards/playerTwoCards</b> endpoints";
		}
	}
	
	//This will allow each player to pick a card from the remaining deck
	public static String pickACard(String player, LinkedList<String> cardsDeck)
	{
		String top = cardsDeck.poll();
		if(player.equals("playerOne"))
		{
			if(playerOne.size() < 13)
			{
				playerOne.add(top);
				return top + " added to " + player;
			}
			else
				return player + " already has 13 cards.";
		}
		else if(player.equals("playerTwo"))
		{
			if(playerTwo.size() < 13)
			{
				playerTwo.add(top);
				return top + " added to " + player;
			}
			else
				return player + " already has 13 cards.";
		}
		else
			return "Please type player name as - <b> playerOne </b> OR <b> playerTwo </b>";
	}
	
	//this method will allow playeOne to discard a card
	public static String removeCardFromPlayerOne(String card)
	{
		if(playerOne.isEmpty() || !playerOne.contains(card))
			return "Either PlayerOne doesn't has any cards Or PlayerOne is not holding the specified card";
		else
		{
			playerOne.remove(card);
			playerOneCardRemoved = true;
			return card + " has been removed from PlayerOne";
		}
	}
	
	//this method will allow playerTwo to discard a card
	public static String removeCardFromPlayerTwo(String card)
	{
		if(playerTwo.isEmpty() || !playerTwo.contains(card))
			return "Either PlayerTwo doesn't has any cards Or PlayerTwo is not holding the specified card";
		else
		{
			playerTwo.remove(card);
			playerTwoCardRemoved = true;
			return card + " has been removed from PlayerTwo";
		}
	}
	
	//This method will be called when PlayerOne opens his/her cards
	public static List<String> getPlayerOneCards()
	{
		Collections.sort(playerOne);
		return playerOne;
	}
	
	//This method will be called when PlayerOne opens his/her cards
	public static List<String> getPlayerTwoCards()
	{
		Collections.sort(playerTwo);
		return playerTwo;
	}
}
