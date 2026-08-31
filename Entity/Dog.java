package Entity;

public class Dog extends Pet{
    public Dog(){super();}
    public Dog(int petId,int ownerId,String name,String breed,String gender,String age,double weight,String stay)
    {super(petId,ownerId,name,breed,gender,age,weight,stay);
    }
    public String getPetType(){return "Dog";}
}
