package edu.berkeley.letscook;

// understands how to convert between different types of quantity
public enum Unit {
    OZ(28.35),
    LB(453.60),
    G(1),
    KG(1000);

    private final double ratio;

    Unit(double ratio) {
        this.ratio = ratio;
    }

    public double convertTo(Unit outputUnit, double magnitude) {
        return magnitude * ratio / outputUnit.ratio;
    }
}
