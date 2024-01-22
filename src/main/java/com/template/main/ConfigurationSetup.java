package com.template.main;

import com.botica.runners.ConfigurationLoader;
import com.botica.utils.configuration.CreateConfiguration;

public class ConfigurationSetup {

    private static String configurationPropertiesFilePath = "src/main/resources/BOTICAConfig/configuration-setup.properties";

    public static void main(String[] args) {

        if (args.length == 1) {
            configurationPropertiesFilePath = args[0];
        }

        ConfigurationLoader configurationLoader = new ConfigurationLoader(configurationPropertiesFilePath, true);

        String botsDefinitionPath = configurationLoader.getBotsDefinitionPath();
        String botsPropertiesPath = configurationLoader.getBotsPropertiesPath();
        String rabbitMQExchange = configurationLoader.getRabbitMQExchange();
        String rabbitMQConfigurationPath = configurationLoader.getRabbitMQConfigurationPath();
        String rabbitMQPortsConfigurationPath = configurationLoader.getRabbitMQPortsConfigurationPath();
        String rabbitMQConnectionPath = configurationLoader.getRabbitMQConnectionPath();
        String rabbitMQUsername = configurationLoader.getRabbitMQUsername();
        String rabbitMQPassword = configurationLoader.getRabbitMQPassword();
        String rabbitMQHost = configurationLoader.getRabbitMQHost();
        Integer rabbitMQAMQPPort = configurationLoader.getRabbitMQAMQPPort();
        Integer rabbitMQUIPort = configurationLoader.getRabbitMQUIPort();
        String dockerComposePath = configurationLoader.getDockerComposePath();
        String dummyDockerfilePath = configurationLoader.getDummyDockerfilePath();
        String boticaDockerfilePath = configurationLoader.getBoticaDockerfilePath();
        String jarFileName = configurationLoader.getJarFileName();
        String unixInitVolumeScriptPath = configurationLoader.getUnixInitVolumeScriptPath();
        String windowsInitVolumeScriptPath = configurationLoader.getWindowsInitVolumeScriptPath();
        String unixMainLaunchScript = configurationLoader.getUnixMainLaunchScript();
        String windowsMainLaunchScript = configurationLoader.getWindowsMainLaunchScript();

        String boticaImageName = configurationLoader.getBoticaImageName();

        CreateConfiguration.createBotPropertiesFiles(botsDefinitionPath, botsPropertiesPath);
        CreateConfiguration.createRabbitMQConfigFile(rabbitMQExchange, rabbitMQConfigurationPath);
        CreateConfiguration.createRabbitMQPortsConfigurationFile(rabbitMQPortsConfigurationPath, rabbitMQAMQPPort, rabbitMQUIPort);
        CreateConfiguration.createRabbitMQConnectionFile(rabbitMQConnectionPath, rabbitMQUsername, rabbitMQPassword, rabbitMQHost, rabbitMQAMQPPort, rabbitMQExchange);
        CreateConfiguration.createDockerCompose(dockerComposePath, rabbitMQPortsConfigurationPath, rabbitMQConfigurationPath, rabbitMQAMQPPort, rabbitMQUIPort);
        CreateConfiguration.createDummyDockerfile(dummyDockerfilePath);
        CreateConfiguration.createBoticaDockerfile(boticaDockerfilePath, jarFileName);
        CreateConfiguration.createUnixInitVolumeScript(unixInitVolumeScriptPath);
        CreateConfiguration.createWindowsInitVolumeScript(windowsInitVolumeScriptPath);
        CreateConfiguration.createUnixMainScript(unixMainLaunchScript, dummyDockerfilePath, unixInitVolumeScriptPath, dockerComposePath, boticaDockerfilePath, boticaImageName);
        CreateConfiguration.createWindowsMainScript(windowsMainLaunchScript, dummyDockerfilePath, windowsInitVolumeScriptPath, dockerComposePath, boticaDockerfilePath, boticaImageName);
    }
}
