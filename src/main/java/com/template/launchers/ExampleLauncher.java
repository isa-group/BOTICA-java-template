package com.template.launchers;

import java.util.Properties;

import org.json.JSONObject;

import es.us.lsi.botica.launchers.AbstractLauncher;

public class ExampleLauncher extends AbstractLauncher{

    public ExampleLauncher(String keyToPublish, String orderToPublish, Properties botProperties) {
        super(keyToPublish, orderToPublish, botProperties);
    }

    @Override
    protected void botAction() {
        System.out.println("Hello world!");
    }

    @Override
    protected JSONObject createMessage() {

        JSONObject message = new JSONObject();
        //message.put(property, value);
        return message;
    }

    @Override
    protected boolean shutdownCondition() {
        return true;
    }
}
