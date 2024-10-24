package enums;

public enum StatusInscricaoEnum {
    DEFERIDA("Deferida"),
    INDEFERIDA("Indeferida"),
    EMPROCESSAMENTO("Aguardando processamento");

    private String value;

    private StatusInscricaoEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}