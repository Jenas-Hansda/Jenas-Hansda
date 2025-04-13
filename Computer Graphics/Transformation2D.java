import javax.swing.*;
import java.awt.*;

public class Transformation2D extends JPanel {

    private int[] xPoints = {100, 150, 200};
    private int[] yPoints = {100, 50, 100};
    private int[] transformedX = xPoints.clone();
    private int[] transformedY = yPoints.clone();
    private String transformation = "";
    private double param1 = 0, param2 = 0;

    public Transformation2D() {
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.WHITE);
    }

    public void applyTransformation(String type, double p1, double p2) {
        transformation = type.toLowerCase();
        param1 = p1;
        param2 = p2;
        performTransformation();
        repaint();
    }

    private void performTransformation() {
        transformedX = new int[xPoints.length];
        transformedY = new int[yPoints.length];

        for (int i = 0; i < xPoints.length; i++) {
            double x = xPoints[i];
            double y = yPoints[i];

            switch (transformation) {
                case "translate":
                    x += param1;
                    y += param2;
                    break;
                case "scale":
                    x *= param1;
                    y *= param2;
                    break;
                case "rotate":
                    double angle = Math.toRadians(param1);
                    double cosA = Math.cos(angle);
                    double sinA = Math.sin(angle);
                    x -= 150; y -= 100; // Rotate around the shape center
                    double newX = x * cosA - y * sinA;
                    double newY = x * sinA + y * cosA;
                    x = newX + 150;
                    y = newY + 100;
                    break;
                case "shear":
                    x = x + param1 * y;
                    y = y + param2 * x;
                    break;
                default:
                    break;
            }

            transformedX[i] = (int) Math.round(x);
            transformedY[i] = (int) Math.round(y);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw original shape
        g.setColor(Color.LIGHT_GRAY);
        g.drawPolygon(xPoints, yPoints, xPoints.length);

        // Draw transformed shape
        g.setColor(Color.RED);
        g.drawPolygon(transformedX, transformedY, transformedX.length);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("2D Transformations");
        Transformation2D panel = new Transformation2D();

        // GUI Components
        String[] transformOptions = {"Translate", "Scale", "Rotate", "Shear"};
        JComboBox<String> transformSelector = new JComboBox<>(transformOptions);
        JTextField param1Field = new JTextField(5);
        JTextField param2Field = new JTextField(5);
        JButton applyButton = new JButton("Apply");

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Transform:"));
        controlPanel.add(transformSelector);
        controlPanel.add(new JLabel("Param 1:"));
        controlPanel.add(param1Field);
        controlPanel.add(new JLabel("Param 2:"));
        controlPanel.add(param2Field);
        controlPanel.add(applyButton);

        applyButton.addActionListener(e -> {
            try {
                double p1 = Double.parseDouble(param1Field.getText());
                double p2 = Double.parseDouble(param2Field.getText());
                String type = (String) transformSelector.getSelectedItem();
                panel.applyTransformation(type, p1, p2);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers.");
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(controlPanel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
