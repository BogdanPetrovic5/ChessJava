package models;

import models.enums.Figures;
import models.figures.Figure;

import javax.swing.*;

public class Field extends JButton {
    private Figure _figure;
    public Field(){

    }
    public void setFigure(Figure figure){
        this._figure = figure;
    }
    public Figure getFigure(){
        return _figure;
    }

}
