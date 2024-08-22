package org.example.domain.weather;

import lombok.Data;

@Data
public class Sys{
	private String country;
	private int sunrise;
	private int sunset;
	private int id;
	private int type;
}