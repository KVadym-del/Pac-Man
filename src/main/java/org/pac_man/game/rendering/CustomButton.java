package org.pac_man.game.rendering;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomButton extends JComponent {
    private String text;
    private final int x;
    private final int y;
    private final int size;
    private final int style;
    private final int color;

    private final String buttonFont = "Press Start 2P";

    private ButtonClickListener listener;

    private boolean isMouseOver = false;

    public CustomButton(String text, int x, int y, int size, int style, int color) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.size = size;
        this.style = style;
        this.color = color;

        this.setLayout(null);
        this.setBounds(x, y - size, getPreferredSize().width, getPreferredSize().height);
        this.setSize(getPreferredSize());

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (listener != null) {
                        listener.buttonClicked(CustomButton.this);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                isMouseOver = true;
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isMouseOver = false;
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.setBounds(x, y - size, getPreferredSize().width, getPreferredSize().height);
        this.setSize(getPreferredSize());
    }

    public void render(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D)graphics;
        graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2d.setFont(new Font(buttonFont, style, size));
        if (isMouseOver)
            graphics2d.setColor(new Color(Color.GRAY.getRGB()));
        else
            graphics2d.setColor(new Color(color));

        graphics2d.drawString(text, x, y);
    }

    @Override
    public Dimension getPreferredSize() {
        Font font = new Font(buttonFont, style, size);
        FontMetrics metrics = getFontMetrics(font);
        int width = metrics.stringWidth(text);
        int height = metrics.getHeight();
        return new Dimension(width, height);
    }

    public void addButtonClickListener(ButtonClickListener listener) {
        this.listener = listener;
    }

    @FunctionalInterface
    public interface ButtonClickListener {
        void buttonClicked(CustomButton button);
    }

    @Override
    public boolean contains(int px, int py) {
        return px >= 0 && px < getWidth() && py >= 0 && py < getHeight();
    }

    public void setText(String clicked) {
        this.text = clicked;
        repaint();
    }
}
