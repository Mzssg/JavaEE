package model;

public class addhomeworkmodel {
    private String homeworkname;
    private String homework;
    private String teachername;
    public addhomeworkmodel(String homeworkname, String homework,String teachername){
        this.homeworkname=homeworkname;
        this.homework=homework;
        this.teachername=teachername;
    }
    public String gethomeworkname() {
        return homeworkname;
    }

    public void sethomeworkname(String Homeworkname) {
        homeworkname = Homeworkname;
    }

    public String gethomework() {
        return homework;
    }

    public void sethomework(String Homework) {
        homework = Homework;
    }

    public String getteachername() {
        return teachername;
    }

    public void setteachername(String Teachername) {
        teachername = Teachername;
    }
}
