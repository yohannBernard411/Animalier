package com.prout.essai.repository;

import org.springframework.data.repository.CrudRepository;

import com.prout.essai.models.Photo;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {

}
