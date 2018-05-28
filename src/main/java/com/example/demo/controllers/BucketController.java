package com.example.demo.controllers;

import com.example.demo.models.Image;
import com.example.demo.repos.ImageRepository;
import com.example.demo.services.AmazonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/")
public class BucketController {

    private ImageRepository ir;
    private AmazonClient amazonClient;

    @Autowired
    BucketController(ImageRepository ir, AmazonClient amazonClient) {
        this.ir = ir;
        this.amazonClient = amazonClient;
    }

    @PostMapping("/uploadTourPicture")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file,
                             @RequestParam(name = "id", defaultValue = "-1") int id,
                             @RequestParam(name = "name", defaultValue = "no_name") String name) {

        String imageUrl = this.amazonClient.uploadFile(file);

        Image image = new Image(id, imageUrl, imageUrl);

        if(imageUrl.startsWith("ERROR")){
            return imageUrl;
        }else {
            image.setId(id);
            image.setS3link(imageUrl);
            ir.save(image);

            return imageUrl;
        }

    }

    @PostMapping("/uploadCityPicture")
    public String uploadCityPicture(@RequestPart(value = "file") MultipartFile file,
                                    @RequestParam(name = "id", defaultValue = "-1") int id,
                                    @RequestParam(name = "name", defaultValue = "no_name") String name) {

        String imageUrl = this.amazonClient.uploadCity(file);

        Image image = new Image(id, imageUrl, imageUrl);

        if(imageUrl.startsWith("ERROR")){
            return imageUrl;
        }else {
            image.setId(id);
            image.setS3link(imageUrl);
            ir.save(image);

            return imageUrl;
        }

    }

    @PostMapping("/uploadCountryPicture")
    public String uploadCountryPicture(@RequestPart(value = "file") MultipartFile file,
                                    @RequestParam(name = "id", defaultValue = "-1") int id,
                                    @RequestParam(name = "name", defaultValue = "no_name") String name) {

        String imageUrl = this.amazonClient.uploadCountry(file);

        Image image = new Image(id, imageUrl, imageUrl);

        if(imageUrl.startsWith("ERROR")){
            return imageUrl;
        }else {
            image.setId(id);
            image.setS3link(imageUrl);
            ir.save(image);

            return imageUrl;
        }

    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }
}