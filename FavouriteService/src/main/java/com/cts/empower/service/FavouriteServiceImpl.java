package com.cts.empower.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.empower.Repository.FavouriteRepository;
import com.cts.empower.dto.FavouriteRequest;
import com.cts.empower.dto.FavouriteResponse;
import com.cts.empower.model.Favouritemodel;

@Service
public class FavouriteServiceImpl implements FavouriteService {
@Autowired
FavouriteRepository favouriteRepository;
@Autowired
private ModelMapper modelMapper;
	public FavouriteResponse addToFavourite(String email, FavouriteRequest request) {
		// TODO Auto-generated method stub
		request.setEmail(email);
		System.out.println("=================="+request);
		Favouritemodel model=modelMapper.map(request, Favouritemodel.class);
		System.out.println("==========model========"+model);

		Favouritemodel response= favouriteRepository.save(model);
		FavouriteResponse favouriteResponse=modelMapper.map(response, FavouriteResponse.class);
		System.out.println("==========favouriteResponse========"+favouriteResponse);

		return favouriteResponse;

	}
	public FavouriteResponse[] getFavouriteByEmail(String email) {
		// TODO Auto-generated method stub
		List<Favouritemodel> model= favouriteRepository.findByEmail(email);
		FavouriteResponse[] favouriteResponse=modelMapper.map(model, FavouriteResponse[].class);

		return favouriteResponse;
	}

}
