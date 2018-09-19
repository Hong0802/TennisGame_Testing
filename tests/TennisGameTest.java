import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;


//import jdk.nashorn.internal.ir.annotations.Ignore;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	
	@Test//@Ignore
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Play1:0, play2:0", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin1Points_Score_15_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Play1:1, play2:1", "15 - 15", score);		
	}	
	
	@Test
	public void testTennisGame_EahcPlayerWin2Points_Score_30_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Play1:2, play2:2", "30 - 30", score);		
	}	


	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Play1:4, play2:4", "deuce", score);		
	}

	@Test
	public void testTennisGame_Player1Win1Point_Score_15_0() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Play1:1, play2:0", "15 - love", score);		
	}	

	@Test
	public void testTennisGame_Player2Win1Point_Score_0_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Play1:0, play2:1", "love - 15", score);		
	}	

	@Test
	public void testTennisGame_Player1Win2Points_Score_30_0() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Play1:2, play2:0", "30 - love", score);		
	}	

	@Test
	public void testTennisGame_Player2Win2Points_Score_0_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Play1:0, play2:2", "love - 30", score);		
	}	

	@Test
	public void testTennisGame_Player1Win3Points_Score_40_0() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Play1:3, play2:0", "40 - love", score);		
	}	

	@Test
	public void testTennisGame_Player2Win3Points_Score_0_40() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Play1:0, play2:3", "love - 40", score);		
	}	
	
	@Test
	public void testTennisGame_Player1Win2Points_Player2Win1Point_Score_30_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Play1:2, play2:1", "30 - 15", score);		
	}	

	@Test
	public void testTennisGame_Player1Win1Point_Player2Win2Points_Score_15_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Play1:1, play2:2", "15 - 30", score);		
	}	
	
	
	@Test
	public void testTennisGame_Player1Win3Points_Player2Win1Point_Score_40_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Play1:3, play2:1", "40 - 15", score);		
	}	

	@Test
	public void testTennisGame_Player1Win1Point_Player2Win3Points_Score_15_40() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Play1:1, play2:3", "15 - 40", score);		
	}	

	@Test
	public void testTennisGame_Player1Win4Point_Player2Win3Points_Score_Player1advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Play1:4, play2:3", "player1 has advantage", score);		
	}	

	@Test
	public void testTennisGame_Player1Win3Point_Player2Win4Points_Score_Player2advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Play1:3, play2:4", "player2 has advantage", score);		
	}	
	
	@Test
	public void testTennisGame_Player1Win4Points_Score() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player1Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Player1", "player1 wins", score);		
	}
	
	public void testTennisGame_Player2Win4Points_Score() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();		
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Player2", "player2 wins", score);		
	}
	

	
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();		
		new TennisGameException();
	}
	
	
}
