package com.cts.empower.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.empower.dto.FavouriteRequest;
import com.cts.empower.dto.FavouriteResponse;

@FeignClient(name="FavouriteService",url="http://localhost:8083/api/v1/favourite")
public interface FavouriteClient {
@PostMapping("/addfavourite/{email}")
	FavouriteResponse favouriteSkill(@PathVariable String email,@RequestBody FavouriteRequest request);
}
