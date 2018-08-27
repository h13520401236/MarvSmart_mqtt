package com.imstlife.marvsmart_mqtt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.qcloud.iot.common.Status;
import com.qcloud.iot.other.MQTTOperate;

import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MainActivity extends AppCompatActivity implements MQTTOperate.MQTTRecDataListener {

    private MQTTOperate mqttHandler;

    /**
     * 产品ID
     */
    private static final String PRODUCT_ID = "1WHKWZ0YWD";

    /**
     * 设备名称
     */
    public static final String DEVICE_NAME = "DEVICE1";


    /**
     * 密钥
     */
    private static final String SECRET_KEY = "ipHeg9Ty+EGuRce2vQYuBg==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mqttHandler = MQTTOperate.getMQTTHandler(this, PRODUCT_ID, DEVICE_NAME, SECRET_KEY);
        mqttHandler.setMQTTListener(this);
    }

    public void connect(View view) {
        mqttHandler.mqttConnect();
    }

    public void sub(View view) {
        mqttHandler.mqttSubscribeTopic("custom_data");
    }

    @Override
    public void onConnectCompleted(Status status, boolean reconnect, Object userContext, String msg) {

    }

    @Override
    public void onConnectionLost(Throwable cause) {

    }

    @Override
    public void onDisconnectCompleted(Status status, Object userContext, String msg) {

    }

    @Override
    public void onPublishCompleted(Status status, IMqttToken token, Object userContext, String errMsg) {

    }

    @Override
    public void onSubscribeCompleted(Status status, IMqttToken asyncActionToken, Object userContext, String errMsg) {

    }

    @Override
    public void onMessageReceived(String topic, MqttMessage message) {
        Log.e("recData", "onMessageReceived: topic = " + topic + ", message = " + message.toString());
    }
}
