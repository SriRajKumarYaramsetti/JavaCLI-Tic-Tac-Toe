package Tictactoe.Models;

import java.util.Scanner;

public class Player {
    private Symbol symbol;
    private String name;
    private Long id;
    private Playertype playertype;
    private Scanner scanner;

    public Player(Long id,String name,Symbol symbol,Playertype playertype){
        this.id=id;
        this.name=name;
        this.symbol=symbol;
        this.playertype=playertype;
        this.scanner=new Scanner(System.in);
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Playertype getPlayertype() {
        return playertype;
    }

    public void setPlayertype(Playertype playertype) {
        this.playertype = playertype;
    }
    public Move makeMove(Board board){
        System.out.println("Please tell row count where you want to move(Starting from zero)");
        int row = scanner.nextInt();
        System.out.println("Please tell column count where you want to move (Starting from zero)");
        int col=scanner.nextInt();
        return new Move(new Cell(row,col),this);

    }
}
