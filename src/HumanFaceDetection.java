package com.humanFD;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;



public class Main {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    public static void main(String[] args) {


        String imagePath = "images/faces1.jpg";
        Mat source = Imgcodecs.imread(imagePath);

        String xmlFile = "xml/lbpcascade_frontalface.xml";
        CascadeClassifier clsf = new CascadeClassifier(xmlFile);

        MatOfRect faceDetection = new MatOfRect();

         clsf.detectMultiScale(source,faceDetection);

        System.out.println("Detected faces : " + faceDetection.toArray().length);

        for(Rect rect : faceDetection.toArray())
        {

            Imgproc.rectangle(source,
                    new Point(rect.x,rect.y),
                    new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0,0,255),
                    3
            );

        }
        Imgcodecs.imwrite("images/faces1-out.png",source);

    }


}
