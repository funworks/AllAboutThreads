package com.threads.queue.delay;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayElement implements Delayed {
	
	private String data;
	
	private long start;
	
	private long delay;
	
	public DelayElement(String data, long delay) {
		this.data = data;
		this.delay = delay;
		this.start = System.currentTimeMillis() + delay;
	}

	@Override
	public int compareTo(Delayed o) {
		if (this.start < ((DelayElement) o).start) 
			return -1;
		else if (this.start > ((DelayElement) o).start)
			return 1;
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff = start - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	@Override
    public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(start);
        
		return "{\"data\": \"" + data + "\"" +
                ", \"start\": " + formatter.format(calendar.getTime()) +
                ", \"delay\":" + delay + 
                '}';
    }
}