package com.aiker.main_f;

import com.aiker.bugaoban.*;
import com.aiker.weatherdata.*;

public class Main {
	public static void main(String[] args) {
		
		// ����WeatherData����������
		WeatherData weatherData = new WeatherData();
		// ��CurrentConditonalDisplay����ע���ΪWeatherData����Ĺ۲���
		CurrentConditionalDisplay cu = new CurrentConditionalDisplay(weatherData);
		// ����WeatherData������
		weatherData.setMesurements(12.4, 13.5);
	}
}