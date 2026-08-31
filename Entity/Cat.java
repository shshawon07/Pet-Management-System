package Entity;

public class Cat extends Pet {
    public Cat() { super(); }
    public Cat(int petId, int ownerId, String name, String breed, String gender,
               String age, String color, double weight) {
        super(petId, ownerId, name, breed, gender, age, color, weight);
    }
    public String getPetType() { return "Cat"; }
}
