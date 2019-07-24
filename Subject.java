package com.aiker.subject;

import com.aiker.observer.Observer;

public interface Subject {
	// ע��۲���
	public abstract boolean registerObserver(Observer observer);
	// �Ƴ��۲���
	public abstract boolean removeObserver(Observer observer);
	// ����������ݷ����仯ʱ������ø÷�����֪ͨ����ע��Ĺ۲���
	public abstract void notifyAllObservers();
}