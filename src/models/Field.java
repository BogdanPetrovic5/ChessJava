package models;

import models.enums.Figures;
import models.figures.Figure;

import javax.swing.*;

public class Field extends JButton {
    private Figure _figure;
    private int y;
    private int x;
    public Field(){

    }
    public void setFigure(Figure figure){
        this._figure = figure;
    }
    public Figure getFigure(){
        return _figure;
    }


    public int getXCoordinates() {
        return x;
    }


    public int getYCooridnates() {
        return y;
    }

    public void setXCooridanates(int x) {
        this.x = x;
    }

    public void setYCooridnates(int y) {
        this.y = y;
    }
}
