public class TransformationDecorator extends ShapeDecorator {

    public TransformationDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }
    private boolean translate;
    private Vec2 translateVector;

    private boolean rotate;
    private double rotateAngle;
    private Vec2 rotateCenter;

    private boolean scale;
    private Vec2 scaleVector;

    public String toSvg(String parameters){
        String result = "";
        if(translate)
            result += String.format( "translate(%f %f)\n",translateVector.x,translateVector.y);
        if(rotate)
            result += String.format("rotate(%f %f %f)\n",rotateAngle,rotateCenter.x,rotateCenter.y);
        if(scale)
            result += String.format("scale(%f %f)\n",scaleVector.x,scaleVector.y);

        result = String.format("transform=\"%s\"%s",result,parameters);

        return super.toSvg(result);

    }

    public static class Builder{
        private boolean translate=false;
        private Vec2 translateVector;

        private Shape shape;

        public TransformationDecorator build(Shape shape){
            TransformationDecorator result = new TransformationDecorator(shape);
            result.translate = translate;
            result.translateVector = translateVector;
            result. rotate = rotate;
            result.rotateAngle = rotateAngle;
            result.rotateCenter = rotateCenter;
            result.scale = scale;
            result.scaleVector = scaleVector;
            return result;
        }

        public Builder translate(Vec2 translateVector){
            translate = true;
            this.translateVector = translateVector;
            return this;
        }

        private boolean rotate=false;
        private double rotateAngle;
        private Vec2 rotateCenter;

        public Builder rotate(double rotateAngle, Vec2 rotateCenter){
            rotate=true;
            this.rotateAngle=rotateAngle;
            this.rotateCenter = rotateCenter;
            return this;
        }

        private boolean scale=false;
        private Vec2 scaleVector;

        public Builder scale(Vec2 scaleVector){
            scale = true;
            this.scaleVector = scaleVector;
            return this;
        }
    }





}
