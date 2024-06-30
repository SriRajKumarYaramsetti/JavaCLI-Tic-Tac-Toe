package Tictactoe.Models;

import Tictactoe.Strategies.BotPlayingStrategies.BotPlayingStrategy;
import Tictactoe.Strategies.BotPlayingStrategies.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(Long id,String name,Symbol symbol,Playertype playertype,
               BotDifficultyLevel botDifficultyLevel){
        super( id,name,symbol,playertype);

        this.botDifficultyLevel=botDifficultyLevel;
        this.botPlayingStrategy= BotPlayingStrategyFactory.getBotPlayingStrategyForDifficultyLevel(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }
    @Override
    public Move makeMove(Board board){
        Move move=botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;

    }

}

