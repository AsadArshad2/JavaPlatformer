package game.bodies;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class Platform extends StaticBody {
    // this is for creating the platforms
    // since i want the platforms to all be the same size the dimensions will be final and static
    private static final float  boxW = 6;
    private static final float boxH = 1;
    private static final BoxShape platShape = new BoxShape(boxW/2,boxH/2);

    public Platform(float x, float y, World world){
        // in super only adding world because we don't want to specify the shape yet since we haven't added images
        // specifying the shape in super will make an image-less platform ar x0,y0
        super(world);
        // make the body and link the shape
        StaticBody ground = new StaticBody(world, platShape);
        // make and add the image for the platform
        BodyImage platImage =
                new BodyImage("data/pngwing.com.png",boxH*7);
        ground.addImage(platImage);
        // finally, set the position
        ground.setPosition(new Vec2(x,y));
        // DEBUGGING
        // ground.setAlwaysOutline(true);








    }

}
