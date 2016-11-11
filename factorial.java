import java.util.*;
class factorial
{
public static void main(String args[ ])
{
System.out.println("Enter the values");
Scanner sc=new Scanner(System.in);
int num=sc.nextInt( );
int i,fact=1;
for(i=1;i<=num;i++)
{
fact=fact*i;
System.out.println(fact);
}
}
}