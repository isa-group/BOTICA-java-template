package com.template.main;

import com.botica.utils.bot.BotDefinitionTemplate;

public class GenerateBotTemplates {

    private static String template = "";
    private static String outputPath = "src/main/java/com/template/bots/bots-definition.json";

    public static void main(String[] args) {

        if (args.length > 0) {
            template = args[0];
        }

        if (args.length > 1) {
            outputPath = args[1];
        }

        BotDefinitionTemplate.generateTemplate(template, outputPath);

    }
}
