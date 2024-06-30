package Tictactoe.Strategies.BotPlayingStrategies;

import Tictactoe.Models.Board;
import Tictactoe.Models.Move;

public interface BotPlayingStrategy {

    Move makeMove(Board board);
}
