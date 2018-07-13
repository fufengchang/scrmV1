package com.vance.scrm.util;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MsgSender {
	private static MessageProducer producer; 
	private static TextMessage message;
	
	static {
		try {
			ConnectionFactory factory = new ActiveMQConnectionFactory("failover://tcp://localhost:61616");
			Connection conn = factory.createConnection();
			Session session = conn.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			Queue  queue = session.createQueue("vance-queue");
			producer = session.createProducer(queue);
			conn.start();
			message = session.createTextMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendMsg(String msg) {
		try {
			message.setText(msg);
			producer.send(message);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}	
}
