package com.example.hackathonendava.ocr;

import org.bytedeco.javacpp.*;

import static org.bytedeco.javacpp.lept.*;
import static org.bytedeco.javacpp.tesseract.*;

public class ImageToText {

    static BytePointer resultText;
    static PIX image;
    public static String result;

    static TessBaseAPI api = new TessBaseAPI();

    public static BytePointer getResultText() {
        return resultText;
    }

    public static void setResultText(BytePointer resultText) {
        ImageToText.resultText = resultText;
    }

    public static PIX getImage() {
        return image;
    }

    public static void setImage(PIX image) {
        ImageToText.image = image;
    }

    public static void initializeTesseract() {

        if (api.Init(".", "ENG") != 0) {
            System.err.println("Could not initialize tesseract.");
        }
    }

    public static void loadImage(String path) {
        setImage(pixRead(path));
        api.SetImage(image);
    }

    public static void calculateText() {
        setResultText(api.GetUTF8Text());
        String string = getResultText().getString();
        result = string;
        System.out.println(string);
    }

    public static void cleanMemory() {
        api.End();
        resultText.deallocate();
        pixDestroy(image);
    }

    // THIS METHOD SHOULD BE REFERENCED IN DIGITAL NOTES PAGE

    public static String imageToText() {
        initializeTesseract();
        // loadImage should receive as argument the correct path
        // this is just an example
        loadImage("testImageToText.png");
        calculateText();
        cleanMemory();
        return result;
    }

    public static void main(String[] args) {
        imageToText();
    }
}
