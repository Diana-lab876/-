import java.util.Scanner;
public class Lab1 extends Point3d {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите координаты первой точки: ");
        double x1 = in.nextInt();
        double y1 =in.nextInt();
        double z1 =in.nextInt();
        System.out.println("Введите координаты второй точки: ");
        double x2 =in.nextInt();
        double y2 =in.nextInt();
        double z2 =in.nextInt();
        System.out.println("Введите координаты третьей точки: ");
        double x3 =in.nextInt();
        double y3 =in.nextInt();
        double z3 =in.nextInt();
        in.close();
        Point3d point3d_1= new Point3d(x1, y1, z1);
        Point3d point3d_2= new Point3d(x2, y2, z2);
        Point3d point3d_3= new Point3d(x3, y3, z3);
        System.out.println(computeArea(point3d_1, point3d_2, point3d_3));
    }

    public static double computeArea(Point3d point3d_1, Point3d point3d_2, Point3d point3d_3){
        double a = point3d_1.distanceTo(point3d_2); //Вычисление стороны a
        double b = point3d_2.distanceTo(point3d_3); //Вычисление стороны b
        double c = point3d_3.distanceTo(point3d_1); //Вычисление стороны c
        double p = ((a+b+c)/2); //Вычисление полупериметра
        double S = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        double s2=Math.round(S*100)/100D;
        return (s2); //Возвращаемое значение
    }
    public static boolean checkPoints(Point3d p1, Point3d p2, Point3d p3) //Проверка на совпадение точек
    {
        if (((p1.getX() == p2.getX()) && (p1.getY() == p2.getY()) && (p1.getZ() == p2.getZ())) ||
        ((p2.getX() == p3.getX()) && (p2.getY() == p3.getY()) && (p2.getZ() == p3.getZ())) ||
        ((p1.getX() == p3.getX()) && (p1.getY() == p3.getY()) && (p1.getZ() == p3.getZ())))
        return false;
        else 
        return true;
    }

}
