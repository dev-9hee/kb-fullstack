package org.scoula.travel.dao;

import org.scoula.travel.domain.TravelImageVO;
import org.scoula.travel.domain.TravelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class TravelDaoImpl implements TravelDao {
    @Autowired
    Connection conn;

    @Override
    public void create(TravelVO travel) throws SQLException {
        String sql = "insert into travel values(?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, travel.getNo());
            ps.setString(2, travel.getDistrict());
            ps.setString(3, travel.getTitle());
            ps.setString(4, travel.getAddress());
            ps.setString(5, travel.getAddress());
            ps.setString(6, travel.getPhone());
            ps.executeUpdate();
        }
    }

    @Override
    public void createImage(TravelImageVO image) throws SQLException {
        String sql = "insert into travel_image(travel_no, file_name, path, size) values(?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, image.getTravelNo());
            ps.setString(2, image.getFileName());
            ps.setString(3, image.getPath());
            ps.setLong(4, image.getSize());

            ps.executeUpdate();
        }
    }
}
