package Controller;

import Model.Movie;

import java.io.FileReader;

public class FileReceiver {

    private FileReader _file;

    public FileReceiver() {

    }

    public FileReader getFile(){
        return _file;
    }

    public void setFile(String filePath){
        try{
            _file = new FileReader(filePath);
        }catch (Exception e){
            System.out.println("Error MADAFAKA !!!!");
        }
    }

}
