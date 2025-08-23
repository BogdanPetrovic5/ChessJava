package factory;

import interfaces.IField;
import models.enums.Figures;
import models.figures.*;

public class FiguresFactory {
    public static Figure createFigure(Figures figureType, String color, String url, int x, int y, IField field){
       return switch (figureType) {
           case KING -> new King(figureType, color, url, x, y, field);
           case QUEEN -> new Queen(figureType, color, url, x, y,field);
           case BISHOP -> new Bishop(figureType, color, url, x, y,field);
           case KNIGHT -> new Knight(figureType, color, url, x, y,field);
           case ROOK -> new Rook(figureType, color, url, x, y,field);
           case PAWN -> new Pawn(figureType, color, url, x, y,field);
       };
    }

}
