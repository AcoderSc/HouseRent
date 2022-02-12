package 房屋出租系统.view;

import 房屋出租系统.domain.House;
import 房屋出租系统.service.HouseService;
import 房屋出租系统.utils.Utility;

public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private final HouseService houseService = new HouseService(2);

    public void listHouses() {
        System.out.println("======房 屋 列 表=====");
        System.out.println("编号\t\t房主\t\t\t号码\t\t\t\t地址\t\t\t租金\t\t\t状态");
        House[] houses = houseService.lsit();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;//如果为空就不显示
            }
            System.out.println(houses[i].toString());
        }
        System.out.println("======显 示 完 毕=====");
    }

    public void addHouses() {
        //用户输入：
        System.out.println("=======添加房屋=======");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(5);
        House newHouse = new House(0, name, phone, address, rent, state);
        if (houseService.add(newHouse)) {
            System.out.println("房屋信息添加成功！");
        } else {
            System.out.println("房屋信息添加失败");
        }
    }

    public void deleteHouse() {
        System.out.println("=======删除房屋=======");
        System.out.print("请输入要删除的房屋编号（-1退出）：");
        int houseID = Utility.readInt();
        if (houseID == -1) {
            System.out.println("放弃删除");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.delete(houseID)) {
                System.out.println("删 除 成 功！");
            } else {
                System.out.println("删除的房屋编号不存在，删除失败");
            }
        } else {
            System.out.println("放弃删除");
            return;
        }
    }

    public void findHouse() {
        System.out.println("查找房屋信息");
        System.out.println("请输入你要查找的房屋Id");
        int HouseID = Utility.readInt();
        House findhouse = houseService.findById(HouseID);
        if (findhouse == null) {
            System.out.println("未查找到房屋信息");
        } else {
            System.out.println(findhouse.toString());
        }
    }

    public void updateHouse() {
        System.out.println("修改房屋信息");
        System.out.println("请输入要修改的房屋编号(-1表示退出)：");
        int houseID = Utility.readInt();
        if (houseID == -1) {
            System.out.println("放 弃 修 改");
            return;
        }
        //根据houseID查找对象
        House updatedHouse = houseService.findById(houseID);
        if (updatedHouse == null) {
            System.out.println("要修改的房屋编号不存在");
            return;
        }
        System.out.print("姓名（" + updatedHouse.getName() + ")：");
        String name = Utility.readString(5, "");//默认是空
        if (!"".equals(name)) {//是空的数组的话就不修改
            updatedHouse.setName(name);
        }
        System.out.print("电话（" + updatedHouse.getPhone() + ")：");
        String phone = Utility.readString(12, "");//默认是空
        if (!"".equals(phone)) {//是空的数组的话就不修改
            updatedHouse.setPhone(phone);
        }
        System.out.print("地址（" + updatedHouse.getAddress() + ")：");
        String address = Utility.readString(20, "");//默认是空
        if (!"".equals(address)) {//是空的数组的话就不修改
            updatedHouse.setAddress(address);
        }
        System.out.print("租金（" + updatedHouse.getRent() + ")：");
        int rent = Utility.readInt(-1);//默认是空
        if (!"".equals(rent)) {//是空的数组的话就不修改
            updatedHouse.setRent(rent);
        }
        System.out.print("状态（" + updatedHouse.getState() + ")：");
        String state = Utility.readString(5, "");//默认是空
        if (!"".equals(state)) {//是空的数组的话就不修改
            updatedHouse.setState(state);
        }

    }

    public void exit() {
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {//退出时进行一波确认！
            loop = false;
        }
    }

    public void mainMenu() {
        do {
            System.out.println("=======房屋出租系统==========");
            System.out.println("\t\t1 新 增 房 源");
            System.out.println("\t\t2 查 找 房 屋");
            System.out.println("\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t5 房 屋 列 表");
            System.out.println("\t\t6 退 出");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    System.out.println("增 加");
                    addHouses();
                    break;
                case '2':
                    System.out.println("查 询");
                    findHouse();
                    break;
                case '3':
                    System.out.println("删 除");
                    deleteHouse();
                    break;
                case '4':
                    System.out.println("修 改");
                    updateHouse();
                    break;
                case '5':
                    System.out.println("房 屋 列 表");
                    listHouses();
                    break;
                case '6':
                    System.out.println("退 出");
                    exit();
                    break;
            }
        } while (loop);
    }
}
