/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main_Panel;

import Connection.DatabaseConnection;
import Model.ModelEnroll;
import Model.ModelStudent;
import Model.ModelSubject;
import Service.ServiceEnroll;
import Service.ServiceStudent;
import Service.ServiceSubject;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import forms.CreateSubject;
import forms.Create_Enroll;
import forms.Create_Student;
import forms.IT_form;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import raven.alerts.MessageAlerts;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.toast.Notifications;
import themes.CheckBoxTableHeaderRenderer;
import themes.TableHeaderAlignment;

/**
 *
 * @author luniz
 */
public class Main extends javax.swing.JFrame {

    private boolean isDarkMode = false;
    private ServiceStudent service = new ServiceStudent();
    private ServiceSubject service1 = new ServiceSubject();
    private ServiceEnroll service2 = new ServiceEnroll();

    /**
     * Creates new form Main
     */
    public Main() {
        setupLookAndFeel();
        initComponents();
        init();
    }

    public void init() {
        GlassPanePopup.install(this);
        Notifications.getInstance().setJFrame(this);
        sidepanel.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:lighten(@background,4%)");

        rounded_panel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:lighten(@background,4%)");

        rounded_panel2.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:lighten(@background,4%)");

        jLabel3.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:#696969");

        student_table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");

        student_table.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");

        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");

        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +5;");

        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search ID No / Name / Course / Major");
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("icons/search_1.svg"));
        txtSearch.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:1;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$Panel.background");

        student_table.getColumnModel().getColumn(0).setHeaderRenderer(new CheckBoxTableHeaderRenderer(student_table, 0));
        student_table.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(student_table));

        student_table1.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");

        student_table1.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");

        scroll1.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");

        lbTitle1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +5;");

        txtSearch1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search ID No / Name / Course / Major");
        txtSearch1.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("icons/search_1.svg"));
        txtSearch1.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:1;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$Panel.background");

        student_table1.getColumnModel().getColumn(0).setHeaderRenderer(new CheckBoxTableHeaderRenderer(student_table1, 0));
        student_table1.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(student_table1));

        student_table2.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");

        student_table2.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");

        scroll2.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");

        lbTitle2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +5;");

        txtSearch2.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search ID No / Name / Course / Major");
        txtSearch2.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("icons/search_1.svg"));
        txtSearch2.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:1;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$Panel.background");

        student_table2.getColumnModel().getColumn(0).setHeaderRenderer(new CheckBoxTableHeaderRenderer(student_table2, 0));
        student_table2.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(student_table2));

        student_table1.getColumnModel().getColumn(0).setHeaderRenderer(new CheckBoxTableHeaderRenderer(student_table1, 0));
        student_table1.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(student_table1));

        subject_table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");

        subject_table.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");

        scroll3.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");

        lbTitle3.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +5;");

        txtSearch3.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search Course Code or Title");
        txtSearch3.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("icons/search_1.svg"));
        txtSearch3.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:1;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$Panel.background");

        subject_table.getColumnModel().getColumn(0).setHeaderRenderer(new CheckBoxTableHeaderRenderer(subject_table, 0));
        subject_table.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(subject_table));

        enroll_table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");

        enroll_table.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");

        scroll_enroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");

        enroll_table.getColumnModel().getColumn(0).setHeaderRenderer(new CheckBoxTableHeaderRenderer(enroll_table, 0));
        enroll_table.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(enroll_table));

        enroll_table1.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");

        enroll_table1.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");

        scroll_enroll1.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");

        enroll_table1.getColumnModel().getColumn(0).setHeaderRenderer(new CheckBoxTableHeaderRenderer(enroll_table1, 0));
        enroll_table1.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(enroll_table1));

        enroll_table2.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");

        enroll_table2.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");

        scroll_enroll2.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");

        enroll_table2.getColumnModel().getColumn(0).setHeaderRenderer(new CheckBoxTableHeaderRenderer(enroll_table2, 0));
        enroll_table2.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(enroll_table2));

        input_grades_table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");

        input_grades_table.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");

        jScrollPane3.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");

        input_grades_table.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(input_grades_table));
        
        input_grades_table1.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");

        input_grades_table1.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");

        jScrollPane4.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");

        input_grades_table1.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(input_grades_table1));

        try {
            DatabaseConnection.getInstance().createConnection();
            loadData();
            loadDataSubject();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setupLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void toggleTheme() {
        try {
            // Toggle between light and dark modes
            if (isDarkMode) {
                UIManager.setLookAndFeel(new FlatMacLightLaf());
                theme_btn.setIcon(new FlatSVGIcon("icons/toggle_off.svg"));
            } else {
                UIManager.setLookAndFeel(new FlatMacDarkLaf());
                theme_btn.setIcon(new FlatSVGIcon("icons/toggle_on.svg"));
            }
            isDarkMode = !isDarkMode;  // Switch the mode flag
            SwingUtilities.updateComponentTreeUI(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        try {
            DefaultTableModel model = (DefaultTableModel) student_table.getModel();
            if (student_table.isEditing()) {
                student_table.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<ModelStudent> list = service.getAll();
            for (ModelStudent d : list) {
                model.addRow(d.toTableRow(student_table.getRowCount() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            DefaultTableModel model = (DefaultTableModel) student_table1.getModel();
            if (student_table1.isEditing()) {
                student_table1.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<ModelStudent> list = service.getAll();
            for (ModelStudent d : list) {
                model.addRow(d.toTableRow(student_table1.getRowCount() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            DefaultTableModel model = (DefaultTableModel) student_table2.getModel();
            if (student_table2.isEditing()) {
                student_table2.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<ModelStudent> list = service.getAll();
            for (ModelStudent d : list) {
                model.addRow(d.toTableRow(student_table2.getRowCount() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchData(String search) {
        try {
            DefaultTableModel model = (DefaultTableModel) student_table.getModel();
            if (student_table.isEditing()) {
                student_table.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<ModelStudent> list = service.search(search);
            for (ModelStudent d : list) {
                model.addRow(d.toTableRow(student_table.getRowCount() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            DefaultTableModel model = (DefaultTableModel) student_table1.getModel();
            if (student_table1.isEditing()) {
                student_table1.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<ModelStudent> list = service.search(search);
            for (ModelStudent d : list) {
                model.addRow(d.toTableRow(student_table1.getRowCount() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            DefaultTableModel model = (DefaultTableModel) student_table2.getModel();
            if (student_table2.isEditing()) {
                student_table2.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<ModelStudent> list = service.search(search);
            for (ModelStudent d : list) {
                model.addRow(d.toTableRow(student_table2.getRowCount() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void new_student() {
        Create_Student create = new Create_Student();
        create.loadData(service, null);
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Cancel", "Save"};
        GlassPanePopup.showPopup(new SimplePopupBorder(create, "New Student Record", actions, (pc, i) -> {
            if (i == 1) {
                // save
                try {
                    service.create(create.getData());
                    pc.closePopup();
                    Notifications.getInstance().show(Notifications.Type.SUCCESS,Notifications.Location.TOP_CENTER, "New Student Registered");
                    loadData();
                } catch (Exception e) {
                    e.printStackTrace();

                    if (e.getMessage().contains("column ID_num is not unique")) {
                        // Show a pop-up message
                        Notifications.getInstance().show(Notifications.Type.ERROR, "Student ID already exists");
                    } else {
                        e.printStackTrace(); // For other SQL exceptions
                    }
                }

            } else {
                pc.closePopup();
            }
        }), option);
    }

    private void edit_student() {
        List<ModelStudent> list = getSelectedDataStudent();
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                ModelStudent data = list.get(0);
                Create_Student create = new Create_Student();
                create.loadData(service, data);
                DefaultOption option = new DefaultOption() {
                    @Override
                    public boolean closeWhenClickOutside() {
                        return true;
                    }
                };
                String actions[] = new String[]{"Cancel", "Update"};
                GlassPanePopup.showPopup(new SimplePopupBorder(create, "Edit Student [" + data.getLname() + ", " + data.getFname() + " " + data.getMname() + "]", actions, (pc, i) -> {
                    if (i == 1) {
                        // edit
                        try {
                            ModelStudent dataEdit = create.getData();
                            dataEdit.setID_num(data.getID_num());
                            service.edit(dataEdit);
                            pc.closePopup();
                            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Student record has been updated");
                            loadData();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        pc.closePopup();
                    }
                }), option);
            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING, "Please select only one student");
            }
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Please select student to edit");
        }
    }

    private void edit_student1() {
        List<ModelStudent> list = getSelectedDataStudent1();
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                ModelStudent data = list.get(0);
                Create_Student create = new Create_Student();
                create.loadData(service, data);
                DefaultOption option = new DefaultOption() {
                    @Override
                    public boolean closeWhenClickOutside() {
                        return true;
                    }
                };
                String actions[] = new String[]{"Cancel", "Update"};
                GlassPanePopup.showPopup(new SimplePopupBorder(create, "Edit Student [" + data.getLname() + ", " + data.getFname() + " " + data.getMname() + "]", actions, (pc, i) -> {
                    if (i == 1) {
                        // edit
                        try {
                            ModelStudent dataEdit = create.getData();
                            dataEdit.setID_num(data.getID_num());
                            service.edit(dataEdit);
                            pc.closePopup();
                            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Student record has been updated");
                            loadData();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        pc.closePopup();
                    }
                }), option);
            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING, "Please select only one student");
            }
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Please select student to edit");
        }
    }

    private void edit_student2() {
        List<ModelStudent> list = getSelectedDataStudent2();
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                ModelStudent data = list.get(0);
                Create_Student create = new Create_Student();
                create.loadData(service, data);
                DefaultOption option = new DefaultOption() {
                    @Override
                    public boolean closeWhenClickOutside() {
                        return true;
                    }
                };
                String actions[] = new String[]{"Cancel", "Update"};
                GlassPanePopup.showPopup(new SimplePopupBorder(create, "Edit Student [" + data.getLname() + ", " + data.getFname() + " " + data.getMname() + "]", actions, (pc, i) -> {
                    if (i == 1) {
                        // edit
                        try {
                            ModelStudent dataEdit = create.getData();
                            dataEdit.setID_num(data.getID_num());
                            service.edit(dataEdit);
                            pc.closePopup();
                            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Student record has been updated");
                            loadData();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        pc.closePopup();
                    }
                }), option);
            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING, "Please select only one student");
            }
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Please select student to edit");
        }
    }

    private void delete_student() {
        List<ModelStudent> list = getSelectedDataStudent();
        if (!list.isEmpty()) {
            DefaultOption option = new DefaultOption() {
                @Override
                public boolean closeWhenClickOutside() {
                    return true;
                }
            };
            String actions[] = new String[]{"Cancel", "Delete"};
            JLabel label = new JLabel("<html>Are you sure to delete " + list.size() + " student(s)?<br/>"
                    + "<span style='color:red;'>This action is irreversible.</span></html>");
            label.setBorder(new EmptyBorder(0, 25, 0, 25));
            GlassPanePopup.showPopup(new SimplePopupBorder(label, "Confirm Delete", actions, (pc, i) -> {
                if (i == 1) {
                    // delete
                    try {
                        for (ModelStudent d : list) {
                            service.delete(d.getID_num());
                        }
                        pc.closePopup();
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Student has been deleted");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    loadData();
                } else {
                    pc.closePopup();
                }
            }), option);
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Please select student to delete");
        }
    }

    private void delete_student1() {
        List<ModelStudent> list = getSelectedDataStudent1();
        if (!list.isEmpty()) {
            DefaultOption option = new DefaultOption() {
                @Override
                public boolean closeWhenClickOutside() {
                    return true;
                }
            };
            String actions[] = new String[]{"Cancel", "Delete"};
            JLabel label = new JLabel("<html>Are you sure to delete " + list.size() + " student(s)?<br/>"
                    + "<span style='color:red;'>This action is irreversible.</span></html>");
            label.setBorder(new EmptyBorder(0, 25, 0, 25));
            GlassPanePopup.showPopup(new SimplePopupBorder(label, "Confirm Delete", actions, (pc, i) -> {
                if (i == 1) {
                    // delete
                    try {
                        for (ModelStudent d : list) {
                            service.delete(d.getID_num());
                        }
                        pc.closePopup();
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Student has been deleted");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    loadData();
                } else {
                    pc.closePopup();
                }
            }), option);
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Please select student to delete");
        }
    }

    private void delete_student2() {
        List<ModelStudent> list = getSelectedDataStudent2();
        if (!list.isEmpty()) {
            DefaultOption option = new DefaultOption() {
                @Override
                public boolean closeWhenClickOutside() {
                    return true;
                }
            };
            String actions[] = new String[]{"Cancel", "Delete"};
            JLabel label = new JLabel("<html>Are you sure to delete " + list.size() + " student(s)?<br/>"
                    + "<span style='color:red;'>This action is irreversible.</span></html>");
            label.setBorder(new EmptyBorder(0, 25, 0, 25));
            GlassPanePopup.showPopup(new SimplePopupBorder(label, "Confirm Delete", actions, (pc, i) -> {
                if (i == 1) {
                    // delete
                    try {
                        for (ModelStudent d : list) {
                            service.delete(d.getID_num());
                        }
                        pc.closePopup();
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Student has been deleted");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    loadData();
                } else {
                    pc.closePopup();
                }
            }), option);
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Please select student to delete");
        }
    }

    private void loadDataSubject() {
        try {
            DefaultTableModel model = (DefaultTableModel) subject_table.getModel();
            if (subject_table.isEditing()) {
                subject_table.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<ModelSubject> list = service1.getAll1();
            for (ModelSubject d : list) {
                model.addRow(d.toTableRow(subject_table.getRowCount() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchDataSubject(String search) {
        try {
            DefaultTableModel model = (DefaultTableModel) subject_table.getModel();
            if (subject_table.isEditing()) {
                subject_table.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<ModelSubject> list = service1.search1(search);
            for (ModelSubject d : list) {
                model.addRow(d.toTableRow(subject_table.getRowCount() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void new_subject() {
        CreateSubject create = new CreateSubject();
        create.loadData1(service1, null);
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Cancel", "Save"};
        GlassPanePopup.showPopup(new SimplePopupBorder(create, "New Subject", actions, (pc, i) -> {
            if (i == 1) {
                // save
                try {
                    service1.create1(create.getData1());
                    pc.closePopup();
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, "New Subject Added");
                    loadDataSubject();
                } catch (Exception e) {
                    e.printStackTrace();
                    if (e.getMessage().contains("column course_code is not unique")) {
                        // Show a pop-up message
                        Notifications.getInstance().show(Notifications.Type.ERROR, "Course Code already exists");
                    } else {
                        e.printStackTrace(); // For other SQL exceptions
                    }
                }

            } else {
                pc.closePopup();
            }
        }), option);
    }

    private void edit_subject() {
        List<ModelSubject> list = getSelectedDataSubject();
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                ModelSubject data = list.get(0);
                CreateSubject create = new CreateSubject();
                create.loadData1(service1, data);
                DefaultOption option = new DefaultOption() {
                    @Override
                    public boolean closeWhenClickOutside() {
                        return true;
                    }
                };
                String actions[] = new String[]{"Cancel", "Edit"};
                GlassPanePopup.showPopup(new SimplePopupBorder(create, "Edit Subject [" + data.getCourse_code() + "]", actions, (pc, i) -> {
                    if (i == 1) {
                        // edit
                        try {
                            ModelSubject dataEdit = create.getData1();
                            dataEdit.setCourse_code(data.getCourse_code());
                            service1.edit1(dataEdit);
                            pc.closePopup();
                            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Subject updated");
                            loadDataSubject();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        pc.closePopup();
                    }
                }), option);
            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING, "Please select only one subject");
            }
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Please select subject to edit");
        }
    }

    private void delete_subject() {
        List<ModelSubject> list = getSelectedDataSubject();
        if (!list.isEmpty()) {
            DefaultOption option = new DefaultOption() {
                @Override
                public boolean closeWhenClickOutside() {
                    return true;
                }
            };
            String actions[] = new String[]{"Cancel", "Delete"};
            /*JLabel label = new JLabel("Are you sure to delete " + list.size() + " subject ?");*/

            JLabel label = new JLabel("<html>Are you sure to delete " + list.size() + " subject(s)?<br/>"
                    + "<span style='color:red;'>This action is irreversible.</span></html>");
            label.setBorder(new EmptyBorder(0, 25, 0, 25));
            GlassPanePopup.showPopup(new SimplePopupBorder(label, "Confirm Delete", actions, (pc, i) -> {
                if (i == 1) {
                    // delete
                    try {
                        for (ModelSubject d : list) {
                            service1.delete1(d.getCourse_code());
                        }
                        pc.closePopup();
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Subject has been deleted");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    loadDataSubject();
                } else {
                    pc.closePopup();
                }
            }), option);
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Please select subject to delete");
        }
    }

    private void loadDataEnroll() {
        try {
            DefaultTableModel model = (DefaultTableModel) enroll_table.getModel();
            if (enroll_table.isEditing()) {
                enroll_table.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<ModelEnroll> list = service2.getAll2();
            for (ModelEnroll d : list) {
                model.addRow(d.toTableRow(enroll_table.getRowCount() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchDataEnroll(String search) {
        try {
            DefaultTableModel model = (DefaultTableModel) enroll_table.getModel();
            if (enroll_table.isEditing()) {
                enroll_table.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<ModelEnroll> list = service2.search2(search);

            for (ModelEnroll d : list) {
                model.addRow(d.toTableRow(enroll_table.getRowCount() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void enroll_name() {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        String ID_num = ntxtfield2.getText().toUpperCase().trim();
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("SELECT * FROM student_table WHERE ID_num = ?");
            p.setString(1, ID_num);
            r = p.executeQuery();
            if (r.next()) {
                String lname = r.getString("Lname");
                String fname = r.getString("Fname");
                String mname = r.getString("Mname");
                String course = r.getString("Course");

                jLabel52.setText("Name: " + lname + ", " + fname + " " + mname);
                jLabel51.setText("Course: " + course);
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, "Student not found");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } finally {
            try {
                if (r != null) {
                    r.close();
                }
                if (p != null) {
                    p.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error closing resources: " + e.getMessage());
            }
        }
    }

    private void edit_enroll() {
        List<ModelEnroll> list = getSelectedDataEnroll();
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                ModelEnroll data = list.get(0);
                Create_Enroll create = new Create_Enroll();
                create.loadData(service2, data);
                DefaultOption option = new DefaultOption() {
                    @Override
                    public boolean closeWhenClickOutside() {
                        return true;
                    }
                };
                String actions[] = new String[]{"Cancel", "Edit"};
                GlassPanePopup.showPopup(new SimplePopupBorder(create, "Edit Enrollment [" + data.getEnrollment_no() + "]", actions, (pc, i) -> {
                    if (i == 1) {
                        // edit
                        try {
                            ModelEnroll dataEdit = create.getData();
                            dataEdit.setEnrollment_no(data.getEnrollment_no());
                            service2.edit2(dataEdit);
                            pc.closePopup();
                            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Enrollment updated");

                            searchDataEnroll(ntxtfield2.getText().trim());
                            enroll_name();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        pc.closePopup();
                    }
                }), option);
            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING, "Please select only one enrollment record");
            }
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Please select record to edit");
        }
    }

    private void delete_enroll() {
        List<ModelEnroll> list = getSelectedDataEnroll();
        if (!list.isEmpty()) {
            DefaultOption option = new DefaultOption() {
                @Override
                public boolean closeWhenClickOutside() {
                    return true;
                }
            };
            String actions[] = new String[]{"Cancel", "Delete"};
            /*JLabel label = new JLabel("Are you sure to delete " + list.size() + " subject ?");*/

            JLabel label = new JLabel("<html>Are you sure to delete " + list.size() + " record(s)?<br/>"
                    + "<span style='color:red;'>This action is irreversible.</span></html>");
            label.setBorder(new EmptyBorder(0, 25, 0, 25));
            GlassPanePopup.showPopup(new SimplePopupBorder(label, "Confirm Delete", actions, (pc, i) -> {
                if (i == 1) {
                    // delete
                    try {
                        for (ModelEnroll d : list) {
                            service2.delete2(d.getEnrollment_no());
                        }
                        pc.closePopup();
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Record has been deleted");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    searchDataEnroll(ntxtfield2.getText().trim());
                    enroll_name();
                } else {
                    pc.closePopup();
                }
            }), option);
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Please select record to delete");
        }
    }

    private void loadDataEnroll2() {
        try {
            DefaultTableModel model = (DefaultTableModel) enroll_table2.getModel();
            if (enroll_table2.isEditing()) {
                enroll_table2.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<ModelEnroll> list = service2.getAll2();
            for (ModelEnroll d : list) {
                model.addRow(d.toTableRow(enroll_table2.getRowCount() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchDataEnroll2(String search) {
        try {
            DefaultTableModel model = (DefaultTableModel) enroll_table2.getModel();
            if (enroll_table2.isEditing()) {
                enroll_table2.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<ModelEnroll> list = service2.search2(search);

            for (ModelEnroll d : list) {
                model.addRow(d.toTableRow(enroll_table2.getRowCount() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadDataEnroll1() {
        try {
            DefaultTableModel model = (DefaultTableModel) enroll_table1.getModel();
            if (enroll_table1.isEditing()) {
                enroll_table1.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<ModelEnroll> list = service2.getAll2();
            for (ModelEnroll d : list) {
                model.addRow(d.toTableRow(enroll_table1.getRowCount() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchDataEnroll1(String search) {
        try {
            DefaultTableModel model = (DefaultTableModel) enroll_table1.getModel();
            if (enroll_table1.isEditing()) {
                enroll_table1.getCellEditor().stopCellEditing();
            }
            model.setRowCount(0);
            List<ModelEnroll> list = service2.search2(search);

            for (ModelEnroll d : list) {
                model.addRow(d.toTableRow(enroll_table1.getRowCount() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void enroll_name2() {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        String ID_num = ntxtfield4.getText().toUpperCase().trim();
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("SELECT * FROM student_table WHERE ID_num = ?");
            p.setString(1, ID_num);
            r = p.executeQuery();
            if (r.next()) {
                String lname = r.getString("Lname");
                String fname = r.getString("Fname");
                String mname = r.getString("Mname");
                String course = r.getString("Course");

                jLabel57.setText("Name: " + lname + ", " + fname + " " + mname);
                jLabel58.setText("Course: " + course);
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, "Student not found");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } finally {
            try {
                if (r != null) {
                    r.close();
                }
                if (p != null) {
                    p.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error closing resources: " + e.getMessage());
            }
        }
    }

    private void edit_enroll2() {
        List<ModelEnroll> list = getSelectedDataEnroll2();
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                ModelEnroll data = list.get(0);
                Create_Enroll create = new Create_Enroll();
                create.loadData(service2, data);
                DefaultOption option = new DefaultOption() {
                    @Override
                    public boolean closeWhenClickOutside() {
                        return true;
                    }
                };
                String actions[] = new String[]{"Cancel", "Edit"};
                GlassPanePopup.showPopup(new SimplePopupBorder(create, "Edit Enrollment [" + data.getEnrollment_no() + "]", actions, (pc, i) -> {
                    if (i == 1) {
                        // edit
                        try {
                            ModelEnroll dataEdit = create.getData();
                            dataEdit.setEnrollment_no(data.getEnrollment_no());
                            service2.edit2(dataEdit);
                            pc.closePopup();
                            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Enrollment updated");

                            searchDataEnroll2(ntxtfield4.getText().trim());
                            enroll_name2();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        pc.closePopup();
                    }
                }), option);
            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING, "Please select only one enrollment record");
            }
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Please select record to edit");
        }
    }

    private void delete_enroll2() {
        List<ModelEnroll> list = getSelectedDataEnroll2();
        if (!list.isEmpty()) {
            DefaultOption option = new DefaultOption() {
                @Override
                public boolean closeWhenClickOutside() {
                    return true;
                }
            };
            String actions[] = new String[]{"Cancel", "Delete"};
            /*JLabel label = new JLabel("Are you sure to delete " + list.size() + " subject ?");*/

            JLabel label = new JLabel("<html>Are you sure to delete " + list.size() + " record(s)?<br/>"
                    + "<span style='color:red;'>This action is irreversible.</span></html>");
            label.setBorder(new EmptyBorder(0, 25, 0, 25));
            GlassPanePopup.showPopup(new SimplePopupBorder(label, "Confirm Delete", actions, (pc, i) -> {
                if (i == 1) {
                    // delete
                    try {
                        for (ModelEnroll d : list) {
                            service2.delete2(d.getEnrollment_no());
                        }
                        pc.closePopup();
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Record has been deleted");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    searchDataEnroll2(ntxtfield4.getText().trim());
                    enroll_name2();
                } else {
                    pc.closePopup();
                }
            }), option);
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Please select record to delete");
        }
    }

    private void new_enroll_student() {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        String ID_num = ntxtfield6.getText().toUpperCase().trim();
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("SELECT * FROM student_table WHERE ID_num = ?");
            p.setString(1, ID_num);
            r = p.executeQuery();
            if (r.next()) {
                String lname = r.getString("Lname");
                String fname = r.getString("Fname");
                String mname = r.getString("Mname");
                String course = r.getString("Course");
                String major = r.getString("Major");

                jLabel66.setText("ID Number:  " + ID_num);
                jLabel67.setText("Name:  " + lname + ", " + fname + " " + mname);
                jLabel68.setText("Course:  " + course);
                jLabel69.setText("Major:  " + major);
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, "Student not found");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } finally {
            try {
                if (r != null) {
                    r.close();
                }
                if (p != null) {
                    p.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error closing resources: " + e.getMessage());
            }
        }
    }

    private void new_enroll() {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        String ID_num = ntxtfield6.getText().toUpperCase().trim();
        String course_code = ntxtfield5.getText().toUpperCase().trim();
        String semester = comboSem.getSelectedItem().toString();
        String schoolyear = txtSY.getText().trim().toUpperCase();

        try {
            // Check if any fields are blank
            if (ID_num.isEmpty() || course_code.isEmpty() || semester.isEmpty() || schoolyear.isEmpty()) {
                Notifications.getInstance().show(Notifications.Type.ERROR, "All fields must be filled.");
                return;  // Stop the insertion process if fields are blank
            }

            con = DatabaseConnection.getInstance().createConnection();

            // Check for duplicate enrollment
            String checkQuery = "SELECT * FROM enrollment_table WHERE ID_num = ? AND course_code = ? AND semester = ? AND schoolyear = ?";
            p = con.prepareStatement(checkQuery);
            p.setString(1, ID_num);
            p.setString(2, course_code);
            p.setString(3, semester);
            p.setString(4, schoolyear);
            r = p.executeQuery();

            if (r.next()) {
                // If a record is found, show an error and stop the process
                Notifications.getInstance().show(Notifications.Type.ERROR, "Student is already enrolled in this subject for the same semester and school year.");
                return;  // Stop further execution
            }

            // If no duplicates, proceed to insert
            p.close();  // Close the previous statement
            String insertQuery = "INSERT INTO enrollment_table (ID_num, course_code, semester, schoolyear) VALUES (?, ?, ?, ?)";
            p = con.prepareStatement(insertQuery);
            p.setString(1, ID_num);
            p.setString(2, course_code);
            p.setString(3, semester);
            p.setString(4, schoolyear);

            int rowsAffected = p.executeUpdate();

            if (rowsAffected > 0) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Enrolled Successfully");
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, "Enrollment failed");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } finally {
            try {
                if (r != null) {
                    r.close();
                }
                if (p != null) {
                    p.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error closing resources: " + e.getMessage());
            }
        }

    }

    private void new_enroll_subject() {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        String course_code = ntxtfield5.getText().toUpperCase().trim();
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("SELECT * FROM subject_table WHERE course_code = ?");
            p.setString(1, course_code);
            r = p.executeQuery();
            if (r.next()) {
                String cc = r.getString("course_code");
                String dt = r.getString("desc_title");
                String u = r.getString("units");

                jLabel60.setText("Course Code:  " + cc);
                jLabel61.setText("Descriptive Title:  " + dt);
                jLabel62.setText("Units:  " + u);
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, "Subject not found");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } finally {
            try {
                if (r != null) {
                    r.close();
                }
                if (p != null) {
                    p.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error closing resources: " + e.getMessage());
            }
        }
    }

    private void searchAndLoadData() {
        String studentId = input_field.getText().trim(); // Get the student ID from the text field

        // Check if the student ID is not empty
        if (studentId.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Please enter a valid student ID.");
            return;
        }

        // Get the table model
        DefaultTableModel model = (DefaultTableModel) input_grades_table.getModel();
        model.setRowCount(0); // Clear existing data

        // Define the SQL query with ordering by schoolyear descending
        String sql = "SELECT enrollment_table.enrollment_no, subject_table.course_code, "
                + "enrollment_table.semester, enrollment_table.schoolyear, "
                + "student_table.Lname, student_table.Fname, student_table.course "
                + "FROM enrollment_table "
                + "JOIN student_table ON enrollment_table.ID_Num = student_table.ID_Num "
                + "JOIN subject_table ON enrollment_table.course_code = subject_table.course_code "
                + "WHERE enrollment_table.ID_Num = ? "
                + "ORDER BY enrollment_table.schoolyear DESC, enrollment_table.semester DESC, subject_table.course_code ASC"; // Order by school year descending

        try (Connection conn = DatabaseConnection.getInstance().createConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId); // Set the student ID in the query
            ResultSet rs = pstmt.executeQuery();

            // Check if student exists
            if (rs.next()) {
                // Set the student details in the labels
                String lname = rs.getString("Lname");
                String fname = rs.getString("Fname");
                String course = rs.getString("course");
                jLabelName.setText("Name: " + lname + ", " + fname);
                jLabelCourse.setText("Course: " + course);

                // Store all records first before adding them to the table
                do {
                    String courseCode = rs.getString("course_code");
                    String semester = rs.getString("semester");
                    String schoolYear = rs.getString("schoolyear");
                    // Add a new row with editable cells for grades
                    model.addRow(new Object[]{courseCode, semester, schoolYear, null, null}); // Tentative and Final Grade as null
                } while (rs.next()); // Move to the next record

                // Show success notification
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Records loaded successfully.");
            } else {
                // If student does not exist
                Notifications.getInstance().show(Notifications.Type.ERROR, "No records found for this student ID.");
                // Clear labels if no student is found
                jLabelName.setText("Name: ");
                jLabelCourse.setText("Course: ");
            }
        } catch (SQLException e) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Error loading data: " + e.getMessage());
        }
    }

    private void loadGrades() {
        String studentId = input_field.getText().trim(); // Get the student ID from the text field

        // Check if the student ID is not empty
        if (studentId.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Please enter a valid student ID.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) input_grades_table.getModel();
        model.setRowCount(0); // Clear the table before loading new data

        String sql = "SELECT e.course_code, e.semester, e.schoolyear, g.tentative_grade, g.final_grade "
                + "FROM enrollment_table e LEFT JOIN grades_table g ON e.enrollment_no = g.enrollment_no "
                + "WHERE e.ID_Num = ? ORDER BY e.schoolyear DESC, e.semester DESC, e.course_code ASC"; // Fetch grades with enrollment

        try (Connection conn = DatabaseConnection.getInstance().createConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId); // Set the student ID in the query
            ResultSet rs = pstmt.executeQuery();

            // Check if any records were found
            if (!rs.isBeforeFirst()) {
                Notifications.getInstance().show(Notifications.Type.ERROR, "No grades found for this student ID.");
                return;
            }

            while (rs.next()) {
                String courseCode = rs.getString("course_code");
                String semester = rs.getString("semester");
                String schoolYear = rs.getString("schoolyear");
                Object tentativeGrade = rs.getObject("tentative_grade"); // Nullable in DB
                Object finalGrade = rs.getObject("final_grade"); // Nullable in DB

                // Add a new row to the model
                model.addRow(new Object[]{
                    courseCode,
                    semester,
                    schoolYear,
                    tentativeGrade,
                    finalGrade
                });
            }

            // After loading data, make columns editable conditionally
            for (int i = 0; i < model.getRowCount(); i++) {
                if (model.getValueAt(i, 3) != null || model.getValueAt(i, 4) != null) { // If grades exist
                    input_grades_table.getColumnModel().getColumn(3).setCellEditor(null); // Tentative Grade
                    input_grades_table.getColumnModel().getColumn(4).setCellEditor(null); // Final Grade
                }
            }

            // Show success notification after loading grades
            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Grades loaded successfully.");
        } catch (SQLException e) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Error loading grades: " + e.getMessage());
        }
    }

    private void delete_grade() {
        int selectedRow = input_grades_table.getSelectedRow(); // Get the selected row

        // Check if a row is selected
        if (selectedRow == -1) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Please select a grade to delete.");
            return;
        }

        // Get the values needed to identify the record
        String courseCode = input_grades_table.getValueAt(selectedRow, 0).toString();
        String semester = input_grades_table.getValueAt(selectedRow, 1).toString();
        String schoolYear = input_grades_table.getValueAt(selectedRow, 2).toString();

        // Confirm deletion using a custom confirmation dialog (instead of JOptionPane)
        int confirmation = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete the grade for " + courseCode + " in " + semester + " for the school year " + schoolYear + "?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            // Proceed with deletion
            try (Connection conn = DatabaseConnection.getInstance().createConnection()) {
                // Get the enrollment_no based on course code, semester, and school year
                String enrollmentSql = "SELECT enrollment_no FROM enrollment_table WHERE ID_Num = ? AND course_code = ? AND semester = ? AND schoolyear = ?";
                String studentId = input_field.getText().trim();

                try (PreparedStatement enrollmentStmt = conn.prepareStatement(enrollmentSql)) {
                    enrollmentStmt.setString(1, studentId);
                    enrollmentStmt.setString(2, courseCode);
                    enrollmentStmt.setString(3, semester);
                    enrollmentStmt.setString(4, schoolYear);

                    ResultSet enrollmentRs = enrollmentStmt.executeQuery();

                    if (enrollmentRs.next()) {
                        int enrollmentNo = enrollmentRs.getInt("enrollment_no");

                        // Delete the grade from grades_table
                        String deleteSql = "DELETE FROM grades_table WHERE enrollment_no = ?";
                        try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {
                            deleteStmt.setInt(1, enrollmentNo);
                            int rowsAffected = deleteStmt.executeUpdate();

                            if (rowsAffected > 0) {
                                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Grade deleted successfully.");
                                // Optionally reload the grades table to reflect changes
                                loadGrades(); // Call your method to reload the table data
                            } else {
                                Notifications.getInstance().show(Notifications.Type.ERROR, "No grade found for deletion.");
                            }
                        }
                    } else {
                        Notifications.getInstance().show(Notifications.Type.ERROR, "Enrollment record not found.");
                    }
                }
            } catch (SQLException e) {
                Notifications.getInstance().show(Notifications.Type.ERROR, "Error deleting grade: " + e.getMessage());
            }
        }
    }

    private void input_grades() {
        DefaultTableModel model = (DefaultTableModel) input_grades_table.getModel();
        String studentId = input_field.getText().trim();

        // Check if the student ID is not empty
        if (studentId.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Please enter a valid student ID.");
            return;
        }

        try (Connection conn = DatabaseConnection.getInstance().createConnection()) {
            for (int row = 0; row < model.getRowCount(); row++) {
                String courseCode = model.getValueAt(row, 0).toString();
                String semester = model.getValueAt(row, 1).toString();
                String schoolYear = model.getValueAt(row, 2).toString();
                Object tentativeGradeObj = model.getValueAt(row, 3);
                Object finalGradeObj = model.getValueAt(row, 4);

                // Get the enrollment_no based on course code, semester, and school year
                String enrollmentSql = "SELECT enrollment_no FROM enrollment_table WHERE ID_Num = ? AND course_code = ? AND semester = ? AND schoolyear = ?";
                try (PreparedStatement enrollmentStmt = conn.prepareStatement(enrollmentSql)) {
                    enrollmentStmt.setString(1, studentId);
                    enrollmentStmt.setString(2, courseCode);
                    enrollmentStmt.setString(3, semester);
                    enrollmentStmt.setString(4, schoolYear);
                    ResultSet enrollmentRs = enrollmentStmt.executeQuery();

                    if (enrollmentRs.next()) {
                        int enrollmentNo = enrollmentRs.getInt("enrollment_no");

                        // Check if grades already exist
                        String checkSql = "SELECT * FROM grades_table WHERE enrollment_no = ?";
                        try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                            checkStmt.setInt(1, enrollmentNo);
                            ResultSet checkRs = checkStmt.executeQuery();

                            if (checkRs.next()) {
                                // Update existing grades
                                String updateSql = "UPDATE grades_table SET tentative_grade = ?, final_grade = ? WHERE enrollment_no = ?";
                                try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                                    updateStmt.setObject(1, tentativeGradeObj);
                                    updateStmt.setObject(2, finalGradeObj);
                                    updateStmt.setInt(3, enrollmentNo);
                                    updateStmt.executeUpdate();
                                }
                            } else {
                                // Insert into grades_table
                                String insertSql = "INSERT INTO grades_table (tentative_grade, final_grade, enrollment_no) VALUES (?, ?, ?)";
                                try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                                    insertStmt.setObject(1, tentativeGradeObj);
                                    insertStmt.setObject(2, finalGradeObj);
                                    insertStmt.setInt(3, enrollmentNo);
                                    insertStmt.executeUpdate();
                                }
                            }
                        }
                    }
                }
            }

            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Grades saved successfully!");
        } catch (SQLException e) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Error saving grades: " + e.getMessage());
        }
    }

    private void searchAndLoadData1() {
        String studentId = input_field1.getText().trim(); // Get the student ID from the text field

        // Check if the student ID is not empty
        if (studentId.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Please enter a valid student ID.");
            return;
        }

        // Get the table model
        DefaultTableModel model = (DefaultTableModel) input_grades_table1.getModel();
        model.setRowCount(0); // Clear existing data

        // Define the SQL query with ordering by schoolyear descending
        String sql = "SELECT enrollment_table.enrollment_no, subject_table.course_code, "
                + "enrollment_table.semester, enrollment_table.schoolyear, "
                + "student_table.Lname, student_table.Fname, student_table.course "
                + "FROM enrollment_table "
                + "JOIN student_table ON enrollment_table.ID_Num = student_table.ID_Num "
                + "JOIN subject_table ON enrollment_table.course_code = subject_table.course_code "
                + "WHERE enrollment_table.ID_Num = ? "
                + "ORDER BY enrollment_table.schoolyear DESC, enrollment_table.semester DESC, subject_table.course_code ASC"; // Order by school year descending

        try (Connection conn = DatabaseConnection.getInstance().createConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId); // Set the student ID in the query

            ResultSet rs = pstmt.executeQuery();

            // Check if student exists
            if (rs.next()) {
                // Set the student details in the labels
                String lname = rs.getString("Lname");
                String fname = rs.getString("Fname");
                String course = rs.getString("course");
                jLabelName1.setText("Name: " + lname + ", " + fname);
                jLabelCourse1.setText("Course: " + course);
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Student data loaded successfully!");
            } else {
                // If student does not exist
                Notifications.getInstance().show(Notifications.Type.INFO, "No records found for this student ID.");
                // Clear labels if no student is found
                jLabelName1.setText("Name: ");
                jLabelCourse1.setText("Course: ");
            }
        } catch (SQLException e) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Error loading data: " + e.getMessage());
        }
    }

    private void loadGradesWithValues() {
        String studentId = input_field1.getText().trim(); // Get the student ID from the text field

        // Check if the student ID is not empty
        if (studentId.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Please enter a valid student ID.");
            return;
        }

        // Get the table model (create one if necessary)
        DefaultTableModel model = (DefaultTableModel) input_grades_table1.getModel();

        // Clear existing data
        model.setRowCount(0);

        // Define the SQL query to get only records with grades
        String sql = "SELECT e.course_code, e.semester, e.schoolyear, g.tentative_grade, g.final_grade "
                + "FROM enrollment_table e "
                + "JOIN grades_table g ON e.enrollment_no = g.enrollment_no "
                + "WHERE e.ID_Num = ? ORDER BY e.schoolyear DESC, e.semester DESC, e.course_code ASC";

        try (Connection conn = DatabaseConnection.getInstance().createConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentId); // Set the student ID in the query

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Loop through the result set and populate the table model
            boolean hasRecords = false; // Flag to check if there are any records
            while (rs.next()) {
                String courseCode = rs.getString("course_code");
                String semester = rs.getString("semester");
                String schoolYear = rs.getString("schoolyear");
                String tentativeGrade = rs.getString("tentative_grade");
                String finalGrade = rs.getString("final_grade");

                // Only add the row if either tentative_grade or final_grade is not empty
                if ((tentativeGrade != null && !tentativeGrade.trim().isEmpty())
                        || (finalGrade != null && !finalGrade.trim().isEmpty())) {
                    // Add a row to the table
                    model.addRow(new Object[]{courseCode, semester, schoolYear, tentativeGrade, finalGrade});
                    hasRecords = true; // Set the flag to true if records are added
                }
            }

            // Notify if no grades were found
            if (!hasRecords) {
                Notifications.getInstance().show(Notifications.Type.INFO, "No grades found for this student ID.");
            } else {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Grades loaded successfully!");
            }
        } catch (SQLException e) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Error loading grades: " + e.getMessage());
        }
    }

    private List<ModelStudent> getSelectedDataStudent() {
        List<ModelStudent> list = new ArrayList<>();
        for (int i = 0; i < student_table.getRowCount(); i++) {
            if ((boolean) student_table.getValueAt(i, 0)) {
                ModelStudent data = (ModelStudent) student_table.getValueAt(i, 1);
                list.add(data);
            }
        }
        return list;
    }

    private List<ModelStudent> getSelectedDataStudent1() {
        List<ModelStudent> list = new ArrayList<>();
        for (int i = 0; i < student_table1.getRowCount(); i++) {
            if ((boolean) student_table1.getValueAt(i, 0)) {
                ModelStudent data = (ModelStudent) student_table1.getValueAt(i, 1);
                list.add(data);
            }
        }
        return list;
    }

    private List<ModelStudent> getSelectedDataStudent2() {
        List<ModelStudent> list = new ArrayList<>();
        for (int i = 0; i < student_table2.getRowCount(); i++) {
            if ((boolean) student_table2.getValueAt(i, 0)) {
                ModelStudent data = (ModelStudent) student_table2.getValueAt(i, 1);
                list.add(data);
            }
        }
        return list;
    }

    private List<ModelSubject> getSelectedDataSubject() {
        List<ModelSubject> list = new ArrayList<>();
        for (int i = 0; i < subject_table.getRowCount(); i++) {
            if ((boolean) subject_table.getValueAt(i, 0)) {
                ModelSubject data = (ModelSubject) subject_table.getValueAt(i, 1);
                list.add(data);
            }
        }
        return list;
    }

    private List<ModelEnroll> getSelectedDataEnroll() {
        List<ModelEnroll> list = new ArrayList<>();
        for (int i = 0; i < enroll_table.getRowCount(); i++) {
            if ((boolean) enroll_table.getValueAt(i, 0)) {
                ModelEnroll data = (ModelEnroll) enroll_table.getValueAt(i, 1);
                list.add(data);
            }
        }
        return list;
    }

    private List<ModelEnroll> getSelectedDataEnroll2() {
        List<ModelEnroll> list = new ArrayList<>();
        for (int i = 0; i < enroll_table2.getRowCount(); i++) {
            if ((boolean) enroll_table2.getValueAt(i, 0)) {
                ModelEnroll data = (ModelEnroll) enroll_table2.getValueAt(i, 1);
                list.add(data);
            }
        }
        return list;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidepanel = new themes.rounded_panel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn1 = new javax.swing.JLabel();
        btn2 = new javax.swing.JLabel();
        btn3 = new javax.swing.JLabel();
        btn5 = new javax.swing.JLabel();
        btn6 = new javax.swing.JLabel();
        btn7 = new javax.swing.JLabel();
        btn8 = new javax.swing.JLabel();
        btn9 = new javax.swing.JLabel();
        btn11 = new javax.swing.JLabel();
        btn12 = new javax.swing.JLabel();
        btn13 = new javax.swing.JLabel();
        btn14 = new javax.swing.JLabel();
        btn15 = new javax.swing.JLabel();
        btn16 = new javax.swing.JLabel();
        btn17 = new javax.swing.JLabel();
        btn18 = new javax.swing.JLabel();
        content_panel = new themes.rounded_panel();
        welcome_panel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        grades_panel_input = new javax.swing.JPanel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        input_field = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jLabelName = new javax.swing.JLabel();
        jLabelCourse = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        input_grades_table = new javax.swing.JTable();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        enrollment_panel = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        edit_sbj_btn2 = new javax.swing.JButton();
        ntxtfield2 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        edit_sbj_btn1 = new javax.swing.JButton();
        del_sbj_btn1 = new javax.swing.JButton();
        scroll_enroll = new javax.swing.JScrollPane();
        enroll_table = new javax.swing.JTable();
        jLabel53ffff = new javax.swing.JLabel();
        enrollment_panel1 = new javax.swing.JPanel();
        jSeparator10 = new javax.swing.JSeparator();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        scroll_enroll1 = new javax.swing.JScrollPane();
        enroll_table1 = new javax.swing.JTable();
        jLabel53ffff1 = new javax.swing.JLabel();
        rounded_panel1 = new themes.rounded_panel();
        jLabel59 = new javax.swing.JLabel();
        ntxtfield5 = new javax.swing.JTextField();
        edit_sbj_btn7 = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        rounded_panel2 = new themes.rounded_panel();
        jLabel65 = new javax.swing.JLabel();
        ntxtfield6 = new javax.swing.JTextField();
        edit_sbj_btn8 = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        edit_sbj_btn9 = new javax.swing.JButton();
        comboSem = new javax.swing.JComboBox<>();
        txtSY = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        enrollment_panel2 = new javax.swing.JPanel();
        jSeparator11 = new javax.swing.JSeparator();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        edit_sbj_btn5 = new javax.swing.JButton();
        ntxtfield4 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        edit_sbj_btn6 = new javax.swing.JButton();
        del_sbj_btn3 = new javax.swing.JButton();
        scroll_enroll2 = new javax.swing.JScrollPane();
        enroll_table2 = new javax.swing.JTable();
        jLabel53ffff2 = new javax.swing.JLabel();
        student_panel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lbTitle = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        scroll = new javax.swing.JScrollPane();
        student_table = new javax.swing.JTable();
        new_stud_btn = new javax.swing.JButton();
        edit_stud_btn = new javax.swing.JButton();
        del_stud_btn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        student_panel1 = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        lbTitle1 = new javax.swing.JLabel();
        txtSearch1 = new javax.swing.JTextField();
        scroll1 = new javax.swing.JScrollPane();
        student_table1 = new javax.swing.JTable();
        new_stud_btn1 = new javax.swing.JButton();
        edit_stud_btn1 = new javax.swing.JButton();
        del_stud_btn1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        student_panel2 = new javax.swing.JPanel();
        jSeparator9 = new javax.swing.JSeparator();
        lbTitle2 = new javax.swing.JLabel();
        txtSearch2 = new javax.swing.JTextField();
        scroll2 = new javax.swing.JScrollPane();
        student_table2 = new javax.swing.JTable();
        new_stud_btn2 = new javax.swing.JButton();
        edit_stud_btn2 = new javax.swing.JButton();
        del_stud_btn2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        subject_panel = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        lbTitle3 = new javax.swing.JLabel();
        txtSearch3 = new javax.swing.JTextField();
        new_sbj_btn = new javax.swing.JButton();
        edit_sbj_btn = new javax.swing.JButton();
        del_sbj_btn = new javax.swing.JButton();
        scroll3 = new javax.swing.JScrollPane();
        subject_table = new javax.swing.JTable();
        settings_panel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        theme_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel74 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel75 = new javax.swing.JLabel();
        grades_panel_view = new javax.swing.JPanel();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        input_grades_table1 = new javax.swing.JTable();
        jButton28 = new javax.swing.JButton();
        input_field1 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabelName1 = new javax.swing.JLabel();
        jLabelCourse1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidepanel.setRoundBottomLeft(25);
        sidepanel.setRoundBottomRight(25);
        sidepanel.setRoundTopLeft(25);
        sidepanel.setRoundTopRight(25);

        jLabel2.setIcon(new FlatSVGIcon("icons/dwcb_logo.svg"));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel1.setText("Divine Word College of Bangued");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel3.setText("College Registrar Office");

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel7.setText("RECORDS MANAGEMENT");

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setText("OTHER");

        btn1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btn1.setIcon(new FlatSVGIcon("icons/grade.svg"));
        btn1.setText("  Grades");

        btn2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btn2.setIcon(new FlatSVGIcon("icons/down.svg"));
        btn2.setText("View");
        btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn2MouseExited(evt);
            }
        });

        btn3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btn3.setIcon(new FlatSVGIcon("icons/down.svg"));
        btn3.setText("Input / Update");
        btn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn3MouseExited(evt);
            }
        });

        btn5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btn5.setIcon(new FlatSVGIcon("icons/down.svg"));
        btn5.setText("Generate Evaluation");
        btn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn5MouseExited(evt);
            }
        });

        btn6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btn6.setIcon(new FlatSVGIcon("icons/enrollment.svg"));
        btn6.setText("  Enrollment");

        btn7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btn7.setIcon(new FlatSVGIcon("icons/down.svg"));
        btn7.setText("Search");
        btn7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn7MouseExited(evt);
            }
        });

        btn8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btn8.setIcon(new FlatSVGIcon("icons/down.svg"));
        btn8.setText("New");
        btn8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn8MouseExited(evt);
            }
        });

        btn9.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btn9.setIcon(new FlatSVGIcon("icons/down.svg"));
        btn9.setText("Update / Drop");
        btn9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn9MouseExited(evt);
            }
        });

        btn11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btn11.setIcon(new FlatSVGIcon("icons/down.svg"));
        btn11.setText("Search & View");
        btn11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn11MouseExited(evt);
            }
        });

        btn12.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btn12.setIcon(new FlatSVGIcon("icons/down.svg"));
        btn12.setText("New");
        btn12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn12MouseExited(evt);
            }
        });

        btn13.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btn13.setIcon(new FlatSVGIcon("icons/down.svg"));
        btn13.setText("Update / Delete");
        btn13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn13MouseExited(evt);
            }
        });

        btn14.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btn14.setIcon(new FlatSVGIcon("icons/subject.svg"));
        btn14.setText("  Subject List");

        btn15.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btn15.setIcon(new FlatSVGIcon("icons/down.svg"));
        btn15.setText("Add/Edit/Delete");
        btn15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn15MouseExited(evt);
            }
        });

        btn16.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btn16.setIcon(new FlatSVGIcon("icons/settings.svg"));
        btn16.setText("  Settings");
        btn16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn16MouseExited(evt);
            }
        });

        btn17.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btn17.setIcon(new FlatSVGIcon("icons/logout.svg"));
        btn17.setText("  Logout");
        btn17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn17MouseExited(evt);
            }
        });

        btn18.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btn18.setIcon(new FlatSVGIcon("icons/student_1.svg"));
        btn18.setText("  Student Details");

        javax.swing.GroupLayout sidepanelLayout = new javax.swing.GroupLayout(sidepanel);
        sidepanel.setLayout(sidepanelLayout);
        sidepanelLayout.setHorizontalGroup(
            sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidepanelLayout.createSequentialGroup()
                        .addGroup(sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addGroup(sidepanelLayout.createSequentialGroup()
                                .addGroup(sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(sidepanelLayout.createSequentialGroup()
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidepanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sidepanelLayout.createSequentialGroup()
                            .addGroup(sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn6, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                .addComponent(btn14, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                .addComponent(btn16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn18, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                            .addGap(8, 8, 8))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidepanelLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btn15, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn13, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        sidepanelLayout.setVerticalGroup(
            sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn15)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        content_panel.setRoundBottomLeft(25);
        content_panel.setRoundBottomRight(25);
        content_panel.setRoundTopLeft(25);
        content_panel.setRoundTopRight(25);
        content_panel.setLayout(new java.awt.CardLayout());

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel12.setIcon(new FlatSVGIcon("icons/enrollment.svg"));
        jLabel12.setText(" Panel");

        javax.swing.GroupLayout welcome_panelLayout = new javax.swing.GroupLayout(welcome_panel);
        welcome_panel.setLayout(welcome_panelLayout);
        welcome_panelLayout.setHorizontalGroup(
            welcome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcome_panelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(welcome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE))
                .addGap(43, 43, 43))
        );
        welcome_panelLayout.setVerticalGroup(
            welcome_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcome_panelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(620, Short.MAX_VALUE))
        );

        content_panel.add(welcome_panel, "card3");

        jLabel20.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new FlatSVGIcon("icons/grade_1.svg"));
        jLabel20.setText("Grades Panel");

        jButton11.setIcon(new FlatSVGIcon("icons/refresh_btn.svg"));
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new FlatSVGIcon("icons/back_btn.svg"));
        jButton12.setBorder(null);
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel54.setText("Enter Student ID Number:");

        jButton17.setText("Search");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabelName.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabelName.setText("Name: ");

        jLabelCourse.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabelCourse.setText("Course: ");

        input_grades_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Code", "Semester", "School Year", " Tentative Grade (INPUT HERE)", "Final Grade (INPUT HERE)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        input_grades_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(input_grades_table);

        jButton19.setFont(new java.awt.Font("Poppins", 0, 10)); // NOI18N
        jButton19.setIcon(new FlatSVGIcon("icons/delete.svg"));
        jButton19.setText("Delete");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setText("Save");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton18.setIcon(new FlatSVGIcon("icons/help.svg"));
        jButton18.setBorder(null);
        jButton18.setBorderPainted(false);
        jButton18.setContentAreaFilled(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout grades_panel_inputLayout = new javax.swing.GroupLayout(grades_panel_input);
        grades_panel_input.setLayout(grades_panel_inputLayout);
        grades_panel_inputLayout.setHorizontalGroup(
            grades_panel_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grades_panel_inputLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(grades_panel_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(grades_panel_inputLayout.createSequentialGroup()
                        .addGroup(grades_panel_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(grades_panel_inputLayout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(input_field, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(grades_panel_inputLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(grades_panel_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(grades_panel_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3)
                                        .addGroup(grades_panel_inputLayout.createSequentialGroup()
                                            .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(grades_panel_inputLayout.createSequentialGroup()
                                            .addComponent(jLabelCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, grades_panel_inputLayout.createSequentialGroup()
                        .addGroup(grades_panel_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(grades_panel_inputLayout.createSequentialGroup()
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                                .addGap(212, 212, 212)
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator6, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE))
                        .addGap(43, 43, 43))))
        );
        grades_panel_inputLayout.setVerticalGroup(
            grades_panel_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grades_panel_inputLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(grades_panel_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(grades_panel_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(input_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(grades_panel_inputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCourse)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        content_panel.add(grades_panel_input, "card3");

        jButton9.setIcon(new FlatSVGIcon("icons/refresh_btn.svg"));
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new FlatSVGIcon("icons/back_btn.svg"));
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new FlatSVGIcon("icons/enrollment_1.svg"));
        jLabel19.setText("Enrollment Panel");

        edit_sbj_btn2.setFont(new java.awt.Font("Poppins Light", 0, 10)); // NOI18N
        edit_sbj_btn2.setIcon(new FlatSVGIcon("icons/search_1.svg"));
        edit_sbj_btn2.setText("Search");
        edit_sbj_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_sbj_btn2ActionPerformed(evt);
            }
        });

        ntxtfield2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ntxtfield2ActionPerformed(evt);
            }
        });
        ntxtfield2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ntxtfield2KeyReleased(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel50.setText("Enter ID Number:");

        jLabel52.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel52.setText("Name: ");

        jLabel51.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel51.setText("Course: ");

        edit_sbj_btn1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        edit_sbj_btn1.setText("Edit");
        edit_sbj_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_sbj_btn1ActionPerformed(evt);
            }
        });

        del_sbj_btn1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        del_sbj_btn1.setText("Drop");
        del_sbj_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_sbj_btn1ActionPerformed(evt);
            }
        });

        scroll_enroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        enroll_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SELECT", "enroll_id", "COURSE CODE", "DESCRIPTIVE TITLE", "UNITS", "SEMESTER", "SCHOOL YEAR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enroll_table.getTableHeader().setReorderingAllowed(false);
        scroll_enroll.setViewportView(enroll_table);
        if (enroll_table.getColumnModel().getColumnCount() > 0) {
            enroll_table.getColumnModel().getColumn(0).setMaxWidth(50);
            enroll_table.getColumnModel().getColumn(1).setMinWidth(0);
            enroll_table.getColumnModel().getColumn(1).setPreferredWidth(0);
            enroll_table.getColumnModel().getColumn(1).setMaxWidth(0);
            enroll_table.getColumnModel().getColumn(2).setPreferredWidth(150);
            enroll_table.getColumnModel().getColumn(2).setMaxWidth(150);
            enroll_table.getColumnModel().getColumn(4).setMinWidth(70);
            enroll_table.getColumnModel().getColumn(4).setPreferredWidth(70);
            enroll_table.getColumnModel().getColumn(4).setMaxWidth(70);
            enroll_table.getColumnModel().getColumn(5).setPreferredWidth(150);
            enroll_table.getColumnModel().getColumn(5).setMaxWidth(200);
            enroll_table.getColumnModel().getColumn(6).setPreferredWidth(150);
            enroll_table.getColumnModel().getColumn(6).setMaxWidth(150);
        }

        jLabel53ffff.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel53ffff.setText("Enrolled Subjects:");

        javax.swing.GroupLayout enrollment_panelLayout = new javax.swing.GroupLayout(enrollment_panel);
        enrollment_panel.setLayout(enrollment_panelLayout);
        enrollment_panelLayout.setHorizontalGroup(
            enrollment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enrollment_panelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(enrollment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll_enroll)
                    .addGroup(enrollment_panelLayout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                        .addGap(250, 250, 250))
                    .addGroup(enrollment_panelLayout.createSequentialGroup()
                        .addComponent(jLabel53ffff, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edit_sbj_btn1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(del_sbj_btn1))
                    .addGroup(enrollment_panelLayout.createSequentialGroup()
                        .addGroup(enrollment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(enrollment_panelLayout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ntxtfield2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edit_sbj_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(enrollment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator5))
                .addGap(36, 36, 36))
        );
        enrollment_panelLayout.setVerticalGroup(
            enrollment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enrollment_panelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(enrollment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(enrollment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(enrollment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ntxtfield2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel50))
                    .addComponent(edit_sbj_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(enrollment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(enrollment_panelLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(enrollment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(del_sbj_btn1)
                            .addComponent(edit_sbj_btn1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, enrollment_panelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel53ffff)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll_enroll, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );

        enrollment_panelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {edit_sbj_btn2, jLabel50, ntxtfield2});

        content_panel.add(enrollment_panel, "card3");

        jButton13.setIcon(new FlatSVGIcon("icons/refresh_btn.svg"));
        jButton13.setBorder(null);
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setIcon(new FlatSVGIcon("icons/back_btn.svg"));
        jButton14.setBorder(null);
        jButton14.setBorderPainted(false);
        jButton14.setContentAreaFilled(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new FlatSVGIcon("icons/enrollment_1.svg"));
        jLabel21.setText("Enrollment Panel");

        scroll_enroll1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        enroll_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SELECT", "enroll_id", "COURSE CODE", "DESCRIPTIVE TITLE", "UNITS", "SEMESTER", "SCHOOL YEAR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enroll_table1.getTableHeader().setReorderingAllowed(false);
        scroll_enroll1.setViewportView(enroll_table1);
        if (enroll_table1.getColumnModel().getColumnCount() > 0) {
            enroll_table1.getColumnModel().getColumn(0).setMaxWidth(50);
            enroll_table1.getColumnModel().getColumn(1).setMinWidth(0);
            enroll_table1.getColumnModel().getColumn(1).setPreferredWidth(0);
            enroll_table1.getColumnModel().getColumn(1).setMaxWidth(0);
            enroll_table1.getColumnModel().getColumn(2).setPreferredWidth(150);
            enroll_table1.getColumnModel().getColumn(2).setMaxWidth(150);
            enroll_table1.getColumnModel().getColumn(4).setMinWidth(70);
            enroll_table1.getColumnModel().getColumn(4).setPreferredWidth(70);
            enroll_table1.getColumnModel().getColumn(4).setMaxWidth(70);
            enroll_table1.getColumnModel().getColumn(5).setPreferredWidth(150);
            enroll_table1.getColumnModel().getColumn(5).setMaxWidth(200);
            enroll_table1.getColumnModel().getColumn(6).setPreferredWidth(150);
            enroll_table1.getColumnModel().getColumn(6).setMaxWidth(150);
        }

        jLabel53ffff1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel53ffff1.setText("Enrolled Subjects:");

        rounded_panel1.setRoundBottomLeft(25);
        rounded_panel1.setRoundBottomRight(25);
        rounded_panel1.setRoundTopLeft(25);
        rounded_panel1.setRoundTopRight(25);

        jLabel59.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel59.setText("Enter Course Code:");

        ntxtfield5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ntxtfield5ActionPerformed(evt);
            }
        });
        ntxtfield5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ntxtfield5KeyReleased(evt);
            }
        });

        edit_sbj_btn7.setFont(new java.awt.Font("Poppins Light", 0, 10)); // NOI18N
        edit_sbj_btn7.setIcon(new FlatSVGIcon("icons/search_1.svg"));
        edit_sbj_btn7.setText("Search");
        edit_sbj_btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_sbj_btn7ActionPerformed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel60.setText("Course Code:");

        jLabel61.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel61.setText("Descriptive Title: ");

        jLabel62.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel62.setText("Units: ");

        jLabel64.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(105, 105, 105));
        jLabel64.setText("SUBJECT DETAILS");

        javax.swing.GroupLayout rounded_panel1Layout = new javax.swing.GroupLayout(rounded_panel1);
        rounded_panel1.setLayout(rounded_panel1Layout);
        rounded_panel1Layout.setHorizontalGroup(
            rounded_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rounded_panel1Layout.createSequentialGroup()
                .addGroup(rounded_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rounded_panel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(rounded_panel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rounded_panel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(rounded_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rounded_panel1Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ntxtfield5, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edit_sbj_btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rounded_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(62, 62, 62))
        );
        rounded_panel1Layout.setVerticalGroup(
            rounded_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rounded_panel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(rounded_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rounded_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ntxtfield5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel59))
                    .addComponent(edit_sbj_btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel62)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rounded_panel2.setRoundBottomLeft(25);
        rounded_panel2.setRoundBottomRight(25);
        rounded_panel2.setRoundTopLeft(25);
        rounded_panel2.setRoundTopRight(25);

        jLabel65.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel65.setText("Enter ID Number:");

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

        jLabel66.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel66.setText("ID Number: ");

        jLabel67.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel67.setText("Name: ");

        jLabel68.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel68.setText("Course: ");

        jLabel69.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel69.setText("Major:");

        jLabel70.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(105, 105, 105));
        jLabel70.setText("STUDENT DETAILS");

        javax.swing.GroupLayout rounded_panel2Layout = new javax.swing.GroupLayout(rounded_panel2);
        rounded_panel2.setLayout(rounded_panel2Layout);
        rounded_panel2Layout.setHorizontalGroup(
            rounded_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rounded_panel2Layout.createSequentialGroup()
                .addGroup(rounded_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rounded_panel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(rounded_panel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(rounded_panel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(rounded_panel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rounded_panel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(rounded_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rounded_panel2Layout.createSequentialGroup()
                                .addComponent(jLabel65)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ntxtfield6, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edit_sbj_btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(62, 62, 62))
        );
        rounded_panel2Layout.setVerticalGroup(
            rounded_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rounded_panel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(rounded_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rounded_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ntxtfield6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel65))
                    .addComponent(edit_sbj_btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel67)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel68)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel69)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        edit_sbj_btn9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        edit_sbj_btn9.setText("Enroll");
        edit_sbj_btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_sbj_btn9ActionPerformed(evt);
            }
        });

        comboSem.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        comboSem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Semester", "2nd Semester", "Short Term" }));

        txtSY.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N

        jLabel63.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel63.setText("Semester:");

        jLabel71.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        jLabel71.setText("School Year:");

        javax.swing.GroupLayout enrollment_panel1Layout = new javax.swing.GroupLayout(enrollment_panel1);
        enrollment_panel1.setLayout(enrollment_panel1Layout);
        enrollment_panel1Layout.setHorizontalGroup(
            enrollment_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, enrollment_panel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(enrollment_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scroll_enroll1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, enrollment_panel1Layout.createSequentialGroup()
                        .addGroup(enrollment_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rounded_panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel53ffff1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(enrollment_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(enrollment_panel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(rounded_panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(enrollment_panel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(edit_sbj_btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(enrollment_panel1Layout.createSequentialGroup()
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138)
                        .addGroup(enrollment_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, enrollment_panel1Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboSem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, enrollment_panel1Layout.createSequentialGroup()
                                .addComponent(jLabel71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSY, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(36, 36, 36))
        );

        enrollment_panel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboSem, txtSY});

        enrollment_panel1Layout.setVerticalGroup(
            enrollment_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enrollment_panel1Layout.createSequentialGroup()
                .addGroup(enrollment_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(enrollment_panel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(enrollment_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboSem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel63))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(enrollment_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel71)))
                    .addGroup(enrollment_panel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(enrollment_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(enrollment_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(enrollment_panel1Layout.createSequentialGroup()
                        .addComponent(rounded_panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel53ffff1)
                        .addGap(7, 7, 7))
                    .addGroup(enrollment_panel1Layout.createSequentialGroup()
                        .addComponent(rounded_panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(edit_sbj_btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addComponent(scroll_enroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        enrollment_panel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboSem, txtSY});

        content_panel.add(enrollment_panel1, "card3");

        jButton15.setIcon(new FlatSVGIcon("icons/refresh_btn.svg"));
        jButton15.setBorder(null);
        jButton15.setBorderPainted(false);
        jButton15.setContentAreaFilled(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setIcon(new FlatSVGIcon("icons/back_btn.svg"));
        jButton16.setBorder(null);
        jButton16.setBorderPainted(false);
        jButton16.setContentAreaFilled(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new FlatSVGIcon("icons/enrollment_1.svg"));
        jLabel22.setText("Enrollment Panel");

        edit_sbj_btn5.setFont(new java.awt.Font("Poppins Light", 0, 10)); // NOI18N
        edit_sbj_btn5.setIcon(new FlatSVGIcon("icons/search_1.svg"));
        edit_sbj_btn5.setText("Search");
        edit_sbj_btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_sbj_btn5ActionPerformed(evt);
            }
        });

        ntxtfield4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ntxtfield4ActionPerformed(evt);
            }
        });
        ntxtfield4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ntxtfield4KeyReleased(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel56.setText("Enter ID Number:");

        jLabel57.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel57.setText("Name: ");

        jLabel58.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel58.setText("Course: ");

        edit_sbj_btn6.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        edit_sbj_btn6.setText("Edit");
        edit_sbj_btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_sbj_btn6ActionPerformed(evt);
            }
        });

        del_sbj_btn3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        del_sbj_btn3.setText("Drop");
        del_sbj_btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_sbj_btn3ActionPerformed(evt);
            }
        });

        scroll_enroll2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        enroll_table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SELECT", "enroll_id", "COURSE CODE", "DESCRIPTIVE TITLE", "UNITS", "SEMESTER", "SCHOOL YEAR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enroll_table2.getTableHeader().setReorderingAllowed(false);
        scroll_enroll2.setViewportView(enroll_table2);
        if (enroll_table2.getColumnModel().getColumnCount() > 0) {
            enroll_table2.getColumnModel().getColumn(0).setMaxWidth(50);
            enroll_table2.getColumnModel().getColumn(1).setMinWidth(0);
            enroll_table2.getColumnModel().getColumn(1).setPreferredWidth(0);
            enroll_table2.getColumnModel().getColumn(1).setMaxWidth(0);
            enroll_table2.getColumnModel().getColumn(2).setPreferredWidth(150);
            enroll_table2.getColumnModel().getColumn(2).setMaxWidth(150);
            enroll_table2.getColumnModel().getColumn(4).setMinWidth(70);
            enroll_table2.getColumnModel().getColumn(4).setPreferredWidth(70);
            enroll_table2.getColumnModel().getColumn(4).setMaxWidth(70);
            enroll_table2.getColumnModel().getColumn(5).setPreferredWidth(150);
            enroll_table2.getColumnModel().getColumn(5).setMaxWidth(200);
            enroll_table2.getColumnModel().getColumn(6).setPreferredWidth(150);
            enroll_table2.getColumnModel().getColumn(6).setMaxWidth(150);
        }

        jLabel53ffff2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel53ffff2.setText("Enrolled Subjects:");

        javax.swing.GroupLayout enrollment_panel2Layout = new javax.swing.GroupLayout(enrollment_panel2);
        enrollment_panel2.setLayout(enrollment_panel2Layout);
        enrollment_panel2Layout.setHorizontalGroup(
            enrollment_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enrollment_panel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(enrollment_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll_enroll2)
                    .addGroup(enrollment_panel2Layout.createSequentialGroup()
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                        .addGap(250, 250, 250))
                    .addGroup(enrollment_panel2Layout.createSequentialGroup()
                        .addComponent(jLabel53ffff2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edit_sbj_btn6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(del_sbj_btn3))
                    .addGroup(enrollment_panel2Layout.createSequentialGroup()
                        .addGroup(enrollment_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(enrollment_panel2Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ntxtfield4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edit_sbj_btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(enrollment_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator11))
                .addGap(36, 36, 36))
        );
        enrollment_panel2Layout.setVerticalGroup(
            enrollment_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enrollment_panel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(enrollment_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(enrollment_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(enrollment_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ntxtfield4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel56))
                    .addComponent(edit_sbj_btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(enrollment_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(enrollment_panel2Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(enrollment_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(del_sbj_btn3)
                            .addComponent(edit_sbj_btn6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, enrollment_panel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel53ffff2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll_enroll2, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );

        content_panel.add(enrollment_panel2, "card3");

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new FlatSVGIcon("icons/student_2.svg"));
        jLabel6.setText("Student Panel");

        lbTitle.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        lbTitle.setText("STUDENT RECORDS");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        student_table.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        student_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SELECT", "ID NUMBER", "LAST NAME", "FIRST NAME", "MIDDLE NAME", "COURSE", "MAJOR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        student_table.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(student_table);
        if (student_table.getColumnModel().getColumnCount() > 0) {
            student_table.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        new_stud_btn.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        new_stud_btn.setText("New");
        new_stud_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_stud_btnActionPerformed(evt);
            }
        });

        edit_stud_btn.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        edit_stud_btn.setText("Edit");
        edit_stud_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_stud_btnActionPerformed(evt);
            }
        });

        del_stud_btn.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        del_stud_btn.setText("Delete");
        del_stud_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_stud_btnActionPerformed(evt);
            }
        });

        jButton1.setIcon(new FlatSVGIcon("icons/back_btn.svg"));
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new FlatSVGIcon("icons/refresh_btn.svg"));
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout student_panelLayout = new javax.swing.GroupLayout(student_panel);
        student_panel.setLayout(student_panelLayout);
        student_panelLayout.setHorizontalGroup(
            student_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(student_panelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(student_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(student_panelLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(280, 280, 280))
                    .addGroup(student_panelLayout.createSequentialGroup()
                        .addGroup(student_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
                            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
                            .addGroup(student_panelLayout.createSequentialGroup()
                                .addGroup(student_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(new_stud_btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edit_stud_btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(del_stud_btn)))
                        .addGap(43, 43, 43))))
        );

        student_panelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        student_panelLayout.setVerticalGroup(
            student_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(student_panelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(student_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTitle)
                .addGap(9, 9, 9)
                .addGroup(student_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(del_stud_btn)
                    .addComponent(edit_stud_btn)
                    .addComponent(new_stud_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );

        student_panelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        content_panel.add(student_panel, "card3");

        lbTitle1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        lbTitle1.setText("STUDENT RECORDS");

        txtSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch1KeyReleased(evt);
            }
        });

        scroll1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        student_table1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        student_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SELECT", "ID NUMBER", "LAST NAME", "FIRST NAME", "MIDDLE NAME", "COURSE", "MAJOR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        student_table1.getTableHeader().setReorderingAllowed(false);
        scroll1.setViewportView(student_table1);
        if (student_table1.getColumnModel().getColumnCount() > 0) {
            student_table1.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        new_stud_btn1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        new_stud_btn1.setText("New");
        new_stud_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_stud_btn1ActionPerformed(evt);
            }
        });

        edit_stud_btn1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        edit_stud_btn1.setText("Edit");
        edit_stud_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_stud_btn1ActionPerformed(evt);
            }
        });

        del_stud_btn1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        del_stud_btn1.setText("Delete");
        del_stud_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_stud_btn1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new FlatSVGIcon("icons/back_btn.svg"));
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new FlatSVGIcon("icons/refresh_btn.svg"));
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new FlatSVGIcon("icons/student_2.svg"));
        jLabel13.setText("Student Panel");

        javax.swing.GroupLayout student_panel1Layout = new javax.swing.GroupLayout(student_panel1);
        student_panel1.setLayout(student_panel1Layout);
        student_panel1Layout.setHorizontalGroup(
            student_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(student_panel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(student_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(student_panel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(279, 279, 279))
                    .addGroup(student_panel1Layout.createSequentialGroup()
                        .addGroup(student_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
                            .addComponent(scroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
                            .addGroup(student_panel1Layout.createSequentialGroup()
                                .addGroup(student_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(new_stud_btn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edit_stud_btn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(del_stud_btn1)))
                        .addGap(43, 43, 43))))
        );
        student_panel1Layout.setVerticalGroup(
            student_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(student_panel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(student_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTitle1)
                .addGap(9, 9, 9)
                .addGroup(student_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(del_stud_btn1)
                    .addComponent(edit_stud_btn1)
                    .addComponent(new_stud_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );

        content_panel.add(student_panel1, "card3");

        lbTitle2.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        lbTitle2.setText("STUDENT RECORDS");

        txtSearch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch2KeyReleased(evt);
            }
        });

        scroll2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        student_table2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        student_table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SELECT", "ID NUMBER", "LAST NAME", "FIRST NAME", "MIDDLE NAME", "COURSE", "MAJOR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        student_table2.getTableHeader().setReorderingAllowed(false);
        scroll2.setViewportView(student_table2);
        if (student_table2.getColumnModel().getColumnCount() > 0) {
            student_table2.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        new_stud_btn2.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        new_stud_btn2.setText("New");
        new_stud_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_stud_btn2ActionPerformed(evt);
            }
        });

        edit_stud_btn2.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        edit_stud_btn2.setText("Edit");
        edit_stud_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_stud_btn2ActionPerformed(evt);
            }
        });

        del_stud_btn2.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        del_stud_btn2.setText("Delete");
        del_stud_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_stud_btn2ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new FlatSVGIcon("icons/back_btn.svg"));
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new FlatSVGIcon("icons/refresh_btn.svg"));
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new FlatSVGIcon("icons/student_2.svg"));
        jLabel16.setText("Student Panel");

        javax.swing.GroupLayout student_panel2Layout = new javax.swing.GroupLayout(student_panel2);
        student_panel2.setLayout(student_panel2Layout);
        student_panel2Layout.setHorizontalGroup(
            student_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(student_panel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(student_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(student_panel2Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                        .addGap(281, 281, 281))
                    .addGroup(student_panel2Layout.createSequentialGroup()
                        .addGroup(student_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
                            .addComponent(scroll2, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
                            .addGroup(student_panel2Layout.createSequentialGroup()
                                .addGroup(student_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(new_stud_btn2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edit_stud_btn2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(del_stud_btn2)))
                        .addGap(43, 43, 43))))
        );
        student_panel2Layout.setVerticalGroup(
            student_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(student_panel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(student_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTitle2)
                .addGap(9, 9, 9)
                .addGroup(student_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(del_stud_btn2)
                    .addComponent(edit_stud_btn2)
                    .addComponent(new_stud_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll2, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );

        content_panel.add(student_panel2, "card3");

        jButton7.setIcon(new FlatSVGIcon("icons/back_btn.svg"));
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new FlatSVGIcon("icons/refresh_btn.svg"));
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new FlatSVGIcon("icons/subject_1.svg"));
        jLabel18.setText("Subject Panel");

        lbTitle3.setText("SUBJECT LIST");

        txtSearch3.setMaximumSize(new java.awt.Dimension(306, 2147483647));
        txtSearch3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch3KeyReleased(evt);
            }
        });

        new_sbj_btn.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        new_sbj_btn.setText("New");
        new_sbj_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_sbj_btnActionPerformed(evt);
            }
        });

        edit_sbj_btn.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        edit_sbj_btn.setText("Edit");
        edit_sbj_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_sbj_btnActionPerformed(evt);
            }
        });

        del_sbj_btn.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        del_sbj_btn.setText("Delete");
        del_sbj_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_sbj_btnActionPerformed(evt);
            }
        });

        scroll3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        subject_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SELECT", "COURSE CODE", "DESCRIPTIVE TITLE", "UNITS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        subject_table.getTableHeader().setReorderingAllowed(false);
        scroll3.setViewportView(subject_table);
        if (subject_table.getColumnModel().getColumnCount() > 0) {
            subject_table.getColumnModel().getColumn(0).setMaxWidth(50);
            subject_table.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        javax.swing.GroupLayout subject_panelLayout = new javax.swing.GroupLayout(subject_panel);
        subject_panel.setLayout(subject_panelLayout);
        subject_panelLayout.setHorizontalGroup(
            subject_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subject_panelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(subject_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subject_panelLayout.createSequentialGroup()
                        .addComponent(lbTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(subject_panelLayout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                        .addGap(279, 279, 279))
                    .addGroup(subject_panelLayout.createSequentialGroup()
                        .addComponent(jSeparator4)
                        .addGap(43, 43, 43))
                    .addGroup(subject_panelLayout.createSequentialGroup()
                        .addGroup(subject_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(subject_panelLayout.createSequentialGroup()
                                .addComponent(txtSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(new_sbj_btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edit_sbj_btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(del_sbj_btn))
                            .addComponent(scroll3))
                        .addGap(37, 37, 37))))
        );

        subject_panelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {del_sbj_btn, edit_sbj_btn, new_sbj_btn});

        subject_panelLayout.setVerticalGroup(
            subject_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subject_panelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(subject_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTitle3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subject_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(del_sbj_btn)
                    .addComponent(edit_sbj_btn)
                    .addComponent(new_sbj_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll3, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        subject_panelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {del_sbj_btn, edit_sbj_btn, new_sbj_btn});

        content_panel.add(subject_panel, "card3");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel4.setIcon(new FlatSVGIcon("icons/settings_1.svg"));
        jLabel4.setText("Settings Panel");

        theme_btn.setIcon(new FlatSVGIcon("icons/toggle_off.svg"));
        theme_btn.setBorderPainted(false);
        theme_btn.setContentAreaFilled(false);
        theme_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theme_btnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setText("Toggle Dark Mode");

        jLabel73.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(105, 105, 105));
        jLabel73.setText("THEME");

        jLabel74.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(105, 105, 105));
        jLabel74.setText("USER ACCOUNT SETTINGS");

        jLabel75.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(105, 105, 105));
        jLabel75.setText("ABOUT");

        javax.swing.GroupLayout settings_panelLayout = new javax.swing.GroupLayout(settings_panel);
        settings_panel.setLayout(settings_panelLayout);
        settings_panelLayout.setHorizontalGroup(
            settings_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settings_panelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(theme_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(settings_panelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(settings_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settings_panelLayout.createSequentialGroup()
                        .addGroup(settings_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(settings_panelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(settings_panelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settings_panelLayout.createSequentialGroup()
                        .addGroup(settings_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator13, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, settings_panelLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE))
                        .addGap(42, 42, 42))))
        );
        settings_panelLayout.setVerticalGroup(
            settings_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settings_panelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel73)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(settings_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(theme_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel74)
                .addGap(147, 147, 147)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel75)
                .addContainerGap(338, Short.MAX_VALUE))
        );

        content_panel.add(settings_panel, "card2");

        jLabel23.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new FlatSVGIcon("icons/grade_1.svg"));
        jLabel23.setText("Grades Panel");

        jButton21.setIcon(new FlatSVGIcon("icons/refresh_btn.svg"));
        jButton21.setBorder(null);
        jButton21.setBorderPainted(false);
        jButton21.setContentAreaFilled(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setIcon(new FlatSVGIcon("icons/back_btn.svg"));
        jButton22.setBorder(null);
        jButton22.setBorderPainted(false);
        jButton22.setContentAreaFilled(false);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton27.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton27.setText("Generate Evaluation");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        input_grades_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COURSE CODE", "SEMESTER", "SCHOOL YEAR", " TENTATIVE", "GRADE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        input_grades_table1.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(input_grades_table1);

        jButton28.setText("Search");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel72.setText("Enter Student ID Number:");

        jLabelName1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabelName1.setText("Name: ");

        jLabelCourse1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabelCourse1.setText("Course: ");

        javax.swing.GroupLayout grades_panel_viewLayout = new javax.swing.GroupLayout(grades_panel_view);
        grades_panel_view.setLayout(grades_panel_viewLayout);
        grades_panel_viewLayout.setHorizontalGroup(
            grades_panel_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grades_panel_viewLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(grades_panel_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(grades_panel_viewLayout.createSequentialGroup()
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                        .addGap(279, 279, 279))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, grades_panel_viewLayout.createSequentialGroup()
                        .addComponent(jSeparator12, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
                        .addGap(43, 43, 43))
                    .addGroup(grades_panel_viewLayout.createSequentialGroup()
                        .addGroup(grades_panel_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4))
                        .addGap(34, 34, 34))))
            .addGroup(grades_panel_viewLayout.createSequentialGroup()
                .addGroup(grades_panel_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(grades_panel_viewLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabelCourse1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, grades_panel_viewLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(grades_panel_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(grades_panel_viewLayout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(input_field1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelName1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        grades_panel_viewLayout.setVerticalGroup(
            grades_panel_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grades_panel_viewLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(grades_panel_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(grades_panel_viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(input_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton28))
                .addGap(5, 5, 5)
                .addComponent(jLabelName1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCourse1)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        content_panel.add(grades_panel_view, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sidepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sidepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(content_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void theme_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theme_btnActionPerformed
        // TODO add your handling code here:
        toggleTheme();
    }//GEN-LAST:event_theme_btnActionPerformed

    private void btn2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2MouseEntered
        // TODO add your handling code here:
        btn2.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_btn2MouseEntered

    private void btn2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2MouseExited
        // TODO add your handling code here:
        Color colorFromJLabel1 = jLabel1.getForeground(); // Get the color from jLabel1
        btn2.setForeground(colorFromJLabel1);
    }//GEN-LAST:event_btn2MouseExited

    private void btn3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3MouseEntered
        // TODO add your handling code here:
        btn3.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_btn3MouseEntered

    private void btn3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3MouseExited
        // TODO add your handling code here:
        Color colorFromJLabel1 = jLabel1.getForeground(); // Get the color from jLabel1
        btn3.setForeground(colorFromJLabel1);
    }//GEN-LAST:event_btn3MouseExited

    private void btn5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn5MouseEntered
        // TODO add your handling code here:
        btn5.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_btn5MouseEntered

    private void btn5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn5MouseExited
        // TODO add your handling code here:
        Color colorFromJLabel1 = jLabel1.getForeground(); // Get the color from jLabel1
        btn5.setForeground(colorFromJLabel1);
    }//GEN-LAST:event_btn5MouseExited

    private void btn7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn7MouseEntered
        // TODO add your handling code here:
        btn7.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_btn7MouseEntered

    private void btn7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn7MouseExited
        // TODO add your handling code here:
        Color colorFromJLabel1 = jLabel1.getForeground(); // Get the color from jLabel1
        btn7.setForeground(colorFromJLabel1);
    }//GEN-LAST:event_btn7MouseExited

    private void btn8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn8MouseEntered
        // TODO add your handling code here:
        btn8.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_btn8MouseEntered

    private void btn8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn8MouseExited
        // TODO add your handling code here:
        Color colorFromJLabel1 = jLabel1.getForeground(); // Get the color from jLabel1
        btn8.setForeground(colorFromJLabel1);
    }//GEN-LAST:event_btn8MouseExited

    private void btn9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn9MouseEntered
        // TODO add your handling code here:
        btn9.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_btn9MouseEntered

    private void btn9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn9MouseExited
        // TODO add your handling code here:
        Color colorFromJLabel1 = jLabel1.getForeground(); // Get the color from jLabel1
        btn9.setForeground(colorFromJLabel1);
    }//GEN-LAST:event_btn9MouseExited

    private void btn11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn11MouseEntered
        // TODO add your handling code here:
        btn11.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_btn11MouseEntered

    private void btn11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn11MouseExited
        // TODO add your handling code here:
        Color colorFromJLabel1 = jLabel1.getForeground(); // Get the color from jLabel1
        btn11.setForeground(colorFromJLabel1);
    }//GEN-LAST:event_btn11MouseExited

    private void btn12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn12MouseEntered
        // TODO add your handling code here:
        btn12.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_btn12MouseEntered

    private void btn12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn12MouseExited
        // TODO add your handling code here:
        Color colorFromJLabel1 = jLabel1.getForeground(); // Get the color from jLabel1
        btn12.setForeground(colorFromJLabel1);
    }//GEN-LAST:event_btn12MouseExited

    private void btn13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn13MouseEntered
        // TODO add your handling code here:
        btn13.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_btn13MouseEntered

    private void btn13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn13MouseExited
        // TODO add your handling code here:
        Color colorFromJLabel1 = jLabel1.getForeground(); // Get the color from jLabel1
        btn13.setForeground(colorFromJLabel1);
    }//GEN-LAST:event_btn13MouseExited

    private void btn15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn15MouseExited
        // TODO add your handling code here:
        Color colorFromJLabel1 = jLabel1.getForeground(); // Get the color from jLabel1
        btn15.setForeground(colorFromJLabel1);
    }//GEN-LAST:event_btn15MouseExited

    private void btn15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn15MouseEntered
        // TODO add your handling code here:
        btn15.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_btn15MouseEntered

    private void btn16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn16MouseEntered
        // TODO add your handling code here:
        btn16.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_btn16MouseEntered

    private void btn16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn16MouseExited
        // TODO add your handling code here:
        Color colorFromJLabel1 = jLabel1.getForeground(); // Get the color from jLabel1
        btn16.setForeground(colorFromJLabel1);
    }//GEN-LAST:event_btn16MouseExited

    private void btn17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn17MouseEntered
        // TODO add your handling code here:
        btn17.setForeground(new Color(0, 153, 255));
    }//GEN-LAST:event_btn17MouseEntered

    private void btn17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn17MouseExited
        // TODO add your handling code here:
        Color colorFromJLabel1 = jLabel1.getForeground(); // Get the color from jLabel1
        btn17.setForeground(colorFromJLabel1);
    }//GEN-LAST:event_btn17MouseExited

    private void btn16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn16MouseClicked
        // TODO add your handling code here:
        content_panel.removeAll();
        content_panel.add(settings_panel);
        content_panel.repaint();
        content_panel.revalidate();
    }//GEN-LAST:event_btn16MouseClicked

    private void btn11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn11MouseClicked
        // TODO add your handling code here:
        content_panel.removeAll();
        content_panel.add(student_panel);
        SwingUtilities.updateComponentTreeUI(content_panel);
        content_panel.repaint();
        content_panel.revalidate();
    }//GEN-LAST:event_btn11MouseClicked

    private void btn7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn7MouseClicked
        // TODO add your handling code here:
        content_panel.removeAll();
        content_panel.add(enrollment_panel);
        SwingUtilities.updateComponentTreeUI(content_panel);
        content_panel.repaint();
        content_panel.revalidate();
    }//GEN-LAST:event_btn7MouseClicked

    private void btn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2MouseClicked
        // TODO add your handling code here:
        content_panel.removeAll();
        content_panel.add(grades_panel_view);
        SwingUtilities.updateComponentTreeUI(content_panel);
        content_panel.repaint();
        content_panel.revalidate();
    }//GEN-LAST:event_btn2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        content_panel.removeAll();
        content_panel.add(welcome_panel);
        SwingUtilities.updateComponentTreeUI(content_panel);
        content_panel.repaint();
        content_panel.revalidate();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btn15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn15MouseClicked
        // TODO add your handling code here:
        content_panel.removeAll();
        content_panel.add(subject_panel);
        SwingUtilities.updateComponentTreeUI(content_panel);
        content_panel.repaint();
        content_panel.revalidate();
    }//GEN-LAST:event_btn15MouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        searchData(txtSearch.getText().trim());

    }//GEN-LAST:event_txtSearchKeyReleased

    private void new_stud_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_stud_btnActionPerformed
        new_student();
    }//GEN-LAST:event_new_stud_btnActionPerformed

    private void edit_stud_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_stud_btnActionPerformed
        edit_student();
    }//GEN-LAST:event_edit_stud_btnActionPerformed

    private void del_stud_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_stud_btnActionPerformed
        delete_student();
    }//GEN-LAST:event_del_stud_btnActionPerformed

    private void txtSearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyReleased
        // TODO add your handling code here:
        searchData(txtSearch1.getText().trim());
    }//GEN-LAST:event_txtSearch1KeyReleased

    private void new_stud_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_stud_btn1ActionPerformed
        // TODO add your handling code here:
        new_student();
    }//GEN-LAST:event_new_stud_btn1ActionPerformed

    private void edit_stud_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_stud_btn1ActionPerformed
        // TODO add your handling code here:
        edit_student1();
    }//GEN-LAST:event_edit_stud_btn1ActionPerformed

    private void del_stud_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_stud_btn1ActionPerformed
        // TODO add your handling code here:
        delete_student1();
    }//GEN-LAST:event_del_stud_btn1ActionPerformed

    private void btn12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn12MouseClicked
        // TODO add your handling code here:
        content_panel.removeAll();
        content_panel.add(student_panel1);
        SwingUtilities.updateComponentTreeUI(content_panel);
        content_panel.repaint();
        content_panel.revalidate();
        new_student();
    }//GEN-LAST:event_btn12MouseClicked

    private void txtSearch2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch2KeyReleased
        // TODO add your handling code here:
        searchData(txtSearch2.getText().trim());
    }//GEN-LAST:event_txtSearch2KeyReleased

    private void new_stud_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_stud_btn2ActionPerformed
        // TODO add your handling code here:
        new_student();
    }//GEN-LAST:event_new_stud_btn2ActionPerformed

    private void edit_stud_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_stud_btn2ActionPerformed
        // TODO add your handling code here:
        edit_student2();
    }//GEN-LAST:event_edit_stud_btn2ActionPerformed

    private void del_stud_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_stud_btn2ActionPerformed
        // TODO add your handling code here:
        delete_student2();
    }//GEN-LAST:event_del_stud_btn2ActionPerformed

    private void btn13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn13MouseClicked
        // TODO add your handling code here:
        content_panel.removeAll();
        content_panel.add(student_panel2);
        SwingUtilities.updateComponentTreeUI(content_panel);
        content_panel.repaint();
        content_panel.revalidate();

        MessageAlerts.getInstance().showMessage("Select student to edit or delete", " ");

        /*Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_RIGHT, "SELECT STUDENT TO EDIT OR DELETE");
        JOptionPane.showMessageDialog(this, "SELECT STUDENT TO EDIT OR DELETE", "Information", JOptionPane.INFORMATION_MESSAGE);
        Notifications.getInstance().show(Notifications.Type.INFO, "SELECT STUDENT TO EDIT OR DELETE");*/
    }//GEN-LAST:event_btn13MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        searchAndLoadData();
        loadGrades();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void txtSearch3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch3KeyReleased
        // TODO add your handling code here:
        searchDataSubject(txtSearch3.getText().trim());

    }//GEN-LAST:event_txtSearch3KeyReleased

    private void new_sbj_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_sbj_btnActionPerformed
        // TODO add your handling code here:
        new_subject();

    }//GEN-LAST:event_new_sbj_btnActionPerformed

    private void edit_sbj_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_sbj_btnActionPerformed
        // TODO add your handling code here:
        edit_subject();

    }//GEN-LAST:event_edit_sbj_btnActionPerformed

    private void del_sbj_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_sbj_btnActionPerformed
        // TODO add your handling code here:
        delete_subject();

    }//GEN-LAST:event_del_sbj_btnActionPerformed

    private void btn5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn5MouseClicked
        // TODO add your handling code here:
        IT_form frame2 = new IT_form();
        frame2.setVisible(true);
    }//GEN-LAST:event_btn5MouseClicked

    private void edit_sbj_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_sbj_btn2ActionPerformed
        // TODO add your handling code here:  
        searchDataEnroll(ntxtfield2.getText().trim());
        enroll_name();

    }//GEN-LAST:event_edit_sbj_btn2ActionPerformed

    private void ntxtfield2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntxtfield2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ntxtfield2ActionPerformed

    private void ntxtfield2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ntxtfield2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ntxtfield2KeyReleased

    private void edit_sbj_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_sbj_btn1ActionPerformed
        // TODO add your handling code here:
        edit_enroll();

    }//GEN-LAST:event_edit_sbj_btn1ActionPerformed

    private void del_sbj_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_sbj_btn1ActionPerformed
        // TODO add your handling code here:
        delete_enroll();

    }//GEN-LAST:event_del_sbj_btn1ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void edit_sbj_btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_sbj_btn5ActionPerformed
        // TODO add your handling code here:
        searchDataEnroll2(ntxtfield4.getText().trim());
        enroll_name2();
    }//GEN-LAST:event_edit_sbj_btn5ActionPerformed

    private void ntxtfield4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntxtfield4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ntxtfield4ActionPerformed

    private void ntxtfield4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ntxtfield4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ntxtfield4KeyReleased

    private void edit_sbj_btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_sbj_btn6ActionPerformed
        // TODO add your handling code here:
        edit_enroll2();
    }//GEN-LAST:event_edit_sbj_btn6ActionPerformed

    private void del_sbj_btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_sbj_btn3ActionPerformed
        // TODO add your handling code here:
        delete_enroll2();
    }//GEN-LAST:event_del_sbj_btn3ActionPerformed

    private void btn8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn8MouseClicked
        // TODO add your handling code here:
        content_panel.removeAll();
        content_panel.add(enrollment_panel1);
        SwingUtilities.updateComponentTreeUI(content_panel);
        content_panel.repaint();
        content_panel.revalidate();
    }//GEN-LAST:event_btn8MouseClicked

    private void btn9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn9MouseClicked
        // TODO add your handling code here:
        content_panel.removeAll();
        content_panel.add(enrollment_panel2);
        SwingUtilities.updateComponentTreeUI(content_panel);
        content_panel.repaint();
        content_panel.revalidate();

        MessageAlerts.getInstance().showMessage("INFORMATION", "Enter Student ID Number then Select Enrollment Record to Edit/Drop ");
    }//GEN-LAST:event_btn9MouseClicked

    private void ntxtfield5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntxtfield5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ntxtfield5ActionPerformed

    private void ntxtfield5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ntxtfield5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ntxtfield5KeyReleased

    private void edit_sbj_btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_sbj_btn7ActionPerformed
        // TODO add your handling code here:
        new_enroll_subject();
    }//GEN-LAST:event_edit_sbj_btn7ActionPerformed

    private void ntxtfield6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntxtfield6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ntxtfield6ActionPerformed

    private void ntxtfield6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ntxtfield6KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ntxtfield6KeyReleased

    private void edit_sbj_btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_sbj_btn8ActionPerformed
        // TODO add your handling code here:
        new_enroll_student();
        searchDataEnroll1(ntxtfield6.getText().trim());
    }//GEN-LAST:event_edit_sbj_btn8ActionPerformed

    private void edit_sbj_btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_sbj_btn9ActionPerformed
        // TODO add your handling code here:\
        new_enroll();
        searchDataEnroll1(ntxtfield6.getText().trim());
    }//GEN-LAST:event_edit_sbj_btn9ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        searchAndLoadData();
        loadGrades();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        delete_grade();
        loadGrades();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        input_grades();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void btn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3MouseClicked
        // TODO add your handling code here:
        content_panel.removeAll();
        content_panel.add(grades_panel_input);
        SwingUtilities.updateComponentTreeUI(content_panel);
        content_panel.repaint();
        content_panel.revalidate();
    }//GEN-LAST:event_btn3MouseClicked

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        MessageAlerts.getInstance().showMessage("HOW TO USE", "Input grades directly into the table then click save");
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:new IT_form1().setVisible(true);
        String textValue = input_field1.getText();  // Get text from JTextField
        String course = jLabelCourse1.getText();
        System.out.println(course);

        // Create an instance of IT_form1
        if (course.equals("Course: BSIT")) {
            IT_form frame2 = new IT_form();
            frame2.setTextValue(textValue);  // Pass the text to IT_form1

            // Show the IT_form1 JFrame
            frame2.setVisible(true);
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, "EVALUATION UNAVAILABLE");
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        searchAndLoadData1();
        loadGradesWithValues();
    }//GEN-LAST:event_jButton28ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 12));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn1;
    private javax.swing.JLabel btn11;
    private javax.swing.JLabel btn12;
    private javax.swing.JLabel btn13;
    private javax.swing.JLabel btn14;
    private javax.swing.JLabel btn15;
    private javax.swing.JLabel btn16;
    private javax.swing.JLabel btn17;
    private javax.swing.JLabel btn18;
    private javax.swing.JLabel btn2;
    private javax.swing.JLabel btn3;
    private javax.swing.JLabel btn5;
    private javax.swing.JLabel btn6;
    private javax.swing.JLabel btn7;
    private javax.swing.JLabel btn8;
    private javax.swing.JLabel btn9;
    private javax.swing.JComboBox<Object> comboSem;
    private themes.rounded_panel content_panel;
    private javax.swing.JButton del_sbj_btn;
    private javax.swing.JButton del_sbj_btn1;
    private javax.swing.JButton del_sbj_btn3;
    private javax.swing.JButton del_stud_btn;
    private javax.swing.JButton del_stud_btn1;
    private javax.swing.JButton del_stud_btn2;
    private javax.swing.JButton edit_sbj_btn;
    private javax.swing.JButton edit_sbj_btn1;
    private javax.swing.JButton edit_sbj_btn2;
    private javax.swing.JButton edit_sbj_btn5;
    private javax.swing.JButton edit_sbj_btn6;
    private javax.swing.JButton edit_sbj_btn7;
    private javax.swing.JButton edit_sbj_btn8;
    private javax.swing.JButton edit_sbj_btn9;
    private javax.swing.JButton edit_stud_btn;
    private javax.swing.JButton edit_stud_btn1;
    private javax.swing.JButton edit_stud_btn2;
    private javax.swing.JTable enroll_table;
    private javax.swing.JTable enroll_table1;
    private javax.swing.JTable enroll_table2;
    private javax.swing.JPanel enrollment_panel;
    private javax.swing.JPanel enrollment_panel1;
    private javax.swing.JPanel enrollment_panel2;
    private javax.swing.JPanel grades_panel_input;
    private javax.swing.JPanel grades_panel_view;
    private javax.swing.JTextField input_field;
    private javax.swing.JTextField input_field1;
    private javax.swing.JTable input_grades_table;
    private javax.swing.JTable input_grades_table1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53ffff;
    private javax.swing.JLabel jLabel53ffff1;
    private javax.swing.JLabel jLabel53ffff2;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCourse;
    private javax.swing.JLabel jLabelCourse1;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelName1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTitle1;
    private javax.swing.JLabel lbTitle2;
    private javax.swing.JLabel lbTitle3;
    private javax.swing.JButton new_sbj_btn;
    private javax.swing.JButton new_stud_btn;
    private javax.swing.JButton new_stud_btn1;
    private javax.swing.JButton new_stud_btn2;
    private javax.swing.JTextField ntxtfield2;
    private javax.swing.JTextField ntxtfield4;
    private javax.swing.JTextField ntxtfield5;
    private javax.swing.JTextField ntxtfield6;
    private themes.rounded_panel rounded_panel1;
    private themes.rounded_panel rounded_panel2;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JScrollPane scroll3;
    private javax.swing.JScrollPane scroll_enroll;
    private javax.swing.JScrollPane scroll_enroll1;
    private javax.swing.JScrollPane scroll_enroll2;
    private javax.swing.JPanel settings_panel;
    private themes.rounded_panel sidepanel;
    private javax.swing.JPanel student_panel;
    private javax.swing.JPanel student_panel1;
    private javax.swing.JPanel student_panel2;
    private javax.swing.JTable student_table;
    private javax.swing.JTable student_table1;
    private javax.swing.JTable student_table2;
    private javax.swing.JPanel subject_panel;
    private javax.swing.JTable subject_table;
    private javax.swing.JButton theme_btn;
    private javax.swing.JTextField txtSY;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearch1;
    private javax.swing.JTextField txtSearch2;
    private javax.swing.JTextField txtSearch3;
    private javax.swing.JPanel welcome_panel;
    // End of variables declaration//GEN-END:variables
}
