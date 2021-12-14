package com.t.cocaspatna.ui.faculty;

public class TeacherData {
    private String TeacherName, Teacheremail, Teacherpost , Teacherimage, key;


    public TeacherData(String teacherName, String teacheremail, String teacherpost, String teacherimage, String key) {
        TeacherName = teacherName;
        Teacheremail = teacheremail;
        Teacherpost = teacherpost;
        Teacherimage = teacherimage;
        this.key = key;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public String getTeacheremail() {
        return Teacheremail;
    }

    public void setTeacheremail(String teacheremail) {
        Teacheremail = teacheremail;
    }

    public String getTeacherpost() {
        return Teacherpost;
    }

    public void setTeacherpost(String teacherpost) {
        Teacherpost = teacherpost;
    }

    public String getTeacherimage() {
        return Teacherimage;
    }

    public void setTeacherimage(String teacherimage) {
        Teacherimage = teacherimage;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
