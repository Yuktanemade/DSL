
import java.util.Scanner;
public class LinearSearch
{
    public static void main(String[] args)
     {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elemnts of array:");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }

        System.out.print("Enter element to search:");
        int key=sc.nextInt();
        boolean flag=true;

        for(int i=0;i<n;i++)
        {
            if (arr[i]==key)
            {
                System.out.println("Element found at "+ i +" index");
                flag=true;
                break;
            }
        
           
        }
        
        if(!flag)
        {
            System.out.println("Element Not found");
        }
            
    sc.close();

          
            

}
        
    
}