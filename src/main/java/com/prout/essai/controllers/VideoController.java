package com.prout.essai.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prout.essai.models.Video;
import com.prout.essai.repository.VideoRepository;

@Controller
@CrossOrigin(origins = {"http://localhost:4200", "https://animalier.herokuapp.com", "http://localhost:8080"})
@RequestMapping(path="/video")
public class VideoController {
	
	@Autowired
	  private VideoRepository videoRepository;

	 // ADD VIDEO
	  @PostMapping(path="/add")
	  public @ResponseBody String addNewVideo (
		  @RequestParam Integer id,
		  @RequestParam String title,
		  @RequestParam String url,
		  @RequestParam String description,
		  @RequestParam Double latitude,
		  @RequestParam Double longitude
	      ) {
	    Video video = new Video();
	    video.setId(id);
	    video.setTitle(title);
	    video.setUrl(url);
	    video.setDescription(description);
	    video.setLatitude(latitude);
	    video.setLongitude(longitude);
	    videoRepository.save(video);
	    return "Video saved";
	  }

	  //ALL VIDEOS
	  @GetMapping(path="/all")
	  public @ResponseBody Iterable<Video> getAllVideos() {
	    return videoRepository.findAll();
	  }

	//READ ONE VIDEO
	  @PostMapping(path="/one")
	  public @ResponseBody Optional<Video> getVideo(@RequestParam Integer id) {
		  return videoRepository.findById(id);
	  }
	  
	  //UPDATE VIDEO
	  @PostMapping(path="/update")
	  public @ResponseBody String updateVideo(
			  @RequestParam Integer id,
			  @RequestParam String title,
			  @RequestParam String url,
			  @RequestParam String description,
			  @RequestParam Double latitude,
			  @RequestParam Double longitude
			  ) {
		  Video video = new Video();
		    video.setId(id);
		    video.setTitle(title);
		    video.setUrl(url);
		    video.setDescription(description);
		    video.setLatitude(latitude);
		    video.setLongitude(longitude);
		    videoRepository.save(video);
		    return "Video updated";
	  }
	  
	  //DELETE VIDEO
	  @PostMapping(path="/delete")
	  public @ResponseBody String deleteVideo(@RequestParam Integer id) {
		  videoRepository.deleteById(id);
		  return "Video is delete";
	  }
	}