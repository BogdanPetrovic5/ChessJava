package models.figures;

import interfaces.IField;
import interfaces.IGameController;
import models.Field;
import models.enums.Figures;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class King extends Figure{
    public King(Figures figureType, String color, String url, int x, int y, IField field, IGameController gameController) {
        super(figureType, color, url, x, y,field, gameController);
    }

    @Override
    public Figure canMove(int x, int y, boolean isSelected) {
        Field[][] fields = field.getField();
        if(!isSelected){
            int[] directionX = {1,-1, 0, 1, -1,  0, 1, -1};
            int[] directionY =  {1,-1, 1, 0,  0, -1, -1, 1};

            for(int i = 0; i < directionY.length; i++){
                if(getY() + directionY[i] < 8 && getY() + directionY[i] >= 0 && getX() + directionX[i] >=0 && getX() + directionX[i] < 8){
                    if(fields[getY() + directionY[i]][getX() + directionX[i]].getFigure() == null){
                        fields[getY() + directionY[i]][getX() + directionX[i]].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                        addAvailableField(fields[getY() + directionY[i]][getX() + directionX[i]]);
                    }
                    if(fields[getY() + directionY[i]][getX() + directionX[i]].getFigure() != null && !fields[getY() + directionY[i]][getX() + directionX[i]].getFigure().getColor().equals(this.getColor())){
                        fields[getY() + directionY[i]][getX() + directionX[i]].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                        addAvailableField(fields[getY() + directionY[i]][getX() + directionX[i]]);
                    }
                }

            }
            fields[getY()][getX()].setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
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
