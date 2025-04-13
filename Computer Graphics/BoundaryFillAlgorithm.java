import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoundaryFillAlgorithm extends JPanel implements MouseListener {

    private int[][] pixels; // Store colors as integer values
    private int width = 500, height = 500;
    private final Color boundaryColor = Color.BLACK;
    private final Color fillColor = Color.YELLOW;

    public BoundaryFillAlgorithm() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
        addMouseListener(this);

        // Simulate a canvas as a 2D pixel array
        pixels = new int[width][height];
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw a closed polygon (manual for demo)
        g.setColor(boundaryColor);
        int[] xPoints = {100, 200, 200, 100};
        int[] yPoints = {100, 100, 200, 200};
        g.drawPolygon(xPoints, yPoints, xPoints.length);

        // Mark the boundary in our 2D pixel array
        for (int i = 100; i <= 200; i++) {
            pixels[i][100] = boundaryColor.getRGB();
            pixels[i][200] = boundaryColor.getRGB();
            pixels[100][i] = boundaryColor.getRGB();
            pixels[200][i] = boundaryColor.getRGB();
        }

        // Redraw filled pixels
        g.setColor(fillColor);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (pixels[x][y] == fillColor.getRGB()) {
                    g.fillRect(x, y, 1, 1);
                }
            }
        }
    }

    // Boundary Fill Algorithm - 4-connected
    public void boundaryFill(int x, int y, int fill, int boundary) {
        if (x < 0 || x >= width || y < 0 || y >= height)
            return;

        int current = pixels[x][y];
        if (current != fill && current != boundary) {
            pixels[x][y] = fill;

            boundaryFill(x + 1, y, fill, boundary);
            boundaryFill(x - 1, y, fill, boundary);
            boundaryFill(x, y + 1, fill, boundary);
            boundaryFill(x, y - 1, fill, boundary);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int seedX = e.getX();
        int seedY = e.getY();
        boundaryFill(seedX, seedY, fillColor.getRGB(), boundaryColor.getRGB());
        repaint();
    }

    // Unused mouse events
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Boundary Fill Algorithm - Click Inside Box to Fill");
        BoundaryFillAlgorithm panel = new BoundaryFillAlgorithm();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
