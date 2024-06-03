package com.template.launchers;

import es.us.isa.botica.configuration.MainConfiguration;
import es.us.isa.botica.launchers.AbstractLauncher;
import org.json.JSONObject;

public class ExampleLauncher extends AbstractLauncher {

  public ExampleLauncher(MainConfiguration configuration) {
    super(configuration);
  }

  @Override
  protected void botAction() {
    System.out.println("Hello world!");
  }

  @Override
  protected JSONObject createMessage() {
    JSONObject message = new JSONObject();
    // message.put(property, value);
    return message;
  }

  @Override
  protected boolean shutdownCondition() {
    return true;
  }
}
