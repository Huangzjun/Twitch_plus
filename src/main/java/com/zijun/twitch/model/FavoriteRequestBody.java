package com.zijun.twitch.model;


import com.zijun.twitch.db.entity.ItemEntity;


public record FavoriteRequestBody(
        ItemEntity favorite
) {}
