package com.deng.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@RestController
@RequestMapping(value = "/image")
public class ImageController {

    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
    @RequestMapping(value = "/get/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public BufferedImage getImage(@PathVariable("imageName") String imageName) throws IOException {

        if (!imageName.endsWith(".jpg")){
            imageName = imageName + ".jpg";
        }
        logger.info("imageName::" + imageName);

        URL resource = ImageController.class.getClassLoader().getResource("images/" + imageName );

        assert resource != null;
        return ImageIO.read(resource.openStream());
    }

}
