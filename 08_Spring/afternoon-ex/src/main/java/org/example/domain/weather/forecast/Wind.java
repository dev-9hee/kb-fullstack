package org.example.domain.weather.forecast;

import lombok.Data;

@Data
public class Wind{
	private int deg;
	private double speed;
	private double gust;
}