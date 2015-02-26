package br.mdarte.exemplo.academico.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
   
   static final int BUFFER = 2048;
   
   File output = null;
   List<File> inputFiles = null;
   
   public Zip (File output, List<File> inputFiles) {
	   this.output = output;
	   this.inputFiles = inputFiles;
   }
   
   public void process(boolean apagar){
      try {
         BufferedInputStream origin = null;
         
         FileOutputStream dest = new FileOutputStream(output.getPath());
         ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
         
         byte data[] = new byte[BUFFER];

         for (int i=0; i< inputFiles.size(); i++) {
            FileInputStream fi = new FileInputStream(((File)inputFiles.get(i)).getPath());
            origin = new BufferedInputStream(fi, BUFFER);
            ZipEntry entry = new ZipEntry(((File)inputFiles.get(i)).getName());
            out.putNextEntry(entry);
            int count;
            while((count = origin.read(data, 0, BUFFER)) != -1) {
               out.write(data, 0, count);
            }
            
            origin.close();
            
            if(apagar){
            	java.io.FileWriter outWriter = new FileWriter ((File)inputFiles.get(i));
            	((File)inputFiles.get(i)).delete();
            	outWriter.close();
            }
         }
         
         out.close();
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
}

