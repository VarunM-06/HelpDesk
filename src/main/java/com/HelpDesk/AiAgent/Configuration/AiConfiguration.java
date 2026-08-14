package com.HelpDesk.AiAgent.Configuration;

import org.slf4j.Logger;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.model.chat.client.autoconfigure.ChatClientBuilderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AiConfiguration {
    private Logger logger = org.slf4j.LoggerFactory.getLogger(AiConfiguration.class);
    @Bean
    public ChatClient client(ChatClient.Builder builder, ChatMemory chatMemory){
        logger. info("ChatClient bean created.");
        logger. info("chat memory bean created. {}", chatMemory.getClass().getName()) ;
        return builder
                .defaultAdvisors(new SimpleLoggerAdvisor( ), MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultSystem("you should not include * or ** in response")
                .defaultSystem("do provide response in 400 word ")
                .build();
    }
}