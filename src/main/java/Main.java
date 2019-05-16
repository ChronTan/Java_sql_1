import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        final String user="postgres";
        final String password="postgres";
        final String url="jdbc:postgresql://localhost:5432/phones_shop";

        final Connection connection=DriverManager.getConnection(url,user,password);

        Statement st=connection.createStatement();
        ResultSet rs;


        st.executeQuery("DELETE FROM users WHERE role=4 ");

//        try(PreparedStatement statement=connection.prepareStatement("SELECT * FROM users WHERE login = (?)")){
        try{
            rs=st.executeQuery("SELECT * FROM users WHERE login != 'Misha'");
//            statement.setString(1,"Egor");
//            final ResultSet resultSet=statement.executeQuery();
            while(rs.next()){
                String byname="login: "+ rs.getString("login");
                String byIndex="password: " + rs.getString(3);
                String byRole="role: "+rs.getInt("role");
                System.out.println(byname);
                System.out.println(byIndex);
                System.out.println(byRole);
            }


        }finally {
            connection.close();
        }

    }
}
