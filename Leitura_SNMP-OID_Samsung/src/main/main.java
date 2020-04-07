package main;

import Gui.GuiPrincipal;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.SQLException;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        GuiPrincipal gui = new GuiPrincipal();
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle r = gui.getBounds();
        int width = r.width;
        int height = r.height;
        int posx = (d.width / 2) - (width / 2);
        int posy = (d.height / 2) - (height / 2);
        gui.setBounds(posx, posy, width, height);
        gui.setVisible(true);

    }

}
