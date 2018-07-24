package com.edit.viberBot.controller;


import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.viber.bot.Request;
import com.viber.bot.ViberSignatureValidator;
import com.viber.bot.api.ViberBot;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

@RestController
public class ViberBotController {

    @Inject
    private ViberBot viberBot;

    @Inject
    private ViberSignatureValidator viberSignatureValidator;

    @PostMapping(value = "/", produces = "application/json")
    public String incoming(@RequestBody String json,
                           @RequestHeader("X-Viber-Content-Signature") String serverSideSignature)
            throws ExecutionException, InterruptedException, IOException {
        com.google.common.base.Preconditions.checkState(viberSignatureValidator.isSignatureValid(serverSideSignature, json), "invalid signature");
        @Nullable InputStream response = viberBot.incoming(Request.fromJsonString(json)).get();
        return response != null ? CharStreams.toString(new InputStreamReader(response, Charsets.UTF_16)) : null;
    }
}
