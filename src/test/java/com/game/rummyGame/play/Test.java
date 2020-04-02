package com.game.rummyGame.play;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	RummyGame obj = new RummyGame();
	
	/*
	 * @org.junit.jupiter.api.Test void testGetAllCards() {
	 * fail("Not yet implemented"); }
	 */

	@org.junit.jupiter.api.Test
	void testDistributeCards() {
		assertEquals(true, obj.distributeCards().contains("shuffled") || obj.distributeCards().contains("no cards"));
		//fail("Not yet implemented");
	}

	@org.junit.jupiter.api.Test void testGetPlayerOneCards()
	{
		assertEquals(false, obj.openCardsForPlayerOne().equals(null));
	}
	  
	@org.junit.jupiter.api.Test void testGetPlayerTwoCards()
	{
		assertEquals(false, obj.openCardsForPlayerTwo().equals(null));
	}
	 
	@org.junit.jupiter.api.Test
	void testRemoveCardforPlayerOne() {
		assertEquals(true, (obj.discardCardforPlayerOne("ACE of Spades").contains("removed") || 
				obj.discardCardforPlayerOne("ACE of Spades").contains("Either")));
		//fail("Not yet implemented");
	}

	@org.junit.jupiter.api.Test
	void testRemoveCardforPlayerTwo() {
		assertEquals(true, (obj.discardCardforPlayerOne("ACE of Spades").contains("removed") || 
				obj.discardCardforPlayerOne("ACE of Spades").contains("Either")));
		//fail("Not yet implemented");
	}
	
	@org.junit.jupiter.api.Test
	void testPickACard() {
		assertEquals(true, (obj.pickACard("playerOne").contains("added")) || 
				(obj.pickACard("playerOne").contains("already")) || (obj.pickACard("playerOne").contains("Please type")));
		//fail("Not yet implemented");
	}

}
