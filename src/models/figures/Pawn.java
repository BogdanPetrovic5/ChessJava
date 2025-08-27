package models.figures;

import interfaces.IField;
import interfaces.IGameController;
import models.Field;
import models.enums.Figures;

import javax.swing.*;
import java.awt.*;

public class Pawn extends Figure {
    public Pawn(Figures figureType, String color, String url, int x, int y, IField field, IGameController gameController) {
        super(figureType, color, url, x, y, field, gameController);
    }

    @Override
    public Figure canMove(int x, int y, boolean isSelected) {
        int directionY = getColor().equals("WHITE") ? -1 : 1;
        int directionX = 0;
        int startRow = getColor().equals("WHITE") ? 6 : 1;

        int currentX = getX();
        int currentY = getY();

        Field[][] fields = field.getField();


        Figure figure = fields[currentY][currentX].getFigure();

        if (!isSelected) {
            fields[currentY][currentX].setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            if(currentX + 1 < 8 && (currentY + directionY >= 0 && currentY + directionY < 8)){
                directionX = fields[currentY + directionY][currentX + 1].getFigure() != null ? 1 : 0;
                if(directionX != 0) fields[currentY + directionY][currentX + directionX].setBorder(BorderFactory.createLineBorder(Color.RED, 2));

            }
            if(currentX - 1 >= 0 && (currentY + directionY >= 0 && currentY + directionY < 8)){
                directionX = fields[currentY + directionY][currentX - 1].getFigure() != null ? -1 : 0;
                if(directionX != 0) fields[currentY + directionY][currentX + directionX].setBorder(BorderFactory.createLineBorder(Color.RED, 2));

            }



            if(currentY + directionY >= 0 && currentY + directionY < 8){
                fields[currentY + directionY][currentX].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));

            }


            if(currentY == startRow){
                System.out.println(startRow);
                fields[currentY + directionY * 2][currentX].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
            }
            return this;

        }else {
            if(x == currentX && currentY == y){
                fields[currentY][currentX].setBorder(null);
                if((currentX + 1 < 8 && (currentY + 1 < 8 && currentY - 1 >= 0))){

                        fields[currentY + directionY][currentX + 1].setBorder(null);


                }
                if((currentX - 1 < 8 && (currentY + 1 < 8 && currentY - 1 >= 0))){

                        fields[currentY + directionY][currentX - 1].setBorder(null);


                }
                if((currentY + directionY < 8 && currentY + directionY >= 0)){

                        fields[currentY + directionY][currentX].setBorder(null);
                        if(currentY + directionY * 2 < 8 && currentY + directionY * 2 >= 0){
                            fields[currentY + directionY * 2][currentX].setBorder(null);

                        }


                }
                return null;
            }

            if(this._checkMovementValidity(x,y,figure)){
                fields[currentY][currentX].setBorder(null);
                if(fields[y][x].getFigure() != null && !fields[y][x].getFigure().getColor().equals(this.getColor())){
                    gameController.handleCaputre(fields[y][x].getFigure());
                }
                fields[y][x].setFigure(figure);
                fields[y][x].setIcon(figure);
                if(currentY + directionY <  8 && currentY + directionY >=0){
                    fields[currentY + directionY][currentX].setBorder(null);
                }

                if(startRow == currentY && currentY + directionY * 2 < 8 && currentY + directionY * 2 >= 0){
                    fields[currentY + directionY * 2][currentX].setBorder(null);
                }
                if(currentX - 1 >= 0 && currentY + directionY <  8 && currentY + directionY >=0){
                    fields[currentY + directionY][currentX - 1].setBorder(null);
                }
                if(currentX + 1 < 8 && currentY + directionY <  8 && currentY + directionY >=0){
                    fields[currentY + directionY][currentX + 1].setBorder(null);
                }

                figure.setY(y);
                figure.setX(x);

                fields[currentY][currentX].setFigure(null);
                fields[currentY][currentX].setIcon(null);
                return null;

            }else{
                System.out.println("Can't move there!");
                return this;
            }


        }

    }

    private boolean _checkMovementValidity(int x, int y, Figure figure){
        int currentY = figure.getY();
        int currentX = figure.getX();
        int directionY = figure.getColor().equals("WHITE") ? -1 : 1;
        int startRow = figure.getColor().equals("WHITE") ? 6 : 1;
        Field[][] fields = field.getField();

        if(fields[y][x].getFigure() != null){
            if((x > currentX || x < currentX) && Math.abs(currentY - y) == 1) {
                Figure checkFigure = fields[y][x].getFigure();
                System.out.println(checkFigure.getColor());
                if(!figure.getColor().equals(checkFigure.getColor())) return true;


            }

        }
        if(fields[y][x].getFigure() != null) {
            return false;
        }
        if(currentY + directionY == y) return true;

        if(startRow == currentY && y == currentY + 2 * directionY) return true;
        return false;

    }
}
