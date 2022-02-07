package MusicPlayer;
/**
 * Class Fabric
 * @Description Class that construct a music player with the users requirements
 * @author luis.pineda
 * @date 05-02-2022
 * @version 1.1
 */

public class Fabric {
    public static Player build(int color, int capacity, int battery){
        return new MusicPlayer();
    }
}