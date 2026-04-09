package topic6;

public class Point3D extends Point2D {
    private float z;


    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        return new float[]{this.getX(), this.getY(), this.getZ()};
    }

    public void setXYZ(float x, float y, float z) {
        this.setXY(x, y);
        this.setZ(z);
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "z=" + z +
                "} " + super.toString();
    }


    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        point2D.setXY(5, 6);
        System.out.println(point2D.toString());

        Point3D point3 = new Point3D();
        point3.setXYZ(4, 6, 7);
        System.out.println(point3);

    }
}
