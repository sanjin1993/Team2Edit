package com.edit.viberBot.config;


import com.edit.viberBot.ViberBotApplication;
import com.edit.viberBot.service.ViberBotService;
import com.viber.bot.ViberSignatureValidator;
import com.viber.bot.api.ViberBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;


@Configuration
public class BotStartupConfig implements ApplicationListener<ApplicationReadyEvent> {

    @Inject
    private ViberBot viberBot;

    @Inject
    private ViberSignatureValidator signatureValidator;

    @Value("${application.viber-bot.webhook-url}")
    private String webhook;

      public static void main(String[] args) {

      ViberBotApplication.run(BotStartupConfig.class, args);
    }

    @Autowired
    private ViberBotService viberBotService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent appReadyEvent) {
        try {
            viberBot.setWebhook(webhook).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("PRORADI");
        viberBot.onMessageReceived((event, message, response) -> viberBotService.onMessageReceived(event, message, response)); // echos everything back
        viberBot.onConversationStarted(event -> viberBotService.onConversationStarted(event));
        viberBot.onSubscribe((event,response)->viberBotService.onSubscribe(event,response));
        viberBot.onUnsubscribe((event)->viberBotService.onUnsubscribe(event));
    }
}




