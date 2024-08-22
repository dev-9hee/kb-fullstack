package org.example.domain.weather;

import java.util.List;
import lombok.Data;

@Data
public class WeatherDto{
	private int visibility;
	private int timezone;
	private Main main;
	private Clouds clouds;
	private Sys sys;
	private int dt;
	private Coord coord;
	private List<WeatherItem> weather;
	private String name;
	private int cod;
	private int id;
	private String base;
	private Wind wind;
}