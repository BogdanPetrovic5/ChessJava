package view;

import javax.swing.*;
import java.awt.*;

public class HorizontalNavigationPanel extends JPanel {
    public HorizontalNavigationPanel(){
        this.setPreferredSize(new Dimension(640, 20));
        this.setLayout(new GridLayout(1, 8));

        for(int i = 65; i <= 72; i++){
            JLabel no = new JLabel(String.valueOf((char)i));
            no.setFont(new Font("Arial", Font.BOLD, 25));
            no.setHorizontalAlignment(SwingConstants.CENTER);
            no.setVerticalAlignment(SwingConstants.CENTER);
            this.add(no);
        }
    }
}
