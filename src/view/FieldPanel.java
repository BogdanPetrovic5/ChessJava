package view;

import controllers.GameController;
import factory.FiguresFactory;
import interfaces.IField;
import models.Field;
import models.figures.Figure;
import models.Player;
import models.enums.Figures;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends JPanel implements IField {
    Figures[] backRow = {
            Figures.ROOK, Figures.KNIGHT, Figures.BISHOP, Figures.QUEEN,
            Figures.KING, Figures.BISHOP, Figures.KNIGHT, Figures.ROOK
    };
    public Field[][] fields;
    private Player _whitePlayer;
    private Player _blackPlayer;
    private GameController _gameController;
    public FieldPanel(GameController gameController, Player whitePlayer, Player blackPlayer, int cellSize) {

        this.setPreferredSize(new Dimension(cellSize * 8, cellSize * 8));
        this.setLayout(new GridLayout(8, 8));
        this._gameController = gameController;
        _gameController.setUpField(this);
        this._whitePlayer = whitePlayer;
        this._blackPlayer = blackPlayer;
        fields = new Field[8][8];

        initializeField();
        initializeFigures();
    }
    private void initializeField(){
        for(int i = 0; i < fields.length; i++){
            for(int j = 0; j < fields.length;j++){
                Field newField = new Field();
                if((i + j) % 2 == 0) newField.setBackground(new Color(239, 193, 113));
                else newField.setBackground(new Color(149, 101, 0));
                newField.setYCooridnates(i);
                newField.setXCooridanates(j);
                fields[i][j] = newField;
                fields[i][j].setFocusable(false);
                final int y = i;
                final int x = j;
                fields[i][j].addActionListener(e->{
                    _gameController.moveFigure(x,y);
                });
                this.add(newField);
            }
        }
    }
    private void initializeFigures(){
        for(int i = 0; i < fields.length; i++){
            for(int j = 0; j < fields[i].length; j++){
                Figure figure = null;

                if(i == 0){
                    figure = FiguresFactory.createFigure(backRow[j], "BLACK", "/assets/blacks/" + backRow[j].name().toLowerCase() + ".png",j, i, this);


                    _blackPlayer.addFigure(figure);
                } else if(i == 1){
                    figure = FiguresFactory.createFigure(Figures.PAWN, "BLACK","/assets/blacks/pawn.png", j,i,this );
                    _blackPlayer.addFigure(figure);
                }

                else if(i == 6){
                    figure = FiguresFactory.createFigure(Figures.PAWN, "WHITE", "/assets/whites/pawn.png", j,i,this);
                    _whitePlayer.addFigure(figure);
                } else if(i == 7){
                    figure = FiguresFactory.createFigure(backRow[j], "WHITE", "/assets/whites/" + backRow[j].name().toLowerCase() + ".png", j, i,this);

                    _whitePlayer.addFigure(figure);
                }

                if(figure != null){
                    fields[i][j].setIcon(figure);
                    fields[i][j].setFigure(figure);
                }
            }
        }
    }

    @Override
    public Field[][] getField() {
        return fields;
    }
}
