import java.util.Scanner;


public class LinearEquationLogic {
    private LinearEquation coordinates;
    private Scanner myScanner;


    public LinearEquationLogic(){
        coordinates = null;
        myScanner = new Scanner(System.in);
    }


    public void start(){
        System.out.println("Welcome to the linear equation calculator!");
        getCoordinateInfo();
        printData();
    }


    private void getCoordinateInfo(){
        System.out.print("Enter coordinate 1: ");
        String cord1 = myScanner.nextLine();

        int idx1 = cord1.indexOf("(" + ",");
        String cordX = cord1.substring(1,2);
        int x1 = Integer.parseInt(cordX);
        String cordY = cord1.substring (4,5);
        int y1 = Integer.parseInt(cordY);

        System.out.println("Enter coordinate 2: ");
        String cord2 = myScanner.nextLine();
        String cordX2 = cord2.substring(1,2);
        int x2 = Integer.parseInt(cordX2);
        String cordY2 = cord2.substring(4,5);
        int y2 = Integer.parseInt(cordY2);

        coordinates = new LinearEquation(x1, y1, x2, y2);
    }

    private void printData() {
        coordinates.lineInfo();
        System.out.print("Enter a value for x: ");
        int xVal = myScanner.nextInt();
        coordinates.coordinateForX(xVal);
        System.out.println("The point on the line is " + coordinates.coordinateForX(xVal));
        System.out.print("Would you like to enter another pair of coordinates? y/n: ");
        myScanner.nextLine();
        String yOrN = myScanner.nextLine();
        if (yOrN.equals ("y")){
            getCoordinateInfo();
            printData();
        } else {
            System.out.println("Thank you for using the slope calculator, goodbye!");
        }

    }
}
