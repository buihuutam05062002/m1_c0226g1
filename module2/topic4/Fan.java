package topic4;

public class Fan {
    static final int SLOW = 1;
    static final int MEDIUM = 2;
    static final int FAST = 3;

    private int speed = SLOW;
    private boolean on;
    private double radius = 5;
    private String color = "blue";


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        if (!this.on) {
            return "fan is off";
        } else {
            return "speed " + this.speed + "\n" + "color " + this.color + "\n" + "radius " + this.radius + "\n" + "fan is on";
        }
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.speed = 10;
        fan1.radius = 10;
        fan1.color = "yellow";
        fan1.on = true;

        Fan fan2 = new Fan();
        fan2.speed = 10;
        fan2.radius = 10;

        System.out.println(fan1);

        System.out.println("/------------------------/");
        System.out.println(fan2);
    }
}
