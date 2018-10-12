package Model;

public enum Genre {
    ACTION("action"),
    HORROR("horror"),
    SCIFI("sci-fi"),
    COMEDY("comedy"),
    UN("uncategorized");

    Genre(String value){
        _value = value;
    }

    private final String _value;
    public String getValue(){
        return _value;
    }


}
