package org.toztemel.trains.output;

import org.toztemel.trains.exception.NoSuchRouteException;
import org.toztemel.trains.exception.NoSuchTownException;
import org.toztemel.trains.graph.Town;
import org.toztemel.trains.trips.Trip;


public class Task {

    protected Trip trip;
    protected Display display;
    protected Town[] path;

    public void execute() {
        String result = "";
        try {
            int distance = trip.calculate(path);
            result = String.valueOf(distance);
        } catch (NoSuchRouteException e) {
            result = "NO SUCH ROUTE";
        } catch (NoSuchTownException e) {
            e.printStackTrace();
        }
        display.setResult(result);
    }

}
