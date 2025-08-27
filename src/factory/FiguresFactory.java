package factory;

import interfaces.IField;
import interfaces.IGameController;
import models.enums.Figures;
import models.figures.*;

public class FiguresFactory {
    public static Figure createFigure(Figures figureType, String color, String url, int x, int y, IField field, IGameController gameController){
       return switch (figureType) {
           case KING -> new King(figureType, color, url, x, y, field, gameController);
           case QUEEN -> new Queen(figureType, color, url, x, y,field,gameController);
           case BISHOP -> new Bishop(figureType, color, url, x, y,field,gameController);
           case KNIGHT -> new Knight(figureType, color, url, x, y,field,gameController);
           case ROOK -> new Rook(figureType, color, url, x, y,field,gameController);
           case PAWN -> new Pawn(figureType, color, url, x, y,field,gameController);
       };
    }

}
