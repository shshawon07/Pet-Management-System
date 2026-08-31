package File;

import Entity.*;
import java.io.*;
import java.util.*;

public class FileIO {

    public static void load(Owner[] owners, Pet[] pets) {
        try {
            Scanner sc = new Scanner(new File("./File/Owners.txt"));

            while(sc.hasNextLine()) {
                String data[] = sc.nextLine().split("\\|");
                int id = Integer.parseInt(data[0]);
                owners[id] = new Owner(id,data[1],data[2],data[3],data[4]);
            }
            sc.close();

            sc = new Scanner(new File("./File/Pets.txt"));

            while(sc.hasNextLine()) {
                String data[] = sc.nextLine().split("\\|");

                String type = data[0];
                int id = Integer.parseInt(data[1]);
                int ownerId = Integer.parseInt(data[2]);
                String name = data[3];
                String breed = data[4];
                String gender = data[5];
                String age = data[6];
                String color = data[7];
                double weight = Double.parseDouble(data[8]);

                if(type.equalsIgnoreCase("Cat"))
                    pets[id] = new Cat(id,ownerId,name,breed,gender,age,color,weight);
                else
                    pets[id] = new Dog(id,ownerId,name,breed,gender,age,color,weight);
            }
            sc.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void save(Owner[] owners, Pet[] pets) {
        try {
            FileWriter ownerWriter =
                    new FileWriter(new File("./File/Owners.txt"));
            FileWriter petWriter =
                    new FileWriter(new File("./File/Pets.txt"));

            for(int i=0;i<owners.length;i++) {
                if(owners[i]!=null) {
                    ownerWriter.write(
                            i+";"+owners[i].getName()+";"+
                            owners[i].getPhone()+";"+
                            owners[i].getEmail()+";"+
                            owners[i].getAddress()+"\n");
                }
            }

            for(int i=0;i<pets.length;i++) {
                if(pets[i]!=null) {
                    petWriter.write(
                            pets[i].getPetType()+";"+
                            pets[i].getPetId()+";"+
                            pets[i].getOwnerId()+";"+
                            pets[i].getName()+";"+
                            pets[i].getBreed()+";"+
                            pets[i].getGender()+";"+
                            pets[i].getAge()+";"+
                            pets[i].getColor()+";"+
                            pets[i].getWeight()+"\n");
                }
            }

            ownerWriter.close();
            petWriter.close();

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}