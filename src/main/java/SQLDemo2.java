import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLDemo2 {
    public static void main(String[] args) {
        String dbUrl="jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName="syntax_hrm";
        String password="syntaxhrm123";

        Connection connection=null;//establishes connection with database
        Statement statement=null;//executes the queries using connection
        ResultSet resultSet=null;// gets data in a form of set
        List<Map<String,String>> table=new ArrayList<>();
        Map<String, String> row;

        try {
            connection= DriverManager.getConnection(dbUrl,userName,password);
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from employee");
            ResultSetMetaData resultSetMetaData= resultSet.getMetaData();//gives us information about table itself


            while(resultSet.next()){
                row=new HashMap<>();
                for(int i=1;i<=resultSetMetaData.getColumnCount();i++){
                   row.put(resultSetMetaData.getColumnName(i),resultSet.getString(i));
                }
                //System.out.println(row);
                table.add(row);
            }
            System.out.println(table);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
