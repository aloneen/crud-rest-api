package org.seisen.crudrestapi.repository;


import org.seisen.crudrestapi.entity.ItemEntity;
import org.seisen.crudrestapi.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<ItemEntity, Long> {
}
