public class Demo {
    public static void main(String[] args) {
        // 字符串拼接
        String str1 = "a";
        String str2 = "b";
        String str3 = str1 + str2;

        // int 加减乘除
        int i1 = 1;
        i1 = i1 + 1;
        i1 = i1 - 1;
        i1 = i1 * 2;
        i1 = i1 / 2;

        // double 加减乘除
        double d1 = 0.2;
        d1 = d1 + 1.0;
        d1 = d1 - 1.0;
        d1 = d1 * 2.0;
        d1 = d1 / 2.0;

        // int 和 double 混合计算
        double d2 = 0.2;
        int i2 = 2;
        d2 = d2 + i2;

        // 循环累加
        int i4 = 0;
        for(int i3=0; i3 < 10; i3++) {
            i4 += 1;
        }

        // if 判断
        if (i4 < 5) {
            System.out.println("if true");
        } else {
            System.out.println("if false");
        }
    }
}