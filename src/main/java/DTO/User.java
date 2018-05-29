package DTO;

import java.util.Objects;

public class User implements Comparable<User> {
        private int userID;
        private String userName;
        private String email;
        private String password;
        private String joined;
        private boolean isAdmin;
        private String wowMain;
    public User(){
        
    }
    
    public User(int userID, String userName, String email, String password, String joined, boolean isAdmin, String wowMain) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.joined = joined;
        this.isAdmin = isAdmin;
        this.wowMain = wowMain;
    }
    public User(String userName, String email, String password, String joined, boolean isAdmin, String wowMain) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.joined = joined;
        this.isAdmin = isAdmin;
        this.wowMain = wowMain;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getJoined() {
        return joined;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public String getWowMain() {
        return wowMain;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setJoined(String joined) {
        this.joined = joined;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setWowMain(String wowMain) {
        this.wowMain = wowMain;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.userID;
        hash = 17 * hash + Objects.hashCode(this.userName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userID != other.userID) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        return true;
    }
   
    
    
    @Override
    public int compareTo(User u) {
        if(this.userID > u.userID)
        {
            return +1;
        }
        if(this.userID < u.userID)
        {
            return -1;
        }
        else{ 
            return 0;
        }
    }
}
