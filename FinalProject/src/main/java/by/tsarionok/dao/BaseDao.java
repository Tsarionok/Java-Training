package by.tsarionok.dao;

import by.tsarionok.dao.connetion.ConnectorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDao {
    protected Connection connection;

    // Этот конструктор временный, просто чтобы потестить дао
    public BaseDao() {
        this.connection = ConnectorDB.getConnection();
    }

    public void setConnection(final Connection dbConnection) {
        this.connection = dbConnection;
    }

    protected void closeResources(final PreparedStatement st, final ResultSet result) throws SQLException {
        if (st != null) {
            st.close();
        }
        if (result != null) {
            result.close();
        }
    }
}
