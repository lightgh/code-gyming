package com.chinakalight.miscellaneous;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 7/10/2020
 */
public class ImageTransformationSample {
    public static void main(String[] args) {
        System.out.println("This is A Print");
//        10-Jul-2020 13:37:32.274 WARNING [pool-4-thread-1]
//        org.mongodb.morphia.query.QueryValidator.validateQuery
//        The type(s) for the query/update may be inconsistent;
//        using an instance of type 'java.lang.String' for the
//        field 'model.Enumerator.statusChangedBy' which is declared
//        as 'constant.StatusChangedSourceConstant'

        try {
//            String externalUrl = "http://fileservice.byteworks.com.ng/api/v1/clients/BW_CAREERS/files/5c9ca4eb58678a11d6feaaf3";
            String externalUrl = "http://fileservice.byteworks.com.ng/api/v1/clients/BW_CAREERS/files/5c9ca56a58678a11d6fead32";

            URL url = new URL(externalUrl);
            BufferedImage imageRetrieved = ImageIO.read(url);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(imageRetrieved, "JPG", byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byte[] imageInByte = byteArrayOutputStream.toByteArray();

            for (byte eachBy: imageInByte
                 ) {
                System.out.print(eachBy);
            }

            System.out.println("This is A Print");
        }catch (Exception exception){
            exception.printStackTrace();
        }

    }
}
