package org.example;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {

        List<StructNameClass> processesDbStruct = ExecuteTaskBuffer.taskBuffer();;


  /*      for (StructNameClass proc : processesDbStruct){
            System.out.println(proc.getImageName() + "   "+ proc.getPID()
                    + "   "+ proc.getSessionNum()
                    + "   "+ proc.getSessionName()
                    + "   "+ proc.getMemUssage());
        }*/


    }
}
