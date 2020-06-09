package cn.code.day4_1_shape.wordTest;

/**
 * @Auther:sommer1111
 * @date 2020/4/3 14:46
 */

import java.util.Objects;

/**封装一个新闻类News，
 * 包含新闻标题，新闻作者，新闻类型三个属性，
 * 提供必要的访问器和修改器方法，
 * 重写toString方法，要求打印对象时输出格式为“标题；类型；作者”，
 * 要求只要新闻标题相同就判断为同一条新闻。
 * */
public class News {

    private String title;
    private String auther;
    private String type;

    public News() {
    }

    public News(String title, String auther, String type) {
        this.title = title;
        this.auther = auther;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", auther='" + auther + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(title, news.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, auther, type);
    }


}
