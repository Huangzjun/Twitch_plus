package com.zijun.twitch.external.model;


import com.zijun.twitch.external.model.Game;

import java.util.List;


public record GameResponse(
        List<Game> data
) {
}
