package org.toztemel.trains.output;

public class Display {

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void print(int i) {
        System.out.println("Output #" + i + ": " + result);
    }

}
