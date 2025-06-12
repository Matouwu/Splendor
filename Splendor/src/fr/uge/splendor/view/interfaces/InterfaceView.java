package fr.uge.splendor.view.interfaces;

import com.github.forax.zen.Application;

import java.awt.Color;

public class InterfaceView {
    public static void main(String[] args) {
        Application.run(Color.DARK_GRAY, context -> {

            // get the screen info
            var screenInfo = context.getScreenInfo();
            var width = screenInfo.width();
            var height = screenInfo.height();
    }
}
