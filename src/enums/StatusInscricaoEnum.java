package enums;

public enum StatusInscricaoEnum {
    APROVADO("Aprovado"),
    CANCELADO("Cancelado");

    private String value;

    private StatusInscricaoEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}