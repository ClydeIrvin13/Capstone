/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author luniz
 */
public class ModelStudent {

    /**
     * @return the ID_num
     */
    public String getID_num() {
        return ID_num;
    }

    /**
     * @param ID_num the ID_num to set
     */
    public void setID_num(String ID_num) {
        this.ID_num = ID_num;
    }

    /**
     * @return the Lname
     */
    public String getLname() {
        return Lname;
    }

    /**
     * @param Lname the Lname to set
     */
    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    /**
     * @return the Fname
     */
    public String getFname() {
        return Fname;
    }

    /**
     * @param Fname the Fname to set
     */
    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    /**
     * @return the Mname
     */
    public String getMname() {
        return Mname;
    }

    /**
     * @param Mname the Mname to set
     */
    public void setMname(String Mname) {
        this.Mname = Mname;
    }

    /**
     * @return the course
     */
    public String setCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * @return the Major
     */
    public String getMajor() {
        return Major;
    }

    /**
     * @param Major the Major to set
     */
    public void setMajor(String Major) {
        this.Major = Major;
    }
    
    public ModelStudent(String ID_num, String Lname, String Fname, String Mname, String course, String Major) {
        this.ID_num = ID_num;
        this.Lname = Lname;
        this.Fname = Fname;
        this.Mname = Mname;
        this.course = course;
        this.Major = Major;

    }

    public ModelStudent() {
    }
    
    private String ID_num;
    private String Lname;
    private String Fname;
    private String Mname;
    private String course;
    private String Major;
    
     public Object[] toTableRow(int rowNum) {
        return new Object[]{false, this , Lname , Fname , Mname, course, Major};
    }
    
     @Override
    public String toString() {
        return ID_num;
    }
}
