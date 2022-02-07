package test;

import de.carne.nio.file.FileUtil;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.ClassNamePatternFilterUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import  org.apache.commons.io.FileUtils;

public class payrollEmployeeTest {
     private static String HOME=System.getProperty("user.home");
     private  static String fileName="Play";
     @Test
     public void pathCheckedExistOrNot() throws IOException {
         //Check File exist
         Path path=Paths.get(HOME);
         Assert.assertTrue(Files.exists(path));

         //Delete file and check file not exist
         Path playPath=Paths.get(HOME+"/"+fileName);
         if(Files.exists(playPath)) {
             System.out.println(playPath);
             FileUtils.fileDelete(String.valueOf(playPath.toFile()));
             Assert.assertTrue(Files.notExists(playPath));
         }
         //Create Directory
         Files.createDirectories(playPath);
         Assert.assertTrue(Files.exists(playPath));

         //Create File
         IntStream.range(1,10).forEach(value->{
             Path tempFile=Paths.get(playPath+"/temp"+value+".txt");
             Assert.assertTrue(Files.notExists(tempFile));
             try
             {
                 Files.createFile(tempFile);
             }catch (Exception e)
             {
                 e.printStackTrace();
             }
         });

//         Display the all File
//         Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
         Files.newDirectoryStream(playPath).forEach(System.out::println);
         Files.newDirectoryStream(playPath,path1 ->path1.toFile().isFile() &&
                 path1.toString().startsWith("temp")).forEach(System.out::println);
     }


}
