import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String dbUrl="jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName="syntax_hrm";
        String password="syntaxhrm123";
        try {
            Connection connection= DriverManager.getConnection(dbUrl,userName,password);
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select emp_firstname, emp_lastname from hs_hr_employees;");
            while(resultSet.next()){
                String firstname=resultSet.getString("emp_firstname");
                String lastName=resultSet.getString("emp_lastname");
                System.out.println(firstname+" "+lastName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
