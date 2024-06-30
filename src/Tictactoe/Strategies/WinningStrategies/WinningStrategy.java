package Tictactoe.Strategies.WinningStrategies;

import Tictactoe.Models.Board;
import Tictactoe.Models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
