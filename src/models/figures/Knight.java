package models.figures;

import interfaces.IField;
import interfaces.IGameController;
import models.Field;
import models.enums.Figures;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Knight extends Figure{

    public Knight(Figures figureType, String color, String url, int x, int y, IField field, IGameController gameController) {
        super(figureType, color, url, x, y,field, gameController);
    }

    @Override
    public Figure canMove(int x, int y, boolean isSelected) {
        int currentX = getX();
        int currentY = getY();



        Field[][] fields = field.getField();


        Figure figure = fields[currentY][currentX].getFigure();
        if(!isSelected){
            fields[currentY][currentX].setBorder(BorderFactory.createLineBorder(Color.GREEN,3));

            if(currentY + 2 < 8 && currentX - 1 >= 0){
                fields[currentY + 2][currentX - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                addAvailableField(fields[currentY + 2][currentX - 1]);
            }
            if(currentY + 2 < 8 && currentX + 1 < 8){
                fields[currentY + 2][currentX + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                addAvailableField(fields[currentY + 2][currentX + 1]);
            }

            if(currentY - 2 >= 0 && currentX - 1 >= 0){
                fields[currentY - 2][currentX - 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                addAvailableField(fields[currentY - 2][currentX - 1]);
            }
            if(currentY - 2 >= 0 && currentX + 1 < 8){
                fields[currentY - 2][currentX + 1].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                addAvailableField( fields[currentY - 2][currentX + 1]);
            }


            if(currentY - 1 >= 0 && currentX - 2 >= 0){
                fields[currentY - 1][currentX - 2].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                addAvailableField(fields[currentY - 1][currentX - 2]);
            }
            if(currentY - 1 >= 0 && currentX + 2 < 8){
                fields[currentY - 1][currentX + 2].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                addAvailableField(fields[currentY - 1][currentX + 2]);
            }

            if(currentY + 1 < 8 && currentX - 2 >= 0){
                fields[currentY + 1][currentX - 2].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                addAvailableField(fields[currentY + 1][currentX - 2]);
            }
            if(currentY + 1 < 8 && currentX + 2 < 8){
                fields[currentY + 1][currentX + 2].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                addAvailableField(fields[currentY + 1][currentX + 2]);
            }
            List<Field> availableFields = getAvailableFields();
            for(Field f : availableFields){
                if(f.getFigure() != null && !f.getFigure().getColor().equals(this.getColor())){
                    f.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                }else if(f.getFigure() != null && f.getFigure().getColor().equals(this.getColor())){
                    f.setBorder(null);
                }

            }
            return this;
        }else{
            if(x != currentX && y != currentY){
                fields[currentY][currentX].setBorder(null);
                List<Field> availableFields = getAvailableFields();
                Field selectedField = null;
                for(Field f : availableFields){
                    if(f.getXCoordinates() == x && f.getYCooridnates() == y && checkForFigure(f)){
                        f.setFigure(this);
                        f.setIcon(this);
                        this.setX(x);
                        this.setY(y);

                        fields[currentY][currentX].setFigure(null);
                        fields[currentY][currentX].setIcon(null);
                        break;
                    }
                }

                for(Field f : availableFields){
                   f.setBorder(null);
                }





                resetAvailableFields();
                return null;
            }else{
                List<Field> availableFields = getAvailableFields();
                fields[currentY][currentX].setBorder(null);
                for(Field f : availableFields){
                  f.setBorder(null);
                }
                return null;
            }
        }

    }
    public boolean checkForFigure(Field f){
        if(f.getFigure() == null) return true;
        return f.getFigure() != null && !f.getFigure().getColor().equals(this.getColor());
    }
}
