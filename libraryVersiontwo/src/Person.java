
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nema mamdoh
 */
import java.util.Scanner;

public class Person
{

    Scanner In = new Scanner(System.in);
    private String name;
    static int ID = 0;

    private int localID = 0;

    public String getString()
    {
        String s;
        while (true)
        {
            s = In.nextLine();
            s = s.trim();
            if (s.length() > 0)
            {
                break;
            }
        }
        return s;
    }

    public void setLocalID(int localID)
    {
        this.localID = localID;
    }

    public int getLocalID()
    {
        return localID;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getName()
    {
        return name;
    }

    public int getID()
    {
        return ID;
    }

    public void search(int ID, ArrayList<Publications> a)
    {
        boolean found = false;
        for (int i = 0; i < a.size(); i++)
        {
            if (a.get(i).getLocalID() == ID)
            {
                System.out.println("-------------------------------------------");
                System.out.println("Name        : " + a.get(i).getName());
                System.out.println("Publisher   : " + a.get(i).getPublisher());
                System.out.println("Pages       : " + a.get(i).getPages());
                System.out.println("Writer      : " + a.get(i).getPublisher());
                System.out.println("Type        : " + a.get(i).getType());
                System.out.println("ID          : " + a.get(i).getLocalID());
                System.out.println("the book is  : " + (a.get(i).borrowed ? "Borrowed " : "NOT Borrowed."));
                System.out.println("-------------------------------------------");
                found = true;
            }

        }
        if (!found)
        {
            System.out.println("Not found");
        }
    }
}
