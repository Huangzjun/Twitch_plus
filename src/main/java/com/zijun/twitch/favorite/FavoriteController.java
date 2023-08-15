package com.zijun.twitch.favorite;


import com.zijun.twitch.db.entity.UserEntity;
import com.zijun.twitch.model.DuplicateFavoriteException;
import com.zijun.twitch.model.FavoriteRequestBody;
import com.zijun.twitch.model.TypeGroupedItemList;
import com.zijun.twitch.user.UserService;
import com.zijun.twitch.favorite.FavoriteService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/favorite")
public class FavoriteController {


    private final FavoriteService favoriteService;
    private final UserService userService;


    public FavoriteController(FavoriteService favoriteService,
                              UserService userService) {
        this.favoriteService = favoriteService;
        this.userService = userService;
    }


    @GetMapping
    public TypeGroupedItemList getFavoriteItems(@AuthenticationPrincipal User user) {
        UserEntity userEntity = userService.findByUsername(user.getUsername());
        return favoriteService.getGroupedFavoriteItems(userEntity);
    }


    @PostMapping
    public void setFavoriteItem(@AuthenticationPrincipal User user, @RequestBody FavoriteRequestBody body) {
        UserEntity userEntity = userService.findByUsername(user.getUsername());
        try {
            favoriteService.setFavoriteItem(userEntity, body.favorite());
        } catch (DuplicateFavoriteException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Duplicate entry for favorite record", e);
        }
    }


    @DeleteMapping
    public void unsetFavoriteItem(@AuthenticationPrincipal User user, @RequestBody FavoriteRequestBody body) {
        UserEntity userEntity = userService.findByUsername(user.getUsername());
        favoriteService.unsetFavoriteItem(userEntity, body.favorite().twitchId());
    }
}
