package 枚举;

class Main{
    public static void main(String[] args) {
        Color color = Color.RED;
        color.show();
        switch (color){
            case GREEN:
                System.out.println("黄色");
                break;
            case BLUE:
                System.out.println("蓝色");
                break;
            case RED:
                System.out.println("红色");
                break;
            default:
                break;
        }
    }
}
interface shouwColor{
    public void show();
}
public enum Color implements shouwColor {
    GREEN(0,0,1),BLUE(2,2,8),RED(5,5,8);
    private double redValue;
    private double blueValue;
    private double greenValue;

    Color(double redValue, double blueValue, double greenValue) {
        this.redValue = redValue;
        this.blueValue = blueValue;
        this.greenValue = greenValue;
    }

    @Override
    public void show() {
        System.out.println("颜色属性值：（" + redValue +","+ blueValue +","+ greenValue +")");
    }
}
