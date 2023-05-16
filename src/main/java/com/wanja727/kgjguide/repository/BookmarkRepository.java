package com.wanja727.kgjguide.repository;

import com.wanja727.kgjguide.entity.Bookmark;
import com.wanja727.kgjguide.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    List<Bookmark> findByUserUserId(Long userId);
}
