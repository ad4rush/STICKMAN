package com.example.finale;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class startMainGameTest {

    @Test
    public void get_count_tester(){
        int fgg = Basic_functions.get_high_score();
        assert (fgg>=0);
    }

    @Test
    public void get_gem_tester(){
        startMainGame st = new startMainGame(new Pane());
        int fg = st.base.get_Cherry_count();
        assert (fg>=0);
    }

    @Test
    public void main_pane_not_null(){
        startMainGame st = new startMainGame(new Pane());
        int i = 0;
        for (Node node : st.main_pane.getChildren()) {
            i++;
        }
        assert(i==0);
    }

}