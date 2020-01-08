

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nema mamdoh
 */
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Person
{

    LocalDateTime issuedDate = LocalDateTime.now();
    LocalDateTime expectedReturnDateForBook = issuedDate.plusSeconds(20);
    LocalDateTime expectedReturnDate = issuedDate.plusSeconds(12);

    public Admin(String name)
    {
        this.setName(name);
        ID++;
    }

    Scanner In = new Scanner(System.in);

    private double salary;

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public double getSalary()
    {
        return salary;
    }

    public void ShowStudentNTH(ArrayList<Student> arr, int index)
    {
        System.out.println("-------------------");
        System.out.println("Student Name   : " + arr.get(index).getName());
        System.out.println("Student ID     : " + arr.get(index).getLocalID());
        System.out.println("Student Level  : " + arr.get(index).getLevel());
        System.out.println("-------------------");
    }

    public void ShowPublicationNth(ArrayList<Publications> a, int index)
    {
        System.out.println("-------------------------------------------");
        System.out.println("Name        : " + a.get(index).getName());
        System.out.println("Publisher   : " + a.get(index).getPublisher());
        System.out.println("Pages       : " + a.get(index).getPages());
        System.out.println("Writer      : " + a.get(index).getPublisher());
        System.out.println("Type        : " + a.get(index).getType());
        System.out.println("ID          : " + a.get(index).getLocalID());
        System.out.println("the book is  : " + (a.get(index).borrowed ? "Borrowed " : "NOT Borrowed."));
        System.out.println("-------------------------------------------");
    }

    public void addStudent(ArrayList<Student> a)
    {
        System.out.println("Enter student name..");
        String nameOfStudent = this.getString();

        System.out.println("Enter student level..");
        int level = In.nextInt();
        if (level < 0)
        {
            System.out.println("level can not be negative number");
        }
        else
        {
            Student s = new Student(nameOfStudent, level);

            a.add(s);
            System.out.println("# Student added successfully...");
            for (int i = 0; i < a.size(); i++)
            {
                ShowStudentNTH(a, i);
            }
        }
    }

    public void addPublication(ArrayList<Publications> a)
    {
        String type = null;
        System.out.println("publication name:");
        String name = this.getString();
        // In.nextLine();
        System.out.println("publication publisher:");
        String publisher = this.getString();
        System.out.println("publication writer:");
        String writer = this.getString();
        System.out.println("publication pages:");
        int pages = 0;
        if (pages < 0)
        {
            System.out.println("level can not be negative number");
        }
        else
        {
            try
            {
                pages = In.nextInt();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

            System.out.println("publication type:\n1-book\n2-booklet\n3-magazine");
        }
        int choosenType = 0;
        if (choosenType < 0)
        {
            System.out.println("choosenType can not be negative number");
        }
        else
        {
            try
            {
                choosenType = In.nextInt();
                if (choosenType == 1)
                {
                    type = "book";
                }
                else if (choosenType == 2)
                {
                    type = "booklet";
                }
                else if (choosenType == 3)
                {
                    type = "magazine";
                }
                else
                {
                    System.out.println("wrong choice");
                }

            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        Publications publication = new Publications(name, pages, publisher, writer, type);
        a.add(publication);

        for (int i = 0; i < a.size(); i++)
        {
            ShowPublicationNth(a, i);
        }
    }

    public void deletePublication(ArrayList<Publications> a)
    {
        System.out.println("enter publication ID");
        int ID = In.nextInt();
        if (ID < 0)
        {
            System.out.println("ID can not be negative number");
        }
        else
        {
            boolean found = false;
            for (int i = 0; i < a.size(); i++)
            {
                if (a.get(i).getLocalID() == ID)
                {
                    a.remove(i);
                    found = true;
                }
            }
            if (found)
            {
                for (int i = 0; i < a.size(); i++)
                {
                    ShowPublicationNth(a, i);
                }
            }
            else
            {
                System.out.println("Book not found");
            }
        }

    }

    public void modifyPublication(ArrayList<Publications> a)
    {
        System.out.println("enter publication ID");
        int ID = In.nextInt();
        for (int i = 0; i < a.size(); i++)
        {
            if (a.get(i).getLocalID() == ID)
            {
                ShowPublicationNth(a, i);
                System.out.println("-----------------------------------------");
                System.out.println("1-modify name");
                System.out.println("2-modify publisher");
                System.out.println("3-modify writer");
                System.out.println("4-modify pages");
                System.out.println("5-modify type");
                int option = In.nextInt();
                if (option == 1)
                {
                    System.out.println("new name:");
                    String name = this.getString();
                    a.get(i).setName(name);
                    ShowPublicationNth(a, i);
                }

                else if (option == 2)
                {
                    System.out.println("new publisher:");
                    String publisher = this.getString();
                    a.get(i).setPublisher(publisher);
                    ShowPublicationNth(a, i);
                }

                else if (option == 3)
                {
                    System.out.println("new writer:");
                    String writer = this.getString();
                    a.get(i).setWriter(writer);
                    ShowPublicationNth(a, i);
                }

                else if (option == 4)
                {
                    System.out.println("new pages:");
                    int pages = In.nextInt();
                    a.get(i).setPages(pages);
                    ShowPublicationNth(a, i);
                }

                else if (option == 5)
                {
                    String type;
                    System.out.println("new type:\n1-book\n2-booklet\n3-magazine");
                    int choosenType = In.nextInt();
                    if (choosenType == 1)
                    {
                        type = "book";
                    }
                    else if (choosenType == 2)
                    {
                        type = "booklet";
                    }
                    else if (choosenType == 3)
                    {
                        type = "magazine";
                    }
                    else
                    {
                        System.out.println("wrong choice");
                    }
                    ShowPublicationNth(a, i);
                }
                else
                {
                    System.out.println("wrong choice");
                }

            }
        }
    }

    public void issueOperation(ArrayList<issueOperation> a, ArrayList<Publications> p, ArrayList<Student> s, int adminID)
    {
        System.out.println("enter student ID");
        int studentID = In.nextInt();
        boolean found = false;
        for (int i = 0; i < s.size(); i++)
        {
            if (s.get(i).getLocalID() == studentID)
            {
                System.out.println("student is enrolled and can issue book");
                found = true;
            }
        }

        System.out.println("enter publication ID");
        int pID = In.nextInt();
        boolean PubFound = false;
        for (int i = 0; i < p.size() && found; i++)
        {
            if (p.get(i).getLocalID() == pID)
            {
                System.out.println("Publication exist");
                PubFound = true;
                p.get(i).borrowed = true;
            }
        }
        if (found && PubFound)
        {
            issueOperation issue = new issueOperation();
            issue.setAdminID(adminID);
            issue.setpublicationID(pID);
            issue.setStudentID(studentID);
            issue.setIssueDate(issuedDate);
            for (int i = 0; i < p.size(); i++)
            {
                if (p.get(i).getType().equals("book"))
                {
                    issue.setReturnDate(expectedReturnDateForBook);
                }
                if (p.get(i).getType().equals("booklet"))
                {
                    issue.setReturnDate(expectedReturnDate);
                }
                if (p.get(i).getType().equals("magazine"))
                {
                    issue.setReturnDate(expectedReturnDate);
                }

            }
            a.add(issue);
            System.out.println("Publication issued");
        }
        else
        {
            System.out.println("student is not enrolled or Publlication not Found !!!");
        }

    }

    public void returnOpration(ArrayList<issueOperation> a, ArrayList<Publications> p, int id)
    {

        boolean found = false;
        for (int j = 0; j < a.size(); j++)
        {
            if (id == a.get(j).getpublicationID())
            {
                found = true;
                for (int i = 0; i < p.size(); i++)
                {
                    if (p.get(i).getLocalID() == a.get(j).getpublicationID())
                    {
                        p.get(i).borrowed = false;
                    }
                }
            }
        }
        if (!found)
        {
            found = false;
            System.out.println("Book not found in issued publications");
        }
    }
    

    public void returnPublication(ArrayList<issueOperation> a, ArrayList<Publications> p)
    {
        LocalDateTime returnDate = LocalDateTime.now();
        System.out.println("1-return Book");
        System.out.println("2-return Booklet");
        System.out.println("3-return Magazine");
        int choice = In.nextInt();
        if (choice == 1)
        {
            System.out.println("enter book id");
            int id = In.nextInt();
            if (returnDate.compareTo(expectedReturnDateForBook) < 0 || returnDate.compareTo(expectedReturnDateForBook) == 0)
            {

                returnOpration(a, p, id);
            }

            if (returnDate.compareTo(expectedReturnDateForBook) > 0)
            {

                returnOpration(a, p, id);
                double dif = ChronoUnit.SECONDS.between(expectedReturnDateForBook, returnDate);
                double fine = dif * 6.5;
                System.out.println("you have to pay a " + fine + "as fine for late to return a book");

            }
        }

        if (choice == 2)
        {
            System.out.println("enter booklet id");
            int id = In.nextInt();
            if (returnDate.compareTo(expectedReturnDate) < 0 || returnDate.compareTo(expectedReturnDate) == 0)
            {
                returnOpration(a, p, id);
            }

            if (returnDate.compareTo(expectedReturnDate) > 0)
            {

                double dif = ChronoUnit.SECONDS.between(expectedReturnDate, returnDate);
                double fine = dif * 6.5;
                System.out.println("you have to pay a " + fine + "as fine for late to return a book");
                returnOpration(a, p, id);
            }
        }

    }

    public void diplayAvaliablepublications(ArrayList<Publications> p)
    {
        System.out.println("1-Books");
        System.out.println("2-Booklets");
        System.out.println("3-Magazines");
        int option = In.nextInt();

        String pType = "NoType";
        if (option == 1)
        {
            pType = "book";
        }
        else if (option == 2)
        {
            pType = "booklet";
        }
        else if (option == 3)
        {
            pType = "magazine";
        }

        if (pType.equals("NoType") == false)
        {
            for (int i = 0; i < p.size(); i++)
            {
                if (p.get(i).getType().equals(pType) && p.get(i).borrowed == false)
                {
                    ShowPublicationNth(p, i);
                }
            }
        }
        else
        {
            System.out.println("Wrong Choise");
        }

    }

    public void displayBorrowedPublications(ArrayList<Publications> p)
    {
        System.out.println("1-Books");
        System.out.println("2-Booklets");
        System.out.println("3-Magazines");
        int option = In.nextInt();
        if (option == 1)
        {
            for (int i = 0; i < p.size(); i++)
            {
                if (p.get(i).getType().equals("book") && p.get(i).borrowed == true)
                {
                    ShowPublicationNth(p, i);
                }
            }
        }

        if (option == 2)
        {
            for (int i = 0; i < p.size(); i++)
            {
                if (p.get(i).getType().equals("booklet") && p.get(i).borrowed == true)
                {
                    ShowPublicationNth(p, i);
                }
            }
        }

        if (option == 3)
        {
            for (int i = 0; i < p.size(); i++)
            {
                if (p.get(i).getType().equals("magazine") && p.get(i).borrowed == true)
                {
                    ShowPublicationNth(p, i);
                }
            }
        }
    }

    public void displayOverPeriodborrowedPublications(ArrayList<issueOperation> a, ArrayList<Publications> p)
    {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("1-Books");
        System.out.println("2-Booklets");
        System.out.println("3-Magazines");
        int option = In.nextInt();
        if (option == 1)
        {
            for (int i = 0; i < a.size(); i++)
            {
                for (int j = 0; j < p.size(); j++)
                {
                    if (p.get(j).getType().equals("book") && p.get(j).borrowed == true && now.compareTo(a.get(i).getReturnDate()) > 0)
                    {
                        ShowPublicationNth(p, j);
                    }
                }
            }
        }

        if (option == 2)
        {
            for (int i = 0; i < a.size(); i++)
            {
                for (int j = 0; j < p.size(); j++)
                {
                    if (p.get(j).getType().equals("booklet") && p.get(j).borrowed == true && now.compareTo(a.get(i).getReturnDate()) > 0)
                    {
                        ShowPublicationNth(p, j);
                    }
                }
            }
        }

        if (option == 3)
        {
            for (int i = 0; i < a.size(); i++)
            {
                for (int j = 0; j < p.size(); j++)
                {
                    if (p.get(j).getType().equals("magazine") && p.get(j).borrowed == true && now.compareTo(a.get(i).getReturnDate()) > 0)
                    {
                        ShowPublicationNth(p, j);
                    }
                }
            }
        }
    }
}
