package 继承;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Pc pc = new Pc("32",22,"联想");
        System.out.println(pc.detail());

    }
}
class Computer{
    private String cpu;
    private int disk;

    public Computer(String cpu, int disk) {
        this.cpu = cpu;
        this.disk = disk;
    }
    public Computer() {
    }

    public String detail() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", disk=" + disk +
                '}';
    }
}
class Pc extends Computer{
    private String brand;
    public Pc(String cpu, int disk, String brand) {
        super(cpu, disk);
        this.brand = brand;
    }
    public void pcInfo(){
        System.out.println();
    }
}