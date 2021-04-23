package hu.nive.ujratervezes.kepesitovizsga.architect;

public class PublicBuildingPlan implements Plan {

    private PlanType planType;
    private String projectName;
    private int stock;
    private int area;

    public PublicBuildingPlan(String projectName, int stock, int area) {
        this.projectName = projectName;
        this.stock = stock;
        this.area = area;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public int getStock() {
        return stock;
    }

    public int getArea() {
        return area;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public int calculateSquareMeter() {
        return stock * area;
    }

    @Override
    public PlanType getType() {
        return PlanType.PUBLIC;
    }
}
