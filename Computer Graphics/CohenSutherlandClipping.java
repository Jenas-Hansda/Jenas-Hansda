import javax.swing.*;
import java.awt.*;

public class CohenSutherlandClipping extends JPanel {

    private final int INSIDE = 0; // 0000
    private final int LEFT = 1;   // 0001
    private final int RIGHT = 2;  // 0010
    private final int BOTTOM = 4; // 0100
    private final int TOP = 8;    // 1000

    // Clipping rectangle
    private int x_min = 100, y_min = 100, x_max = 300, y_max = 300;

    // Line endpoints
    private int x1 = 50, y1 = 50, x2 = 350, y2 = 350;

    // Clipped line
    private int cx1 = 0, cy1 = 0, cx2 = 0, cy2 = 0;
    private boolean isClipped = false;

    public CohenSutherlandClipping() {
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.WHITE);
    }

    // Compute region code for a point (x, y)
    private int computeCode(int x, int y) {
        int code = INSIDE;

        if (x < x_min)
            code |= LEFT;
        else if (x > x_max)
            code |= RIGHT;
        if (y < y_min)
            code |= BOTTOM;
        else if (y > y_max)
            code |= TOP;

        return code;
    }

    // Cohen-Sutherland clipping algorithm
    public void cohenSutherlandClip(int x1, int y1, int x2, int y2) {
        int code1 = computeCode(x1, y1);
        int code2 = computeCode(x2, y2);
        boolean accept = false;

        while (true) {
            if ((code1 | code2) == 0) {
                // Both points inside
                accept = true;
                break;
            } else if ((code1 & code2) != 0) {
                // Both points share an outside zone — trivially reject
                break;
            } else {
                // Clipping needed
                int code_out = (code1 != 0) ? code1 : code2;
                int x = 0, y = 0;

                if ((code_out & TOP) != 0) {
                    x = x1 + (x2 - x1) * (y_max - y1) / (y2 - y1);
                    y = y_max;
                } else if ((code_out & BOTTOM) != 0) {
                    x = x1 + (x2 - x1) * (y_min - y1) / (y2 - y1);
                    y = y_min;
                } else if ((code_out & RIGHT) != 0) {
                    y = y1 + (y2 - y1) * (x_max - x1) / (x2 - x1);
                    x = x_max;
                } else if ((code_out & LEFT) != 0) {
                    y = y1 + (y2 - y1) * (x_min - x1) / (x2 - x1);
                    x = x_min;
                }

                if (code_out == code1) {
                    x1 = x;
                    y1 = y;
                    code1 = computeCode(x1, y1);
                } else {
                    x2 = x;
                    y2 = y;
                    code2 = computeCode(x2, y2);
                }
            }
        }

        if (accept) {
            isClipped = true;
            this.cx1 = x1;
            this.cy1 = y1;
            this.cx2 = x2;
            this.cy2 = y2;
        } else {
            isClipped = false;
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw clipping window
        g.setColor(Color.BLUE);
        g.drawRect(x_min, y_min, x_max - x_min, y_max - y_min);

        // Draw original line
        g.setColor(Color.LIGHT_GRAY);
        g.drawLine(this.x1, this.y1, this.x2, this.y2);

        // Draw clipped line
        if (isClipped) {
            g.setColor(Color.RED);
            g.drawLine(cx1, cy1, cx2, cy2);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cohen-Sutherland Line Clipping");
        CohenSutherlandClipping panel = new CohenSutherlandClipping();

        // Input fields
        JTextField x1Field = new JTextField("50", 5);
        JTextField y1Field = new JTextField("50", 5);
        JTextField x2Field = new JTextField("350", 5);
        JTextField y2Field = new JTextField("350", 5);
        JButton clipButton = new JButton("Clip");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("x1:"));
        inputPanel.add(x1Field);
        inputPanel.add(new JLabel("y1:"));
        inputPanel.add(y1Field);
        inputPanel.add(new JLabel("x2:"));
        inputPanel.add(x2Field);
        inputPanel.add(new JLabel("y2:"));
        inputPanel.add(y2Field);
        inputPanel.add(clipButton);

        clipButton.addActionListener(e -> {
            try {
                int x1 = Integer.parseInt(x1Field.getText());
                int y1 = Integer.parseInt(y1Field.getText());
                int x2 = Integer.parseInt(x2Field.getText());
                int y2 = Integer.parseInt(y2Field.getText());

                panel.x1 = x1;
                panel.y1 = y1;
                panel.x2 = x2;
                panel.y2 = y2;
                panel.cohenSutherlandClip(x1, y1, x2, y2);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid integer coordinates.");
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
