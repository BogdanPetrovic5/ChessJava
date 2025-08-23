package view;

import javax.swing.*;
import java.awt.*;

public class VerticalNavigationPanel extends JPanel {
    public VerticalNavigationPanel(){
        this.setPreferredSize(new Dimension(20,640));
        this.setLayout(new GridLayout(8, 1));

        for(int i = 7; i >= 0; i--){
            JLabel no = new JLabel(String.valueOf(i + 1));
            no.setFont(new Font("Arial", Font.BOLD, 25));
            this.add(no);
        }
    }

}
