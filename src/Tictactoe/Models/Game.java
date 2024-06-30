package Tictactoe.Models;

import Tictactoe.Exceptions.DuplicateSymbolException;
import Tictactoe.Exceptions.MoreThanOneBotException;
import Tictactoe.Exceptions.PlayersCountDimensionMismatchException;
import Tictactoe.Strategies.WinningStrategies.WinningStrategy;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private List<Player> players;
    private GameState gameState;
    private int nextMovePlayerIndex;
    private List<WinningStrategy> winningStrategies;
    private Board board;
    private List<Move> moves;
    private Player winner;

    public static Builder getBuilder(){
        return new Builder();
    }
    private Game(int dimension,List<Player> players,List<WinningStrategy> winningStrategies){
        this.nextMovePlayerIndex=0;
        this.gameState=GameState.IN_PROGRESS;
        this.players=players;
        this.winningStrategies=winningStrategies;
        this.moves=new ArrayList<>();
        this.board=new Board(dimension);


    }


    public static class Builder {
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;

        private Builder(){
            this.players=new ArrayList<>();
            this.winningStrategies=new ArrayList<>();
            this.dimension=0;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder addPlayer(Player player){
            this.players.add(player);
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder addWinningStrategy(WinningStrategy winningStrategy){
            this.winningStrategies.add(winningStrategy);
            return this;
        }

        private void validateBotCounts() throws MoreThanOneBotException {
            int botCount=0;
            for(Player player:players){
                if(player.getPlayertype().equals(Playertype.BOT)){
                    botCount+=1;
                }
            }
            if (botCount>1){
                throw new MoreThanOneBotException();
            }


        }

        private void validateDimensionAndPlayersCount() throws PlayersCountDimensionMismatchException {
            if(players.size()!=dimension-1){
                throw new PlayersCountDimensionMismatchException();
            }

        }

        private void validateSymbolCount() throws DuplicateSymbolException {
            Map<Character,Integer> symbolCounts=new HashMap<>();
            for(Player player:players){
                if (!symbolCounts.containsKey(player.getSymbol().getaChar())) {
                    symbolCounts.put(player.getSymbol().getaChar(),0);
                }
                symbolCounts.put(
                        player.getSymbol().getaChar(),
                        symbolCounts.get(player.getSymbol().getaChar())+1
                );
                if (symbolCounts.get(player.getSymbol().getaChar())>1){
                    throw new DuplicateSymbolException();

                }
            }

        }

        private void validate() throws DuplicateSymbolException, PlayersCountDimensionMismatchException, MoreThanOneBotException {
            try {
                validateBotCounts();
                validateSymbolCount();
                validateDimensionAndPlayersCount();
            }
            catch (Exception e){
                throw e;
            }

        }



        public Game build() throws DuplicateSymbolException, PlayersCountDimensionMismatchException, MoreThanOneBotException {
            validate();
            return new Game(dimension,players,winningStrategies);
        }



    }

    public void printBoard(){
            board.printBoard();
    }

    private boolean validateMove(Move move){
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();

        if (board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)){
            return true;
        }
        return false;

    }

    private boolean checkWinner(Board board,Move move){
        for (WinningStrategy winningStrategy:winningStrategies){
                    if(winningStrategy.checkWinner(board,move)){
                        return true;
                    }
        }
        return false;
    }

    public void makeMove(){
        Player currentMovePlayer=players.get(nextMovePlayerIndex);
        System.out.println("It is "+currentMovePlayer.getName()+" 's turn.Please make your move");
        Move move=currentMovePlayer.makeMove(board);

        if(!validateMove(move)){
            return;
        }
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Cell cellToChange=board.getBoard().get(row).get(col);
        cellToChange.setCellState(CellState.FILLED);
        cellToChange.setPlayer(currentMovePlayer);

        Move finalMoveObject=new Move(cellToChange,currentMovePlayer);
        moves.add(finalMoveObject);
        nextMovePlayerIndex+=1;
        nextMovePlayerIndex%=players.size();

        if (checkWinner(board,move)){
            gameState=GameState.WIN;
            winner=currentMovePlayer;

        }

        if (moves.size() == this.board.getSize() * this.board.getSize()){
            gameState=GameState.DRAW;

        }




    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }




}
