package com.demo.test.mq;

import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.CMQC;
import com.ibm.mq.constants.MQConstants;

public class MQSubscriber {

	public static void main(String[] args) {
		try {
			int openOptions = CMQC.MQOO_INQUIRE | CMQC.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_OUTPUT;
			MQEnvironment.hostname = "localhost";
			MQEnvironment.port = 1414;
			MQEnvironment.channel = "SYSTEM.DEF.SVRCONN";
			MQEnvironment.properties.put(CMQC.USER_ID_PROPERTY, "rajanp");
			MQEnvironment.properties.put(CMQC.PASSWORD_PROPERTY, "Sep@2019");
			MQEnvironment.properties.put(CMQC.TRANSPORT_PROPERTY, CMQC.TRANSPORT_MQSERIES);
			MQQueueManager qMgr;
			qMgr = new MQQueueManager("TEST");
			MQQueue destQueue = qMgr.accessQueue("TEST", openOptions);
			MQGetMessageOptions gmo = new MQGetMessageOptions();
			MQMessage message = new MQMessage();
			destQueue.get(message, gmo);
			 byte[] b = new byte[message.getMessageLength()];
             message.readFully(b);
			String msg = new String(b);
			System.out.println("the message received is " + msg);
			destQueue.close();
			qMgr.disconnect();
			System.out.println("------------------------success...");
		} catch (Exception e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
		}
	}

}
