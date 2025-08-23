package controllers;

import interfaces.IField;
import models.Field;
import models.Player;
import models.figures.Figure;

public class GameController {
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


        selected = selected.canMove(x, y, isSelected);
        isSelected = !isSelected;




    }

    public void setUpField(IField field){
        this._fieldPanel = field;

        System.out.println(_fields == null);
    }
}
