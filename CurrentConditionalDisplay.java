package com.aiker.bugaoban;

import com.aiker.observer.Observer;
import com.aiker.display.Display;
import com.aiker.weatherdata.WeatherData;


public class CurrentConditionalDisplay implements Observer, Display{
	// 定义温度字段
	private double WD;
	// 定义湿度字段
	private double SD;
	
	// 定义空参构造器
	public CurrentConditionalDisplay() {}
	
	// 定义两重载有参构造器
	public CurrentConditionalDisplay(double WD, double SD) {
		this.WD = WD;
		this.SD = SD;
	}
	
	public CurrentConditionalDisplay(WeatherData weatherData) {
		weatherData.registerObserver(this); // 将当前对象注册成WeatherData的观察者
	}
	
	// 重写Observer的update方法
	@Override
	public void update(double WD, double SD) {
		this.WD = WD;
		this.SD = SD;
		display();
	}
	
	// 重写Display方法
	@Override
	public void display() {
		System.out.println("温度 = " + this.WD + "\t" + "湿度 = " + this.SD);
	}
}