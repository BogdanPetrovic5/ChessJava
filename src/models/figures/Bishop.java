package models.figures;

import interfaces.IField;
import interfaces.IGameController;
import models.Field;
import models.enums.Figures;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Bishop extends Figure{

    public Bishop(Figures figureType, String color, String url, int x, int y, IField field, IGameController gameController) {
        super(figureType, color, url, x ,y,field, gameController);
    }

    @Override
    public Figure canMove(int x, int y, boolean isSelected) {

        Field[][] fields = field.getField();
        if(!isSelected){
            for(int i = this.getY() + 1 , j = this.getX() + 1; i<= fields.length && j < fields.length; i++, j++){
                if(i < 8 && i >= 0){
                    if(fields[i][j].getFigure() == null){
                        fields[i][j].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                        addAvailableField(fields[i][j]);
                    }else{
                        if(!fields[i][j].getFigure().getColor().equals(this.getColor())){
                            System.out.println("asd");
                            fields[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                            addAvailableField(fields[i][j]);
                        }

                        break;
                    }
                }

            }
            for(int i = this.getY() - 1, j = this.getX() - 1; i >= 0 && j >= 0; i--, j--){
                if(i < 8 && i >= 0){
                    if(fields[i][j].getFigure() == null){
                        fields[i][j].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                        addAvailableField(fields[i][j]);
                    }else{
                        if(!fields[i][j].getFigure().getColor().equals(this.getColor())){
                            System.out.println("asd");
                            fields[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                            addAvailableField(fields[i][j]);
                        }

                        break;
                    }
                }
            }
            for(int i = this.getY() + 1, j = this.getX() - 1; i < 8  && j >= 0; i++, j--){
                if(i < 8 && i >= 0){
                    if(fields[i][j].getFigure() == null){
                        fields[i][j].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                        addAvailableField(fields[i][j]);
                    }else{
                        if(!fields[i][j].getFigure().getColor().equals(this.getColor())){
                            System.out.println("asd");
                            fields[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                            addAvailableField(fields[i][j]);
                        }

                        break;
                    }
                }
            }
            for(int i = this.getY() - 1, j = this.getX() + 1; i >= 0 && j < fields.length; i--, j++){
                if(i < 8 && i >= 0){
                    if(fields[i][j].getFigure() == null){
                        fields[i][j].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                        addAvailableField(fields[i][j]);
                    }else{
                        if(!fields[i][j].getFigure().getColor().equals(this.getColor())){
                            System.out.println("asd");
                            fields[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                            addAvailableField(fields[i][j]);
                        }

                        break;
                    }
                }
            }

            fields[this.getY()][this.getX()].setBorder(BorderFactory.createLineBorder(Color.green, 3));
            return this;
        }else{
            List<Field> availabelFields = getAvailableFields();
            for(Field f : availabelFields){
                if(f.getYCooridnates() == y && f.getXCoordinates() == x){

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
            for(Field f : availabelFields){
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
