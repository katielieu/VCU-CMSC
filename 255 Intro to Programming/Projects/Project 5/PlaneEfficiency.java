package Projects.Project5;

import java.util.Arrays;

/**
 * PlaneEfficiency.java
 *
 * Find the most efficient cargo planes that meets VCU's metrics
 *_____________________________________________________
 * Katie Lieu
 * 3/22/24
 * CMSC 255 Section 4
 */

public class PlaneEfficiency {
    public static void main(String[] args) {

        //pass the first command line argument (args[0]) to the getMetrics method and assign it to a variable
        String[] metrics = getMetrics(args[0]);

        //pass the second command line arg (args[1]) to the getPlaneData method and assign it to a variable
        double[][] planeData = getPlaneData(args[1]);

        //pass the result of getPlaneData to the findPlaneViability method and print the result
        System.out.println("Planes above the viability criteria are: " + Arrays.toString(findPlaneViability(planeData)));

        //pass the results of getMetrics to the searchHighestMetric method
        //print the result
        System.out.println("The two highest value efficiency metrics for plane 1 are: " + searchHighestPlaneMetric(planeData, metrics, 1));

        //pass the result of getMetrics and getPlaneData to the searchHighestPlane method
        //print the result
        System.out.println("The plane with the highest weight-capacity is: " + searchHighestPlane(planeData, metrics, "weight-capacity"));
    }

    /**
     * getMetrics - separates the given efficiency
     * metrics and adds them to a 1d array
     *
     * @param efficiencyMetrics
     * @return metricsArray, a string array of elements in the param
     */

    public static String[] getMetrics(String efficiencyMetrics) {
        //initialize string array metricsArray and set it to efficiencyMetrics.split(",")
        String[] metricsArray = efficiencyMetrics.split(",");
        //return metricsArray
        return metricsArray;
    }

    /**
     * getPlaneData - separate the given values and
     * fill in a 2d array of the metrics and values
     *
     * @param planes
     * @return planeData, a 2d array of elements in the param
     */
    public static double[][] getPlaneData(String planes) {

        //the number of rows
        //initialize numPlanes to getNumPlanes(planes)
        int numPlanes = getNumPlanes(planes);
        //the number of columns
        //initialize numMetrics to getNumMetrics(planes)
        int numMetrics = getNumMetrics(planes);
        //initialize double[][] planeData and set it to a new double[numPlanes][numMetrics]
        double[][] planeData = new double[numPlanes][numMetrics];
        //split planes by commas to separate the rows
        String[] firstSplit = planes.split("<>");
        //for each row in planeData
        for (int row = 0; row < planeData.length; row++) {
            //fillInValuesOfRow(row, split, planeData[row])
            fillInValuesOfRow(row, firstSplit, planeData[row]);
        }

        return planeData;

    }

    /**
     * Get the number of planes by splitting up planes
     *
     * @param planes, the string of values
     * @return the length of the resulting array
     */
    public static int getNumPlanes(String planes) {
        return planes.split("<>").length;
    }

    /**
     * Get the values of the first plane and get the length of that
     *
     * @param planes, the string of values
     * @return the length of the first plane’s values
     */
    public static int getNumMetrics(String planes) {
        //initialize plane1Values to (planes.split(“<>”)[0])
        String plane1Values = planes.split("<>")[0];
        return plane1Values.split(",").length;
    }

    /**
     * Take values from planes and fill in planeData
     *
     * @param row,       to determine the row to fill in
     * @param firstSplit,     the string array of planes' first split
     * @param planeData, the memory location
     */
    public static void fillInValuesOfRow(int row, String[] firstSplit, double[] planeData) {
        //String[] secondSplit = split firstSplit by commas;
        String[] secondSplit = firstSplit[row].split(",");
        //for each row in planeValues split by ","
        for (int col = 0; col < firstSplit.length; col++) {
            //make a variable to convert string to double to then input into planeData
            double value = Double.parseDouble(secondSplit[col]);
            planeData[col] = value;
        }
    }


    /**
     * findPlaneViability - searches for the
     * planes that achieve adequate viability
     *
     * @param planes
     * @return validPlanes, an int array of the planes
     * that attains the score of 83 or more
     */

    public static int[] findPlaneViability(double [][] planes){
        //initialize viability variable
        double viability;
        //make an empty array for the qualifying planes
        int[] validPlanes = {};
        //for int row = 0 to planes length by 1
        for (int row = 0; row < planes.length; row++) {
            //initialize each metric value variable
            double mpg = planes[row][0];
            double maintenanceCosts = planes[row][3];
            double lifespan = planes[row][5];
            double volumeCapacity = planes[row][1];
            double weightCapacity = planes[row][2];
            double landingDistance = planes[row][4];

            //calculate viability for each plane
            viability = (((mpg * 100) + maintenanceCosts) / (2 * lifespan)) * (volumeCapacity / 700) * (weightCapacity / 83) * (((2.4 - landingDistance) / 2.4) + 0.5);

            if (viability >= 83) {
                //add an element to the validPlanes array
                validPlanes = Arrays.copyOf(validPlanes, validPlanes.length + 1);

                //make the new element the next qualifying plane number (which is the row + 1)
                validPlanes[validPlanes.length - 1] = row + 1;
            }
        }
        return validPlanes;

    }

    /**
     * searchHighestMetric - search the given plane for its
     * two highest value metrics and return them in order
     *
     * @param planes
     * @param metrics
     * @param planeNumber
     * @return metric1 and metric2 as a String
     */

    public static String searchHighestPlaneMetric(double [][]
                                                     planes, String[] metrics, int planeNumber){
        //initialize index1 = 0, index2 = 0, max1 = 0, max2 = 0
        int index1 = 0;
        int index2 = 0;
        double max1 = 0;
        double max2 = 0;
        //initialize metric1, metric2
        String metric1 = "";
        String metric2 = "";

        //for int col = 0 to planes[planeNumber - 1].length by 1 do
        for (int col = 0; col < planes[planeNumber - 1].length; col++) {
            //if planes[planeNumber - 1][col] is greater than max1
            if (planes[planeNumber - 1][col] > max1) {
                //make this index the second index
                index2 = index1;
                //make this max the second max
                max2 = max1;
                //set index1 to col
                index1 = col;
                //set max1 to planes[planeNumber - 1][col]
                max1 = planes[planeNumber - 1][col];
            //else if planes[planeNumber - 1][col] is greater than max2 and is not max1
            } else if (planes[planeNumber - 1][col] > max2 && planes[planeNumber - 1][col] != max1) {
                //set index2 to col
                index2 = col;
                //set max2 to planes[planeNumber - 1][col]
                max2 = planes[planeNumber - 1][col];
            }
            //set metric1 to metrics[index1]
            metric1 = metrics[index1];
            //set metric2 to metrics[index2]
            metric2 = metrics[index2];

        }
        //return metric1 “ and “ metric2
        return (metric1 + " and " + metric2);
    }


    /**
     * searchHighestPlane - search for the plane that
     * contains the highest value for the given metric
     *
     * @param planes
     * @param metrics
     * @param metric
     * @return maxIndex + 1 the plane's number that contains
     * the highest value for the given metric
     */

    public static int searchHighestPlane(double [][]
                                                 planes, String[] metrics, String metric){
        //initialize index = 0, max = 0, maxIndex = 0
        int index = 0;
        double max = 0;
        int maxIndex = 0;

        //find the index of the given metric
        for (int i = 0; i < metrics.length; i++) {
            if (metrics[i].equals(metric)) {
                index = i;
            }
        }

        //for int col = 0 to planes[0] length by 1 do
        for (int col = 0; col < planes[0].length; col++) {
            //for int row = 0 to planes length by 1 do
            for (int row = 0; row < planes.length; row++) {
                //traverse the weight capacity column
                if (col == index) {
                    //if planes[row][col] is greater than max
                    if (planes[row][col] > max) {
                        //set max to planes[row][col]
                        max = planes[row][col];
                        //set maxIndex to row
                        maxIndex = row;
                    }
                }
            }
        }

        //return (maxIndex + 1)
        return (maxIndex + 1);
    }

}
