package ua.cluster.controller;

import ua.cluster.model.Note;
import ua.cluster.view.NoteView;

import java.util.ArrayList;
import java.util.Arrays;

public class NoteController {
    public NoteController() {
    }


    public static void ShortDate(ArrayList<Note> notes){
        int povtoriv = 0;
        boolean zmina = true;
        while(zmina){
            zmina = false;
            for(int i=0; i<notes.size()-1-povtoriv; i++){
                Note note = notes.get(i);
                Note note1 = notes.get(i+1);
                String label = note.getDate();
                String label1 = note1.getDate();
                String[] c = {label,label1};
                String[] c2 = {label,label1};
                Arrays.sort(c2);
                if(!c[0].equals(c2[0]) && !c[1].equals(c2[1])){
                    notes.remove(i);
                    notes.remove(+i);
                    notes.add(i,note1);
                    notes.add(1+i,note);
                    zmina = true;
                }
            }
            povtoriv ++;
        }
        show(notes);
    }


    public static void Short(ArrayList<Note> notes){
        int povtoriv = 0;
        boolean zmina = true;
        while(zmina){
            zmina = false;
            for(int i=0; i<notes.size()-1-povtoriv; i++){
                Note note = notes.get(i);
                Note note1 = notes.get(i+1);
                String label = note.getLabel();
                String label1 = note1.getLabel();
                String[] c = {label,label1};
                String[] c2 = {label,label1};
                Arrays.sort(c2);
                if(!c[0].equals(c2[0]) && !c[1].equals(c2[1])){
                    notes.remove(i);
                    notes.remove(+i);
                    notes.add(i,note1);
                    notes.add(1+i,note);
                    zmina = true;
                }
            }
            povtoriv ++;
        }
        show(notes);
    }
    public static void show(ArrayList<Note> arr){
        NoteView noteView = new NoteView();
        for(int i =0; i<arr.size();i++){
            Note notes = arr.get(i);
            noteView.printNote(notes);
        }

    }
}

