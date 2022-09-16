package com.alsocity.equipment.mqtt;

import com.alsocity.equipment.config.mqtt.MQTTClient;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

@Slf4j
public class Callback implements MqttCallback {

    private MQTTClient myMQTTClient;

    public Callback(MQTTClient myMQTTClient) {
        this.myMQTTClient = myMQTTClient;
    }

    /**
     * 丢失连接，可在这里做重连
     * 只会调用一次
     */
    @Override
    public void connectionLost(Throwable throwable) {
        log.error("mqtt connectionLost 连接断开，5S之后尝试重连: {}", throwable.getMessage());
        long reconnectTimes = 1;
        while (true) {
            try {
                if (MQTTClient.getClient().isConnected()) {
                    log.warn("mqtt reconnect success end");
                    return;
                }
                log.warn("mqtt reconnect times = {} try again...", reconnectTimes++);
                MQTTClient.getClient().reconnect();
            } catch (MqttException e) {
                log.error("", e);
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e1) {
            }
        }
    }

    /**
     * @throws Exception subscribe后得到的消息会执行到这里面
     */
    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        log.info("接收消息主题 : {}，接收消息内容 : {}", topic, new String(mqttMessage.getPayload()));
    }

    /**
     * publish后，配送完成后回调的方法
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        log.info("==========deliveryComplete={}==========", iMqttDeliveryToken.isComplete());
    }
}