package com.lesliehao.builder;

/**
 * @author HaoHao
 * @date 2018/11/12下午5:39
 */
public class A45AMG implements Car {

    private String chassis;

    private String tire;

    private String engine;

    private String gearbox;

    private String turbine;

    private String exhaust;

    public A45AMG() {
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getTire() {
        return tire;
    }

    public void setTire(String tire) {
        this.tire = tire;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getTurbine() {
        return turbine;
    }

    public void setTurbine(String turbine) {
        this.turbine = turbine;
    }

    public String getExhaust() {
        return exhaust;
    }

    public void setExhaust(String exhaust) {
        this.exhaust = exhaust;
    }

    @Override
    public String toString() {
        return "A45AMG{" +
                "chassis='" + chassis + '\'' +
                ", tire='" + tire + '\'' +
                ", engine='" + engine + '\'' +
                ", gearbox='" + gearbox + '\'' +
                ", turbine='" + turbine + '\'' +
                ", exhaust='" + exhaust + '\'' +
                '}';
    }

    @Override
    public void drive() {
        System.out.println("Benz A45 AMG,driving around~");
        System.out.println(toString());
    }
}
