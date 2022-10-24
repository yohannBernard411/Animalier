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

import com.prout.essai.models.Materiel;
import com.prout.essai.repository.MaterielRepository;

@Controller
@CrossOrigin(origins = {"http://localhost:4200", "https://animalier.herokuapp.com", "http://localhost:8080"})
@RequestMapping(path="/materiel")
public class MaterielController {
	@Autowired
	  private MaterielRepository materielRepository;

	  // ADD MATERIEL
	  @PostMapping(path="/add")
	  public @ResponseBody String addNewMateriel (
		  @RequestParam Integer id,
		  @RequestParam String title,
		  @RequestParam Integer quantity,
		  @RequestParam String description,
		  @RequestParam String url
	      ) {
	    Materiel materiel = new Materiel();
	    materiel.setId(id);
	    materiel.setTitle(title);
	    materiel.setQuantity(quantity);
	    materiel.setDescription(description);
	    materiel.setUrl(url);
	    materielRepository.save(materiel);
	    return "Materiel saved";
	  }

	  //ALL MATERIELS
	  @GetMapping(path="/all")
	  public @ResponseBody Iterable<Materiel> getAllMateriels() {
	    return materielRepository.findAll();
	  }

	//READ ONE MATERIEL
	  @PostMapping(path="/one")
	  public @ResponseBody Optional<Materiel> getMateriel(@RequestParam Integer id) {
		  return materielRepository.findById(id);
	  }
	  
	  //UPDATE MATERIEL
	  @PostMapping(path="/update")
	  public @ResponseBody String updateMateriel(
			  @RequestParam Integer id,
			  @RequestParam String title,
			  @RequestParam Integer quantity,
			  @RequestParam String description,
			  @RequestParam String url
		      ) {
		    Materiel materiel = new Materiel();
		    materiel.setId(id);
		    materiel.setTitle(title);
		    materiel.setQuantity(quantity);
		    materiel.setDescription(description);
		    materiel.setUrl(url);
		    materielRepository.save(materiel);
		    return "The materiel is updated";
	  }
	  
	  //DELETE MTERIEL
	  @PostMapping(path="/delete")
	  public @ResponseBody String deleteMateriel(@RequestParam Integer id) {
		  materielRepository.deleteById(id);
		  return "Materiel is delete";
	  }
	}