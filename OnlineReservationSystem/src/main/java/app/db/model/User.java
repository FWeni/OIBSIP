package app.db.model;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;
    private String email;
    private String password;

    public User() {}

    public User(String firstName, String lastName, String birthDate, String gender, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public User(int id, String firstName, String lastName, String birthDate, String gender, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  "User {"+
                "id:"+ id+","+
                "first_name:"+ firstName +","+
                "last_name :" + lastName+","+
                "birth_date :" + birthDate +","+
                "gender:" + gender +","+
                "email: " + email +
                "}";
    }
}
