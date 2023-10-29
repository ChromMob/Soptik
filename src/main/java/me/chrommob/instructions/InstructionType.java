package me.chrommob.instructions;

public enum InstructionType {
    NOP("69"),
    ADD("01"),
    SUB("02"),
    MUL("03"),
    LOAD("05"),
    STORE("06"),
    MOV("07"),
    JUMP("10"),
    REVJUMP("11"),
    LTJUMP("12"),
    REVLTJUMP("13"),
    NEQJUMP("14"),
    REVNEQJUMP("15"),
    SETIMMLOW("20"),
    SETIMMHIGH("21"),
    TELEPORT("42"),
    BOMB("50");
    private final String id;

    InstructionType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
