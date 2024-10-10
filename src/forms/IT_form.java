package forms;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.*;
import java.awt.print.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import java.awt.event.*;
import raven.toast.Notifications;

/**
 *
 * @author luniz
 */
public class IT_form extends javax.swing.JFrame {

    /**
     * Creates new form IT_form
     */
    private String textValue;

    public IT_form() {
        initComponents();
    }

    public void setTextValue(String textValue) {
        // Here you can handle the text value, for example:
        this.textValue = textValue;  // Assuming you have a JLabel in your IT_form1
        loadEvaluationData(this.textValue);
    }

    /*private void loadEvaluationData(String studentId) {
        String sql = "SELECT tentative_grade, final_grade, course_code, student_table.Lname, student_table.Fname, student_table.Mname, student_table.course FROM grades_table join enrollment_table ON enrollment_table.enrollment_no = grades_table.enrollment_no join student_table ON enrollment_table.ID_num = student_table.ID_num WHERE enrollment_table.ID_num = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, studentId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String subjectCode = rs.getString("course_code");
                String tentative_grade = rs.getString("tentative_grade");
                String final_grade = rs.getString("final_grade");
                displayGradeForSubject(subjectCode, tentative_grade, final_grade);

                String lname = rs.getString("Lname");
                String fname = rs.getString("Fname");
                String mname = rs.getString("Mname");
                String course = rs.getString("course");

                IDNO.setText("ID NUMBER: " + studentId);
                NME.setText("NAME: " + lname + ", " + fname + " " + mname);
                COUR.setText("COURSE: " + course);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading evaluation data: " + e.getMessage());
        }
    }*/
    private void loadEvaluationData(String studentId) {
        String sql = "SELECT tentative_grade, final_grade, course_code, student_table.Lname, student_table.Fname, student_table.Mname, student_table.course "
                + "FROM grades_table "
                + "JOIN enrollment_table ON enrollment_table.enrollment_no = grades_table.enrollment_no "
                + "JOIN student_table ON enrollment_table.ID_num = student_table.ID_num "
                + "WHERE enrollment_table.ID_num = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId);
            ResultSet rs = pstmt.executeQuery();

            // Check if the ResultSet is empty
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(this, "No Record Found");
                return; // Exit the method if no records are found
            }

            while (rs.next()) {
                String subjectCode = rs.getString("course_code");
                String tentative_grade = rs.getString("tentative_grade");
                String final_grade = rs.getString("final_grade");
                displayGradeForSubject(subjectCode, tentative_grade, final_grade);

                String lname = rs.getString("Lname");
                String fname = rs.getString("Fname");
                String mname = rs.getString("Mname");
                String course = rs.getString("course");

                IDNO.setText("ID NUMBER: " + studentId);
                NME.setText("NAME: " + lname + ", " + fname + " " + mname);
                COUR.setText("COURSE: " + course);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading evaluation data: " + e.getMessage());
        }
    }

    private void displayGradeForSubject(String subjectCode, String tentative_grade, String final_grade) {
        switch (subjectCode) {
            /* first year first sem */
            case "REED 1":
                REED1_TFG.setText(tentative_grade);
                REED1_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    REED1_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    REED1_FG.setText("‎‎ ");
                }
                break;

            case "GE 01":
                GE01_TFG.setText(tentative_grade);
                GE01_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    GE01_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    GE01_FG.setText("‎‎ ");
                }
                break;

            case "GE 02":
                GE02_TFG.setText(tentative_grade);
                GE02_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    GE02_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    GE02_FG.setText("‎‎ ");
                }
                break;

            case "GE 03":
                GE03_TFG.setText(tentative_grade);
                GE03_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    GE03_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    GE03_FG.setText("‎‎ ");
                }
                break;

            case "DID 101":
                DID101_TFG.setText(tentative_grade);
                DID101_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    DID101_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    DID101_FG.setText("‎‎ ");
                }
                break;

            case "ITCC 100":
                ITCC100_TFG.setText(tentative_grade);
                ITCC100_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    ITCC100_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    ITCC100_FG.setText("‎‎ ");
                }
                break;

            case "ITCC 101":
                ITCC101_TFG.setText(tentative_grade);
                ITCC101_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    ITCC101_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    ITCC101_FG.setText("‎‎ ");
                }
                break;

            case "PE 1":
                PE1_TFG.setText(tentative_grade);
                PE1_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    PE1_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    PE1_FG.setText("‎‎ ");
                }
                break;

            case "GE 09":
                GE09_TFG.setText(tentative_grade);
                GE09_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    GE09_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    GE09_FG.setText("‎‎ ");
                }
                break;

            /* first year second sem */
            case "GE 04":
                GE04_TFG.setText(tentative_grade);
                GE04_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    GE04_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    GE04_FG.setText("‎‎ ");
                }
                break;

            case "GE 05":
                GE05_TFG.setText(tentative_grade);
                GE05_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    GE05_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    GE05_FG.setText("‎‎ ");
                }
                break;

            case "REED 2":
                REED2_TFG.setText(tentative_grade);
                REED2_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    REED2_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    REED2_FG.setText("‎‎ ");
                }
                break;

            case "HCI 101":
                HCI101_TFG.setText(tentative_grade);
                HCI101_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    HCI101_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    HCI101_FG.setText("‎‎ ");
                }
                break;

            case "ITCC 102":
                ITCC102_TFG.setText(tentative_grade);
                ITCC102_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    ITCC102_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    ITCC102_FG.setText("‎‎ ");
                }
                break;

            case "MS 101":
                MS101_TFG.setText(tentative_grade);
                MS101_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    MS101_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    MS101_FG.setText("‎‎ ");
                }
                break;

            case "PE 2":
                PE2_TFG.setText(tentative_grade);
                PE2_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    PE2_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    PE2_FG.setText("‎‎ ");
                }
                break;

            case "GE 10":
                GE10_TFG.setText(tentative_grade);
                GE10_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    GE10_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    GE10_FG.setText("‎‎ ");
                }
                break;

            /* SECOND year 1ST sem */
            case "GE 07":
                GE07_TFG.setText(tentative_grade);
                GE07_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    GE07_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    GE07_FG.setText("‎‎ ");
                }
                break;

            case "GE 08":
                GE08_TFG.setText(tentative_grade);
                GE08_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    GE08_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    GE08_FG.setText("‎‎ ");
                }
                break;

            case "REED 3":
                REED3_TFG.setText(tentative_grade);
                REED3_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    REED3_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    REED3_FG.setText("‎‎ ");
                }
                break;

            case "DTP 101":
                DTP101_TFG.setText(tentative_grade);
                DTP101_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    DTP101_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    DTP101_FG.setText("‎‎ ");
                }
                break;

            case "PF 101":
                PF101_TFG.setText(tentative_grade);
                PF101_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    PF101_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    PF101_FG.setText("‎‎ ");
                }
                break;

            case "ITCC 103":
                ITCC103_TFG.setText(tentative_grade);
                ITCC103_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    ITCC103_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    ITCC103_FG.setText("‎‎ ");
                }
                break;

            case "PE 3":
                PE3_TFG.setText(tentative_grade);
                PE3_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    PE3_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    PE3_FG.setText("‎‎ ");
                }
                break;

            case "HCI 102":
                HCI102_TFG.setText(tentative_grade);
                HCI102_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    HCI102_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    HCI102_FG.setText("‎‎ ");
                }
                break;

            case "LIT":
                LIT_TFG.setText(tentative_grade);
                LIT_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    LIT_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    LIT_FG.setText("‎‎ ");
                }
                break;

            /* SECOND year 2ND sem */
            case "REED 4":
                REED4_TFG.setText(tentative_grade);
                REED4_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    REED4_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    REED4_FG.setText("‎‎ ");
                }
                break;

            case "ITCC 104":
                ITCC104_TFG.setText(tentative_grade);
                ITCC104_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    ITCC104_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    ITCC104_FG.setText("‎‎ ");
                }
                break;

            case "MS 102":
                MS102_TFG.setText(tentative_grade);
                MS102_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    MS102_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    MS102_FG.setText("‎‎ ");
                }
                break;

            case "NET 101":
                NET101_TFG.setText(tentative_grade);
                NET101_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    NET101_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    NET101_FG.setText("‎‎ ");
                }
                break;

            case "IPT 101":
                IPT101_TFG.setText(tentative_grade);
                IPT101_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    IPT101_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    IPT101_FG.setText("‎‎ ");
                }
                break;

            case "PT 101":
                PT101_TFG.setText(tentative_grade);
                PT101_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    PT101_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    PT101_FG.setText("‎‎ ");
                }
                break;

            case "PE 4":
                PE4_TFG.setText(tentative_grade);
                PE4_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    PE4_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    PE4_FG.setText("‎‎ ");
                }
                break;

            case "GE 06":
                GE06_TFG.setText(tentative_grade);
                GE06_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    GE06_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    GE06_FG.setText("‎‎ ");
                }
                break;

            case "NSTP 1":
                NSTP1_TFG.setText(tentative_grade);
                NSTP1_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    NSTP1_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    NSTP1_FG.setText("‎‎ ");
                }
                break;

            /* SECOND year SUMMER */
            case "NSTP 2":
                NSTP2_TFG.setText(tentative_grade);
                NSTP2_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    NSTP2_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    NSTP2_FG.setText("‎‎ ");
                }
                break;

            case "FIL 1":
                FIL1_TFG.setText(tentative_grade);
                FIL1_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    FIL1_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    FIL1_FG.setText("‎‎ ");
                }
                break;

            case "FIL 2":
                FIL2_TFG.setText(tentative_grade);
                FIL2_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    FIL2_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    FIL2_FG.setText("‎‎ ");
                }
                break;

            /* 3RD year 1ST SEM */
            case "ITCC 105":
                ITCC105_TFG.setText(tentative_grade);
                ITCC105_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    ITCC105_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    ITCC105_FG.setText("‎‎ ");
                }
                break;

            case "IM 102":
                IM102_TFG.setText(tentative_grade);
                IM102_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    IM102_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    IM102_FG.setText("‎‎ ");
                }
                break;

            case "NET 102":
                NET102_TFG.setText(tentative_grade);
                NET102_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    NET102_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    NET102_FG.setText("‎‎ ");
                }
                break;

            case "SIA 101":
                SIA101_TFG.setText(tentative_grade);
                SIA101_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    SIA101_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    SIA101_FG.setText("‎‎ ");
                }
                break;

            case "IAS 101":
                IAS101_TFG.setText(tentative_grade);
                IAS101_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    IAS101_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    IAS101_FG.setText("‎‎ ");
                }
                break;

            case "SP 101":
                SP101_TFG.setText(tentative_grade);
                SP101_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    SP101_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    SP101_FG.setText("‎‎ ");
                }
                break;

            case "GE 11":
                GE11_TFG.setText(tentative_grade);
                GE11_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    GE11_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    GE11_FG.setText("‎‎ ");
                }
                break;
                
            /* 3RD year 2ND SEM */
            case "RIZAL":
                RIZAL_TFG.setText(tentative_grade);
                RIZAL_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    RIZAL_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    RIZAL_FG.setText("‎‎ ");
                }
                break;

            case "WS 101":
                WS101_TFG.setText(tentative_grade);
                WS101_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    WS101_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    WS101_FG.setText("‎‎ ");
                }
                break;

            case "SIA 102":
                SIA102_TFG.setText(tentative_grade);
                SIA102_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    SIA102_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    SIA102_FG.setText("‎‎ ");
                }
                break;

            case "TECH 1":
                TECH1_TFG.setText(tentative_grade);
                TECH1_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    TECH1_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    TECH1_FG.setText("‎‎ ");
                }
                break;

            case "TECH 1L":
                TECH1L_TFG.setText(tentative_grade);
                TECH1L_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    TECH1L_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    TECH1L_FG.setText("‎‎ ");
                }
                break;

            case "GE 12":
                GE12_TFG.setText(tentative_grade);
                GE12_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    GE12_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    GE12_FG.setText("‎‎ ");
                }
                break;
                
                /* 3RD year SUMMER */
            case "ITCAP 101":
                ITCAP101_TFG.setText(tentative_grade);
                ITCAP101_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    ITCAP101_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    ITCAP101_FG.setText("‎‎ ");
                }
                break;

            case "IAS 102":
                IAS102_TFG.setText(tentative_grade);
                IAS102_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    IAS102_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    IAS102_FG.setText("‎‎ ");
                }
                break;
                
                /* 4TH year 1ST SEM */
            case "ITCAP 102":
                ITCAP102_TFG.setText(tentative_grade);
                ITCAP102_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    ITCAP102_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    ITCAP102_FG.setText("‎‎ ");
                }
                break;

            case "SA 101":
                SA101_TFG.setText(tentative_grade);
                SA101_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    SA101_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    SA101_FG.setText("‎‎ ");
                }
                break;
                
                case "WD 101":
                WD101_TFG.setText(tentative_grade);
                WD101_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    WD101_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    WD101_FG.setText("‎‎ ");
                }
                break;

            case "IPT 102":
                IPT102_TFG.setText(tentative_grade);
                IPT102_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    IPT102_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    IPT102_FG.setText("‎‎ ");
                }
                break;
                
                case "ITPRAC 101":
                ITPRAC101_TFG.setText(tentative_grade);
                ITPRAC101_FG.setText(final_grade);
                if (tentative_grade == null || tentative_grade.isEmpty()) {
                    ITPRAC101_TFG.setText("‎‎ ");
                }
                if (final_grade == null || final_grade.isEmpty()) {
                    ITPRAC101_FG.setText("‎‎ ");
                }
                break;
        }
    }

    private Connection connect() {
        // Implement your database connection logic here
        // For example:
        String url = "jdbc:sqlite:C:\\Users\\luniz\\OneDrive\\Documents\\capstone_db.db"; // Update this to your database path
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void printWithPreview(JPanel jPanel1) {
        // Long bond paper dimensions (8.5 x 13 inches) in points
        final double paperWidth = 8.5 * 72;   // 8.5 inches * 72 points per inch
        final double paperHeight = 13 * 72;   // 13 inches * 72 points per inch

        // Create the preview dialog
        JFrame previewFrame = new JFrame("Print Preview");
        previewFrame.setSize(1200, 600);
        previewFrame.setLayout(new BorderLayout());

        // Create a scrollable panel to preview the content
        JScrollPane scrollPane = new JScrollPane(jPanel1);
        previewFrame.add(scrollPane, BorderLayout.CENTER);

        // Add Print and Cancel buttons
        JPanel buttonPanel = new JPanel();
        JButton printButton = new JButton("Print");
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(printButton);
        buttonPanel.add(cancelButton);
        previewFrame.add(buttonPanel, BorderLayout.SOUTH);

        // Button to close preview without printing
        cancelButton.addActionListener(e -> previewFrame.dispose());

        // Button to print the panel after showing the preview
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Print the panel after showing preview
                PrinterJob printerJob = PrinterJob.getPrinterJob();
                printerJob.setJobName("Print jPanel1");

                printerJob.setPrintable(new Printable() {
                    @Override
                    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                        if (pageIndex > 0) {
                            return Printable.NO_SUCH_PAGE;
                        }

                        // Translate to the top left corner of the printable area
                        Graphics2D g2d = (Graphics2D) graphics;
                        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                        // Scale the content of jPanel1 to fit long bond paper width
                        double panelWidth = jPanel1.getWidth();
                        double scaleX = paperWidth / panelWidth;
                        double scaleY = paperHeight / jPanel1.getHeight();  // Scale to fit the height too if necessary
                        double scale = Math.min(scaleX, scaleY);  // Maintain aspect ratio

                        g2d.scale(scale, scale);  // Apply the scale transformation

                        // Print the entire jPanel1
                        jPanel1.printAll(g2d);

                        return Printable.PAGE_EXISTS;
                    }
                });

                // Show print dialog and print if the user accepts
                if (printerJob.printDialog()) {
                    try {
                        printerJob.print();
                    } catch (PrinterException ex) {
                        ex.printStackTrace();
                    }
                }

                // Close the preview window after printing
                previewFrame.dispose();
            }
        });

        // Show the preview window
        previewFrame.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        ITCAP102_FG = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        MS102_FG = new javax.swing.JLabel();
        jLabel346 = new javax.swing.JLabel();
        ITCC101_TFG = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel352 = new javax.swing.JLabel();
        WD101_TFG = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel368 = new javax.swing.JLabel();
        jLabel323 = new javax.swing.JLabel();
        jLabel322 = new javax.swing.JLabel();
        LIT_TFG = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel338 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel240 = new javax.swing.JLabel();
        FIL2_TFGFFFF = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        PT101_TFG = new javax.swing.JLabel();
        ITPRAC101_FG = new javax.swing.JLabel();
        GE08_FG = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel277 = new javax.swing.JLabel();
        DID101_FG = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        GE12_TFG = new javax.swing.JLabel();
        REED2_FG = new javax.swing.JLabel();
        WS101_FG = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        RIZAL_TFG = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        PE4_TFG = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel371 = new javax.swing.JLabel();
        REED4_TFG = new javax.swing.JLabel();
        jLabel360 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        ITCC103_FG = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel288 = new javax.swing.JLabel();
        REED3_TFG = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        NET102_TFG = new javax.swing.JLabel();
        GE06_TFG = new javax.swing.JLabel();
        jLabel331 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        SA101_FG = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TECH1_FG = new javax.swing.JLabel();
        jLabel221 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel366 = new javax.swing.JLabel();
        jLabel312 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        FIL1_FG = new javax.swing.JLabel();
        NSTP1_TFG = new javax.swing.JLabel();
        HCI101_FG = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        jLabel276 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        ITCAP101_FG = new javax.swing.JLabel();
        PE2_TFG = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        GE10_FG = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        NSTP2_TFG = new javax.swing.JLabel();
        ITCC101_FG = new javax.swing.JLabel();
        GE05_TFG = new javax.swing.JLabel();
        jLabel374 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        TECH1L_FG = new javax.swing.JLabel();
        ITCC100_TFG = new javax.swing.JLabel();
        PF101_FG = new javax.swing.JLabel();
        GE02_FG = new javax.swing.JLabel();
        ITPRAC101_TFG = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        jLabel260 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel343 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        PE2_FG = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        IM102_TFG = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel379 = new javax.swing.JLabel();
        GE04_TFG = new javax.swing.JLabel();
        jLabel316 = new javax.swing.JLabel();
        jLabel283 = new javax.swing.JLabel();
        jLabel359 = new javax.swing.JLabel();
        jLabel259 = new javax.swing.JLabel();
        jLabel279 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        GE03_TFG = new javax.swing.JLabel();
        jLabel376 = new javax.swing.JLabel();
        GE07_FG = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel330 = new javax.swing.JLabel();
        jLabel211 = new javax.swing.JLabel();
        jLabel245 = new javax.swing.JLabel();
        HCI102_TFG = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel289 = new javax.swing.JLabel();
        jLabel321 = new javax.swing.JLabel();
        jLabel328 = new javax.swing.JLabel();
        jLabel264 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jLabel329 = new javax.swing.JLabel();
        jLabel353 = new javax.swing.JLabel();
        ITCC105_TFG = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel261 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel336 = new javax.swing.JLabel();
        GE09_TFG = new javax.swing.JLabel();
        jLabel375 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel339 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel251 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel257 = new javax.swing.JLabel();
        jLabel273 = new javax.swing.JLabel();
        IPT101_TFG = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        IAS101_TFG = new javax.swing.JLabel();
        jLabel231 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        jLabel241 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel284 = new javax.swing.JLabel();
        jLabel319 = new javax.swing.JLabel();
        jLabel248 = new javax.swing.JLabel();
        ITCC105_FG = new javax.swing.JLabel();
        jLabel341 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        SP101_FG = new javax.swing.JLabel();
        jLabel212 = new javax.swing.JLabel();
        jLabel300 = new javax.swing.JLabel();
        jLabel320 = new javax.swing.JLabel();
        jLabel282 = new javax.swing.JLabel();
        jLabelCourse1 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        LIT_FG = new javax.swing.JLabel();
        ITCC104_FG = new javax.swing.JLabel();
        HCI102_FG = new javax.swing.JLabel();
        DID101_TFG = new javax.swing.JLabel();
        jLabel324 = new javax.swing.JLabel();
        RIZAL_FG = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        SIA102_FG = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        GE08_TFG = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel367 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        jLabel372 = new javax.swing.JLabel();
        NET101_FG = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel348 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel287 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel325 = new javax.swing.JLabel();
        ITCC102_TFG = new javax.swing.JLabel();
        jLabel207 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        SP101_TFG = new javax.swing.JLabel();
        PE1_FG = new javax.swing.JLabel();
        jLabel315 = new javax.swing.JLabel();
        jLabel347 = new javax.swing.JLabel();
        MS101_FG = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        ITCC102_FG = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel370 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        GE06_FG = new javax.swing.JLabel();
        jLabel326 = new javax.swing.JLabel();
        jLabel332 = new javax.swing.JLabel();
        jLabel262 = new javax.swing.JLabel();
        GE10_TFG = new javax.swing.JLabel();
        DTP101_TFG = new javax.swing.JLabel();
        FIL2_TFG = new javax.swing.JLabel();
        GE11_FG = new javax.swing.JLabel();
        jLabel234 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel342 = new javax.swing.JLabel();
        jLabel236 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        PE3_FG = new javax.swing.JLabel();
        GE09_FG = new javax.swing.JLabel();
        jLabel364 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel230 = new javax.swing.JLabel();
        REED1_TFG = new javax.swing.JLabel();
        jLabel208 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel363 = new javax.swing.JLabel();
        jLabel265 = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        jLabel292 = new javax.swing.JLabel();
        DTP101_FG = new javax.swing.JLabel();
        ITCAP101_TFG = new javax.swing.JLabel();
        jLabel356 = new javax.swing.JLabel();
        ITCC100_FG = new javax.swing.JLabel();
        jLabel255 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel294 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        NSTP1_FG = new javax.swing.JLabel();
        jLabel227 = new javax.swing.JLabel();
        jLabel311 = new javax.swing.JLabel();
        IPT102_FG = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        PE3_TFG = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel250 = new javax.swing.JLabel();
        jLabel225 = new javax.swing.JLabel();
        IPT101_FG = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel340 = new javax.swing.JLabel();
        REED4_FG = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        jLabel285 = new javax.swing.JLabel();
        jLabel256 = new javax.swing.JLabel();
        jLabel275 = new javax.swing.JLabel();
        IAS102_TFG = new javax.swing.JLabel();
        jLabel244 = new javax.swing.JLabel();
        GE01_FG = new javax.swing.JLabel();
        jLabel274 = new javax.swing.JLabel();
        jLabel377 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        SA101_TFG = new javax.swing.JLabel();
        jLabel298 = new javax.swing.JLabel();
        jLabel317 = new javax.swing.JLabel();
        jLabel249 = new javax.swing.JLabel();
        jLabel344 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        ITCC103_TFG = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        GE02_TFG = new javax.swing.JLabel();
        PF101_TFG = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        NSTP2_FG = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel350 = new javax.swing.JLabel();
        PT101_FG = new javax.swing.JLabel();
        jLabel242 = new javax.swing.JLabel();
        HCI101_TFG = new javax.swing.JLabel();
        jLabel297 = new javax.swing.JLabel();
        REED3_FG = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        IM102_FG = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel318 = new javax.swing.JLabel();
        jLabel335 = new javax.swing.JLabel();
        GE11_TFG = new javax.swing.JLabel();
        jLabel354 = new javax.swing.JLabel();
        jLabel278 = new javax.swing.JLabel();
        GE03_FG = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        NET102_FG = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        WS101_TFG = new javax.swing.JLabel();
        jLabel293 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel291 = new javax.swing.JLabel();
        jLabel314 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        jLabel380 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        IAS102_FG = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        jLabel219 = new javax.swing.JLabel();
        REED2_TFG = new javax.swing.JLabel();
        WD101_FG = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        SIA101_TFG = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        jLabel280 = new javax.swing.JLabel();
        jLabel272 = new javax.swing.JLabel();
        FIL2_FG = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        PE4_FG = new javax.swing.JLabel();
        jLabel266 = new javax.swing.JLabel();
        NET101_TFG = new javax.swing.JLabel();
        jLabel218 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel269 = new javax.swing.JLabel();
        jLabel373 = new javax.swing.JLabel();
        GE07_TFG = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        PE1_TFG = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        ITCAP102_TFG = new javax.swing.JLabel();
        jLabel233 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jLabel313 = new javax.swing.JLabel();
        GE12_FG = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel296 = new javax.swing.JLabel();
        REED1_FG = new javax.swing.JLabel();
        GE01_TFG = new javax.swing.JLabel();
        IPT102_TFG = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        MS102_TFG = new javax.swing.JLabel();
        jLabel361 = new javax.swing.JLabel();
        SIA102_TFG = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        jLabel253 = new javax.swing.JLabel();
        jLabel365 = new javax.swing.JLabel();
        IAS101_FG = new javax.swing.JLabel();
        jLabel247 = new javax.swing.JLabel();
        jLabel229 = new javax.swing.JLabel();
        jLabel349 = new javax.swing.JLabel();
        jLabel258 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jLabel327 = new javax.swing.JLabel();
        jLabel286 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        jLabel381 = new javax.swing.JLabel();
        jLabel369 = new javax.swing.JLabel();
        jLabel290 = new javax.swing.JLabel();
        jLabel351 = new javax.swing.JLabel();
        MS101_TFG = new javax.swing.JLabel();
        jLabel345 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel267 = new javax.swing.JLabel();
        SIA101_FG = new javax.swing.JLabel();
        jLabel295 = new javax.swing.JLabel();
        GE04_FG = new javax.swing.JLabel();
        jLabel337 = new javax.swing.JLabel();
        GE05_FG = new javax.swing.JLabel();
        TECH1L_TFG = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        TECH1_TFG = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel358 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel333 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel281 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        FIL1_TFG = new javax.swing.JLabel();
        jLabel268 = new javax.swing.JLabel();
        ITCC104_TFG = new javax.swing.JLabel();
        jLabel378 = new javax.swing.JLabel();
        jLabel271 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel252 = new javax.swing.JLabel();
        jLabel334 = new javax.swing.JLabel();
        jLabel254 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel362 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel270 = new javax.swing.JLabel();
        jLabel263 = new javax.swing.JLabel();
        jLabel235 = new javax.swing.JLabel();
        jLabel246 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel299 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        IDNO = new javax.swing.JLabel();
        NME = new javax.swing.JLabel();
        COUR = new javax.swing.JLabel();
        jLabelCourse2 = new javax.swing.JLabel();
        jLabelCourse3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        ntxtfield6 = new javax.swing.JTextField();
        edit_sbj_btn8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        ITCAP102_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        ITCAP102_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITCAP102_FG.setText("‎ ");
        ITCAP102_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel145.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel145.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel145.setText("PE 1 ");
        jLabel145.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        MS102_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        MS102_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MS102_FG.setText("‎ ");
        MS102_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel346.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel346.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel346.setText("IAS 102");
        jLabel346.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ITCC101_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ITCC101_TFG.setForeground(new java.awt.Color(204, 0, 0));
        ITCC101_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITCC101_TFG.setText("‎ ");
        ITCC101_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel31.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel31.setText("GE 02");
        jLabel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel74.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel74.setText("GE 04");
        jLabel74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel352.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel352.setText("‎ ");
        jLabel352.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        WD101_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        WD101_TFG.setForeground(new java.awt.Color(204, 0, 0));
        WD101_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WD101_TFG.setText("‎ ");
        WD101_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel181.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel181.setText("Kontekstawlisadong Komunikasyon sa Filipino");
        jLabel181.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel80.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("U");
        jLabel80.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel368.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel368.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel368.setText("3");
        jLabel368.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel323.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel323.setText("Information Assurance and Security 2");
        jLabel323.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel322.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel322.setText("Capstone Project and Research");
        jLabel322.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        LIT_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        LIT_TFG.setForeground(new java.awt.Color(204, 0, 0));
        LIT_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LIT_TFG.setText("‎ ");
        LIT_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("GRADES");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel338.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel338.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel338.setText("‎ ");
        jLabel338.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel141.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel141.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel141.setText("3");
        jLabel141.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel240.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel240.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel240.setText("ITCC 103");
        jLabel240.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        FIL2_TFGFFFF.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        FIL2_TFGFFFF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FIL2_TFGFFFF.setText("‎ ");
        FIL2_TFGFFFF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel173.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel173.setText("HCI 102");
        jLabel173.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel159.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel159.setText("NSTP 2/CWTS 2");
        jLabel159.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PT101_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        PT101_TFG.setForeground(new java.awt.Color(204, 0, 0));
        PT101_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PT101_TFG.setText("‎ ");
        PT101_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ITPRAC101_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        ITPRAC101_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITPRAC101_FG.setText("‎ ");
        ITPRAC101_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE08_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        GE08_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE08_FG.setText("‎ ");
        GE08_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel26.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel26.setText("Understanding the Self");
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel277.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel277.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel277.setText("3");
        jLabel277.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DID101_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        DID101_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DID101_FG.setText("‎ ");
        DID101_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel175.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel175.setText("FIL 1");
        jLabel175.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE12_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        GE12_TFG.setForeground(new java.awt.Color(204, 0, 0));
        GE12_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE12_TFG.setText("‎ ");
        GE12_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        REED2_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        REED2_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        REED2_FG.setText("‎ ");
        REED2_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        WS101_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        WS101_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WS101_FG.setText("‎ ");
        WS101_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel94.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel94.setText("Programming 1");
        jLabel94.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel174.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel174.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel174.setText("3");
        jLabel174.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        RIZAL_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        RIZAL_TFG.setForeground(new java.awt.Color(204, 0, 0));
        RIZAL_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RIZAL_TFG.setText("‎ ");
        RIZAL_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel51.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("‎ ");
        jLabel51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel158.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel158.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel158.setText("3");
        jLabel158.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel193.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel193.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel193.setText("ITCC 100");
        jLabel193.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel117.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel117.setText("COURSE CODE");
        jLabel117.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PE4_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        PE4_TFG.setForeground(new java.awt.Color(204, 0, 0));
        PE4_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PE4_TFG.setText("‎ ");
        PE4_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel89.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("3");
        jLabel89.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel371.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel371.setText("‎ ");
        jLabel371.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        REED4_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        REED4_TFG.setForeground(new java.awt.Color(204, 0, 0));
        REED4_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        REED4_TFG.setText("‎ ");
        REED4_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel360.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel360.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel360.setText("‎ ");
        jLabel360.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel72.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("3");
        jLabel72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel84.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("GRADES");
        jLabel84.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ITCC103_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        ITCC103_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITCC103_FG.setText("‎ ");
        ITCC103_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("DESCRIPTIVE TITLE");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel288.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel288.setText("Digital Electronics Lab");
        jLabel288.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        REED3_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        REED3_TFG.setForeground(new java.awt.Color(204, 0, 0));
        REED3_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        REED3_TFG.setText("‎ ");
        REED3_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel142.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel142.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel142.setText("3");
        jLabel142.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        NET102_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        NET102_TFG.setForeground(new java.awt.Color(204, 0, 0));
        NET102_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NET102_TFG.setText("‎ ");
        NET102_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE06_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        GE06_TFG.setForeground(new java.awt.Color(204, 0, 0));
        GE06_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE06_TFG.setText("‎ ");
        GE06_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel331.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel331.setText("‎ ");
        jLabel331.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel222.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel222.setText("GE 06");
        jLabel222.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SA101_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        SA101_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SA101_FG.setText("‎ ");
        SA101_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("TENTATIVE");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TECH1_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        TECH1_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TECH1_FG.setText("‎ ");
        TECH1_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel221.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel221.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel221.setText("3");
        jLabel221.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel129.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel129.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel129.setText("ITCC 101");
        jLabel129.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel44.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel44.setText("Programming 1");
        jLabel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel366.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel366.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel366.setText("IPT 101");
        jLabel366.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel312.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel312.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel312.setText("‎ ");
        jLabel312.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel123.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel123.setText("Remedial Instruction");
        jLabel123.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel180.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel180.setText("Panitikang Filipino / Sinesosyodad");
        jLabel180.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        FIL1_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        FIL1_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FIL1_FG.setText("‎ ");
        FIL1_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        NSTP1_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        NSTP1_TFG.setForeground(new java.awt.Color(204, 0, 0));
        NSTP1_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NSTP1_TFG.setText("‎ ");
        NSTP1_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        HCI101_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        HCI101_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HCI101_FG.setText("‎ ");
        HCI101_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel178.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel178.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel178.setText("3");
        jLabel178.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel276.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel276.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel276.setText("3");
        jLabel276.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel37.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel37.setText("Mathematics in the Modern World");
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ITCAP101_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        ITCAP101_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITCAP101_FG.setText("‎ ");
        ITCAP101_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PE2_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        PE2_TFG.setForeground(new java.awt.Color(204, 0, 0));
        PE2_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PE2_TFG.setText("‎ ");
        PE2_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("U");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("3");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE10_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        GE10_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE10_FG.setText("‎ ");
        GE10_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel76.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("‎ ");
        jLabel76.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        NSTP2_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        NSTP2_TFG.setForeground(new java.awt.Color(204, 0, 0));
        NSTP2_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NSTP2_TFG.setText("‎ ");
        NSTP2_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ITCC101_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        ITCC101_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITCC101_FG.setText("‎ ");
        ITCC101_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE05_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        GE05_TFG.setForeground(new java.awt.Color(204, 0, 0));
        GE05_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE05_TFG.setText("‎ ");
        GE05_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel374.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel374.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel374.setText("‎ ");
        jLabel374.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel149.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel149.setText("Community Service and Immersion");
        jLabel149.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel71.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("2");
        jLabel71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel57.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("‎ ");
        jLabel57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TECH1L_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        TECH1L_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TECH1L_FG.setText("‎ ");
        TECH1L_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ITCC100_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ITCC100_TFG.setForeground(new java.awt.Color(204, 0, 0));
        ITCC100_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITCC100_TFG.setText("‎ ");
        ITCC100_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PF101_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        PF101_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PF101_FG.setText("‎ ");
        PF101_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE02_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        GE02_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE02_FG.setText("‎ ");
        GE02_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ITPRAC101_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ITPRAC101_TFG.setForeground(new java.awt.Color(204, 0, 0));
        ITPRAC101_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITPRAC101_TFG.setText("‎ ");
        ITPRAC101_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel184.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel184.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel184.setText("3 ");
        jLabel184.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel260.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel260.setText("IM 102");
        jLabel260.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel146.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel146.setText("Dancing");
        jLabel146.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel109.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel109.setText("GE 03");
        jLabel109.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel90.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(204, 0, 0));
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("‎ ");
        jLabel90.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel100.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel100.setText("Introduction to Human Computer Interaction");
        jLabel100.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel343.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel343.setText("Capstone Project and Research 2");
        jLabel343.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel162.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel162.setText("Data Structure and Algorithm");
        jLabel162.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PE2_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        PE2_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PE2_FG.setText("‎ ");
        PE2_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel226.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel226.setText("Integrative Programming and Technologies");
        jLabel226.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel223.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel223.setText("‎ ");
        jLabel223.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        IM102_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        IM102_TFG.setForeground(new java.awt.Color(204, 0, 0));
        IM102_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IM102_TFG.setText("‎ ");
        IM102_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel42.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("3");
        jLabel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel379.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel379.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel379.setText("‎ ");
        jLabel379.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE04_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        GE04_TFG.setForeground(new java.awt.Color(204, 0, 0));
        GE04_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE04_TFG.setText("‎ ");
        GE04_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel316.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel316.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel316.setText("3");
        jLabel316.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel283.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel283.setText("Tech 1L");
        jLabel283.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel359.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel359.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel359.setText("6");
        jLabel359.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel259.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        jLabel259.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel259.setText("FIRST SEMESTER                                                                                                        THIRD YEAR                                                                                                SECOND SEMESTER");
        jLabel259.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel279.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel279.setText("Rizal");
        jLabel279.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel81.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel81.setText("REED 2");
        jLabel81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE03_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        GE03_TFG.setForeground(new java.awt.Color(204, 0, 0));
        GE03_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE03_TFG.setText("‎ ");
        GE03_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel376.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel376.setForeground(new java.awt.Color(204, 0, 0));
        jLabel376.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel376.setText("‎ ");
        jLabel376.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE07_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        GE07_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE07_FG.setText("‎ ");
        GE07_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel137.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel137.setText("NET 102");
        jLabel137.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel330.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel330.setText("‎ ");
        jLabel330.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel211.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel211.setText("ITCC 104");
        jLabel211.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel245.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel245.setText("‎ ");
        jLabel245.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        HCI102_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        HCI102_TFG.setForeground(new java.awt.Color(204, 0, 0));
        HCI102_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HCI102_TFG.setText("‎ ");
        HCI102_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel122.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel122.setText("GE 05");
        jLabel122.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel289.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel289.setText("Digital Electronics");
        jLabel289.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel321.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel321.setText("IAS 102");
        jLabel321.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel328.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel328.setText("‎ ");
        jLabel328.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel264.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel264.setText("Systems Integration and Architecture 1");
        jLabel264.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel200.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel200.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel200.setText("3");
        jLabel200.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel329.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel329.setText("‎ ");
        jLabel329.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel353.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel353.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel353.setText("Senior");
        jLabel353.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ITCC105_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ITCC105_TFG.setForeground(new java.awt.Color(204, 0, 0));
        ITCC105_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITCC105_TFG.setText("‎ ");
        ITCC105_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel60.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("3");
        jLabel60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel261.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel261.setText("Environmental Science");
        jLabel261.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel124.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel124.setText("‎ ");
        jLabel124.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel336.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel336.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel336.setText("‎ ");
        jLabel336.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE09_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        GE09_TFG.setForeground(new java.awt.Color(204, 0, 0));
        GE09_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE09_TFG.setText("‎ ");
        GE09_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel375.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel375.setForeground(new java.awt.Color(204, 0, 0));
        jLabel375.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel375.setText("‎ ");
        jLabel375.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel118.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel118.setText("‎ ");
        jLabel118.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel339.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel339.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel339.setText("‎ ");
        jLabel339.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel88.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("PREQ");
        jLabel88.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel121.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel121.setText("Understanding the Self");
        jLabel121.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel251.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel251.setForeground(new java.awt.Color(204, 0, 0));
        jLabel251.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel251.setText("‎ ");
        jLabel251.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel172.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel172.setText("LIT");
        jLabel172.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel136.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel136.setText("REED 3");
        jLabel136.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel105.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel105.setText("ITCC 102");
        jLabel105.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel257.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel257.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel257.setText("‎ ");
        jLabel257.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel273.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel273.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel273.setText("3");
        jLabel273.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        IPT101_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        IPT101_TFG.setForeground(new java.awt.Color(204, 0, 0));
        IPT101_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IPT101_TFG.setText("‎ ");
        IPT101_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel78.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel78.setText("GE 07");
        jLabel78.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        IAS101_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        IAS101_TFG.setForeground(new java.awt.Color(204, 0, 0));
        IAS101_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IAS101_TFG.setText("‎ ");
        IAS101_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel231.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel231.setText("NET 101");
        jLabel231.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel198.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel198.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel198.setText("3");
        jLabel198.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel138.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel138.setText("Application Development and Emerging Technologies");
        jLabel138.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel75.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel75.setText("The Contemporary World");
        jLabel75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel82.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("‎ ");
        jLabel82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel209.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel209.setText("NSTP 1/CWTS 1 ");
        jLabel209.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel241.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel241.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel241.setText("PF 101");
        jLabel241.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel101.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setText("3");
        jLabel101.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel284.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel284.setText("GE 12");
        jLabel284.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel319.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        jLabel319.setText("                                                                 SUMMER");
        jLabel319.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel248.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel248.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel248.setText("‎ ");
        jLabel248.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ITCC105_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        ITCC105_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITCC105_FG.setText("‎ ");
        ITCC105_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel341.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel341.setText("ITCAP 102");
        jLabel341.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel144.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel144.setText("God's People: A Community of Believers");
        jLabel144.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SP101_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        SP101_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SP101_FG.setText("‎ ");
        SP101_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel212.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel212.setText("Information Management 1");
        jLabel212.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel300.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel300.setForeground(new java.awt.Color(204, 0, 0));
        jLabel300.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel300.setText("‎ ");
        jLabel300.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel320.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel320.setText("ITCAP 101");
        jLabel320.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel282.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel282.setText("Tech 1");
        jLabel282.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelCourse1.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabelCourse1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCourse1.setText("DIVINE WORD COLLEGE OF BANGUED");

        jLabel49.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel49.setText("ITCC 100");
        jLabel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        LIT_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        LIT_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LIT_FG.setText("‎ ");
        LIT_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ITCC104_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        ITCC104_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITCC104_FG.setText("‎ ");
        ITCC104_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        HCI102_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        HCI102_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HCI102_FG.setText("‎ ");
        HCI102_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DID101_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        DID101_TFG.setForeground(new java.awt.Color(204, 0, 0));
        DID101_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DID101_TFG.setText("‎ ");
        DID101_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel324.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel324.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel324.setText("Senior");
        jLabel324.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        RIZAL_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        RIZAL_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RIZAL_FG.setText("‎ ");
        RIZAL_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel185.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel185.setText("MS 102");
        jLabel185.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SIA102_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        SIA102_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SIA102_FG.setText("‎ ");
        SIA102_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel125.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel125.setText("GE 10");
        jLabel125.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel179.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel179.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel179.setText("3");
        jLabel179.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE08_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        GE08_TFG.setForeground(new java.awt.Color(204, 0, 0));
        GE08_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE08_TFG.setText("‎ ");
        GE08_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel115.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel115.setText("DESCRIPTIVE TITLE");
        jLabel115.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel367.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel367.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel367.setText("3");
        jLabel367.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel38.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel38.setText("GE 03");
        jLabel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel169.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel169.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel169.setText("HCI 101");
        jLabel169.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel134.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel134.setText("Art Appreciation");
        jLabel134.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel112.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel112.setText("2");
        jLabel112.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel191.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel191.setText("Platform Technologies");
        jLabel191.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel372.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel372.setText("‎ ");
        jLabel372.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        NET101_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        NET101_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NET101_FG.setText("‎ ");
        NET101_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel204.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel204.setText("Quantitative Methods");
        jLabel204.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel66.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("‎ ");
        jLabel66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel348.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel348.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel348.setText("3");
        jLabel348.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel171.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel171.setText("Human Computer Interaction 2");
        jLabel171.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel287.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel287.setText("Living in the IT Era (Informatics)");
        jLabel287.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel41.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("‎ ");
        jLabel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel325.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel325.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel325.setText("IAS 101");
        jLabel325.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ITCC102_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ITCC102_TFG.setForeground(new java.awt.Color(204, 0, 0));
        ITCC102_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITCC102_TFG.setText("‎ ");
        ITCC102_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel207.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel207.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel207.setText("3");
        jLabel207.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel135.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel135.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel135.setText("‎ ");
        jLabel135.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SP101_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SP101_TFG.setForeground(new java.awt.Color(204, 0, 0));
        SP101_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SP101_TFG.setText("‎ ");
        SP101_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PE1_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        PE1_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PE1_FG.setText("‎ ");
        PE1_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel315.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel315.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel315.setText("3");
        jLabel315.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel347.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel347.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel347.setText("3");
        jLabel347.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        MS101_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        MS101_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MS101_FG.setText("‎ ");
        MS101_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel140.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel140.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel140.setText("ITCC 104");
        jLabel140.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel23.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel23.setText("Man: In Search of God");
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ITCC102_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        ITCC102_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITCC102_FG.setText("‎ ");
        ITCC102_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel147.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel147.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel147.setText("3");
        jLabel147.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel63.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel63.setText("Wellness and Fitness");
        jLabel63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel370.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel370.setText("‎ ");
        jLabel370.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel54.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("3");
        jLabel54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel20.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("3");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE06_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        GE06_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE06_FG.setText("‎ ");
        GE06_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel326.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel326.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel326.setText("3");
        jLabel326.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel332.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel332.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel332.setText("‎ ");
        jLabel332.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel262.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel262.setText("Social and Professional Issues");
        jLabel262.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE10_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        GE10_TFG.setForeground(new java.awt.Color(204, 0, 0));
        GE10_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE10_TFG.setText("‎ ");
        GE10_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DTP101_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        DTP101_TFG.setForeground(new java.awt.Color(204, 0, 0));
        DTP101_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DTP101_TFG.setText("‎ ");
        DTP101_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        FIL2_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        FIL2_TFG.setForeground(new java.awt.Color(204, 0, 0));
        FIL2_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FIL2_TFG.setText("‎ ");
        FIL2_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE11_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        GE11_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE11_FG.setText("‎ ");
        GE11_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel234.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel234.setText("GE 08");
        jLabel234.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel96.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("ITCC 100");
        jLabel96.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel342.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel342.setText("SA 101");
        jLabel342.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel236.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel236.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel236.setText("ITCC 103 ");
        jLabel236.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel132.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel132.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel132.setText("‎ ");
        jLabel132.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PE3_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        PE3_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PE3_FG.setText("‎ ");
        PE3_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE09_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        GE09_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE09_FG.setText("‎ ");
        GE09_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel364.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel364.setText("Integrative Programming and Technologies 2");
        jLabel364.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel25.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel25.setText("GE 01");
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel230.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel230.setText("Networking 1");
        jLabel230.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        REED1_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        REED1_TFG.setForeground(new java.awt.Color(204, 0, 0));
        REED1_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        REED1_TFG.setText("‎ ");
        REED1_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel208.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel208.setText("‎ ");
        jLabel208.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel166.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel166.setText("SP 101");
        jLabel166.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel24.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel24.setText("REED 1");
        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel363.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel363.setText("Web Development");
        jLabel363.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel265.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel265.setText("Networking 2");
        jLabel265.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel214.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel214.setText("Values Integration and Promotion ");
        jLabel214.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel292.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel292.setText("The Life and Works of Jose Rizal");
        jLabel292.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DTP101_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        DTP101_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DTP101_FG.setText("‎ ");
        DTP101_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ITCAP101_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ITCAP101_TFG.setForeground(new java.awt.Color(204, 0, 0));
        ITCAP101_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITCAP101_TFG.setText("‎ ");
        ITCAP101_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel356.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel356.setForeground(new java.awt.Color(204, 0, 0));
        jLabel356.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel356.setText("‎ ");
        jLabel356.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ITCC100_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        ITCC100_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITCC100_FG.setText("‎ ");
        ITCC100_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel255.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel255.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel255.setText("‎ ");
        jLabel255.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("‎ ");
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel294.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel294.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel294.setText("PF 101");
        jLabel294.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel187.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel187.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel187.setText("3");
        jLabel187.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel194.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel194.setText("Christian Living");
        jLabel194.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        NSTP1_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        NSTP1_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NSTP1_FG.setText("‎ ");
        NSTP1_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel227.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel227.setText("PE 4");
        jLabel227.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel311.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel311.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel311.setText("‎ ");
        jLabel311.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        IPT102_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        IPT102_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IPT102_FG.setText("‎ ");
        IPT102_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel165.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel165.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel165.setText("3");
        jLabel165.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PE3_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        PE3_TFG.setForeground(new java.awt.Color(204, 0, 0));
        PE3_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PE3_TFG.setText("‎ ");
        PE3_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel61.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel61.setText("PE 1");
        jLabel61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel250.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel250.setForeground(new java.awt.Color(204, 0, 0));
        jLabel250.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel250.setText("‎ ");
        jLabel250.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel225.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel225.setText("‎ ");
        jLabel225.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        IPT101_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        IPT101_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IPT101_FG.setText("‎ ");
        IPT101_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel176.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel176.setText("FIL 2");
        jLabel176.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel340.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        jLabel340.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel340.setText("FIRST SEMESTER                                                                                                        FOURTH YEAR                                                                                                SECOND SEMESTER");
        jLabel340.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        REED4_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        REED4_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        REED4_FG.setText("‎ ");
        REED4_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel215.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel215.setText("‎ ");
        jLabel215.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel285.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel285.setText("‎ ");
        jLabel285.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel256.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel256.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel256.setText("‎ ");
        jLabel256.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel275.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel275.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel275.setText("3");
        jLabel275.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        IAS102_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        IAS102_TFG.setForeground(new java.awt.Color(204, 0, 0));
        IAS102_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IAS102_TFG.setText("‎ ");
        IAS102_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel244.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        jLabel244.setText("                                                                 SUMMER");
        jLabel244.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE01_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        GE01_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE01_FG.setText("‎ ");
        GE01_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel274.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel274.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel274.setText("3");
        jLabel274.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel377.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel377.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel377.setText("‎ ");
        jLabel377.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel167.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel167.setText("GE 11");
        jLabel167.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel62.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel62.setText("GE 09");
        jLabel62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel133.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        jLabel133.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel133.setText("FIRST SEMESTER                                                                                                     FIRST YEAR                                                                                                SECOND SEMESTER");
        jLabel133.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SA101_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SA101_TFG.setForeground(new java.awt.Color(204, 0, 0));
        SA101_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SA101_TFG.setText("‎ ");
        SA101_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel298.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel298.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel298.setText("‎ ");
        jLabel298.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel317.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel317.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel317.setText("3");
        jLabel317.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel249.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel249.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel249.setText("‎ ");
        jLabel249.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel344.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel344.setText("System Administration and Maintenance");
        jLabel344.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel64.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel64.setText("Gender and Society");
        jLabel64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ITCC103_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ITCC103_TFG.setForeground(new java.awt.Color(204, 0, 0));
        ITCC103_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITCC103_TFG.setText("‎ ");
        ITCC103_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel120.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel120.setText("‎ ");
        jLabel120.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel85.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("‎ ");
        jLabel85.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE02_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        GE02_TFG.setForeground(new java.awt.Color(204, 0, 0));
        GE02_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE02_TFG.setText("‎ ");
        GE02_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PF101_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        PF101_TFG.setForeground(new java.awt.Color(204, 0, 0));
        PF101_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PF101_TFG.setText("‎ ");
        PF101_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel48.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("3");
        jLabel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        NSTP2_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        NSTP2_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NSTP2_FG.setText("‎ ");
        NSTP2_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel95.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("3");
        jLabel95.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel56.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel56.setText("Digital Image Design and Manipulation");
        jLabel56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel350.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel350.setText("‎ ");
        jLabel350.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PT101_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        PT101_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PT101_FG.setText("‎ ");
        PT101_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel242.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel242.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel242.setText("3");
        jLabel242.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        HCI101_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        HCI101_TFG.setForeground(new java.awt.Color(204, 0, 0));
        HCI101_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HCI101_TFG.setText("‎ ");
        HCI101_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel297.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel297.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel297.setText("‎ ");
        jLabel297.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        REED3_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        REED3_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        REED3_FG.setText("‎ ");
        REED3_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel91.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("REED 1");
        jLabel91.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel50.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel50.setText("Introduction to Computing");
        jLabel50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        IM102_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        IM102_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IM102_FG.setText("‎ ");
        IM102_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel30.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("3");
        jLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel318.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel318.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel318.setText("3");
        jLabel318.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel335.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel335.setForeground(new java.awt.Color(204, 0, 0));
        jLabel335.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel335.setText("‎ ");
        jLabel335.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE11_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        GE11_TFG.setForeground(new java.awt.Color(204, 0, 0));
        GE11_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE11_TFG.setText("‎ ");
        GE11_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel354.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel354.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel354.setText("‎ ");
        jLabel354.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel278.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel278.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel278.setText("3");
        jLabel278.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE03_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        GE03_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE03_FG.setText("‎ ");
        GE03_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel143.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel143.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel143.setText("REED 2 ");
        jLabel143.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        NET102_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        NET102_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NET102_FG.setText("‎ ");
        NET102_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel119.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel119.setText("‎ ");
        jLabel119.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel45.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("‎ ");
        jLabel45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        WS101_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        WS101_TFG.setForeground(new java.awt.Color(204, 0, 0));
        WS101_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WS101_TFG.setText("‎ ");
        WS101_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel293.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel293.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel293.setText("‎ ");
        jLabel293.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel160.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel160.setText("IAS 101");
        jLabel160.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel291.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel291.setText("Web Systems and Technologies");
        jLabel291.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel314.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel314.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel314.setText("1");
        jLabel314.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel79.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("3");
        jLabel79.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel203.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel203.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel203.setText("PE 1");
        jLabel203.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel380.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel380.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel380.setText("‎ ");
        jLabel380.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel110.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel110.setText("Introduction to Computing");
        jLabel110.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        IAS102_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        IAS102_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IAS102_FG.setText("‎ ");
        IAS102_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel106.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel106.setText("3");
        jLabel106.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel192.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel192.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel192.setText("‎ ");
        jLabel192.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel219.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel219.setText("‎ ");
        jLabel219.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        REED2_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        REED2_TFG.setForeground(new java.awt.Color(204, 0, 0));
        REED2_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        REED2_TFG.setText("‎ ");
        REED2_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        WD101_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        WD101_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WD101_FG.setText("‎ ");
        WD101_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel92.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel92.setText("Readings in Philippine History");
        jLabel92.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel83.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("3");
        jLabel83.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("COURSE CODE");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel224.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel224.setText("IPT 101");
        jLabel224.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SIA101_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SIA101_TFG.setForeground(new java.awt.Color(204, 0, 0));
        SIA101_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SIA101_TFG.setText("‎ ");
        SIA101_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel202.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel202.setText("Outdoor and Adventure Activities ");
        jLabel202.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel148.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel148.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel148.setText("‎ ");
        jLabel148.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel190.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel190.setText("PT 101");
        jLabel190.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel280.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel280.setText("WS 101");
        jLabel280.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel272.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel272.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel272.setText("‎ ");
        jLabel272.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        FIL2_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        FIL2_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FIL2_FG.setText("‎ ");
        FIL2_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel43.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel43.setText("ITCC 101");
        jLabel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel99.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel99.setText("HCI 101");
        jLabel99.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PE4_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        PE4_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PE4_FG.setText("‎ ");
        PE4_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel266.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel266.setText("Advanced Database Systems");
        jLabel266.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        NET101_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        NET101_TFG.setForeground(new java.awt.Color(204, 0, 0));
        NET101_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NET101_TFG.setText("‎ ");
        NET101_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel218.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel218.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel218.setText("‎ ");
        jLabel218.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel33.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("‎ ");
        jLabel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel126.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel126.setText("3");
        jLabel126.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel269.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel269.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel269.setText("ITCC 105");
        jLabel269.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel373.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel373.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel373.setText("‎ ");
        jLabel373.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE07_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        GE07_TFG.setForeground(new java.awt.Color(204, 0, 0));
        GE07_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE07_TFG.setText("‎ ");
        GE07_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel32.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel32.setText("Readings in Philippine History");
        jLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel164.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel164.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel164.setText("2");
        jLabel164.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PE1_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        PE1_TFG.setForeground(new java.awt.Color(204, 0, 0));
        PE1_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PE1_TFG.setText("‎ ");
        PE1_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel161.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel161.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel161.setText("MS 101");
        jLabel161.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ITCAP102_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ITCAP102_TFG.setForeground(new java.awt.Color(204, 0, 0));
        ITCAP102_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITCAP102_TFG.setText("‎ ");
        ITCAP102_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel233.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel233.setText("Ethics");
        jLabel233.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel170.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel170.setText("World Literature");
        jLabel170.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel313.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel313.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel313.setText("3");
        jLabel313.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE12_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        GE12_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE12_FG.setText("‎ ");
        GE12_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel111.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel111.setText("MS 101");
        jLabel111.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel296.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel296.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel296.setText("‎ ");
        jLabel296.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        REED1_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        REED1_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        REED1_FG.setText("‎ ");
        REED1_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE01_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        GE01_TFG.setForeground(new java.awt.Color(204, 0, 0));
        GE01_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE01_TFG.setText("‎ ");
        GE01_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        IPT102_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        IPT102_TFG.setForeground(new java.awt.Color(204, 0, 0));
        IPT102_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IPT102_TFG.setText("‎ ");
        IPT102_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel150.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel150.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel150.setText("NSTP 1");
        jLabel150.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("3");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        MS102_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        MS102_TFG.setForeground(new java.awt.Color(204, 0, 0));
        MS102_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MS102_TFG.setText("‎ ");
        MS102_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel361.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel361.setText("WD 101");
        jLabel361.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SIA102_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        SIA102_TFG.setForeground(new java.awt.Color(204, 0, 0));
        SIA102_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SIA102_TFG.setText("‎ ");
        SIA102_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel154.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel154.setText("SIA 101");
        jLabel154.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel103.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel103.setText("PE 2");
        jLabel103.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel205.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel205.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel205.setText("MS 101");
        jLabel205.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel183.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel183.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel183.setText("3");
        jLabel183.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel253.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel253.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel253.setText("‎ ");
        jLabel253.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel365.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel365.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel365.setText("WS 101");
        jLabel365.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        IAS101_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        IAS101_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IAS101_FG.setText("‎ ");
        IAS101_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel247.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel247.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel247.setText("‎ ");
        jLabel247.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel229.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel229.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel229.setText("3");
        jLabel229.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel349.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel349.setText("ITPRAC 101");
        jLabel349.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel258.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel258.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel258.setText("‎ ");
        jLabel258.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel163.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel163.setText("ITCC 103");
        jLabel163.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel327.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel327.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel327.setText("3");
        jLabel327.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel286.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel286.setText("‎ ");
        jLabel286.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel182.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel182.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel182.setText("‎ ");
        jLabel182.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel381.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        jLabel381.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel381.setText("TOTAL UNITS REQUIRED                         171               ");
        jLabel381.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel369.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel369.setText("‎ ");
        jLabel369.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel290.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel290.setText("Systems Integration and Architecture");
        jLabel290.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel351.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel351.setText("IT Practicum (486 hours)");
        jLabel351.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        MS101_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        MS101_TFG.setForeground(new java.awt.Color(204, 0, 0));
        MS101_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MS101_TFG.setText("‎ ");
        MS101_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel345.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel345.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel345.setText("ITCAP 101");
        jLabel345.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel55.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel55.setText("DID 101");
        jLabel55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel267.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel267.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel267.setText("IPT 101");
        jLabel267.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SIA101_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        SIA101_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SIA101_FG.setText("‎ ");
        SIA101_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel295.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel295.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel295.setText("SIA 101");
        jLabel295.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE04_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        GE04_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE04_FG.setText("‎ ");
        GE04_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel337.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel337.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel337.setText("‎ ");
        jLabel337.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GE05_FG.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        GE05_FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GE05_FG.setText("‎ ");
        GE05_FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TECH1L_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        TECH1L_TFG.setForeground(new java.awt.Color(204, 0, 0));
        TECH1L_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TECH1L_TFG.setText("‎ ");
        TECH1L_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel168.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel168.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel168.setText("‎ ");
        jLabel168.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel104.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel104.setText("Programming 2");
        jLabel104.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel196.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel196.setText("REED 4");
        jLabel196.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel216.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel216.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel216.setText("‎ ");
        jLabel216.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel189.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel189.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel189.setText("2");
        jLabel189.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TECH1_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        TECH1_TFG.setForeground(new java.awt.Color(204, 0, 0));
        TECH1_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TECH1_TFG.setText("‎ ");
        TECH1_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel65.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("‎ ");
        jLabel65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel153.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel153.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel153.setText("3");
        jLabel153.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel358.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel358.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel358.setText("‎ ");
        jLabel358.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel93.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("PE 1");
        jLabel93.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel333.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel333.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel333.setText("‎ ");
        jLabel333.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel151.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel151.setText("DTP 101");
        jLabel151.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel281.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel281.setText("SIA 102");
        jLabel281.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel87.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel87.setText("ITCC 105");
        jLabel87.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        FIL1_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        FIL1_TFG.setForeground(new java.awt.Color(204, 0, 0));
        FIL1_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FIL1_TFG.setText("‎ ");
        FIL1_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel268.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel268.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel268.setText("NET 101");
        jLabel268.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ITCC104_TFG.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ITCC104_TFG.setForeground(new java.awt.Color(204, 0, 0));
        ITCC104_TFG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITCC104_TFG.setText("‎ ");
        ITCC104_TFG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel378.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel378.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel378.setText("‎ ");
        jLabel378.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel271.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel271.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel271.setText("‎ ");
        jLabel271.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel27.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("‎ ");
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel252.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel252.setForeground(new java.awt.Color(204, 0, 0));
        jLabel252.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel252.setText("‎ ");
        jLabel252.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel334.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel334.setForeground(new java.awt.Color(204, 0, 0));
        jLabel334.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel334.setText("‎ ");
        jLabel334.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel254.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel254.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel254.setText("‎ ");
        jLabel254.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel210.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel210.setText("Science, Technology, and Society");
        jLabel210.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel156.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel156.setText("Object-Oriented Programming");
        jLabel156.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel362.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel362.setText("IPT 102");
        jLabel362.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("PREQ");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel86.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("TENTATIVE");
        jLabel86.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel270.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel270.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel270.setText("IPT 101");
        jLabel270.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel263.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel263.setText("Information Assurance and Security 1");
        jLabel263.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel235.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        jLabel235.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel235.setText("FIRST SEMESTER                                                                                                     SECOND YEAR                                                                                                SECOND SEMESTER");
        jLabel235.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel246.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel246.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel246.setText("‎ ");
        jLabel246.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel155.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel155.setText("PE 3");
        jLabel155.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel152.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel152.setText("Desktop Publishing");
        jLabel152.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel299.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel299.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel299.setText("‎ ");
        jLabel299.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel157.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel157.setText("PF 101");
        jLabel157.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel177.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel177.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel177.setText("ITCC 102");
        jLabel177.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel36.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("3");
        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        IDNO.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        IDNO.setText("ID NUMBER: ");

        NME.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        NME.setText("NAME:");

        COUR.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        COUR.setText("COURSE: ");

        jLabelCourse2.setFont(new java.awt.Font("Poppins", 2, 14)); // NOI18N
        jLabelCourse2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCourse2.setText("BACHELOR OF SCIENCE IN INFORMATION TECHNOLOGY");

        jLabelCourse3.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabelCourse3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCourse3.setText("Evaluation Form");

        jLabel2.setIcon(new FlatSVGIcon("icons/dwcb_logo.svg"));

        jLabel3.setIcon(new FlatSVGIcon("icons/dwcb_logo.svg"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel381, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel340, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel235, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel137)
                                        .addComponent(jLabel154)
                                        .addComponent(jLabel167)
                                        .addComponent(jLabel160)
                                        .addComponent(jLabel166)
                                        .addComponent(jLabel260))
                                    .addGap(0, 0, 0)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel265)
                                        .addComponent(jLabel261)
                                        .addComponent(jLabel264)
                                        .addComponent(jLabel263)
                                        .addComponent(jLabel262)
                                        .addComponent(jLabel266))
                                    .addGap(0, 0, 0)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel268)
                                        .addComponent(jLabel272)
                                        .addComponent(jLabel269)
                                        .addComponent(jLabel271)
                                        .addComponent(jLabel270)
                                        .addComponent(jLabel267))
                                    .addGap(0, 0, 0)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(NET102_TFG)
                                        .addComponent(ITCC105_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SIA101_TFG)
                                        .addComponent(SP101_TFG)
                                        .addComponent(GE11_TFG)
                                        .addComponent(IAS101_TFG)
                                        .addComponent(IM102_TFG))
                                    .addGap(0, 0, 0)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ITCC105_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SIA101_FG)
                                        .addComponent(NET102_FG)
                                        .addComponent(SP101_FG)
                                        .addComponent(GE11_FG)
                                        .addComponent(IAS101_FG)
                                        .addComponent(IM102_FG))
                                    .addGap(0, 0, 0)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel278)
                                        .addComponent(jLabel276)
                                        .addComponent(jLabel277)
                                        .addComponent(jLabel274)
                                        .addComponent(jLabel273)
                                        .addComponent(jLabel275))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel281, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel284, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel279, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel280, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel283, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel285, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel282, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel287, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel292, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel286, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel290, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel291, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel288, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel289, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel293, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel298, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel299, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel295, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel294, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel296, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel297, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(RIZAL_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(GE12_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SIA102_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel300, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(WS101_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TECH1_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TECH1L_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(GE12_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(RIZAL_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel311, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TECH1L_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SIA102_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TECH1_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(WS101_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel313, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel318, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel312, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel317, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel314, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel316, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel315, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel259, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel244, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel159, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel176)
                                            .addComponent(jLabel175))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel180)
                                            .addComponent(jLabel181))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(FIL2_TFGFFFF)
                                            .addComponent(jLabel182))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(NSTP2_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(FIL1_TFG)
                                            .addComponent(FIL2_TFG))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(NSTP2_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(FIL2_FG)
                                            .addComponent(FIL1_FG))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel165, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel198)
                                            .addComponent(jLabel200))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel215, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel223, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel245, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel208, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel219, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel225, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel247, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel248, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel249, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel251, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel250, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel252, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel253, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel254, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel255, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel257, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel256, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel258, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel133, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel25)
                                            .addComponent(jLabel31)
                                            .addComponent(jLabel38)
                                            .addComponent(jLabel43)
                                            .addComponent(jLabel49)
                                            .addComponent(jLabel55)
                                            .addComponent(jLabel61)
                                            .addComponent(jLabel62)
                                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel136)
                                            .addComponent(jLabel151)
                                            .addComponent(jLabel155)
                                            .addComponent(jLabel157)
                                            .addComponent(jLabel163)
                                            .addComponent(jLabel172)
                                            .addComponent(jLabel173)
                                            .addComponent(jLabel234))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel23)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel32)
                                            .addComponent(jLabel37)
                                            .addComponent(jLabel44)
                                            .addComponent(jLabel50)
                                            .addComponent(jLabel56)
                                            .addComponent(jLabel63)
                                            .addComponent(jLabel64)
                                            .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel144)
                                            .addComponent(jLabel146)
                                            .addComponent(jLabel152)
                                            .addComponent(jLabel156)
                                            .addComponent(jLabel162)
                                            .addComponent(jLabel170)
                                            .addComponent(jLabel171)
                                            .addComponent(jLabel233))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel22)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel33)
                                            .addComponent(jLabel41)
                                            .addComponent(jLabel45)
                                            .addComponent(jLabel51)
                                            .addComponent(jLabel57)
                                            .addComponent(jLabel65)
                                            .addComponent(jLabel66)
                                            .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel143)
                                            .addComponent(jLabel145)
                                            .addComponent(jLabel148)
                                            .addComponent(jLabel161)
                                            .addComponent(jLabel168)
                                            .addComponent(jLabel169)
                                            .addComponent(jLabel177)
                                            .addComponent(jLabel246))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(REED1_TFG)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(GE01_TFG)
                                            .addComponent(GE02_TFG)
                                            .addComponent(GE03_TFG)
                                            .addComponent(ITCC101_TFG)
                                            .addComponent(ITCC100_TFG)
                                            .addComponent(DID101_TFG)
                                            .addComponent(PE1_TFG)
                                            .addComponent(GE09_TFG)
                                            .addComponent(REED3_TFG)
                                            .addComponent(GE07_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(DTP101_TFG)
                                            .addComponent(ITCC103_TFG)
                                            .addComponent(PE3_TFG)
                                            .addComponent(HCI102_TFG)
                                            .addComponent(PF101_TFG)
                                            .addComponent(LIT_TFG)
                                            .addComponent(GE08_TFG))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(REED1_FG)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(GE01_FG)
                                            .addComponent(GE02_FG)
                                            .addComponent(GE03_FG)
                                            .addComponent(ITCC101_FG)
                                            .addComponent(ITCC100_FG)
                                            .addComponent(DID101_FG)
                                            .addComponent(PE1_FG)
                                            .addComponent(GE09_FG)
                                            .addComponent(GE07_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(DTP101_FG)
                                            .addComponent(REED3_FG)
                                            .addComponent(ITCC103_FG)
                                            .addComponent(PE3_FG)
                                            .addComponent(PF101_FG)
                                            .addComponent(LIT_FG)
                                            .addComponent(HCI102_FG)
                                            .addComponent(GE08_FG))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel30)
                                            .addComponent(jLabel36)
                                            .addComponent(jLabel42)
                                            .addComponent(jLabel48)
                                            .addComponent(jLabel54)
                                            .addComponent(jLabel60)
                                            .addComponent(jLabel71)
                                            .addComponent(jLabel72)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel141)
                                            .addComponent(jLabel147)
                                            .addComponent(jLabel153)
                                            .addComponent(jLabel158)
                                            .addComponent(jLabel164)
                                            .addComponent(jLabel174)
                                            .addComponent(jLabel178)
                                            .addComponent(jLabel179))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel74)
                                            .addComponent(jLabel81)
                                            .addComponent(jLabel99)
                                            .addComponent(jLabel103)
                                            .addComponent(jLabel105)
                                            .addComponent(jLabel111)
                                            .addComponent(jLabel117, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                            .addComponent(jLabel122)
                                            .addComponent(jLabel124)
                                            .addComponent(jLabel125)
                                            .addComponent(jLabel185, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel190, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel196, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel209, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel211, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel222, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel224, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel227, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel231, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel75)
                                            .addComponent(jLabel92)
                                            .addComponent(jLabel94)
                                            .addComponent(jLabel100)
                                            .addComponent(jLabel104)
                                            .addComponent(jLabel110)
                                            .addComponent(jLabel115, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                            .addComponent(jLabel120)
                                            .addComponent(jLabel121)
                                            .addComponent(jLabel123)
                                            .addComponent(jLabel191, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel194, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel202, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel204, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel210, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel212, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel214, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel226, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel230, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel76)
                                            .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                            .addComponent(jLabel91)
                                            .addComponent(jLabel93)
                                            .addComponent(jLabel96)
                                            .addComponent(jLabel109)
                                            .addComponent(jLabel118)
                                            .addComponent(jLabel119)
                                            .addComponent(jLabel129)
                                            .addComponent(jLabel132)
                                            .addComponent(jLabel192, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel193, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel203, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel205, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel216, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel218, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel236, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel240, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel241, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(REED2_TFG)
                                            .addComponent(GE04_TFG)
                                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel90)
                                            .addComponent(HCI101_TFG)
                                            .addComponent(MS101_TFG)
                                            .addComponent(PE2_TFG)
                                            .addComponent(GE10_TFG)
                                            .addComponent(ITCC102_TFG)
                                            .addComponent(GE05_TFG)
                                            .addComponent(REED4_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PT101_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(MS102_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(GE06_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PE4_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(NSTP1_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ITCC104_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(NET101_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(IPT101_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(GE04_FG)
                                            .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel85)
                                            .addComponent(GE10_FG)
                                            .addComponent(HCI101_FG)
                                            .addComponent(REED2_FG)
                                            .addComponent(MS101_FG)
                                            .addComponent(PE2_FG)
                                            .addComponent(ITCC102_FG)
                                            .addComponent(GE05_FG)
                                            .addComponent(PT101_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(REED4_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PE4_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(GE06_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(NSTP1_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(IPT101_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(MS102_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(NET101_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ITCC104_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel126, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel183, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel184, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel187, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel189, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel207, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel221, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel229, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel242, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel320, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel321))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel322, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel323))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel324, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel325))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ITCAP101_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(IAS102_TFG))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ITCAP101_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(IAS102_FG))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel326, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel327))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel329, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel328, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel330, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel331, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel332, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel333, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel335, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel334, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel336, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel337, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel339, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel338, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel341, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel342))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel343, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel344))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel345, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel346))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ITCAP102_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SA101_TFG))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ITCAP102_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SA101_FG))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel347, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel348))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel350, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel349, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel351, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel352, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel353, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel354, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel356, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ITPRAC101_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ITPRAC101_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel358, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel360, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel359, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel361, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel362))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel363, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel364))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel365, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel366))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(WD101_TFG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(IPT102_TFG))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(WD101_FG, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(IPT102_FG))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel367, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel368))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel370, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel369, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel371, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel372, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel373, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel374, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel376, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel375, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel377, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel378, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel380, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel379, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel319, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IDNO, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NME, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(COUR, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabelCourse1, javax.swing.GroupLayout.PREFERRED_SIZE, 1147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCourse2, javax.swing.GroupLayout.PREFERRED_SIZE, 1147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCourse3, javax.swing.GroupLayout.PREFERRED_SIZE, 1147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel13, jLabel136, jLabel137, jLabel151, jLabel154, jLabel155, jLabel157, jLabel159, jLabel160, jLabel163, jLabel166, jLabel167, jLabel172, jLabel173, jLabel175, jLabel176, jLabel234, jLabel24, jLabel25, jLabel260, jLabel31, jLabel320, jLabel321, jLabel341, jLabel342, jLabel361, jLabel362, jLabel38, jLabel43, jLabel49, jLabel55, jLabel61, jLabel62, jLabel78, jLabel87});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel134, jLabel138, jLabel14, jLabel144, jLabel146, jLabel149, jLabel152, jLabel156, jLabel162, jLabel170, jLabel171, jLabel180, jLabel181, jLabel23, jLabel233, jLabel26, jLabel261, jLabel262, jLabel263, jLabel264, jLabel265, jLabel266, jLabel32, jLabel322, jLabel323, jLabel343, jLabel344, jLabel363, jLabel364, jLabel37, jLabel44, jLabel50, jLabel56, jLabel63, jLabel64});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {DID101_TFG, DTP101_TFG, FIL1_TFG, FIL2_TFG, FIL2_TFGFFFF, GE01_TFG, GE02_TFG, GE03_TFG, GE07_TFG, GE08_TFG, GE09_TFG, GE11_TFG, HCI102_TFG, IAS101_TFG, IAS102_TFG, IM102_TFG, IPT102_TFG, ITCAP101_TFG, ITCAP102_TFG, ITCC100_TFG, ITCC101_TFG, ITCC103_TFG, ITCC105_TFG, LIT_TFG, NET102_TFG, NSTP2_TFG, PE1_TFG, PE3_TFG, PF101_TFG, REED1_TFG, REED3_TFG, SA101_TFG, SIA101_TFG, SP101_TFG, WD101_TFG, jLabel135, jLabel140, jLabel143, jLabel145, jLabel148, jLabel15, jLabel150, jLabel16, jLabel161, jLabel168, jLabel169, jLabel177, jLabel182, jLabel22, jLabel246, jLabel267, jLabel268, jLabel269, jLabel27, jLabel270, jLabel271, jLabel272, jLabel324, jLabel325, jLabel33, jLabel345, jLabel346, jLabel365, jLabel366, jLabel41, jLabel45, jLabel51, jLabel57, jLabel65, jLabel66});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {DID101_FG, DTP101_FG, FIL1_FG, FIL2_FG, GE01_FG, GE02_FG, GE03_FG, GE07_FG, GE08_FG, GE09_FG, GE11_FG, HCI102_FG, IAS101_FG, IAS102_FG, IM102_FG, IPT102_FG, ITCAP101_FG, ITCAP102_FG, ITCC100_FG, ITCC101_FG, ITCC103_FG, ITCC105_FG, LIT_FG, NET102_FG, NSTP2_FG, PE1_FG, PE3_FG, PF101_FG, REED1_FG, REED3_FG, SA101_FG, SIA101_FG, SP101_FG, WD101_FG, jLabel17});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel141, jLabel147, jLabel153, jLabel158, jLabel164, jLabel165, jLabel174, jLabel178, jLabel179, jLabel18, jLabel19, jLabel198, jLabel20, jLabel200, jLabel21, jLabel273, jLabel274, jLabel275, jLabel276, jLabel277, jLabel278, jLabel30, jLabel326, jLabel327, jLabel347, jLabel348, jLabel36, jLabel367, jLabel368, jLabel42, jLabel48, jLabel54, jLabel60, jLabel71, jLabel72});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel103, jLabel105, jLabel111, jLabel117, jLabel122, jLabel124, jLabel125, jLabel74, jLabel81, jLabel99});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel100, jLabel104, jLabel110, jLabel115, jLabel120, jLabel121, jLabel123, jLabel75, jLabel92, jLabel94});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel109, jLabel118, jLabel119, jLabel129, jLabel132, jLabel76, jLabel88, jLabel91, jLabel93, jLabel96});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {GE04_TFG, GE05_TFG, GE10_TFG, HCI101_TFG, ITCC102_TFG, MS101_TFG, PE2_TFG, REED2_TFG, jLabel86, jLabel90});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {GE04_FG, GE05_FG, GE10_FG, HCI101_FG, ITCC102_FG, MS101_FG, PE2_FG, REED2_FG, jLabel84, jLabel85});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel101, jLabel106, jLabel112, jLabel126, jLabel79, jLabel80, jLabel82, jLabel83, jLabel89, jLabel95});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelCourse1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCourse2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCourse3))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel133)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel117)
                            .addComponent(jLabel115)
                            .addComponent(jLabel88)
                            .addComponent(jLabel86)
                            .addComponent(jLabel84)
                            .addComponent(jLabel80))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel74)
                            .addComponent(jLabel75)
                            .addComponent(jLabel76)
                            .addComponent(GE04_TFG)
                            .addComponent(GE04_FG)
                            .addComponent(jLabel79))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel122)
                            .addComponent(jLabel121)
                            .addComponent(jLabel132)
                            .addComponent(GE05_TFG)
                            .addComponent(GE05_FG)
                            .addComponent(jLabel89))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel81)
                            .addComponent(jLabel92)
                            .addComponent(jLabel91)
                            .addComponent(REED2_TFG)
                            .addComponent(REED2_FG)
                            .addComponent(jLabel101))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel99)
                            .addComponent(jLabel100)
                            .addComponent(jLabel96)
                            .addComponent(HCI101_TFG)
                            .addComponent(HCI101_FG)
                            .addComponent(jLabel95))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel105)
                            .addComponent(jLabel104)
                            .addComponent(jLabel129)
                            .addComponent(ITCC102_TFG)
                            .addComponent(ITCC102_FG)
                            .addComponent(jLabel126))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel111)
                            .addComponent(jLabel110)
                            .addComponent(jLabel109)
                            .addComponent(MS101_TFG)
                            .addComponent(MS101_FG)
                            .addComponent(jLabel106))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel103)
                            .addComponent(jLabel94)
                            .addComponent(jLabel93)
                            .addComponent(PE2_TFG)
                            .addComponent(PE2_FG)
                            .addComponent(jLabel112))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel125)
                            .addComponent(jLabel123)
                            .addComponent(jLabel119)
                            .addComponent(GE10_TFG)
                            .addComponent(GE10_FG)
                            .addComponent(jLabel83))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel124)
                            .addComponent(jLabel120)
                            .addComponent(jLabel118)
                            .addComponent(jLabel90)
                            .addComponent(jLabel85)
                            .addComponent(jLabel82)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22)
                            .addComponent(REED1_TFG)
                            .addComponent(REED1_FG)
                            .addComponent(jLabel19))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(GE01_TFG)
                            .addComponent(GE01_FG)
                            .addComponent(jLabel30))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33)
                            .addComponent(GE02_TFG)
                            .addComponent(GE02_FG)
                            .addComponent(jLabel36))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37)
                            .addComponent(jLabel41)
                            .addComponent(GE03_TFG)
                            .addComponent(GE03_FG)
                            .addComponent(jLabel42))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(jLabel56)
                            .addComponent(jLabel57)
                            .addComponent(DID101_TFG)
                            .addComponent(DID101_FG)
                            .addComponent(jLabel60))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51)
                            .addComponent(ITCC100_TFG)
                            .addComponent(ITCC100_FG)
                            .addComponent(jLabel54))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45)
                            .addComponent(ITCC101_TFG)
                            .addComponent(ITCC101_FG)
                            .addComponent(jLabel48))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61)
                            .addComponent(jLabel63)
                            .addComponent(jLabel65)
                            .addComponent(PE1_TFG)
                            .addComponent(PE1_FG)
                            .addComponent(jLabel71))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel62)
                            .addComponent(jLabel64)
                            .addComponent(jLabel66)
                            .addComponent(GE09_TFG)
                            .addComponent(GE09_FG)
                            .addComponent(jLabel72))))
                .addGap(0, 0, 0)
                .addComponent(jLabel235)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel196)
                            .addComponent(jLabel194)
                            .addComponent(jLabel192)
                            .addComponent(REED4_TFG)
                            .addComponent(REED4_FG)
                            .addComponent(jLabel187))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel211)
                            .addComponent(jLabel212)
                            .addComponent(jLabel236)
                            .addComponent(ITCC104_TFG)
                            .addComponent(ITCC104_FG)
                            .addComponent(jLabel207))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel185)
                            .addComponent(jLabel204)
                            .addComponent(jLabel205)
                            .addComponent(MS102_TFG)
                            .addComponent(MS102_FG)
                            .addComponent(jLabel229))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel231)
                            .addComponent(jLabel230)
                            .addComponent(jLabel240)
                            .addComponent(NET101_TFG)
                            .addComponent(NET101_FG)
                            .addComponent(jLabel242))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel224)
                            .addComponent(jLabel226)
                            .addComponent(jLabel241)
                            .addComponent(IPT101_TFG)
                            .addComponent(IPT101_FG)
                            .addComponent(jLabel221))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel190)
                            .addComponent(jLabel191)
                            .addComponent(jLabel193)
                            .addComponent(PT101_TFG)
                            .addComponent(PT101_FG)
                            .addComponent(jLabel142))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel227)
                            .addComponent(jLabel202)
                            .addComponent(jLabel203)
                            .addComponent(PE4_TFG)
                            .addComponent(PE4_FG)
                            .addComponent(jLabel189))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel222)
                            .addComponent(jLabel210)
                            .addComponent(jLabel216)
                            .addComponent(GE06_TFG)
                            .addComponent(GE06_FG)
                            .addComponent(jLabel183))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel209)
                            .addComponent(jLabel214)
                            .addComponent(jLabel218)
                            .addComponent(NSTP1_TFG)
                            .addComponent(NSTP1_FG)
                            .addComponent(jLabel184)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel78)
                            .addComponent(jLabel134)
                            .addComponent(jLabel135)
                            .addComponent(GE07_TFG)
                            .addComponent(GE07_FG)
                            .addComponent(jLabel20))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel234)
                            .addComponent(jLabel233)
                            .addComponent(jLabel246)
                            .addComponent(GE08_TFG)
                            .addComponent(GE08_FG)
                            .addComponent(jLabel141))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel136)
                            .addComponent(jLabel144)
                            .addComponent(jLabel143)
                            .addComponent(REED3_TFG)
                            .addComponent(REED3_FG)
                            .addComponent(jLabel153))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel151)
                            .addComponent(jLabel152)
                            .addComponent(jLabel148)
                            .addComponent(DTP101_TFG)
                            .addComponent(DTP101_FG)
                            .addComponent(jLabel147))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel157)
                            .addComponent(jLabel156)
                            .addComponent(jLabel177)
                            .addComponent(PF101_TFG)
                            .addComponent(PF101_FG)
                            .addComponent(jLabel174))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel163)
                            .addComponent(jLabel162)
                            .addComponent(jLabel161)
                            .addComponent(ITCC103_TFG)
                            .addComponent(ITCC103_FG)
                            .addComponent(jLabel158))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel155)
                            .addComponent(jLabel146)
                            .addComponent(jLabel145)
                            .addComponent(PE3_TFG)
                            .addComponent(PE3_FG)
                            .addComponent(jLabel164))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel173)
                            .addComponent(jLabel171)
                            .addComponent(jLabel169)
                            .addComponent(HCI102_TFG)
                            .addComponent(HCI102_FG)
                            .addComponent(jLabel179))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel172)
                            .addComponent(jLabel170)
                            .addComponent(jLabel168)
                            .addComponent(LIT_TFG)
                            .addComponent(LIT_FG)
                            .addComponent(jLabel178))))
                .addGap(0, 0, 0)
                .addComponent(jLabel244)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel245)
                            .addComponent(jLabel208)
                            .addComponent(jLabel247)
                            .addComponent(jLabel250)
                            .addComponent(jLabel253)
                            .addComponent(jLabel258))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel223)
                            .addComponent(jLabel219)
                            .addComponent(jLabel248)
                            .addComponent(jLabel251)
                            .addComponent(jLabel254)
                            .addComponent(jLabel257))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel215)
                            .addComponent(jLabel225)
                            .addComponent(jLabel249)
                            .addComponent(jLabel252)
                            .addComponent(jLabel255)
                            .addComponent(jLabel256)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel159)
                            .addComponent(jLabel149)
                            .addComponent(jLabel150)
                            .addComponent(NSTP2_TFG)
                            .addComponent(NSTP2_FG)
                            .addComponent(jLabel165))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel175)
                            .addComponent(jLabel181)
                            .addComponent(jLabel182)
                            .addComponent(FIL1_TFG)
                            .addComponent(FIL1_FG)
                            .addComponent(jLabel200))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel176)
                            .addComponent(jLabel180)
                            .addComponent(FIL2_TFGFFFF)
                            .addComponent(FIL2_TFG)
                            .addComponent(FIL2_FG)
                            .addComponent(jLabel198))))
                .addGap(0, 0, 0)
                .addComponent(jLabel259)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel279)
                            .addComponent(jLabel292)
                            .addComponent(jLabel293)
                            .addComponent(RIZAL_TFG)
                            .addComponent(RIZAL_FG)
                            .addComponent(jLabel318))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel280)
                            .addComponent(jLabel291)
                            .addComponent(jLabel294)
                            .addComponent(WS101_TFG)
                            .addComponent(WS101_FG)
                            .addComponent(jLabel317))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel281)
                            .addComponent(jLabel290)
                            .addComponent(jLabel295)
                            .addComponent(SIA102_TFG)
                            .addComponent(SIA102_FG)
                            .addComponent(jLabel316))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel282)
                            .addComponent(jLabel289)
                            .addComponent(jLabel296)
                            .addComponent(TECH1_TFG)
                            .addComponent(TECH1_FG)
                            .addComponent(jLabel315))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel283)
                            .addComponent(jLabel288)
                            .addComponent(jLabel297)
                            .addComponent(TECH1L_TFG)
                            .addComponent(TECH1L_FG)
                            .addComponent(jLabel314))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel284)
                            .addComponent(jLabel287)
                            .addComponent(jLabel298)
                            .addComponent(GE12_TFG)
                            .addComponent(GE12_FG)
                            .addComponent(jLabel313))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel285)
                            .addComponent(jLabel286)
                            .addComponent(jLabel299)
                            .addComponent(jLabel300)
                            .addComponent(jLabel311)
                            .addComponent(jLabel312)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel87)
                            .addComponent(jLabel138)
                            .addComponent(jLabel140)
                            .addComponent(ITCC105_TFG)
                            .addComponent(ITCC105_FG)
                            .addComponent(jLabel21))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel260)
                            .addComponent(jLabel266)
                            .addComponent(jLabel267)
                            .addComponent(IM102_TFG)
                            .addComponent(IM102_FG)
                            .addComponent(jLabel278))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel137)
                            .addComponent(jLabel265)
                            .addComponent(jLabel268)
                            .addComponent(NET102_TFG)
                            .addComponent(NET102_FG)
                            .addComponent(jLabel277))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel154)
                            .addComponent(jLabel264)
                            .addComponent(jLabel269)
                            .addComponent(SIA101_TFG)
                            .addComponent(SIA101_FG)
                            .addComponent(jLabel276))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel160)
                            .addComponent(jLabel263)
                            .addComponent(jLabel270)
                            .addComponent(IAS101_TFG)
                            .addComponent(IAS101_FG)
                            .addComponent(jLabel275))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel166)
                            .addComponent(jLabel262)
                            .addComponent(jLabel271)
                            .addComponent(SP101_TFG)
                            .addComponent(SP101_FG)
                            .addComponent(jLabel274))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel167)
                            .addComponent(jLabel261)
                            .addComponent(jLabel272)
                            .addComponent(GE11_TFG)
                            .addComponent(GE11_FG)
                            .addComponent(jLabel273))))
                .addGap(0, 0, 0)
                .addComponent(jLabel319)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel328)
                            .addComponent(jLabel330)
                            .addComponent(jLabel332)
                            .addComponent(jLabel334)
                            .addComponent(jLabel336)
                            .addComponent(jLabel338))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel329)
                            .addComponent(jLabel331)
                            .addComponent(jLabel333)
                            .addComponent(jLabel335)
                            .addComponent(jLabel337)
                            .addComponent(jLabel339)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel320)
                            .addComponent(jLabel322)
                            .addComponent(jLabel324)
                            .addComponent(ITCAP101_TFG)
                            .addComponent(ITCAP101_FG)
                            .addComponent(jLabel326))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel321)
                            .addComponent(jLabel323)
                            .addComponent(jLabel325)
                            .addComponent(IAS102_TFG)
                            .addComponent(IAS102_FG)
                            .addComponent(jLabel327))))
                .addGap(0, 0, 0)
                .addComponent(jLabel340)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel349)
                            .addComponent(jLabel351)
                            .addComponent(jLabel353)
                            .addComponent(ITPRAC101_TFG)
                            .addComponent(ITPRAC101_FG)
                            .addComponent(jLabel359))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel350)
                            .addComponent(jLabel352)
                            .addComponent(jLabel354)
                            .addComponent(jLabel356)
                            .addComponent(jLabel358)
                            .addComponent(jLabel360)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel341)
                            .addComponent(jLabel343)
                            .addComponent(jLabel345)
                            .addComponent(ITCAP102_TFG)
                            .addComponent(ITCAP102_FG)
                            .addComponent(jLabel347))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel342)
                            .addComponent(jLabel344)
                            .addComponent(jLabel346)
                            .addComponent(SA101_TFG)
                            .addComponent(SA101_FG)
                            .addComponent(jLabel348))))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel369)
                            .addComponent(jLabel371)
                            .addComponent(jLabel373)
                            .addComponent(jLabel375)
                            .addComponent(jLabel377)
                            .addComponent(jLabel379))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel370)
                            .addComponent(jLabel372)
                            .addComponent(jLabel374)
                            .addComponent(jLabel376)
                            .addComponent(jLabel378)
                            .addComponent(jLabel380)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel361)
                            .addComponent(jLabel363)
                            .addComponent(jLabel365)
                            .addComponent(WD101_TFG)
                            .addComponent(WD101_FG)
                            .addComponent(jLabel367))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel362)
                            .addComponent(jLabel364)
                            .addComponent(jLabel366)
                            .addComponent(IPT102_TFG)
                            .addComponent(IPT102_FG)
                            .addComponent(jLabel368))))
                .addGap(0, 0, 0)
                .addComponent(jLabel381)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(IDNO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NME)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(COUR))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        jButton1.setIcon(new FlatSVGIcon("icons/refresh.svg"));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton2.setIcon(new FlatSVGIcon("icons/print.svg"));
        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel67.setText("Enter ID Number:");

        ntxtfield6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ntxtfield6ActionPerformed(evt);
            }
        });
        ntxtfield6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ntxtfield6KeyReleased(evt);
            }
        });

        edit_sbj_btn8.setFont(new java.awt.Font("Poppins Light", 0, 10)); // NOI18N
        edit_sbj_btn8.setIcon(new FlatSVGIcon("icons/search_1.svg"));
        edit_sbj_btn8.setText("Search");
        edit_sbj_btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_sbj_btn8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ntxtfield6, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit_sbj_btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(855, 855, 855)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1387, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ntxtfield6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67))
                        .addComponent(edit_sbj_btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {edit_sbj_btn8, jLabel67, ntxtfield6});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:String studentId = jTextField1.getText();  loadEvaluationData(studentId);// Get the ID from the text field
        loadEvaluationData(this.textValue);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        printWithPreview(jPanel1);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void ntxtfield6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntxtfield6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ntxtfield6ActionPerformed

    private void ntxtfield6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ntxtfield6KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ntxtfield6KeyReleased

    private void edit_sbj_btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_sbj_btn8ActionPerformed
        // TODO add your handling code here:
        String studentId = ntxtfield6.getText();
        loadEvaluationData(studentId);

    }//GEN-LAST:event_edit_sbj_btn8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatLaf.registerCustomDefaultsSource("themes");
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IT_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel COUR;
    private javax.swing.JLabel DID101_FG;
    private javax.swing.JLabel DID101_TFG;
    private javax.swing.JLabel DTP101_FG;
    private javax.swing.JLabel DTP101_TFG;
    private javax.swing.JLabel FIL1_FG;
    private javax.swing.JLabel FIL1_TFG;
    private javax.swing.JLabel FIL2_FG;
    private javax.swing.JLabel FIL2_TFG;
    private javax.swing.JLabel FIL2_TFGFFFF;
    private javax.swing.JLabel GE01_FG;
    private javax.swing.JLabel GE01_TFG;
    private javax.swing.JLabel GE02_FG;
    private javax.swing.JLabel GE02_TFG;
    private javax.swing.JLabel GE03_FG;
    private javax.swing.JLabel GE03_TFG;
    private javax.swing.JLabel GE04_FG;
    private javax.swing.JLabel GE04_TFG;
    private javax.swing.JLabel GE05_FG;
    private javax.swing.JLabel GE05_TFG;
    private javax.swing.JLabel GE06_FG;
    private javax.swing.JLabel GE06_TFG;
    private javax.swing.JLabel GE07_FG;
    private javax.swing.JLabel GE07_TFG;
    private javax.swing.JLabel GE08_FG;
    private javax.swing.JLabel GE08_TFG;
    private javax.swing.JLabel GE09_FG;
    private javax.swing.JLabel GE09_TFG;
    private javax.swing.JLabel GE10_FG;
    private javax.swing.JLabel GE10_TFG;
    private javax.swing.JLabel GE11_FG;
    private javax.swing.JLabel GE11_TFG;
    private javax.swing.JLabel GE12_FG;
    private javax.swing.JLabel GE12_TFG;
    private javax.swing.JLabel HCI101_FG;
    private javax.swing.JLabel HCI101_TFG;
    private javax.swing.JLabel HCI102_FG;
    private javax.swing.JLabel HCI102_TFG;
    private javax.swing.JLabel IAS101_FG;
    private javax.swing.JLabel IAS101_TFG;
    private javax.swing.JLabel IAS102_FG;
    private javax.swing.JLabel IAS102_TFG;
    private javax.swing.JLabel IDNO;
    private javax.swing.JLabel IM102_FG;
    private javax.swing.JLabel IM102_TFG;
    private javax.swing.JLabel IPT101_FG;
    private javax.swing.JLabel IPT101_TFG;
    private javax.swing.JLabel IPT102_FG;
    private javax.swing.JLabel IPT102_TFG;
    private javax.swing.JLabel ITCAP101_FG;
    private javax.swing.JLabel ITCAP101_TFG;
    private javax.swing.JLabel ITCAP102_FG;
    private javax.swing.JLabel ITCAP102_TFG;
    private javax.swing.JLabel ITCC100_FG;
    private javax.swing.JLabel ITCC100_TFG;
    private javax.swing.JLabel ITCC101_FG;
    private javax.swing.JLabel ITCC101_TFG;
    private javax.swing.JLabel ITCC102_FG;
    private javax.swing.JLabel ITCC102_TFG;
    private javax.swing.JLabel ITCC103_FG;
    private javax.swing.JLabel ITCC103_TFG;
    private javax.swing.JLabel ITCC104_FG;
    private javax.swing.JLabel ITCC104_TFG;
    private javax.swing.JLabel ITCC105_FG;
    private javax.swing.JLabel ITCC105_TFG;
    private javax.swing.JLabel ITPRAC101_FG;
    private javax.swing.JLabel ITPRAC101_TFG;
    private javax.swing.JLabel LIT_FG;
    private javax.swing.JLabel LIT_TFG;
    private javax.swing.JLabel MS101_FG;
    private javax.swing.JLabel MS101_TFG;
    private javax.swing.JLabel MS102_FG;
    private javax.swing.JLabel MS102_TFG;
    private javax.swing.JLabel NET101_FG;
    private javax.swing.JLabel NET101_TFG;
    private javax.swing.JLabel NET102_FG;
    private javax.swing.JLabel NET102_TFG;
    private javax.swing.JLabel NME;
    private javax.swing.JLabel NSTP1_FG;
    private javax.swing.JLabel NSTP1_TFG;
    private javax.swing.JLabel NSTP2_FG;
    private javax.swing.JLabel NSTP2_TFG;
    private javax.swing.JLabel PE1_FG;
    private javax.swing.JLabel PE1_TFG;
    private javax.swing.JLabel PE2_FG;
    private javax.swing.JLabel PE2_TFG;
    private javax.swing.JLabel PE3_FG;
    private javax.swing.JLabel PE3_TFG;
    private javax.swing.JLabel PE4_FG;
    private javax.swing.JLabel PE4_TFG;
    private javax.swing.JLabel PF101_FG;
    private javax.swing.JLabel PF101_TFG;
    private javax.swing.JLabel PT101_FG;
    private javax.swing.JLabel PT101_TFG;
    private javax.swing.JLabel REED1_FG;
    private javax.swing.JLabel REED1_TFG;
    private javax.swing.JLabel REED2_FG;
    private javax.swing.JLabel REED2_TFG;
    private javax.swing.JLabel REED3_FG;
    private javax.swing.JLabel REED3_TFG;
    private javax.swing.JLabel REED4_FG;
    private javax.swing.JLabel REED4_TFG;
    private javax.swing.JLabel RIZAL_FG;
    private javax.swing.JLabel RIZAL_TFG;
    private javax.swing.JLabel SA101_FG;
    private javax.swing.JLabel SA101_TFG;
    private javax.swing.JLabel SIA101_FG;
    private javax.swing.JLabel SIA101_TFG;
    private javax.swing.JLabel SIA102_FG;
    private javax.swing.JLabel SIA102_TFG;
    private javax.swing.JLabel SP101_FG;
    private javax.swing.JLabel SP101_TFG;
    private javax.swing.JLabel TECH1L_FG;
    private javax.swing.JLabel TECH1L_TFG;
    private javax.swing.JLabel TECH1_FG;
    private javax.swing.JLabel TECH1_TFG;
    private javax.swing.JLabel WD101_FG;
    private javax.swing.JLabel WD101_TFG;
    private javax.swing.JLabel WS101_FG;
    private javax.swing.JLabel WS101_TFG;
    private javax.swing.JButton edit_sbj_btn8;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel245;
    private javax.swing.JLabel jLabel246;
    private javax.swing.JLabel jLabel247;
    private javax.swing.JLabel jLabel248;
    private javax.swing.JLabel jLabel249;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel250;
    private javax.swing.JLabel jLabel251;
    private javax.swing.JLabel jLabel252;
    private javax.swing.JLabel jLabel253;
    private javax.swing.JLabel jLabel254;
    private javax.swing.JLabel jLabel255;
    private javax.swing.JLabel jLabel256;
    private javax.swing.JLabel jLabel257;
    private javax.swing.JLabel jLabel258;
    private javax.swing.JLabel jLabel259;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel260;
    private javax.swing.JLabel jLabel261;
    private javax.swing.JLabel jLabel262;
    private javax.swing.JLabel jLabel263;
    private javax.swing.JLabel jLabel264;
    private javax.swing.JLabel jLabel265;
    private javax.swing.JLabel jLabel266;
    private javax.swing.JLabel jLabel267;
    private javax.swing.JLabel jLabel268;
    private javax.swing.JLabel jLabel269;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel270;
    private javax.swing.JLabel jLabel271;
    private javax.swing.JLabel jLabel272;
    private javax.swing.JLabel jLabel273;
    private javax.swing.JLabel jLabel274;
    private javax.swing.JLabel jLabel275;
    private javax.swing.JLabel jLabel276;
    private javax.swing.JLabel jLabel277;
    private javax.swing.JLabel jLabel278;
    private javax.swing.JLabel jLabel279;
    private javax.swing.JLabel jLabel280;
    private javax.swing.JLabel jLabel281;
    private javax.swing.JLabel jLabel282;
    private javax.swing.JLabel jLabel283;
    private javax.swing.JLabel jLabel284;
    private javax.swing.JLabel jLabel285;
    private javax.swing.JLabel jLabel286;
    private javax.swing.JLabel jLabel287;
    private javax.swing.JLabel jLabel288;
    private javax.swing.JLabel jLabel289;
    private javax.swing.JLabel jLabel290;
    private javax.swing.JLabel jLabel291;
    private javax.swing.JLabel jLabel292;
    private javax.swing.JLabel jLabel293;
    private javax.swing.JLabel jLabel294;
    private javax.swing.JLabel jLabel295;
    private javax.swing.JLabel jLabel296;
    private javax.swing.JLabel jLabel297;
    private javax.swing.JLabel jLabel298;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel300;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel311;
    private javax.swing.JLabel jLabel312;
    private javax.swing.JLabel jLabel313;
    private javax.swing.JLabel jLabel314;
    private javax.swing.JLabel jLabel315;
    private javax.swing.JLabel jLabel316;
    private javax.swing.JLabel jLabel317;
    private javax.swing.JLabel jLabel318;
    private javax.swing.JLabel jLabel319;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel320;
    private javax.swing.JLabel jLabel321;
    private javax.swing.JLabel jLabel322;
    private javax.swing.JLabel jLabel323;
    private javax.swing.JLabel jLabel324;
    private javax.swing.JLabel jLabel325;
    private javax.swing.JLabel jLabel326;
    private javax.swing.JLabel jLabel327;
    private javax.swing.JLabel jLabel328;
    private javax.swing.JLabel jLabel329;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel330;
    private javax.swing.JLabel jLabel331;
    private javax.swing.JLabel jLabel332;
    private javax.swing.JLabel jLabel333;
    private javax.swing.JLabel jLabel334;
    private javax.swing.JLabel jLabel335;
    private javax.swing.JLabel jLabel336;
    private javax.swing.JLabel jLabel337;
    private javax.swing.JLabel jLabel338;
    private javax.swing.JLabel jLabel339;
    private javax.swing.JLabel jLabel340;
    private javax.swing.JLabel jLabel341;
    private javax.swing.JLabel jLabel342;
    private javax.swing.JLabel jLabel343;
    private javax.swing.JLabel jLabel344;
    private javax.swing.JLabel jLabel345;
    private javax.swing.JLabel jLabel346;
    private javax.swing.JLabel jLabel347;
    private javax.swing.JLabel jLabel348;
    private javax.swing.JLabel jLabel349;
    private javax.swing.JLabel jLabel350;
    private javax.swing.JLabel jLabel351;
    private javax.swing.JLabel jLabel352;
    private javax.swing.JLabel jLabel353;
    private javax.swing.JLabel jLabel354;
    private javax.swing.JLabel jLabel356;
    private javax.swing.JLabel jLabel358;
    private javax.swing.JLabel jLabel359;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel360;
    private javax.swing.JLabel jLabel361;
    private javax.swing.JLabel jLabel362;
    private javax.swing.JLabel jLabel363;
    private javax.swing.JLabel jLabel364;
    private javax.swing.JLabel jLabel365;
    private javax.swing.JLabel jLabel366;
    private javax.swing.JLabel jLabel367;
    private javax.swing.JLabel jLabel368;
    private javax.swing.JLabel jLabel369;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel370;
    private javax.swing.JLabel jLabel371;
    private javax.swing.JLabel jLabel372;
    private javax.swing.JLabel jLabel373;
    private javax.swing.JLabel jLabel374;
    private javax.swing.JLabel jLabel375;
    private javax.swing.JLabel jLabel376;
    private javax.swing.JLabel jLabel377;
    private javax.swing.JLabel jLabel378;
    private javax.swing.JLabel jLabel379;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel380;
    private javax.swing.JLabel jLabel381;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLabel jLabelCourse1;
    private javax.swing.JLabel jLabelCourse2;
    private javax.swing.JLabel jLabelCourse3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField ntxtfield6;
    // End of variables declaration//GEN-END:variables
}
