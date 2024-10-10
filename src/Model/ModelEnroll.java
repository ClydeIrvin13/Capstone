/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author luniz
 */
public class ModelEnroll {

    /**
     * @return the enrollment_no
     */
    public int getEnrollment_no() {
        return enrollment_no;
    }

    /**
     * @param enrollment_no the enrollment_no to set
     */
    public void setEnrollment_no(int enrollment_no) {
        this.enrollment_no = enrollment_no;
    }

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
    
    public String getDesc_title() {
        return desc_title;
    }

    /**
     * @param ID_num the ID_num to set
     */
    public void setDesc_title(String desc_title) {
        this.desc_title = desc_title;
    }
    
    public String getUnits() {
        return units;
    }

    /**
     * @param ID_num the ID_num to set
     */
    public void setUnits(String units) {
        this.units = units;
    }

    /**
     * @return the course_code
     */
    public String getCourse_code() {
        return course_code;
    }

    /**
     * @param course_code the course_code to set
     */
    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    /**
     * @return the semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * @return the schoolyear
     */
    public String getSchoolyear() {
        return schoolyear;
    }

    /**
     * @param schoolyear the schoolyear to set
     */
    public void setSchoolyear(String schoolyear) {
        this.schoolyear = schoolyear;
    }
    
    public ModelEnroll(int enrollment_no, String course_code,String desc_title, String units, String semester, String schoolyear) {
        this.enrollment_no = enrollment_no;
        this.course_code = course_code;
        this.desc_title = desc_title;
        this.units = units;
        this.semester = semester;
        this.schoolyear = schoolyear;

    }

    public ModelEnroll() {
    }
    
    
    private int enrollment_no;
    private String ID_num;
    private String course_code;
    private String desc_title;
    private String units;
    private String semester;
    private String schoolyear;
    
    
    public Object[] toTableRow(int rowNum) {
        return new Object[]{false, this, course_code, desc_title, units, semester, schoolyear};
    }
    
     @Override
    public String toString() {
        return course_code;
    }
}
