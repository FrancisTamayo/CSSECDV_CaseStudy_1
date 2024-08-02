package View;

import Controller.Main;
import Controller.SQLite;
import Model.Session;
import Model.User;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Frame extends javax.swing.JFrame {
    
    private final SQLite sqlite;
    private Timer sessionTimer;

    public Frame() {
        initComponents();
        sqlite = new SQLite();
        startSessionTimer();
        addActivityListeners();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Container = new javax.swing.JPanel();
        HomePnl = new javax.swing.JPanel();
        Content = new javax.swing.JPanel();
        Navigation = new javax.swing.JPanel();
        adminBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        managerBtn = new javax.swing.JButton();
        staffBtn = new javax.swing.JButton();
        clientBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setMinimumSize(new java.awt.Dimension(800, 450));

        HomePnl.setBackground(new java.awt.Color(102, 102, 102));
        HomePnl.setPreferredSize(new java.awt.Dimension(801, 500));

        javax.swing.GroupLayout ContentLayout = new javax.swing.GroupLayout(Content);
        Content.setLayout(ContentLayout);
        ContentLayout.setHorizontalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );
        ContentLayout.setVerticalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Navigation.setBackground(new java.awt.Color(204, 204, 204));

        adminBtn.setBackground(new java.awt.Color(250, 250, 250));
        adminBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        adminBtn.setText("Admin Home");
        adminBtn.setFocusable(false);
        adminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        managerBtn.setBackground(new java.awt.Color(250, 250, 250));
        managerBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        managerBtn.setText("Manager Home");
        managerBtn.setFocusable(false);
        managerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerBtnActionPerformed(evt);
            }
        });

        staffBtn.setBackground(new java.awt.Color(250, 250, 250));
        staffBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        staffBtn.setText("Staff Home");
        staffBtn.setFocusable(false);
        staffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffBtnActionPerformed(evt);
            }
        });

        clientBtn.setBackground(new java.awt.Color(250, 250, 250));
        clientBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clientBtn.setText("Client Home");
        clientBtn.setFocusable(false);
        clientBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientBtnActionPerformed(evt);
            }
        });

        logoutBtn.setBackground(new java.awt.Color(250, 250, 250));
        logoutBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logoutBtn.setText("LOGOUT");
        logoutBtn.setFocusable(false);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NavigationLayout = new javax.swing.GroupLayout(Navigation);
        Navigation.setLayout(NavigationLayout);
        NavigationLayout.setHorizontalGroup(
            NavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(managerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staffBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        NavigationLayout.setVerticalGroup(
            NavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(adminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(managerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout HomePnlLayout = new javax.swing.GroupLayout(HomePnl);
        HomePnl.setLayout(HomePnlLayout);
        HomePnlLayout.setHorizontalGroup(
            HomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePnlLayout.createSequentialGroup()
                .addComponent(Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HomePnlLayout.setVerticalGroup(
            HomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ContainerLayout = new javax.swing.GroupLayout(Container);
        Container.setLayout(ContainerLayout);
        ContainerLayout.setHorizontalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
            .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(HomePnl, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE))
        );
        ContainerLayout.setVerticalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(HomePnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminBtnActionPerformed
        adminHomePnl.showPnl("home");
        contentView.show(Content, "adminHomePnl");
    }//GEN-LAST:event_adminBtnActionPerformed

    private void managerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerBtnActionPerformed
        managerHomePnl.showPnl("home");
        contentView.show(Content, "managerHomePnl");
    }//GEN-LAST:event_managerBtnActionPerformed

    private void staffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffBtnActionPerformed
        staffHomePnl.showPnl("home");
        contentView.show(Content, "staffHomePnl");
    }//GEN-LAST:event_staffBtnActionPerformed

    private void clientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientBtnActionPerformed
        clientHomePnl.showPnl("home");
        contentView.show(Content, "clientHomePnl");
    }//GEN-LAST:event_clientBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
    //    Session.getInstance().clearSession();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String timestamp = now.format(formatter);
        
        sqlite.addLogs("NOTICE", Session.getInstance().getCurrentUser(), "User Successful Logout", timestamp);
        
        Session.getInstance().clearSession();
        sqlite.addLogs("NOTICE", Session.getInstance().getCurrentUser(), "Session Termination", timestamp);
    
        Session.getInstance().setCurrentUser("id");
        System.out.println("Session ID: " + Session.getInstance().getSessionId()); // For debugging purposes
        System.out.println("Current User: " + Session.getInstance().getCurrentUser());
        sqlite.addLogs("NOTICE", Session.getInstance().getCurrentUser(), "Session Creation", timestamp);
        
        resetPanels();
        
        frameView.show(Container, "loginPnl");
    }//GEN-LAST:event_logoutBtnActionPerformed

    public Main main;
    public Login loginPnl = new Login();
    public Register registerPnl = new Register();
    
    private AdminHome adminHomePnl = new AdminHome();
    private ManagerHome managerHomePnl = new ManagerHome();
    private StaffHome staffHomePnl = new StaffHome();
    private ClientHome clientHomePnl = new ClientHome();
    
    private CardLayout contentView = new CardLayout();
    private CardLayout frameView = new CardLayout();
    
    public void init(Main controller){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("CSSECDV - SECURITY Svcs");
        this.setLocationRelativeTo(null);
        
        this.main = controller;
        loginPnl.frame = this;
        registerPnl.frame = this;
        
        adminHomePnl.init(main.sqlite);
        clientHomePnl.init(main.sqlite);
        managerHomePnl.init(main.sqlite);
        staffHomePnl.init(main.sqlite);
        
        Container.setLayout(frameView);
        Container.add(loginPnl, "loginPnl");
        Container.add(registerPnl, "registerPnl");
        Container.add(HomePnl, "homePnl");
        frameView.show(Container, "loginPnl");
        
        Content.setLayout(contentView);
        
        adminBtn.setVisible(false);
        managerBtn.setVisible(false);
        staffBtn.setVisible(false);
        clientBtn.setVisible(false);
        //Content.add(adminHomePnl, "adminHomePnl");
        //Content.add(managerHomePnl, "managerHomePnl");
        //Content.add(staffHomePnl, "staffHomePnl");
        //Content.add(clientHomePnl, "clientHomePnl");
       
        
        
    /*    //make the button invisible or visible depending on the number
        
        // get session name
        String currentUser = Session.getInstance().getCurrentUser();
        
        // find the username sa list of users then get which role it is
        ArrayList<User> users = sqlite.getUsers();
        
        System.out.println(currentUser);
        int role = 0;
        
        for (User user : users) {
        //    System.out.println(user.getUsername());
            
            if (user.getUsername().equals(currentUser)) {
                role = user.getRole();
                
            }
        }
        
        
        
        // if role is 3 hide everythin except the client
        if (role == 2){
            adminBtn.setVisible(false);
            staffBtn.setVisible(false);
            managerBtn.setVisible(false);
            adminBtn.setVisible(false);
        } */
        
       
    
        this.setVisible(true);
    }
    
    public void mainNav(){
        resetPanels();
        
        frameView.show(Container, "homePnl");
        
         // get session name
        String currentUser = Session.getInstance().getCurrentUser();
        
        // find the username sa list of users then get which role it is
        ArrayList<User> users = sqlite.getUsers();
        
        System.out.println(currentUser);
        int role = 0;
        
        for (User user : users) {
        //    System.out.println(user.getUsername());
            
            if (user.getUsername().equals(currentUser)) {
                role = user.getRole();
                
            }
        }
        
    //    role = 6;
        
        // if role is 3 hide everythin except the client
        
        if (role == 2){
            Content.add(clientHomePnl, "clientHomePnl");
            clientBtn.setVisible(true);
            staffBtn.setVisible(false);
            managerBtn.setVisible(false);
            adminBtn.setVisible(false);
        } 
        
        if (role == 3){
            Content.add(staffHomePnl, "staffHomePnl");
            clientBtn.setVisible(false);
            staffBtn.setVisible(true);
            managerBtn.setVisible(false);
            adminBtn.setVisible(false);
        } 
        
        if (role == 4){
            Content.add(managerHomePnl, "managerHomePnl");
            clientBtn.setVisible(false);
            staffBtn.setVisible(false);
            managerBtn.setVisible(true);
            adminBtn.setVisible(false);
        } 
        
        if (role == 5){
            Content.add(adminHomePnl, "adminHomePnl");
            clientBtn.setVisible(false);
            staffBtn.setVisible(false);
            managerBtn.setVisible(false);
            adminBtn.setVisible(true);
        } 
        
    }
    
    
    private void startSessionTimer() {
        sessionTimer = new Timer(60000, new ActionListener() { // Check every minute
            @Override
            public void actionPerformed(ActionEvent e) {
                Session session = Session.getInstance();

                if (session.isIdleSessionExpired()) {
                    handleIdleSessionTimeout();
                } 

                if (session.isAbsoluteSessionExpired()) {
                    handleAbsoluteSessionTimeout();
                }
            }
        });
        sessionTimer.start();
    }

    private void handleIdleSessionTimeout() {
        // Handle idle timeout (e.g., notify the user and log them out)
    //    Session.getInstance().clearSession();
        
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String timestamp = now.format(formatter);

        sqlite.addLogs("NOTICE", Session.getInstance().getCurrentUser(), "Idle Session Timeout", timestamp);
        
        Session.getInstance().clearSession();
        sqlite.addLogs("NOTICE", Session.getInstance().getCurrentUser(), "Session Termination", timestamp);
        javax.swing.JOptionPane.showMessageDialog(this, "Session has expired due to inactivity. Please log in again.");
        
        Session.getInstance().setCurrentUser("id");
        System.out.println("Session ID: " + Session.getInstance().getSessionId()); // For debugging purposes
        System.out.println("Current User: " + Session.getInstance().getCurrentUser());
        sqlite.addLogs("NOTICE", Session.getInstance().getCurrentUser(), "Session Creation", timestamp);
        
        loginNav();
    }

    private void handleAbsoluteSessionTimeout() {
        // Handle absolute timeout (e.g., notify the user and log them out)
    //    Session.getInstance().clearSession();
  
        
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String timestamp = now.format(formatter);

        sqlite.addLogs("NOTICE", Session.getInstance().getCurrentUser(), "Absolute Session Timeout", timestamp);
        
        Session.getInstance().clearSession();
        sqlite.addLogs("NOTICE", Session.getInstance().getCurrentUser(), "Session Termination", timestamp);
        javax.swing.JOptionPane.showMessageDialog(this, "Session has expired. Please log in again.");
        
        Session.getInstance().setCurrentUser("id");
        System.out.println("Session ID: " + Session.getInstance().getSessionId()); // For debugging purposes
        System.out.println("Current User: " + Session.getInstance().getCurrentUser());
        sqlite.addLogs("NOTICE", Session.getInstance().getCurrentUser(), "Session Creation", timestamp);
        
        loginNav();
    }

    public void refreshSessionLastActivityTime() {
        Session.getInstance().updateLastActivityTime();
    }

    // Add this method to handle user activity
    private void addActivityListeners() {
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                refreshSessionLastActivityTime();
            }
        });

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                refreshSessionLastActivityTime();
            }
        });
    }
    
    public void loginNav(){
        frameView.show(Container, "loginPnl");
    }
    
    public void registerNav(){
        frameView.show(Container, "registerPnl");
    }
    
    public void registerAction(String username, String password, String confpass){
        main.sqlite.addUser(username, password);
    }
    
    private void resetPanels() {
        Content.removeAll();
    adminHomePnl = new AdminHome();
    managerHomePnl = new ManagerHome();
    staffHomePnl = new StaffHome();
    clientHomePnl = new ClientHome();

    // Reinitialize panels with the SQLite instance
    adminHomePnl.init(sqlite);
    managerHomePnl.init(sqlite);
    staffHomePnl.init(sqlite);
    clientHomePnl.init(sqlite);

    adminBtn.setVisible(false);
    managerBtn.setVisible(false);
    staffBtn.setVisible(false);
    clientBtn.setVisible(false);
    
    Content.repaint();
    Content.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Content;
    private javax.swing.JPanel HomePnl;
    private javax.swing.JPanel Navigation;
    private javax.swing.JButton adminBtn;
    private javax.swing.JButton clientBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton managerBtn;
    private javax.swing.JButton staffBtn;
    // End of variables declaration//GEN-END:variables
}
