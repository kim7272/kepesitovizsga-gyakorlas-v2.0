package hu.nive.ujratervezes.kepesitovizsga.architect;

public interface Plan {

    public abstract String getProjectName();
    public abstract int calculateSquareMeter();
    public abstract PlanType getType();
}
