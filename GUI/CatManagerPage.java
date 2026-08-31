package GUI;

import Entity.*;
import File.FileIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CatManagerPage extends JFrame implements ActionListener{

    JTextField ownerId,ownerName,phone,email,address;
    JTextField type,petId,petOwnerId,petName,breed,gender,age,weight,stay,searchField;
    JButton createOwner,updateOwner,removeOwner,createPet,updatePet,removePet;
    JButton searchButton,saveButton,clearButton;
    JTextArea screen;
    Owner[] owners=new Owner[100];
    Pet[] pets=new Pet[100];

    public CatManagerPage()
    {
        super("Pet Management System");
        setSize(1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setContentPane(new BG());
        getContentPane().setLayout(null);
        FileIO.load(owners,pets);
        gui();
        updateScreen();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class BG extends JPanel{

    Image img=new ImageIcon("./images/cattdog.png").getImage();

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(img,0,250,450,450,this);
    }
}
    JLabel label(String t,int x,int y,int w,int h){
        JLabel l=new JLabel(t);
        l.setBounds(x,y,w,h);
        l.setFont(new Font("Arial",Font.BOLD,14));
        add(l);
        return l;
    }

    JTextField field(int x,int y,int w){
        JTextField f=new JTextField();
        f.setBounds(x,y,w,28);
        add(f);
        return f;
    }

    JButton button(String t,int x,int y,int w){
        JButton b=new JButton(t);
        b.setBounds(x,y,w,30);
        b.addActionListener(this);
        add(b);
        return b;
    }

    void icon(String file,int x,int y){
        Image i=new ImageIcon("./images/"+file).getImage();
        i=i.getScaledInstance(35,35,Image.SCALE_SMOOTH);
        JLabel l=new JLabel(new ImageIcon(i));
        l.setBounds(x,y,35,35);
        add(l);
    }

    void gui(){

        label("Pet Management System",15,15,350,30)
                .setFont(new Font("Arial",Font.BOLD,20));
        searchField=field(650,15,180);
        searchButton=button("Search",840,15,100);
        saveButton=button("Save",950,15,100);

        icon("owner.png",20,68);
        label("OWNER",65,70,200,30).setFont(new Font("Arial",Font.BOLD,18));

        label("Owner ID",20,110,100,25); ownerId=field(130,108,250);
        label("Name",20,145,100,25); ownerName=field(130,143,250);
        label("Phone",20,180,100,25); phone=field(130,178,250);
        label("Email",20,215,100,25); email=field(130,213,250);
        label("Address",20,250,100,25); address=field(130,248,250);

        createOwner=button("Create Owner",20,290,120);
        updateOwner=button("Update Owner",150,290,120);
        removeOwner=button("Remove Owner",280,290,120);

        icon("pet.png",20,340);
        label("PET (CAT / DOG)",65,345,250,30).setFont(new Font("Arial",Font.BOLD,18));

        label("Type",20,385,100,25); type=field(130,383,250);
        label("Pet ID",20,420,100,25); petId=field(130,418,250);
        label("Owner ID",20,455,100,25); petOwnerId=field(130,453,250);
        label("Name",20,490,100,25); petName=field(130,488,250);
        label("Breed",20,525,100,25); breed=field(130,523,250);
        label("Gender",20,560,100,25); gender=field(130,558,250);
        label("Age",20,595,100,25); age=field(130,593,250);
        label("Weight (kg)",20,630,100,25); weight=field(130,628,250);
        label("Stay",20,665,100,25); stay=field(130,663,250);

        createPet=button("Create Pet",20,700,120);
        updatePet=button("Update Pet",150,700,120);
        removePet=button("Remove Pet",280,700,120);
        clearButton=button("Clear Fields",150,740,120);

        label("DATA LIST",450,70,200,30).setFont(new Font("Arial",Font.BOLD,18));

        screen=new JTextArea();
        screen.setFont(new Font("Monospaced",Font.PLAIN,14));
        screen.setEditable(false);
        JScrollPane sp=new JScrollPane(screen);
        sp.setBounds(450,110,700,650);
        add(sp);
    }

    Pet makePet(int id,int oid){
        Object[] a={id,oid,petName.getText(),breed.getText(),gender.getText(),age.getText(),Double.parseDouble(weight.getText()),stay.getText()};

        if(type.getText().equalsIgnoreCase("Cat"))return new Cat((int)a[0],(int)a[1],(String)a[2],(String)a[3],(String)a[4],(String)a[5],(double)a[6],(String)a[7]);

        return new Dog((int)a[0],(int)a[1],(String)a[2],(String)a[3],(String)a[4],(String)a[5],(double)a[6],(String)a[7]);
    }

    void updateScreen(){
        String s="========== OWNERS ==========\n";
        for(Owner o:owners) if(o!=null) s+=o.getOwner()+"\n";
        s+="\n========== PETS ============\n";
        for(Pet p:pets) if(p!=null) s+=p.getPet()+"\n";
        screen.setText(s);
    }

    void clearFields(){
        JTextField[] f={ownerId,ownerName,phone,email,address,type,petId,petOwnerId,petName,breed,gender,age,weight,stay,searchField};
        for(JTextField x:f)x.setText("");
    }

    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==createOwner){
                int id=Integer.parseInt(ownerId.getText());
                if(owners[id]==null) 
                    {owners[id]=new Owner(id,ownerName.getText(),phone.getText(),email.getText(),address.getText());
                    updateScreen();
                } else msg("Owner ID already exists!");
            }

            else if(e.getSource()==updateOwner){
                int id=Integer.parseInt(ownerId.getText());
                if(owners[id]!=null) {
                    owners[id].setName(ownerName.getText());
                    owners[id].setPhone(phone.getText());
                    owners[id].setEmail(email.getText());
                    owners[id].setAddress(address.getText());
                    updateScreen();
                } else msg("Owner not found!");
            }

            else if(e.getSource()==removeOwner){
                int id=Integer.parseInt(ownerId.getText());
                if(owners[id]!=null) {
                    owners[id]=null;
                    updateScreen();
                } else msg("Owner not found!");
            }

            else if(e.getSource()==createPet){
                int id=Integer.parseInt(petId.getText());
                int oid=Integer.parseInt(petOwnerId.getText());
                String t=type.getText();
                if(pets[id]==null&&owners[oid]!=null&&(t.equalsIgnoreCase("Cat")||t.equalsIgnoreCase("Dog"))) 
                    {
                    pets[id]=makePet(id,oid);
                    updateScreen();
                } else msg("Invalid Pet information!");
            }

            else if(e.getSource()==updatePet){
                int id=Integer.parseInt(petId.getText());
                int oid=Integer.parseInt(petOwnerId.getText());
                if(pets[id]!=null&&owners[oid]!=null) {
                    pets[id]=makePet(id,oid);
                    updateScreen();
                } else msg("Pet not found!");
            }

            else if(e.getSource()==removePet){
                int id=Integer.parseInt(petId.getText());
                if(pets[id]!=null) 
                    {
                    pets[id]=null;
                    updateScreen();
                } else msg("Pet not found!");
            }

            else if(e.getSource()==searchButton){
                String k=searchField.getText(),s="========== SEARCH RESULT ==========\n";
                boolean f=false;
                for(Owner o:owners)
                    if(o!=null&&o.search(k)){s+=o.getOwner()+"\n";f=true;}
                for(Pet p:pets)
                    if(p!=null&&p.search(k)){s+=p.getPet()+"\n";f=true;}
                if(!f)s+="No matching data found.\n";
                screen.setText(s);
            }

            else if(e.getSource()==saveButton){
                FileIO.save(owners,pets);
                JOptionPane.showMessageDialog(this,"Data Saved Successfully!");
            }

            else if(e.getSource()==clearButton) clearFields();

        } catch(Exception ex){
            msg("Please enter valid values!");
        }
    }

    void msg(String s){
        JOptionPane.showMessageDialog(this,s,"Warning",
                JOptionPane.WARNING_MESSAGE);
    }
}