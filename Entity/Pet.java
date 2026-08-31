package Entity;

public abstract class Pet implements Searchable {
    private int petId;
    private int ownerId;
    private String name;
    private String breed;
    private String gender;
    private String age;
    private String color;
    private double weight;

    public Pet() {}

    public Pet(int petId, int ownerId, String name, String breed, String gender,
               String age, String color, double weight) {
        this.petId = petId;
        this.ownerId = ownerId;
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
        this.color = color;
        this.weight = weight;
    }

    public int getPetId() { return petId; }
    public void setPetId(int petId) { this.petId = petId; }
    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public abstract String getPetType();

   public boolean search(String keyword) {

    keyword = keyword.toLowerCase();

    if (String.valueOf(petId).equals(keyword))
        return true;

    if (String.valueOf(ownerId).equals(keyword))
        return true;

    if (name.toLowerCase().contains(keyword))
        return true;

    if (breed.toLowerCase().contains(keyword))
        return true;

    if (gender.toLowerCase().contains(keyword))
        return true;

    if (age.toLowerCase().contains(keyword))
        return true;

    if (color.toLowerCase().contains(keyword))
        return true;

    if (getPetType().toLowerCase().contains(keyword))
        return true;

    return false;
}

    public String getPet() {
        return "Pet ID: " + petId + "\n" +
               "Owner ID: " + ownerId + "\n" +
               "Name: " + name + "\n" +
               "Type: " + getPetType() + "\n" +
               "Breed: " + breed + "\n" +
               "Gender: " + gender + "\n" +
               "Age: " + age + "\n" +
               "Color: " + color + "\n" +
               "Weight: " + weight + " kg\n";
    }
}
