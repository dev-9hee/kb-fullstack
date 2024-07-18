package org.scoula.travel.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.todo.config.ProjectConfig;
import org.scoula.travel.domain.TravelImageVO;
import org.scoula.travel.domain.TravelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
class TravelDaoImplTest {
    @Autowired
    TravelDao dao;

    @Test
    void create() throws IOException, SQLException {
        List<TravelVO> members = new CsvToBeanBuilder<TravelVO>(new FileReader("src/test/resources/travel.csv", StandardCharsets.UTF_8))
                .withType(TravelVO.class)
                .build()
                .parse();
        for (TravelVO travel : members) {
            System.out.println(travel);
            dao.create(travel);
        }
    }

    @Test
    void createTravelImages() throws IOException {
        String dir = "D:\\travel-image";

        List<TravelImageVO> files = Files.list(Paths.get(dir))
                .map(Path::toFile)
                .map(TravelImageVO::of)
                .toList();

        for (TravelImageVO file : files) {
            System.out.println(file);
            try {
                dao.createImage(file);
            } catch (SQLException e) {
                e.printStackTrace();
                // 예외 처리 로직 추가 가능
            }
        }
    }
}