/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author luniz
 */
public class ModelSubject {


  
    public String getCourse_code() {
        return Course_code;
    }

   
    public void setCourse_code(String Course_code) {
        this.Course_code = Course_code;
    }

    
    public String getDesc_title() {
        return Desc_title;
    }

    
    public void setDesc_title(String Desc_title) {
        this.Desc_title = Desc_title;
    }

    
    public String getUnits() {
        return Units;
    }

    
    public void setUnits(String Units) {
        this.Units = Units;
    }

    
   
    
    public ModelSubject(String Course_code, String Desc_title, String Units) {
        this.Course_code = Course_code;
        this.Desc_title = Desc_title;
        this.Units = Units;

    }

    public ModelSubject() {
    }
    
 
    private String Course_code;
    private String Desc_title;
    private String Units;

    
     public Object[] toTableRow(int rowNum) {
        return new Object[]{false, this, Desc_title, Units};
    }
    
     @Override
    public String toString() {
        return Course_code;
    }
}
