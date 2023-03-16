import java.awt.*;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        Shape poly = new Polygon(new Vec2[]{new Vec2(120,60), new Vec2(270,280), new Vec2(240,320), new Vec2(110,80)});

        SvgScene scene=new SvgScene();
        //scene.add(poly);

        SolidFillShapeDecorator prost = new SolidFillShapeDecorator(poly,"red");

        Ellipse e = new Ellipse(new Vec2(50,50),30,60);
        SolidFillShapeDecorator elipsa = new SolidFillShapeDecorator(e,"gold");

        StrokeShapeDecorator ab = new StrokeShapeDecorator(e,"blue",10);

//        scene.add(elipsa);
//        scene.add(prost);
//        scene.add(ab);


        TransformationDecorator t = new TransformationDecorator.Builder().translate(new Vec2(500,10)).rotate(20,new Vec2(0,0)).scale(new Vec2(1,21)).build(e);

        scene.add(t);

        scene.saveHtml("scene.html");

    }
}
