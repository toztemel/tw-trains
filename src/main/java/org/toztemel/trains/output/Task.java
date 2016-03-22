package org.toztemel.trains.output;

import org.toztemel.trains.exception.NoSuchRouteException;
import org.toztemel.trains.exception.NoSuchTownException;
import org.toztemel.trains.graph.Town;
import org.toztemel.trains.trips.Trip;


public class Task {

    private static final String NO_SUCH_ROUTE = "NO SUCH ROUTE";

    protected Trip trip;
    protected Display display;
    protected Town[] path;

    public void execute() {
        String result = calculateResult();
        display.setResult(result);
    }

    private String calculateResult() {
        String result = "";
        try {
            int distance = trip.calculate(path);
            result = String.valueOf(distance);
        } catch (NoSuchRouteException e) {
            result = reportNoSuchRoute();
        } catch (NoSuchTownException e) {
            reportQuestionProblem(e);
        }
        return result;
    }

    private String reportNoSuchRoute() {
        return NO_SUCH_ROUTE;
    }

    private void reportQuestionProblem(NoSuchTownException e) {
        e.printStackTrace();
    }

}
