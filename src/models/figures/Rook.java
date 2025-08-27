package models.figures;

import interfaces.IField;
import interfaces.IGameController;
import models.Field;
import models.enums.Figures;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Rook extends Figure{
    public Rook(Figures figureType, String color, String url, int x, int y, IField field, IGameController gameController) {
        super(figureType, color, url, x, y, field, gameController);
    }

    @Override
    public Figure canMove(int x, int y, boolean isSelected) {
        Field[][] fields = field.getField();
        if(!isSelected){
            for(int i = getY() + 1; i < fields.length;i++){
                if(fields[i][getX()].getFigure() != null && fields[i][getX()].getFigure().getColor().equals(this.getColor())) break;
                if(fields[i][getX()].getFigure() == null){
                    fields[i][getX()].setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
                    addAvailableField(fields[i][getX()]);
                }
                if(fields[i][getX()].getFigure() != null && !fields[i][getX()].getFigure().getColor().equals(this.getColor())){
                    fields[i][getX()].setBorder(BorderFactory.createLineBorder(Color.RED,3));
                    addAvailableField(fields[i][getX()]);
                    break;
                }
            }
            for(int i = getY() - 1; i >= 0;i--){
                if(fields[i][getX()].getFigure() != null && fields[i][getX()].getFigure().getColor().equals(this.getColor())) break;
                if(fields[i][getX()].getFigure() == null){
                    fields[i][getX()].setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
                    addAvailableField(fields[i][getX()]);
                }
                if(fields[i][getX()].getFigure() != null && !fields[i][getX()].getFigure().getColor().equals(this.getColor())){
                    fields[i][getX()].setBorder(BorderFactory.createLineBorder(Color.RED,3));
                    addAvailableField(fields[i][getX()]);
                    break;
                }
            }

            for(int i = getX() - 1; i >= 0;i--){
                if(fields[getY()][i].getFigure() != null && fields[getY()][i].getFigure().getColor().equals(this.getColor())) break;
                if(fields[getY()][i].getFigure() == null){
                    fields[getY()][i].setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
                    addAvailableField(fields[getY()][i]);
                }
                if(fields[getY()][i].getFigure() != null && !fields[getY()][i].getFigure().getColor().equals(this.getColor())){
                    fields[getY()][i].setBorder(BorderFactory.createLineBorder(Color.RED,3));
                    addAvailableField(fields[getY()][i]);
                    break;
                }
            }
            for(int i = getX() + 1; i < fields.length;i++){
                if(fields[getY()][i].getFigure() != null && fields[getY()][i].getFigure().getColor().equals(this.getColor())) break;
                if(fields[getY()][i].getFigure() == null){
                    fields[getY()][i].setBorder(BorderFactory.createLineBorder(Color.YELLOW,3));
                    addAvailableField(fields[getY()][i]);
                }
                if(fields[getY()][i].getFigure() != null && !fields[getY()][i].getFigure().getColor().equals(this.getColor())){
                    fields[getY()][i].setBorder(BorderFactory.createLineBorder(Color.RED,3));
                    addAvailableField(fields[getY()][i]);
                    break;
                }
            }
            fields[this.getY()][this.getX()].setBorder(BorderFactory.createLineBorder(Color.green, 3));
            return  this;
        }else{
            List<Field> availableFields = getAvailableFields();
            for(Field f : availableFields){
                if(f.getXCoordinates() == x && f.getYCooridnates() == y){

                    f.setFigure(this);
                    f.setIcon(this);
                    fields[this.getY()][getX()].setBorder(null);
                    fields[this.getY()][getX()].setFigure(null);
                    fields[this.getY()][getX()].setIcon(null);
                    this.setX(x);
                    this.setY(y);


                    break;
                }
            }
            for(Field f : availableFields){
                f.setBorder(null);
            }
            if(x == getX() && y == getY()){
                fields[this.getY()][getX()].setBorder(null);
            }
            resetAvailableFields();
            return null;
        }

    }
}
