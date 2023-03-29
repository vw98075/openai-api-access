package com.example.messagingstompwebsocketopenai;

import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.ChatCompletionResponse;
import com.unfbx.chatgpt.entity.chat.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Controller
public class GreetingController {

    @Value("${openAI.apiKey}")
    private String apiKey   ;

    // Define a regular expression pattern to match the content value
    private static Pattern pattern = Pattern.compile("content=(.*?)\\)");

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {

        return new Greeting(HtmlUtils.htmlEscape(takeMessage(message.getName())));
    }

    private String takeMessage(String msg) {

        OpenAiClient openAiClient = OpenAiClient.builder()
            .apiKey(Arrays.asList(apiKey))
            .build();

        Message message = Message
            .builder()
            .role(Message.Role.USER)
            .content(msg)
            .build();
        ChatCompletion chatCompletion = ChatCompletion
            .builder()
            .messages(Arrays.asList(message))
            .build();
        ChatCompletionResponse chatCompletionResponse = openAiClient.chatCompletion(chatCompletion);
        List<String> responseMessages = new ArrayList<>();
        chatCompletionResponse.getChoices().forEach(e -> {
            responseMessages.add(e.getMessage().toString());
        });

        Matcher matcher = pattern.matcher(responseMessages.stream().collect(Collectors.joining()));
        String content = "";
        if (matcher.find()) {
            // Extract the content value from the matched substring
            content = matcher.group(1);
        }

        return content;
    }

}
