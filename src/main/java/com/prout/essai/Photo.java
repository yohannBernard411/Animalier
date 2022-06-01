package com.prout.essai;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Photo {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  private String small_url;
  private String big_url;
  private String animal;
  private Double latitude;
  private Double longitude;
  private Integer width;
  private Integer height;
  private String model_device;
  private Double aperture;
  private Double num_expo;
  private Integer denom_expo;
  private Integer iso;
  private Double focale;
  
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSmall_url() {
		return small_url;
	}
	public void setSmall_url(String small_url) {
		this.small_url = small_url;
	}
	public String getBig_url() {
		return big_url;
	}
	public void setBig_url(String big_url) {
		this.big_url = big_url;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getModel_device() {
		return model_device;
	}
	public void setModel_device(String model_device) {
		this.model_device = model_device;
	}
	public Double getAperture() {
		return aperture;
	}
	public void setAperture(Double aperture) {
		this.aperture = aperture;
	}
	public Double getNum_expo() {
		return num_expo;
	}
	public void setNum_expo(Double num_expo) {
		this.num_expo = num_expo;
	}
	public Integer getDenom_expo() {
		return denom_expo;
	}
	public void setDenom_expo(Integer denom_expo) {
		this.denom_expo = denom_expo;
	}
	public Integer getIso() {
		return iso;
	}
	public void setIso(Integer iso) {
		this.iso = iso;
	}
	public Double getFocale() {
		return focale;
	}
	public void setFocale(Double focale) {
		this.focale = focale;
	}

}
