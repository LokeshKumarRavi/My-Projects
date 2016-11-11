import java.util.*;
class palindrome1
{
public static void main(String args[ ])
{
System.out.println("Enter the Values");
Scanner sc=new Scanner(System.in);
String s1=sc.next( );
String s2=sc.next( );
char [ ] ch=s1.toCharArray( );
char [ ] ch1=s2.toCharArray( );
for(int i=0;i<6;i++)
{
if(ch[i]==ch1[i])
{
System.out.println("Palindrome");
}
else
{
System.out.println("not a Palindrome");
break;
}
}
}
}