import java.sql.*;

public class SQLDemo1 {
    public static void main(String[] args) {
        String dbUrl="jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName="syntax_hrm";
        String password="syntaxhrm123";

        Connection connection=null;//establishes connection with database
        Statement statement=null;//executes the queries using connection
        ResultSet resultSet=null;// gets data in a form of set

        try {
            connection= DriverManager.getConnection(dbUrl,userName,password);
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from employee");
            ResultSetMetaData resultSetMetaData= resultSet.getMetaData();//gives us information about table itself
            for(int i=1;i<=resultSetMetaData.getColumnCount();i++){
                System.out.print(resultSetMetaData.getColumnName(i)+" ");
            }
            System.out.println();
            while(resultSet.next()){
                System.out.print(resultSet.getString("empid")+"  ");
                System.out.print(resultSet.getString("salary")+"  ");
                System.out.print(resultSet.getString("grade")+"  ");
                System.out.print(resultSet.getString("department")+"  ");
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
