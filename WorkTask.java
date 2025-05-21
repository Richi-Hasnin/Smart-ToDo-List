public class WorkTask extends Task {
    public WorkTask(String title, String priority) {
        super(title, priority);
    }

    @Override
    public String getType() {
        return "Work";
    }
}