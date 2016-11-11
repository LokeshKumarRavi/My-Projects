class Testarray1{  
public static void main(String args[]){   
int a[]=new int[3];
a[0]=10;
a[1]=20;  
a[2]=70; 
try
{
for(int i=0;i<3;i++)
System.out.println(a[i]);
}
catch(Exception ex)
{
System.out.println("Exception  Handling");
}
}}  