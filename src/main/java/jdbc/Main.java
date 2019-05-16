package jdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        final String user="postgres";
        final String password="postgres";
        final String url="jdbc:postgresql://localhost:5432/phones_shop";

        final Connection connection=DriverManager.getConnection(url,user,password);

//        Statement st=connection.createStatement();
//        ResultSet rs;


//        st.execute("DELETE FROM roles WHERE id>2 ");

        try(PreparedStatement statement=connection.prepareStatement("SELECT * FROM users WHERE id = (?)")){
//        try{
//            rs=st.executeQuery("SELECT * FROM users WHERE login != 'Misha'");
            statement.setInt(1,1);
            final ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()){
                String byname="login: "+ resultSet.getString("login");
                String byIndex="password: " + resultSet.getString(3);
                String byRole="role: "+resultSet.getInt("role");
                System.out.println(byname);
                System.out.println(byIndex);
                System.out.println(byRole);
            }


        }finally {
            connection.close();
        }

    }
}
