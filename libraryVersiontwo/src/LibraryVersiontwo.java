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
import java.util.ArrayList;

public class LibraryVersiontwo
{

    static Scanner In = new Scanner(System.in);

    static String getString()
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

    public static void menuOfStudent()
    {
        System.out.println("1-search for publication");
        System.out.println("2-Exit");
    }

    public static void menuOfAdmin()
    {
        System.out.println("1-search for publication.");
        System.out.println("2-add student.");
        System.out.println("3-add publication.");
        System.out.println("4-delete publication");
        System.out.println("5-modify publication");
        System.out.println("6-issue publication");
        System.out.println("7-return publication");
        System.out.println("8-Display list of available publications");
        System.out.println("9-Display list of borrowed publications");
        System.out.println("10-Display list of over-period borrowed publications");
        System.out.println("11-Exit");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ArrayList<Student> studentlist = new ArrayList<Student>();
        ArrayList<Publications> publicationslist = new ArrayList<Publications>();
        ArrayList<issueOperation> issueList = new ArrayList<issueOperation>();

        System.out.println("Library System");

        System.out.println("1- student.\n2- Admin.");
        try
        {

            int option1 = In.nextInt();
            if (option1 == 1)
            {
                menuOfStudent();
                int option2 = In.nextInt();
                while (option2 != 2)
                {
                    if (option2 == 1)
                    {
                        System.out.println("Enter publication id..");
                        int ID = In.nextInt();
                        Student s = new Student();
                        s.search(ID, publicationslist);
                    }
                    else{
                       System.out.println("wrong choice."); 
                    }
                    menuOfStudent();
                }
            }
            else if (option1 == 2)
            {
                System.out.println("enter admin name");
                String name = getString();
                Admin a = new Admin(name);
                menuOfAdmin();
                int option2 = In.nextInt();
                while (option2 != 11)
                {

                    if (option2 == 1)
                    {
                        System.out.println("Enter publication id..");
                        int ID = In.nextInt();
                        a.search(ID, publicationslist);

                    }

                    else if (option2 == 2)
                    {

                        a.addStudent(studentlist);
                    }
                    else if (option2 == 3)
                    {
                        a.addPublication(publicationslist);

                    }
                    else if (option2 == 4)

                    {
                        a.deletePublication(publicationslist);
                    }
                    else if (option2 == 5)
                    {

                        a.modifyPublication(publicationslist);
                    }
                    else if (option2 == 6)
                    {
                        int id = a.ID;
                        a.issueOperation(issueList, publicationslist, studentlist, id);
                    }
                    else if (option2 == 7)
                    {
                        a.returnPublication(issueList, publicationslist);
                    }
                    else if (option2 == 8)
                    {
                        a.diplayAvaliablepublications(publicationslist);
                    }
                    else if (option2 == 9)
                    {
                        a.displayBorrowedPublications(publicationslist);
                    }
                    else if (option2 == 10)
                    {
                        a.displayOverPeriodborrowedPublications(issueList, publicationslist);
                    }
                    menuOfAdmin();
                    option2 = In.nextInt();

                }

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

}
