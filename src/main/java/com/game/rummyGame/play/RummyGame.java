package com.game.rummyGame.play;

import java.util.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RummyGame 
{
	private LinkedList<String> allCards = new LinkedList<>();
	
	@RequestMapping("/cards")
	public List<String> getAllCards()
	{
		if(allCards.isEmpty())
			RummyGameService.makeDeck();
		
		allCards = RummyGameService.getDeck();
		return allCards;
	}
	
	@RequestMapping("/cards/shuffleAndDeal")
	public String distributeCards()
	{
		if(allCards.isEmpty())
			return "There are no cards to Distribute! Please use endpoint <b>/cards</b>, to get the cards first";
		return RummyGameService.shuffleAnddeal(allCards);
	}
	
	
	@RequestMapping("/cards/declareCardsForPlayerOne")
	public List<String> openCardsForPlayerOne()
	{
		return RummyGameService.getPlayerOneCards();
	}
	
	@RequestMapping("/cards/declareCardsForPlayerTwo")
	public List<String> openCardsForPlayerTwo()
	{
		return RummyGameService.getPlayerTwoCards();
	}
	
	
	@RequestMapping("/cards/remove/playerOne/{card}")
	public String discardCardforPlayerOne(@PathVariable String card)
	{
		return RummyGameService.removeCardFromPlayerOne(card);
	}
	
	@RequestMapping("/cards/remove/playerTwo/{card}")
	public String discardCardforPlayerTwo(@PathVariable String card)
	{
		return RummyGameService.removeCardFromPlayerTwo(card);
	}
	
	@RequestMapping(value="cards/pickCard/{player}", method=RequestMethod.GET)
	@ResponseBody
	public String pickACard(@PathVariable String player)
	{
		if(allCards.isEmpty())
			RummyGameService.makeDeck();
		
		allCards = RummyGameService.getDeck();
		return RummyGameService.pickACard(player, allCards);
	}
}
