package data;

import data.EKGDAO;
import data.SQLConnector;
import ekg.EKGData;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EKGDAOImpl implements EKGDAO {
    @Override
    public void save(EKGData ekgData) {
        Connection conn = SQLConnector.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO EKGdata(EKGdata) VALUES (?)");
            preparedStatement.setDouble(1, (ekgData.getSample())); ;
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}