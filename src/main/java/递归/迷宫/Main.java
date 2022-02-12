package 递归.迷宫;

public class Main {
    public static void main(String[] args) {
        //创建一个二维数组，模拟迷宫
        int[][] map = new int[8][7];
        //使用1表示墙面
        //将上下全部置为一
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }//
        for (int i = 1; i < 7; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2] = 1;
//        map[2][2] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        //使用递归回溯来给小球找路
        findway(map,1,1);
        System.out.println("~~~~~~~~");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param map
     * @param i（1，1）
     * @param j
     * i，j表示从哪个位置开始
     * 如果能到（6,5）位置则说明通路找到
     * @return  如果找到通路就返回true
     * map[i][j] = 0,表示没有走的路， = 1表示墙， = 2表示通路，3表示该点已经走过，此路不通！
     * */
    public static boolean findway(int[][] map,int i,int j){
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){//该点还没有走过
                map[i][j] = 2;//假定该点可以走通
                if (findway(map, i-1, j)){//向下走
                    return true;
                }else if (findway(map, i, j+1)){//向右走
                    return true;
                }else if (findway(map, i+1, j)){//向上走
                    return true;
                }else if (findway(map, i, j-1)){
                    return true;
                }else {//说明该点是死路
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}

