// Executable simulator

import javax.swing.*;
import java.io.FileNotFoundException;

public class NBody {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        CelestialBodies bodies = new CelestialBodies();
        JFrame frame = new JFrame();
        frame.setSize(bodies.width,bodies.height);
        frame.setTitle("Celestial Body Simulation");
        frame.setVisible(true);
        frame.add(bodies);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bodies.simulate();
    }

}
