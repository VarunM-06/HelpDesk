package com.HelpDesk.AiAgent.Controller;

import com.HelpDesk.AiAgent.Service.AiService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import org.springframework.beans.factory.annotation.Value;
import jakarta.annotation.PostConstruct;


@RestController
@RequestMapping("/api/v1/helpdesk")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class Controller {


    private  final AiService service;

    @PostMapping
    public ResponseEntity<String >  getResponse(@RequestBody  String query, @RequestHeader("ConversationId") String conversationId){
        return ResponseEntity.ok(service.getResponseFromAssistant(query,conversationId));
    }


    @PostMapping(value = "/stream")
    public Flux<String> streamResponse(@RequestBody  String query, @RequestHeader("ConversationId") String conversationId){
        return this.service.streamResponseFromAssistant(query,conversationId) ;
    }


    @Value("${OPENROUTER_API_KEY:NOT_FOUND}")
    private String key;

    @PostConstruct
    public void testKey() {
        System.out.println("OPENROUTER_API_KEY = " + key);
    }



}
