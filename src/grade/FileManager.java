package grade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public FileManager(){};

    private final String studentFileName = "students.json";

    public void ReadStudentData(ArrayList<Student> students) {
        String jsonString = FileManager.readFile(studentFileName);
        if(jsonString.isEmpty()){
            return;
        }
        ArrayList<Student> newStudents = JSON.parseObject(jsonString, new TypeReference<ArrayList<Student>>(){});
        if (newStudents != null) {
            students.clear();
            students.addAll(newStudents);
        }
    }


    public void WriteStudentData(ArrayList<Student> students) {
        String jsonString = JSON.toJSONString(students, SerializerFeature.PrettyFormat);
        FileManager.writeFile(studentFileName, jsonString);
    }


    private static String readFile(String fileName){
        // Read data from fileName
        File file = new File("data/" + fileName);

        // If the file does not exist, return
        if (!file.exists()) {
            return "";
        }

        // Read the file and parse the data
        StringBuilder stringBuilder = new StringBuilder();
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
            fileReader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    private static void writeFile(String fileName, String jsonString){
        // Write data to fileName
        File file = new File("data/" + fileName);
        // If file does not exist, create a new file
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Write data to the file
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(jsonString);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
