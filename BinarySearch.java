
import java.util.Scanner;

public class BinarySearch {
        public static int binarySearch(int[] arr,int low,int high,int key)
        {
            if(low>high)
            {
                return -1;
            }

            int mid=(low+high)/2;
            if(arr[mid]==key)
            {
            return mid;
            }
            else if(arr[mid]>key){
                return binarySearch(arr, low, mid-1, key);
            }
            else{
                return binarySearch(arr, mid+1, high, key);
            }
        }   


public static void main(String[] args)
{   
   Scanner sc=new Scanner(System.in);
   System.out.println("enter size of array:");
   int n=sc.nextInt();
   int [] arr=new int[n];
        System.out.println("Enter elements in sorted order:");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
   
    System.out.println("Enter element to search");
    int key=sc.nextInt();

    int result=binarySearch(arr,0,n-1,key);

    if(result!=-1){
    System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
}
}
