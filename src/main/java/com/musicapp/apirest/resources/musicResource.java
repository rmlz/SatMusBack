package com.musicapp.apirest.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicapp.apirest.models.Music;
import com.musicapp.apirest.repository.MusicRepository;

@RestController
@RequestMapping(value="/api")
public class musicResource {

	@Autowired
	MusicRepository musicRepository;
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/musics")
	public List<Music> listMusic(){
		return musicRepository.findAll();
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/music/{id}")
	public Optional<Music> oneMusic(@PathVariable(value="id") Long id){
		return musicRepository.findById(id);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/music")
	public Music saveMusic(@RequestBody Music music) {
		return musicRepository.save(music);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@DeleteMapping("/music")
	public void deleteMusic(@RequestBody Music music) {
		musicRepository.delete(music);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/music")
	public Music updateMusic(@RequestBody Music music) {
		return musicRepository.save(music);
	}
	
}
