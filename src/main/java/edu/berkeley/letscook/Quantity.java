package edu.berkeley.letscook;

// understands the conversion of quantities with different units
public class Quantity {
    private final double magnitude;
    private final Unit unit;

    public Quantity(double magnitude, Unit unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    private Quantity convertTo(Unit outputUnit) {
        return new Quantity(this.unit.convertTo(outputUnit, magnitude), outputUnit);
    }

    @Override
    public String toString() {
        return magnitude + " " + unit;
    }

    @Override
    public int hashCode() {
        return (int) magnitude * unit.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Quantity otherQuantity)) return false;
        return magnitude == otherQuantity.convertTo(unit).magnitude;
    }

    public boolean moreThan(Quantity other) {
        return magnitude >= other.convertTo(unit).magnitude;
    }

    public Quantity add(Quantity other) {
        return new Quantity(other.convertTo(unit).magnitude + magnitude, unit);
    }

    public double multiplyPerUnit(double propValue, Quantity valuePerUnit) {
        return propValue * this.convertTo(valuePerUnit.unit).magnitude / valuePerUnit.magnitude;
    }

    public double multiplyPerUnit(double propValue) {
        return multiplyPerUnit(propValue, new Quantity(1, Unit.OZ));
    }
}
