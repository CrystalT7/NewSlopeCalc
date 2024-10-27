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

        int x1 = parseIntForX(cord1);
        int y1 = parseIntForY(cord1);

        System.out.print("Enter coordinate 2: ");
        String cord2 = myScanner.nextLine();

        int x2 = parseIntForX(cord2);
        int y2 = parseIntForY(cord2);

        coordinates = new LinearEquation(x1, y1, x2, y2);
    }

    private void printData() {
        System.out.println();
        System.out.println(coordinates.lineInfo());
        System.out.print("Enter a value for x: ");
        double xVal = myScanner.nextDouble();
        coordinates.coordinateForX(xVal);
        System.out.println();
        System.out.println("The point on the line is " + coordinates.coordinateForX(xVal));
        System.out.println();
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

    private int parseIntForX(String coordinate){
        int idx1 = coordinate.indexOf("(");
        int idx2 = coordinate.indexOf(",");
        String cordX = coordinate.substring(idx1 + 1, idx2);
        int x = Integer.parseInt(cordX);
        return x;
    }

    private int parseIntForY(String coordinate){
        int idx3 = coordinate.indexOf(" ");
        int idx4 = coordinate.indexOf(")");
        String cordY = coordinate.substring(idx3 + 1, idx4);
        int y = Integer.parseInt(cordY);
        return y;
    }
}

