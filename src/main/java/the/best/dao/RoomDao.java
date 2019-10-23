package the.best.dao;

import lombok.extern.slf4j.Slf4j;
import the.best.DataSourceFactory;
import the.best.model.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class RoomDao implements Dao<Room> {
    public static final String TABLE = "rooms";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CAPITAL = "capital";
    public static final String COLUMN_CAPACITY = "capacity";
    public static final String COLUMN_AGE_GROUP_ID = "age_group_id";

    public static final String QUERY_ROOM = "SELECT * FROM " + TABLE + " WHERE " + COLUMN_ID + " = ? ";

    public static final String QUERY_ROOMS = "SELECT * FROM " + TABLE;

    public static final String INSERT_ROOM = "INSERT INTO " + TABLE + " (" +
            COLUMN_ID + ", " +COLUMN_CAPITAL + ", " + COLUMN_CAPACITY + ", " + COLUMN_AGE_GROUP_ID +
            ") VALUES(?,?,?,?)";

    public static final String UPDATE_ROOM = "UPDATE " + TABLE + " SET " + COLUMN_CAPITAL + " = ?, " +
            COLUMN_CAPACITY + " = ?, " + COLUMN_AGE_GROUP_ID + " = ? WHERE " + COLUMN_ID + " = ?";

    public static final String DELETE_ROOM = "DELETE FROM " + TABLE + " WHERE " + COLUMN_ID + " = ?";

    public Room get(long id) {
        try(PreparedStatement deleteRoomPreparedStatement = DataSourceFactory.getConnection().prepareStatement(QUERY_ROOM)){
            deleteRoomPreparedStatement.setInt(1, (int)id);
            ResultSet resultSet = deleteRoomPreparedStatement.executeQuery();

            if(resultSet.next()){
                Room room = new Room();
                room.setId(resultSet.getInt(COLUMN_ID));
                room.setCapital(resultSet.getDouble(COLUMN_CAPITAL));
                room.setCapacity(resultSet.getInt(COLUMN_CAPACITY));
                room.setAgeGroupId(resultSet.getInt(COLUMN_AGE_GROUP_ID));
                return room;
            } else {
                log.info("Room not found with id " + id);
                return null;
            }

        } catch (SQLException e){
            log.error("Failed delete room " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Room> getAll() {
        try (Statement statement = DataSourceFactory.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(QUERY_ROOMS)){
            List<Room> res = new ArrayList<>();
            while(resultSet.next()){
                Room room = new Room();
                room.setId(resultSet.getInt(COLUMN_ID));
                room.setCapital(resultSet.getDouble(COLUMN_CAPITAL));
                room.setCapacity(resultSet.getInt(COLUMN_CAPACITY));
                room.setAgeGroupId(resultSet.getInt(COLUMN_AGE_GROUP_ID));

                res.add(room);
            }
            return res;
        } catch (SQLException e){
            System.out.println("Query failed " + e.getMessage());
            return null;
        }
    }

    @Override
    public void save(Room room) {
        try(PreparedStatement insertRoomPreparedStatement = DataSourceFactory.getConnection().prepareStatement(INSERT_ROOM, Statement.RETURN_GENERATED_KEYS)){
            insertRoomPreparedStatement.setInt(1, room.getId());
            insertRoomPreparedStatement.setDouble(2, room.getCapital());
            insertRoomPreparedStatement.setInt(3, room.getCapacity());
            insertRoomPreparedStatement.setInt(4, room.getAgeGroupId());

            insertRoomPreparedStatement.execute();
        } catch (SQLException e){
            log.error("Failed insert room" + e.getMessage());
        }

    }

    @Override
    public void update(Room room) {
        try(PreparedStatement updateRoomPreparedStatement = DataSourceFactory.getConnection().prepareStatement(UPDATE_ROOM)){
            updateRoomPreparedStatement.setDouble(1, room.getCapital());
            updateRoomPreparedStatement.setInt(2, room.getCapacity());
            updateRoomPreparedStatement.setInt(3, room.getAgeGroupId());
            updateRoomPreparedStatement.setInt(4, room.getId());

            updateRoomPreparedStatement.execute();
        } catch (SQLException e){
            log.error("Failed update room " + e.getMessage());
        }
    }

    @Override
    public void delete(Room room) {
        try(PreparedStatement deleteRoomPreparedStatement = DataSourceFactory.getConnection().prepareStatement(DELETE_ROOM)){
            deleteRoomPreparedStatement.setInt(1, room.getId());

            deleteRoomPreparedStatement.execute();
        } catch (SQLException e){
            log.error("Failed delete room " + e.getMessage());
        }
    }
}
