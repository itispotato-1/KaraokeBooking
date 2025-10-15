package GUI.Decorate;

import java.awt.*;
import javax.swing.*;

public class RoundedButton extends JButton{
        private int arcWidth;
        private int arcHeight;
        private Boolean HaveBorderColor;
        private Color Border;
        private int size;

        public RoundedButton(int arcWidth, int arcHeight, Color Border,int size) {
                this.arcWidth = arcWidth;
                this.arcHeight = arcHeight;
                this.Border = Border;
                this.size = size;
                HaveBorderColor = true;
                setContentAreaFilled(false); // ปิด default fill
                setFocusPainted(false);
                setOpaque(false); // ให้พื้นหลังโปร่งใส จะได้ไม่ทับโค้ง
        }

        public RoundedButton(int arcWidth, int arcHeight) {
                this.arcWidth = arcWidth;
                this.arcHeight = arcHeight;
                HaveBorderColor = false;

                setContentAreaFilled(false); // ปิด default fill
                setFocusPainted(false);

                setOpaque(false); // ให้พื้นหลังโปร่งใส จะได้ไม่ทับโค้ง
        }

        @Override
        protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (HaveBorderColor) {
                        g2.setColor(Border);
                } else {
                        g2.setColor(getBackground());
                }
                
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

                g2.setColor(getBackground());
                g2.fillRoundRect(size/2, size/2, getWidth() - size, getHeight() - size, arcWidth, arcHeight);

                g2.dispose();
                super.paintComponent(g);
        }
}
