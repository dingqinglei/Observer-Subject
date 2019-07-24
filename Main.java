package com.aiker.main_f;

import com.aiker.bugaoban.*;
import com.aiker.weatherdata.*;

public class Main {
	public static void main(String[] args) {
		
		// 创建WeatherData这个主题对象
		WeatherData weatherData = new WeatherData();
		// 将CurrentConditonalDisplay对象注册成为WeatherData对象的观察者
		CurrentConditionalDisplay cu = new CurrentConditionalDisplay(weatherData);
		// 更新WeatherData的数据
		weatherData.setMesurements(12.4, 13.5);
	}
}