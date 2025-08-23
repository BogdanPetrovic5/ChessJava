package models;

import models.figures.Figure;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    public List<Figure> figureList = new ArrayList<>();
    private String _color;

    public Player(String color){
        this._color = color;
    }

    public void addFigure(Figure figure){
        figureList.add(figure);
    }
    public List<Figure> getFigures(){
        return figureList;
    }



}
