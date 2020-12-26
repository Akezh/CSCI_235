import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.Color;
import javax.swing.border.EtchedBorder;


public class Aquarium extends JFrame {

    private DrawingPanel drawingPanel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Aquarium frame = new Aquarium();
                    frame.setVisible(true);
                    frame.addContents();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Aquarium() {
        super("Aquarium");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        drawingPanel = new DrawingPanel();
        drawingPanel.setBackground(Color.CYAN);
        drawingPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        drawingPanel.setLayout(new BorderLayout(0, 0));
        setContentPane(drawingPanel);

        // The animator is a handler that updates the position and repaints the aquarium
        // whenever it detects an ActionEvent
        Animator animator = new Animator(this);

        // The Timer object will fire off an ActionEvent every 50 ms, and alert the
        // animator listener/handler which is being registered here
        Timer timer = new Timer(50, animator);

        // Timers have to be started
        timer.start();
    }

    /*
     * This method adds bubbles and fish to the aquarium
     */
    public void addContents() {
        DrawingPanel dPanel = this.getDrawingPanel();

        // new Fish(drawArea, imageFile, speed, facingRight)
        dPanel.addDrawableItem(new Fish(dPanel, "Clownfish.gif", 11, false, true));
        dPanel.addDrawableItem(new Fish(dPanel, "PezTropical.gif", 5, true, false));
        dPanel.addDrawableItem(new Fish(dPanel, "tropical.gif", 10, true, true));

        // new Bubble(drawArea, size, speed)
        dPanel.addDrawableItem(new Bubble(dPanel, 18, 6));
        dPanel.addDrawableItem(new Bubble(dPanel, 30, 5));
        dPanel.addDrawableItem(new Bubble(dPanel, 20, 3));
        dPanel.addDrawableItem(new Bubble(dPanel, 25, 4));
        dPanel.addDrawableItem(new Bubble(dPanel, 25, 5));
        dPanel.addDrawableItem(new Bubble(dPanel, 25, 4));
        dPanel.addDrawableItem(new Bubble(dPanel, 35, 5));
        dPanel.addDrawableItem(new Bubble(dPanel, 30, 3));

        // Set the position of the fish and bubbles
        dPanel.initializeEverything();
    }

    public DrawingPanel getDrawingPanel() {
        return drawingPanel;
    }

    public void setDrawingPanel(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }
}