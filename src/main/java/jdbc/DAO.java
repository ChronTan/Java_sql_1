package jdbc;

public interface DAO <Entity, Key> { // Data access object объект предоставляющий интерфейс для сущности

    boolean create(Entity model);
    Entity read(Key key); // достать из базы по ключу(String или другой тип)
    boolean update(Entity model);
    boolean delete(Entity model);
}
