package com.aiker.weatherdata;

import com.aiker.subject.Subject;
import com.aiker.observer.Observer;
import java.util.*;

// WeatherData��ʵ��Subject�ӿڣ���������淶
public class WeatherData implements Subject{
	// �����¶��ֶ�
	private double WD;
	// ����ʪ���ֶ�
	private double SD;
	// ����۲��߶����б�
	ArrayList<Object> observerList;
	
	public WeatherData() {
		observerList = new ArrayList<>(); // �ڴ���WeatherData�����ͬʱ�����۲����б�
	}
	
	// ��дSubject�ӿڵĳ��󷽷�
	@Override
	public boolean registerObserver(Observer observer) {
		observerList.add(observer); // ���µĹ۲�����ӽ��۲����б�
		return true;
	}
	
	@Override
	public boolean removeObserver(Observer observer) {
		int index = observerList.indexOf(observer);
		if (index > 0) {
			// ����۲����б��а�������۲��ߣ��ͽ��ù۲��ߴӹ۲����б����Ƴ�
			observerList.remove(index);
			return true;
		}
		return false;
	}
	
	/*
	 * һ��WeatherData�����е��κ�һ�����ݷ����ı䣬��ô�÷����ͻᱻ����
	*/
	@Override
	public void notifyAllObservers() {
		for (Object observers : observerList) {
			Observer ob = (Observer)observers;
			ob.update(WD, SD);
		}
	}
	
	public void mesurementsChanged() {
		// ������վ�õ����º�����ݺ�����֪ͨ�۲���
		notifyAllObservers();
	} 
	
	public void setMesurements(double WD, double SD) {
		this.WD = WD;
		this.SD = SD;
		mesurementsChanged();
	}
}