package Model;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Base64;

public class Session {
    private static Session instance;
    private String currentUser;
    private String sessionId;
    private Instant sessionStartTime;
    private Instant lastActivityTime;
    private final long TIMEOUT_DURATION_ABSOLUTE = 2 * 60 * 1000;; //1 minute //15 * 60 * 1000; // 15 minutes in milliseconds
    private final long TIMEOUT_DURATION_IDLE = 1 * 60 * 1000;
    
    private Session() {
        sessionStartTime = Instant.now();
        lastActivityTime = Instant.now();
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public String getCurrentUser() {
        return this.currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
        this.sessionId = generateSessionId();
    //    updateSessionStartTime();
    }

    public String getSessionId() {
        return this.sessionId;
    }

    private String generateSessionId() {
        // Generate 64 bits of entropy
        
        updateSessionStartTime();
        
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[8]; // 64 bits
        secureRandom.nextBytes(randomBytes);

        // Convert to a 128-bit session ID using Base64 encoding
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
        
        
    }

    public void clearSession() {
        this.currentUser = null;
        this.sessionId = null;
    }
    
    public boolean isAbsoluteSessionExpired() {
        return Instant.now().isAfter(sessionStartTime.plusMillis(TIMEOUT_DURATION_ABSOLUTE));
    }
    
    public boolean isIdleSessionExpired() {
        return Instant.now().isAfter(lastActivityTime.plusMillis(TIMEOUT_DURATION_IDLE));
    }

    public void updateSessionStartTime() {
        this.sessionStartTime = Instant.now();
    }

    public void updateLastActivityTime() {
        this.lastActivityTime = Instant.now();
    }
}
