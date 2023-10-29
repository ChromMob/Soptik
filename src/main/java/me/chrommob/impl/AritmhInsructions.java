package me.chrommob.impl;

import me.chrommob.instructions.Instruction;
import me.chrommob.instructions.InstructionType;

public class AritmhInsructions implements Instruction {
    private final String load;
    private final int loadInt;

    private final String add;
    private final int addInt;

    private final String write;
    private final int writeInt;
    private final InstructionType type;

    public AritmhInsructions(int load, int add, int write, InstructionType type) {
        if (Instruction.verifyReg(load) || Instruction.verifyReg(write)) {
            throw new IllegalArgumentException("Too high registry value " + load + " " + write);
        }

        this.type = type;

        this.load = Instruction.convertToFormattedHex(load, 4);
        this.loadInt = load;

        this.add = Instruction.convertToFormattedHex(add, 16);
        this.addInt = add;

        this.write = Instruction.convertToFormattedHex(write, 4);
        this.writeInt = write;
    }
    @Override
    public InstructionType getType() {
        return type;
    }

    @Override
    public String byteRepresentation() {
        return load + write + add;
    }

    @Override
    public String codeRepresentation() {
        String znamenko = type == InstructionType.ADD ? "+" : type == InstructionType.SUB ? "-" : type == InstructionType.MUL ? "*" : "";
        int writeIntTemp = writeInt;
        int loadIntTemp = loadInt;
        if (type == InstructionType.MOV) {
            writeIntTemp = loadInt;
            loadIntTemp = writeInt;
        }
        return "reg " + writeIntTemp + " " + znamenko + "= reg " + loadIntTemp + " + " + addInt;
    }
}
