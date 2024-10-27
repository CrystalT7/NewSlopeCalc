public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double distance (){
        double diffX = x2 - x1;
        double diffY = y2 - y1;
        double sumOfPow = Math.pow(diffX,2) + Math.pow(diffY, 2);
        double distance = Math.sqrt(sumOfPow);
        distance = Math.round(distance * 100)/100.0;
        return distance;
    }

    public double yIntercept (){
        double yDiff = (double) y2-y1;
        double xDiff = (double) x2-x1;
        double slope = yDiff/xDiff;
        double slopeTimeX = slope * x1;
        if (slopeTimeX < 0){
            double yInt = y1-slopeTimeX;
            yInt = roundedToHundredth(yInt);
            return yInt;
        }
        if (slopeTimeX > 0){
            double yInt = y1-slopeTimeX;
            yInt = roundedToHundredth(yInt);
            return yInt;
        } else {
            double yInt = y1;
            return yInt;
        }
    }

    public double slope(){
        double slope = (double) (y2-y1)/(x2-x1);
        slope = Math.round(slope * 100)/100.0;
        return slope;
    }

    public String equation(){
        if(y1==y2){
            String equation = "y = " + y1;
            return equation;
        }
        if(x1==x2){
            String equation = "x = " + x1;
            return equation;
        } else {
            double yInt = yIntercept();
            int diffY = y2 - y1;
            int diffX = x2 - x1;
            String slope = diffY + "/" + diffX;
            String equation = "y = " + slope + "x + " + yInt;
            if (diffY%diffX == 0){
                int whole = diffY/diffX;
                String wholeEquation = "y = " + whole + "x + " + yInt;
                return wholeEquation;
            } else {
                return equation;
            }
        }
    }

    public String coordinateForX(double x){
        double yValue = (slope() * x) + yIntercept();
        yValue = Math.round(yValue * 100)/100.0;
        String coordinates = "(" + x + ", " + yValue + ")";
        return coordinates;
    }

    public String lineInfo(){
        String points = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n";
        String equation = "The equation of the lne between these points is: " + equation() + "\n";
        String yInt = "The y-intercept of this line is: " + yIntercept() + "\n";
        String slope = "The slope of this line is: " + slope() + "\n";
        String distance = "The distance between these points is " + distance() + "\n";
        if(x1 == x2){
            String equationOnVert = "The points are on a vertical line: " + equation() + "\n";
            return equationOnVert;
        } else {
            return points + equation + yInt + slope + distance;
        }
    }

    private double roundedToHundredth(double toRound){
        return Math.round(toRound*100)/100.0;
    }
}
