/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
//Noor Al Din Zakarneh
//21520012
import  java.io.*;
import javax.swing.JOptionPane;
import java.util.*;

public class Project {
     
    static String s;
    static String line;
    static String tokens[] ;
    static ArrayList<String>lines=new<String> ArrayList();
    
   
static ArrayList<String> r= new <String>ArrayList();

    /**
     * @param args the command line arguments
     */
    

public static void fill(BufferedReader inb) throws IOException{
lines.clear();
  
while (  (line=inb.readLine())!=null  ){

 
 
     lines.add(line);
}


}



public static  boolean checkprimary(int column1  ) throws IOException{
     
if(r.get(column1)==null)
    return false;

else return true;
    
    }

     public static  boolean checkforeign(int column1, String value  ) throws IOException{
     

    for(int i=0;i<lines.size();i++){
    if(tokens!=null)
        tokens = lines.get(i).split(" ");//ظ„طھط±ط¬ط¹ array of string 
    
     if( tokens[column1].equals(value)) return true;
    }
return false;}

     public static  boolean checkkey(int column,String value  ) throws IOException{
     

    for(int i=0;i<lines.size();i++){
    tokens = lines.get(i).split(" ");//ظ„طھط±ط¬ط¹ array of string 
       
     if( tokens[column].equals(value) ) return false;
    }
return true ;}
     
public  static void  records(BufferedReader inb) throws IOException{
    r.clear();
line =lines.get(0);

tokens =line.split(" ");

for (int i=0;i<tokens.length;i++)
  r.add(JOptionPane.showInputDialog("Enter value of "+tokens[i]));

}     
    public static void  insert(BufferedReader inb,BufferedWriter outb  ) throws IOException{
 
    
    for(int  i=0;i<r.size();i++) 
         outb.append(r.get(i) +" ");  
    outb.append(System.lineSeparator());
 //outb.newLine();        
outb.flush();
outb.close();

inb.close();



    }
    
    
    public static void main(String[] args) {
     
FileOutputStream out;
FileInputStream in;
BufferedWriter outb;
BufferedReader inb;
BufferedReader relational;
BufferedReader relational2;

Character ch = new Character(' ');
     String s=ch.toString();
     
     String s1= "Please enter your choice to insert"
      
           +"Welcome"+ "\n1 : Department\n2 : Employee\n3 : DeptLocation\n4 : WorksOn\n 5 : Project\n 6 : Dependent\n 7 : End\n";
    
    
      
try{
 
    
for(;;) {
         
        s=(JOptionPane.showInputDialog(null,s1, "Enter Choice",JOptionPane.QUESTION_MESSAGE));
  
        
        if(s.equals("1"))  {
           inb = new BufferedReader(new FileReader("F:\\Company\\Department.txt"));
           outb = new BufferedWriter(new FileWriter("F:\\Company\\Department.txt",true));
          relational=new BufferedReader(new FileReader("F:\\Company\\Employee.txt"));
          
           fill(inb);
records(inb);

if(!r.get(1).equals("null")) 
{
if(checkkey( 1,r.get(1)))
{   
    fill(relational);
if (checkforeign(3,r.get(2)))
    
insert(inb, outb  );
    else
JOptionPane.showMessageDialog(null,"No Foregin Key ","Refrencial constraint",JOptionPane.WARNING_MESSAGE);    
    }
else JOptionPane.showMessageDialog(null,"This value is already exist","Key constraint",JOptionPane.WARNING_MESSAGE);
}
else JOptionPane.showMessageDialog(null,"This value Cannot be Null ","PrimaryKey constraint",JOptionPane.WARNING_MESSAGE);
        }

     else  if(s.equals("2"))  {
           inb = new BufferedReader(new FileReader("F:\\Company\\Employee.txt"));
           outb = new BufferedWriter(new FileWriter("F:\\Company\\Employee.txt",true));
           relational=new BufferedReader(new FileReader("F:\\Company\\Department.txt"));
           fill(inb);
records(inb);   

if(!r.get(3).equals("null")) 
{
if(checkkey( 3,r.get(3)))
{   
    fill(relational);
if (checkforeign(1,r.get(6)))
    
insert(inb, outb  );
    else
JOptionPane.showMessageDialog(null,"No Foregin Key ","Refrencial constraint",JOptionPane.WARNING_MESSAGE);    
    }
else JOptionPane.showMessageDialog(null,"This value is already exist","Key constraint",JOptionPane.WARNING_MESSAGE);
}
else JOptionPane.showMessageDialog(null,"This value Cannot be Null ","PrimaryKey constraint",JOptionPane.WARNING_MESSAGE);
        }

     else  if(s.equals("3"))  {
           inb = new BufferedReader(new FileReader("F:\\Company\\Deptlocations.txt"));
           outb = new BufferedWriter(new FileWriter("F:\\Company\\Deptlocations.txt",true));
           relational=new BufferedReader(new FileReader("F:\\Company\\Department.txt"));
           fill(inb);
      records(inb);
      if(!r.get(0).equals("null") && !r.get(1).equals("null")) 
{
if(checkkey( 0,r.get(0))||checkkey( 1,r.get(1)))
{   
    fill(relational);
if (checkforeign(1,r.get(0)))
    
insert(inb, outb  );
    else
JOptionPane.showMessageDialog(null,"No Foregin Key ","Refrencial constraint",JOptionPane.WARNING_MESSAGE);    
    }
else JOptionPane.showMessageDialog(null,"This value is already exist","Key constraint",JOptionPane.WARNING_MESSAGE);
}
else JOptionPane.showMessageDialog(null,"This value Cannot be Null ","PrimaryKey constraint",JOptionPane.WARNING_MESSAGE);

        }
        
        else  if(s.equals("4"))  {
           inb = new BufferedReader(new FileReader("F:\\Company\\WorksOn.txt"));
           outb = new BufferedWriter(new FileWriter("F:\\Company\\WorksOn.txt",true));
           relational=new BufferedReader(new FileReader("F:\\Company\\Project.txt"));
          relational2=new BufferedReader(new FileReader("F:\\Company\\Employee.txt"));
        
           fill(inb);
records(inb);   
 if(!r.get(0).equals("null") && !r.get(1).equals("null")) 
{
if(checkkey( 0,r.get(0))&&checkkey( 1,r.get(1)))
{   
    
    fill(relational);
    
if (checkforeign(1,r.get(1)))
    fill(relational2);
    if (checkforeign(3,r.get(0)))
insert(inb, outb  );
    else
JOptionPane.showMessageDialog(null,"No Foregin Key ","Refrencial constraint",JOptionPane.WARNING_MESSAGE);    
    }
else JOptionPane.showMessageDialog(null,"This value is already exist","Key constraint",JOptionPane.WARNING_MESSAGE);
}
else JOptionPane.showMessageDialog(null,"This value Cannot be Null ","PrimaryKey constraint",JOptionPane.WARNING_MESSAGE);

        }
        
        else  if(s.equals("5"))  {
           inb = new BufferedReader(new FileReader("F:\\Company\\Project.txt"));
           outb = new BufferedWriter(new FileWriter("F:\\Company\\Project.txt",true));
           relational=new BufferedReader(new FileReader("F:\\Company\\Department.txt"));
           fill(inb);
records(inb);   

if(!r.get(1).equals("null")) 
{
if(checkkey( 1,r.get(1)))
{   
    fill(relational);
if (checkforeign(1,r.get(3)))
    
insert(inb, outb  );
    else
JOptionPane.showMessageDialog(null,"No Foregin Key ","Refrencial constraint",JOptionPane.WARNING_MESSAGE);    
    }
else JOptionPane.showMessageDialog(null,"This value is already exist","Key constraint",JOptionPane.WARNING_MESSAGE);
}
else JOptionPane.showMessageDialog(null,"This value Cannot be Null ","PrimaryKey constraint",JOptionPane.WARNING_MESSAGE);
        



        }
        
        else  if(s.equals("6"))  {
           inb = new BufferedReader(new FileReader("F:\\Company\\Dependent.txt"));
           outb = new BufferedWriter(new FileWriter("F:\\Company\\Dependent.txt",true));
           relational=new BufferedReader(new FileReader("F:\\Company\\Employee.txt"));
           fill(inb);
records(inb);   
      if(!r.get(0).equals("null") && !r.get(1).equals("null")) 
{
if(checkkey( 0,r.get(0))&&checkkey( 1,r.get(1)))
{   
    fill(relational);
if (checkforeign(3,r.get(0)))
    
insert(inb, outb  );
    else
JOptionPane.showMessageDialog(null,"No Foregin Key ","Refrencial constraint",JOptionPane.WARNING_MESSAGE);    
    }
else JOptionPane.showMessageDialog(null,"This value is already exist","Key constraint",JOptionPane.WARNING_MESSAGE);
}
else JOptionPane.showMessageDialog(null,"This value Cannot be Null ","PrimaryKey constraint",JOptionPane.WARNING_MESSAGE);

        }
        
        
else if (s.equals("7")){break;}






  
    
}}catch(IOException e){
    e.printStackTrace();
}
        
    }
    
}