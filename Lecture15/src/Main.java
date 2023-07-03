// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Numbers[] numbersArray = new Numbers[3];

        // Create Numbers objects and assign hem to array elements
        Numbers number1 = new Numbers("N", 1);
        Numbers number2 = new Numbers("S", 2);
        Numbers number3 = new Numbers("Three", 3);

        numbersArray[0] = number1;
        numbersArray[2] = number2;
        numbersArray[1] = number3;



        Lecture15.mergeSort(numbersArray, new Numbers());

        for(Numbers ele: numbersArray){
            System.out.println(ele.getNumber());
        }


    }
}