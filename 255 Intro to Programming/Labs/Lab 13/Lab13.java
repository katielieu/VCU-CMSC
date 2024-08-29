package Labs.Lab13;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class contains methods to process a file containing information about soccer teams
 */
public class Lab13 {

    /**
     * Processes the input file containing information about soccer teams and writes the analysis to an output file
     *
     * @param inputFile The input file containing data about soccer teams
     * @param outputFile The output file where the analysis will be written
     * @throws FileNotFoundException If the input file is not found
     */
    public static void processFile(File inputFile, File outputFile) throws FileNotFoundException {
        Team team;
        Team minTeam = null; // Team with the minimum number of goals scored.
        Team maxTeam = null; // Team with the maximum number of goals scored.
        double totalShots = 0; // Total number of shots across all teams.
        int numTeams = 0; // Total number of teams processed.
        String line;

        Scanner fileScan = new Scanner(inputFile);
        PrintWriter writer = new PrintWriter(outputFile);

        // Loop through each line in the input file
        while(fileScan.hasNextLine()) {
            line = fileScan.nextLine();
            String[] fields = line.split(",");

            // Create a Team object from the line's data
            team = new Team(fields[0],Integer.parseInt(fields[1]), Double.parseDouble(fields[2]));

            // Update the team with the minimum number of goals scored
            if(minTeam == null || minTeam.getNumGoals() > team.getNumGoals()) {
                minTeam = team;
            }

            // Update the team with the maximum number of goals scored
            if(maxTeam == null || maxTeam.getNumGoals() < team.getNumGoals()) {
                maxTeam = team;
            }

            numTeams++;
            totalShots += team.getNumShots();
        }

        fileScan.close();

        // Write the analysis to the output file
        if(numTeams > 0) {
            writer.println("Maximum goals Scored: " + maxTeam.getName() + " " + maxTeam.getNumGoals());
            writer.println("Minimum goals Scored: " + minTeam.getName() + " " + minTeam.getNumGoals());
            writer.printf("Average shots per game: %.3f", (totalShots/numTeams));
        }
        writer.close();
    }

    /**
     * Main method to run the program
     *
     * @param args Command line arguments. Requires two arguments: input file path and output file path
     */
    public static void main(String[] args) {
        // Get input and output file paths from command line arguments
        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);

        try {
            // Process the input file
            processFile(inputFile, outputFile);
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.out.println("Unable to open file(s)");
        }
    }
}
