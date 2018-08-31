package com.maot.navigation.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.maot.navigation.util.SessionManager;

public class SeesionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent session) {
		SessionManager.addSession(session.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent session) {
		SessionManager.removeSession(session.getSession());
	}
	
}
