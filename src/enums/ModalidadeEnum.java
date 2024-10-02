package enums;

public enum ModalidadeEnum {
    PRESENCIAL("Presencial"),
    REMOTO("Remoto"),
    SEMIPRESENCIAL("Semi-presencial");

    private String value;

    private ModalidadeEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
 }
