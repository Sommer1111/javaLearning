package cn.code.day4_1_shape.test1_employee;

/**
 * @Auther:sommer1111
 * @date 2020/4/3 10:08
 */

//这里直接在泛型中就贴入泛型标签，后面就可以一气呵成
public class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }


    @Override
    //这里直接用泛型，传入参数
    public int compareTo(MyDate myDate) {
        //这里已经默认传入的数据一定是MyDate类的。所以立马省略了判断的过程
        //1.比较出生年的大小
        int minyear = this.getYear()-myDate.getYear();
        if(minyear !=0){
            return minyear;
        }
        //2.出生年相同则继续判断，不需要嵌套，容易导致错误；
        int minmonth = this.getMonth()-myDate.getMonth();
        if(minmonth !=0){
            return minmonth;
        }
        return this.getDay()-myDate.getDay();
    }
}
