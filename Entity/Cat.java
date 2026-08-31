package Entity;

public class Cat extends Pet{
    public Cat(){super();}
    public Cat(int petId,int ownerId,String name,String breed,String gender,String age,double weight,String stay)
    {
        super(petId,ownerId,name,breed,gender,age,weight,stay);
    }
    public String getPetType(){return "Cat";}
}
