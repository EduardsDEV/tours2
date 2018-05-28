package com.example.demo.repos;

import com.example.demo.models.Image;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by edwar on 5/16/2018.
 */
public interface ImageRepository extends CrudRepository<Image, Integer> {
    public Image findImageById(int id);
}