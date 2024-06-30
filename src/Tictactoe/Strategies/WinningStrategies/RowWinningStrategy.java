package Tictactoe.Strategies.WinningStrategies;

import Tictactoe.Models.Board;
import Tictactoe.Models.Move;
import Tictactoe.Models.Symbol;

import java.util.List;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{
    private List<Map<Symbol,Integer>> symbolCount;
    public boolean checkWinner(Board board, Move move){
        return true;
    }
}
