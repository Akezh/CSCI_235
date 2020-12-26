import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Animator implements ActionListener {

    private Aquarium aquarium;

    public Animator(Aquarium aquarium) {
        this.setAquarium(aquarium);
    }

    public void actionPerformed(ActionEvent arg0) {

        // Get the drawing panel from the aquarium
        Aquarium aquarium = this.getAquarium();
        DrawingPanel dPanel = aquarium.getDrawingPanel();

        // Move everything one step, and repaint everything
        dPanel.moveEverythingOneStep();
        dPanel.repaint();
    }

    public Aquarium getAquarium() {
        return aquarium;
    }

    public void setAquarium(Aquarium aquarium) {
        this.aquarium = aquarium;
    }

}
