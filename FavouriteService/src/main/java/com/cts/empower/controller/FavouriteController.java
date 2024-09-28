package com.cts.empower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.empower.Repository.FavouriteRepository;
import com.cts.empower.dto.FavouriteRequest;
import com.cts.empower.dto.FavouriteResponse;
import com.cts.empower.service.FavouriteServiceImpl;

@RestController
@RequestMapping("/api/v1/favourite")
public class FavouriteController {
	@Autowired
	FavouriteServiceImpl favouriteService;
	@Autowired
	private FavouriteRepository favouriteRepository;
	
	@PostMapping("/addfavourite/{email}")
	public FavouriteResponse createFavourite(@PathVariable String email,@RequestBody FavouriteRequest request) {
		System.out.println("=====================fsffs");
		return favouriteService.addToFavourite(email,request);
		
	}

	@GetMapping("/getFavourite/{email}")
	public FavouriteResponse[] getFavouriteByEmail(@PathVariable String email) {
		return favouriteService.getFavouriteByEmail(email);
	}

}
