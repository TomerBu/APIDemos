
package com.example.tomerbuzaglo.apidemos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Notes {

    @SerializedName("notes")
    @Expose
    private List<Note> notes = new ArrayList<Note>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Notes() {
    }

    @Override
    public String toString() {
        return "Notes{" +
                "notes=" + notes +
                '}';
    }

    /**
     * 
     * @param notes
     */
    public Notes(List<Note> notes) {
        this.notes = notes;
    }

    /**
     * 
     * @return
     *     The notes
     */
    public List<Note> getNotes() {
        return notes;
    }

    /**
     * 
     * @param notes
     *     The notes
     */
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }


}
