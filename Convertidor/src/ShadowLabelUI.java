import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicLabelUI;
/**
 * 
 * @author Omar Virili
 * @version 1.0
 * Esta clase permite agregar texto con sombras, se creo como clase que hereda de BasicLablUI
 * 
 *
 */
 public class ShadowLabelUI extends BasicLabelUI {
        private Color shadowColor;
        private int offsetX;
        private int offsetY;
        
        /**
         * @author Omar Virili
         * @version: 1.0
         * Este constructor permite crear el texto con el color, y el desplazamiento
         * @param shadowColor: color de la sombra
         * @param offsetX: desplazamiento de la sombra en x
         * @param offsetY: desplazamiento de la sombra en y
         */
        public ShadowLabelUI(Color shadowColor, int offsetX, int offsetY) {
            this.shadowColor = shadowColor;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2 = (Graphics2D) g.create();
            JLabel label = (JLabel) c;

            // Obtener el texto en varias líneas
            String[] lines = label.getText().split("<br/>");

            // Dibujar cada línea con sombra
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.setColor(shadowColor);

            FontMetrics fm = g2.getFontMetrics(label.getFont());
            int lineHeight = fm.getHeight();

            int y = label.getY();
            for (String line : lines) {
                g2.drawString(line, label.getX() + offsetX, y + offsetY);
                y += lineHeight;
            }

            // Dibujar el texto principal
            g2.setColor(label.getForeground());
            y = label.getY();
            for (String line : lines) {
                g2.drawString(line, label.getX(), y);
                y += lineHeight;
            }
            g2.dispose();
        }
    }