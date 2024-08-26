package org.scoula.weather.dto;

import lombok.Data;

@Data
public class Main{
	private double temp;
	private double tempMin;
	private int grndLevel;
	private int humidity;
	private int pressure;
	private int seaLevel;
	private double feelsLike;
	private double tempMax;
}