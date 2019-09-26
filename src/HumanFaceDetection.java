import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;



public class HumanFaceDetection {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    public  static  void getDetectionImage(String imageRelativePath, String xmlFileRelativePath){



        Mat source = Imgcodecs.imread(imageRelativePath);
        CascadeClassifier clsf = new CascadeClassifier(xmlFileRelativePath);

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
        String exitName = getExitName(imageRelativePath);
        Imgcodecs.imwrite(exitName,source);

    }

    private  static  String getExitName(String path)
    {
        char[] chrs = path.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbPath = new StringBuilder();
        sb.append("faces-out/");

        int last = chrs.length - 5; // before the dot;
        while (chrs[last] != '/')
        {
           sbPath.append(chrs[last]);
           last--;
        }

        sb.append(sbPath.reverse() + "-out.png");
        return sb.toString();
    }


}
