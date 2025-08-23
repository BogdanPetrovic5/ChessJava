package view;

import controllers.GameController;
import models.BlackPlayer;
import models.Player;
import models.WhitePlayer;

import javax.swing.*;
import java.awt.*;

public class GameInterface extends JFrame {
    public final int cellSize = 80;
    public final int width = 660;
    public final int height = 700;
    public GameInterface(){
        this.setSize(width,height);
        this.setLayout(new BorderLayout());

        Player whitePlayer = new WhitePlayer();
        Player blackPlayer = new BlackPlayer();

        GameController gameController = new GameController(whitePlayer, blackPlayer);

        VerticalNavigationPanel verticalNavigationPanel = new VerticalNavigationPanel();
        HorizontalNavigationPanel horizontalNavigationPanel = new HorizontalNavigationPanel();
        FieldPanel fieldPanel = new FieldPanel(gameController, whitePlayer, blackPlayer, cellSize);
        StatusPanel statusPanel = new StatusPanel(gameController,cellSize * cellSize, 40);


        this.add(fieldPanel, BorderLayout.CENTER);
        this.add(horizontalNavigationPanel, BorderLayout.SOUTH);
        this.add(verticalNavigationPanel, BorderLayout.WEST);
        this.add(statusPanel, BorderLayout.NORTH);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

}
