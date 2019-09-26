public class Main {

public static final String XML_PATH = "xml/lbpcascade_frontalface.xml" ;
    public static void main(String[] args) {

        for(int i = 1; i <= 11 ;i ++)
        {
            HumanFaceDetection.getDetectionImage("faces/f" + i +  ".jpg" , XML_PATH);

        }

    }
}
