package com.mapshop.modle;

/**
 * Created by cun.he on 2017/9/27.
 */

public class CourseBean {
    @Override
    public String toString() {
        return "CourseBean{" +
                "CoursePackID=" + CoursePackID +
                ", KnowledgeName='" + KnowledgeName + '\'' +
                ", CourseKnowledgeID='" + CourseKnowledgeID + '\'' +
                ", TextbookName='" + TextbookName + '\'' +
                ", UserID=" + UserID +
                ", TermID=" + TermID +
                ", CreatedDate='" + CreatedDate + '\'' +
                ", TermName='" + TermName + '\'' +
                ", Tthumbnail='" + Tthumbnail + '\'' +
                ", CourseID=" + CourseID +
                ", CourseName='" + CourseName + '\'' +
                ", Photo=" + Photo +
                ", ImgUrl='" + ImgUrl + '\'' +
                ", UserName='" + UserName + '\'' +
                '}';
    }

    /**
     * CoursePackID : 10
     * KnowledgeName : 保险学
     * CourseKnowledgeID : 17a65867-09f7-45c4-9d6a-b6e332d1c119
     * TextbookName : 保险学网页设计22
     * UserID : 152
     * TermID : 1
     * CreatedDate : 2017-08-13T14:29:56
     * TermName : 2015年上学期
     * Tthumbnail :
     * CourseID : 10
     * CourseName : 保险学网页设计22
     * Photo : null
     * ImgUrl : http://10.1.34.34:8081/UploadFile/thumbnail/b2b60836-28c1-1964-b07c-3f5db02275b6/投资理财.jpg
     * UserName : 教师一
     */
    public int CourseID;
    public String CourseKnowledgeID;



    public int CoursePackID;
    public String KnowledgeName;

    public String TextbookName;
    public int UserID;
    public int TermID;
    public String CreatedDate;
    public String TermName;
    public String Tthumbnail;

    public String CourseName;
    public Object Photo;
    public String ImgUrl;
    public String UserName;

    public int getCoursePackID() {
        return CoursePackID;
    }

    public void setCoursePackID(int CoursePackID) {
        this.CoursePackID = CoursePackID;
    }

    public String getKnowledgeName() {
        return KnowledgeName;
    }

    public void setKnowledgeName(String KnowledgeName) {
        this.KnowledgeName = KnowledgeName;
    }

    public String getCourseKnowledgeID() {
        return CourseKnowledgeID;
    }

    public void setCourseKnowledgeID(String CourseKnowledgeID) {
        this.CourseKnowledgeID = CourseKnowledgeID;
    }

    public String getTextbookName() {
        return TextbookName;
    }

    public void setTextbookName(String TextbookName) {
        this.TextbookName = TextbookName;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getTermID() {
        return TermID;
    }

    public void setTermID(int TermID) {
        this.TermID = TermID;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    public String getTermName() {
        return TermName;
    }

    public void setTermName(String TermName) {
        this.TermName = TermName;
    }

    public String getTthumbnail() {
        return Tthumbnail;
    }

    public void setTthumbnail(String Tthumbnail) {
        this.Tthumbnail = Tthumbnail;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public Object getPhoto() {
        return Photo;
    }

    public void setPhoto(Object Photo) {
        this.Photo = Photo;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String ImgUrl) {
        this.ImgUrl = ImgUrl;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
}
