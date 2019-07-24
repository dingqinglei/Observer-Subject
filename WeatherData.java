package com.aiker.weatherdata;

import com.aiker.subject.Subject;
import com.aiker.observer.Observer;
import java.util.*;

// WeatherData类实现Subject接口，遵守主题规范
public class WeatherData implements Subject{
	// 定义温度字段
	private double WD;
	// 定义湿度字段
	private double SD;
	// 定义观察者对象列表
	ArrayList<Object> observerList;
	
	public WeatherData() {
		observerList = new ArrayList<>(); // 在创建WeatherData对象的同时创建观察者列表
	}
	
	// 重写Subject接口的抽象方法
	@Override
	public boolean registerObserver(Observer observer) {
		observerList.add(observer); // 将新的观察者添加进观察者列表
		return true;
	}
	
	@Override
	public boolean removeObserver(Observer observer) {
		int index = observerList.indexOf(observer);
		if (index > 0) {
			// 如果观察者列表中包含这个观察者，就将该观察者从观察者列表中移除
			observerList.remove(index);
			return true;
		}
		return false;
	}
	
	/*
	 * 一旦WeatherData主题中的任何一个数据发生改变，那么该方法就会被调用
	*/
	@Override
	public void notifyAllObservers() {
		for (Object observers : observerList) {
			Observer ob = (Observer)observers;
			ob.update(WD, SD);
		}
	}
	
	public void mesurementsChanged() {
		// 当气象站得到更新后的数据后，我们通知观察者
		notifyAllObservers();
	} 
	
	public void setMesurements(double WD, double SD) {
		this.WD = WD;
		this.SD = SD;
		mesurementsChanged();
	}
}