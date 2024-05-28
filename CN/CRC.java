import java.util.Scanner;




public class CRC{

    static int[] dividedd(int old[],int divisor[]){
        int rem[]=new int [divisor.length];
        int i;
        int data[]=new int[old.length+divisor.length];
        System.arraycopy(old,0,data,0,old.length);
        System.arraycopy(data,0,rem,0,divisor.length);
        for(i=0;i<old.length;i++){
            System.out.println("remainder");
            if(rem[0]==1){
                for(int j=1;j<divisor.length;j++){
                    rem[j-1]=exoro(rem[j],divisor[j]);
                    System.out.print(rem[j-1]);
                }
            }
            else{
                for(int j=1;j<divisor.length;j++){
                    rem[j-1]=exoro(rem[j],0);
                    System.out.print(rem[j-1]);
                }
            }
            rem[divisor.length-1]=data[i+divisor.length];
            System.out.println(rem[divisor.length-1]);
        }
        return rem;

    }



    static int exoro(int x,int y){
        if(x==y){
            return 0;
        }
        else{
            return 1;
        }
    }
    static void recievedata(int data[],int divisor[]){
        int rem[] = dividedd(data,divisor);
        for(int i=0;i<rem.length;i++){
            if(rem[i]!=0){
                System.out.println("Corrupted data");
                return;
            }
        }

        System.out.println("Data recieved without any error");

    }








    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of date aray");
        int size = sc.nextInt();
        int data[] = new int[size];
        System.out.println("Enter data");
        for(int i=0;i<size;i++){
            data[i] = sc.nextInt();

        }
        System.out.println("Enter size of divisor array: ");
        int divisorSize = sc.nextInt();
        int divisor[] = new int[divisorSize];
        System.out.println("Enter divisor: ");
        for(int i=0;i<divisorSize;i++){
            divisor[i] = sc.nextInt();
        }
        int rem[] = dividedd(data,divisor);
        for(int i=0;i<rem.length;i++){
            System.out.print(rem[i]);
        }
        System.out.println("Generated CRC code");
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]);
        }
        for(int i=0;i<rem.length;i++){
            System.out.print(rem[i]);
        }
        int sentdata[]=new int[data.length+rem.length-1];
        System.out.println("enter bits in array which will be sent");
        for(int i=0;i<sentdata.length;i++){
            sentdata[i]=sc.nextInt();
        }
        recievedata(sentdata,divisor);
    }
}





/*
 * / import required classes and packages  
package javaTpoint.MicrosoftJava;  
import java.util.*;  
// create CRCExample class to demonstrate the working of Cyclic Redundancy Check  
class CRCExample {  
    // main() method start  
    public static void main(String args[]) {  
        // create scanner class object to take input from user  
        Scanner scan = new Scanner(System.in);  
        // declare n for the size of the data  
        int size;  
        // take the size of the data from the user  
        System.out.println("Enter the size of the data array: ");  
        size = scan.nextInt();  
        // declaration of the data array  
        int data[] = new int[size];  
        // take bits of the data from the user  
        System.out.println("Enter data bits in the array one by one: ");  
        for(int i = 0 ; i < size ; i++) {  
            System.out.println("Enter bit " + (size-i) + ":");  
            data[i] = scan.nextInt();  
        }  
        // take the size of the divisor from the user  
        System.out.println("Enter the size of the divisor array:");  
        size = scan.nextInt();  
        // declaration of the divisor array  
        int divisor[] = new int[size];  
        System.out.println("Enter divisor bits in the array one by one: ");  
        for(int i = 0 ; i < size ; i++) {  
            System.out.println("Enter bit " + (size-i) + ":");  
            divisor[i] = scan.nextInt();  
        }  
    // Divide the input data by the input divisor and store the result in the rem array  
        int rem[] = divideDataWithDivisor(data, divisor);  
        // iterate rem using for loop to print each bit  
        for(int i = 0; i < rem.length-1; i++) {  
            System.out.print(rem[i]);  
        }  
        System.out.println("\nGenerated CRC code is: ");  
          
        for(int i = 0; i < data.length; i++) {  
            System.out.print(data[i]);  
        }  
        for(int i = 0; i < rem.length-1; i++) {  
            System.out.print(rem[i]);  
        }  
        System.out.println();  
        // we create a new array that contains the original data with its CRC code  
        // the size of the sentData array with be equal to the sum of the data and the rem arrays length  
        int sentData[] = new int[data.length + rem.length - 1];  
        System.out.println("Enter bits in the array which you want to send: ");  
        for(int i = 0; i < sentData.length; i++) {  
            System.out.println("Enter bit " +(sentData.length - 1)+ ":");  
            sentData[i] = scan.nextInt();  
        }  
        receiveData(sentData, divisor);  
    }  
    // create divideDataWithDivisor() method to get CRC  
    static int[] divideDataWithDivisor(int oldData[], int divisor[]) {  
        // declare rem[] array  
        int rem[] = new int[divisor.length];  
        int i;  
        int data[] = new int[oldData.length + divisor.length];  
    // use system's arraycopy() method for copying data into rem and data arrays  
        System.arraycopy(oldData, 0, data, 0, oldData.length);  
        System.arraycopy(data, 0, rem, 0, divisor.length);  
        // iterate the oldData and exor the bits of the remainder and the divisor  
        for(i = 0; i < oldData.length; i++) {  
            System.out.println((i+1) + ".) First data bit is : "+ rem[0]);  
            System.out.print("Remainder : ");  
            if(rem[0] == 1) {  
                // We have to exor the remainder bits with divisor bits  
                for(int j = 1; j < divisor.length; j++) {  
                    rem[j-1] = exorOperation(rem[j], divisor[j]);  
                    System.out.print(rem[j-1]);  
                }  
            }  
            else {  
                // We have to exor the remainder bits with 0  
                for(int j = 1; j < divisor.length; j++) {  
                    rem[j-1] = exorOperation(rem[j], 0);  
                    System.out.print(rem[j-1]);  
                }  
            }  
            // The last bit of the remainder will be taken from the data  
            // This is the 'carry' taken from the dividend after every step  
            // of division  
            rem[divisor.length-1] = data[i+divisor.length];  
            System.out.println(rem[divisor.length-1]);  
        }  
        return rem;  
    }  
    // create exorOperation() method to perform exor data  
    static int exorOperation(int x, int y) {  
        // This simple function returns the exor of two bits  
        if(x == y) {  
            return 0;  
        }  
        return 1;  
    }  
    // method to print received data   
    static void receiveData(int data[], int divisor[]) {  
       
        int rem[] = divideDataWithDivisor(data, divisor);  
        // Division is done  
        for(int i = 0; i < rem.length; i++) {  
            if(rem[i] != 0) {  
                // if the remainder is not equal to zero, data is currupted  
                System.out.println("Currupted data received...");  
                return;  
            }  
        }  
        System.out.println("Data received without any error.");  
    }  
}  
 */



/*Enter size of date aray
6
Enter data
1 0 0 1 0 0
Enter size of divisor array: 
4
Enter divisor: 
1 1 0 1
remainder
1000
remainder
1010
remainder
1110
remainder
0110
remainder
1100
remainder
0010
0010Generated CRC code
1001000010enter bits in array which will be sent
1 0 0 1 0 0 0 0 1
remainder
1000
remainder
1010
remainder
1110
remainder
0110
remainder
1101
remainder
0000
remainder
0000
remainder
0000
remainder
0000
Data recieved without any error */






 