package MusicPlayer;

/**
 * Class Music Player
 * @Description Class that implements interface Player
 * @author luis.pineda
 * @date 05-02-2022
 * @version 1.0
 */

public class MusicPlayer implements Player{
    int uColor, uCapacity, uBattery = 0;

    /**
     * chooseColor
     *
     * @param color
     * @return void
     * @Description Method that allows to pick the music player's color
     * @date 05-02-2022
     */
    @Override
    public void chooseColor(int color) {
        this.uColor=color;
    }

    /**
     * getColor
     *
     * @return int
     * @Description Method that returns the color value
     * @date 05-02-2022
     */
    @Override
    public int getColor() {
        return this.uColor;
    }

    /**
     * chooseCapacity
     *
     * @param capacity
     * @return void
     * @Description Method that allows to pick the music player's drive capacity
     * @date 05-02-2022
     */
    @Override
    public void chooseCapacity(int capacity) {
        this.uCapacity=capacity;
    }

    /**
     * getCapacity
     *
     * @return int
     * @Description Method that returns the capacity value
     * @date 05-02-2022
     */
    @Override
    public int getCapacity() {
        return this.uCapacity;
    }

    /**
     * chooseBattery
     *
     * @param battery
     * @return void
     * @Description Method that allows to pick the music player's battery capacity
     * @date 05-02-2022
     */
    @Override
    public void chooseBattery(int battery) {
        this.uBattery=battery;
    }

    /**
     * getBattery
     *
     * @return int
     * @Description Method that returns the battery value
     * @date 05-02-2022
     */
    @Override
    public int getBattery() {
        return this.uBattery;
    }

    /**
     * getConfiguration
     *
     * @return String
     * @Description Method that returns the final device configuration selected by user
     * @date 05-02-2022
     */
    @Override
    public String getConfiguration() {
        String conf = "Your device configurations are: ";
        if(uColor==1)
        {
            conf+="Color Green";
        }
        else{
            conf+="Color Blue";
        }
        if(uCapacity==1)
        {
            conf+="-8GB";
        }
        else{
            conf+="-16GB";
        }
        if(uCapacity==1)
        {
            conf+="-5 Hours Battery";
        }
        else{
            conf+="-8 Hours Battery";
        }
        return conf;
    }
}