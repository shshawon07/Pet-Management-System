package File;
import Entity.*;
import java.io.*;
import java.util.*;

public class FileIO{
    public static void load(Owner[] owners,Pet[] pets){
        try{
            Scanner sc=new Scanner(new File("./File/Owners.txt"));
            while(sc.hasNextLine()){
                String data[]=sc.nextLine().split("\\|",-1);
                int id=Integer.parseInt(data[0]);
                owners[id]=new Owner(id,data[1],data[2],data[3],data[4]);
            }
            sc.close();
            sc=new Scanner(new File("./File/Pets.txt"));
            while(sc.hasNextLine()){
                String data[]=sc.nextLine().split("\\|",-1);
                String type=data[0]; int id=Integer.parseInt(data[1]); int oid=Integer.parseInt(data[2]);
                String name=data[3],breed=data[4],gender=data[5],age=data[6];
                double weight=Double.parseDouble(data[7]); String stay=data[8];
                if(type.equalsIgnoreCase("Cat")) pets[id]=new Cat(id,oid,name,breed,gender,age,weight,stay);
                else pets[id]=new Dog(id,oid,name,breed,gender,age,weight,stay);
            }
            sc.close();
        }catch(Exception e){System.out.println(e.getMessage());}
    }

    public static void save(Owner[] owners,Pet[] pets){
        try{
            FileWriter ow=new FileWriter(new File("./File/Owners.txt"));
            FileWriter pw=new FileWriter(new File("./File/Pets.txt"));
            for(int i=0;i<owners.length;i++) if(owners[i]!=null)
                ow.write(i+"|"+owners[i].getName()+"|"+owners[i].getPhone()+"|"+owners[i].getEmail()+"|"+owners[i].getAddress()+"\n");
            for(int i=0;i<pets.length;i++) if(pets[i]!=null)
                pw.write(pets[i].getPetType()+"|"+pets[i].getPetId()+"|"+pets[i].getOwnerId()+"|"+pets[i].getName()+"|"+pets[i].getBreed()+"|"+pets[i].getGender()+"|"+pets[i].getAge()+"|"+pets[i].getWeight()+"|"+pets[i].getStay()+"\n");
            ow.close(); pw.close();
        }catch(IOException e){System.out.println(e.getMessage());}
    }
}
