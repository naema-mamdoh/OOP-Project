
import java.time.LocalDateTime;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nema mamdoh
 */
public class issueOperation
{

    private int studentID;
    private int adminID;
    private int publicationID;
    private LocalDateTime issueDate;
    private LocalDateTime returnDate;

    public void setIssueDate(LocalDateTime issueDate)
    {
        this.issueDate = issueDate;
    }

    public void setReturnDate(LocalDateTime returnDate)
    {
        this.returnDate = returnDate;
    }

    public LocalDateTime getIssueDate()
    {
        return issueDate;
    }

    public LocalDateTime getReturnDate()
    {
        return returnDate;
    }
    
    public void setStudentID(int studentID)
    {
        this.studentID = studentID;
    }

    public void setAdminID(int adminID)
    {
        this.adminID = adminID;
    }

    public void setpublicationID(int publicationID)
    {
        this.publicationID = publicationID;
    }

    public int getStudentID()
    {
        return studentID;
    }

    public int getAdminID()
    {
        return adminID;
    }

    public int getpublicationID()
    {
        return publicationID;
    }

}
