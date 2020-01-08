

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

public class Publications
{

    Scanner In = new Scanner(System.in);
    private String name;
    static int ID;
    private int localID;
    private int pages;
    private String publisher;
    private String writer;
    private String type;
    boolean borrowed;

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

    public Publications(String name, int pages, String publisher, String writer, String type)
    {
        this.name = name;
        this.pages = pages;
        this.publisher = publisher;
        this.writer = writer;
        this.type = type;
        borrowed = false;
        ID++;
        setLocalID(ID);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPages(int pages)
    {
        this.pages = pages;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public void setWriter(String writer)
    {
        this.writer = writer;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public int getPages()
    {
        return pages;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public String getWriter()
    {
        return writer;
    }

    public String getType()
    {
        return type;
    }

}
