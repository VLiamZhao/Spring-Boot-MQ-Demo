package com.ccgg.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Publisher {
    public static void main(String[] args) {
        ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        try {
            Connection connection = factory.createConnection();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createTopic("Demo-Topic");

            MessageProducer producer = session.createProducer(destination);

            TextMessage textMessage = session.createTextMessage("Message for Topic");

            producer.send(textMessage);

            System.out.println("Message published to topic");

            session.close();

            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
