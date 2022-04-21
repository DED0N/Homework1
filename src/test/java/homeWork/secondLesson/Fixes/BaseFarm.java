package homeWork.secondLesson.Fixes;

public class BaseFarm {
    private String name;
    private String setVoice;
    private String age;
    private String food;

    public BaseFarm(String setName) {
        this.name = setName;
    }

    public BaseFarm() {
    }

    public String getName() {
        return name;
    }

    public void setVoice(final String setVoice) {
        this.setVoice = setVoice;
    }

    public String getVoice() {
        return setVoice;
    }

    public void setAge(final String setAge) {
        this.age = setAge;
    }

    public String getAge() {
        return age;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFood() {
        return food;
    }
}
