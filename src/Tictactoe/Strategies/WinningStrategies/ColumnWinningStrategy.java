package Tictactoe.Strategies.WinningStrategies;

import Tictactoe.Models.Board;
import Tictactoe.Models.Move;
import Tictactoe.Models.Symbol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy{
    //In each column ,each symbol is present how many times
    Map<Integer,HashMap<Symbol,Integer>> counts=new HashMap();
    //|0| ---> {x->0;0->0}
    //|1| ---> {x->0;0->0}
    //|2| ---> {x->0;0->0}
    //|3| ---> {x->0;0->0}


    @Override
    public boolean checkWinner(Board board, Move move){
        int col=move.getCell().getCol();
        Symbol symbol=move.getPlayer().getSymbol();
        if(!counts.containsKey(col)){
            counts.put(col,new HashMap<>());
        }

        Map<Symbol,Integer> colMap=counts.get(col);

        if(!colMap.containsKey(symbol)){
            colMap.put(symbol,0);
        }
        return true;
    }
}
