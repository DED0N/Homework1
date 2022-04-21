package homeWork.secondLesson.Fixes;

public class Cat extends BaseFarm implements AnimalColor{

    public Cat() {

    }

    public Cat(String setName){
        super(setName);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setVoice(String setVoice) {
        super.setVoice(setVoice);
    }

    @Override
    public String getVoice() {
        return super.getVoice();
    }

    @Override
    public void setAge(String setAge) {
        super.setAge(setAge);
    }

    @Override
    public String getAge() {
        return super.getAge();
    }

    @Override
    public void getColor() {
        System.out.println("Белый");
    }


}
