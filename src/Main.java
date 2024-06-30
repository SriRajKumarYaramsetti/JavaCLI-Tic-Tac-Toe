import Tictactoe.Controllers.gameController;
import Tictactoe.Exceptions.DuplicateSymbolException;
import Tictactoe.Exceptions.MoreThanOneBotException;
import Tictactoe.Exceptions.PlayersCountDimensionMismatchException;
import Tictactoe.Models.*;
import Tictactoe.Strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        gameController gamecontroller = new gameController();

        try {
            int dimensionOfBoard = 3;
            List<Player> players = new ArrayList<>();
            players.add(
                    new Player(1l, "Lalitha", new Symbol('x'), Playertype.HUMAN)
            );
            players.add(new Bot(2l, "GPT", new Symbol('O'), Playertype.BOT, BotDifficultyLevel.HARD)
            );
            List<WinningStrategy> winningStrategies = new ArrayList<>();


            Game game = gameController.startGame(
                    dimensionOfBoard,
                    players,
                    winningStrategies
            );
            while (gamecontroller.checkState(game).equals(GameState.IN_PROGRESS)){
                    //print the board
                    //X's turn
                    //Ask to make move
                    gamecontroller.printBoard(game);
                    gamecontroller.makeMove(game);

            }

        } catch (Exception exception) {
            System.out.println("Something wrong with the game");

        }
        System.out.println("Game Started");


    }
}

