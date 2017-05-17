package cyberdemon.spacetravel;

/**
 * Created by rekrux on 12/05/2017.
 */

public class obj_ss {
    private String name;
    private long dts;

    public obj_ss(){}

    public obj_ss(String name, long dts){
        this.name = name;
        this.dts = dts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDts() {
        return dts;
    }

    public void setDts(long dts) {
        this.dts = dts;
    }
}
