package 房屋出租系统.service;

import 房屋出租系统.domain.House;

public class HouseService {
    private House[] houses;//存放house对象
    private int houseNums = 1;//记录当前有多少个房屋
    private int idCounter = 1;//记录当前的id自增长增长到哪个数值

    public HouseService(int size) {
        houses = new House[size];
        //为配合测试使用！
        houses[0] = new House(1, "王小刚", "12345678", "南阳市", 12000, "已租出");
    }

    public boolean add(House newHouse) {
        if (houseNums == houses.length) {//不能再添加房屋
            System.out.println("数组已满，不能再添加房屋信息");
            return false;
        }
        //将newHouse添加到houses[]中
        houses[houseNums] = newHouse;
        houseNums++;
        idCounter++;
        newHouse.setId(idCounter);//更新newHouse的id
        return true;
    }

    public boolean delete(int houseId) {
        //先找到要删除的房屋信息对应的数组下标
        //房屋的编号和下标的区别；
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if (houseId == houses[i].getId()) {
                index = i;
            }
        }
        if (index == -1) {
            return false;//表示没找到！
        }
        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i+1];//将后边的元素向前挪
        }
        houseNums --;
        houses[houseNums] = null;//将最后一个置为空；
        return true;
    }

    public House findById(int houseId){
        for (int i = 0; i < houseNums; i++) {
            if (houseId == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }
    //返回house列表
    public House[] lsit() {
        return houses;
    }
}
