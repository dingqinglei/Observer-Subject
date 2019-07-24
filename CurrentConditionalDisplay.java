package com.aiker.bugaoban;

import com.aiker.observer.Observer;
import com.aiker.display.Display;
import com.aiker.weatherdata.WeatherData;


public class CurrentConditionalDisplay implements Observer, Display{
	// �����¶��ֶ�
	private double WD;
	// ����ʪ���ֶ�
	private double SD;
	
	// ����ղι�����
	public CurrentConditionalDisplay() {}
	
	// �����������вι�����
	public CurrentConditionalDisplay(double WD, double SD) {
		this.WD = WD;
		this.SD = SD;
	}
	
	public CurrentConditionalDisplay(WeatherData weatherData) {
		weatherData.registerObserver(this); // ����ǰ����ע���WeatherData�Ĺ۲���
	}
	
	// ��дObserver��update����
	@Override
	public void update(double WD, double SD) {
		this.WD = WD;
		this.SD = SD;
		display();
	}
	
	// ��дDisplay����
	@Override
	public void display() {
		System.out.println("�¶� = " + this.WD + "\t" + "ʪ�� = " + this.SD);
	}
}