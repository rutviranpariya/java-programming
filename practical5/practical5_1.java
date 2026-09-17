abstract class shapes
{
    abstract double area();
}

class circle extends shapes
{
    double radius;

    circle(double radius)
    {
        this.radius = radius;
    }

    double area()
    {
        return 3.14 * radius * radius;
    }
}

class rectangle extends shapes
{
    double length;
    double width;

    rectangle(double length, double width)
    {
        this.length = length;
        this.width = width;
    }

    double area()
    {
        return length * width;
    }
}

class triangle extends shapes
{
    double height;
    double base;

    triangle(double height, double base)
    {
        this.height = height;
        this.base = base;
    }

    double area()
    {
        return 0.5 * height * base;
    }
}

public class practical5_1
{
    public static void main(String[] args)
    {
        shapes[] shapeArray =
        {
            new circle(5),
            new rectangle(5, 2),
            new triangle(5, 2)
        };

        double total = 0;
        double largest = 0;

        for(shapes s : shapeArray)
        {
            double a = s.area();

            System.out.println("Area = " + a);

            total = total + a;

            if(a > largest)
            {
                largest = a;
            }
        }

        System.out.println("Total Area = " + total);
        System.out.println("Largest Area = " + largest);
    }
}