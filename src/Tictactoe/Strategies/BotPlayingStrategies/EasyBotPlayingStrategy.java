package Tictactoe.Strategies.BotPlayingStrategies;

import Tictactoe.Models.Board;
import Tictactoe.Models.Cell;
import Tictactoe.Models.CellState;
import Tictactoe.Models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board) {
        for (List<Cell> row:board.getBoard()){
            for(Cell cell:row){
                if (cell.getCellState().equals(CellState.EMPTY)){
                    return new Move(cell,null);
                }
            }
        }
        return null;
    }
}
