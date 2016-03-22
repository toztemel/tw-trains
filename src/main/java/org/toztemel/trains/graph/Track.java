package org.toztemel.trains.graph;

public class Track {

    private int distance;

    public Track(int i) {
        this.distance = i;
    }

    public Track(Track r) {
        if (r == null)
            r = new Track(0);
        this.distance = r.distance;
    }

    public int length() {
        return distance;
    }

    public Track joinWith(Track r) {
        return new Track(distance + r.distance);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Track) && (((Track) o).distance == this.distance);
    }

}
