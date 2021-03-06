/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author acer
 */
public class Employee extends javax.swing.JPanel {

    /**
     * Creates new form Employee
     */
    public Employee() {
        initComponents();
        tableload();
        Color white = new Color(255,255,255);
        EmpTable.setBackground(white);
        EmpTable.setGridColor(white);
        EmpTable.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
        EmpTable.getTableHeader().setOpaque(false);
        EmpTable.getTableHeader().setReorderingAllowed(false);
        EmpTable.getTableHeader().setBackground(white);
        EmpTable.getTableHeader().setForeground(new Color(0,0,0));
        EmpTable.setRowHeight(40);
    }
     public void tableload(){
       
        try {
             DefaultTableModel table =(DefaultTableModel) EmpTable.getModel();
             table.setRowCount(0);
             Statement statment=(Statement) DBConnector.DBCon().createStatement();
             ResultSet results=statment.executeQuery("select * from Employee");
             while(results.next())
             {
                 Vector v = new Vector();
                 v.add(results.getString("EmployeeName"));
                 v.add(results.getString("NIC"));
                 v.add(results.getString("Salary"));
                 v.add(results.getString("Job"));
                 v.add(results.getString("Contact"));
                 table.addRow(v);
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void SearchTable(){
        if(EmpSearch.getText().trim().isEmpty()) {
            tableload();
        }
        else{ try{
                Statement State=(Statement) DBConnector.DBCon().createStatement();
                ResultSet result=State.executeQuery("select * from employee where EmployeeName='"+EmpSearch.getText()+"'");
                DefaultTableModel table =(DefaultTableModel) EmpTable.getModel();
                table.setRowCount(0);
                  while(result.next())
                 {
                   
                    Vector v = new Vector();
                    v.add(result.getString("EmployeeName"));
                    v.add(result.getString("NIC"));
                    v.add(result.getString("Salary"));
                    v.add(result.getString("Job"));
                    v.add(result.getString("Contact"));
                    table.addRow(v);
                 }
            }
            catch(Exception e){
                System.out.print("Erro while data fetching "+e);
            }
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Contact = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        NIC = new javax.swing.JTextField();
        EmployeeAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        EmpTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Sal = new javax.swing.JTextField();
        JOB = new javax.swing.JTextField();
        EmployeeName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        EmpSearch = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));

        Contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contact");

        NIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NICActionPerformed(evt);
            }
        });

        EmployeeAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EmployeeAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/images/icons8_add_64px_3.png"))); // NOI18N
        EmployeeAdd.setText("ADD");
        EmployeeAdd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        EmployeeAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeAddActionPerformed(evt);
            }
        });

        EmpTable.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        EmpTable.setForeground(new java.awt.Color(0, 153, 153));
        EmpTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Employee Name", "NIC Number", "Salary", "JOB", "Contact"
            }
        ));
        EmpTable.setFocusable(false);
        EmpTable.setGridColor(new java.awt.Color(255, 255, 255));
        EmpTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        EmpTable.setRowHeight(30);
        EmpTable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        EmpTable.setShowVerticalLines(false);
        EmpTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(EmpTable);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NIC Numebr");

        Sal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalActionPerformed(evt);
            }
        });

        JOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOBActionPerformed(evt);
            }
        });

        EmployeeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeNameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Monthly salery");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employee Name");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("JOB");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/images/icons8_update_left_rotation_64px.png"))); // NOI18N
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/images/icons8_remove_64px.png"))); // NOI18N
        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        EmpSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EmpSearchKeyReleased(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Find");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Search Employee");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jButton2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NIC, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sal, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JOB, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Contact, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(EmployeeAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(41, 41, 41)
                .addComponent(EmpSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NIC, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Sal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JOB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Contact, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmployeeAdd)
                            .addComponent(jButton2)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EmpSearch, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContactActionPerformed

    private void NICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NICActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NICActionPerformed

    private void SalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalActionPerformed

    private void JOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JOBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JOBActionPerformed

    private void EmployeeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmployeeNameActionPerformed

    private void EmployeeAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeAddActionPerformed
        String name=EmployeeName.getText();
        String nic=NIC.getText();
        String job=JOB.getText();
        double salary=Double.parseDouble(Sal.getText());
        String contact=Contact.getText();
        try{
            Statement s = (Statement) DBConnector.DBCon().createStatement();
            s.executeUpdate("insert into employee (EmployeeName,NIC,Salary,Job,Contact)values('"+name+"','"+nic+"','"+salary+"','"+job+"','"+contact+"')");
             JOptionPane.showMessageDialog(null, "Employee Added");
            System.out.println("Employee Added");
            tableload();
            
        }
        catch(Exception e)
        {
            System.out.print("Erro while data fetching"+e);
        }
        EmployeeName.setText(null);
        NIC.setText(null);
        JOB.setText(null);
        Sal.setText(null);
        Contact.setText(null);
    }//GEN-LAST:event_EmployeeAddActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            Statement statement=(Statement) DBConnector.DBCon().createStatement();
            statement.executeUpdate("delete from Employee where NIC='"+NIC.getText().trim()+"'");
            tableload();
            JOptionPane.showMessageDialog(null, "Delete Success");
        }
        catch(Exception e){
            System.out.print("Erro while data fetching"+e);
        }
        EmployeeName.setText(null);
        NIC.setText(null);
        JOB.setText(null);
        Sal.setText(null);
        Contact.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String name= null;
        String nic=NIC.getText();
        String job=null;
        double salary = 0;
        String contact=null;
        try{
            Statement statement = (Statement) DBConnector.DBCon().createStatement();
            ResultSet results=  statement.executeQuery("select * from Employee where NIC='"+nic+"'");
            results.next();
             name= results.getString("EmployeeName");
             nic=results.getString("NIC");
             job=results.getString("Job");
             salary= Double.parseDouble(results.getString("Salary"));
             contact=results.getString("Contact");
             System.out.println("Employee selected");
        }
        catch(Exception e)
        {
            System.out.print("Erro while data fetching"+e);
        }
        
        if(!EmployeeName.getText().isEmpty()){
            name=EmployeeName.getText();
        }
        if(!JOB.getText().isEmpty()){
            job=JOB.getText();
        }
        if(!Sal.getText().isEmpty()){
            salary=Double.parseDouble(Sal.getText());
        }
        if(!Contact.getText().isEmpty()){
            contact=Contact.getText();
        }
       
        try{
            Statement s = (Statement) DBConnector.DBCon().createStatement();
            s.executeUpdate("update employee set EmployeeName ='"+name+"',Job ='"+job+"',Salary='"+salary+"',Contact='"+contact+"' where NIC='"+nic+"' ");
            tableload();
            JOptionPane.showMessageDialog(null, "Update Success");
            System.out.println("Employee updated");
        }
        catch(Exception e)
        {
            System.out.print("Erro while data fetching"+e);
        }
        EmployeeName.setText(null);
        NIC.setText(null);
        JOB.setText(null);
        Sal.setText(null);
        Contact.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void EmpSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmpSearchKeyReleased
        SearchTable();
    }//GEN-LAST:event_EmpSearchKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        SearchTable();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Contact;
    private javax.swing.JTextField EmpSearch;
    private javax.swing.JTable EmpTable;
    private javax.swing.JButton EmployeeAdd;
    private javax.swing.JTextField EmployeeName;
    private javax.swing.JTextField JOB;
    private javax.swing.JTextField NIC;
    private javax.swing.JTextField Sal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
