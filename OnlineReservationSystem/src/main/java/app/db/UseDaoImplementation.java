package app.db;

import app.db.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UseDaoImplementation implements UserDao{
    private static final String DB_URL ="jdbc:sqlite:ors.db";

    public UseDaoImplementation () {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private void createTable(){
        try (Connection connection = getConnection()) {
            String CREATE_USERS_TABLE = """
                    CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    lastname TEXT NOT NULL,
                    birthdate TEXT NOT NULL,
                    gender TEXT,
                    email TEXT NOT NULL,
                    password TEXT NOT NULL)
                    """;

            Statement statement = connection.createStatement();
            statement.execute(CREATE_USERS_TABLE);
            System.out.println("hui");
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    public void addUser(User user) {
        String table = "users";
        String ADD_USER =
                "INSERT INTO users " +
                        "(name, lastname, birthdate, gender, email, password)" +
                        " VALUES (?, ?, ?, ?, ?, ?)";
       try( Connection conn = getConnection()) {
           DatabaseMetaData metaData = conn.getMetaData();
           ResultSet rs = metaData.getTables(null,null, table, null);
           boolean tableExists = rs.next();
           System.out.println(tableExists);

           if (!tableExists) {
               createTable();
               System.out.println("creating "+table);
               PreparedStatement stmt = conn.prepareStatement(ADD_USER);

               stmt.setString(1, user.getFirstName());
               stmt.setString(2, user.getLastName());
               stmt.setString(3, user.getBirthDate());
               stmt.setString(4, user.getGender());
               stmt.setString(5, user.getEmail());
               stmt.setString(6, user.getPassword());

               int rowsAffected = stmt.executeUpdate();
               if (rowsAffected > 0) {
                   System.out.println("User added successfully");
               } else {
                   System.out.println("Failed to add user");
               }
               stmt.close();
           } else {
               System.out.println("Adding user to "+table);
               PreparedStatement stmt = conn.prepareStatement(ADD_USER);
               stmt.setString(1, user.getFirstName());
               stmt.setString(2, user.getLastName());
               stmt.setString(3, user.getBirthDate());
               stmt.setString(4, user.getGender());
               stmt.setString(5, user.getEmail());
               stmt.setString(6, user.getPassword());
               int rowsAffected = stmt.executeUpdate();
               if (rowsAffected > 0) {
                   System.out.println("User added successfully");
               } else {
                   System.out.println("Failed to add user");
               }
               stmt.close();
               conn.close();
           }

       } catch (SQLException e) {
           System.err.println("Error: " + e.getMessage());
       }

    }

    @Override
    public User getUserById(int id) {
        String name = "";
        String lastname = "";
        String birthdate = "";
        String gender = "";
        String email = "";
        String password = "";
        User user = new User();
        String FETCH_USER = "SELECT * FROM users WHERE id = ?";


        try( Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(FETCH_USER);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                lastname = resultSet.getString("lastname");
                birthdate = resultSet.getString("birthdate");
                gender = resultSet.getString("gender");
                email = resultSet.getString("email");
                password = resultSet.getString("password");

                user.setId(id);
                user.setFirstName(name);
                user.setLastName(lastname);
                user.setBirthDate(birthdate);
                user.setGender(gender);
                user.setEmail(email);
                user.setPassword(password);
            }
            conn.close();
            resultSet.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return new User(id,name,lastname,birthdate,gender,email,password);
    }

    @Override
    public List<User> getAllUsers() {
        String FETCH_USERS = "SELECT * FROM users";

        List<User> users = new ArrayList<>();

        int id;
        String name = "";
        String lastname = "";
        String birthdate = "";
        String gender = "";
        String email = "";
        String password = "";

        try( Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(FETCH_USERS);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                lastname = rs.getString("lastname");
                birthdate = rs.getString("birthdate");
                gender = rs.getString("gender");
                email = rs.getString("email");
                password = rs.getString("password");

                users.add(new User(id,name,lastname,birthdate,gender,email,password));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return List.copyOf(users);
    }

    @Override
    public void updateUser(User user) {
        String UPDATE_USER = """
                UPDATE users SET
                name = ?,
                lastname = ?,
                birthdate = ?,
                gender = ?,
                email = ?,
                password = ?
                WHERE id = ?
                """;
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(UPDATE_USER);

            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getFirstName());
            stmt.setString(3, user.getLastName());
            stmt.setString(4, user.getBirthDate());
            stmt.setString(5, user.getGender());
            stmt.setString(6, user.getEmail());
            stmt.setString(7, user.getPassword());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User profile successfully updated");
            } else {
                System.out.println("Failed to update user profile");
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error updating user: " + e.getMessage());
        }

    }

    @Override
    public void deleteUser(int id) {
        String DELETE_USER = "DELETE * FROM users WHERE id = ?";
        try(Connection conn = getConnection();) {
            PreparedStatement stmt = conn.prepareStatement(DELETE_USER);
            stmt.setInt(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting user: "+e.getMessage());
        }

    }
}
