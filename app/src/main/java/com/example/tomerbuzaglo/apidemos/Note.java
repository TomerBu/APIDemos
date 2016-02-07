
package com.example.tomerbuzaglo.apidemos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Note {

    @SerializedName("note")
    @Expose
    private String note;
    @SerializedName("title")
    @Expose
    private String title;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Note() {
    }

    /**
     * 
     * @param title
     * @param note
     */
    public Note(String note, String title) {
        this.note = note;
        this.title = title;
    }

    /**
     * 
     * @return
     *     The note
     */
    public String getNote() {
        return note;
    }

    /**
     * 
     * @param note
     *     The note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Note{" +
                "note='" + note + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
