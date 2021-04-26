package three_lab;

public class Location {
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }
    @Override
    //Метод equals() — сравнивает два объекта.
    public boolean equals(Object obj) {
        //проверить сравниваем ли мы объект с самим собой
        if (this == obj) return true;
        //getClass() - получает класс объекта во время выполнения
        //сравнение объектов двух одинаковых классов.
        //также проверка не равен ли объект null
        if (obj == null || getClass() != obj.getClass()) return false;
        Location one = (Location) obj;
        //проверяем у координату 
        if (yCoord != one.yCoord) return false;
        //проверяем х координату
        return xCoord==one.xCoord;
     }
     @Override
     //метод hashCode() возвращает для любого объекта 32-битное число типа int. 
     public int hashCode(){
         int prime = 31;
        int result = 17; // Простое число

        // используется другое простое число для перемножения
        result = prime * result + (int)xCoord;
        result = prime * result + (int)yCoord;
        return result;
     }   
}
