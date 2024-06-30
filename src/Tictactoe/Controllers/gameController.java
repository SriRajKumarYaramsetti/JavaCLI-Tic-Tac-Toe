package Tictactoe.Controllers;

import Tictactoe.Exceptions.DuplicateSymbolException;
import Tictactoe.Exceptions.MoreThanOneBotException;
import Tictactoe.Exceptions.PlayersCountDimensionMismatchException;
import Tictactoe.Models.Game;
import Tictactoe.Models.GameState;
import Tictactoe.Models.Player;
import Tictactoe.Strategies.WinningStrategies.WinningStrategy;

import java.util.List;

public class gameController {
    public static Game startGame(int dimensionOfBoard,
                                 List<Player> players, List<WinningStrategy> winningStrategies) throws DuplicateSymbolException, PlayersCountDimensionMismatchException, MoreThanOneBotException {
               return Game.getBuilder()
                        .setPlayers(players)
                        .setDimension(dimensionOfBoard)
                        .setWinningStrategies(winningStrategies)
                        .build();


    }
    void undo(Game game){

    }
    public GameState checkState(Game game){
        return game.getGameState();

    }
    void getWinner(Game game){
        game.printBoard();
    }
    public void printBoard(Game game){
        game.printBoard();
    }
    public void makeMove(Game game){

    }

}
