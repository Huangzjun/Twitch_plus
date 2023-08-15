package com.zijun.twitch.external.model;


import com.zijun.twitch.external.model.Video;

import java.util.List;


public record VideoResponse(
        List<Video> data
) {
}
