package com.musicapp.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicapp.apirest.models.Music;

public interface MusicRepository extends JpaRepository<Music, Long> {
	
	Optional<Music> findById(Long id);
}
