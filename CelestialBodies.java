import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.InterruptedException;

public class CelestialBodies extends JPanel {

    public  java.util.List<CelestialBody> celestialBodyList;
    public int width, height;
    public double scale;
    public CelestialBodies() throws FileNotFoundException {
        celestialBodyList = new ArrayList<>();
        width = 768;
        height = 768;
        readData();
    }
    public void drawing() {
        repaint();
    }

    public void simulate() throws InterruptedException {
       while (true) {
           Thread.sleep(4000);
           // Delaying the simulation to view the output before the bodies leave
           move();
           repaint();
       }
    }

    public void move() {
        for (CelestialBody body: celestialBodyList) {
            body.move();
        }
    }

    public void paintComponent(Graphics g) {
        // Using Graphics to create bodies 
        super.paintComponent(g);
        for (CelestialBody body: celestialBodyList) {
            g.setColor(Color.RED);
            g.fillOval((int)body.x, (int)body.y, body.size, body.size);
        }
    }

    public void readData() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("nbody_input.txt"));
        // Reading file
        int line = 0;
        while (scanner.hasNext()) {
            String lineString  = scanner.nextLine();
            if (line == 0) {
            } else if (line == 1) {
                scale = Double.parseDouble(lineString);
            } else {
                createBody(lineString);
            } line++;
        }
    }

    public void createBody(String s) {
        System.out.println(s);
        String [] lineArray = s.split(",");
        // CSV file split and adding the planets with the data
        celestialBodyList.add(
                new CelestialBody(
                        lineArray[0],
                        Double.parseDouble(lineArray[1]),
                        Integer.parseInt(lineArray[2]),
                        Integer.parseInt(lineArray[3]),
                        Double.parseDouble(lineArray[4]),
                        Double.parseDouble(lineArray[5]),
                        Integer.parseInt(lineArray[6])
                )
        );
    }

}
