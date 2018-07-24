package com.edit.viberBot.config;


import com.edit.viberBot.ViberBotApplication;
import com.google.common.util.concurrent.Futures;
import com.viber.bot.ViberSignatureValidator;
import com.viber.bot.api.ViberBot;
import com.viber.bot.message.TextMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Optional;


@RestController
public class BotStartupConfig implements ApplicationListener<ApplicationReadyEvent> {

    @Inject
    private ViberBot bot;

    @Inject
    private ViberSignatureValidator signatureValidator;

    @Value("${application.viber-bot.webhook-url}")
    private String webhookUrl;

    public static void main(String[] args) {
        ViberBotApplication.run(BotStartupConfig.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent appReadyEvent) {
        try {
            bot.setWebhook(webhookUrl).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        bot.onMessageReceived((event, message, response) -> response.send(message)); // echos everything back
        bot.onConversationStarted(event -> Futures.immediateFuture(Optional.of( // send 'Hi UserName' when conversation is started
                new TextMessage("Hi " + event.getUser().getName()))));
    }



}




