package com.Pluralsight;
 // ALL THESE ARE IMPORTED SO I CAN USE
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner; // imported so I can use my scanner

public class Main {
    public static void main(String[] args) {


        ScreenManager screenManager = new ScreenManager();

        screenManager.homeScreen();
    }
}

