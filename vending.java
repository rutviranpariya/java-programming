import java.util.Scanner;
enum coin{
    ONE, TWO, FIVE, TEN
}
public class vending
{
    public static void main(){
Scanner sc= new Scanner(System.in);
int total=0;
final int price=15;

System.out.println("Enter the coins");
while(total<price)
{
String s=sc.next().toUpperCase();
coin cn=coin.valueOf(s);

int result=switch(cn)
{
case ONE->1;
case TWO->2;
case FIVE->5;
case TEN->10;
};
total+=result;
}
System.out.println("Exchange is " + (total-15));


    }
}