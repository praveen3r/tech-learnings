package ioc.food;

import org.springframework.beans.factory.annotation.Autowired;

public class Meal implements Food {
    public Meal() {

    }

    @Autowired
    public Meal(Diary diary, Fruit fruit, Grains grains, Meat meat, Vegetables vegetables) {
        this.diary = diary;
        this.fruit = fruit;
        this.grains = grains;
        this.meat = meat;
        this.vegetables = vegetables;
    }

    @Autowired
    private Diary diary;

    //Make sure here wouldnt any ambugity
    private Diary diary1;

    @Autowired//(required = false)
    private Fruit fruit;

    @Autowired
    private Grains grains;
    @Autowired
    private Meat meat;
    @Autowired
    private Vegetables vegetables;


    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Grains getGrains() {
        return grains;
    }

    public void setGrains(Grains grains) {
        this.grains = grains;
    }

    public Meat getMeat() {
        return meat;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }

    public Vegetables getVegetables() {
        return vegetables;
    }

    public void setVegetables(Vegetables vegetables) {
        this.vegetables = vegetables;
    }

    public String talkAboutYourself() {
        return "I am Meal";
    }

    public String whatsIsInThisMeal() {
        String answer = "This Meal Contains :";

        if (fruit != null) answer += ": Some Fruit";
        if (diary != null) answer += ": Some Diary";
        if (vegetables != null) answer += ": Some Vegetables";
        if (grains != null) answer += ": Some Grains";
        if (meat != null) answer += ": Some Meat";
        return answer;

    }
}
