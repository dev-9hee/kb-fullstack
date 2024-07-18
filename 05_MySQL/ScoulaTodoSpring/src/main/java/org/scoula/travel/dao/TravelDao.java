package org.scoula.travel.dao;

import org.scoula.travel.domain.TravelImageVO;
import org.scoula.travel.domain.TravelVO;

import java.sql.SQLException;

public interface TravelDao {
    void create(TravelVO travel) throws SQLException;

    void createImage(TravelImageVO image) throws SQLException;
}
