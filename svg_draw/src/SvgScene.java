import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SvgScene {
    private List<Shape> shapes = new ArrayList<>();
    public void add(Shape polygon){
        shapes.add(polygon);
    }

    private static SvgScene instance = null;



    public static SvgScene getInstance(){
        if(instance == null){
            instance = new SvgScene();
        }
        return instance;
    }

    List<String> defs = new ArrayList<>();

    public void addDef(String def){
        defs.add(def);
    }

    public void saveHtml(String path){
        try {
            FileWriter fw = new FileWriter(path);
            fw.write("<html> <body> <svg width=\"1000\" height=\"1000\">\n");
            for(var polygon : shapes){
                fw.write(polygon.toSvg("")+"\n");
            }
            fw.write("</svg>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
