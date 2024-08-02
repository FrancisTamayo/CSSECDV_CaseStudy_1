
package View;

import Model.Session;

import Model.User;
import java.util.ArrayList;
import Controller.SQLite;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JPanel {

    public Frame frame;
    private final SQLite sqlite;
    
    
    public Login() {
        initComponents();
        sqlite = new SQLite();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernameFld = new javax.swing.JTextField();
        passwordFld = new javax.swing.JPasswordField();
        registerBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        usernameFld.setBackground(new java.awt.Color(240, 240, 240));
        usernameFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernameFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        passwordFld.setBackground(new java.awt.Color(240, 240, 240));
        passwordFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordFld.setHorizontalAlignment(javax.swing.JPasswordField.CENTER);
        passwordFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        registerBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registerBtn.setText("REGISTER");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        loginBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        loginBtn.setText("LOGIN");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(registerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(usernameFld)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordFld, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        
         if (doesUserExist(usernameFld.getText())) {
            ArrayList<User> users = sqlite.getUsers();
           
            int ctr = 0;
        
            for (User user : users) {
                if (user.getUsername().equals(usernameFld.getText())) {
            
                    if (user.isLocked()) {
                        JOptionPane.showMessageDialog(null, "Your account is locked. Please contact Admin to unlock your account.");
                        return;
                    }   
                    break;
                }
               
                ctr++;
            }
                
            try {
                
                   LocalDateTime now = LocalDateTime.now();
                   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
                   String timestamp = now.format(formatter);
                
                if (isPasswordCorrect(usernameFld.getText(), passwordFld.getText())){
                
                    sqlite.updateUserAttempts(usernameFld.getText(), 0);
                    
                    Session.getInstance().setCurrentUser(usernameFld.getText());
                    String sessionId = Session.getInstance().getSessionId();
                    System.out.println("Session ID: " + sessionId); // For debugging purposes
                    sqlite.addLogs("NOTICE", Session.getInstance().getCurrentUser(), "User Successful Login", timestamp);
                    
                    clearFields();
                
                    frame.mainNav();
                    
                } else {
                    
                    if (users.get(ctr).getLoginAttempts() == 4){
                        // disable = 1
                        sqlite.lockUser(usernameFld.getText(), true);
                        sqlite.updateUserRole(usernameFld.getText(), 1);
                        JOptionPane.showMessageDialog(null, "Account is Diabled. Please contact Admin to re-enable the account.");
                        
                        Session.getInstance().setCurrentUser(usernameFld.getText());
                        String sessionId = Session.getInstance().getSessionId();
                        System.out.println("Session ID: " + sessionId); 
                        sqlite.addLogs("NOTICE", Session.getInstance().getCurrentUser(), "Disable User", timestamp);
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Username or Password!");
                        sqlite.updateUserAttempts(usernameFld.getText(), users.get(ctr).getLoginAttempts() + 1);
                    }
                    
                    
                }
                
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Username or Password!"); 
        }
        
    }//GEN-LAST:event_loginBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        frame.registerNav();
    }//GEN-LAST:event_registerBtnActionPerformed
    
    public boolean doesUserExist(String username){
        ArrayList<User> users = sqlite.getUsers();
        
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    
    
    public boolean isPasswordCorrect(String usernameInput, String passwordInput) throws NoSuchAlgorithmException{
        ArrayList<User> users = sqlite.getUsers();
        
        for (User user : users) {
            if (user.getUsername().equals(usernameInput)) {
                
                byte[] salt = getSalt(user.getPassword());
                String hashedPasswordInput = hashPassword(passwordInput, salt);
                
                if (user.getPassword().equals(hashedPasswordInput)){
                    return true;
                }   
            }
        }
        
        return false;
    }
    
    public String hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException{

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashedPassword) {
            sb.append(String.format("%02x", b & 0xFF));
        }

        return sb.toString()+ Arrays.toString(salt);
      
    }
    
    public byte[] getSalt(String input) {

        int start = input.indexOf('[');
        int end = input.indexOf(']');
        
        String saltString = input.substring(start + 1, end);

        String[] byteArray = saltString.split(",");
        byte[] salt = new byte[byteArray.length];

        if (start != -1 && end != -1 && end > start) {
            
            for (int i = 0; i < byteArray.length; i++) {
                salt[i] = Byte.parseByte(byteArray[i].trim());
            }

        }
        
        return salt;
        
    }
    
    private void clearFields() {
        usernameFld.setText("");
        passwordFld.setText("");
    }
     
     
    
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordFld;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField usernameFld;
    /*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JTextField passwordFld;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField usernameFld;
    // End of variables declaration//GEN-END:variables
    */
}
