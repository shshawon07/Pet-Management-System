package Entity;

public class Dog extends Pet {
    public Dog() { super(); }
    public Dog(int petId, int ownerId, String name, String breed, String gender,
               String age, String color, double weight) {
        super(petId, ownerId, name, breed, gender, age, color, weight);
    }
    public String getPetType() { return "Dog"; }
}
