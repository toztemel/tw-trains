package org.toztemel.trains;

import org.toztemel.trains.exception.CannotReadFromInputFileException;
import org.toztemel.trains.exception.NoSuchTownException;
import org.toztemel.trains.graph.GraphBuilder;
import org.toztemel.trains.graph.Town;
import org.toztemel.trains.graph.Graph;
import org.toztemel.trains.input.InputFileReader;
import org.toztemel.trains.output.*;
import org.toztemel.trains.input.InputReader;

import java.util.ArrayList;
import java.util.List;

public class TrainRouteOffice {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Program requires absolute path of the input file.");
            System.err.println("Example:");
            System.err.println("\t> java org.trains.TrainRouteOffice /tmp/input");
            System.exit(-1);
        }

        try {
            String fileName = args[0];
            InputReader inputReader = new InputReader();
            inputReader.readFrom(new InputFileReader(fileName));
            List<String> input = inputReader.getInput();

            Graph towns = new Graph();
            GraphBuilder builder = new GraphBuilder(towns);

            builder.addToGraph(input.toArray(new String[0]));

            List<Task> tasks = new ArrayList<Task>();
            Display display = new Display();
            tasks.add(new DistanceCalculation(towns, display, new Town("A"), new Town("B"), new Town("C")));
            tasks.add(new DistanceCalculation(towns, display, new Town("A"), new Town("D")));
            tasks.add(new DistanceCalculation(towns, display, new Town("A"), new Town("D"), new Town("C")));
            tasks.add(new DistanceCalculation(towns, display, new Town("A"), new Town("E"), new Town("B"), new Town("C"), new Town("D")));
            tasks.add(new DistanceCalculation(towns, display, new Town("A"), new Town("E"), new Town("D")));
            tasks.add(new RouteWithMaxStopCalculation(towns, display, new Town("C"), new Town("C")));
            tasks.add(new RouteWithExactStopCalculation(towns, display, new Town("A"), new Town("C")));
            tasks.add(new ShortestPathCalculation(towns, display, new Town("A"), new Town("C")));
            tasks.add(new ShortestPathCalculation(towns, display, new Town("B"), new Town("B")));
            tasks.add(new RouteOfMaxLengthCalculation(towns, display, new Town("C"), new Town("C")));

            for (int i = 0; i < tasks.size(); i++) {
                tasks.get(i).execute();
                display.print(i + 1);
            }
        } catch (NoSuchTownException e) {
            reportQuestioningProblem(e);
        } catch (CannotReadFromInputFileException e) {
            reportInputFileProblem(e);
        }
    }

    private static void reportQuestioningProblem(NoSuchTownException e) {
        e.printStackTrace();
    }

    private static void reportInputFileProblem(CannotReadFromInputFileException e) {
        e.printStackTrace();
    }

}
