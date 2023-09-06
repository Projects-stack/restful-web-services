package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

public class ErrorDetails
{
    private LocalDateTime timeStamp;
    private String message;
    private String description;

    public ErrorDetails(LocalDateTime timeStamp, String message, String description)
    {
        this.timeStamp = timeStamp;
        this.message = message;
        this.description = description;
    }

    public LocalDateTime getTimeStamp()
    {
        return timeStamp;
    }

    public String getMessage()
    {
        return message;
    }

    public String getDescription()
    {
        return description;
    }
}
