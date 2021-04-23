package hu.nive.ujratervezes.kepesitovizsga.architect;

public class StudioArchiveItem{

    private Plan plan;
    private String workingTitle;

    public StudioArchiveItem(Plan plan, String workingTitle) {
        this.plan = plan;
        this.workingTitle = workingTitle;
    }

    public Plan getPlan() {
        return plan;
    }

    public String getWorkingTitle() {
        return workingTitle;
    }
}
