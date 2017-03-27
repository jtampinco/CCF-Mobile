package ph.com.bilinear.ccf_mobile.data.vo;

import android.graphics.drawable.Drawable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jtampinco on 3/20/2017.
 */

public class Event {

    private String title;
    private Drawable thumbnail;
    private Drawable banner;
    private String location;
    private String date;
    private String time;
    private String content;
    private String person;
    private String number;
    private String email;
    private Date timestamp;

    public Event(String title, Drawable thumbnail, Drawable banner, String location, String date, String time, String content, String person, String number, String email){
        this.title = title;
        this.thumbnail = thumbnail;
        this.banner = banner;
        this.location = location;
        this.date = date;
        this.time = time;
        this.content = content;
        this.person = person;
        this.number = number;
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Drawable thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Drawable getBanner() {
        return banner;
    }

    public void setBanner(Drawable banner) {
        this.banner = banner;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTimestampMonth(){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM");
        return dateFormatter.format(new Date());
    }

    public String getTimestampDay(){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd");
        return dateFormatter.format(new Date());
    }

}
