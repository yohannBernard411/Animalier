package com.prout.essai;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@CrossOrigin(origins = {"http://localhost:4200", "https://animalier.herokuapp.com"})
@RequestMapping(path="/photo")
public class MainController {
  @Autowired
  private PhotoRepository photoRepository;

  // ADD PHOTO
  @PostMapping(path="/add")
  public @ResponseBody String addNewPhoto (
	  @RequestParam Integer id,
	  @RequestParam String small_url,
	  @RequestParam String big_url,
	  @RequestParam String animal,
	  @RequestParam Double latitude,
	  @RequestParam Double longitude,
	  @RequestParam Integer width,
	  @RequestParam Integer height,
	  @RequestParam String model_device,
	  @RequestParam Double aperture,
	  @RequestParam Double num_expo,
	  @RequestParam Integer denom_expo,
	  @RequestParam Integer iso,
	  @RequestParam Double focale
      ) {

    Photo photo = new Photo();
    photo.setId(id);
    photo.setSmall_url(small_url);
    photo.setBig_url(big_url);
    photo.setAnimal(animal);
    photo.setLatitude(latitude);
    photo.setLongitude(longitude);
    photo.setWidth(width);
    photo.setHeight(height);
    photo.setModel_device(model_device);
    photo.setAperture(aperture);
    photo.setNum_expo(num_expo);
    photo.setDenom_expo(denom_expo);
    photo.setIso(iso);
    photo.setFocale(focale);
    photoRepository.save(photo);
    return " Photo saved";
  }

  //ALL PHOTOS
  @GetMapping(path="/all")
  public @ResponseBody Iterable<Photo> getAllPhotos() {
    return photoRepository.findAll();
  }

//READ ONE PHOTO
  @PostMapping(path="/one")
  public @ResponseBody Optional<Photo> getPhoto(@RequestParam Integer id) {
	  return photoRepository.findById(id);
  }
  
  //UPDATE PHOTO
  @PostMapping(path="/update")
  public @ResponseBody String updatePhoto(
		  @RequestParam Integer id,
		  @RequestParam String small_url,
		  @RequestParam String big_url,
		  @RequestParam String animal,
		  @RequestParam Double latitude,
		  @RequestParam Double longitude,
		  @RequestParam Integer width,
		  @RequestParam Integer height,
		  @RequestParam String model_device,
		  @RequestParam Double aperture,
		  @RequestParam Double num_expo,
		  @RequestParam Integer denom_expo,
		  @RequestParam Integer iso,
		  @RequestParam Double focale
		  ) {
	    Photo photo = new Photo();
	    photo.setId(id);
	    photo.setSmall_url(small_url);
	    photo.setBig_url(big_url);
	    photo.setAnimal(animal);
	    photo.setLatitude(latitude);
	    photo.setLongitude(longitude);
	    photo.setWidth(width);
	    photo.setHeight(height);
	    photo.setModel_device(model_device);
	    photo.setAperture(aperture);
	    photo.setNum_expo(num_expo);
	    photo.setDenom_expo(denom_expo);
	    photo.setIso(iso);
	    photo.setFocale(focale);
	    photoRepository.save(photo);
	    return "The photo is updated";
  }
  
  //DELETE PHOTO
  @PostMapping(path="/delete")
  public @ResponseBody String deletePhoto(@RequestParam Integer id) {
	  photoRepository.deleteById(id);
	  return "Photo is delete";
  }
}
