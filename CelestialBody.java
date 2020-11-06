// Constructing Bodies

public class CelestialBody {
    public double x, y;
    public int size;
    public String name;
    public double mass, vX, vY;

    public CelestialBody(String name, double mass, int x, int y, double vX, double vY, int size) {
        this.name = name;
        this.mass = mass;
        this.x = x;
        this.y = y;
        this.vX = vX;
        this.vY = vY;
        this.size = size;
    }

    public void move() {
        // Moving bodies taking in account mass and speed
        double f = 10 * mass / (size * size);
        double speed = mass * 10 -f;
        x+=vX*f;
        y+=vY*f;
        
    }
}
