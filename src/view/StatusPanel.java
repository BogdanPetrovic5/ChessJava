package view;

import controllers.GameController;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {

    public StatusPanel(GameController gameController,int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.GREEN);
    }
}
