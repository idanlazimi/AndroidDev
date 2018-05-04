package Entities;

/**
 * Created by Dell on 04/05/2018.
 */

public class ActivityItem {

    private String title, description;

    private ActivityID activityID;
    private int imageResource;

    public ActivityID getActivityID() {
        return activityID;
    }

    public void setActivityID(ActivityID activityID) {
        this.activityID = activityID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public ActivityItem(String title, String description, int imageResource, ActivityID activityID) {

        this.title = title;
        this.description = description;
        this.imageResource = imageResource;
        this.activityID = activityID;
    }

    public enum ActivityID { CALC, BDAY};
}
