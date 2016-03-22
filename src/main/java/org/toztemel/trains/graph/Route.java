package org.toztemel.trains.graph;

public class Route extends Track {

    private Town source;
    private Town dest;

    public Route(Track track, Town source, Town dest) {
        super(track);
        this.source = source;
        this.dest = dest;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o)
                && (((Route) o).source.equals(this.source))
                && (((Route) o).dest.equals(this.dest));
    }

    public Town destination() {
        return dest;
    }

    public Town source() {
        return source;
    }

}
