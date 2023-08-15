package com.zijun.twitch.item;


import com.zijun.twitch.model.TypeGroupedItemList;
import com.zijun.twitch.external.TwitchService;
import com.zijun.twitch.external.model.Clip;
import com.zijun.twitch.external.model.Stream;
import com.zijun.twitch.external.model.Video;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ItemService {


    private static final int SEARCH_RESULT_SIZE = 20;


    private final TwitchService twitchService;


    public ItemService(TwitchService twitchService) {
        this.twitchService = twitchService;
    }


    public TypeGroupedItemList getItems(String gameId) {
        List<Video> videos = twitchService.getVideos(gameId, SEARCH_RESULT_SIZE);
        List<Clip> clips = twitchService.getClips(gameId, SEARCH_RESULT_SIZE);
        List<Stream> streams = twitchService.getStreams(List.of(gameId), SEARCH_RESULT_SIZE);
        return new TypeGroupedItemList(gameId, streams, videos, clips);
    }
}


