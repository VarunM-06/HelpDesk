package com.HelpDesk.AiAgent.Tools;


import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class EmailTool {


    @Tool(description = "this tools helps to send the email to the support team regarding new ticket")
    public void sendingEmail(@ToolParam(description = "email id assosiate with the for the contact information") String email, @ToolParam(description = "this is the message to sent ") String message ){

        System.out.printf("sending message");
        System.out.println("emailid" + email);
        System.out.println("message"+ message );
    }
}
