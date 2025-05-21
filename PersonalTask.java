public class PersonalTask extends Task {
    public PersonalTask(String title, String priority) {
        super(title, priority);
    }

    @Override
    public String getType() {
        return "Personal";
    }
}
