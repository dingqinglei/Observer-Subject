package com.aiker.subject;

import com.aiker.observer.Observer;

public interface Subject {
	// 注册观察者
	public abstract boolean registerObserver(Observer observer);
	// 移除观察者
	public abstract boolean removeObserver(Observer observer);
	// 当主题的数据发生变化时，会调用该方法，通知所有注册的观察者
	public abstract void notifyAllObservers();
}