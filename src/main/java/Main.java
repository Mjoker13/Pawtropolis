import lombok.extern.java.Log;
import org.Domain.*;

@Log
public class Main {
    public static void main(String[] args) {

        ZooController zooController= new ZooController();
        for (var a: zooController.getAnimals().values()) {
            log.info(a.toString());
        }

        log.info("The TALLEST tiger is: " + zooController.getHighestAnimalByClass(Tiger.class).getName() + " and its height is: " + zooController.getHighestAnimalByClass(Tiger.class).getHeight() + " cm");
        log.info("The SHORTEST tiger is: " + zooController.getShortestAnimalByClass(Tiger.class).getName() + " and its height is: " + zooController.getShortestAnimalByClass(Tiger.class).getHeight() + " cm");
        log.info("The HEAVIEST tiger is: " + zooController.getHeaviestAnimalByClass(Tiger.class).getName() + " and its weight is: " + zooController.getHeaviestAnimalByClass(Tiger.class).getWeight() + " kg");
        log.info("The LIGHTEST tiger is:" + zooController.getLightestAnimalByClass(Tiger.class).getName() + " and its weight is: " + zooController.getLightestAnimalByClass(Tiger.class).getWeight() + " kg");
        log.info("-----------------------------------------------------");
        log.info("The TALLEST lion is: " + zooController.getHighestAnimalByClass(Lion.class).getName() + " and its height is: " + zooController.getHighestAnimalByClass(Lion.class).getHeight()+ " cm");
        log.info("The SHORTEST lion is: " + zooController.getShortestAnimalByClass(Lion.class).getName() + " and its height is: " + zooController.getShortestAnimalByClass(Lion.class).getHeight()+ " cm");
        log.info("The HEAVIEST lion is: " + zooController.getHeaviestAnimalByClass(Lion.class).getName() + " and its weight is: " + zooController.getHeaviestAnimalByClass(Lion.class).getWeight()+ " kg");
        log.info("The LIGHTEST lion is: " + zooController.getLightestAnimalByClass(Lion.class).getName() + " and its weight is: " + zooController.getLightestAnimalByClass(Lion.class).getWeight()+ " kg");
        log.info("-----------------------------------------------------");
        log.info("The TALLEST eagle is: " + zooController.getHighestAnimalByClass(Eagle.class).getName() + " and its height is: " + zooController.getHighestAnimalByClass(Eagle.class).getHeight()+ " cm");
        log.info("The SHORTEST eagle is: " + zooController.getShortestAnimalByClass(Eagle.class).getName() + " and its height is: " + zooController.getShortestAnimalByClass(Eagle.class).getHeight()+ " cm");
        log.info("The HEAVIEST eagle is: " + zooController.getHeaviestAnimalByClass(Eagle.class).getName() + " and its weight is: " + zooController.getHeaviestAnimalByClass(Eagle.class).getWeight()+ " kg");
        log.info("The LIGHTEST eagle is: " + zooController.getLightestAnimalByClass(Eagle.class).getName() + " and its weight is: " + zooController.getLightestAnimalByClass(Eagle.class).getWeight()+ " kg");
        log.info("-----------------------------------------------------");
        log.info("The animal with longest tail is: " + zooController.getLongestTail().getName() + " and its tail is :" + zooController.getLongestTail().getTailLength()+ " cm");
        log.info("-----------------------------------------------------");
        log.info("The animal with greater wingspan is: " + zooController.getWidestWingspan().getName() + " and its tail is :" + zooController.getWidestWingspan().getWingspan()+ " cm");
    }
}