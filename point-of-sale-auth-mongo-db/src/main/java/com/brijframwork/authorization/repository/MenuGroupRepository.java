package com.brijframwork.authorization.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframwork.authorization.model.menus.EOMenuGroup;

@Repository
@Transactional
public interface MenuGroupRepository  extends MongoRepository<EOMenuGroup, Long>{

	@Query(value="select * from MENU_GROUP UE where UE.TITLE = :title")
	Optional<EOMenuGroup> findByTitle(@Param("title")String title);
	
	@Query(value="select * from MENU_GROUP UE where UE.URL = :url")
	Optional<EOMenuGroup> findByUrl(@Param("url")String url);

	@Query(value="select * from MENU_GROUP UE where UE.TYPE = :type")
	List<EOMenuGroup> findAllByType(@Param("type")String type);

	@Query(value="select * from MENU_GROUP UE where UE.URL in (:urls)")
	List<EOMenuGroup> findByUrls(@Param("urls")List<String> urls);


}
