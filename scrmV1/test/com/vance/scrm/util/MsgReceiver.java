package com.vance.scrm.util;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.vance.scrm.po.LoginStatus;
import com.vance.scrm.service.ILoginStatusService;
import com.vance.scrm.service.impl.LoginStatusServiceImpl;

public class MsgReceiver {

	public static void main(String[] args) throws JMSException {
		/**
		 * Queue
		 */
		ConnectionFactory factory = new ActiveMQConnectionFactory("failover://tcp://localhost:61616");
		Connection conn = factory.createConnection();
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue  queue = session.createQueue("vance-queue");
		MessageConsumer consumer = session.createConsumer(queue);
		conn.start();
		consumer.setMessageListener(new MessageListener() {
			public void onMessage(Message message) {
				TextMessage tm = (TextMessage)message;
				try {
					LoginStatus status = (LoginStatus)JsonUtil.jsonToObject(tm.getText(), LoginStatus.class);
					ILoginStatusService service = new LoginStatusServiceImpl();
					service.update(status);
//					System.out.println("The number2...." + tm.getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
