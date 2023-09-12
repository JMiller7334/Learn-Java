import java.util.Arrays;
import java.util.Date;

public class Main {


    static class myVariables {
        //primitive type practice
        byte age = 29; //byte is best for numbers that are not long.
        long viewCount = 3_123_456_789L; /*long: best for long numbers
    notice the _s act as ,s. The L at the end declares it as a long number*/

        float price = 10.99F; //notice the f is needed to declare a float

        char string = 'A'; // single character should be declared with ''s

        boolean onOff = true; // boolean value; it is true or false.
        static String stringMulti = "This is a string"; //java string!

        //creating a date (because I never have these)
        static Date myDate = new Date();

        int[] myArray;

        //below is the constructor of this class.
        public myVariables(int[] myArray){
            this.myArray = myArray;
        }
    }
    private final myVariables instanceVariables; // Stored reference to the instance variables
    /*This private var is important because it is used to reference all the variables for this
    class instance of myVariables after they are initialized

    * */



    /*note that static declares methods and variables as a member
    * of the class and not just a specific instance of the class.*/
    public static String getStringMultiAsUpper() {
        return myVariables.stringMulti.toLowerCase();
    }

    static String asUpper = getStringMultiAsUpper();


    public int iterateArray(int[] array){
        System.out.println("func: for loop: - will return index");


        int i = 0; //this variable could be
        /*below we create a loop that will iterate over the array that is passed into this func.*/
        for (i =0; i < array.length; i++){
            System.out.println("loop@" + i + " index, value: " + array[i]);
        }
        //return the index back
        return i;
    }


    //this function will make changes to only this instance of the class
    // because it is not a static function.
    public void changeVarsUnique(){
        instanceVariables.onOff = false;
        instanceVariables.myArray[1] = 3;
        System.out.println(Arrays.toString(instanceVariables.myArray));
        int indexTotal = this.iterateArray(instanceVariables.myArray);

        System.out.println(indexTotal);
    }

    //init for the class of main notice the call to init the constructor on the nest class within(myVariables)
    public Main(){
        int[] initMyArray =  {1, 2, 3};
        instanceVariables = new myVariables(initMyArray);

        //the print statement returns true (as expect)
        System.out.println("myNewClass: var on/off: " + instanceVariables.onOff);
    }

    public static void main(String[] args) {
        //print calendar date:
        System.out.println("Now I have a date at: " + myVariables.myDate);

        //print string in uppercase:
        System.out.println("To upper:" + asUpper);

        //create an instance of this class so the non-static function can be called.
        // note: type declaration before the variable name and initialization of the class
        Main myNewClass = new Main();


        //access the function below:
        myNewClass.changeVarsUnique();

        //the print statement returns false (as expect)
        System.out.println("myNewClass: var on/off: " + myNewClass.instanceVariables.onOff);
    }
}


