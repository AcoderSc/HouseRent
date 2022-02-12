package 房屋出租系统;

import 房屋出租系统.view.HouseView;

/**
 * @author 森
 */
public class App {
    public static void main(String[] args) {
        //在此处创建主菜单  view对象
        new HouseView().mainMenu();
        System.out.println("您已退出系统，欢迎下次登陆！");
    }
}
