package enums;

public enum SituacaoMatriculaEnum {
    REGULAR("Regular"),
    FORMANDO("Formando");

    private String value;

    private SituacaoMatriculaEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}