package View;

import java.util.ArrayList;

public enum InterfaceOptions {

    EXIT(0, "Exit program"),
    LOAD_ONE_MOVIE(1, "Load one movie JSON"),
    LOAD_TABLE_JSON(2, "Load movie from movie JSON table"),
    LOAD_XML_MOVIE(3, "Load movie from movie XML table"),
    FIND_BY_ACTOR(4, "Find by actor"),
    FIND_BY_GENRE(5, "Find by Genre"),
    FIND_BY_DATE_RANGE (6, "Find by date"),
    SHOW_ALL(8, "Print all movies"),
    BAD_COMMAND(101, "Bad Comand");

    private int value;
    private String description;

    InterfaceOptions(int value, String description){
        this.value = value;
        this.description = description;
    }

    public static InterfaceOptions createOption(int option){

        InterfaceOptions result = BAD_COMMAND;
        for (int i = 0; i < InterfaceOptions.values().length; i++){
            if ( option == InterfaceOptions.values()[i].value ) {
                result = InterfaceOptions.values()[i];
            }
        }
        //return InterfaceOptions.values()[option];
        return result;

    }

    @Override
    public String toString(){
        return value + " - " + description;
    }

    public String getName(){
        return name();
    }

}
