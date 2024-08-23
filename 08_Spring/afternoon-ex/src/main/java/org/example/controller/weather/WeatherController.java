package org.example.controller.weather;


import lombok.extern.slf4j.Slf4j;
import org.example.domain.weather.WeatherDto;
import org.example.domain.weather.forecast.ForecastDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController // RESTful 웹 서비스의 컨트롤러
@Slf4j
@Transactional
@PropertySource("classpath:application.properties")
@RequestMapping("/weather")
@CrossOrigin(origins = "*")
public class WeatherController {

    // 필드 주입
    @Value("${weather.url}")
    private String WEATHER_URL;
    @Value("${forecast.url}")
    private String FORECAST_URL;
    @Value("${weather.api.key}")
    private String API_KEY;

    // 도시 날씨 받아오기
    @GetMapping("/{cityname}")
    public ResponseEntity<WeatherDto> getWeather(@PathVariable("cityname") String cityName) {
        log.info("도시 날씨 받아오기");
        cityName = cityName == null ? "seoul" : cityName; // 도시 이름이 제공되지 않으면 서울의 날씨 정보를 가져옴

        RestTemplate restTemplate = new RestTemplate(); // 외부 API 호출을 위해 RestTemplate 객체를 생성

        String url = UriComponentsBuilder.fromHttpUrl(WEATHER_URL) // 동적으로 최종 요청 URL 을 생성
                .queryParam("q", cityName)
                .queryParam("units", "metric")
                .queryParam("APPID", API_KEY)
                .queryParam("lang", "kr")
                .toUriString();

        WeatherDto weather = restTemplate.getForObject(url, WeatherDto.class); // API 응답을 WeatherDto 객체로 받아옴
        return ResponseEntity.ok(weather); // 클라이언트에게 JSON 형태로 반환
    }

    // 도시 예보 받아오기
    @GetMapping("/forecast/{cityname}")
    public ResponseEntity<ForecastDto> getForecast(@PathVariable("cityname") String cityName) {
        log.info("도시 예보 받아오기");
        cityName = cityName == null ? "seoul" : cityName;

        RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder.fromHttpUrl(FORECAST_URL)
                .queryParam("q", cityName)
                .queryParam("units", "metric")
                .queryParam("APPID", API_KEY)
                .queryParam("lang", "kr")
                .toUriString();

        ForecastDto forecast = restTemplate.getForObject(url, ForecastDto.class);
        return ResponseEntity.ok(forecast);
    }
}
