package com.mycompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mycompany.data.Gallery;
@RestController
public class GalleryController {
	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/{id}")

	public Gallery createGallery(@PathVariable Long id)
	{
		Gallery gallery=new Gallery();
		gallery.setGalleryId(1L);
		List<Object> list=restTemplate.getForObject("http://image-service/images/", List.class);
		gallery.setImages(list);
		return gallery;
	}
}
