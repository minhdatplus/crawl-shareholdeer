package com.example.crawl.repository;

import com.example.crawl.repository.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, K extends Serializable> extends JpaRepository<T, K> {

}
