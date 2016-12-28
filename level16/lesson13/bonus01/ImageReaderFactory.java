package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by nemchinov on 02.11.2016.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes imageType) {
        if (ImageTypes.BMP.equals(imageType))
            return new BmpReader();
        else if (ImageTypes.JPG.equals(imageType))
            return new JpgReader();
        else if (ImageTypes.PNG.equals(imageType))
            return new PngReader();
        else
        {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
