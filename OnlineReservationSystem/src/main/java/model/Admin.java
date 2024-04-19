package model;

import io.github.cdimascio.dotenv.Dotenv;

public class Admin extends Person {
    private String adminId;
    private String role;

    Dotenv dotenv = Dotenv.configure().ignoreIfMissing().ignoreIfMalformed().load();

    public Admin(String email, String username, String password) {
        super(email,username,password);
        this.adminId = dotenv.get("ADMIN1");
        this.role = "Admin";
    }

    public Admin(String email, String username, String password, String role,String adminId) {
        super(email,username,password);
        this.adminId = adminId;
        this.role = role;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
