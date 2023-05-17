package com.wanja727.kgjguide.service;

import com.wanja727.kgjguide.config.auth.dto.SessionUser;
import com.wanja727.kgjguide.entity.Bookmark;
import com.wanja727.kgjguide.entity.Cafe;
import com.wanja727.kgjguide.entity.Users;
import com.wanja727.kgjguide.repository.BookmarkRepository;
import com.wanja727.kgjguide.repository.CafeRepository;
import com.wanja727.kgjguide.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final CafeRepository cafeRepository;
    private final UsersRepository usersRepository;


    public Long register(String cafeId, SessionUser user) {

        Cafe cafe = cafeRepository.findById(cafeId).orElseThrow(EntityNotFoundException::new);
//        Users users = usersRepository.findByEmail("wanja727@gmail.com").orElseThrow(EntityNotFoundException::new);
        Users users = usersRepository.findById(user.getUserId()).orElseThrow(EntityNotFoundException::new);;

        Bookmark bookmark = Bookmark.builder()
                .user(users)
                .cafe(cafe)
                .build();

        Bookmark saved = bookmarkRepository.save(bookmark);

        return saved.getBookmarkId();
    }
}
