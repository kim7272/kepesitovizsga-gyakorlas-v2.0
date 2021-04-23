package hu.nive.ujratervezes.kepesitovizsga.architect;

import java.util.ArrayList;
import java.util.List;

public class ArchitectStudio {

    private List<StudioArchiveItem> items = new ArrayList<>();

    public List<StudioArchiveItem> addPlan(String workingTitle, Plan plan) {
        if (workingTitle == null || plan == null) {
            throw new IllegalArgumentException("Working title and plan must not be empty!");
        }
        items.add(new StudioArchiveItem(plan, workingTitle));
        return items;
    }

    public Plan getPlanWithMaxSquareMeter() {
        Plan plan = null;
        int min = Integer.MIN_VALUE;
        for (StudioArchiveItem item : items) {
            if (item.getPlan().calculateSquareMeter() > min) {
                min = item.getPlan().calculateSquareMeter();
                plan = item.getPlan();
            }
        }
        return plan;
    }

    public Plan getPlanByWorkingTitle(String workingTitle){
        if (workingTitle.isEmpty()){
            throw new IllegalArgumentException("Working title must not be empty!");
        }
        Plan plan = null;
        for (StudioArchiveItem item : items){
            if (item.getWorkingTitle().equals(workingTitle)){
                plan = item.getPlan();
            }
        }
        if (plan == null){
            throw new IllegalArgumentException("No such project.");
        }
        return plan;
    }

    public Plan getPlanByProjectName(String projectName){
        if (projectName.trim().isEmpty()){
            throw new IllegalArgumentException("Project name must not be empty!");
        }
        Plan plan = null;
        for (StudioArchiveItem item : items){
            if (item.getPlan().getProjectName().equals(projectName)){
                plan = item.getPlan();
            }
        }
        if (plan == null){
            throw new IllegalArgumentException("No such project.");
        }
        return plan;
    }
    public List<Plan> getSmallerPlans(int squareMeter){
        List<Plan> result = new ArrayList<>();
        for (StudioArchiveItem item : items){
            if (item.getPlan().calculateSquareMeter() < squareMeter){
                result.add(item.getPlan());
            }
        }
        return result;
    }

    public List<Plan> getListOfPlansByPlanType(PlanType type){
        if (type == null){
            throw new IllegalArgumentException("Parameter must not be null!");
        }
        List<Plan> result = new ArrayList<>();
        for (StudioArchiveItem item : items){
            if (item.getPlan().getType() == type){
                result.add(item.getPlan());
            }
        }
        return result;
    }
}

