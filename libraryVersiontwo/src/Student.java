

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nema mamdoh
 */
public class Student extends Person
{

    private int level;

    public Student()
    {
    }
    
    

    public Student(String name, int level)
    {
        this.setName(name);
        this.level = level;
        ID++;
        setLocalID(ID);
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public int getLevel()
    {
        return level;
    }

}
