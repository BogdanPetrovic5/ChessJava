package controllers;

import interfaces.IField;
import interfaces.IGameController;
import models.Field;
import models.Player;
import models.figures.Figure;

public class GameController implements IGameController {
    private Player _whitePlayer;
    private Player _blackPlayer;
    private IField _fieldPanel;
    private Field[][] _fields;
    private boolean isSelected = false;
    private Figure selected = null;
    public GameController(Player white, Player black){
        _whitePlayer = white;
        _blackPlayer = black;
    }
    public void moveFigure(int x, int y){
        this._fields = _fieldPanel.getField();

        if(selected == null){
            selected = _fields[y][x].getFigure();
        }

        if(selected != null){
            selected = selected.canMove(x, y, isSelected);
        }

        isSelected = !isSelected;




    }

    @Override
    public void handleCaputre(Figure figure) {
        if(figure.getColor().equals("BLACK")){
            _blackPlayer.removeFigure(figure);
        }
    }

    public void setUpField(IField field){
        this._fieldPanel = field;

        System.out.println(_fields == null);
    }
}
