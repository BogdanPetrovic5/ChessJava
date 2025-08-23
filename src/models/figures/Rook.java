package models.figures;

import interfaces.IField;
import models.enums.Figures;

public class Rook extends Figure{
    public Rook(Figures figureType, String color, String url, int x, int y, IField field) {
        super(figureType, color, url, x, y, field);
    }

    @Override
    public Figure canMove(int x, int y, boolean isSelected) {
        return null;
    }
}
