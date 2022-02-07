package MusicPlayer;

/**
 * Interface Player
 * @Description Interface that contains the music player's methods
 * @author luis.pineda
 * @date 05-02-2022
 * @version 1.1
 */

public interface Player {
    /**
     * chooseColor
     * @Description Method that allows to pick the music player's color
     * @date 05-02-2022
     * @return void
     */
    public void chooseColor(int color);

    /**
     * getColor
     * @Description Method that returns the color value
     * @date 05-02-2022
     * @return int
     */
    public int getColor();

    /**
     * chooseCapacity
     * @Description Method that allows to pick the music player's drive capacity
     * @date 05-02-2022
     * @return void
     */
    public void chooseCapacity(int capacity);

    /**
     * getCapacity
     * @Description Method that returns the capacity value
     * @date 05-02-2022
     * @return int
     */
    public int getCapacity();

    /**
     * chooseBattery
     * @Description Method that allows to pick the music player's battery capacity
     * @date 05-02-2022
     * @return void
     */
    public void chooseBattery(int battery);

    /**
     * getBattery
     * @Description Method that returns the battery value
     * @date 05-02-2022
     * @return int
     */
    public int getBattery();

    /**
     * getConfiguration
     * @Description Method that returns the final device configuration selected by user
     * @date 05-02-2022
     * @return String
     */
    public String getConfiguration();
}
