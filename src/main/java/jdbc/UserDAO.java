package jdbc;

import com.sun.istack.internal.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO implements DAO <User, String> {

    @NotNull
    private final Connection connection;   // ссылка для подключения к базе данных

    public UserDAO(final Connection connection){
        this.connection=connection;
    }

    @Override
    public boolean create(@NotNull User user){
        boolean result=false;

        try(PreparedStatement statement=connection.prepareStatement(SQLUser.INSERT.QUERY)){
            statement.setString(1, user.getLogin());
            statement.setString(2,user.getPassword());
            statement.setInt(3, user.getRole().getId());
            result=statement.executeQuery().next();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
