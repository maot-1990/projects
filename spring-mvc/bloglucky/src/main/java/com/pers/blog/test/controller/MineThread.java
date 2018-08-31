package com.pers.blog.test.controller;

public class MineThread implements Runnable {

	@Override
	public void run() {
		try {
			int i = 0;
			while (true) {
				Thread.sleep(100);
				System.out.println("MineDaemonThread线程已执行 " + (i++) + "次");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
