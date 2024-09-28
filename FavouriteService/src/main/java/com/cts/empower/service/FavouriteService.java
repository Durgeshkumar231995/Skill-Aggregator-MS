package com.cts.empower.service;

import com.cts.empower.dto.FavouriteRequest;
import com.cts.empower.dto.FavouriteResponse;

public interface FavouriteService {
	public FavouriteResponse addToFavourite(String email, FavouriteRequest request);
}
