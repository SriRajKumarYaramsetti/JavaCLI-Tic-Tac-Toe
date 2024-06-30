package Tictactoe.Strategies.BotPlayingStrategies;

import Tictactoe.Models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel level){
        return new EasyBotPlayingStrategy();
    }
}
