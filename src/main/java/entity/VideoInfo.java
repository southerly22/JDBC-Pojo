package entity;


import java.util.Date;

/**
 * 
 * @author lzx
 * @date 2023/01/15 19:50
 **/


public class VideoInfo {
    int id;
    int video_id;
    int author;
    String tag;
    int duration;
    Date release_time;

    public Date getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Date release_time) {
        this.release_time = release_time;
    }

    public VideoInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }



    @Override
    public String toString() {
        return "VideoInfo{" +
                "id=" + id +
                ", video_id=" + video_id +
                ", author=" + author +
                ", tag='" + tag + '\'' +
                ", duration=" + duration +
                ", release_time=" + release_time +
                '}';
    }
}
