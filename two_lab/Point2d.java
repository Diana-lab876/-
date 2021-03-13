package two_lab;

public class Point2d {
    private double xCoord;
    private double yCoord;
    public Point2d ( double x, double y) {
        xCoord = x;
        yCoord = y;
        }
        public Point2d () {
            this(0, 0);
        }
        public double getX () {
            return xCoord;
            }
            public double getY () {
                return yCoord;
                }
                public void setX ( double val) {
                    xCoord = val;
                    }
                    public void setY ( double val) {
                        yCoord = val;
                        }      

}
public class Point3d extends Point2d{
    private double zCoord;
    public Point3d( double x, double y, double z) {
        zCoord = z;
    }
    public Point3d() {
        this(0, 0, 0);
    }
    public double getz () {
        return zCoord;
    }
    public void setZ (double val) {
        zCoord = val;
    }
}
