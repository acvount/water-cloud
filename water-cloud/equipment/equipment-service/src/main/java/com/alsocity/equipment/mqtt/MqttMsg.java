package com.alsocity.equipment.mqtt;


import lombok.Data;

@Data
public class MqttMsg {
    private String name;
    private String content;
    private String time;
}
