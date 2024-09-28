package com.cts.empower.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.empower.dto.FavouriteResponse;
import com.cts.empower.model.Favouritemodel;
@Repository
public interface FavouriteRepository extends JpaRepository<Favouritemodel, Long> {

	List<Favouritemodel> findByEmail(String email);


}
