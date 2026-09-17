abstract class employee
{
    String name;
    int id;

    employee(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    abstract double salary();
}

class fulltime extends employee
{
    double salary;

    fulltime(String name, int id, double salary)
    {
        super(name, id);
        this.salary = salary;
    }

    double salary()
    {
        return salary;
    }
}

class parttime extends employee
{
    int hours;
    double rate;

    parttime(String name, int id, int hours, double rate)
    {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    double salary()
    {
        return hours * rate;
    }
}

class intern extends employee
{
    double stipend;

    intern(String name, int id, double stipend)
    {
        super(name, id);
        this.stipend = stipend;
    }

    double salary()
    {
        return stipend;
    }
}

public class practical5_2
{
    public static void main(String[] args)
    {
        employee[] employees =
        {
            new fulltime("Rahul", 101, 50000),
            new intern("Amit", 102, 10000),
            new parttime("Neha", 103, 80, 3000),
            new fulltime("Priya", 104, 60000)
        };

        double total = 0;

        for(employee e : employees)
        {
            double salary = e.salary();

            System.out.println(
                e.name + " (ID: " + e.id + ") Salary = " + salary
            );

            if(e instanceof intern)
            {
                System.out.println("Note: This employee is an intern");
            }

            total = total + salary;
        }

        System.out.println("Total Salary = " + total);
    }
}