package Labs.Lab9;

public class Lab9 {      //addTo10()
    public static void main(String[] args){
        int [][] addTo10Input={
                {6,3,2,0,4},
                {34,53,0,23,1},
                {0,23,54,11,7}
        };

        double [][] findAvgInput={
                {5,4.5,6.8},
                {6,0,3.4},
                {7,8.4,2.3}
        };
        double [][] findAvgInputLarge={
                {6.7,23.8,0,5.9,12.8,45.7},
                {0,36.8,13.5,6.7,54.9,67.4},
                {37.4,2.5,39.8,0,2.4,43.6},
                {44.6,76.5,4.5,2.4,0,54.6},
                {5.4,76.3,6.5,28.5,54.7,0},
                {19.4,0,5.3,65.4,93.5,3.5}
        };
        addTo10(addTo10Input);
        System.out.println();
        findAverage(findAvgInput);
        System.out.println();
        findAverage(findAvgInputLarge);
    }
    public static void addTo10(int [][]array){
        int row, col;
        //for each row, set the sum to 0
        for(row = 0; row < array.length; row++){
            int sum = 0;
            //for each column in each row, add the value to sum
            for(col = 0; col < array[row].length; col++){
                sum += array[row][col];
            }
            //subtract sum from 10 to get the result
            int res = 10 - sum;
            //set column to 0 to go through the row
            col = 0;
            //pass every element that isn't 0
            while(array[row][col] != 0){
                col++;
            }
            //replace the 0 with the result
            array[row][col] = res;
        }
        //print out the array
        for(row = 0; row < array.length; row++){
            for(col = 0; col < array[row].length; col++){
                System.out.print(array[row][col]+" ");
            }
            System.out.println();
        }
    }

    public static void findAverage(double [][] array){
        int row,col,k,k1;
        double ra = 0; //row avg
        double ca = 0; //column avg
        //for each column in each row, if the element is 0 do
        for(row = 0; row < array.length; row++){
            for(col = 0; col < array[row].length; col++){
                if(array[row][col] == 0) {
                    //add up the row's elements and get the avg
                    for(k = 0; k < array[row].length; k++){
                        ra += array[row][k];
                    }
                    ra = ra / array[row].length;
                    //do the same for the column of 0
                    for(k1 = 0; k1 < array.length; k1++){
                        ca += array[k1][col];
                    }
                    ca = ca / array.length;
                    //replace the 0 with whichever average is larger
                    if(ra > ca) {
                        array[row][col]=ra;
                    } else  {
                        array[row][col]=ca;
                    }
                }
            }
        }
        //print the array out
        for(row = 0; row < array.length; row++){
            for(col = 0; col < array[row].length; col++){
                System.out.print(array[row][col]+" ");
            }
            System.out.println();
        }
    }
}

