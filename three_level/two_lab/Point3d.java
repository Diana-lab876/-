package two_lab;

//import javax.lang.model.util.ElementScanner6;

public class Point3d extends Point2d {
    public static void main(String[] args){
        //System.out.println(distanceTo(4,5,6));
    }
    private double zCoord;
    public Point3d(double x, double y, double z){
        super(x,y);
        zCoord=z;
    }
    public Point3d () {
        this(0.0, 0.0, 0.0);
    }
    public double getZ () {
        return zCoord;
    }
    public void setZ ( double val) {
        zCoord = val;
    }
    public boolean Equalityoftwopoints(Point3d points){
        //метод для сравнения значений двух объектов Point3d.
        if (this.getX() == points.getX() && this.getY() == points.getY() && this.getZ() == points.getZ())
        return true;
        else
        return false; 
    }
    public double distanceTo(Point3d point){
        //вычисляет расстояние между двумя точками с точность двух знаков после запятой и возвращает полученное значение.
        if(!this.Equalityoftwopoints(point)){
            double Xcoordinate = Math.pow(this.getX() - point.getX(), 2.0);
            double Ycoordinate = Math.pow(this.getY() - point.getY(), 2.0);
            double Zcoordinate = Math.pow(this.getZ() - point.getZ(), 2.0);
            double distance = Math.sqrt(Xcoordinate + Ycoordinate + Zcoordinate);
            distance = Math.round(distance*100)/100D;
            return distance;
        }
        else 
        return 0.0;
    }
    
}
