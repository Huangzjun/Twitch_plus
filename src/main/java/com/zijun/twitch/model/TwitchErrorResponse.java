package com.zijun.twitch.model;


public record TwitchErrorResponse(
        String message,
        String error,
        String details
) {
}
