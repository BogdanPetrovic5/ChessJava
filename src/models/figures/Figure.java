package models.figures;

import interfaces.IField;
import interfaces.IGameController;
import models.Field;
import models.enums.Figures;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Figure extends ImageIcon {
    protected IField field;
    protected IGameController gameController;
    private Figures _figureType;
    private String _color;
    private int _x;
    private int _y;
    private List<Field> availableFields;
    public Figure(Figures figureType, String color, String url, int x, int y, IField field,IGameController gameController) {
        this.gameController = gameController;
        availableFields = new ArrayList<>();
        setFigureType(figureType);
        setFiguresColor(color);
        setUrl(url);
        setX(x);
        setY(y);
        this.field = field;
    }

    public void setFigureType(Figures figureType) {
        this._figureType = figureType;
    }

    public Figures getFigureType() {
        return _figureType;
    }
    public void setFiguresColor(String color){
        this._color = color;
    }

    public void setUrl(String url){
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        super.setImage(icon.getImage());

    }

    public void setX(int x) {
        this._x = x;
    }
    public void setY(int y){
        this._y = y;
    }
    public int getX(){
        return _x;
    }
    public int getY(){
        return _y;
    }
    public String getColor(){
        return  _color;
    }

    public List<Field> getAvailableFields() {
        return availableFields;
    }
    public void addAvailableField(Field field){
        availableFields.add(field);
    }
    public void resetAvailableFields(){
        availableFields.clear();
    }

    public abstract Figure canMove(int x, int y, boolean isSelected);
}
