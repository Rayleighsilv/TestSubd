package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExecuteTaskBuffer {
    public static List<StructNameClass> taskBuffer () throws IOException {

        List<StructNameClass> processesDbStruct = new ArrayList<>();
        int counterCucle =0;

        try {
            String line;
            Pattern r = Pattern.compile("[0-9a-zA-Z.,]+");
            //Process p = Runtime.getRuntime().exec("tasklist.exe /nh");
            Process p = Runtime.getRuntime().exec
                    (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                if (!line.trim().equals("")) {
                    if (counterCucle >2) {
                        StructNameClass structNameClass = new StructNameClass();
                        String memUssage = null;
                        int counterm1 =0;
                        Matcher m1 = r.matcher(line);
                        while (m1.find()) {
                            switch (counterm1){
                                case (0):
                                    structNameClass.setImageName(m1.group());
                                    break;
                                case (1):
                                    structNameClass.setPID(m1.group());
                                    break;
                                case (2):
                                    structNameClass.setSessionNum(m1.group());
                                    break;
                                case (3):
                                    structNameClass.setSessionName(m1.group());
                                    break;
                                case (4):
                                    memUssage = m1.group();
                                    break;
                                case (5):
                                    memUssage = memUssage + m1.group();
                                    structNameClass.setMemUssage(memUssage);
                                    break;
                            }
                            counterm1++;
                        }
                        processesDbStruct.add(structNameClass);
                    }
                    counterCucle++;
                }
            }
            input.close();
        } catch (
                IOException err) {
            err.printStackTrace();
        }
        return processesDbStruct;
    }


}
